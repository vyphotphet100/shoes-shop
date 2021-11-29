-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Nov 28, 2021 at 07:10 am
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.0.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shoes-shop`
--

-- --------------------------------------------------------

--
-- Table structure for table `brand`
--

CREATE TABLE `brand` (
  `code` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_by` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `modified_by` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Dumping data for table `brand`
--

INSERT INTO `brand` (`code`, `created_date`, `created_by`, `modified_by`, `modified_date`, `name`) VALUES
('BRAND1', NULL, NULL, NULL, NULL, 'Nike'),
('BRAND2', NULL, NULL, NULL, NULL, 'Adidas'),
('BRAND3', NULL, NULL, NULL, NULL, 'Puma'),
('BRAND4', NULL, NULL, NULL, NULL, 'Converse'),
('BRAND5', NULL, NULL, NULL, NULL, 'GYM'),
('BRAND6', NULL, NULL, NULL, NULL, 'YOGA'),
('BRAND7', NULL, NULL, NULL, NULL, 'SWIMMING'),
('BRAND8', NULL, NULL, NULL, NULL, 'Brand Name 8');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `code` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_by` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `modified_by` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`code`, `created_date`, `created_by`, `modified_by`, `modified_date`, `name`) VALUES
('CATEGORY1', NULL, NULL, NULL, NULL, 'Women\'s Shoes'),
('CATEGORY2', NULL, NULL, NULL, NULL, 'Men\'s Shoes'),
('CATEGORY3', NULL, NULL, NULL, NULL, 'Sportswear Collection');

-- --------------------------------------------------------

--
-- Table structure for table `order_item`
--

CREATE TABLE `order_item` (
  `id` int(11) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_by` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `modified_by` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `quantity_bought` int(11) DEFAULT NULL,
  `total_cost` float DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `product_code` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `id` int(11) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_by` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `modified_by` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `payment_date` datetime DEFAULT NULL,
  `shipment_date` datetime DEFAULT NULL,
  `order_item_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `payment_method`
--

CREATE TABLE `payment_method` (
  `id` int(11) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_by` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `modified_by` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Dumping data for table `payment_method`
--

INSERT INTO `payment_method` (`id`, `created_date`, `created_by`, `modified_by`, `modified_date`, `name`) VALUES
(1, NULL, NULL, NULL, NULL, 'Paypal'),
(2, NULL, NULL, NULL, NULL, 'VNPAY'),
(3, NULL, NULL, NULL, NULL, 'COD');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `code` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_by` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `modified_by` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `description` text COLLATE utf8_vietnamese_ci,
  `in_stock` bit(1) DEFAULT NULL,
  `is_available` tinyint(1) DEFAULT NULL,
  `picture_url` text COLLATE utf8_vietnamese_ci,
  `price` float DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `title` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `brand_code` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `category_code` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `seller_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `code` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_by` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `modified_by` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`code`, `created_date`, `created_by`, `modified_by`, `modified_date`, `name`) VALUES
('ADMIN', NULL, NULL, NULL, NULL, 'Admin'),
('BUYER', NULL, NULL, NULL, NULL, 'Buyer'),
('SELLER', NULL, NULL, NULL, NULL, 'Seller');

-- --------------------------------------------------------

--
-- Table structure for table `transfer_payment`
--

