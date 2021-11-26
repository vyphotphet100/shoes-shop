package com.group3.shoesshop.service.impl;

import com.group3.shoesshop.entity.OrderItemEntity;
import com.group3.shoesshop.service.IPayPalService;
import com.group3.shoesshop.utils.MyUtils;
import com.group3.shoesshop.utils.PaymentUtils;
import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PayPalService implements IPayPalService {
    private static final String CLIENT_ID = "AWY4PZ5MFzJRu3MQGi3qNLHejkA9mtk3b5vAOqlUm4QL_osF2Oo5ry0L3QJG9FGOXXgd__sOB1uHiyU7";
    private static final String CLIENT_SECRET = "EDlRUMCrDxdGqtfWb5F5Gvb_brKRgzJ6lFZcEfGEBS8N6zlCuXZtxgVWy9O6j_bnDKO4RVzRGASg2bvX";
    private static final String MODE = "sandbox";

    @Override
    public String authorizePayment(List<OrderItemEntity> orderItemEntities) throws PayPalRESTException {
        Payer payer = getPayerInformation();
        RedirectUrls redirectUrls = getRedirectURLs();
        List<Transaction> listTransaction = getTransactionInformation(orderItemEntities);

        Payment requestPayment = new Payment();
        requestPayment.setTransactions(listTransaction);
        requestPayment.setRedirectUrls(redirectUrls);
        requestPayment.setPayer(payer);
        requestPayment.setIntent("authorize");

        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);

        Payment approvedPayment = requestPayment.create(apiContext);

        System.out.println("=== CREATED PAYMENT: ====");
        System.out.println(approvedPayment);

        return getApprovalLink(approvedPayment);
    }

    @Override
    public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException {
        PaymentExecution paymentExecution = new PaymentExecution();
        paymentExecution.setPayerId(payerId);

        Payment payment = new Payment().setId(paymentId);

        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);

        return payment.execute(apiContext, paymentExecution);
    }

    @Override
    public Payment getPaymentDetails(String paymentId) throws PayPalRESTException {
        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
        return Payment.get(apiContext, paymentId);
    }

    private Payer getPayerInformation() {
        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");

        PayerInfo payerInfo = new PayerInfo();
        payerInfo.setFirstName("William")
                .setLastName("Peterson")
                .setEmail("william.peterson@company.com");

        payer.setPayerInfo(payerInfo);

        return payer;
    }

    private RedirectUrls getRedirectURLs() {
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl("http://localhost:8080/PaypalTest_war/cancel.jsp");
        redirectUrls.setReturnUrl("http://localhost:8080/customer/paying/review-payment");

        return redirectUrls;
    }

    private List<Transaction> getTransactionInformation(List<OrderItemEntity> orderItemEntities) {
        Transaction transaction = new Transaction();
        String description = PaymentUtils.generateDescriptionFromOrderItemList(orderItemEntities);

        transaction.setDescription(description);

        ItemList itemList = new ItemList();
        List<Item> items = new ArrayList<>();

        float subTotal = 0;
        for (OrderItemEntity orderItemEntity : orderItemEntities) {
            Item item = new Item();
            item.setCurrency("USD");
            item.setName(orderItemEntity.getProduct().getTitle());
            item.setPrice(String.valueOf(orderItemEntity.getProduct().getPrice()));
            item.setTax("0");
            item.setQuantity(orderItemEntity.getQuantityBought().toString());

            items.add(item);
            subTotal += orderItemEntity.getProduct().getPrice() * orderItemEntity.getQuantityBought();
        }

        itemList.setItems(items);
        transaction.setItemList(itemList);

        Details details = new Details();
        details.setShipping("0");
        details.setSubtotal(String.valueOf(subTotal));
        details.setTax("0");

        Amount amount = new Amount();
        amount.setCurrency("USD");
        amount.setTotal(details.getSubtotal());
        amount.setDetails(details);
        transaction.setAmount(amount);

        List<Transaction> listTransaction = new ArrayList<>();
        listTransaction.add(transaction);

        return listTransaction;
    }

    private String getApprovalLink(Payment approvedPayment) {
        List<Links> links = approvedPayment.getLinks();
        String approvalLink = null;

        for (Links link : links) {
            if (link.getRel().equalsIgnoreCase("approval_url")) {
                approvalLink = link.getHref();
                break;
            }
        }

        return approvalLink;
    }
}
