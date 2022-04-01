--
-- Dumping data for table `brand`
--

INSERT INTO `brand` (`code`, `created_date`, `created_by`, `modified_by`, `modified_date`, `name`)
VALUES ('BRAND1', NULL, NULL, NULL, NULL, 'Nike'),
       ('BRAND2', NULL, NULL, NULL, NULL, 'Adidas'),
       ('BRAND3', NULL, NULL, NULL, NULL, 'Puma'),
       ('BRAND4', NULL, NULL, NULL, NULL, 'Converse'),
       ('BRAND5', NULL, NULL, NULL, NULL, 'GYM'),
       ('BRAND6', NULL, NULL, NULL, NULL, 'YOGA'),
       ('BRAND7', NULL, NULL, NULL, NULL, 'SWIMMING');

-- --------------------------------------------------------

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`code`, `created_date`, `created_by`, `modified_by`, `modified_date`, `name`)
VALUES ('CATEGORY1', NULL, NULL, NULL, NULL, 'Women\'s Shoes'),
('CATEGORY2', NULL, NULL, NULL, NULL, 'Men\'s Shoes'),
       ('CATEGORY3', NULL, NULL, NULL, NULL, 'Sportswear Collection');

-- --------------------------------------------------------

--
-- Dumping data for table `order_item`
--

INSERT INTO `order_item` (`id`, `created_date`, `created_by`, `modified_by`, `modified_date`, `quantity_bought`,
                          `total_cost`, `customer_id`, `product_code`)
VALUES (50, '2021-11-28 09:49:16', 'user5', 'user5', '2021-11-28 09:49:16', 1, 75, 6, 'fjjrt'),
       (52, '2021-11-28 09:49:23', 'user5', 'user5', '2021-11-28 09:49:23', 1, 82, 6, 'momsc'),
       (55, '2021-11-28 12:43:52', 'vyphotphet101', 'vyphotphet101', '2021-11-28 12:43:52', 1, 75, 21, 'fjjrt'),
       (56, '2021-11-28 13:19:53', 'hoanne', 'hoanne', '2021-11-28 13:19:53', 1, 100, 20, 'gzbxo'),
       (57, '2021-11-28 13:40:37', 'datdatdf', 'datdatdf', '2021-11-28 13:42:04', 20, 2000, 22, 'xykrh'),
       (61, '2021-11-29 03:21:00', 'vyphotphet101', 'vyphotphet101', '2021-11-29 03:21:40', 8, 520, 21, 'gkaxf'),
       (62, '2021-11-29 03:21:05', 'vyphotphet101', 'vyphotphet101', '2021-11-29 03:21:05', 1, 95, 21, 'hvbop'),
       (63, '2021-11-29 04:54:05', 'user1', 'user1', '2021-11-29 04:54:05', 1, 101, 2, 'nnkxh'),
       (65, '2021-12-02 18:26:21', 'hoanne', 'hoanne', '2021-12-02 18:26:21', 1, 75, 20, 'fjjrt'),
       (68, '2021-12-03 11:44:08', 'Ziết Lon', 'Ziết Lon', '2021-12-03 11:44:08', 1, 75, 24, 'fjjrt'),
       (69, '2021-12-03 15:44:37', 'hoanseller', 'hoanseller', '2021-12-03 15:44:37', 1, 399, 23, 'lvlku'),
       (72, '2021-12-04 14:01:34', 'user5', 'user5', '2021-12-04 14:02:38', 3, 330, 6, 'boglw'),
       (73, '2021-12-04 14:01:40', 'user5', 'user5', '2021-12-04 14:01:40', 1, 60, 6, 'espdw'),
       (74, '2021-12-06 07:14:31', 'hoan1', 'hoan1', '2021-12-06 07:14:31', 1, 130, 28, 'aehgw'),
       (75, '2021-12-06 07:14:35', 'hoan1', 'hoan1', '2021-12-06 07:14:35', 1, 75, 28, 'aqrrj'),
       (76, '2021-12-07 14:05:11', 'hoan123', 'hoan123', '2021-12-07 14:05:11', 1, 110, 29, 'boglw'),
       (77, '2021-12-07 14:10:25', 'hoan123', 'hoan123', '2021-12-07 14:11:07', 2, 298, 29, 'arynm'),
       (78, '2021-12-07 14:21:33', 'hoan123', 'hoan123', '2021-12-07 14:21:33', 2, 100, 29, 'stdiy'),
       (80, '2022-01-27 04:01:01', 'user5', 'user5', '2022-01-27 04:01:01', 1, 130, 6, 'aehgw'),
       (81, '2022-01-27 04:24:49', 'user5', 'user5', '2022-01-27 04:24:49', 1, 75, 6, 'aqrrj'),
       (83, '2022-01-27 04:24:54', 'user5', 'user5', '2022-01-27 04:24:54', 1, 110, 6, 'boglw'),
       (97, '2022-01-27 17:22:34', 'user5', 'user5', '2022-02-20 15:20:28', 1, 130, 6, 'aehgw'),
       (98, '2022-01-27 17:29:13', 'user5', 'user5', '2022-02-16 08:09:30', 2, 150, 6, 'aqrrj');

-- --------------------------------------------------------

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`id`, `created_date`, `created_by`, `modified_by`, `modified_date`, `payment_date`,
                       `shipment_date`, `order_item_id`)
VALUES (31, '2021-11-28 09:50:32', 'user5', 'user5', '2021-11-28 09:50:32', '2021-11-28 09:50:32', NULL, 52),
       (32, '2021-11-28 13:21:40', 'hoanne', 'hoanne', '2021-11-28 13:21:40', '2021-11-28 13:21:40', NULL, 56),
       (33, '2021-11-28 13:43:33', 'datdatdf', 'datdatdf', '2021-11-28 13:43:33', '2021-11-28 13:43:33', NULL, 57),
       (34, '2021-11-29 04:14:56', 'vyphotphet101', 'vyphotphet101', '2021-11-29 04:14:56', '2021-11-29 04:14:56', NULL,
        61),
       (35, '2021-11-29 16:41:00', 'user5', 'user5', '2021-11-29 16:41:00', '2021-11-29 16:41:00', NULL, 50),
       (36, '2021-12-04 14:04:52', 'user5', 'user5', '2021-12-04 14:04:52', '2021-12-04 14:04:52', NULL, 72),
       (37, '2021-12-04 14:04:52', 'user5', 'user5', '2021-12-04 14:04:52', '2021-12-04 14:04:52', NULL, 73),
       (38, '2021-12-06 07:16:02', 'hoan1', 'hoan1', '2021-12-06 07:16:02', '2021-12-06 07:16:02', NULL, 75),
       (39, '2021-12-07 14:07:42', 'hoan123', 'hoan123', '2021-12-07 14:07:42', '2021-12-07 14:07:42', NULL, 76),
       (40, '2021-12-07 14:12:29', 'hoan123', 'hoan123', '2021-12-07 14:12:29', '2021-12-07 14:12:29', NULL, 77),
       (41, '2021-12-07 14:22:15', 'hoan123', 'hoan123', '2021-12-07 14:22:15', '2021-12-07 14:22:15', NULL, 78),
       (42, '2022-01-27 04:32:10', 'user5', 'user5', '2022-01-27 04:32:10', '2022-01-27 04:32:10', NULL, 80),
       (43, '2022-01-27 04:32:10', 'user5', 'user5', '2022-01-27 04:32:10', '2022-01-27 04:32:10', NULL, 81),
       (44, '2022-01-27 04:32:10', 'user5', 'user5', '2022-01-27 04:32:10', '2022-01-27 04:32:10', NULL, 83),
       (45, '2022-02-16 08:09:53', 'user5', 'user5', '2022-02-16 08:09:53', '2022-02-16 08:09:53', NULL, 98);

-- --------------------------------------------------------

--
-- Dumping data for table `payment_method`
--

INSERT INTO `payment_method` (`id`, `created_date`, `created_by`, `modified_by`, `modified_date`, `name`)
VALUES (1, NULL, NULL, NULL, NULL, 'Paypal'),
       (2, NULL, NULL, NULL, NULL, 'VNPAY'),
       (3, NULL, NULL, NULL, NULL, 'COD');

-- --------------------------------------------------------

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`code`, `created_date`, `created_by`, `modified_by`, `modified_date`, `description`, `in_stock`,
                       `is_available`, `picture_url`, `price`, `quantity`, `rating`, `size`, `title`, `brand_code`,
                       `category_code`, `seller_id`)