CREATE TABLE `transfer_payment` (
  `id` int(11) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_by` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `modified_by` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `amount` float DEFAULT NULL,
  `transfer_date` datetime DEFAULT NULL,
  `admin_id` int(11) DEFAULT NULL,
  `payment_id` int(11) DEFAULT NULL,
  `seller_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_by` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `modified_by` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `address` text COLLATE utf8_vietnamese_ci,
  `birthday` date DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `first_name` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `gender` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT NULL,
  `last_name` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `payment_method_id` int(11) DEFAULT NULL,
  `role_code` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `created_date`, `created_by`, `modified_by`, `modified_date`, `address`, `birthday`, `email`, `first_name`, `gender`, `is_active`, `last_name`, `password`, `phone`, `username`, `payment_method_id`, `role_code`) VALUES
(1, NULL, NULL, NULL, NULL, 'TPHCM', '2001-04-20', 'abc@123.com', 'Nguyen', 'Male', 1, 'Admin', '123456', '0123456789', 'admin', 1, 'ADMIN'),
(2, NULL, NULL, NULL, NULL, 'TPHCM', '2001-04-20', 'abc@123.com', 'Nguyen', 'Female', 1, 'Anh 1', '123456', '0123456789', 'user1', 1, 'SELLER'),
(3, NULL, NULL, NULL, NULL, 'TPHCM', '2001-04-15', 'abc@123.com', 'Nguyen', 'Male', 1, 'Anh 2', '123456', '0123456789', 'user2', 2, 'SELLER'),
(4, NULL, NULL, NULL, NULL, 'TPHCM', '2001-04-15', 'abc@123.com', 'Nguyen', 'Female', 1, 'Anh 3', '123456', '0123456789', 'user3', 1, 'SELLER'),
(5, NULL, NULL, NULL, NULL, 'TPHCM', '2001-04-20', 'abc@123.com', 'Nguyen', 'Male', 0, 'Anh 4', '123456', '0123456789', 'user4', 2, 'BUYER'),
(6, NULL, NULL, NULL, NULL, 'TPHCM', '2001-04-15', 'abc@123.com', 'Nguyen', 'Female', 1, 'Anh 5', '123456', '0123456789', 'user5', 1, 'BUYER'),
(7, NULL, NULL, NULL, NULL, 'TPHCM', '2001-04-20', 'abc@123.com', 'Nguyen', 'Male', 1, 'Anh 6', '123456', '0123456789', 'user6', 1, 'BUYER'),
(8, NULL, NULL, NULL, NULL, 'TPHCM', '2001-04-20', 'abc@123.com', 'Nguyen', 'Male', 1, 'Anh 7', '123456', '0123456789', 'user7', 2, 'BUYER'),
(9, NULL, NULL, NULL, NULL, 'TPHCM', '2001-04-15', 'abc@123.com', 'Nguyen', 'Female', 1, 'Anh 8', '123456', '0123456789', 'user8', 1, 'BUYER'),
(10, NULL, NULL, NULL, NULL, 'Quang Binh', '2001-04-15', 'caovy2001@gmail.com', 'Cao', 'Male', 1, 'Vy', '123456', '0975543975', 'vyphotphet100', NULL, 'SELLER'),
(17, NULL, NULL, NULL, NULL, NULL, '2021-11-02', 'caovy2001@gmail.com', 'Cao', NULL, 1, 'Vy', '123456', '0975543975', 'user101', NULL, 'BUYER'),
(18, NULL, NULL, NULL, NULL, NULL, '2021-11-11', 'caovy2001@gmail.com', 'Cao', NULL, 1, 'Vy', '123', '0975543975', 'user102', NULL, 'SELLER');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `brand`
--
ALTER TABLE `brand`
  ADD PRIMARY KEY (`code`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`code`);

--
-- Indexes for table `order_item`
--
ALTER TABLE `order_item`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKkbgaappyp4pvxj9yqpf91c3n7` (`customer_id`),
  ADD KEY `FKbykdp3n8proui9ssfjqj1jia9` (`product_code`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKeieewj4wh8xqkejt013qvxnq1` (`order_item_id`);

--
-- Indexes for table `payment_method`
--
ALTER TABLE `payment_method`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`code`),
  ADD KEY `FKkj5ym5uuelxkv9mgxqk0vwhoc` (`brand_code`),
  ADD KEY `FKq2is6nuh9082to0kr959h9tum` (`category_code`),
  ADD KEY `FKmsvavr0t3lra70gf2ymxdi5te` (`seller_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`code`);

--
-- Indexes for table `transfer_payment`
--
ALTER TABLE `transfer_payment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK8ge7a5yvloi10fp8gob34d81y` (`admin_id`),
  ADD KEY `FK93ysoysuo9codyuhliguigv1s` (`payment_id`),
  ADD KEY `FK7gr7sl7al0k0jerc7ir4a0m5g` (`seller_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKsyue4e5dut0pg0mr05jn7ypx3` (`payment_method_id`),
  ADD KEY `FK5lv7c3wigi276kuiwxs7cs3fi` (`role_code`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `order_item`
--
ALTER TABLE `order_item`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;
--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT for table `payment_method`
--
ALTER TABLE `payment_method`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `transfer_payment`
--
ALTER TABLE `transfer_payment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `order_item`
--
ALTER TABLE `order_item`
  ADD CONSTRAINT `FKbykdp3n8proui9ssfjqj1jia9` FOREIGN KEY (`product_code`) REFERENCES `product` (`code`),
  ADD CONSTRAINT `FKkbgaappyp4pvxj9yqpf91c3n7` FOREIGN KEY (`customer_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `FKeieewj4wh8xqkejt013qvxnq1` FOREIGN KEY (`order_item_id`) REFERENCES `order_item` (`id`);

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `FKkj5ym5uuelxkv9mgxqk0vwhoc` FOREIGN KEY (`brand_code`) REFERENCES `brand` (`code`),
  ADD CONSTRAINT `FKmsvavr0t3lra70gf2ymxdi5te` FOREIGN KEY (`seller_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKq2is6nuh9082to0kr959h9tum` FOREIGN KEY (`category_code`) REFERENCES `category` (`code`);

--
-- Constraints for table `transfer_payment`
--
ALTER TABLE `transfer_payment`
  ADD CONSTRAINT `FK7gr7sl7al0k0jerc7ir4a0m5g` FOREIGN KEY (`seller_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FK8ge7a5yvloi10fp8gob34d81y` FOREIGN KEY (`admin_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FK93ysoysuo9codyuhliguigv1s` FOREIGN KEY (`payment_id`) REFERENCES `payment` (`id`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FK5lv7c3wigi276kuiwxs7cs3fi` FOREIGN KEY (`role_code`) REFERENCES `role` (`code`),
  ADD CONSTRAINT `FKsyue4e5dut0pg0mr05jn7ypx3` FOREIGN KEY (`payment_method_id`) REFERENCES `payment_method` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
