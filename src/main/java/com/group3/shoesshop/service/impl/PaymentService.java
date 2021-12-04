package com.group3.shoesshop.service.impl;

import com.group3.shoesshop.constant.Constant;
import com.group3.shoesshop.entity.OrderItemEntity;
import com.group3.shoesshop.entity.PaymentEntity;
import com.group3.shoesshop.entity.ProductEntity;
import com.group3.shoesshop.entity.UserEntity;
import com.group3.shoesshop.repository.PaymentRepository;
import com.group3.shoesshop.repository.ProductRepository;
import com.group3.shoesshop.service.IPaymentService;
import com.group3.shoesshop.service.IProductService;
import com.group3.shoesshop.utils.GoogleMailUtils;
import com.group3.shoesshop.utils.PaymentUtils;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

@Service
public class PaymentService extends BaseService<PaymentEntity> implements IPaymentService {
    @Autowired
    private PaymentRepository paymentRepo;

    @Autowired
    private IProductService productService;

    @Override
    public List<PaymentEntity> findAll() {
        return paymentRepo.findAll();
    }

    @Override
    public PaymentEntity save(PaymentEntity entity) {
        return paymentRepo.save(entity);
    }

    @Override
    public PaymentEntity update(PaymentEntity entity) {
        return null;
    }

    @Override
    public PaymentEntity findOne(Integer id) {
        return paymentRepo.findById(id).orElse(null);
    }

    @Override
    public PaymentEntity delete(Integer id) {
        return null;
    }

    @Override
    public List<PaymentEntity> findAllBySellerId(Integer id) {
        return paymentRepo.findAllByOrderItemProductSellerId(id);
    }

    @Override
    public Boolean executePayment(List<OrderItemEntity> orderItemEntities) {
        try {
            for (OrderItemEntity orderItemEntity : orderItemEntities) {
                PaymentEntity paymentEntity = new PaymentEntity();

                // update product quantity in bunker
                ProductEntity productEntity = productService.findOne(orderItemEntity.getProduct().getCode());
                productEntity.setQuantity(productEntity.getQuantity() - orderItemEntity.getQuantityBought());
                productService.update(productEntity);

                // save payment
                paymentEntity.setOrderItem(orderItemEntity);
                paymentEntity.setPaymentDate(new Date());
                paymentRepo.save(paymentEntity);
            }

            // send mail
            if (orderItemEntities.size() > 0) {
                UserEntity userEntity = orderItemEntities.get(0).getCustomer();
                ResourceBundle rb = ResourceBundle.getBundle("hostmail");
                String email = rb.getString("email");
                String password = rb.getString("password");
                String toAddress = userEntity.getEmail();
                String subject = "NORIVA - Your order has been successfully processed!";
                String description = PaymentUtils.generateDescriptionFromOrderItemList(orderItemEntities);
                float total = PaymentUtils.getTotalCostOfOrderItemList(orderItemEntities);
                String message =
                        "<h1 class=\"mb-5\">Your order have been placed!</h1>\n" +
                                "            <p>Your order has been successfully processed!</p>\n" +
                                "            <p>You can view your order history by going to the <span><a href=\""+ Constant.ROOT_PATH +"customer/my-account/account\">My Account</a></span>\n" +
                                "                page and by\n" +
                                "                clicking on <span><a href=\""+ Constant.ROOT_PATH +"customer/my-account/order-history\">History</a></span>.</p>\n" +
                                "            <p>Thanks for shopping with us online!</p><br>" +
                                "<div class=\"details\">\n" +
                                "                <table class=\"table table-bordered\">\n" +
                                "                    <thead class=\"thead-dark\">\n" +
                                "                        <tr>\n" +
                                "                            <td colspan=\"2\"><p class=\"para\">Payment Details</p></td>\n" +
                                "                        </tr>\n" +
                                "                    </thead>\n" +
                                "                    <tr>\n" +
                                "                        <td>Shipping Address:</td>\n" +
                                "                        <td>"+userEntity.getAddress()+"</td>\n" +
                                "                    </tr>\n" +
                                "                    <tr>\n" +
                                "                        <td>Description:</td>\n" +
                                "                        <td>"+ description +"</td>\n" +
                                "                    </tr>\n" +
                                "                    <tr>\n" +
                                "                        <td>Subtotal:</td>\n" +
                                "                        <td>"+ total +" USD</td>\n" +
                                "                    </tr>\n" +
                                "                    <tr>\n" +
                                "                        <td>Total:</td>\n" +
                                "                        <td>"+ total +" USD</td>\n" +
                                "                    </tr>\n" +
                                "                </table>\n" +
                                "            </div>";
                GoogleMailUtils.sendEmail(email, password, toAddress, subject, message);
            }

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
