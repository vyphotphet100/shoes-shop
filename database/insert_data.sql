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




