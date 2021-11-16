INSERT INTO `role`(`code`, `name`)
VALUES ('ADMIN', 'Admin'),
       ('SELLER', 'Seller'),
       ('BUYER', 'Buyer');

INSERT INTO `payment_method`(`name`)
VALUES ('Paypal'),
       ('VNPAY');

INSERT INTO `user`(`first_name`, `last_name`, `gender`, `birthday`, `address`, `phone`, `email`, `username`, `password`,
                   `is_active`, `role_code`, `payment_method_id`)
VALUES ('Nguyen', 'Admin', 'Male', '2001-04-20', 'TPHCM', '0123456789', 'abc@123.com', 'admin', '123456', TRUE, 'ADMIN',
        '1'),
       ('Nguyen', 'Anh 1', 'Female', '2001-04-20', 'TPHCM', '0123456789', 'abc@123.com', 'user1', '123456', TRUE,
        'SELLER', '1'),
       ('Nguyen', 'Anh 2', 'Male', '2001-04-15', 'TPHCM', '0123456789', 'abc@123.com', 'user2', '123456', TRUE,
        'SELLER', '2'),
       ('Nguyen', 'Anh 3', 'Female', '2001-04-15', 'TPHCM', '0123456789', 'abc@123.com', 'user3', '123456', TRUE,
        'SELLER', '1'),
       ('Nguyen', 'Anh 4', 'Male', '2001-04-20', 'TPHCM', '0123456789', 'abc@123.com', 'user4', '123456', TRUE, 'BUYER',
        '2'),
       ('Nguyen', 'Anh 5', 'Female', '2001-04-15', 'TPHCM', '0123456789', 'abc@123.com', 'user5', '123456', TRUE,
        'BUYER', '1'),
       ('Nguyen', 'Anh 6', 'Male', '2001-04-20', 'TPHCM', '0123456789', 'abc@123.com', 'user6', '123456', TRUE, 'BUYER',
        '1'),
       ('Nguyen', 'Anh 7', 'Male', '2001-04-20', 'TPHCM', '0123456789', 'abc@123.com', 'user7', '123456', TRUE, 'BUYER',
        '2'),
       ('Nguyen', 'Anh 8', 'Female', '2001-04-15', 'TPHCM', '0123456789', 'abc@123.com', 'user8', '123456', TRUE,
        'BUYER', '1');

INSERT INTO `brand`(`code`, `name`)
VALUES ('BRAND1', 'Brand Name 1'),
       ('BRAND2', 'Brand Name 2'),
       ('BRAND3', 'Brand Name 3'),
       ('BRAND4', 'Brand Name 4'),
       ('BRAND5', 'Brand Name 5'),
       ('BRAND6', 'Brand Name 6'),
       ('BRAND7', 'Brand Name 7'),
       ('BRAND8', 'Brand Name 8');

INSERT INTO `category`(`code`, `name`)
VALUES ('CATEGORY1', 'Category Name 1'),
       ('CATEGORY2', 'Category Name 2'),
       ('CATEGORY3', 'Category Name 3'),
       ('CATEGORY4', 'Category Name 4'),
       ('CATEGORY5', 'Category Name 5'),
       ('CATEGORY6', 'Category Name 6'),
       ('CATEGORY7', 'Category Name 7');


INSERT INTO `product`(`code`, `description`, `in_stock`, `picture_url`, `price`, `quantity`,
                      `rating`, `size`, `title`, `brand_code`, `category_code`, `seller_id`)
VALUES ('PRODUCT1', 'Description of product 1', true,
        'https://vn-test-11.slatic.net/p/6b267c92a9cdcb8546be3e7925592603.jpg_320x320.jpg', 80, 10,
        5, 42, 'Product Title 1', 'BRAND1', 'CATEGORY7', 3),
       ('PRODUCT2', 'Description of product 2', true,
        'https://vn-test-11.slatic.net/p/6b267c92a9cdcb8546be3e7925592603.jpg_320x320.jpg', 90, 20,
        5, 43, 'Product Title 2', 'BRAND1', 'CATEGORY7', 3),
       ('PRODUCT3', 'Description of product 3', true,
        'https://vn-test-11.slatic.net/p/6b267c92a9cdcb8546be3e7925592603.jpg_320x320.jpg', 100, 30,
        5, 44, 'Product Title 3', 'BRAND2', 'CATEGORY7', 3),
       ('PRODUCT4', 'Description of product 4', true,
        'https://vn-test-11.slatic.net/p/6b267c92a9cdcb8546be3e7925592603.jpg_320x320.jpg', 100, 30,
        5, 42, 'Product Title 4', 'BRAND2', 'CATEGORY6', 3),
       ('PRODUCT5', 'Description of product 5', true,
        'https://vn-test-11.slatic.net/p/6b267c92a9cdcb8546be3e7925592603.jpg_320x320.jpg', 90, 20,
        5, 43, 'Product Title 5', 'BRAND3', 'CATEGORY6', 3),
       ('PRODUCT6', 'Description of product 6', true,
        'https://vn-test-11.slatic.net/p/6b267c92a9cdcb8546be3e7925592603.jpg_320x320.jpg', 80, 10,
        5, 44, 'Product Title 6', 'BRAND3', 'CATEGORY6', 2),
       ('PRODUCT7', 'Description of product 7', true,
        'https://vn-test-11.slatic.net/p/6b267c92a9cdcb8546be3e7925592603.jpg_320x320.jpg', 80, 10,
        5, 42, 'Product Title 7', 'BRAND4', 'CATEGORY5', 2),
       ('PRODUCT8', 'Description of product 8', true,
        'https://vn-test-11.slatic.net/p/6b267c92a9cdcb8546be3e7925592603.jpg_320x320.jpg', 90, 20,
        5, 43, 'Product Title 8', 'BRAND4', 'CATEGORY5', 2),
       ('PRODUCT9', 'Description of product 9', true,
        'https://vn-test-11.slatic.net/p/6b267c92a9cdcb8546be3e7925592603.jpg_320x320.jpg', 100, 30,
        5, 44, 'Product Title 9', 'BRAND5', 'CATEGORY5', 2),
       ('PRODUCT10', 'Description of product 10', true,
        'https://vn-test-11.slatic.net/p/6b267c92a9cdcb8546be3e7925592603.jpg_320x320.jpg', 100, 30,
        5, 42, 'Product Title 10', 'BRAND5', 'CATEGORY4', 2),
       ('PRODUCT11', 'Description of product 11', true,
        'https://vn-test-11.slatic.net/p/6b267c92a9cdcb8546be3e7925592603.jpg_320x320.jpg', 90, 20,
        5, 43, 'Product Title 11', 'BRAND6', 'CATEGORY4', 2);