VALUES ('aehgw', '2021-12-03 16:40:48', 'datdatdf', 'admin', '2022-02-15 03:36:05',
        'Since first appearing in SLAM 232 when he made history as the first ever solo artist to grace the cover of the legendary hoops magazine, J. Cole and DREAMER’s lines have been ...\r\n Style: 195065_03\r\n Color: Puma White-Puma White\r\n',
        b'1', 1, '/file?name=product_aehgw.png', 130, 65, 5, 36, 'The White Jointz', 'BRAND3', 'CATEGORY1', 22),
       ('aqrrj', '2021-12-03 16:14:22', 'hoanseller', 'user5', '2022-02-16 08:09:53',
        'ELEVATED STYLE.\r\nInspired by the iconic looks of \'90s girl bands,
        these platform Chucks are sure to turn heads. Premium leather can be as refined or edgy as you\'d like, while a double-stacked sole takes you higher.\r\nWHY YOU SHOULD BE DOWN\r\n•	Platform leather low top sneakers\r\n•	Elevated platform for added height\r\n•	Lace-up style for adjustable fit',
        b'1', 1, '/file?name=product_aqrrj.png', 75, 26, 5, 46, 'Chuck Taylor All Star', 'BRAND4', 'CATEGORY1', 23),
       ('arows', '2021-12-03 15:43:27', 'user1', 'user1', '2022-02-20 15:26:38',
        'X9000L2 SHOES\r\nSLEEK RUNNING SHOES FOR MID-DISTANCE RUNS.\r\nWhen robots take over the world, you\'ll be able to outrun them in these adidas running shoes. They come equipped with lightweight and flexible Bounce cushioning. A booster pack of Jetboost in the heel delivers energy return and enhanced stability. This product is made with Primegreen,
        a series of high-performance recycled materials. 50% of the upper is recycled content.\r\n', b'1', 0, '/file?name=product_arows.png', 285, 1, 5, 44, 'X9000L2 SHOES', 'BRAND2', 'CATEGORY2', 2),
('arynm', '2021-12-03 15:47:22', 'user1', 'user1', '2022-02-20 15:27:51', 'HEAVY WEIGHT INHERITANCE.\r\nShow off your game on the street in the Jordan Flight Heritage Hoodie,
        made from thick,
        high - density fleece in a classic hoodie look.\r\nProfits\r\n•	High-density French Terry fabric feels soft,
        thick, and warm.\r\n• Combination of embroidery and embossing on the chest.\r\n', b' 1 ', 0, ' / file ? name =
        product_arynm.png ', 149, 1, 5, 42, ' Jordan Flight Heritage ', ' BRAND5 ', ' CATEGORY3 ', 2),
(' azufx ', ' 2021 - 12 - 03 16 : 04 : 01 ', ' user1 ', ' user1 ', ' 2021 - 12 - 03 16 : 04 : 01 ', ' TRAINING 3 -
        STRIPES
        AEROREADY TEE\r\nA CREWNECK TEE THAT\'S A GO-TO FOR ANY TRAINING SESSION.\r\nWear this adidas t-shirt for gym workouts, yoga or whatever studio class you\'
        ve had your eye on.The relaxed cut gives you easy movement as you stretch and lift.AEROREADY wicks moisture to
        keep you feeling dry.This product is made with Primegreen, a series of high-performance recycled materials', b'1', 1, '/file?name=product_azufx.png', 75, 3, 5, 42, 'TRAINING 3-STRIPES AEROREADY TEE', 'BRAND6', 'CATEGORY3', 2),
('bcfpq', '2021-12-03 06:46:50', 'admin', 'admin', '2021-12-03 06:46:50', 'THE FUTURE OF AIR IS HERE.\r\n\r\n\r\nWe could use many superlatives to describe this shoe. We could tell you that the new Air cushioning system offers the most revolutionary feel you have ever experienced. Or say the foam core midsole gives you an amazing,
        super soft feel. But what fun is it to anticipate surprises? Tie your laces and experience the next era of Air. Made with at least 20% recycled materials by weight.\r\n\r\n\r\nRevolutionary comfort\r\n\r\nThe Air-Sole unit is combined with a foldable frame,
        providing a new level of comfort,
        whether you\'re walking 5 miles or heading to the corner store.\r\n\r\n\r\nModern details\r\n\r\nMade with at least 20% recycled materials by weight, the upper includes engineered mesh, woven fabric and seamless leathers for a stylish look that is both durable, lightweight and ventilated.\r\n\r\n\r\nLight cushioning\r\n\r\nThe foam midsole is divided into two sections and features a center (like a honeycomb) for lightweight cushioning that lasts.\r\n\r\n\r\nMore benefits\r\n\r\nThe low cut padded collar looks elegant and feels remarkably good.\r\nMesh accents are combined with floating eyelets for a fresh, quick-fitting look.\r\nOverlays on the sides and heel add durability and depth.\r\n\r\nProduct dates\r\n\r\nReticulated grip clips\r\nRound shoelaces\r\nFull-length rubber outsole\r\nColor Shown: Black / Mystic Red / Cosmic Clay / White\r\nStyle: DH4245-001\r\nCountry / Region of Origin: Vietnam\r\n\r\nNike air max origins\r\n\r\nRevolutionary Air technology was first introduced into Nike footwear in 1978. In 1987, the Nike Air Max 1 debuted with visible Air technology in the heel, providing fans with much more than just the feeling of Air cushioning: this comfort could also be seen. Since then, the latest generation Air Max footwear has become a favorite with athletes and collectors for its attractive color combinations, as well as its lightweight and reliable cushioning.',
        b'1', 1, '/file?name=product_bcfpq.png', 359, 15, 5, 38, 'Nike air max 2021', 'BRAND1', 'CATEGORY2', 1),
       ('bhcsu', '2021-12-03 15:35:07', 'hoanseller', 'admin', '2021-12-04 13:59:51',
        'STAN SMITH SHOES\r\nSTAN SMITH, FOREVER. ALWAYS ICONIC. NOW MORE SUSTAINABLE.\r\nTimeless appeal. Effortless style. Everyday versatility. For over 50 years and counting, adidas Stan Smith Shoes have continued to hold their place as an icon. This pair shows off a fresh redesign as part of adidas\' commitment to use only recycled polyester by 2024. Plus,
        they have an outsole made from rubber waste add to the classic style. This product is made with Primegreen,
        a series of high-performance recycled materials. 50% of upper is recycled content. No virgin polyester.\r\n', b'1', 1, '/file?name=product_bhcsu.png', 239.6, 20, 5, 40, 'STAN SMITH SHOES', 'BRAND2', 'CATEGORY1', 23),
('boglw', '2021-12-03 16:16:09', 'hoanseller', 'user5', '2022-01-27 04:32:10', 'POWER PLAYER.\r\nFeaturing a chunky platform heel with embossed hook-and-loop straps,
        the Chuck Taylor All Star GR82 shoe is equal parts design and utility. A durable, boot - like
                                                                                          upper protects while eye-catching straps keep the fit secure and the look strong. Stunner.\r\nWHY YOU SHOULD BE DOWN\r\n•	CORDURA® fabric is tough,
        but comfortable.\r\n•	Elevated platform heel for added height.\r\n•	Hook-and-loop closure for easy on and off.\r\n•	Embossed straps offer a secure fit.\r\n•	Converse wordmark across ankle strap.\r\n', b'1', 1, '/file?name=product_boglw.png', 110, 30, 5, 44, 'Chuck Taylor All Star GR82', 'BRAND4', 'CATEGORY1', 23),
('bqweh', '2021-12-03 16:38:15', 'datdatdf', 'datdatdf', '2021-12-03 16:38:15', 'Time to step things up. Meet Cali Sport – a bold sneak with a platform sole and crisp color palette....\r\n Style: 371202_03\r\n Color: Puma White-Puma Black\r\n', b'1', 1, '/file?name=product_bqweh.png', 90, 66, 5, 48, 'Cali Sport Mix', 'BRAND3', 'CATEGORY1', 22),
('caanx', '2021-12-03 16:39:20', 'datdatdf', 'datdatdf', '2021-12-03 16:39:20', 'Time to step things up. Meet Cali Sport – a bold sneak with a platform sole and crisp color palette....\r\n Style: 371202_02\r\n Color: Puma White-Marshmallow\r\n', b'1', 1, '/file?name=product_caanx.png', 90, 45, 5, 40, 'Cali Sport Mix', 'BRAND3', 'CATEGORY1', 22),
('cavks', '2021-12-03 15:59:50', 'user1', 'user1', '2021-12-03 15:59:50', 'TURN UP THE HEAT.\r\nThe iconic high top levels up with a double-stacked,
        platform sole to keep you up and out of the elements. Premium suede layers up with a warm, fleece lining,
        maintaining style and warmth from the inside out. With Chuck Taylor All Star standbys, like a diamond toe bumper
        and contrast midsole stripes.EVA cushioning helps keep it comfortable.\r\nWHY YOU SHOULD BE DOWN\r\n• High top
        suede platform sneaker.\r\n• EVA cushioning provides all - day comfort.\r\n• A soft fleece lining keeps it warm
        and cozy.\r\n• A platform outsole ups the height.\r\n• Tonal laces and iconic Chuck Taylor ankle patch.', b' 1
        ', 1, ' / file ? name = product_cavks.png ', 75, 15, 5, 39, ' Chuck Taylor All Star Platform ', ' BRAND4 ', '
        CATEGORY1 ', 2),
(' cjdrt ', ' 2021 - 12 - 03 15 : 58 : 31 ', ' user1 ', ' user1 ', ' 2021 - 12 - 03 15 : 58 : 31 ', ' RENOVATED \'70S STYLE.\r\n\r\n\r\n\r\nFollowing in the legendary footsteps of the original from \'
        79,
        the Nike DBreak SE gives your athletic look the finish of a champion. Bring the past with the present by combining the exquisite feel of old-school suede with ventilated textile materials. Waffle rubber outsole maintains its retro appeal. Animal print details make this a wild design.\r\n\r\n\r\n\r\nProfits\r\nSuede on the upper adds an athletic-inspired retro look.\r\nLightweight woven woven fabric keeps you cool and airy.\r\nFoam midsole offers lightweight cushioning and a soft feel.\r\nInspired by the 1979 icon,
        the waffle rubber outsole adds traction, durability and
                                                 classic style.\r\n\r\n\r\n\r\nProduct dates\r\nStitched Swoosh logo\r\nDesign based on Blue Ribbon\'s heritage running sports shoes.\r\nColor Shown: White / Particle Gray / Black / Summit White\r\nStyle: DM3346-101\r\nCountry / Region of Origin: Indonesia\r\n',
        b'1', 1, '/file?name=product_cjdrt.png', 191, 69, 5, 40, 'Nike DBreak SE', 'BRAND1', 'CATEGORY2', 2),
       ('cvgdj', '2021-12-03 15:54:12', 'user1', 'user1', '2021-12-03 15:54:12',
        'A classic swim silhouette takes on a bold new look with a sporty scoop neckline and plush velvet fabric designed for the beach and beyond. \r\n•	One-piece swimsuit\r\n•	Removable pads\r\n•	Wireless\r\n•	Scoop neckline\r\n•	Moderate back coverage: shows a little, but not all\r\n•	Hand wash\r\n•	Imported',
        b'1', 1, '/file?name=product_cvgdj.png', 69, 3, 5, 42, 'Velvet One-Piece', 'BRAND7', 'CATEGORY3', 2),
       ('cvghf', '2021-12-03 15:56:07', 'user1', 'user1', '2021-12-03 15:56:07',
        'The Suede hit the scene in 1968 and has been changing the game ever since. It’s been worn by the icons of every generation and it’s stayed classic through it all. This year, w...\r\n Style: 374915_31\r\n Color: Green Gables-Intense Red-Puma White\r\n',
        b'1', 1, '/file?name=product_cvghf.png', 79, 40, 5, 39, 'Suede Classic XXI', 'BRAND3', 'CATEGORY2', 2),
       ('cwyrs', '2021-12-03 16:00:05', 'user1', 'user1', '2021-12-03 16:00:05',
        'Get your tricolour on in the Suede Triplex Sneakers. This new addition to the iconic Suede family takes our influential 1960s silhouette and spruces it up with a triple Formst...\r\n Style: 381175_13\r\n Color: Peacoat-Maize-Puma White\r\n',
        b'1', 1, '/file?name=product_cwyrs.png', 80, 21, 5, 38, 'Suede Triplex Sneakers', 'BRAND3', 'CATEGORY2', 2),
       ('dxmgv', '2021-12-03 15:38:38', 'user1', 'user1', '2021-12-03 15:38:38',
        'LEGENDARY AND REFINED STYLE.\r\n\r\n\r\n\r\nThe glow lives on in the Nike Air Force 1 \'07,
        the basketball icon that puts a fresh twist on the most remembered features: bold colors and the perfect amount of sparkles to make you shine.\r\n\r\n\r\n\r\nProfits\r\nLeather overlays on the upper add traditional style with durability and support.\r\nOriginally designed for basketball,
        Nike Air cushioning adds lightweight, all- day comfort.\r\nThe low - profile style offers a sleek,
        streamlined look.\r\nThe padded ankle area is soft and comfortable.\r\n\r\n\r\n\r\nProduct dates\r\nFoam midsole\r\nPerforations in the tip\r\nColor Shown: White / White / White / White\r\nStyle: DD8959-100\r\nCountry / Region of Origin: Vietnam\r\n\r\n\r\n\r\nOrigins of Air Force 1\r\nFollowing its debut in 1982,
        the AF1 revolutionized the sport by becoming the first basketball shoe to feature the Nike Air system. In addition,
        it did not take long to gain acceptance around the world. Today,
        the Air Force 1 remains true to its origins with the same soft,
        springy cushioning that changed the course of shoe history.\r\n', b'1', 1, '/file?name=product_dxmgv.png', 209, 70, 5, 40, 'Nike Air Force 1 \'07',
        'BRAND1', 'CATEGORY2', 2),
       ('dymvq', '2021-12-03 15:35:39', 'user1', 'user1', '2021-12-03 15:35:39',
        'SPORT-INSPIRED DESIGN WITH A TOUCH OF SERENA WILLIAMS.\r\n\r\n\r\n\r\nYou don\'t need 3D glasses to see the texture of this multidimensional shoe. Celebrating athlete Serena and fashion icon Serena,
        details include a top you\'ll want to touch, serrated edges and 4 gold grommets that pay tribute to their medals. The SDC \"10 4 01\" logo on the tongue represents the designers that she herself chose to create a collection that allows you to enter her world and feel like an extraordinary star.\r\n\r\n\r\n\r\nSport on the catwalk\r\nDetails celebrate the link between sport and fashion, including gold grommets representing Serena\'s gold medals,
        sawtooth edging for catwalk brilliance, and 23 points on the Swoosh symbolizing her titles in the tennis.\r\n\r\n\r\n\r\nCelebrate
        the heritage\r\nThe leather on the upper adds elegance while the rich texture is made to show off.\r\n\r\n\r\n\r\nLong
        live the diversity\r\nThe authentic SDC label on the tongue with the \"10 4 01\" logo pays tribute to diversity and inclusion (for more information, see the declaration of origin).\r\n\r\n\r\n\r\nMore benefits\r\nThe tennis-inspired upper has a durable finish and a large retro Swoosh.\r\nVulcanized construction links the sole to the midsole for a long-lasting, streamlined look.\r\nThe low cut neckline streamlines the ankle and feels great.\r\nThe full-length rubber outsole has a graphic herringbone pattern that provides traction on different surfaces and adds a traditional style.\r\n\r\n\r\n\r\nProduct dates\r\nSoft foam insole\r\nClassic Swoosh plaque on back heel tape\r\nMetal eyelets\r\nWoven SDC label on tongue\r\nColor Shown: Black / Metallic Gold / Summit White\r\nStyle: DJ1454-001\r\nCountry / Region of Origin: Indonesia\r\n\r\n\r\n\r\nSerena Design Crew\r\nCelebrating diversity and inclusion, the Serena Design Crew is a group of emerging designers from New York City selected by Serena Williams. These 10 designers created a footwear and apparel collection that tells the story of Serena\'s incredible legacy, both on and off the court, while paying tribute to the diverse backgrounds and rich culture of each designer.\r\n', b'1', 1, '/file?name=product_dymvq.png', 179, 80, 5, 40, 'Nike Court Legacy Serena Design Crew', 'BRAND1', 'CATEGORY2', 2),
       ('ecdvl', '2021-12-03 16:16:17', 'tienseller', 'tienseller', '2021-12-03 16:16:17',
        'MARIMEKKO AEROKNIT LONG LINE BRA\r\nA LIGHT-SUPPORT BRA WITH A SNUG, SUPPORTIVE FEEL.\r\nYour Vinyasa feels seamless. Your sports bra should feel the same way. This light-support bra shows off an eye-catching Marimekko design on soft, textured material, uniting fashion with function. Targeted power mesh zones and adidas Aeroknit with moisture-absorbing AEROREADY keep you feeling dry and confident as you flow through your movements. This product is made with Primegreen, a series of high-performance recycled materials.\r\n',
        b'1', 1, '/file?name=product_ecdvl.png', 105, 3, 5, 42, 'MARIMEKKO AEROKNIT LONG LINE BRA', 'BRAND6',
        'CATEGORY3', 26),
        ('ekjex', '2021-12-03 15:42:00', 'user1', 'admin', '2021-12-05 01:59:11',
         'CLASSIC AND FUN.\r\nNike Basketball features a new collection of apparel inspired by the fun Lil \'Penny commercials of yesteryear, and
         this is the t - shirt to match . It\
         's made from soft, comfortable cotton and features a collection graphic.\r\nProfits\r\n•	Cotton fabric feels soft and light for every day.\r\n•	The fit is loose and comfortable.\r\n',
         b'1', 1, '/file?name=product_ekjex.png', 59, 3, 5, 42, 'Nike Lil\' Penny', 'BRAND1', 'CATEGORY3', 2),
('emiew', '2021-12-03 15:30:51', 'user1', 'user1', '2021-12-03 15:30:51', 'DURAMO SL SHOES\r\nCOMFORTABLE RUNNING SHOES THAT KEEP YOU LIGHT ON YOUR FEET.\r\nCommit to getting faster one run at a time. A mesh upper and soft neoprene heel give these adidas running shoes a technical look and a comfortable,
         supportive fit. When you\'re ready to accelerate, the lightweight Lightmotion midsole is ready to respond.\r\n',
         b'1', 1, '/file?name=product_emiew.png', 79, 20, 5, 39, 'DURAMO SL SHOES', 'BRAND2', 'CATEGORY2', 2),
        ('espdw', '2021-12-03 15:46:40', 'user1', 'user5', '2021-12-04 14:04:52',
         'WE MAKE THE SHOE. YOU MAKE THE STORIES.\r\nWe could tell you that it’s the OG basketball shoe, created over 100 years ago. Or that the design has largely stayed the same, because why mess with a good thing. Or how it became the unofficial sneaker of all your favorite artists and musicians, who each made it their own. Yeah, we could share a lot of stories, but the one that matters most isn’t ours—it’s yours. It’s how and where you take your Chucks. The legacy is long, but what comes next is up to you. We just make the shoe. You make the stories.\r\nWHY YOU SHOULD BE DOWN\r\nCanvas upper is lightweight and durable.\r\nThe timeless silhouette you know and love.\r\nHigh profile for classic coverage.\r\nMedial eyelets enhance airflow.\r\nClassic All Star ankle patch.\r\nCHUCK TAYLOR ALL STAR ORIGINS\r\nCreated in 1917, the Chuck Taylor All Star sneaker was the original basketball shoe. Its use has changed over the years, but it’s still perfect in its simplicity. With its timeless silhouette, vulcanized rubber sole and unmistakable ankle patch, the Chuck is ready for you to make it your own.\r\n',
         b'1', 1, '/file?name=product_espdw.png', 60, 8, 5, 38, 'Chuck Taylor All Star', 'BRAND4', 'CATEGORY2', 2),
        ('ezwpu', '2021-12-03 15:50:53', 'user1', 'user1', '2021-12-03 15:50:53',
         'A RENOVATED COURT ICON FOR THE STREET.\r\n\r\n\r\n\r\nThe Nike Court Legacy Canvas pays tribute to a history rooted in tennis culture and brings you a classic with a modern, urban design. Made with durable canvas, heritage stitching and a retro Swoosh design, it allows you to combine sport and fashion.\r\n\r\n\r\n\r\nProfits\r\nThe tennis-inspired upper can be worn anywhere and features a durable canvas and retro Swoosh logo.\r\nThe autoclave construction fuses the sole with the midsole for a simple look, while the low-cut collar molds to the ankle for a comfortable feel.\r\nFull-length rubber outsole with herringbone pattern provides multi-surface traction and heritage style.\r\n\r\n\r\n\r\nProduct dates\r\nSoft foam insole\r\nClassic Swoosh license plate on back heel tape\r\nMetal eyelets\r\nColor Shown: Oxford Pink / Light Soft Pink / Black / White\r\nStyle: CZ0294-602\r\nCountry / Region of Origin: Vietnam\r\n',
         b'1', 1, '/file?name=product_ezwpu.png', 129, 70, 5, 39, 'Nike Court Legacy Canvas', 'BRAND1', 'CATEGORY1', 2),
        ('fbeps', '2021-12-03 15:48:58', 'hoanseller', 'hoanseller', '2021-12-03 15:48:58',
         'ZX 1K BOOST SHOES\r\nDISTINCTIVE TRAINERS WITH UPGRADED CUSHIONING.\r\nThe ZX series entered the scene in the \'80s and took hold of running culture with its groundbreaking approach to speed. These adidas ZX 1K Boost Shoes might not be about performance anymore,
         but that doesn\'t mean they\'re slowing down. Forever forward focused,
         the progressive silhouette doubles up on comfort with a plush Boost and EVA midsole combo. The mesh upper is accented with synthetic overlays. This product is made with recycled content as part of our ambition to end plastic waste. 20% of pieces used to make the upper are made with minimum 50% recycled content.\r\n\r\n\r\n', b'1', 1, '/file?name=product_fbeps.png', 359, 15, 5, 44, 'ZX 1K BOOST SHOES', 'BRAND2', 'CATEGORY1', 23),
('fguyq', '2021-12-03 15:53:32', 'user1', 'user1', '2021-12-03 15:53:32', 'Bring the glamour with you when you splash in this one-piece,
         cut with a bold high leg and plunging neckline and finished with glittering shine straps.\r\n•	Lined\r\n•	Wireless\r\n•	Plunge neckline\r\n•	High-cut leg\r\n•	Shine straps and waistband\r\n•	Adjustable crossback straps\r\n•	Minimal back coverage,
         lots of cheek peek\r\n•	Hand wash\r\n•	Imported', b'1', 1, '/file?name=product_fguyq.png', 99, 3, 5, 42, 'Shine Strap Montanita Plunge One-piece', 'BRAND7', 'CATEGORY3', 2),
('fjjrt', '2021-11-28 08:52:05', 'user1', 'admin', '2021-12-03 06:24:19', 'LEGENDARY STYLE REFINED.\r\n\r\nThe radiance lives on in the Nike Air Force 1 \'07, the b-ball OG that puts a fresh spin on what you know best: durably stitched overlays, clean finishes and the perfect amount of flash to make you shine.\r\n\r\nBenefits\r\n\r\nThe stitched overlays on the upper add heritage style, durability and support.\r\nOriginally designed for performance hoops, the Nike Air cushioning adds lightweight, all-day comfort.\r\nThe low-cut silhouette adds a clean, streamlined look.\r\nThe padded collar feels soft and comfortable.\r\n\r\nProduct Details',
         b'1', 1, '/file?name=product_fjjrt.png', 75, 16, 5, 42, 'Nike Air Force 1 \'08 ', 'BRAND1', 'CATEGORY1', 2),
('fnjgj', '2021-12-03 15:29:59', 'user1', 'user1', '2021-12-03 15:29:59', 'ULTRABOOST 22 SHOES\r\nICONIC RUNNING SHOES MADE IN PART WITH PARLEY OCEAN PLASTIC.\r\nA little extra push. The Ultraboost running shoes serve up comfort and responsiveness at every pace and distance. The adidas PRIMEKNIT upper includes foam around the heel to prevent blisters. You\'ll be riding on a BOOST midsole for endless energy, with a Linear Energy Push system for more responsiveness than ever before. A Continental™ Rubber outsole grips in wet and dry conditions so you can stride confidently. This shoe\'s upper is made with a high-performance yarn which contains at least 50% Parley Ocean Plastic —  reimagined plastic waste,
         intercepted on remote islands, beaches, coastal communities and shorelines,
         preventing it from polluting our ocean. The other 50% of the yarn is recycled polyester.\r\n', b'1', 1, '/file?name=product_fnjgj.png', 300, 20, 5, 39, ' ULTRABOOST 22 SHOES', 'BRAND2', 'CATEGORY2', 2),
('fyzhf', '2021-12-03 15:34:32', 'hoanseller', 'hoanseller', '2021-12-03 15:34:32', 'ULTRABOOST 20 X JAMES BOND SHOES\r\nENERGY-RETURNING RUNNING SHOES INSPIRED BY JAMES BOND\'S NEWEST NEMESIS.\r\nTo celebrate the release of the 25th James Bond film, \"No Time to Die,\" adidas created these running shoes inspired by Safin, the newest Bond villain. A print gives the foot-hugging knit upper the look of rough concrete. The porcelain-look cage mimics Safin\'s porcelain mask. The blueprint of his zen garden is printed on the sockliner.\r\n\r\n\r\n', b'1', 1, '/file?name=product_fyzhf.png', 699, 15, 5, 39, 'ULTRABOOST 20 X JAMES BOND SHOES', 'BRAND2', 'CATEGORY1', 23),
('gcktk', '2021-12-03 15:50:40', 'user1', 'user1', '2021-12-03 15:50:40', 'SHATTER THE MOLD.\r\nBreak from convention with the DRKSTAR Chuck 70,
         created by Rick Owens. The subversive design both celebrates and distorts the lines of our best-ever silhouette—literally stretching the possibilities with an elongated tongue and signature DRKSHDW toe cap. The cotton-twill upper and refined finishes add polish and couture-like sophistication to the design’s edgy look and exaggerated features. It’s the bold reinvention of a street classic. And a rebellion against the ubiquitous. Rick Owens crafts a Chuck 70 unlike any other.\r\nWHY YOU SHOULD BE DOWN\r\nLimited-edition high-top sneaker designed by Rick Owens with a waxed cotton twill upper\r\nThe timeless silhouette distorted with a rebellious spin\r\nMolded rubber dual toe design featuring DRKSHDW toe cap and molded rubber heel component\r\nBold elongated tongue emphasizes the distinct style of classic Chucks\r\nCustom DRKSHDW license plate and wrap around DRKSTAR woven label\r\n', b'1', 1, '/file?name=product_gcktk.png', 170, 17, 5, 38, 'Converse x DRKSHDW', 'BRAND4', 'CATEGORY2', 2),
('giypn', '2021-12-03 15:34:24', 'tienseller', 'admin', '2021-12-05 01:59:30', 'STACKED STYLE AND COMFORT.\r\nCrafted to layer with other garments comfortably,
         the Nike Sportswear Sport Essentials + Crewneck Sweatshirt offers a new take on a favorite fleece model. The mix of embroidered Futura logos adds a bright and playful look to the semi-brushed French Terry fleece construction. .\r\nA lucky accident\r\nA wise man once said, “
         There are no mistakes, just lucky accidents.” When the samples came back with a lucky little accident,
         we decided to go ahead with what we had. The stacked Swoosh is the result of a small mistake that became the which we think is a big win.\r\nEmbroidered Futura logos\r\nThe embroidered logo mix features stacked Futura logo clusters on the chest and below the back of the neck, as
         well as logos above the hem and left wrist .\ r\ nSemi - brushed fleece fabric\ r\ nThis French Terry fleece
         fabric features a smooth surface and a brushed loop design for extra warmth and softness .\ r\ nMore benefits\
         r\ nThe ribbed hem and cuffs provide a comfortable fit to wear with other layers,
         which is also perfect for everyday wear.', b'1', 1, '/file?name=product_giypn.png', 149, 3, 5, 42, 'Nike Sportswear Sport Essentials+', 'BRAND5', 'CATEGORY3', 26),
('gkaxf', '2021-11-28 08:47:45', 'user1', 'user1', '2021-11-28 08:50:07', 'LEGENDARY STYLE REFINED.\r\n\r\nThe radiance lives on in the Nike Air Force 1 \'07, the b-ball OG that puts a fresh spin on what you know best: durably stitched overlays, clean finishes and the perfect amount of flash to make you shine.\r\n\r\nBenefits\r\n\r\nThe stitched overlays on the upper add heritage style, durability and support.\r\nOriginally designed for performance hoops, the Nike Air cushioning adds lightweight, all-day comfort.\r\nThe low-cut silhouette adds a clean, streamlined look.\r\nThe padded collar feels soft and comfortable.\r\n\r\nProduct Details',
         b'1', 1, '/file?name=product_gkaxf.png', 65, 10, 5, 40, 'Nike Air Force 1 \'07 ', 'BRAND1', 'CATEGORY2', 2),
('gkzpl', '2021-12-03 15:51:22', 'user1', 'user1', '2021-12-03 15:51:22', 'Escape the winter chill with this ruched,
         wireless top in patterns worth melting for. Its straps can be worn around the neck, crisscrossed, or tied
         together in front .\ r\ n• Removable padding\ r\ n• Wireless\ r\ n• Convertible halter straps\ r\ n• Adjustable
         tie back\ r\ n• Logo charm details\ r\ n• Hand wash\ r\ n• Imported ', b' 1 ', 1, ' / file ? name =
         product_gkzpl . png ', 34, 3, 5, 42, ' Ice Queen Printed Halter Swim Top ', ' BRAND7 ', ' CATEGORY3 ', 2),
(' gqfxl ', ' 2021 - 12 - 03 16 : 00 : 21 ', ' user1 ', ' user1 ', ' 2021 - 12 - 03 16 : 00 : 21 ', ' A lightweight
         crochet knit that\
         's perfect for layering over your favorite swim look. \r\nFOR LOVE & LEMONS FOR VICTORIA’S SECRET: An exclusive collaboration that blends dreamy confidence with thoughtful detailing, giving each piece a unique and feminine feel.\r\n•	Swim cover-up\r\n•	Tank dress\r\n•	Tie-front closure\r\n•	Hand wash\r\n•	Imported',
         b'1', 1, '/file?name=product_gqfxl.png', 153, 3, 5, 42, 'Crochet Dress Cover-up', 'BRAND7', 'CATEGORY3', 2),
        ('gvkyd', '2021-12-03 16:11:22', 'hoanseller', 'hoanseller', '2021-12-03 16:11:22',
         'Double-stacked platforms get all warmed up for winter. We updated the iconic high top with durable leather to protect you from the elements and a soft Sherpa lining to keep you warm. Fuzzy laces and hits of suede play up the cozy factor, while subtle \"Perfect is not perfect\" prints at the inner-tongue and heel bring an empowering message everywhere you go.\r\nWHY YOU SHOULD BE DOWN\r\n•	High top leather extra-high platform sneaker.\r\n•	EVA cushioning provides all-day comfort.\r\n•	A cozy Sherpa lining helps you stay warm.\r\n•	\"Perfect is not perfect\" message at heel and inside tongue.\r\n•	Iconic Chuck Taylor ankle patch.\r\n',
         b'1', 1, '/file?name=product_gvkyd.png', 85, 15, 5, 39, 'Cozy Tones 2X', 'BRAND4', 'CATEGORY1', 23),
        ('gvuvl', '2021-12-03 15:36:23', 'user1', 'user1', '2021-12-03 15:36:23',
         'ALPHAMAGMA SHOES\r\nWORKOUT SHOES FOR EVERY DAY.\r\nFrom lifting to boxing to bootcamp classes. These adidas training shoes keep you comfortable, whatever your workout of choice. The lightweight textile upper is reinforced at the toe and heel. The Bounce midsole provides flexibility on the move.\r\n',
         b'1', 1, '/file?name=product_gvuvl.png', 300, 30, 5, 45, 'ALPHAMAGMA SHOES', 'BRAND2', 'CATEGORY2', 2),
        ('gzbxo', '2021-11-28 09:19:57', 'user1', 'admin', '2021-12-03 07:04:36',
         'LEGENDARY STYLE REFINED.\r\n\r\nThe radiance lives on in the Nike Air Force 1 \'07,
         the b-ball OG that puts a fresh spin on what you know best: durably stitched overlays,
         clean finishes and the perfect amount of flash to make you shine.\r\n\r\nBenefits\r\n\r\nThe stitched overlays on the upper add heritage style,
         durability and support.\r\nOriginally designed for performance hoops,
         the Nike Air cushioning adds lightweight, all - day comfort .\ r\ nThe low - cut silhouette adds a clean,
         streamlined look.\r\nThe padded collar feels soft and comfortable.\r\n\r\nProduct Details', b'1', 0, '/file?name=product_gzbxo.png', 100, 37, 5, 38, 'Nike Air Force 1.5 WB', 'BRAND1', 'CATEGORY2', 2),
('gzqxl', '2021-12-03 16:36:16', 'datdatdf', 'datdatdf', '2021-12-03 16:36:16', 'In the late 1970s,
         Argentinean tennis player Guillermo Vilas went on a title-winning rampage. Known for his one-handed backhand and off-the-court charm,
         he paired with PUMA to...\r\n Style: 366613_06\r\n Color: Puma White-Peacoat\r\n', b'1', 1, '/file?name=product_gzqxl.png', 70, 70, 5, 33, 'GV Special+ Sneakers', 'BRAND3', 'CATEGORY1', 22),
('hccjs', '2021-12-03 15:52:21', 'user1', 'user1', '2021-12-03 15:52:21', 'INNOVATIVE CUSHIONING,
         MORE COMFORTABLE THAN EVER.\r\n\r\n\r\n\r\nThe Nike Air Zoom SuperRep 2 with polka dot details is designed for circuit workouts,
         HIIT(high intensity interval) workouts, sprints and
                                                 other fast-paced workouts. Layers of support meet with Zoom Air cushioning to keep your foot on the ground. Secure and comfortable as you stride and jump and beat every rep. The roomier design around the fingers allows you to get the perfect fit.\r\n\r\n\r\n\r\nA design made for comfort\r\nThis version has a fully adjustable tongue that allows you to put the shoe on,
         adjust it and give it everything you have in your training.Another update is the wide forefoot design that provides comfort for different types of feet.\r\n\r\n\r\n\r\nCushioned tread\r\nEvery time you land on the forefoot,
         two powerful Zoom Air units absorb energy and immediately return it to take you to the next step or jump. A full-length plate distributes energy and balances the foot.\r\n\r\n\r\n\r\nSide by side support\r\nThe large lateral arch acts as a reinforcement for the foot when you cut hard from side to side. The welt mesh on the upper,
         stitched and tighter in this version,
         helps keep the foot secure during movements such as jumping and jumping. lateral strides.\r\n\r\n\r\n\r\nFlexibility on the floor\r\nThe split just below the natural flex point allows the foot to flex effortlessly so you can maintain stability during the plank and to make climbers and burpees a breeze.\r\n\r\n\r\n\r\nMore benefits\r\nOpen mesh lining allows airflow to keep your foot cool.\r\nThe grooved outsole encourages natural movement in all directions.\r\nRubber accents in key areas provide durable traction.\r\nColor Shown: Platinum Tint / Light Bone / Total Orange / Dark Smoke Gray\r\nStyle: DH3383-091\r\nCountry / Region of Origin: Vietnam\r\n', b'1', 1, '/file?name=product_hccjs.png', 191, 87, 5, 39, 'Nike Air Zoom SuperRep 2', 'BRAND1', 'CATEGORY2', 2),
('hcepf', '2021-12-03 16:32:00', 'datdatdf', 'datdatdf', '2021-12-03 16:32:00', 'TRADITIONAL STYLE. MODERN COMFORT.\r\n\r\n\r\n\r\nClean,
         versatile and
         timeless lines. People\'s footwear makes a comeback with the Nike Air Max 90. With the same iconic waffle sole, stitched overlays and classic TPU details you\'ve come to love,
         it lets you walk through the pantheon of Air.\r\n\r\n\r\n\r\nLow profile style\r\nThe low-profile design is combined with a padded collar for a stylish look that feels soft and comfortable.\r\n\r\n\r\n\r\nHigh performance comfort\r\nOriginally designed for high-performance running,
         the Max unit adds incredible cushioning.\r\n\r\n\r\n\r\nNike DNA\r\nRubber waffle outsole provides traction,
         durability and heritage style.\r\n\r\n\r\n\r\nRetro appeal\r\nStitched overlays and TPU details add durability,
         comfort, and the iconic \
         '90s look you love.\r\n\r\n\r\n\r\nProfits\r\nFoam midsole adds durable cushioning.\r\nColor Shown: White / White / Wolf Gray / White\r\nStyle: CQ2560-100\r\nCountry / Region of Origin: Vietnam, Indonesia\r\n',
         b'1', 1, '/file?name=product_hcepf.png', 233, 80, 5, 39, 'Nike Air Max 90', 'BRAND1', 'CATEGORY2', 22),
        ('hheer', '2021-12-03 15:55:30', 'user1', 'user1', '2021-12-03 15:55:30',
         'Channel laid-back, sunny West Coast vibes in this stand-out edition of the classic Suede, inspired by Santa Cruz Skateboard. Dating back to the 1970s, this skateboard company ...\r\n Style: 381905_01\r\n Color: Puma Black-Green Flash-Deep Wisteria\r\n',
         b'1', 1, '/file?name=product_hheer.png', 110, 24, 5, 39, 'PUMA x SANTA CRUZ Suede Shark', 'BRAND3',
         'CATEGORY2', 2),
        ('hjyyv', '2021-12-03 16:34:06', 'datdatdf', 'datdatdf', '2021-12-03 16:34:06',
         'A sport style turned street classic, the California is one of PUMA’s most iconic silhouettes. We’ve updated the California for the next generation to create the Cali. Taking c...\r\n Style: 369155_04\r\n Color: Puma White-Puma Black\r\n',
         b'1', 1, '/file?name=product_hjyyv.png', 80, 66, 5, 38, 'Cali Women\'s Sneakers', 'BRAND3', 'CATEGORY1', 22),
('hmvzh', '2021-12-03 15:55:12', 'user1', 'user1', '2021-12-03 15:55:12', 'TRAIN IN THE CITY.\r\n\r\n\r\n\r\nThe Nike City Rep TR is a versatile shoe that adds durability and flexibility to your active lifestyle. The rubber outsole provides grip on different types of surfaces,
         while the foam cushioning maintains comfort in outdoor workouts and in everything you put your mind to.\r\n\r\n\r\n\r\nStrong on the top\r\nThe upper is durable thanks to being reinforced with overlays to cope with the demands of outdoor workouts.\r\n\r\n\r\n\r\nComfort on the sole of the foot\r\nFoam cushions your footprint for long-lasting comfort from quick workouts to the rest of the day.\r\n\r\n\r\n\r\nDurable at the bottom\r\nRubber tread pattern provides traction on a variety of surfaces. Arches on the sides provide durability where it is needed during planking and lateral movements.\r\n\r\n\r\n\r\nProduct dates\r\nHeel grip loop\r\nEmbossed logo on the tongue\r\nColor Shown: Black / Cave Purple / Lilac / Hyper Pink\r\nStyle: DA1351-014\r\nCountry / Region of Origin: Indonesia\r\n', b'1', 1, '/file?name=product_hmvzh.png', 149, 70, 5, 40, 'Nike City Rep TR', 'BRAND1', 'CATEGORY2', 2),
('hvbop', '2021-11-28 09:18:04', 'user1', 'admin', '2021-12-03 07:04:54', 'LEGENDARY STYLE REFINED.\r\n\r\nThe radiance lives on in the Nike Air Force 1 \'07, the b-ball OG that puts a fresh spin on what you know best: durably stitched overlays, clean finishes and the perfect amount of flash to make you shine.\r\n\r\nBenefits\r\n\r\nThe stitched overlays on the upper add heritage style, durability and support.\r\nOriginally designed for performance hoops, the Nike Air cushioning adds lightweight, all-day comfort.\r\nThe low-cut silhouette adds a clean, streamlined look.\r\nThe padded collar feels soft and comfortable.\r\n\r\nProduct Details',
         b'1', 0, '/file?name=product_hvbop.png', 95, 32, 5, 41, 'Nike Air Force 2', 'BRAND1', 'CATEGORY2', 2),
        ('hvijb', '2021-12-03 07:00:05', 'admin', 'admin', '2021-12-03 07:00:05',
         'THE LEGENDARY AIR RISES.\r\n\r\n\r\nNike\'s first Lifestyle Air Max brings you style, comfort and
                                                                                                great attitude in the Nike Air Max 270. The design is inspired by classic Air Max icons and showcases Nike\'s greatest innovation with its large window and new assortment of colors.\r\n\r\n\r\nProfits\r\n\r\nThe Max Air 270 unit provides unmatched comfort throughout the day.\r\nThe sleek running-inspired design roots you in everything Nike.\r\nWoven and synthetic fabric on the upper provides a lightweight fit and feel.\r\nFoam midsole feels soft and comfortable.\r\nStretch inner sleeve and bootie-like construction create a custom fit.\r\nRubber on the outsole provides traction and durability.\r\n\r\nProduct dates\r\n\r\nMesh details provide a fresh feel\r\nSynthetic material and fabric\r\n2-piece midsole\r\nColor Shown: Black / White / Solar Red / Anthracite\r\nStyle: AH8050-002\r\nCountry / Region of Origin: Vietnam, Indonesia, China\r\n\r\nOrigins of the Nike Air Max\r\n\r\nRevolutionary Air technology was first introduced into Nike footwear in 1978. In 1987, the Nike Air Max 1 debuted with visible Air technology in the heel, providing fans with much more than just the feeling of Air cushioning: this comfort could also be seen. Since then, the latest generation Air Max footwear has become a favorite with athletes and collectors for its attractive color combinations, as well as its lightweight and reliable cushioning.',
         b'1', 1, '/file?name=product_hvijb.png', 319, 15, 5, 39, 'Nike Air Max 270', 'BRAND1', 'CATEGORY2', 1),
        ('icstz', '2021-12-03 15:58:42', 'user1', 'user1', '2021-12-03 15:58:42',
         'The Suede Gum Trainers take classic to a whole new level. The original PUMA Suede first hit the scene in 1968, and has been sported by iconic figures from every decade and gen...\r\n Style: 381174_01\r\n Color: Puma Black-Gum\r\n',
         b'1', 1, '/file?name=product_icstz.png', 70, 40, 5, 40, 'Suede Gum Sneakers', 'BRAND3', 'CATEGORY2', 2),
        ('iipfk', '2021-12-03 15:37:45', 'hoanseller', 'hoanseller', '2021-12-03 15:37:45',
         'ULTRABOOST 20 X JAMES BOND SHOES\r\nHIGH-PERFORMANCE RUNNING SHOES FOR JAMES BOND FANS.\r\nAlways impeccably dressed but never afraid to get dirty, James Bond is the quintessential gentleman spy. These adidas running shoes are inspired by the action scenes in the 25th Bond film, \"No Time to Die.\" A print on the responsive cushioning gives it the look of forged carbon. An image from the movie is depicted on the sockliner. Hidden pockets inside the cage mean it\'s Q Branch approved.\r\n', b'1', 1, '/file?name=product_iipfk.png', 899, 15, 5, 39, 'ULTRABOOST 20 X JAMES BOND SHOES', 'BRAND2', 'CATEGORY1', 23),
('ivfcw', '2021-12-03 16:10:34', 'tienseller', 'admin', '2021-12-04 13:45:55', 'BELIEVE THIS MEDIUM-SUPPORT WORKOUT LOGO BRA\r\nA MEDIUM-SUPPORT PULLOVER BRA WITH REMOVABLE PADS.\r\nYou might not think you can do one more rep,
         but you can. You might not think you can climb that last hill,
         but you will. This adidas training bra provides medium support for challenging sessions. AEROREADY wicks moisture to keep you feeling dry. Workout complete, next
         level unlocked . ', b' 1 ', 1, ' / file ? name = product_ivfcw . png ', 95.3, 3, 5, 42, ' BELIEVE THIS MEDIUM -
         SUPPORT WORKOUT LOGO BRA ', ' BRAND6 ', ' CATEGORY3 ', 26),
(' ivxzv ', ' 2021 - 12 - 03 15 : 38 : 29 ', ' user1 ', ' user1 ', ' 2021 - 12 - 03 15 : 38 : 29 ', ' STAN SMITH SHOES\
         r\ nCHIC STAN SMITH SHOES BURSTING WITH \
         '70S ATTITUDE.\r\nAlways stand up for what you believe in. Inspired by the spirit of the \' 70s and the changes
         that occurred during that pivotal decade,
         these adidas Stan Smith Shoes show off a vintage-looking colour-shifting heel tab. The textile upper and redesigned tongue label add modern appeal to this classic silhouette. This product is made with Primegreen,
         a series of high-performance recycled materials. 50% of upper is recycled content. No virgin polyester.\r\n', b'1', 1, '/file?name=product_ivxzv.png', 250, 12, 5, 39, ' STAN SMITH SHOES', 'BRAND2', 'CATEGORY2', 2),
('jmdox', '2021-12-03 15:50:01', 'user1', 'user1', '2021-12-03 15:50:01', 'WARMED-UP COMFORT.\r\nWith its translucent midsole wrap,
         the Chuck Taylor All Star CX gives you a window into our comfort-first high top. Complete with classic Chuck Taylor All Star style, like
         a rubber toe bumper and toe cap, iconic lace-up design, and license plate,
         this high top comes updated with our revolutionary CX foam comfort midsole and synthetic stretch-canvas upper that moves with you. Plus,
         a soft fleece lining backs the upper for extra warmth.\r\nWHY YOU SHOULD BE DOWN\r\nHigh-top shoe with stretch canvas upper backed with low-pile fleece lining for flexible warmth\r\nCX foam sockliner and IU outsole for comfort\r\nTranslucent foxing tape and visible midsole for comfort you can see\r\nClassic star ankle patch for a dose of Converse DNA\r\nHeel pull tab for easy on and off\r\n', b'1', 1, '/file?name=product_jmdox.png', 80, 30, 5, 42, 'Chuck Taylor All Star CX Fleece Lined', 'BRAND4', 'CATEGORY2', 2),
('jmqml', '2021-12-03 15:27:06', 'user1', 'user1', '2021-12-03 15:27:06', 'FORUM LOW SHOES\r\nTHE B-BALL STATUS SHOE IN LOW TOP FORM.\r\nMore than just a shoe,
         it\'s a statement. The adidas Forum hit the scene in \' 84 and gained major love on both the hardwood and in
         the music biz . This pair of the classic shoes brings back the \
         '80s attitude, the explosive hardwood energy and the iconic X-strap ankle design, distilled into a low top version meant for the streets.\r\n',
         b'1', 1, '/file?name=product_jmqml.png', 143, 4, 5, 42, 'FORUM LOW SHOES', 'BRAND2', 'CATEGORY2', 2),
        ('jqfst', '2021-12-03 15:32:19', 'user1', 'user1', '2021-12-03 15:32:19',
         'LITE RACER 3.0 SHOES\r\nRUNNING-INSPIRED SHOES MADE FOR EVERYDAY COMFORT AND STYLE.\r\nWalking is an essential part of daily life. Comfort should be too. Enjoy every step you take in these adidas shoes. Inspired by classic running shoes, they have plush Cloudfoam cushioning and a snug fit. Plus, 3-Stripes style. Do you even need any other shoes?\r\n',
         b'1', 1, '/file?name=product_jqfst.png', 79, 21, 5, 44, ' LITE RACER 3.0 SHOES', 'BRAND2', 'CATEGORY2', 2),
        ('keoiw', '2021-12-03 15:55:59', 'user1', 'user1', '2021-12-03 15:55:59',
         'Ultra-roomy sleeves and a below-the-knee length give this beautifully draped cover-up the dramatic flair you love. Wear it over your favorite outfit for a totally new look.\r\n•	Hits below the knee\r\n•	Belted waist\r\n•	Machine wash\r\n•	Imported',
         b'1', 1, '/file?name=product_keoiw.png', 50, 3, 5, 42, 'Oahu Cover-up', 'BRAND7', 'CATEGORY3', 2),
        ('khukd', '2021-12-03 06:49:23', 'admin', 'admin', '2021-12-03 06:49:23',
         'GREATER SPEED TO BREAK BARRIERS.\r\n\r\n\r\nPrepare for your next personal best with the Nike Air Zoom Alphafly NEXT%. The immediate response foam and two Zoom Air units combine to help you run further on your next marathon or run.\r\n\r\n\r\nSpeed ​​and efficiency\r\n\r\nThe Nike ZoomX foam has incredible immediate response and lightweight, and provides optimal energy return and impact protection while you run. It is combined with two thin and visible Zoom Air units, to provide the greatest energy return of all our running shoes. careers.\r\n\r\n\r\nEnergetic footfall\r\n\r\nA full-length carbon fiber plate provides a nimble feel with every step.\r\n\r\n\r\nLightness and uniformity\r\n\r\nIntroducing the latest version of FlyKnit: AtomKnit. Flyknit fabric is stretched and steam treated to provide a lightweight, molded fit with minimal water absorption and improved breathability.\r\n\r\n\r\nFIT WHERE YOU NEED IT\r\n\r\nThe outsole was created using data from hundreds of runners. That data helped shape the design, with different angles of traction placed where you need them, thus maintaining grip from take-off and during all phases of the stride.\r\n\r\n\r\nMore benefits\r\n\r\nIncreased cushioning provides a soft feel with every step, to keep you comfortable during the last miles of your run.\r\nAn integrated tongue provides a uniform fit and allows you to comfortably tie your shoe.\r\n\r\nProduct dates\r\n\r\nWeight: 210 grams (men\'s size 43)\r\
         nOffset : 4mm (Forefoot : 35mm, Heel : 39mm)\ r\ nThe height of the sole and the materials in the footwear
         adhere to the guidelines established by World Athletics .\ r\ nColor Shown : Light Volt / Hyper Orange /
         Dynamic Turquoise / Black\ r\ nStyle : CI9925 - 700\ r\ nCountry / Region of Origin : China ', b' 1 ', 1, ' /
         file ? name = product_khukd . png ', 589, 15, 5, 40, ' Nike Air Zoom Alphafly NEXT % ', ' BRAND1 ', ' CATEGORY2 ', 1),
(' kigvb ', ' 2021 - 12 - 03 15 : 29 : 19 ', ' user1 ', ' user1 ', ' 2021 - 12 - 03 15 : 29 : 19 ', ' The quest for
         speed continues with the Nike Quest 4 Premium . Take to the streets with higher foam heights and cushioned
         comfort that combine with a lightweight upper for secure support . Intuitive details make it a staple for
         regular runners .\ r\ n\ r\ n\ r\ n\ r\ nVisible and secure support\ r\ nThe lightweight,
        minimalist upper features breathable mesh in the forefoot. The translucent window showcases Flywire technology in the midfoot. Flywire cables integrate with the laces to provide more midfoot support when you tighten them.\r\n\r\n\r\n\r\nHigher height,
        smooth feeling\r\nTextured foam midsole increases durability where you need it most and delivers an image of speed. The raised height adds a softer cushioning with every step.\r\n\r\n\r\n\r\nBuilt for long runs\r\nThe rubber outsole offers more traction. The tread rail on the side sole acts as a cushioning device,
        while the shock pad enhances durability in the high-wear area.\r\n\r\n\r\n\r\nComfort and support\r\nSoft foam in the heel provides comfort and support for your runs.\r\n\r\n\r\n\r\nNumbered details\r\nMesh lined tongue connects to inner lining of upper for a secure feel. The alphanumeric logo on the tongue says Nike Quest.\r\n', b'1', 1, '/file?name=product_kigvb.png', 157, 79, 5, 39, 'Nike Quest 4', 'BRAND1', 'CATEGORY2', 2),
('kiugp', '2021-12-03 15:41:09', 'user1', 'user1', '2021-12-03 15:41:09', 'RESPONSE SR SHOES\r\nEVERYDAY RUNNERS WITH SUPPORTIVE CUSHIONING.\r\nFall into the rhythm in these adidas running shoes. Inhale. Exhale. One foot in front of the other. And then,
        that runner\'s high. Chase after it fuelled by comfort. Because the ultra-plush cushioned midsole makes you feel like you could run forever. And even if you can\'t really,
        there are probably at least a few extra blocks in you. Maybe even another mile.\r\n', b'1', 1, '/file?name=product_kiugp.png', 179, 20, 5, 43, 'RESPONSE SR SHOES', 'BRAND2', 'CATEGORY2', 2),
('kjpdb', '2021-12-03 06:51:27', 'admin', 'admin', '2021-12-03 06:51:27', 'STABLE,
        STRONG AND READY TO RUN.\r\n\r\n\r\nStronger and more stable than previous versions,
        this shoe meets the highest standards for weight training. We also added comfort-enhancing React foam to keep you ready for high-intensity cardio. Plus,
        a flap secures the laces. so you can forget about them breaking loose when you\'re focused on your next personal best.\r\n\r\n\r\nMore stability for lifting\r\n\r\nThe flat, wide heel is made even more stable with an inner plate that distributes weight from edge to edge. It also flexes to be comfortable for cardio intervals.\r\n\r\n\r\nCushioned tread\r\n\r\nNike React foam forms a comfortable, cushioned base that\'s lightweight and springy when you have to give it your all for cardio and sprinting.\r\n\r\n\r\nGrip from every angle\r\n\r\nRenewed rubber wraps around the arch for intense grip during rope climbs. The rubber outsole gives you traction from the training room to the pavement.\r\n\r\n\r\nMore benefits\r\n\r\nLightweight mesh with textured overlays in high-strength areas helps keep your foot cool without sacrificing durability.\r\nThe flap secures the laces with a touch closure to avoid distractions.\r\nVertical heel clip minimizes chafing during wall exercises.\r\nThe laces feature Flywire cables to lock in the midfoot.\r\nGrooves in the sole allow the forefoot to flex naturally.\r\nColor Shown: White / Black / Strike Yellow / Multicolor\r\nStyle: DC9510-199\r\nCountry / Region of Origin: Vietnam', b'1', 1, '/file?name=product_kjpdb.png', 319, 15, 5, 38, 'Nike Metcon 7 AMP', 'BRAND1', 'CATEGORY2', 1),
('kpani', '2021-12-03 15:27:18', 'hoanseller', 'hoanseller', '2021-12-03 15:27:18', 'X9000L4 SHOES\r\nRESPONSIVE RUNNING SHOES WITH A GAMER-INSPIRED DESIGN.\r\nA few miles can be enough to reset your mind. These adidas running shoes keep you feeling good on short- to mid-distance runs. They ride on a full-length Boost midsole,
        which returns energy with every stride. The design draws inspiration from the virtual realm, with shocks of
        colour and semi - translucent details that are reminiscent of a glowing screen.A glitched pattern on the outsole
        offers grippy traction on city streets.\r\n\r\n', b' 1 ', 1, ' / file ? name = product_kpani.png
        ', 379, 15, 5, 39, ' X9000L4 SHOES ', ' BRAND2 ', ' CATEGORY1 ', 23),
(' krgiz ', ' 2021- 12 - 03 06 : 56 : 41 ', ' admin ', ' admin ', ' 2021- 12 - 03 07 : 05 : 16 ', ' COMFORT,
        HERITAGE AND NOTHING BETTER.\r\n\r\n\r\nNothing lighter, nothing more comfortable,
        nothing more tried and true: The Nike Air Max 90 stays true to its roots with the iconic waffle outsole,
        stitched overlays and classic TPU details on the heel and eyelets. of the upper part provides a renewed look and the Max Air cushioning adds comfort in each step.\r\n\r\n\r\nProfits\r\n\r\nOriginally designed for high-performance running,
        the Max Air unit in the heel adds incredible cushioning.\r\nThe padded low collar looks classy and feels great.\r\nThe rubber waffle outsole adds a traditional look,
        traction and durability.\r\nStitched overlays and TPU details add durability, comfort, and the iconic \'90s look you love.\r\n\r\nProduct dates\r\n\r\nFoam midsole provides springy cushioning.\r\nColor Shown: White / Black / Pure Platinum / Volt\r\nStyle: DB0625-100\r\nCountry / Region of Origin: Indonesia\r\n\r\nNike air max origins\r\n\r\nRevolutionary Air technology was first introduced into Nike footwear in 1978. In 1987, the Nike Air Max 1 debuted with visible Air technology in the heel, providing fans with much more than just the feeling of Air cushioning: this Comfort could also be seen. Since then, the next-generation Air Max shoe became a favorite with athletes and collectors for its attractive color combinations, as well as its lightweight and reliable cushioning.',
        b'1', 0, '/file?name=product_krgiz.png', 259, 15, 5, 38, 'Nike air max 90', 'BRAND1', 'CATEGORY2', 1);
INSERT INTO `product` (`code`, `created_date`, `created_by`, `modified_by`, `modified_date`, `description`, `in_stock`,
                       `is_available`, `picture_url`, `price`, `quantity`, `rating`, `size`, `title`, `brand_code`,
                       `category_code`, `seller_id`)
VALUES ('ksibj', '2021-12-03 15:43:35', 'user1', 'admin', '2021-12-05 01:59:53',
        'LIGHT AND WILD.\r\nVentilated coverage and sweat-wicking technology help keep you moving in the Nike Dri-FIT Wild Run Top. Reflective elements and graffiti-style graphic evoke the spirit of \"Never off,\" no matter the weather.\r\nWild in winter\r\nDuring the winter months, the days are shorter and the temperatures are lower. With this in mind, the Wild Run collection was designed with reflectance in key areas. Inspiration comes from the \"Never off\" philosophy, which drives you to keep going. adding kilometers even when the cold arrives.\r\nComfort and humidity control\r\nNike Dri-FIT technology wicks sweat away from the skin to accelerate evaporation, helping to maintain breathability and comfort.',
        b'1', 1, '/file?name=product_ksibj.png', 59, 3, 5, 42, 'Nike Dri-FIT Wild Run', 'BRAND5', 'CATEGORY3', 2),
       ('ksjvw', '2021-12-03 16:11:04', 'tienseller', 'tienseller', '2021-12-03 16:11:04',
        'AEROKNIT TRAINING TEE\r\nAN ADIDAS AEROKNIT TEE MADE IN PART WITH RECYCLED CONTENT.\r\nNot your ordinary training t-shirt. This cropped tee levels up your workout gear a notch or three with a chic, minimalist design. Go all out on cardio day in comfort, knowing it will stay put thanks to a tight fit and elastic waistband on the hem. Soft knit and ribbed details give you extra texture. The smooth, seamless fabric lets you move any way you want without distractions. Made in part with recycled content generated from production waste, e.g. cutting scraps, and post-consumer household waste to avoid the larger environmental impact of producing virgin content.',
        b'1', 1, '/file?name=product_ksjvw.png', 95, 3, 5, 42, 'AEROKNIT TRAINING TEE', 'BRAND6', 'CATEGORY3', 26),
       ('kvhyu', '2021-12-03 06:32:03', 'admin', 'admin', '2021-12-03 06:43:25',
        'WE CELEBRATE 75 YEARS OF BASKETBALL.\r\n\r\n\r\nFrom the class of 82, he is the fierce defender of heritage style. In honor of the NBA\'s 75th anniversary,
        give it up for a revamped version of a shoe that started it all. See the year 1946 in this Air Force 1? It is the year that the magic of the basket began.\r\n\r\n\r\nProfits\r\n\r\nLeather upper\r\nThe classic colors hint at the legendary basketball teams.\r\nOriginally designed for high-performance basketball,
        Nike Air cushioning provides long-lasting comfort.\r\nDetails include metal dubraes with \"1946\" and \"2021,\" woven tongue tab and embroidered logos.\r\nAir Force 1 Origins\r\n\r\nFollowing its debut in 1982, the AF1 revolutionized the sport by becoming the first basketball shoe to feature the Nike Air system. And it didn\'t take long to gain acceptance around the world.Today, the Air Force 1 remains true to its origins with the same soft, springy cushioning that changed the course of footwear history.\r\n\r\n', b'1', 1, '/file?name=product_kvhyu.png', 229, 20, 5, 38, 'Nike Air Force 1 \'07 LV8', 'BRAND1', 'CATEGORY2', 1),
('lbbhb', '2021-12-03 16:04:42', 'user1', 'user1', '2021-12-03 16:04:42', 'ADIDAS AEROKNIT LIGHT-SUPPORT BRA\r\nA MOISTURE-MANAGING SPORTS BRA MADE IN PART WITH RECYCLED MATERIALS.\r\nFrom hot yoga to sunny hikes, this adidas AEROKNIT sports bra helps keep you dry and feeling your confident best. It hugs the body for light support during low-impact activities. The seamless knit reduces chafing and irritation, so you feel comfortable from start to finish.', b'1', 1, '/file?name=product_lbbhb.png', 85, 3, 5, 42, 'ADIDAS AEROKNIT LIGHT-SUPPORT BRA', 'BRAND6', 'CATEGORY3', 2),
        ('lkgqh', '2021-12-03 16:01:04', 'user1', 'user1', '2021-12-03 16:01:04',
         'LEVEL UP IN LEATHER.\r\nGive your style a boost. These fan-favorite platform Chucks come ready for lightweight comfort, with a molded platform midsole and OrthoLite cushioning. A recycled mesh lining keeps it breathable, while textured and smooth leather bring a premium look and feel.\r\nWHY YOU SHOULD BE DOWN\r\n•	High top leather platform sneaker.\r\n•	OrthoLite cushioning for all-day comfort.\r\n•	A recycled mesh lining keeps it breathable.\r\n•	Lightweight, projectile platform adds height.\r\n•	Iconic Chuck Taylor ankle patch.\r\n',
         b'1', 1, '/file?name=product_lkgqh.png', 80, 15, 5, 40, 'Chuck Taylor All Star Move', 'BRAND4', 'CATEGORY1',
         2),
        ('lvlku', '2021-12-03 15:37:48', 'user1', 'user1', '2021-12-03 15:37:48',
         'ULTRABOOST 21 SHOES\r\nENERGY-RETURNING RUNNING SHOES WITH A POP OF CORDUROY.\r\nPrototype after prototype. Innovation after innovation. Testing after testing. Meet us in the hot pursuit of the pinnacle harmonization of weight, cushioning, and responsiveness. Ultraboost 21. Say hello to incredible energy return.\r\n',
         b'1', 1, '/file?name=product_lvlku.png', 399, 41, 5, 44, 'ULTRABOOST 21 SHOES', 'BRAND2', 'CATEGORY2', 2),
        ('mfugo', '2021-12-03 15:47:43', 'user1', 'user1', '2021-12-03 15:47:43',
         'NEVER LOOK BACK.\r\nAvailable in a low top for the first time, the Run Star Hike\'s chunky platform and jagged rubber sole put an unexpected twist on your everyday Chucks. Details like an organic canvas build,
         rubber toe cap and Chuck Taylor ankle patch stay true to the original, while a molded platform,
         two - tone outsole and rounded heel give off futuristic vibes.\r\nWHY YOU SHOULD BE DOWN\r\nOrganic canvas low top platform sneakers.\r\nOrthoLite insole for cushioning.\r\nTwo-tone exaggerated outsole tread.\r\nColorblocked design.\r\n', b'1', 1, '/file?name=product_mfugo.png', 100, 33, 5, 39, 'Run Star Hike', 'BRAND4', 'CATEGORY2', 2),
('mgdri', '2021-12-03 16:29:56', 'datdatdf', 'datdatdf', '2021-12-03 16:29:56', 'INNOVATIVE CUSHIONING,
         MORE COMFORTABLE THAN EVER.\r\n\r\n\r\n\r\nThe Nike Air Zoom SuperRep 2 X is designed for circuit workouts,
         high - intensity interval training (HIIT), sprints, and other fast - paced exercises . Layers of support join
         with Zoom Air cushioning to keep your foot secure and comfortable as you stride and jump, and beat every rep .
         The roomier design around the fingers allows you to get the perfect fit .\ r\ n\ r\ n\ r\ n\ r\ nA design made
         for comfort\ r\ nThis version has a fully adjustable tongue that allows you to put the shoe on,
         adjust it and give it everything you have in your training. Another update is the wide forefoot design that provides comfort for different types of feet.\r\n\r\n\r\n\r\nCushioned tread\r\nEvery time you land on the forefoot,
         two powerful Zoom Air units absorb the energy and immediately return it to take you to the next step or jump. A long plate distributes energy and balances the foot.\r\n\r\n\r\n\r\nSide by side support\r\nThe large lateral arch acts as a reinforcement for the foot when you cut hard from side to side. Stitched and tighter on this version,
         the stitched mesh on the upper keeps the foot secure in movements such as jumps and lateral lunges.\r\n\r\n\r\n\r\nFlexibility on the floor\r\nSplitting just below a natural flex point allows the foot to bend effortlessly so you can stay steady while doing a plank or completing mountain climbs and burpees like it\'s your thing.\r\n\r\n\r\n\r\nMore benefits\r\nThe grooved outsole encourages natural movement in all directions.\r\nColor Shown: White / Pollen / Volt / Black\r\nStyle: DH7916-121\r\nCountry / Region of Origin: Vietnam\r\n',
         b'1', 1, '/file?name=product_mgdri.png', 199, 68, 5, 39, 'Nike Air Zoom SuperRep 2 X', 'BRAND1', 'CATEGORY2',
         22),
        ('momsc', '2021-11-28 08:54:09', 'user1', 'user1', '2021-11-28 09:23:03',
         'LEGENDARY STYLE REFINED.\r\n\r\nThe radiance lives on in the Nike Air Force 1 \'07,
         the b-ball OG that puts a fresh spin on what you know best: durably stitched overlays,
         clean finishes and the perfect amount of flash to make you shine.\r\n\r\nBenefits\r\n\r\nThe stitched overlays on the upper add heritage style,
         durability and support.\r\nOriginally designed for performance hoops,
         the Nike Air cushioning adds lightweight, all - day comfort .\ r\ nThe low - cut silhouette adds a clean,
         streamlined look.\r\nThe padded collar feels soft and comfortable.\r\n\r\nProduct Details', b'1', 1, '/file?name=product_momsc.png', 82, 29, 5, 38, 'Adidas Air Force 1 \'07 WB',
         'BRAND2', 'CATEGORY2', 2),
        ('monab', '2021-12-03 15:47:59', 'hoanseller', 'hoanseller', '2021-12-03 15:47:59',
         'OZELIA SHOES\r\nGET YOUR STATEMENT LOOK ON LOCK WITH THESE CHUNKY, PROGRESSIVE SHOES.\r\nIf it all has to start somewhere, we\'d say the \'90s are a pretty solid launching point. Take these Ozelia Shoes. The DNA is straight out of adidas\' past,
         but the futuristic look is all grown up with a sleek,
         monochromatic build. Adiprene cushioning makes every step feel like a good one.\r\n', b'1', 1, '/file?name=product_monab.png', 269, 15, 5, 46, 'OZELIA SHOES', 'BRAND2', 'CATEGORY1', 23),
('mqaja', '2021-12-03 15:31:06', 'hoanseller', 'hoanseller', '2021-12-03 15:31:06', 'EQ21 RUN SHOES\r\nRUNNING SHOES FOR ULTIMATE COMFORT.\r\nLog miles in confidence with these adidas running shoes. The breathable upper lets your feet stay fresh on long runs. Lightweight cushioning keeps a comfortable spring in your step from the first toe-off to the final heel strike.', b'1', 1, '/file?name=product_mqaja.png', 229, 20, 5, 40, 'EQ21 RUN SHOES', 'BRAND2', 'CATEGORY1', 23),
('msmbd', '2021-12-03 15:28:17', 'hoanseller', 'hoanseller', '2021-12-03 15:28:17', 'ALPHAMAGMA SHOES\r\nWORKOUT SHOES FOR EVERY DAY.\r\nFrom lifting to boxing to bootcamp classes. These adidas training shoes keep you comfortable,
         whatever your workout of choice. The lightweight textile upper is reinforced at the toe and heel. The Bounce midsole provides flexibility on the move.\r\n', b'1', 1, '/file?name=product_msmbd.png', 299, 41, 5, NULL, 'ALPHAMAGMA SHOES', 'BRAND2', 'CATEGORY1', 23),
('mxudr', '2021-12-03 15:54:17', 'user1', 'user1', '2021-12-03 15:54:17', 'The Suede hit the scene in 1968 and has been changing the game ever since. It’s been worn by the icons of every generation and it’s stayed classic through it all. This year,
         w...\r\n Style : 374915_01\ r\ n Color : Puma Black - Puma White\ r\ n', b' 1 ', 1, ' / file ? name =
         product_mxudr . png ', 70, 30, 5, 45, ' Suede Classic XXI ', ' BRAND3 ', ' CATEGORY2 ', 2),
(' ndehv ', ' 2021 - 12 - 03 16 : 21 : 33 ', ' datdatdf ', ' datdatdf ', ' 2021 - 12 - 03 16 : 21 : 33 ', '
         EVERYDAY, IMMEDIATE RESPONSE TRAINING FOR ALL ATHLETES .\ r\ n\ r\ n\ r\ n\ r\ nYour winged workhorse returns .
         The Nike Air Zoom Pegasus 38 FlyEase offers more responsiveness for your daily long or short road runs . It is
         cool and breathable and features a wider fit at the fingers for stability and great support . cushioned to help
         you exceed your personal goals . FlyEase entry system allows you to slip on quickly and easily . Bold colors
         hint at the world gathering to celebrate sport .\ r\ n\ r\ n\ r\ n\ r\ njoin up\ r\ nThis eye - catching
         colourway celebrates unity as athletes around the world emerge from the events of the past year to compete,
         celebrating sport, humanity and
                            our ability to push through the toughest challenges.\r\n\r\n\r\n\r\nPay homage to the Swoosh\r\nThe Swoosh logo celebrates its 50th anniversary combining past and present,
         the original Swoosh appears on top of the current version to represent the path that Nike has traveled.\r\n\r\n\r\n\r\nStart with speed\r\nThanks to the closure,
         it\'s easy to put the shoe on and take it off. With one hand, you can secure the fit of the laces that do not tie.\r\n\r\n\r\n\r\nSomething classic, something new\r\nThe wider forefoot offers more room for the toes, while the shoe\'
         s fit maintains the comfortable feel you\
         've come to expect from the Pegasus. The mesh on the upper feels breathable and soft, while stretching with the foot to provide a comfortable shape and fit.\r\n\r\n\r\n\r\nCushioning with every step\r\nNike React foam is light, springy and durable. More foam means better cushioning. The Zoom Air unit in the forefoot provides more elasticity with each step. It is located closer to the foot for more immediate response.\r\n\r\n\r\n\r\nSecure fit\r\nMesh in the midfoot provides added security; it wraps around your foot when you lace up, allowing you to choose the fit and feel.\r\n\r\n\r\n\r\nMore benefits\r\nFoam tongue helps take pressure off the shoelaces.\r\nColor Shown: White / Football Gray / Avalanche Pink / Black\r\nStyle: DJ5413-100\r\nCountry / Region of Origin: China\r\n',
         b'1', 1, '/file?name=product_ndehv.png', 207, 70, 5, 40, 'Nike Air Zoom Pegasus 38 FlyEase', 'BRAND1',
         'CATEGORY2', 22),
        ('neqbn', '2021-12-03 16:23:24', 'datdatdf', 'datdatdf', '2021-12-03 16:23:24',
         'STABLE, STRONG AND READY TO RUN.\r\n\r\n\r\n\r\nThe gold standard fit for weight training just keeps getting better: the Nike Metcon 7, now stronger and more stable than before, we\'ve added an immediate-response foam under the foot for comfort and a flap that lets you lock in your feet. laces,
         so you forget about untying them when you\'re focused on your next personal best.\r\n\r\n\r\n\r\nMore stability for lifting\r\nThe flat, wide heel is made even more stable with an inner plate that distributes weight from edge to edge. It also flexes for comfort during high intensity sets.\r\n\r\n\r\n\r\nCushioned tread\r\nNike React foam forms a comfortable, cushioned base that\'s lightweight and springy when you have to give it your all for cardio and sprinting.\r\n\r\n\r\n\r\nGrip from every angle\r\nRenewed rubber wraps around the arch for intense grip during rope climbs. The rubber outsole gives you traction from the training room to the pavement.\r\n\r\n\r\n\r\nMore benefits\r\nLightweight mesh with textured overlays in heavy-duty areas keeps your foot cool without sacrificing durability.\r\nThe flap secures the laces with a touch closure to prevent distraction.\r\nVertical heel clip minimizes drag during wall exercises.\r\nThe laces feature Flywire cables to lock in the midfoot.\r\nGrooves in the sole allow the forefoot to flex naturally.\r\nColor Shown: Light Bone / Platinum Tint / Summit White / Dark Smoke Gray\r\nStyle: DA9624-091\r\nCountry / Region of Origin: Vietnam\r\n', b'1', 1, '/file?name=product_neqbn.png', 227, 60, 5, 39, 'Nike Metcon 7', 'BRAND1', 'CATEGORY2', 22),
('njnia', '2021-12-03 16:10:37', 'hoanseller', 'hoanseller', '2021-12-03 16:10:37', 'HIGHER GROUND.\r\nThe laidback design of the iconic Chuck Taylor All Star High Top shoe gets a hiking-inspired twist in the Run Star Hike. A 100% recycled polyester build and heel loop come together with the classic star ankle patch,
         while a foxing stripe draws attention to the jagged platform sole.\r\nWHY YOU SHOULD BE DOWN\r\n•	High top recycled poly-canvas platform sneaker.\r\n•	OrthoLite cushioning for all-day comfort.\r\n•	A recycled mesh lining keeps it breathable.\r\n•	Exaggerated,
         jagged outsole.\r\n•	Iconic Chuck Taylor ankle patch.\r\n', b'1', 1, '/file?name=product_njnia.png', 0, 35, 5, 41, 'Converse Color Run Star Hike', 'BRAND4', 'CATEGORY1', 23),
('nmotw', '2021-12-03 15:59:40', 'user1', 'user1', '2021-12-03 15:59:40', 'Ultra-roomy sleeves and a below-the-knee length give this beautifully draped cover-up the dramatic flair you love. Wear it over your favorite outfit for a totally new look.\r\n•	Hits below the knee\r\n•	Belted waist\r\n•	Machine wash\r\n•	Imported', b'1', 1, '/file?name=product_nmotw.png', 50, 3, 5, 42, 'Oahu Cover-up', 'BRAND7', 'CATEGORY3', 2),
('nnkxh', '2021-11-28 09:21:24', 'user1', 'user1', '2021-11-28 09:22:34', 'LEGENDARY STYLE REFINED.\r\n\r\nThe radiance lives on in the Nike Air Force 1 \'07, the b-ball OG that puts a fresh spin on what you know best: durably stitched overlays, clean finishes and the perfect amount of flash to make you shine.\r\n\r\nBenefits\r\n\r\nThe stitched overlays on the upper add heritage style, durability and support.\r\nOriginally designed for performance hoops, the Nike Air cushioning adds lightweight, all-day comfort.\r\nThe low-cut silhouette adds a clean, streamlined look.\r\nThe padded collar feels soft and comfortable.\r\n\r\nProduct Details',
         b'1', 1, '/file?name=product_nnkxh.png', 101, 38, 5, 39, 'Adidas Air Force 1.5 WB', 'BRAND2', 'CATEGORY2', 2),
        ('nnpvx', '2021-12-03 15:33:36', 'hoanseller', 'hoanseller', '2021-12-03 15:33:36',
         'ULTRABOOST 21 X MARIMEKKO SHOES\r\nGRAPHIC SHOES DESIGNED IN COLLABORATION WITH MARIMEKKO.\r\nOne founding principle of Marimekko is that women should be able to run in a dress if they want to. The vibrant print on these adidas running shoes reflects the joy of moving your feet. Behind the chic look lies all the performance features the Ultraboost is known for, like a supportive adidas Primeknit+ upper and responsive Boost cushioning.\r\n',
         b'1', 1, '/file?name=product_nnpvx.png', 799, 30, 5, 40, 'ULTRABOOST 21 X MARIMEKKO SHOES', 'BRAND2',
         'CATEGORY1', 23),
        ('nuegw', '2021-12-03 06:58:10', 'admin', 'admin', '2021-12-03 06:58:10',
         'LEGENDARY AND REFINED STYLE.\r\n\r\n\r\nThe glow lives on in the Nike Air Force 1 \'07,
         the original basketball model that puts a fresh twist on well-remembered features: durable stitched overlays,
         impeccable finishes, and the perfect amount of sparkle to make you shine .\ r\ n\ r\ n\ r\ nProfits\ r\ n\ r\
         nStitched overlays on the upper add a heritage look with durability and support .\ r\ nOriginally designed for
         high - performance basketball, Nike Air cushioning adds lightweight, all - day comfort .\ r\ nThe low - profile
         style offers a sleek,
         streamlined look.\r\nThe padded ankle area is soft and comfortable.\r\n\r\nProduct dates\r\n\r\nFoam midsole\r\nPerforations in the tip\r\nRubber sole\r\nColor Shown: Black / Black\r\nStyle: CW2288-001\r\nCountry / Region of Origin: Vietnam,
         India\r\ n\ r\ nOrigins of Air Force 1\ r\ n\ r\ nFollowing its debut in 1982,
         the AF1 revolutionized the sport by becoming the first basketball shoe to feature the Nike Air system. In addition,
         it did not take long to gain acceptance around the world. Today,
         the Air Force 1 remains true to its origins with the same soft,
         springy cushioning that changed the course of shoe history.', b'1', 1, '/file?name=product_nuegw.png', 209, 15, 5, 38, 'Nike Air Force 1 \'07',
         'BRAND1', 'CATEGORY2', 1),
        ('ojmej', '2021-12-03 15:50:21', 'hoanseller', 'hoanseller', '2021-12-03 15:50:21',
         'KARLIE KLOSS X9000 SHOES\r\nVERSATILE, SUPPORTIVE RUNNING SHOES DESIGNED WITH KARLIE KLOSS.\r\nYour mind may try to box you in. Your legs are there to break you out. A collaboration with Karlie Kloss, these adidas running shoes have a bold look that acts as extra motivation to lace in and get out in the morning. Boost cushioning keeps that motivation flowing, with every take off and landing fuelled by energy-returning comfort. This product is made with recycled content as part of our ambition to end plastic waste. 20% of pieces used to make the upper are made with minimum 50% recycled content.\r\n',
         b'1', 1, '/file?name=product_ojmej.png', 389, 15, 5, 37, 'KARLIE KLOSS X9000 SHOES', 'BRAND2', 'CATEGORY1',
         23),
        ('oztnd', '2021-12-03 15:47:56', 'user1', 'user1', '2021-12-03 15:47:56',
         'LIGHTER THAN EVER\r\n\r\n\r\n\r\nThe NikeCourt Air Zoom Vapor Pro takes everything you love about the NikeCourt Air Zoom Vapor X and makes it lighter and more supportive. The three-layer design offers breathability, stability and durability where you need it most, while keeping weight to a minimum.\r\n\r\n\r\n\r\nLightness and breathability\r\nDurable mesh helps keep feet cool. The inside of the mesh is reinforced where you need extra support. The exterior features a thin, flexible coating for added durability.\r\n\r\n\r\n\r\nReady for tennis\r\nAsymmetric laces adapt to the foot during lateral movements. Center grommets located closer to the toes are covered to increase durability during slides.\r\n\r\n\r\n\r\nData driven traction\r\nThe sole uses a data-driven design to provide grip without affecting your ability to slide. Rubber was removed from low-wear areas to reduce weight.\r\n\r\n\r\n\r\nCourt comfort\r\nThe soft foam midsole features a Zoom Air unit in the heel that provides low-profile, responsive cushioning. Elastic inner sleeve wraps the foot for a sock-like fit.\r\n\r\n\r\n\r\nMore benefits\r\nThe full-length structure on the sides helps stabilize the foot during quick cuts.\r\n\r\n\r\n\r\nProduct dates\r\nDesigned for use on hard court surfaces\r\nRemovable footbed\r\nColor Shown: Summit White / White / Sail / Binary Blue\r\nStyle: CZ0222-133\r\nCountry / Region of Origin: China\r\n',
         b'1', 1, '/file?name=product_oztnd.png', 202, 70, 5, 39, 'NikeCourt Air Zoom Vapor Pro', 'BRAND1', 'CATEGORY2',
         2),
        ('pakdz', '2021-11-28 09:17:40', 'user1', 'admin', '2021-12-03 07:05:38',
         'LEGENDARY STYLE REFINED.\r\n\r\nThe radiance lives on in the Nike Air Force 1 \'07,
         the b-ball OG that puts a fresh spin on what you know best: durably stitched overlays,
         clean finishes and the perfect amount of flash to make you shine.\r\n\r\nBenefits\r\n\r\nThe stitched overlays on the upper add heritage style,
         durability and support.\r\nOriginally designed for performance hoops,
         the Nike Air cushioning adds lightweight, all - day comfort .\ r\ nThe low - cut silhouette adds a clean,
         streamlined look.\r\nThe padded collar feels soft and comfortable.\r\n\r\nProduct Details', b'1', 0, '/file?name=product_pakdz.png', 94, 31, 5, 40, 'Nike Air Force 1 \'07 WE',
         'BRAND1', 'CATEGORY2', 2),
        ('pazgo', '2021-11-28 09:18:43', 'user1', 'admin', '2021-12-03 15:00:05',
         'LEGENDARY STYLE REFINED.\r\n\r\nThe radiance lives on in the Nike Air Force 1 \'07,
         the b-ball OG that puts a fresh spin on what you know best: durably stitched overlays,
         clean finishes and the perfect amount of flash to make you shine.\r\n\r\nBenefits\r\n\r\nThe stitched overlays on the upper add heritage style,
         durability and support.\r\nOriginally designed for performance hoops,
         the Nike Air cushioning adds lightweight, all - day comfort .\ r\ nThe low - cut silhouette adds a clean,
         streamlined look.\r\nThe padded collar feels soft and comfortable.\r\n\r\nProduct Details', b'1', 0, '/file?name=product_pazgo.png', 97, 34, 5, 41, 'Nike Air Force 2.1', 'BRAND1', 'CATEGORY2', 2),
('pjiay', '2021-12-03 15:58:03', 'user1', 'user1', '2021-12-03 15:58:03', 'The classic PUMA Suede is a shoe with a legacy - icons of every generation have enjoyed this legendary look for more than 50 years, from
         Tommie Smith’ s victory stand protest a . . .\ r\ n Style : 381176_05\ r\ n Color : Fudge - Fudge\ r\ n', b' 1
         ', 1, ' / file ? name = product_pjiay . png ', 70, 44, 5, 39, ' Suede Mono XXI Sneakers ', ' BRAND3 ', '
         CATEGORY1 ', 2),
(' pkttw ', ' 2021 - 12 - 03 16 : 05 : 27 ', ' user1 ', ' user1 ', ' 2021 - 12 - 03 16 : 05 : 27 ', ' TRAINING AEROKNIT
         BRA\ r\ nA SOFT,
         STYLISH BRA FOR LOW-INTENSITY WORKOUTS.\r\nPull on this adidas workout bra and push your limits in comfort. Temperature-regulating adidas Aeroknit keeps you feeling dry and distraction free,
         so you can focus on what matters. That final rep,
         the last lap and knowing that your bra is part of adidas\' commitment to help end plastic waste.', b'1', 1,
         '/file?name=product_pkttw.png', 95, 3, 5, 42, 'TRAINING AEROKNIT BRA', 'BRAND6', 'CATEGORY3', 2),
        ('pmnmo', '2021-12-03 16:42:18', 'datdatdf', 'datdatdf', '2021-12-03 16:42:18',
         'With a form-fitting textile upper, sleek monochromatic lines, a sparkly outsole and gold hardware, the Defy Mid Varsity has an elegant silhouette that’s as ready for the gym a...\r\n Style: 191667_02\r\n Color: Puma White-Metallic Gold\r\n',
         b'1', 1, '/file?name=product_pmnmo.png', 100, 100, 5, 39, 'Defy Varsity Mid', 'BRAND3', 'CATEGORY1', 22),
        ('pmswd', '2021-12-03 15:59:15', 'user1', 'user1', '2021-12-03 15:59:15',
         'This season, we launch the iconic PUMA Suede into the 21st century in this new mid-top silhouette. The classic style from the \'60s hits new heights with a mid-top padded colla...\r\n Style: 380205_01\r\n Color: Puma Black-Puma White-Amazon Green\r\n', b'1', 1, '/file?name=product_pmswd.png', 80, 33, 5, 39, 'Suede Mid XXI', 'BRAND3', 'CATEGORY2', 2),
('pnomt', '2021-11-28 08:53:17', 'user1', 'user1', '2021-11-28 08:53:17', 'LEGENDARY STYLE REFINED.\r\n\r\nThe radiance lives on in the Nike Air Force 1 \'07, the b-ball OG that puts a fresh spin on what you know best: durably stitched overlays, clean finishes and the perfect amount of flash to make you shine.\r\n\r\nBenefits\r\n\r\nThe stitched overlays on the upper add heritage style, durability and support.\r\nOriginally designed for performance hoops, the Nike Air cushioning adds lightweight, all-day comfort.\r\nThe low-cut silhouette adds a clean, streamlined look.\r\nThe padded collar feels soft and comfortable.\r\n\r\nProduct Details',
         b'1', 1, '/file?name=product_pnomt.png', 81, 25, 5, 41, 'Nike Air Force 1 \'10 ', 'BRAND1', 'CATEGORY2', 2),
('pnqyl', '2021-12-03 15:36:02', 'hoanseller', 'hoanseller', '2021-12-03 15:36:02', 'X9000L4 SHOES\r\nRESPONSIVE RUNNING SHOES WITH A GAMER-INSPIRED DESIGN.\r\nA few miles can be enough to reset your mind. These adidas running shoes keep you feeling good on short- to mid-distance runs. They ride on a full-length Boost midsole,
         which returns energy with every stride. The design draws inspiration from the virtual realm, with shocks of
         colour and semi - translucent details that are reminiscent of a glowing screen . A glitched pattern on the
         outsole offers grippy traction on city streets .\ r\ n', b' 1 ', 1, ' / file ? name = product_pnqyl . png
         ', 389, 15, 5, 42, ' X9000L4 SHOES ', ' BRAND2 ', ' CATEGORY1 ', 23),
(' ppvvo ', ' 2021 - 12 - 03 16 : 17 : 09 ', ' hoanseller ', ' hoanseller ', ' 2021 - 12 - 03 16 : 17 : 09 ', ' LEVEL UP
         .\ r\ nA bold, projectile platform brings new energy to classic Chucks. Designed for freedom of movement,
         a lightweight,
         molded platform adds height without the bulky weight. Stand tall and stand out.\r\nWHY YOU SHOULD BE DOWN\r\n•	Low top canvas platform sneaker.\r\n•	OrthoLite insole for cushioning.\r\n•	Lightweight,
         projectile platform adds height.\r\n•	Neutral colors pair easily with anything in your closet.\r\n•	Gum rubber outsole for a subtle vintage look.', b'1', 1, '/file?name=product_ppvvo.png', 70, 15, 5, 39, 'Chuck Taylor All Star Move', 'BRAND4', 'CATEGORY1', 23),
('pszzo', '2021-12-03 15:41:40', 'user1', 'user1', '2021-12-03 15:41:40', 'RESPONSE SR SHOES\r\nEVERYDAY RUNNERS WITH SUPPORTIVE CUSHIONING.\r\nFall into the rhythm in these adidas running shoes. Inhale. Exhale. One foot in front of the other. And then,
         that runner\'s high. Chase after it fuelled by comfort. Because the ultra-plush cushioned midsole makes you feel like you could run forever. And even if you can\'t really,
         there are probably at least a few extra blocks in you. Maybe even another mile.\r\n', b'1', 1, '/file?name=product_pszzo.png', 179, NULL, 5, NULL, 'RESPONSE SR SHOES', 'BRAND2', 'CATEGORY2', 2),
('pvvza', '2021-12-03 16:02:38', 'user1', 'user1', '2021-12-03 16:02:38', 'The classic PUMA Suede is a shoe with a legacy - icons of every generation have enjoyed this legendary look for more than 50 years, from
         Tommie Smith’ s victory stand protest a . . .\ r\ n Style : 381176_02\ r\ n Color : Yellow Pear - Yellow Pear\
         r\ n', b' 1 ', 1, ' / file ? name = product_pvvza . png ', 99, 33, 5, 41, ' Suede Mono XXI Sneakers ', ' BRAND3
         ', ' CATEGORY2 ', 2),
(' qgpeh ', ' 2021 - 12 - 03 15 : 54 : 53 ', ' user1 ', ' user1 ', ' 2021 - 12 - 03 15 : 54 : 53 ', ' A plunging V -
         neck and high - cut legs put a modern spin on a classic one - piece,
         adorned with a single gold logo charm.\r\n•	Removable padding\r\n•	High-cut leg\r\n•	Logo charm detail\r\n•	Moderate back coverage: shows a little,
         but not all \r\n•	Hand wash\r\n•	Imported\r\n', b'1', 1, '/file?name=product_qgpeh.png', 79, 3, 5, 42, 'Banded Plunge One-Piece', 'BRAND7', 'CATEGORY3', 2),
('qleqa', '2021-12-03 15:58:35', 'hoanseller', 'hoanseller', '2021-12-03 15:58:35', 'BUNDLED UP.\r\nThe best-selling Run Star Hike gets cozy with Sherpa,
         bringing warm,
         winter - right material to a style that can stand out‚ and stand up‚ to the elements. The Sherpa build elevates both look and feel,
         doubling up on warmth from its cozy Sherpa lining. Complete with the same platform midsole and statement-making,
         saw -
         tooth outsole that makes it a streetwear favorite. An OrthoLite sockliner with an extra soft top cloth completes the look with comfort.\r\nWHY YOU SHOULD BE DOWN\r\n•	High top Sherpa platform sneaker.\r\n•	OrthoLite cushioning for all-day comfort.\r\n•	A cozy Sherpa lining helps you stay warm.\r\n•	Exaggerated,
         jagged outsole.\r\n•	A clear rubber Chuck Taylor ankle patch adds subtle branding.\r\n', b'1', 1, '/file?name=product_qleqa.png', 120, 15, 5, 39, 'Sherpa Run Star Hike', 'BRAND4', 'CATEGORY1', 23),
('qwjti', '2021-12-03 15:52:05', 'user1', 'user1', '2021-12-03 15:52:05', 'Our Wicked push-up technology takes on swimwear. A ruched scoop neckline is universally flattering,
         while adjustable straps and a tie back create the perfect fit. \r\n•	Unlined with innovative sling to provide push-up without padding\r\n•	Underwire\r\n•	Adjustable straps\r\n•	Adjustable tie back\r\n•	Hand wash\r\n•	Imported', b'1', 1, '/file?name=product_qwjti.png', 44, 3, 5, 42, 'Ice Queen Printed Wicked Swim Top', 'BRAND7', 'CATEGORY3', 2),
('qwqyi', '2021-12-03 15:28:48', 'user1', 'admin', '2021-12-03 15:38:25', 'ALPHABOUNCE SHOES\r\nVERSATILE RUNNING SHOES FOR SPEED IN EVERY DIRECTION.\r\nThat competitive edge you\'ve been looking for? It\'s all in your training routine. These adidas running shoes keep you comfortable through gym workouts and short- to mid-distance runs. Supportive yet flexible,
         they have a stable feel during side-to-side exercises like ice skaters. Bounce cushioning feels springy underfoot.\r\n', b'1', 1, '/file?name=product_qwqyi.png', 219, 10, 5, 38, 'ALPHABOUNCE SHOES', 'BRAND2', 'CATEGORY2', 2),
('rdssk', '2021-12-03 16:12:47', 'tienseller', 'tienseller', '2021-12-03 16:13:38', '3-STRIPES TRAINING TEE\r\nPAIR THIS SEMI-SHEER WORKOUT TEE WITH YOUR FAVOURITE SPORTS BRA.\r\nLight as air. This adidas training t-shirt is a simple tee for anyone who likes a barely-there feel. The fabric is not only ultralight,
         but semi-sheer. AEROREADY wicks moisture so you stay focused on the workout. This product is made with Primegreen,
         a series of high-performance recycled materials.', b'1', 1, '/file?name=product_rdssk.png', 75, 3, 5, 42, '3-STRIPES TRAINING TEE', 'BRAND6', 'CATEGORY3', 26),
('rfyct', '2021-12-03 15:33:08', 'user1', 'user1', '2021-12-03 15:33:08', 'ADVANTAGE SHOES\r\nSHOES WITH CLASSIC STYLE AND A MODERN FIT.\r\nThese adidas tennis-inspired shoes combine a classic look with modern step-in comfort. Lace up in a soft yet snug fit that hugs your foot naturally. Step confidently with dependable traction on any surface. This product is made with Primegreen,
         a series of high-performance recycled materials. 50% of upper is recycled content. No virgin polyester.\r\n', b'1', 1, '/file?name=product_rfyct.png', 89, 22, 5, 43, 'ADVANTAGE SHOES', 'BRAND2', 'CATEGORY2', 2),
('rhaex', '2021-12-03 15:31:41', 'user1', 'user1', '2021-12-03 15:31:41', 'FORUM MID SHOES\r\nLUXE MID-CUT TRAINERS WITH HOOPS DNA.\r\nLet\'s take a moment to honour an icon. Is it the gravity-defying B-ball legend from the \'80s? Or perhaps the status shoe that adorned the feet of rappers? Both, in
         fact . The adidas Forum shoes have dominated the hardwood and the streets, and they\
         're back in a mid top version to take your moves to the next level. Slip into the unmistakable style, now in luxurious coated leather, and flaunt that pure class.\r\n',
         b'1', 1, '/file?name=product_rhaex.png', 249, 20, 5, 40, 'FORUM MID SHOES', 'BRAND2', 'CATEGORY2', 2),
        ('rhwoo', '2021-12-03 15:38:51', 'hoanseller', 'hoanseller', '2021-12-03 15:38:51',
         'ULTRABOOST 21 SHOES\r\nCUSHIONED RUNNING SHOES MADE FOR ULTIMATE ENERGY RETURN.\r\nPrototype after prototype. Innovation after innovation. Testing after testing. Meet us in the hot pursuit of the pinnacle harmonization of weight, cushioning, and responsiveness. Ultraboost 21. Say hello to incredible energy return.\r\n',
         b'1', 1, '/file?name=product_rhwoo.png', 699, 20, 5, 38, 'ULTRABOOST 21 SHOES', 'BRAND2', 'CATEGORY1', 23),
        ('rjhyl', '2021-12-03 15:48:19', 'user1', 'user1', '2021-12-03 15:48:19',
         'FUTURE FAMILIAR.\r\nReflecting the energy of city streets, the Run Star Motion’s playful and distorted lines are built for future movement. Reimagined from the inside out, the elevated stance and CX foam midsole help bring next-level comfort to every stride. The upper stays true to the original, juxtaposed by future-forward design details for bold self-expression. An exaggerated, wavy platform and sculptural traction lugs raise you up and keep you steady with standout traction.\r\nWHY YOU SHOULD BE DOWN\r\n100% organic canvas upper.\r\nRubber heel star and premium Chuck 70 detailing.\r\nWavy sculpted pinstripe.\r\nCX foam insole and lightweight phylon midsole absorb impact and support you all day long.\r\nExpressive lugged rubber forefoot and heel for standout traction.\r\n',
         b'1', 1, '/file?name=product_rjhyl.png', 120, 20, 5, 41, 'Run Star Motion', 'BRAND4', 'CATEGORY2', 2),
        ('rnskc', '2021-12-03 15:39:33', 'user1', 'admin', '2021-12-05 02:04:02',
         'SHINES LIKE A DIAMOND.\r\nOpen your mind and shine like a diamond in the Nike Sportswear Glow-in-the-Dark T-Shirt. Its soft cotton fabric and classic fit offer a familiar feel, while fluorescent glow-in-the-dark graphics help you stand out from the crowd. the crowd.\r\nProfits\r\n•	The classic fit style of the shirt is relaxed over the body and hips.\r\n•	Special UV ink allows fluorescent details to stand out in the dark.\r\n',
         b'1', 1, '/file?name=product_rnskc.png', 69, 3, 5, 42, 'Nike Sportswear', 'BRAND5', 'CATEGORY3', 2),
        ('rqriw', '2021-12-03 15:34:09', 'user1', 'user1', '2021-12-03 15:34:09',
         'SECURE SUPPORT FOR YOUR EVERYDAY SPEED TRAINING.\r\n\r\n\r\n\r\nWhen running is an everyday habit, you need support that matches your speed. The Nike Winflo 8 reintroduces the cushioning you love, combining it with details like a translucent upper and Flywire technology for a comfortable fit. improves stability for long runs, the animal print touch lets you run wild.\r\n\r\n\r\n\r\nSpeed ​​in nature\r\nThe animal-inspired print on the Swoosh or on the back is inspired by the fastest land animal.\r\n\r\n\r\n\r\nLightweight and breathable support\r\nThe upper features translucent mesh and perforations in the forefoot for breathable comfort. The translucent window on the inner sides showcases Flywire technology in the midfoot. Flywire cables integrate with the laces to provide more support as you adjust them.\r\n\r\n\r\n\r\nComfort where it matters most\r\nFoam around the heel and ankle combines with support at the base of the heel for a secure fit.\r\n\r\n\r\n\r\nCushioning for miles\r\nA Zoom Air unit in the forefoot provides cushioning where you need it. Cushlon foam makes it soft and responsive, while adding more elasticity to your stride.\r\n\r\n\r\n\r\nMore benefits\r\nCoatings on the toe add a layer of durability.\r\nThe tongue connects to the inner lining of the upper for a secure feeling.\r\nColor Shown: Mist Gray / Pale Coral / Metallic Pewter / Light Pink\r\nStyle: DA3056-001\r\nCountry / Region of Origin: Vietnam\r\n',
         b'1', 1, '/file?name=product_rqriw.png', 179, 77, 5, 39, 'Nike Winflo 8 Premium', 'BRAND1', 'CATEGORY2', 2),
        ('rqsne', '2021-12-03 15:46:57', 'hoanseller', 'hoanseller', '2021-12-03 15:46:57',
         'ULTRABOOST 21 SHOES\r\nSTEP UP YOUR RUNS IN THESE ULTRABOOST 21 SHOES.\r\nPrototype after prototype. Innovation after innovation. Testing after testing. Meet us in the hot pursuit of the pinnacle harmonization of weight, cushioning, and responsiveness. Ultraboost 21. Say hello to incredible energy return.\r\n\r\n',
         b'1', 1, '/file?name=product_rqsne.png', 389, 15, 5, 45, 'ULTRABOOST 21 SHOES', 'BRAND2', 'CATEGORY1', 23),
        ('rrcmz', '2021-12-03 16:09:34', 'tienseller', 'tienseller', '2021-12-03 16:09:34',
         'AEROKNIT TRAINING TEE\r\nAN ADIDAS AEROKNIT TEE MADE IN PART WITH RECYCLED CONTENT.\r\nNot your ordinary training t-shirt. This cropped tee levels up your workout gear a notch or three with a chic, minimalist design. Go all out on cardio day in comfort, knowing it will stay put thanks to a tight fit and elastic waistband on the hem. Soft knit and ribbed details give you extra texture. The smooth, seamless fabric lets you move any way you want without distractions. Made in part with recycled content generated from production waste, e.g. cutting scraps, and post-consumer household waste to avoid the larger environmental impact of producing virgin content.',
         b'1', 1, '/file?name=product_rrcmz.png', 95, 3, 5, 42, 'AEROKNIT TRAINING TEE', 'BRAND6', 'CATEGORY3', 26),
        ('rvjhl', '2021-12-03 15:40:37', 'user1', 'user1', '2021-12-03 15:40:37',
         'ULTRABOOST 21 X PARLEY SHOES\r\nULTRABOOST RUNNING SHOES MADE IN PART WITH PARLEY FOR THE OCEANS.\r\nRunning pushes you outside, and it grows a love for the planet we play on. This version of the Ultraboost 21 is designed with the oceans in mind. With an adidas Primeknit upper and responsive BOOST in the midsole, the shoes feel as comfortable on short morning miles as they do on your next 10k\r\n',
         b'1', 1, '/file?name=product_rvjhl.png', 550, 30, 5, 40, 'ULTRABOOST 21 X PARLEY SHOES', 'BRAND2', 'CATEGORY2',
         2),
        ('rxiid', '2021-12-03 06:53:36', 'admin', 'admin', '2021-12-03 06:53:36',
         'THE POWER FOR YOUR ELITE RACING.\r\n\r\n\r\nKeep evolving in speed in a running shoe made to help you reach new goals and records. Enhance comfort and breathability with a redesigned upper. Whether in a 10K race or a marathon, this model, like its previous version, maintains immediate-response cushioning and secure support for you to reach your personal best.\r\n\r\n\r\nThe best energy return\r\n\r\nNike ZoomX foam provides the best Nike Running energy return to date. The full-length carbon fiber plate creates a responsive feel that keeps you moving with every step.\r\n\r\n\r\nUltra breathable and soft\r\n\r\nThe redesigned upper uses a mesh fabric placed in the areas where you need breathability most. The result is a softer and cooler shoe that adapts to your foot.\r\n\r\n\r\nSecure containment\r\n\r\nReinforcement throughout the forefoot provides durability and secure comfort.\r\n\r\n\r\nMore benefits\r\n\r\nInternal foam capsule in the heel offers additional cushioning.\r\nThe lightweight padding on the tongue helps reduce pressure from the laces on the top of the foot.\r\nThe laces slide through lightweight lateral supports, eliminating the need for an arch band. This helps reduce the weight of the shoe.\r\nWider toe box provides a looser fit.\r\nFlex grooves in the outsole provide traction on multiple terrains and in varying weather conditions.\r\n\r\nProduct dates\r\n\r\nApproved by World Athletics\r\nColor Shown: Light Volt / Hyper Orange / Volt / Black\r\nStyle: CU4111-700\r\nCountry / Region of Origin: China',
         b'1', 1, '/file?name=product_rxiid.png', 519, 15, 5, 39, 'Nike ZoomX Vaporfly Next% 2', 'BRAND1', 'CATEGORY2',
         1),
        ('samrd', '2021-12-03 15:28:46', 'user1', 'user1', '2021-12-03 15:28:46',
         'ALPHABOUNCE SHOES\r\nVERSATILE RUNNING SHOES FOR SPEED IN EVERY DIRECTION.\r\nThat competitive edge you\'ve been looking for? It\'s all in your training routine. These adidas running shoes keep you comfortable through gym workouts and short- to mid-distance runs. Supportive yet flexible, they have a stable feel during side-to-side exercises like ice skaters. Bounce cushioning feels springy underfoot.\r\n',
         b'1', 1, '/file?name=product_samrd.png', 219, 10, 5, 38, 'ALPHABOUNCE SHOES', 'BRAND2', 'CATEGORY2', 2),
        ('sbgie', '2021-12-03 15:35:47', 'user1', 'user1', '2021-12-03 15:35:47',
         'X9000L2 SHOES\r\nSLEEK RUNNING SHOES FOR MID-DISTANCE RUNS.\r\nWhen robots take over the world, you\'ll be able to outrun them in these adidas running shoes. They come equipped with lightweight and flexible Bounce cushioning. A booster pack of Jetboost in the heel delivers energy return and enhanced stability. This product is made with Primegreen,
         a series of high-performance recycled materials. 50% of the upper is recycled content.\r\n', b'1', 1, '/file?name=product_sbgie.png', 234, 30, 5, 41, 'X9000L2 SHOES', 'BRAND2', 'CATEGORY2', 2),
('sdkyu', '2021-12-03 15:29:46', 'hoanseller', 'hoanseller', '2021-12-03 15:29:46', 'ULTRABOOST 4.0 DNA SHOES\r\nTHE SLEEK LOOK OF PERFORMANCE RUNNING SHOES IN AN EVERYDAY TRAINER.\r\nLegends have to keep evolving to stay relevant. That\'s true for musicians, actors and even game-changing running shoes like the adidas Ultraboost. This lifestyle version gives you the same comfort and support as the legendary runners in a shoe you can wear every day. The fourth iteration of adidas Primeknit rides on the OG tooling. Boost cushioning returns energy to your step to keep you feeling confident.\r\n',
         b'1', 1, '/file?name=product_sdkyu.png', 459, 20, 5, 39, 'ULTRABOOST 4.0 DNA SHOES', 'BRAND2', 'CATEGORY1',
         23),
        ('sigor', '2021-12-03 15:26:17', 'hoanseller', 'hoanseller', '2021-12-03 15:26:17',
         'ULTRABOOST 22 SHOES\r\nICONIC RUNNING SHOES MADE IN PART WITH PARLEY OCEAN PLASTIC.\r\nA little extra push. The Ultraboost running shoes serve up comfort and responsiveness at every pace and distance. Designed specifically for women, this version comes with extra lugs on the outsole for a more centred transition. The adidas PRIMEKNIT upper includes foam around the heel to prevent blisters. You\'ll be riding on a BOOST midsole for endless energy, with
         a Linear Energy Push system for more responsiveness than ever before . This shoe\
         's upper is made with a high-performance yarn which contains at least 50% Parley Ocean Plastic —  reimagined plastic waste, intercepted on remote islands, beaches, coastal communities and shorelines, preventing it from polluting our ocean. The other 50% of the yarn is recycled polyester.\r\n',
         b'1', 1, '/file?name=product_sigor.png', 499, 15, 5, 40, 'ULTRABOOST 22 SHOES', 'BRAND2', 'CATEGORY1', 23),
        ('skeit', '2021-12-03 15:29:04', 'hoanseller', 'hoanseller', '2021-12-03 15:29:04',
         'RESPONSE SR SHOES\r\nRUNNING SHOES FOR VERSATILE SUPPORT.\r\nFrom an early-morning track workout to an afternoon jog through the neighbourhood, keep your feet feeling fresh and comfortable in these adidas running shoes. A breathable upper lets air flow freely with each step. The balance of stability and freedom of movement give you versatile support as you log miles.\r\n\r\n',
         b'1', 1, '/file?name=product_skeit.png', 199, 20, 5, 38, 'RESPONSE SR SHOES', 'BRAND2', 'CATEGORY1', 23),
        ('stdiy', '2021-12-07 14:18:13', 'vyseller', 'hoan123', '2021-12-07 14:22:15', 'Description', b'1', 1,
         '/file?name=product_stdiy.png', 50, 38, 5, 40, 'Test product', 'BRAND1', 'CATEGORY1', 30),
        ('supqn', '2021-12-03 15:47:10', 'user1', 'user1', '2021-12-03 15:47:10',
         'NEXT-GENERATION COMFORT.\r\nYour favorite sneakers, made more comfortable. The Chuck Taylor All Star CX updates the classic with revolutionary CX foam for lightweight support and comfort. Designed to move with you, stretch canvas forms to your foot, while pull tabs allow for easy on and off. This edition goes bold with transparent details and pops of vibrant color, inspired by the physical and digital worlds.\r\nWHY YOU SHOULD BE DOWN\r\nLow top dynamic stretch canvas sneaker.\r\nCX foam sockliner brings the latest in comfort technology.\r\nHeel pull tabs for easy on and off.\r\nTranslucent rubber details reveal pops of color.\r\nStandard license plate.\r\n',
         b'1', 1, '/file?name=product_supqn.png', 70, 21, 5, 44, 'Chuck Taylor All Star CX', 'BRAND4', 'CATEGORY2', 2),
        ('sydym', '2021-12-03 15:51:13', 'user1', 'user1', '2021-12-03 15:51:13',
         'POWERED-UP POSITIVITY.\r\nPremium leather and suede come together with a PU foam collar and wrapped rubber outsole for maximum comfort. A peace and unity graphic on the heel and footbed celebrates the positive, unifying force of basketball on culture. The Y-bar paneling and woven tongue label reference where we\'ve been,
         while the speckled CX midsole and lightweight,
         responsive CX comfort sockliner take us where we\'re going. Game-changing.\r\nWHY YOU SHOULD BE DOWN\r\nMid-top, archival-inspired shoe with premium leather and suede upper\r\nArchival Y-bar paneling and tongue logo\r\nPeace and unity graphic on heel and footbed\r\nPU foam collar and wrapped rubber outsole for comfort and stability\r\nCX foam sockliner and exaggerated, speckled midsole for lightweight and responsive comfort\r\n',
         b'1', 1, '/file?name=product_sydym.png', 100, 20, 5, 41, 'Weapon CX Peace & Unity', 'BRAND4', 'CATEGORY2', 2),
        ('szxtr', '2021-12-03 15:37:55', 'tienseller', 'admin', '2021-12-05 02:03:31',
         'MOVE IN COMFORT.\r\nThe Nike Dri-FIT Sports Clash Shorts help you stay cool and comfortable with breathable fabric made from 100% recycled polyester fibers. Lightweight stretch and openings in the hems allow you to move freely during training workouts. Any level, Sport Clash graphics combine inspiration from the team\'s uniforms and classic Nike cross-training details.\r\nMove freely\r\nThe slightly stretchy,
         breathable fabric design has vents in the hem that create extra stretch to help you move naturally.\r\nStay breathable\r\nNike Dri-FIT technology wicks sweat away from the skin to accelerate evaporation,
         helping to maintain breathability and comfort.\r\nExpress yourself\r\nPart of Nike\'s Sport Clash collection, these shorts combine classic cross-training DNA with innovative energy and a final logo filled with a brushstroke print that represents the creativity involved in training your sport.\r\n',
         b'1', 1, '/file?name=product_szxtr.png', 85, 3, 5, 42, 'Nike Dri-FIT Sport Clash', 'BRAND5', 'CATEGORY3', 26),
        ('tajwr', '2021-12-03 15:35:58', 'tienseller', 'admin', '2021-12-05 02:01:51',
         'ADDITIONAL SOFTNESS FOR MORE COMFORT.\r\nGive your all to your workout in the comfort of the Nike Dri-FIT Sport Clash T-Shirt, which features soft, stretchy fabric to maintain breathability and freedom of movement. It\'s made from at least 75% recycled polyester fibers. .\r\nSweat absorption\r\nNike Dri-FIT Technology wicks sweat away from the body to accelerate evaporation,
         helping to maintain breathability and coolness.\r\nTotal comfort\r\nThe woven fabric feels soft against the skin and its elasticity allows you to move naturally during training.\r\nEverything is in the details\r\nPart of Nike\'s Sport Clash collection, this shirt combines classic cross-training DNA with innovative energy. Plus, it features a sports team-inspired color-block style pattern and a brushstroke print that represents the fluidity and creativity with which you train.',
         b'1', 1, '/file?name=product_tajwr.png', 99, 3, 5, 42, 'Nike Dri-FIT Sport Clash', 'BRAND5', 'CATEGORY3', 26),
        ('taofy', '2021-12-03 15:31:57', 'user1', 'user1', '2021-12-03 15:31:57',
         'MAXIMUM INNOVATION MEETS MAXIMUM COMFORT.\r\n\r\n\r\n\r\nWith an edgy look inspired by the high-speed running shoe of the 90s, the Nike Air Max Furyosa NRG brings a bold new voice to fashion and comfort. The stacked and offset Air unit in the heel offers great cushioning The ultra-soft pillow in the heel, padded collar and padded tongue make you feel like you\'ve just stepped into your favorite sneakers. As if that wasn\'t enough, the double lacing system lets you unleash your expressiveness by adding an air of flair. handcrafted at your comfort five stars.\r\n\r\n\r\n\r\nStay bold and comfortable\r\nStacked, visible and offset: Air cushioning in the heel offers a fresh look that adds comfort to your experience.\r\n\r\n\r\n\r\nYou saw what you demand\r\nThe taller footbed, wider front and lower ankle - are \'specifically designed for the unique shape of a woman\'s foot\' and provide the perfect fit out of the box.\r\n\r\n\r\n\r\nBe spontaneous\r\nThe double lacing system keeps you expressive - wrap,
         tie, tie or
              remove to suit your style.\r\n\r\n\r\n\r\nTake a step towards luxury\r\nThe boot-style design creates a shoe within a shoe,
         giving you the luxurious feel of a slipper. The heel pad, super -
                                                                   soft tongue and low-profile padded collar feel great and provide a stylish look.\r\n\r\n\r\n\r\nMore benefits\r\nInspired by Nike running shoes inherited from the \'90s, the upper features wavy lines and a rich mix of materials like airy mesh and TPU eyelets.\r\nThe sleek toe design features a slightly wider toe box for additional comfort while maintaining a sleek shape.\r\nFoam midsole provides lightweight, durable cushioning.\r\nThe design is made with at least 20% of its weight recycled material and features an efficient graphic pattern to create less waste.\r\n\r\n\r\n\r\nProduct dates\r\nRubber outsole with Nike Grind and Waffle-inspired graphic pattern add traction and durability\r\nGrip clips\r\nMidfoot shank design and outsole create a smooth, understated ride\r\nAdditional set of laces\r\n90s style on branding\r\nColor Shown: Ash Slate / Venice / Provencal Purple / Summit White\r\nStyle: CZ4149-400\r\nCountry / Region of Origin: Vietnam\r\n\r\n\r\n\r\nOrigins of the Nike Air Max\r\nRevolutionary Air technology was first introduced into Nike footwear in 1978. In 1987, the Nike Air Max 1 debuted with visible Air technology in the heel, providing fans with much more than just the cushioned feel — Air: this comfort could also be seen. Since then, the latest generation Air Max shoe became a favorite with athletes and collectors for its attractive color combinations, as well as its lightweight and reliable cushioning.\r\n',
         b'1', 1, '/file?name=product_taofy.png', 339, 80, 5, 40, 'Nike Air Max Furyosa', 'BRAND1', 'CATEGORY2', 2),
        ('tmous', '2021-12-03 15:50:05', 'user1', 'user1', '2021-12-03 15:50:05',
         'Our Wicked push-up technology takes on swimwear. A ruched scoop neckline is universally flattering, while adjustable straps and a tie back create the perfect fit. \r\n•	Unlined with innovative sling to provide push-up without padding\r\n•	Underwire\r\n•	Adjustable straps\r\n•	Adjustable tie back\r\n•	Hand wash\r\n•	Imported',
         b'1', 1, '/file?name=product_tmous.png', 45, 3, 5, 42, 'Ice Queen Printed Wicked Swim Top', 'BRAND7',
         'CATEGORY3', 2);
INSERT INTO `product` (`code`, `created_date`, `created_by`, `modified_by`, `modified_date`, `description`, `in_stock`,
                       `is_available`, `picture_url`, `price`, `quantity`, `rating`, `size`, `title`, `brand_code`,
                       `category_code`, `seller_id`)
VALUES ('tnpop', '2021-12-03 16:43:08', 'datdatdf', 'datdatdf', '2021-12-03 16:43:08',
        'A sport style turned street classic, the California is one of PUMA’s most iconic silhouettes. We’ve updated the California for the next generation to create the Cali. Taking c...\r\n Style: 369155_04\r\n Color: Puma White-Puma Black\r\n',
        b'1', 1, '/file?name=product_tnpop.png', 80, 213, 5, 39, 'Cali Women\'s Sneakers', 'BRAND3', 'CATEGORY1', 22),
('tucgr', '2021-11-29 04:48:59', 'datdatdf', 'datdatdf', '2021-11-29 04:48:59', 'A pair of shoes with sporty style,
        lightweight design and subtle colors to help you shine in any situation', b'1', 1, '/file?name=product_tucgr.png', 200, 15, 5, 40, 'Nike Epic React', 'BRAND1', 'CATEGORY2', 22),
('txdlz', '2021-11-28 09:19:38', 'user1', 'user1', '2021-11-28 09:19:38', 'LEGENDARY STYLE REFINED.\r\n\r\nThe radiance lives on in the Nike Air Force 1 \'07, the b-ball OG that puts a fresh spin on what you know best: durably stitched overlays, clean finishes and the perfect amount of flash to make you shine.\r\n\r\nBenefits\r\n\r\nThe stitched overlays on the upper add heritage style, durability and support.\r\nOriginally designed for performance hoops, the Nike Air cushioning adds lightweight, all-day comfort.\r\nThe low-cut silhouette adds a clean, streamlined look.\r\nThe padded collar feels soft and comfortable.\r\n\r\nProduct Details',
        b'1', 1, '/file?name=product_txdlz.png', 99, 36, 5, 39, 'Nike Air Force 1.5 WE', 'BRAND1', 'CATEGORY2', 2),
       ('tykjm', '2021-12-03 16:02:10', 'user1', 'user1', '2021-12-03 16:02:10', 'We\'re not afraid to take a classic,
        rip it apart and put it back together – in this case, literally.The Suede Layers is an edgy,
        defiant challenge to the traditional streetst...\r\n Style: 381939_02\r\n Color: Puma Black-Puma White\r\n', b'1', 1, '/file?name=product_tykjm.png', 100, 10, 5, 43, 'Suede Layers', 'BRAND3', 'CATEGORY2', 2),
('tzcec', '2021-12-03 15:39:27', 'user1', 'user1', '2021-12-03 15:39:57', 'COPA SENSE.3 FIRM GROUND BOOTS\r\nLEATHER BOOTS FOR AN ENHANCED TOUCH.\r\nSome players need to be noticed. But the truly enlightened operate under the radar,
        slicing through the noise with the lightest touch. Focus on your football instincts in adidas Copa Sense. These boots reduce distractions with a stretchy collar that opens wide for easy entry. Their soft leather forefoot adapts to your foot\'s shape, adding assurance to every touch. The outsole keeps you a class apart on firm ground. This product is made with recycled content as part of our ambition to end plastic waste. 20% of pieces used to make the upper are made with minimum 50% recycled content.\r\n',
        b'1', 1, '/file?name=product_tzcec.png', 299, 40, 5, 38, 'COPA SENSE.3 FIRM GROUND BOOTS', 'BRAND1',
        'CATEGORY2', 2),
       ('ujfzq', '2021-12-03 15:25:04', 'hoanseller', 'hoanseller', '2021-12-03 15:25:04',
        'ALPHABOUNCE SHOES\r\nVERSATILE RUNNING SHOES FOR SPEED IN EVERY DIRECTION.\r\nThat competitive edge you\'ve been looking for? It\'s all in your training routine. These adidas running shoes keep you comfortable through gym workouts and short- to mid-distance runs. Supportive yet flexible, they have a stable feel during side-to-side exercises like ice skaters. Bounce cushioning feels springy underfoot.\r\n',
        b'1', 1, '/file?name=product_ujfzq.png', 299, 15, 5, 39, 'ALPHABOUNCE SHOES', 'BRAND2', 'CATEGORY1', 23),
       ('uthsj', '2021-11-29 04:50:28', 'datdatdf', 'datdatdf', '2021-11-29 04:50:28',
        'Shoes that combine elegance and sport will make you more masculine', b'1', 1, '/file?name=product_uthsj.png',
        250, 10, 5, 39, 'Nike Air Max 97', 'BRAND1', 'CATEGORY2', 22),
       ('vbknx', '2021-12-03 15:46:45', 'user1', 'admin', '2021-12-05 02:02:14',
        'The Jordan Flight Heritage T-Shirt is cut from structured high-density cotton for a relaxed fit, with a textured \"Flight\" lettering exploded to the back over a streamlined look of a famous Michael Jordan image.\r\nProfits\r\n•	High-density cotton fabric feels structured and premium.\r\n•	The fit is loose and the sleeves are longer with dropped shoulders.\r\n•	Graphics are a mix of smooth and textured prints.\r\n',
        b'1', 1, '/file?name=product_vbknx.png', 99, 3, 5, 42, 'Jordan Flight Heritage', 'BRAND5', 'CATEGORY3', 2),
       ('vgdif', '2021-12-03 15:46:08', 'hoanseller', 'hoanseller', '2021-12-03 15:46:08',
        'ULTRABOOST 21 SHOES\r\nCUSHIONED RUNNING SHOES MADE FOR ULTIMATE ENERGY RETURN.\r\nPrototype after prototype. Innovation after innovation. Testing after testing. Meet us in the hot pursuit of the pinnacle harmonization of weight, cushioning, and responsiveness. Ultraboost 21. Say hello to incredible energy return.\r\n\r\n',
        b'1', 1, '/file?name=product_vgdif.png', 799, 15, 5, 38, 'ULTRABOOST 21 SHOES', 'BRAND2', 'CATEGORY1', 23),
       ('vlqef', '2021-12-03 15:51:53', 'hoanseller', 'hoanseller', '2021-12-03 15:51:53',
        'ADIZERO ADIOS PRO SHOES\r\n10K TO MARATHON RACING SHOES MADE IN PART WITH RECYCLED MATERIALS.\r\nWhen it comes to the adidas Adizero Adios Pro running shoes, \"impossible\" isn\'t part of the vocabulary. Created with insights from the world\'s best, and made with record-breakers in mind, they help you unleash your full potential on race day. Two layers of Lightstrike Pro cushioning push the boundaries of energy return, and ENERGYRODS fine-tune stiffness for a snappy, explosive ride. That PB? It\'s time to smash it. Made with a series of recycled materials,
        this upper features at least 50% recycled content. This product represents just one of our solutions to help end plastic waste.\r\n\r\n', b'1', 1, '/file?name=product_vlqef.png', 899, 20, 5, 39, 'ADIZERO ADIOS PRO SHOES', 'BRAND2', 'CATEGORY1', 23),
('volsk', '2021-12-03 16:40:03', 'datdatdf', 'datdatdf', '2021-12-03 16:40:03', 'June Ambrose and PUMA Hoops are teaming up. Introducing the High Court Collection,
        coached by June Ambrose. This new line infuses the bold energy of women and their refusal to...\r\n Style: 382228_02\r\n Color: Whisper White-Puma Black\r\n', b'1', 1, '/file?name=product_volsk.png', 100, 80, 5, 39, 'Ralph Sampson Mid', 'BRAND3', 'CATEGORY1', 22),
('vvvta', '2021-12-03 15:42:44', 'user1', 'user1', '2021-12-03 15:42:44', 'GRAND COURT SE SHOES\r\nCLASSIC COURT SHOES READY FOR TODAY\'S STREETS.\r\nVintage vibes. New soul. These shoes have a clean and contemporary design with the bones of \'70s-era tennis trainers. This version has soft suede overlays and and a textured leather upper.\r\n', b'1', 1, '/file?name=product_vvvta.png', 199, 1, 5, 45, 'GRAND COURT SE SHOES', 'BRAND2', 'CATEGORY2', 2),
('vxusc', '2021-12-03 15:46:10', 'user1', 'user1', '2021-12-03 15:46:10', 'A DESIGN THAT SHOWS THE BEST OF AIR MAX.\r\n\r\n\r\n\r\nThe Nike Air VaporMax Evo illustrates the DNA of the Air Max and features the hallmarks of seven Nike icons, from
        the richly textured overlays to the TPU detailing on the heel and shank to the incredible Air cushioning and
        visible styling.The 90s,
        brings together the essential elements of the Air to create footwear that pays tribute to it.\r\n\r\n\r\n\r\nIconic style\r\nThe shoe takes elements from the Air Max generations,
        including the 90s, 93s, 96s, Air Max Plus, Tuned 99s, Solas and
                                                              180 +.It combines history with innovation and allows you to bring the best of the past into the present.\r\n\r\n\r\n\r\nThe comfort of the Swoosh\r\nOriginally designed for high-performance running,
        the VaporMax Air unit represents a new era in Nike innovation that captures the feeling of \"standing\" on the air.\r\n\r\n\r\n\r\nThe key is in the details\r\nThe upper combines flawless leather, durable synthetics and mesh for a punchy style that feels amazing.\r\n\r\n\r\n\r\nMore benefits\r\nStrategically placed rubber pads on the outsole provide durability and traction on all types of surfaces.\r\nThe tongue logo combines details inspired by the seven Air Max styles, in a nod to the Evo\'s predecessors from the 90s and early 2000s.\r\n\r\n\r\n\r\nProduct dates\r\nFoam midsole with soft feel\r\nHeel grip loop\r\nRound shoelaces\r\nThis product is not designed to be used as personal protective equipment (PPE)\r\nColor Shown: White / Black / Light Lemon Twist / Ice Lime\r\nStyle: DC9222-101\r\nCountry / Region of Origin: Vietnam\r\n\r\n\r\n\r\nNike Air VaporMax\r\nAfter the seven-year process from idea to launch, the Air VaporMax represents a new era in Nike innovation. The designers wanted to capture the feeling of \"running on air\" so they began to restructure the Air unit. to adhere directly to the upper. When you step on, each groove is pushed into the Air unit, increasing the pressure. When you lift your foot, the pressure is released, creating that springy bounce with superior flexibility. Specially designed For runners, futuristic technology was quickly adopted on the streets, making this incredible feeling of lightness available to everyone.\r\n', b'1', 1, '/file?name=product_vxusc.png', 359, 80, 5, 39, 'Nike Air Vapormax Evo', 'BRAND1', 'CATEGORY2', 2),
('vzlbl', '2021-11-29 04:52:50', 'datdatdf', 'datdatdf', '2021-11-29 04:52:50', 'With vintage style, these shoes will help you become more elegant', b'1', 1, '/file?name=product_vzlbl.png', 150, 15, 5, 39, 'Converse Chuck Taylor 1970s', 'BRAND4', 'CATEGORY2', 22),
        ('wkkdb', '2021-11-28 09:19:05', 'user1', 'user1', '2021-11-28 09:19:05',
         'LEGENDARY STYLE REFINED.\n\nThe radiance lives on in the Nike Air Force 1 \'07,
         the b-ball OG that puts a fresh spin on what you know best: durably stitched overlays,
         clean finishes and the perfect amount of flash to make you shine.\n\nBenefits\n\nThe stitched overlays on the upper add heritage style,
         durability and support.\nOriginally designed for performance hoops,
         the Nike Air cushioning adds lightweight, all - day comfort .\ nThe low - cut silhouette adds a clean,
         streamlined look.\nThe padded collar feels soft and comfortable.\n\nProduct Details', b'1', 1, '/file?name=product_wkkdb.png', 98, 35, 5, 40, 'Nike Air Force 2.2', 'BRAND1', 'CATEGORY2', 2),
('wlxbg', '2021-12-03 15:32:10', 'hoanseller', 'hoanseller', '2021-12-03 15:32:10', 'X9000L2 SHOES\r\nSLEEK RUNNING SHOES FOR MID-DISTANCE RUNS.\r\nWhen robots take over the world,
         you\'ll be able to outrun them in these adidas running shoes. They come equipped with lightweight and flexible Bounce cushioning. A booster pack of Jetboost in the heel delivers energy return and enhanced stability. This product is made with Primegreen, a series of high-performance recycled materials. 50% of the upper is recycled content.\r\n',
         b'1', 1, '/file?name=product_wlxbg.png', 285, 30, 5, 42, 'X9000L2 SHOES', 'BRAND2', 'CATEGORY1', 23),
        ('wmzdk', '2021-12-03 15:45:54', 'user1', 'user1', '2021-12-03 15:45:54',
         'ICONIC STYLE. MASTERFUL CRAFTSMANSHIP. THE CHUCK 70.\r\nThe Chuck 70 mixes the best details from the ’70s-era Chuck with impeccable craftsmanship and premium materials. An elevated style icon, it features more cushioning to keep you looking—and feeling—good all day. The Chuck 70 holds its own on fashion week runways and city streets, making it the go-to sneaker for those looking to enhance and express their style. The shoe’s timeless cool has made it a go-to sneaker for collaborators like Comme des Garçon and Tyler, the Creator.\r\nWHY YOU SHOULD BE DOWN\r\nCrafted in a premium canvas for durability and elevated feel.\r\nOrthoLite insole for comfort.\r\nHigh gloss eyelets make it shine.\r\nShiny, taller rubber sidewall and winged tongue stitching.\r\nHeritage details like a 1970’s heel logo nod to its legacy.\r\nCHUCK 70 ORIGINS\r\nBy 1970, the Chuck had evolved to become the pinnacle of function and utility for sport, and was considered the best basketball sneaker ever. The Chuck 70 is built off of the original 1970s design, with premium materials and an extraordinary attention to detail. A shoe so rooted in tradition that it has its own instant history. That\'s the Chuck 70. It\'s not a shoe. It\'s the shoe.\r\n', b'1', 1, '/file?name=product_wmzdk.png', 80, 3, 5, 45, 'Chuck 70', 'BRAND4', 'CATEGORY2', 2),
('wocbl', '2021-12-03 15:35:11', 'user1', 'user1', '2021-12-03 15:35:11', 'EQ21 RUN SHOES\r\nSHOES FOR THE DAILY RUNNER.\r\nWhen running is your sport,
         there\'s nothing you love more than that daily run. Log miles in ultimate comfort when you lace up in these adidas shoes. A breathable upper keeps feet feeling cool and fresh on warm days. Lightweight cushioning makes each step more enjoyable.\r\n',
         b'1', 1, '/file?name=product_wocbl.png', 109, 22, 5, 42, 'EQ21 RUN SHOES', 'BRAND2', 'CATEGORY2', 2),
        ('wolmx', '2021-12-03 15:54:00', 'user1', 'user1', '2021-12-03 15:54:00',
         'SPORTS INSPIRATION WITH A TOUCH OF SERENA WILLIAMS.\r\n\r\n\r\n\r\nMuch shorter than a biography and much more fun, the RYZ 365 2 footwear allows you to enter the world of Serena. The details hint at her accomplishments on and off the pitch, while the SDC \"10 4 01\" logo on the tongue represents the designers she chose to create a collection that allows you to be a part of her story.\r\n\r\n\r\n\r\nSport on the catwalk\r\nIn tribute to the athlete and fashion icon, details include gold grommets depicting Serena\'s victories in the United States,
         sawtooth edging for a runway glow, and beaded shoelaces hinting at ceremonial . tennis court protocol .\ r\ n\
         r\ n\ r\ n\ r\ nLong live the diversity\ r\ nThe authentic SDC label on the tongue features the \
         " 10 4 01\" logo in homage to diversity and inclusion (for more information, see the declaration of origin).\r\n\r\n\r\n\r\nInnovative and fun\r\nThe raised midsole features oversized cutouts to add dimension to the sporty look.\r\n\r\n\r\n\r\nMore benefits\r\nThe fun and innovative lacing system lets you add your own personality every day.\r\nThe low cut padded collar looks elegant and feels remarkably good.\r\nThe TPU plate connects to the midsole for stability and comfort.\r\n\r\n\r\n\r\nProduct dates\r\nEmbroidered Swoosh Design\r\nRubber details on the sole\r\nGripping loop\r\nColor Shown: Army Navy / Summit White / Cinnabar / Metallic Gold\r\nStyle: DJ1518-400\r\nCountry / Region of Origin: Vietnam\r\n\r\n\r\n\r\nSerena Design Crew\r\nThe Serena Design Crew is a group of emerging designers from New York City who celebrate craftsmanship, creativity and the art of dreaming. Chosen by Serena Williams, these 10 designers created a collection of footwear and apparel that tells the story of Serena\'s incredible career, on and off the court, while honoring the diverse backgrounds of each artist and promoting diversity and the inclution.\r\n', b'1', 1, '/file?name=product_wolmx.png', 175, 80, 5, 39, 'Nike RYZ 365 2 Serena Design Crew', 'BRAND1', 'CATEGORY2', 2),
           ('wxpas', '2021-12-03 16:35:04', 'datdatdf', 'datdatdf', '2021-12-03 16:35:04',
        'Definitely the most well-known and popular of all PUMA shoes, this sport classic is one of the shoes that started it all. As part of every street community from the 80\'
        s on, t...\ r\ n Style : 384175_01\ r\ n Color : Peyote\ r\ n', b' 1 ', 1, ' / file ? name = product_wxpas.
        png ', 70, 77, 5, 39, ' Suede Triplex Botanics Sneakers ', ' BRAND3 ', ' CATEGORY1 ', 22),
(' wxrvn ', ' 2021 - 12 - 03 06 : 55 : 31 ', ' admin ', ' admin ', ' 2021 - 12 - 03 06 : 55 : 31 ', ' MAXIMUM STYLE.
        MINIMUM IMPACT.\ r\ n\ r\ n\ r\ nThe Nike Waffle One Crater Shoe is a treat for the eyes and feet.Its fun
        speckled midsole (created from crater foam) sweetens the retro styling of the BRS with a modern twist.And for
        added depth, the upper part is made with at least 20 % recycled materials by weight, it includes transparent
        mesh so you can show off your set of socks.\ r\ n\ r\ n\ r\ nProfits\ r\ n\ r\ nMade with at least 20 %
        recycled materials by weight, the design includes a transparent upper that renews a favorite streetwear shoe.\ r\
        nThe double - stacked Crater foam midsole maintains the classic wedge shape of the Waffle franchise, while
        presenting a speckled look that is sure to turn heads.\ r\ nBefore Nike, there was Blue Ribbon Sports (BRS).
        This atmosphere of Nike heritage keeps the brand rooted in the original.\ r\ nThe iconic waffle rubber outsole
        with Nike Grind is updated with new molded studs for added support, traction and durability.\ r\ nThe low -
        profile collar features smooth, seamless edges to create a stylish look that feels comfortable.\ r\ n\ r\
        nProduct dates\ r\ n\ r\ nSheer mesh that lets you show off your socks\ r\ nRubber outsole with waffle pattern\
        r\ nReflective details\ r\ nThis product is not designed to be used as personal protective equipment (PPE)\ r\
        nColor Shown : Cream II / Orange / Black / White\ r\ nStyle : DC2650 - 200\ r\ nCountry / Region of Origin :
        Vietnam\ r\ n\ r\ nOrigins of waffle design\ r\ n\ r\ nIn 1971, as Nike co - founder Bill Bowerman watched his
        wife Barbra make breakfast in an iron waffle iron, inspiration came suddenly.He changed the dough for rubber
        and thus the waffle - type sole was born.Not only does it provide traction, durability and classic Nike
        style, it shows that greatness is in the everyday.And that old rusty iron waffle iron ? Well now it\
        's on a pedestal at Nike World Headquarters.\r\n\r\n\r\nBRS origin\r\n\r\nBefore Nike, there was Blue Ribbon Sports (BRS), a shoe distribution company founded in 1964 by Phil Knight and Oregon\'
        s leading track coach, Bill Bowerman.The company, rooted in sports, training and innovative accessories for
        the most popular athletic shoes, quickly established itself as a dominant and fast - paced presence.', b' 1
        ', 1, ' / file ? name = product_wxrvn.png ', 239, 15, 5, 38, ' Nike Waffle One Crater ', ' BRAND1 ', '
        CATEGORY2 ', 1),
(' wygkj ', ' 2021 - 12 - 03 16 : 30 : 52 ', ' datdatdf ', ' datdatdf ', ' 2021 - 12 - 03 16 : 30 : 52 ', ' GO WITH
        EVERYTHING, GO FAST.DO IT AGAIN.\ r\ n\ r\ n\ r\ n\ r\ nThe Nike SuperRep Go 2 with speckled accents
        combines lightweight underfoot cushioning and breathable mesh upper to keep you moving comfortably in track
        fitness classes or while training at home.and the added flexibility of the sole set you up for one more rep
        .\ r\ n\ r\ n\ r\ n\ r\ nFeel the fit\ r\ nThe upper is soft and breathable to provide more elasticity in the
        forefoot than the previous version, it also has a molded fit around the ankle and a soft padding on the neck
        and tongue for total comfort from front to back.\ r\ n\ r\ n\ r\ n\ r\ nMove with confidence\ r\ nA thick
        layer of soft, lightweight foam provides comfortable cushioning for jumps and squats.Channels in the forefoot
        provide flexibility for planks and other body - weight movements.Rubber outsole in heavy - duty areas provide
        durability and traction\ r\ n\ r\ n\ r\ n\ r\ nPrepare for what is coming\ r\ nA support covers the entire heel
        to support your foot, while the arch on the outside works as a reinforcement during lateral exercises.\ r\
        n', b' 1 ', 1, ' / file ? name = product_wygkj.png ', 172, 66, 5, 41, ' Nike SuperRep Go 2 ', ' BRAND1 ', '
        CATEGORY2 ', 22),
(' wzbyq ', ' 2021 - 12 - 03 15 : 32 : 19 ', ' tienseller ', ' admin ', ' 2021 - 12 - 05 02 : 02 : 30 ', ' ADVANCED SOFT
        AND WARMTH.\ r\ nThe Nike Therma - FIT Hoodie helps you stay warm and breathable before, during and after your
        workout with soft, sweat - wicking fleece.Made from at least 50 % recycled polyester fibers and logos High -
        tech, honors applied science to training that keeps your performance at its best, now and in the future.\ r\
        nWarm comfort\ r\ nSoft fleece with Nike Therma - FIT technology helps control your body\
        's natural heat to keep you warm in cold weather conditions.\r\nSweat absorption\r\nMoisture wicking technology wicks sweat away from the body to accelerate evaporation and maintain breathability and comfort.\r\nUseful storage\r\nThe front pocket allows you to carry your things and keep your hands warm. The hidden zippered pocket on the right is safe to store your phone.\r\n',
        b'1', 1, '/file?name=product_wzbyq.png', 119, 3, 5, 42, 'Nike Therma-FIT', 'BRAND5', 'CATEGORY3', 26),
        ('xblbi', '2021-12-03 16:00:47', 'user1', 'user1', '2021-12-03 16:00:47',
         'Get your tricolour on in the Suede Triplex Sneakers. This new addition to the iconic Suede family takes our influential 1960s silhouette and spruces it up with a triple Formst...\r\n Style: 381175_13\r\n Color: Peacoat-Maize-Puma White\r\n',
         b'1', 1, '/file?name=product_xblbi.png', 100, 44, 5, 44, 'Suede Triplex Sneakers', 'BRAND3', 'CATEGORY2', 2),
        ('xexco', '2021-12-03 07:02:31', 'admin', 'admin', '2021-12-03 07:02:31',
         'PUT ON THE SOFTNESS.\r\n\r\n\r\nImagine a shoe that you don\'t have to tie,
         but simply put it on and go. The Nike Glide FlyEase makes your dreams come true with a FlyEase design to easily put your shoe on. Luxurious and comfortable,
         it has ZoomX foam cushioning for a reactive footprint.\r\n\r\n\r\nQuick and easy adjustment\r\n\r\nThe shoe features the FlyEase design for hands-free donning and doffing, and
         the shoe features a flexible heel that folds up when you put it on and then returns to its original position
         to ensure a secure fit .\ r\ n\ r\ n\ r\ nCushioning and support\ r\ n\ r\ nThe part of the cushioning located
         just under the foot is made with ZoomX foam to offer an extremely soft feeling and immediate response .\ r\ n\
         r\ n\ r\ nSlip - on, comfortable fit\r\n\r\nThe thick,
         elastic cord stretches over the foot to keep the shoe snug without the need for traditional laces.\r\n\r\n\r\nMore benefits\r\n\r\nLightweight upper includes breathable mesh overlay.\r\nThe insole adds a layer of cushioning.\r\nColor Shown: Mercury Gray / Black / Fog Gray / Fog Gray\r\nStyle: DN4919-001\r\nCountry / Region of Origin: Vietnam', b'1', 1, '/file?name=product_xexco.png', 2699, 20, 5, 40, 'Nike Glide FlyEase', 'BRAND1', 'CATEGORY2', 1),
('xgdvi', '2021-12-03 15:33:46', 'user1', 'user1', '2021-12-03 15:33:46', 'X SPEEDFLOW.3 TURF BOOTS\r\nA LIGHTWEIGHT BOOT FOR YOUR VERSION OF SPEED.\r\nOn the pitch,
         speed is a virtue. On the court,
         it\'s the only thing that counts. Think fast. Move faster. Find your flow and leave the rest behind. Take everything in your stride in these adidas X football boots. Their semi-translucent Speedskin upper keeps you comfortable as you explode into action. Underneath, a lugged rubber outsole lays down serious acceleration on artificial turf. The foot-hugging fit straps you in for jinks and turns to keep you one step ahead.\r\n',
         b'1', 1, '/file?name=product_xgdvi.png', 99, 22, 5, 45, 'X SPEEDFLOW.3 TURF BOOTS', 'BRAND2', 'CATEGORY2', 2),
        ('xirjb', '2021-12-03 15:44:09', 'user1', 'user1', '2021-12-03 15:44:09',
         'RELAXATION COMFORT, REINVENTED.\r\n\r\n\r\n\r\nFrom the beach to the stands, the Nike Victori One Flip Flop perfects a classic design that you can\'t miss. With lightweight,
         easy - to -use comfort,
         it features a new softer foam that feels comfortable. Molded insole with grippy graphic pattern helps support and keep your foot in place. The wide,
         padded strap feels as good as it looks.\r\n\r\n\r\n\r\nProfits\r\nNew softer foam and mechanical cushioning add incredible comfort that lasts.\r\nThe molded sockliner supports and supports your foot,
         while the grippy graphic pattern helps keep your foot in place.\r\nThe rolled top edge of the strap adds comfort while the thick padding feels soft.\r\nWider strap adds extra room and fits more foot sizes.\r\nConstruction features a new graphic pattern for added traction.\r\n\r\n\r\n\r\nProduct dates\r\nBold \"NIKE\" and Swoosh on the strap let you represent the brand\r\nThe graphic pattern on the strap is perfectly on trend\r\nColor Shown: Desert Sand / Summit White / Black\r\nStyle: CN9676-007\r\nCountry / Region of Origin: Indonesia\r\n', b'1', 1, '/file?name=product_xirjb.png', 79, 80, 5, 40, 'Nike Victori One', 'BRAND1', 'CATEGORY1', 2),
('xmkkq', '2021-12-03 15:52:47', 'user1', 'user1', '2021-12-03 15:52:47', 'She’s the one. Push-up padding and adjustable straps provide maximum support for added confidence. The ruched torso detail accentuates your curves and smooths your midsection, creating a slimming feeling and flattering fit.\r\n•	One-piece swimsuit \r\n•	Push-up padding \r\n•	Wireless \r\n•	Adjustable back ties \r\n•	Halter neckline \r\n•	Ruched sides \r\n•	Moderate back coverage: shows a little, but not all \r\n•	Imported', b'1', 1, '/file?name=product_xmkkq.png', 95, 3, 5, 42, 'Marieta Push-Up One-piece', 'BRAND7', 'CATEGORY3', 2),
         ('xykrh', '2021-11-28 13:39:40', 'datdatdf', 'datdatdf', '2021-11-28 13:39:40',
          'A pair of white shoes with sporty and youthful style', b'1', 1, '/file?name=product_xykrh.png', 100, 20, 5,
          37, 'Adidas SuperStar', 'BRAND2', 'CATEGORY2', 22),
         ('yacwj', '2021-12-03 15:49:18', 'user1', 'user1', '2021-12-03 15:49:18',
          'VINTAGE CANVAS. NEW COLORS.\r\nBlurring the lines of digital and natural realities, we\'ve updated the premium Chuck 70 with durable,
          12oz vintage canvas in new colors. The Chuck 70 mixes the best details from the ’70s-era Chuck with impeccable craftsmanship and premium materials. An elevated style icon,
          it features more cushioning to keep you looking—and feeling—good all day.\r\nWHY YOU SHOULD BE DOWN\r\nCrafted in a premium canvas for an elevated feel.\r\nEnhanced cushioning provides all-day comfort and support.\r\nFresh seasonal colors to refresh your rotation.\r\nShiny,
          taller rubber sidewall and winged tongue stitching.\r\nHeritage details like a 1970s heel logo nod to its legacy.\r\n', b'1', 1, '/file?name=product_yacwj.png', 80, 11, 5, 45, 'Converse Color Chuck 70', 'BRAND4', 'CATEGORY2', 2),
('yfbyz', '2021-12-03 16:15:39', 'tienseller', 'tienseller', '2021-12-03 16:32:03', 'DON\'T REST ALPHASKIN PADDED 3-STRIPES BRA\r\nA MEDIUM-SUPPORT WORKOUT BRA WITH LIGHT COMPRESSION.\r\nFrom HIIT to spin class, you never stop pushing yourself. This adidas bra is designed for all your workouts. The medium-support bra hugs the body with a compression fit that reduces bouncing and gives you confidence for kickboxing workouts and cardio classes. The mesh back lets air circulate so you stay cool.\r\n',
          b'1', 1, '/file?name=product_yfbyz.png', 85, 3, 5, 42, 'DON\'T REST ALPHASKIN PADDED 3-STRIPES BRA', 'BRAND6', 'CATEGORY3', 26),
('yijos', '2021-12-03 16:12:39', 'hoanseller', 'hoanseller', '2021-12-03 16:12:39', 'ELEVATED STYLE.\r\nInspired by the iconic looks of \'90s girl bands, the Converse Chuck Taylor All Star Clean Platform Leather High Top sneaker is sure to turn heads. Premium leather gives off an edgy vibe, while a double-stacked sole takes you higher. Get Platformed.\r\nWHY YOU SHOULD BE DOWN\r\n•	Luxe leather upper provides a superior feel.\r\n•	High profile for a classic look.\r\n•	Elevated platform for added height.\r\n•	Lace-up style for an adjustable fit.\r\n•	Iconic Star ankle patch.',
          b'1', 1, '/file?name=product_yijos.png', 75, 40, 5, 43, 'Clean Leather Platform', 'BRAND4', 'CATEGORY1', 23),
         ('yliof', '2021-12-03 16:26:48', 'datdatdf', 'datdatdf', '2021-12-03 16:26:48',
          'A DESIGN THAT CONTINUES TO KEEP RUNNERS MOVING.\r\n\r\n\r\n\r\nThe Nike React Infinity Run Flyknit 2 shoe helps you reduce injuries and keep you moving. The revamped upper uses Flywire technology that combines with Flyknit to deliver support and breathability where you need it most. Higher foam provides a soft, immediate response. Long-lasting comfort - It\'s still one of our most proven footwear,
          designed so you feel the potential when your foot hits the pavement.\r\n\r\n\r\n\r\njoin up\r\nThis special edition color scheme celebrates unity, as
          athletes from around the world resurface from the events of last year to compete . It\
          's a celebration of sport, humanity and our ability to push through the toughest challenges.\r\n\r\n\r\n\r\nCelebrate the Swoosh\r\nThe Swoosh celebrates its 50th anniversary by combining the past and present, the original Swoosh appears over the current version to represent the path that Nike has traveled.\r\n\r\n\r\n\r\nVentilation where you need it\r\nEnhanced Flyknit upper has breathability zones where you need it. It\'
          s strong and durable,
          helping to keep your foot secure through every mile. Flywire technology offers more support and stability in the foot.\r\n\r\n\r\n\r\nSoft tread\r\nNike React technology is a lightweight,
          durable foam that provides a smooth ride and immediate response. Its rocking chair design offers support during all three phases of a runner\'s stride. Provides flexibility when you lift your foot off the ground, a soft tread when the foot moves forward and cushioning when in contact with the ground.\r\n\r\n\r\n\r\nCushioned feel, higher sole\r\nLess material between the insole and midsole to be closer to the foam. This helps create an immediate response from the shoe. The foam is higher, providing a softer feel.\r\n\r\n\r\n\r\nProfits\r\nThe increased volume of rubber in the outsole helps provide traction and durability.\r\nCushioned collar provides soft comfort.\r\nThe wider shape provides a more stable footprint and helps unleash energy with every step.\r\nAdjustable heel closure allows you to slip on and off your shoe with ease.\r\nColor Shown: White / Sail / Avalanche Pink / Black\r\nStyle: DJ5396-100\r\nCountry / Region of Origin: Vietnam\r\n\r\n\r\n\r\nTested for miles\r\nTests show * that the Nike React Infinity Running 2 reduces injuries at a rate similar to that of the Nike React Infinity: in an independent study, the latter showed a 52% reduction in injuries compared to the Nike Air Zoom Structure 22, our traditional motion control shoe. * In an external study of 226 men and women during a variable 12-week training program conducted in 2019, the Nike React Infinity Run reduced running injuries by 52% compared to the Nike Air Zoom Structure 22 (injury = missing 3 or more consecutive runs due to running-related pain) Participants reported running-related injuries and progress using online questionnaires Our study found that 30,3% of the runners who used the Nike Air Zoom Structure 22 suffered an injury, while only 14.5% of the runners who used the Nike React Infinity Run suffered an injury. In a second study conducted in 2020, using the same protocol, the Nike React Infinity Run 2 did not show statistically significant differences in the incidence of injuries compared to the Nike React Infinity Run models of previous years.The Nike React Infinity Run 2 did not show statistically significant differences in injury incidence from previous years\' Nike React Infinity Run models.The Nike React Infinity Run 2 did not show statistically significant differences in injury incidence from previous years\' Nike React Infinity Run models.\r\n',
          b'1', 1, '/file?name=product_yliof.png', 247, 60, 5, 40, 'Nike React Infinity Run Flyknit 2', 'BRAND1',
          'CATEGORY2', 22),
         ('ylkaw', '2021-12-03 15:34:26', 'user1', 'user1', '2021-12-03 15:34:26',
          'X SPEEDFLOW.4 TURF BOOTS\r\nA LIGHTWEIGHT BOOT FOR YOUR VERSION OF SPEED.\r\nOn the pitch, speed is a virtue. On the court, it\'s the only thing that counts. Think fast. Move faster. Find your flow and leave the rest behind. Take everything in your stride in these adidas X football boots. Their soft,
          coated textile upper offers a comfortable ride as you explode into action. Underneath,
          a lugged rubber outsole keeps you quick on artificial turf.', b'1', 1, '/file?name=product_ylkaw.png', 99, 22, 5, 41, 'X SPEEDFLOW.4 TURF BOOTS', 'BRAND2', 'CATEGORY2', 2),
('yqjxd', '2021-12-03 06:44:53', 'admin', 'admin', '2021-12-03 06:44:53', 'SPLASHED IN RED.\r\n\r\n\r\nThis Nike Air Max 270 features an all-over red colorway,
          while offering everything that makes this shoe famous. The massive Max Air unit and sock-like fit bring modern comfort to a shoe inspired by the \'91 Air Max 180.\r\n\r\n\r\nProfits\r\n\r\nThe high-volume Max Air unit provides responsive cushioning for a smooth ride.\r\nStretch inner sleeve features a sock-like fit that feels soft.\r\nStructured heel pin offers stability when you\'re on the go.\r\nFull-length mesh adds ventilation where you need it most.\r\n\r\nProduct dates\r\n\r\nTextile and synthetic upper\r\nColor Shown: University Red / Black / University Red\r\nStyle: CV7544-600\r\nCountry / Region of Origin: Vietnam', b'1', 1, '/file?name=product_yqjxd.png', 3119, 20, 5, 38, 'Nike air max 270', 'BRAND1', 'CATEGORY2', 1),
('yqulx', '2021-12-03 15:42:16', 'user1', 'user1', '2021-12-03 16:22:27', 'ADIZERO ADIOS 6 SHOES\r\nLIGHTWEIGHT RUNNING SHOES FOR RACING AND TRAINING.\r\nThe intervals,
          tempo runs and chilly morning sessions paid off. You made it to the starting line. All that\'s left is to kick into gear and go the distance in these adidas running shoes. Their mesh upper is so lightweight you\'ll barely feel it on the course. Lightstrike cushioning gives a responsive and snappy ride.', b'1', 1, '/file?name=product_yqulx.png', 300, 4, 5, 38, 'ADIZERO ADIOS 6 SHOES', 'BRAND2', 'CATEGORY2', 2),
('ytqnu', '2021-12-03 16:01:27', 'user1', 'user1', '2021-12-03 16:01:27', 'This season,
          we launch the iconic PUMA Suede into the 21st century in this new mid-top silhouette. The classic style from the \'60s hits new heights with a mid-top padded colla...\r\n Style: 380205_03\r\n Color: High Risk Red-Puma White\r\n',
          b'1', 1, '/file?name=product_ytqnu.png', 134, 33, 5, 45, 'Suede Mid XXI', 'BRAND3', 'CATEGORY2', 2),
         ('zjzya', '2021-12-03 16:37:25', 'datdatdf', 'datdatdf', '2021-12-03 16:37:25',
          'Back in the ‘80s, the original RS (short for “running system”) was PUMA’s innovative cushioning technology. Today, the RS has reinvented itself in the RS-X, featuring a bulky ...\r\n Style: 371808_01\r\n Color: Pastel Parchment-Bridal Rose-Sulphur\r\n',
          b'1', 1, '/file?name=product_zjzya.png', 110, 79, 5, 37, 'RS-X Unexpected Mixes', 'BRAND3', 'CATEGORY1', 22),
         ('zkljd', '2021-12-03 15:45:58', 'user1', 'admin', '2021-12-05 02:02:49',
          'THIS IS THE SEASON OF JUMPMAN.\r\nInspired by the holiday knitted sweaters, this Jordan brand long sleeve t-shirt is the perfect gift for everyone on your list.\r\nProfits\r\n•	Cotton fabric feels soft and light for every day.\r\n•	The fit is loose fitting and easy to wear with a versatile shape.\r\n',
          b'1', 1, '/file?name=product_zkljd.png', 79, 3, 5, 42, 'Jordan Fiesta de la marca', 'BRAND5', 'CATEGORY3',
          2),
         ('zqoeo', '2021-12-03 16:01:32', 'user1', 'user1', '2021-12-03 16:01:32',
          'A classic wrap skirt to cover you up, here in an electric floral print.\r\nFOR LOVE & LEMONS FOR VICTORIA’S SECRET: An exclusive collaboration that blends dreamy confidence with thoughtful detailing, giving each piece a unique and feminine feel.\r\n•	Swim cover-up\r\n•	Mini skirt\r\n•	Self-tie waist\r\n•	Hand wash\r\n•	Imported',
          b'1', 1, '/file?name=product_zqoeo.png', 108, 3, 5, 42, 'Lizzy Floral Skirt Cover-up', 'BRAND7', 'CATEGORY3',
          2),
         ('zrofq', '2021-12-03 16:24:58', 'datdatdf', 'datdatdf', '2021-12-03 16:24:58',
          'NEXT STOP: LEGENDARY STATUS.\r\n\r\n\r\n\r\nGet on the go in premium comfort. The Nike Air Max 97 LX lets you take your style at full speed with its iconic wavy design inspired by Japanese bullet trains. Re-invented with a braided design on the upper, its construction feels great with or No socks. Decorative vents along the sides add a fresh touch to the icon.\r\n\r\n\r\n\r\nProfits\r\nThe synthetic leather and textile upper maintains the flowing look of the classic, while adding incredible breathability and comfort.\r\nWear it with or without socks, the decorative vents on the sides add an airy feel and allow you to show off your socks.\r\nOriginally designed for high-performance running, the long Max Air unit provides long-lasting comfort.\r\nThe foam sole feels stretchy and comfortable.\r\n\r\n\r\n\r\nProduct dates\r\nRubber sole\r\nFoam insole\r\nReticulated lacing system\r\nGripping loop\r\nColor Shown: Fossil / White / Gum Yellow / Fossil\r\nStyle: DC4144-200\r\nCountry / Region of Origin: Indonesia\r\n\r\n\r\n\r\nOrigins of the Nike Air Max\r\nRevolutionary Air technology was first introduced into Nike footwear in 1978. In 1987, the Nike Air Max 1 debuted with visible Air technology in the heel, providing fans with much more than just the feeling of Air cushioning: this Comfort could also be seen. Since then, the next-generation Air Max shoe became a favorite with athletes and collectors for its attractive color combinations, as well as its lightweight and reliable cushioning.\r\n',
          b'1', 1, '/file?name=product_zrofq.png', 319, 60, 5, 40, 'Nike Air Max 97 LX', 'BRAND1', 'CATEGORY2', 22),
         ('zzrba', '2021-11-28 09:18:24', 'user1', 'user1', '2021-11-28 09:18:24',
          'LEGENDARY STYLE REFINED.\r\n\r\nThe radiance lives on in the Nike Air Force 1 \'07,
          the b-ball OG that puts a fresh spin on what you know best: durably stitched overlays,
          clean finishes and the perfect amount of flash to make you shine.\r\n\r\nBenefits\r\n\r\nThe stitched overlays on the upper add heritage style,
          durability and support.\r\nOriginally designed for performance hoops,
          the Nike Air cushioning adds lightweight, all - day comfort .\ r\ nThe low - cut silhouette adds a clean,
          streamlined look.\r\nThe padded collar feels soft and comfortable.\r\n\r\nProduct Details', b'1', 1, '/file?name=product_zzrba.png', 96, 33, 5, 42, 'Nike Air Force 2.1', 'BRAND1', 'CATEGORY2', 2);

-- --------------------------------------------------------

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`code`, `created_date`, `created_by`, `modified_by`, `modified_date`, `name`) VALUES
('ADMIN', NULL, NULL, NULL, NULL, 'Admin'),
('ADMIN1', NULL, NULL, NULL, NULL, 'Product Admin'),
('ADMIN2', NULL, NULL, NULL, NULL, 'Seller Admin'),
('ADMIN3', NULL, NULL, NULL, NULL, 'Customer Admin'),
('BUYER', NULL, NULL, NULL, NULL, 'Buyer'),
('SELLER', NULL, NULL, NULL, NULL, 'Seller');

-- --------------------------------------------------------

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `created_date`, `created_by`, `modified_by`, `modified_date`, `address`, `birthday`, `email`, `first_name`, `gender`, `is_active`, `last_name`, `password`, `phone`, `username`, `payment_method_id`, `role_code`, `chat_plugin_script`) VALUES
(1, NULL, NULL, 'admin', '2021-12-10 17:48:18', 'TPHCM', '2001-04-20', 'abc@123.com', 'Nguyen', 'Male', 1, 'Admin', '123456789@', '0123456789', 'admin', 1, 'ADMIN', NULL),
(2, NULL, NULL, 'user1', '2022-02-15 08:59:37', 'TPHCM', '2001-04-20', 'abc@123.com', 'Nguyen', 'Female', 1, 'Anh 1', '123456', '0123456789', 'user1', 1, 'SELLER', '<!-- Messenger Plugin chat Code -->\r\n    <div id=\"fb-root\"></div>\r\n\r\n    <!-- Your Plugin chat code -->\r\n    <div id=\"fb-customer-chat\" class=\"fb-customerchat\">\r\n    </div>\r\n\r\n    <script>\r\n      var chatbox = document.getElementById(\'fb-customer-chat\');\r\n      chatbox.setAttribute(\"page_id\", \"100970318176532\");\r\n      chatbox.setAttribute(\"attribution\", \"biz_inbox\");\r\n\r\n      window.fbAsyncInit = function() {\r\n        FB.init({\r\n          xfbml            : true,\r\n          version          : \'v12.0\'\r\n        });\r\n      };\r\n\r\n      (function(d, s, id) {\r\n        var js, fjs = d.getElementsByTagName(s)[0];\r\n        if (d.getElementById(id)) return;\r\n        js = d.createElement(s); js.id = id;\r\n        js.src = \'https://connect.facebook.net/en_US/sdk/xfbml.customerchat.js\';\r\n        fjs.parentNode.insertBefore(js, fjs);\r\n      }(document, \'script\', \'facebook-jssdk\'));\r\n    </script>'),
(6, NULL, NULL, 'user5', '2022-02-19 16:00:11', '01234567890', '2022-02-16', 'abc@123.com', 'Nguyen', 'Female', 1, 'Anh 5', '123456', '', 'user5', 3, 'BUYER', NULL),
          (19, '2021-11-28 08:24:06', 'anonymousUser', 'anonymousUser', '2021-11-28 08:24:06', NULL, '2001-04-15',
           'caovy2001@gmail.com', 'Cao', NULL, 1, 'Vy', '123456', '0975543975', 'vyphotphet100', NULL, 'SELLER', NULL),
          (20, '2021-11-28 09:58:15', 'anonymousUser', 'hoanne', '2021-12-02 18:26:44',
           '210/10 Sawmbram Eatam Buôn Ma Thuột', '2001-09-17', 'nguyenthienhoangeatam@gmail.com', 'Nguyen', NULL, 1,
           'Hoan', 'hoan17092001', '0378911238', 'hoanne', 1, 'BUYER', NULL),
          (21, '2021-11-28 12:43:33', 'anonymousUser', 'vyphotphet101', '2021-11-29 04:14:13',
           'Thôn Tiền Phong, xã Trung Hóa', '2021-11-09', 'caovy2001@gmail.com', 'Cao', NULL, 1, 'Vy Buyer', '123456',
           '0975543975', 'vyphotphet101', 2, 'BUYER', NULL),
          (22, '2021-11-28 13:33:29', 'anonymousUser', 'datdatdf', '2021-11-28 13:42:44',
           'k8 Phú Đức Tam Nông Đồng Tháp', '2001-01-05', 'datdragon168@gmail.com', 'dat', NULL, 1, 'nguyen',
           'datwerwer123', '0378911238', 'datdatdf', 1, 'SELLER', NULL),
          (23, '2021-12-03 08:09:13', 'anonymousUser', 'hoanseller', '2021-12-08 04:09:00', NULL, '2001-09-17',
           'profession3005@gmail.com', 'Hoan', NULL, 1, 'Ne', '123456', '0794676336', 'hoanseller', NULL, 'SELLER',
           '<!-- Messenger Plugin chat Code -->\r\n    <div id=\"fb-root\"></div>\r\n\r\n    <!-- Your Plugin chat code -->\r\n    <div id=\"fb-customer-chat\" class=\"fb-customerchat\">\r\n    </div>\r\n\r\n    <script>\r\n      var chatbox = document.getElementById(\'fb-customer-chat\');\r\n      chatbox.setAttribute(\"page_id\", \"108828571645399\");\r\n      chatbox.setAttribute(\"attribution\", \"biz_inbox\");\r\n    </script>\r\n\r\n    <!-- Your SDK code -->\r\n    <script>\r\n      window.fbAsyncInit = function() {\r\n        FB.init({\r\n          xfbml            : true,\r\n          version          : \'v12.0\'\r\n        });\r\n      };\r\n\r\n      (function(d, s, id) {\r\n        var js, fjs = d.getElementsByTagName(s)[0];\r\n        if (d.getElementById(id)) return;\r\n        js = d.createElement(s); js.id = id;\r\n        js.src = \'https://connect.facebook.net/vi_VN/sdk/xfbml.customerchat.js\';\r\n        fjs.parentNode.insertBefore(js, fjs);\r\n      }(document, \'script\', \'facebook-jssdk\'));\r\n    </script>'),
          (24, '2021-12-03 11:43:47', 'anonymousUser', 'Ziết Lon', '2021-12-03 11:46:17', '1111', '1201-01-01', 'l@f',
           'Ziết Lon ', NULL, 1, '.', '123', '7086955922123420', 'Ziết Lon', 1, 'BUYER', NULL),
          (25, '2021-12-03 15:22:54', 'anonymousUser', 'anonymousUser', '2021-12-03 15:22:54', NULL, '2001-01-06',
           'levietlongx3@gmail.com', 'Viết Long', NULL, 1, 'Lê ', '123', '0708695592', 'Longseller', NULL, 'SELLER',
           NULL),
          (26, '2021-12-03 15:25:10', 'anonymousUser', 'tienseller', '2021-12-03 16:32:16', NULL, '2001-06-05',
           '19110059@student.hcmute.edu.vn', 'Hồ', NULL, 1, 'Tiên', 'acidblack', '0779604768', 'tienseller', NULL,
           'SELLER', NULL),
          (27, '2021-12-03 16:18:05', 'anonymousUser', 'anonymousUser', '2021-12-03 16:18:05', NULL, '2001-09-17',
           'profession3005@gmail.com', 'Nguyen', NULL, 1, 'Hoan', '123456', '0938561346', 'hoancustomer', NULL,
           'BUYER', NULL),
          (28, '2021-12-06 07:14:02', 'anonymousUser', 'admin', '2022-02-12 20:19:55', 'BMT, Đâu Đó Nha Bạn',
           '2001-09-17', 'Hoan@gmail.com', 'Hoan', 'Male', 1, 'Ne', '123456', '0794676336', 'hoan1', 3, 'BUYER', NULL),
          (29, '2021-12-07 14:04:36', 'anonymousUser', 'admin', '2022-02-12 20:16:04', 'Ho Chi Minh', '2001-09-17',
           'nguyenthienhoangeatam@gmail.com', 'Nguyen', NULL, 0, 'Hoan', 'hoan17092001', '0794676336', 'hoan123', 3,
           'BUYER', NULL),
          (30, '2021-12-07 14:16:27', 'anonymousUser', 'vyseller', '2021-12-10 03:12:55', NULL, '2001-12-04',
           'caovy2001@gmail.com', 'Cao', NULL, 1, 'Vy', '123456', '0975543975', 'vyseller', NULL, 'SELLER',
           '<!-- Messenger Plugin chat Code -->\r\n    <div id=\"fb-root\"></div>\r\n\r\n    <!-- Your Plugin chat code -->\r\n    <div id=\"fb-customer-chat\" class=\"fb-customerchat\">\r\n    </div>\r\n\r\n    <script>\r\n      var chatbox = document.getElementById(\'fb-customer-chat\');\r\n      chatbox.setAttribute(\"page_id\", \"100970318176532\");\r\n      chatbox.setAttribute(\"attribution\", \"biz_inbox\");\r\n    </script>\r\n\r\n    <!-- Your SDK code -->\r\n    <script>\r\n      window.fbAsyncInit = function() {\r\n        FB.init({\r\n          xfbml            : true,\r\n          version          : \'v12.0\'\r\n        });\r\n      };\r\n\r\n      (function(d, s, id) {\r\n        var js, fjs = d.getElementsByTagName(s)[0];\r\n        if (d.getElementById(id)) return;\r\n        js = d.createElement(s); js.id = id;\r\n        js.src = \'https://connect.facebook.net/en_US/sdk/xfbml.customerchat.js\';\r\n        fjs.parentNode.insertBefore(js, fjs);\r\n      }(document, \'script\', \'facebook-jssdk\'));\r\n    </script>'),
          (31, NULL, NULL, NULL, NULL, 'TPHCM', '2001-04-20', 'abc@123.com', 'Nguyen', 'Male', 1, 'Admin', '123456',
           '0123456789', 'admin1', 1, 'ADMIN1', NULL),
          (32, NULL, NULL, NULL, NULL, 'TPHCM', '2001-04-20', 'abc@123.com', 'Nguyen', 'Male', 1, 'Admin', '123456',
           '0123456789', 'admin2', 1, 'ADMIN2', NULL),
          (33, NULL, NULL, NULL, NULL, 'TPHCM', '2001-04-20', 'abc@123.com', 'Nguyen', 'Male', 1, 'Admin', '123456',
           '0123456789', 'admin3', 1, 'ADMIN3', NULL);
