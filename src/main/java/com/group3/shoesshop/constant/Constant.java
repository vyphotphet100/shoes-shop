package com.group3.shoesshop.constant;

import java.util.Arrays;
import java.util.List;

public class Constant {
    public static String ROOT_PATH = null;
    public static String USER_SESSION = "USER_SESSION";

    // Role
    public static String ROLE_ADMIN = "ADMIN";
    public static String ROLE_ADMIN1 = "ADMIN1";
    public static String ROLE_ADMIN2 = "ADMIN2";
    public static String ROLE_ADMIN3 = "ADMIN3";

    public static List<String> ROLE_ADMIN_CAN = Arrays.asList(new String[]{"PRODUCT_MANAGING","SELLER_MANAGING", "CUSTOMER_MANAGING"});
    public static List<String> ROLE_ADMIN1_CAN = Arrays.asList(new String[]{"PRODUCT_MANAGING"});
    public static List<String> ROLE_ADMIN2_CAN = Arrays.asList(new String[]{"SELLER_MANAGING"});
    public static List<String> ROLE_ADMIN3_CAN = Arrays.asList(new String[]{"CUSTOMER_MANAGING"});

    public static String ROLE_SELLER = "SELLER";
    public static String ROLE_CUSTOMER = "BUYER";

    public static String READY_ORDER_ITEMS = "READY_ORDER_ITEMS";

    public static int EXCHANGE_RATE_USD_VND = 22679;
}