INSERT INTO `order_item`(`customer_id`, `product_code`, `quantity_bought`, `total_cost`, `created_date`)
VALUES (5, 'PRODUCT1', 15, 1200, '2021-11-01 08:07:00'),
       (5, 'PRODUCT2', 15, 1200, '2021-11-02 09:08:00'),
       (5, 'PRODUCT3', 15, 1200, '2021-11-03 10:09:00'),
       (5, 'PRODUCT4', 15, 1200, '2021-11-04 07:10:00'),
       (6, 'PRODUCT5', 15, 1200, '2021-11-05 06:11:00'),
       (6, 'PRODUCT6', 15, 1200, '2021-11-06 05:12:00'),
       (6, 'PRODUCT7', 15, 1200, '2021-11-07 04:13:00'),
       (6, 'PRODUCT8', 15, 1200, '2021-11-08 03:14:00'),
       (6, 'PRODUCT9', 15, 1200, '2021-11-08 02:15:00'),
       (6, 'PRODUCT10', 15, 1200, '2021-11-07 01:16:00'),
       (7, 'PRODUCT11', 15, 1200, '2021-11-06 02:17:00'),
       (7, 'PRODUCT10', 15, 1200, '2021-11-05 03:16:00'),
       (7, 'PRODUCT9', 15, 1200, '2021-11-04 04:15:00'),
       (7, 'PRODUCT8', 15, 1200, '2021-11-03 05:14:00'),
       (7, 'PRODUCT7', 15, 1200, '2021-11-02 06:13:00'),
       (7, 'PRODUCT6', 15, 1200, '2021-11-01 07:12:00'),
       (7, 'PRODUCT5', 15, 1200, '2021-11-02 08:11:00'),
       (8, 'PRODUCT4', 15, 1200, '2021-11-03 09:10:00'),
       (8, 'PRODUCT3', 15, 1200, '2021-11-04 10:09:00'),
       (8, 'PRODUCT2', 15, 1200, '2021-11-05 09:08:00'),
       (8, 'PRODUCT1', 15, 1200, '2021-11-06 08:07:00');

INSERT INTO `payment`(`payment_date`, `shipment_date`, `order_item_id`)
VALUES ('2021-11-06 08:07:00', '2021-11-08 08:07:00', 1),
       ('2021-11-07 08:07:00', '2021-11-09 08:07:00', 2),
       ('2021-11-08 08:07:00', '2021-11-10 08:07:00', 3),
       ('2021-11-09 08:07:00', '2021-11-11 08:07:00', 4),
       ('2021-11-10 08:07:00', '2021-11-12 08:07:00', 5),
       ('2021-10-06 08:07:00', '2021-10-08 08:07:00', 6),
       ('2021-10-06 08:07:00', '2021-10-09 08:07:00', 7),
       ('2021-10-06 08:07:00', '2021-10-10 08:07:00', 8),
       ('2021-10-06 08:07:00', '2021-10-11 08:07:00', 9),
       ('2021-10-06 08:07:00', '2021-10-12 08:07:00', 10),
       ('2021-10-06 08:07:00', '2021-10-13 08:07:00', 11),
       ('2021-10-06 08:07:00', '2021-10-14 08:07:00', 12),
       ('2021-10-06 08:07:00', '2021-10-15 08:07:00', 13),
       ('2021-10-06 08:07:00', '2021-10-16 08:07:00', 14),
       ('2021-10-06 08:07:00', '2021-10-17 08:07:00', 15),
       ('2021-10-06 08:07:00', '2021-10-18 08:07:00', 16),
       ('2021-10-06 08:07:00', '2021-10-19 08:07:00', 17),
       ('2021-10-06 08:07:00', '2021-10-20 08:07:00', 18),
       ('2021-10-06 08:07:00', '2021-10-21 08:07:00', 19),
       ('2021-10-06 08:07:00', '2021-10-22 08:07:00', 20),
       ('2021-10-06 08:07:00', '2021-10-23 08:07:00', 21);

INSERT INTO `transfer_payment`(`transfer_date`, `admin_id`, `seller_id`, `payment_id`, `amount`)
    VALUES ('2021-10-09 08:07:00', 1, 3, 1, 1100);



