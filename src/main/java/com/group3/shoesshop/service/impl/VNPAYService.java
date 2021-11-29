package com.group3.shoesshop.service.impl;

import com.group3.shoesshop.constant.Constant;
import com.group3.shoesshop.entity.OrderItemEntity;
import com.group3.shoesshop.service.IVNPAYService;
import com.group3.shoesshop.utils.PaymentUtils;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class VNPAYService implements IVNPAYService {
    public static String vnp_PayUrl = "https://sandbox.vnpayment.vn/paymentv2/vpcpay.html";
    public static String vnp_TmnCode = "EYS9XOIK";
    public static String vnp_HashSecret = "QEFMYVGWEZZVNDAMYVNPTNMJZOKVMGDR";
    public static String vnp_apiUrl = "https://sandbox.vnpayment.vn/merchant_webapi/merchant.html";

    @Override
    public String getRedirectLink(HttpServletRequest request, List<OrderItemEntity> orderItemEntities) throws IOException {
        String vnp_Version = "2.1.0";
        String vnp_Command = "pay";
        //String vnp_Command = "genqr";

        String description = PaymentUtils.generateDescriptionFromOrderItemList(orderItemEntities);

        String vnp_OrderInfo = description; // description
        String orderType = "billpayment";
        String vnp_TxnRef = this.getRandomNumber(8);
        int mcId = Integer.parseInt(this.getRandomNumber(8));

        float total = PaymentUtils.getTotalCostOfOrderItemList(orderItemEntities);

        String vnp_IpAddr = this.getIpAddress(request);
        String vnp_TmnCode = this.vnp_TmnCode;
        int amount = (int) total * Constant.EXCHANGE_RATE_USD_VND * 100; // total amount
        Map<String, String> vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", vnp_Version);
        vnp_Params.put("vnp_Command", vnp_Command);
        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
        vnp_Params.put("vnp_Amount", String.valueOf(amount));
        vnp_Params.put("vnp_CurrCode", "VND");
        String bank_code = null;
        if (bank_code != null && !bank_code.isEmpty()) {
            vnp_Params.put("vnp_BankCode", bank_code);
        }
        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
        vnp_Params.put("vnp_OrderInfo", vnp_OrderInfo);
        vnp_Params.put("vnp_OrderType", orderType);

        String locate = "vn";
        if (locate != null && !locate.isEmpty()) {
            vnp_Params.put("vnp_Locale", locate);
        } else {
            vnp_Params.put("vnp_Locale", "vn");
        }
        String vnp_Returnurl = Constant.ROOT_PATH + "customer/paying/execute-payment";
        vnp_Params.put("vnp_ReturnUrl", vnp_Returnurl);
        vnp_Params.put("vnp_IpAddr", vnp_IpAddr);

        Date dt = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnp_CreateDate = formatter.format(dt);
        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

        Calendar cldvnp_ExpireDate = Calendar.getInstance();
        cldvnp_ExpireDate.add(Calendar.SECOND, 30);
        Date vnp_ExpireDateD = cldvnp_ExpireDate.getTime();
        String vnp_ExpireDate = formatter.format(vnp_ExpireDateD);

        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

        List fieldNames = new ArrayList(vnp_Params.keySet());
        Collections.sort(fieldNames);
        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();
        Iterator itr = fieldNames.iterator();
        while (itr.hasNext()) {
            String fieldName = (String) itr.next();
            String fieldValue = (String) vnp_Params.get(fieldName);
            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                //Build hash data
                hashData.append(fieldName);
                hashData.append('=');
                //hashData.append(fieldValue); //sử dụng và 2.0.0 và 2.0.1 checksum sha256
                hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString())); //sử dụng v2.1.0  check sum sha512
                //Build query
                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                query.append('=');
                query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                if (itr.hasNext()) {
                    query.append('&');
                    hashData.append('&');
                }
            }
        }
        String queryUrl = query.toString();
        //String vnp_SecureHash = Config.Sha256(Config.vnp_HashSecret + hashData.toString());
        String vnp_SecureHash = this.hmacSHA512(this.vnp_HashSecret, hashData.toString());
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
        String paymentUrl = this.vnp_PayUrl + "?" + queryUrl;
        return paymentUrl;
    }

    private String hashAllFields(Map fields) {
        // create a list and sort it
        List fieldNames = new ArrayList(fields.keySet());
        Collections.sort(fieldNames);
        // create a buffer for the md5 input and add the secure secret first
        StringBuilder sb = new StringBuilder();
        //sb.append(com.vnpay.common.Config.vnp_HashSecret);
        Iterator itr = fieldNames.iterator();
        while (itr.hasNext()) {
            String fieldName = (String) itr.next();
            String fieldValue = (String) fields.get(fieldName);
            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                sb.append(fieldName);
                sb.append("=");
                sb.append(fieldValue);
            }
            if (itr.hasNext()) {
                sb.append("&");
            }
        }
        //return Sha256(sb.toString());
        return hmacSHA512(vnp_HashSecret,sb.toString());
    }

    private String hmacSHA512(final String key, final String data) {
        try {

            if (key == null || data == null) {
                throw new NullPointerException();
            }
            final Mac hmac512 = Mac.getInstance("HmacSHA512");
            byte[] hmacKeyBytes = key.getBytes();
            final SecretKeySpec secretKey = new SecretKeySpec(hmacKeyBytes, "HmacSHA512");
            hmac512.init(secretKey);
            byte[] dataBytes = data.getBytes(StandardCharsets.UTF_8);
            byte[] result = hmac512.doFinal(dataBytes);
            StringBuilder sb = new StringBuilder(2 * result.length);
            for (byte b : result) {
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();

        } catch (Exception ex) {
            return "";
        }
    }

    private String getIpAddress(HttpServletRequest request) {
        String ipAdress;
        try {
            ipAdress = request.getHeader("X-FORWARDED-FOR");
            if (ipAdress == null) {
                ipAdress = request.getRemoteAddr();
            }
        } catch (Exception e) {
            ipAdress = "Invalid IP:" + e.getMessage();
        }
        return ipAdress;
    }

    private String getRandomNumber(int len) {
        Random rnd = new Random();
        String chars = "0123456789";
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        return sb.toString();
    }
}
