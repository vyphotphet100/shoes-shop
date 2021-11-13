INSERT INTO `role`(`code`, `name`)
VALUES ('ADMIN', 'Admin'),
       ('SELLER', 'Seller'),
       ('BUYER', 'Buyer');

INSERT INTO `payment_method`(`name`)
VALUES ('Paypal'),
       ('VNPAY');

INSERT INTO `user`(`first_name`, `last_name`, `gender`, `birthday`, `address`, `phone`, `email`, `username`, `password`,
                   `is_active`, `role_code`, `payment_method_id`)
VALUES ('Nguyen', 'Admin', 'Male', '2001-04-20', 'TPHCM', '0123456789', 'abc@123.com', 'admin' ,'123456', TRUE, 'ADMIN', '1'),
       ('Nguyen', 'Anh 1', 'Female', '2001-04-20', 'TPHCM', '0123456789', 'abc@123.com', 'user1', '123456', TRUE, 'SELLER', '1'),
       ('Nguyen', 'Anh 2', 'Male', '2001-04-15', 'TPHCM', '0123456789', 'abc@123.com', 'user2', '123456', TRUE, 'SELLER', '2'),
       ('Nguyen', 'Anh 3', 'Female', '2001-04-15', 'TPHCM', '0123456789', 'abc@123.com', 'user3', '123456', TRUE, 'SELLER', '1'),
       ('Nguyen', 'Anh 4', 'Male', '2001-04-20', 'TPHCM', '0123456789', 'abc@123.com', 'user4', '123456', TRUE, 'BUYER', '2'),
       ('Nguyen', 'Anh 5', 'Female', '2001-04-15', 'TPHCM', '0123456789', 'abc@123.com', 'user5', '123456', TRUE, 'BUYER', '1'),
       ('Nguyen', 'Anh 6', 'Male', '2001-04-20', 'TPHCM', '0123456789', 'abc@123.com', 'user6', '123456', TRUE, 'BUYER', '1'),
       ('Nguyen', 'Anh 7', 'Male', '2001-04-20', 'TPHCM', '0123456789', 'abc@123.com', 'user7', '123456', TRUE, 'BUYER', '2'),
       ('Nguyen', 'Anh 8', 'Female', '2001-04-15', 'TPHCM', '0123456789', 'abc@123.com', 'user8', '123456', TRUE, 'BUYER', '1');

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





