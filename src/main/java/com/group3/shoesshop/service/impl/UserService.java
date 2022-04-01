package com.group3.shoesshop.service.impl;

import com.group3.shoesshop.entity.OrderItemEntity;
import com.group3.shoesshop.entity.PaymentEntity;
import com.group3.shoesshop.entity.ProductEntity;
import com.group3.shoesshop.entity.UserEntity;
import com.group3.shoesshop.repository.OrderItemRepository;
import com.group3.shoesshop.repository.ProductRepository;
import com.group3.shoesshop.repository.UserRepository;
import com.group3.shoesshop.service.IPaymentService;
import com.group3.shoesshop.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService extends BaseService<UserEntity> implements IUserService {
    public enum IsActiveMode {
        TRUE,
        FALSE,
        BOTH
    }

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private OrderItemRepository orderItemRepo;

    @Autowired
    private IPaymentService paymentService;

    @Override
    public List<UserEntity> findAll() {
        return null;
    }

    @Override
    public UserEntity save(UserEntity entity) {
        UserEntity userEntity = userRepo.findByUsername(entity.getUsername());
        if (userEntity != null)
            return this.exceptionObject(new UserEntity(), "This username exists.");

        entity.setIsActive(true);
        entity = userRepo.save(entity);
        entity.setMessage("Register account successfully.");
        return entity;
    }

    @Override
    public UserEntity update(UserEntity entity) {
        UserEntity userEntity = userRepo.findById(entity.getId()).orElse(null);
        if (userEntity == null)
            return this.exceptionObject(new UserEntity(), "This user id does not exist.");

        // format birthday
        if (userEntity.getBirthday() != null) {
            userEntity.getBirthday().setYear(entity.getBirthday().getYear());
            userEntity.getBirthday().setMonth(entity.getBirthday().getMonth());
            userEntity.getBirthday().setDate(entity.getBirthday().getDate());
            entity.setBirthday(null);
        }

        BeanUtils.copyProperties(entity, userEntity, getNullPropertyNames(entity));

        userRepo.save(userEntity);
        userEntity = userRepo.findByUsernameAndPassword(userEntity.getUsername(), userEntity.getPassword());
        userEntity.setMessage("Update information successfully.");
        return userEntity;
    }

    @Override
    public UserEntity findOneByIsActiveAndId(Boolean isActive, Integer id) {
        UserEntity userEntity = userRepo.findById(id).orElse(null);
        if (userEntity == null || userEntity.getIsActive() == false)
            return this.exceptionObject(new UserEntity(), "This user id does not exist.");

        return userEntity;
    }

    @Override
    public UserEntity delete(Integer id) {
        UserEntity userEntity = userRepo.findById(id).orElse(null);
        if (userEntity == null)
            return this.exceptionObject(new UserEntity(), "This user does not exist");

        userEntity.setIsActive(false);
        userEntity = this.update(userEntity);
        userEntity.setMessage("Delete user successfully");
        return userEntity;
    }

    @Override
    public UserEntity findByUsernameAndPassword(String username, String password) {
        UserEntity userEntity = userRepo.findByUsernameAndPassword(username, password);

        if (userEntity == null)
            return this.exceptionObject(new UserEntity(), "Invalid username or password.");

        userEntity.setMessage("Log in successfully.");
        return userEntity;
    }

    @Override
    public List<UserEntity> findAllSellerByIsActive(Boolean isActive) {
        return userRepo.findAllByIsActiveAndRoleCode(isActive, "SELLER");
    }

    @Override
    public List<UserEntity> findAllSellerByKeyword(String keyword) {
        return userRepo.findAllSellerByKeyword(keyword);
    }

    @Override
    public List<UserEntity> findAllBuyerByIsActive(Boolean isActive) {
        return userRepo.findAllByIsActiveAndRoleCode(isActive, "BUYER");
    }

    @Override
    public List<UserEntity> findAllBuyerByIsActiveAndKeyword(Boolean isAvailable, String keyword) {
//        List<UserEntity> res = new ArrayList<>();
//        for (String subKey: keyword.split(" ")) {
//            List<UserEntity> userEntities = userRepo.findAllBuyerByKeyword(subKey);
//            for (UserEntity userEntity: userEntities)
//                if (!res.contains(userEntity))
//                    res.add(userEntity);
//        }

        return userRepo.findAllBuyerByIsActiveAndKeyword(isAvailable, keyword);
    }

    @Override
    public Integer getOrderedItem(Integer customerId) {
        UserEntity customer = userRepo.findById(customerId).orElse(null);

        Integer ordered = 0;
        for (OrderItemEntity orderItem : customer.getOrderItems())
            ordered += orderItem.getQuantityBought();

        return ordered;
    }

    @Override
    public float getTotalSpent(Integer customerId) {
        UserEntity customer = userRepo.findById(customerId).orElse(null);

        float totalSpent = 0;
        for (OrderItemEntity orderItem : customer.getOrderItems())
            totalSpent += orderItem.getTotalCost();

        return totalSpent;
    }

    @Override
    public UserEntity addProductToCart(Integer userId, String productCode, Integer quantityBought) {
        ProductEntity product = productRepo.findById(productCode).orElse(null);
        UserEntity user = userRepo.findById(userId).orElse(null);

        if (product == null || user == null)
            return null;

        // check exist
        for (OrderItemEntity orderItemEntity : user.getOrderItems()) {
            if (orderItemEntity.getProduct().getCode().equals(productCode) &&
                    orderItemEntity.getQuantityBought().equals(quantityBought) &&
                    orderItemEntity.getCustomer().getId().equals(userId) &&
                    orderItemEntity.getPayment() == null) {
                return this.exceptionObject(new UserEntity(), "This product existed in your cart.");
            }
        }

        OrderItemEntity orderItem = new OrderItemEntity();
        orderItem.setProduct(product);
        orderItem.setQuantityBought(quantityBought);
        orderItem.setTotalCost(product.getPrice() * quantityBought);
        orderItem.setCustomer(user);
        orderItem = orderItemRepo.save(orderItem);
        if (!orderItem.getHttpStatus().equals(HttpStatus.OK))
            return this.exceptionObject(new UserEntity(), "Something went wrong.");

        user.setMessage("Add product to cart successfully.");
        return user;
    }

    @Override
    public List<OrderItemEntity> getOrderItemsWithoutPayment(Integer userId) {
        UserEntity userEntity = userRepo.findById(userId).orElse(null);
        if (userEntity == null)
            return new ArrayList<>();

        List<OrderItemEntity> resEntities = new ArrayList<>();
        for (OrderItemEntity orderItemEntity : userEntity.getOrderItems()) {
            if (orderItemEntity.getPayment() == null)
                resEntities.add(orderItemEntity);
        }

        return resEntities;
    }

    @Override
    public List<UserEntity> findAllCustomerBySellerId(Integer sellerId) {
        List<UserEntity> resEntities = new ArrayList<>();
        List<PaymentEntity> paymentEntities = paymentService.findAllBySellerId(sellerId);
        for (PaymentEntity paymentEntity : paymentEntities) {
            if (!resEntities.contains(paymentEntity.getOrderItem().getCustomer()))
                resEntities.add(paymentEntity.getOrderItem().getCustomer());
        }

        return resEntities;
    }

    @Override
    public List<UserEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<UserEntity> findAll(String keyword) {
        return null;
    }

    @Override
    public List<UserEntity> findAll(Pageable pageable, String keyword) {
        return null;
    }

    @Override
    public List<UserEntity> findAll(IsActiveMode isActiveMode) {
        if (isActiveMode == IsActiveMode.TRUE)
            return userRepo.findAllByIsActive(true);
        else if (isActiveMode == IsActiveMode.FALSE)
            return userRepo.findAllByIsActive(false);
        else if (isActiveMode == IsActiveMode.BOTH)
            return userRepo.findAll();

        return null;

    }

    @Override
    public List<UserEntity> findAll(Pageable pageable, IsActiveMode isActiveMode) {
        return null;
    }

    @Override
    public List<UserEntity> findAll(String keyword, IsActiveMode isActiveMode) {
        return null;
    }

    @Override
    public List<UserEntity> findAll(Pageable pageable, String keyword, IsActiveMode isActiveMode) {
        return null;
    }

    @Override
    public List<UserEntity> findAllSeller() {
        return userRepo.findAllByIsActiveAndRoleCode(true, "SELLER");
    }

    @Override
    public List<UserEntity> findAllSeller(Pageable pageable) {
        return null;
    }

    @Override
    public List<UserEntity> findAllSeller(String keyword) {
        return null;
    }

    @Override
    public List<UserEntity> findAllSeller(Pageable pageable, String keyword) {
        return null;
    }

    @Override
    public List<UserEntity> findAllSeller(IsActiveMode isActiveMode) {
        if (isActiveMode == IsActiveMode.TRUE)
            return this.findAllSeller();
        else if (isActiveMode == IsActiveMode.FALSE)
            return userRepo.findAllByIsActiveAndRoleCode(false, "SELLER");
        else if (isActiveMode == IsActiveMode.BOTH)
            return userRepo.findAllByRoleCode("SELLER");

        return null;
    }

    @Override
    public List<UserEntity> findAllSeller(Pageable pageable, IsActiveMode isActiveMode) {
        return null;
    }

    @Override
    public List<UserEntity> findAllSeller(String keyword, IsActiveMode isActiveMode) {
        return null;
    }

    @Override
    public List<UserEntity> findAllSeller(Pageable pageable, String keyword, IsActiveMode isActiveMode) {
        return null;
    }

    @Override
    public List<UserEntity> findAllBuyer() {
        return userRepo.findAllByIsActiveAndRoleCode(true, "BUYER");
    }

    @Override
    public List<UserEntity> findAllBuyer(Pageable pageable) {
        return null;
    }

    @Override
    public List<UserEntity> findAllBuyer(String keyword) {
        return null;
    }

    @Override
    public List<UserEntity> findAllBuyer(Pageable pageable, String keyword) {
        return null;
    }

    @Override
    public List<UserEntity> findAllBuyer(IsActiveMode isActiveMode) {
        if (isActiveMode == IsActiveMode.TRUE)
            return this.findAllBuyer();
        else if (isActiveMode == IsActiveMode.FALSE)
            return userRepo.findAllByIsActiveAndRoleCode(false, "BUYER");
        else if (isActiveMode == IsActiveMode.BOTH)
            return userRepo.findAllByRoleCode("BUYER");

        return null;
    }

    @Override
    public List<UserEntity> findAllBuyer(Pageable pageable, IsActiveMode isActiveMode) {
        return null;
    }

    @Override
    public List<UserEntity> findAllBuyer(String keyword, IsActiveMode isActiveMode) {
        return null;
    }

    @Override
    public List<UserEntity> findAllBuyer(Pageable pageable, String keyword, IsActiveMode isActiveMode) {
        return null;
    }

    @Override
    public UserEntity findOne(Integer id) {
        UserEntity userEntity = userRepo.findById(id).orElse(null);
        if (userEntity == null || userEntity.getIsActive().equals(false))
            return this.exceptionObject(new UserEntity(), "This user id does not exist.");

        return userEntity;
    }

    @Override
    public UserEntity findOne(Integer id, IsActiveMode isActiveMode) {
        if (isActiveMode == IsActiveMode.TRUE)
            return findOne(id);
        else if (isActiveMode == IsActiveMode.FALSE) {
            UserEntity userEntity = userRepo.findById(id).orElse(null);
            if (userEntity == null || userEntity.getIsActive().equals(true))
                return this.exceptionObject(new UserEntity(), "This user id does not exist with isActive = true.");
            return userEntity;
        } else if (isActiveMode == IsActiveMode.BOTH) {
            UserEntity userEntity = userRepo.findById(id).orElse(null);
            if (userEntity == null)
                return this.exceptionObject(new UserEntity(), "This user id does not exist");
            return userEntity;
        }

        return null;
    }

}
