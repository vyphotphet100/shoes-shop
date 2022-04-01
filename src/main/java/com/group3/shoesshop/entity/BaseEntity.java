package com.group3.shoesshop.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.LazyInitializationException;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.http.HttpStatus;

import javax.persistence.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static javax.persistence.TemporalType.TIMESTAMP;

@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity<D> {
    @Column(name = "created_by")
    @CreatedBy
    private String createdBy;

    @Column(name = "created_date")
    @CreatedDate
    @Temporal(TIMESTAMP)
    private Date createdDate;

    @Column(name = "modified_by")
    @LastModifiedBy
    private String modifiedBy;

    @Column(name = "modified_date")
    @LastModifiedDate
    @Temporal(TIMESTAMP)
    private Date modifiedDate;

    @Column(name = "added_data", columnDefinition = "LONGTEXT")
    private String addedData;

    public void setAddedData(String data) throws Exception {
        if (data != null)
            throw new Exception("Cannot set added data through this way. Please transfer a hash map instead.");
    }

    public void setAddedData(HashMap<String, Object> data){
        this.addedData = data.toString();
    }

    public HashMap<String, Object> getAddedData() {
        if (this.addedData == null || this.addedData.length() == 2)
            return null;
        String value = this.addedData.substring(1, this.addedData.length()-1);
        String[] keyValuePairs = value.split(",");
        HashMap<String,Object> hashMap = new HashMap<String, Object>();

        for(String pair : keyValuePairs)
        {
            String[] entry = pair.split("=");
            hashMap.put(entry[0].trim(), entry[1].trim());
        }

        return hashMap;
    }

    public Object getValueInAddedData(String key) {
        HashMap<String, Object> hashMap = this.getAddedData();
        return hashMap.get(key);
    }

    public void setValueInAddedData(String key, Object value) {
        HashMap<String, Object> hashMap = this.getAddedData();
        hashMap.put(key, value);
        this.setAddedData(hashMap);
    }

    public void removeFieldInAddedData(String key) {
        HashMap<String, Object> hashMap = this.getAddedData();
        hashMap.remove(key);
        this.setAddedData(hashMap);
    }


    @Transient
    private String message;

    @Transient
    private HttpStatus httpStatus = HttpStatus.OK;

    @Transient
    private HashMap<String, Object> listRequest = new HashMap<>();

    @Transient
    private HashMap<String, Object> listResult = new HashMap<>();

    public D toLaziness() {
        for (java.lang.reflect.Field field : this.getClass().getDeclaredFields()) {
            if (field.getType().getName().contains("List")) {
                String fieldName = field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
                List<Object> resIds = new ArrayList<>();
                try {
                    Method method = this.getClass().getMethod("get" + fieldName);
                    try {
                        for (Object o : (List) method.invoke(this)) {
                            HashMap<String, Object> obj = new HashMap<>();
                            if (((BaseEntity) o).getId() != null)
                                obj.put("id", ((BaseEntity) o).getId());
                            else
                                obj.put("code", ((BaseEntity) o).getCode());
                            resIds.add(obj);
                        }

                    } catch (LazyInitializationException lazyEx) {
                        lazyEx.printStackTrace();
                    }

                    this.getClass().getMethod("set" + fieldName, List.class).invoke(this, resIds);

                } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                    e.printStackTrace();
                    continue;
                }
            }
            else if (field.getType().getName().contains("Entity")) {
                String fieldName = field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
                List<Object> resIds = new ArrayList<>();
                try {
                    Class<?> className = field.getType();
                    Method method = this.getClass().getMethod("set" + fieldName, className.asSubclass(BaseEntity.class));
                    method.invoke(this, ((BaseEntity)this.getClass().getMethod("get" + fieldName).invoke(this)).toLaziness());

                } catch (Exception e) {
//                    e.printStackTrace();
                    continue;
                }
            }
        }

        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String, Object> hashMap = objectMapper.convertValue(this, HashMap.class);
        return (D) objectMapper.convertValue(hashMap, this.getClass());
    }

    // Two these fields (id, code) is in order to serve toLaziness function
    @Transient
    private Integer id;

    @Transient
    private String code;

}
