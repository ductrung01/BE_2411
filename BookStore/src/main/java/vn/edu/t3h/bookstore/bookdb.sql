-- MySQL dump 10.13  Distrib 8.0.35, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bookshopdb
-- ------------------------------------------------------
-- Server version	8.0.35
CREATE DATABASE IF NOT EXISTS bookshopdb;
USE bookshopdb;
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Table structure for table `role`
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `name` varchar(255) NOT NULL,
                        `code` varchar(50) NOT NULL,
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table `role`
LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Admin','ROLE_ADMIN'),(2,'User','ROLE_USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

-- Table structure for table `user`
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `username` varchar(25) NOT NULL,
                        `password` varchar(32) NOT NULL,
                        `fullname` varchar(50) NOT NULL,
                        `email` varchar(50) NOT NULL,
                        `phoneNumber` varchar(11) NOT NULL,
                        `gender` bit(1) NOT NULL,
                        `address` varchar(200) NOT NULL,
                        `role_id` int DEFAULT NULL,
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `uq_username` (`username`),
                        UNIQUE KEY `uq_email` (`email`),
                        UNIQUE KEY `uq_phoneNumber` (`phoneNumber`),
                        KEY `role_id` (`role_id`),
                        CONSTRAINT `user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table `user`
LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES
                       (1,'admin','CuYQCQdpCYhQnlYY29mJmg==','Dunn Mcpherson','dunnmcpherson@recrisys.com','0989894900',_binary '\0','8 Virginia Place, Troy, Norway',1),
                       (2,'user2','8t5mSQk7MAVO0AyN+yItYQ==','Foreman Carter','foremancarter@recrisys.com','0993194154',_binary '\0','28 Richardson Street, Layhill, Netherlands',2),
                       (3,'user3','8t5mSQk7MAVO0AyN+yItYQ==','Felecia Cabrera','feleciacabrera@recrisys.com','0930174351',_binary '','41 Linden Street, Slovan, S. Georgia and S. Sandwich Isls.',2),
                       (4,'user4','8t5mSQk7MAVO0AyN+yItYQ==','Juliette Mcdowell','juliettemcdowell@recrisys.com','0911925643',_binary '','5 Schenck Court, Dana, Cyprus',2),
                       (5,'user5','8t5mSQk7MAVO0AyN+yItYQ==','Vilma Spencer','vilmaspencer@recrisys.com','0987509391',_binary '','5 Pooles Lane, Allentown, Zambia',2);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

-- Table structure for table `cart`
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `userId` bigint NOT NULL,
                        `createdAt` datetime NOT NULL,
                        `updatedAt` datetime DEFAULT NULL,
                        PRIMARY KEY (`id`),
                        KEY `idx_cart_user` (`userId`),
                        CONSTRAINT `fk_cart_user` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table `cart`
LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (1,4,'2021-12-30 15:39:19',NULL),(2,5,'2021-12-18 20:35:59',NULL);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

-- Table structure for table `cart_item`
DROP TABLE IF EXISTS `cart_item`;
CREATE TABLE `cart_item` (
                             `id` bigint NOT NULL AUTO_INCREMENT,
                             `cartId` bigint NOT NULL,
                             `productId` bigint NOT NULL,
                             `quantity` smallint NOT NULL,
                             `createdAt` datetime NOT NULL,
                             `updatedAt` datetime DEFAULT NULL,
                             PRIMARY KEY (`id`),
                             UNIQUE KEY `uq_cartId_productId` (`cartId`,`productId`),
                             KEY `idx_cart_item_cart` (`cartId`),
                             KEY `idx_cart_item_product` (`productId`),
                             CONSTRAINT `fk_cart_item_cart` FOREIGN KEY (`cartId`) REFERENCES `cart` (`id`) ON DELETE CASCADE,
                             CONSTRAINT `fk_cart_item_product` FOREIGN KEY (`productId`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table `cart_item`
LOCK TABLES `cart_item` WRITE;
/*!40000 ALTER TABLE `cart_item` DISABLE KEYS */;
INSERT INTO `cart_item` VALUES
                            (1,2,55,3,'2021-07-13 10:21:51',NULL),
                            (2,2,36,2,'2021-07-05 07:21:45',NULL),
                            (3,1,7,3,'2021-04-14 19:36:26',NULL),
                            (4,1,70,2,'2021-02-20 18:51:20',NULL),
                            (5,1,27,4,'2021-11-24 00:05:40',NULL);
/*!40000 ALTER TABLE `cart_item` ENABLE KEYS */;
UNLOCK TABLES;

-- Table structure for table `category`
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `name` varchar(100) NOT NULL,
                            `description` text,
                            `imageName` varchar(35) DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table `category`
LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES
                           (1,'Sách giáo khoa','Cillum nulla non Lorem ut irure fugiat veniam deserunt do.','sach-giao-khoa.jpg'),
                           (2,'Sách khoa học','Aliqua exercitation ea sint do.','sach-khoa-hoc.png'),
                           (3,'Truyện tranh','Cillum laboris et nulla nostrud duis consectetur labore cupidatat minim proident.','truyen-tranh.png'),
                           (4,'Tiểu thuyết','Enim dolore cupidatat tempor sunt amet veniam aute officia est officia.','tieu-thuyet.png'),
                           (5,'Truyện ngắn','Dolor in pariatur aliqua dolore ea cillum ut consectetur tempor do eu incididunt est.','truyen-ngan.png'),
                           (6,'Truyện dài','Eiusmod adipisicing consectetur occaecat culpa in ullamco labore velit magna.','truyen-dai.png'),
                           (7,'Sách giáo trình','In officia ex magna commodo ullamco in magna incididunt esse mollit enim consectetur laboris.','sach-giao-trinh.png'),
                           (8,'Báo in','Laborum in elit ullamco pariatur laborum magna veniam nostrud eu anim irure deserunt ad sunt.','bao-in.png'),
                           (9,'Tạp chí','Excepteur qui commodo sint sint irure sunt sunt in nostrud.','tap-chi.png'),
                           (10,'Tập san','Elit amet proident et cupidatat in eu quis velit tempor sunt labore aute et.','tap-san.png'),
                           (11,'Sách nấu ăn','Consequat anim officia aute eiusmod dolor.','nau-an.png'),
                           (12,'Sách kỹ thuật','Veniam pariatur deserunt ea non voluptate sunt do culpa elit esse.','sach-ky-thuat.png'),
                           (13,'Sách nông nghiệp','Minim deserunt aute ipsum duis ea eiusmod aute sint sint ut.','sach-nong-nghiep.png'),
                           (14,'Sách thiếu nhi','Ex eu ad adipisicing magna tempor occaecat id cupidatat dolor dolor aliquip dolore.','sach-thieu-nhi.png'),
                           (15,'Sách kỹ năng sống','Ad exercitation anim in magna qui ipsum ipsum proident magna.','sach-ky-nang-song.png');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

-- Table structure for table `order_item`
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item` (
                              `id` bigint NOT NULL AUTO_INCREMENT,
                              `orderId` bigint NOT NULL,
                              `productId` bigint NOT NULL,
                              `price` float NOT NULL,
                              `discount` float NOT NULL,
                              `quantity` smallint NOT NULL,
                              `createdAt` datetime NOT NULL,
                              `updatedAt` datetime DEFAULT NULL,
                              PRIMARY KEY (`id`),
                              KEY `idx_order_item_orders` (`orderId`),
                              KEY `idx_order_item_product` (`productId`),
                              CONSTRAINT `fk_order_item_orders` FOREIGN KEY (`orderId`) REFERENCES `orders` (`id`),
                              CONSTRAINT `fk_order_item_product` FOREIGN KEY (`productId`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table `order_item`
LOCK TABLES `order_item` WRITE;
/*!40000 ALTER TABLE `order_item` DISABLE KEYS */;
INSERT INTO `order_item` VALUES
                             (1,1,78,286587,0,4,'2021-06-27 03:11:05',NULL),
                             (2,2,21,29619,0,2,'2021-03-26 10:39:47',NULL),
                             (3,3,69,299814,0,4,'2021-07-31 12:54:03',NULL),
                             (4,4,2,181582,0,5,'2021-07-15 11:58:11',NULL),
                             (5,5,79,355067,20,1,'2021-08-28 20:28:16',NULL),
                             (6,6,41,116744,0,1,'2021-04-09 09:53:33',NULL),
                             (7,7,3,276065,20,5,'2021-08-16 21:48:06',NULL),
                             (8,8,87,421713,20,5,'2021-05-15 09:36:10',NULL),
                             (9,9,90,480454,20,3,'2021-09-18 01:58:18',NULL),
                             (10,10,82,280519,0,4,'2022-01-08 19:44:56',NULL);
/*!40000 ALTER TABLE `order_item` ENABLE KEYS */;
UNLOCK TABLES;

-- Table structure for table `orders`
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
                          `id` bigint NOT NULL AUTO_INCREMENT,
                          `userId` bigint NOT NULL,
                          `status` tinyint NOT NULL,
                          `deliveryMethod` tinyint NOT NULL,
                          `deliveryPrice` float NOT NULL,
                          `createdAt` datetime NOT NULL,
                          `updatedAt` datetime DEFAULT NULL,
                          PRIMARY KEY (`id`),
                          KEY `idx_orders_user` (`userId`),
                          CONSTRAINT `fk_orders_user` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table `orders`
LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES
                         (1,4,3,1,10000,'2021-12-01 08:34:38',NULL),
                         (2,5,2,2,50000,'2021-07-05 10:52:51',NULL),
                         (3,4,1,1,10000,'2021-10-11 09:15:13',NULL),
                         (4,5,3,2,50000,'2022-01-06 15:05:11',NULL),
                         (5,4,2,1,10000,'2021-09-25 14:06:36',NULL),
                         (6,4,3,2,50000,'2021-09-18 02:22:12',NULL),
                         (7,5,1,1,10000,'2021-04-08 15:13:25',NULL),
                         (8,4,3,2,50000,'2021-04-06 22:47:57',NULL),
                         (9,5,3,1,10000,'2021-04-03 11:40:27',NULL),
                         (10,4,2,2,50000,'2021-10-22 15:49:15',NULL);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

-- Table structure for table `product`
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `name` varchar(100) NOT NULL,
                           `price` float NOT NULL,
                           `discount` float NOT NULL,
                           `quantity` smallint NOT NULL,
                           `totalBuy` smallint NOT NULL,
                           `author` varchar(50) NOT NULL,
                           `pages` smallint NOT NULL,
                           `publisher` varchar(100) NOT NULL,
                           `yearPublishing` year NOT NULL,
                           `description` text,
                           `imageName` tinytext,
                           `shop` bit(1) NOT NULL,
                           `createdAt` datetime NOT NULL,
                           `updatedAt` datetime DEFAULT NULL,
                           `startsAt` datetime DEFAULT NULL,
                           `endsAt` datetime DEFAULT NULL,
                           `created_by` varchar(35) DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table `product`
LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES
                          (1,'Sách Toyletry',466183,0,86,86,'Stafford Hayden',250,'NXB Giáo dục',2013,'Consequat cupidatat magna nostrud ullamco non commodo esse. Veniam anim ipsum duis cillum cillum exercitation deserunt irure sint eiusmod. Duis consectetur adipisicing aliquip magna eiusmod ullamco ut ad ipsum nostrud dolore id. Ex ullamco nulla Lorem consequat sunt exercitation cillum adipisicing.\r\nProident labore ut qui esse cupidatat deserunt occaecat dolor in. Ad nulla reprehenderit pariatur esse enim ullamco do incididunt anim do excepteur est dolore excepteur. Laboris voluptate cupidatat anim dolore eiusmod in id fugiat est cupidatat pariatur mollit. Mollit irure proident enim consequat irure ipsum proident amet aliqua. Irure ad dolore laboris elit reprehenderit officia ex.\r\n','temp-10075522682831764585.jpg',_binary '\0','2021-03-23 08:22:50',NULL,NULL,NULL,'user3'),
                          (2,'Sách Sultrax',26228,0,23,60,'Diane Nguyen',305,'NXB Đại học Sư phạm TP.HCM',2011,'Ipsum consequat reprehenderit amet ullamco dolore consectetur non eiusmod dolor irure sit. Lorem nulla officia dolore officia laboris. Excepteur anim consectetur reprehenderit duis duis ea nostrud. Reprehenderit consequat cupidatat enim ea eiusmod nisi. Mollit veniam quis est ex elit proident tempor pariatur sit aute. Eu Lorem irure sunt sit aute nostrud culpa. Voluptate enim sit dolor laborum est nulla eiusmod eu laborum Lorem laborum.\r\nPariatur id proident laborum consectetur pariatur deserunt quis tempor excepteur non tempor. Sit tempor irure id fugiat occaecat. Ex ut veniam nostrud sunt dolore. Veniam cillum incididunt enim tempor ut amet do est pariatur aliqua labore.','temp-10075522682831764585.jpg',_binary '','2021-03-23 08:22:50',NULL,NULL,NULL,'user3'),
                          (3,'Sách Phép Thuật',30000,0,50,20,'John Doe',150,'NXB Văn học',2020,'Sách này chứa những phép thuật kỳ diệu giúp bạn khám phá thế giới huyền bí. Các câu chuyện và bài học trong sách sẽ dẫn dắt bạn đến những cuộc phiêu lưu không thể nào quên.','temp-10075522682831764585.jpg',_binary '','2021-03-23 08:22:50',NULL,NULL,NULL,'user3');
-- Thêm dữ liệu cho các sản phẩm khác ở đây...

/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

-- Table structure for table `product_category`
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category` (
                                    `productId` bigint NOT NULL,
                                    `categoryId` bigint NOT NULL,
                                    PRIMARY KEY (`productId`, `categoryId`),
                                    CONSTRAINT `fk_product_category_product` FOREIGN KEY (`productId`) REFERENCES `product` (`id`) ON DELETE CASCADE,
                                    CONSTRAINT `fk_product_category_category` FOREIGN KEY (`categoryId`) REFERENCES `category` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Table structure for table `product_review`
DROP TABLE IF EXISTS `product_review`;
CREATE TABLE `product_review` (
                                  `id` bigint NOT NULL AUTO_INCREMENT,
                                  `productId` bigint NOT NULL,
                                  `userId` bigint NOT NULL,
                                  `rating` tinyint NOT NULL,
                                  `comment` text,
                                  `createdAt` datetime NOT NULL,
                                  PRIMARY KEY (`id`),
                                  KEY `idx_product_review_product` (`productId`),
                                  KEY `idx_product_review_user` (`userId`),
                                  CONSTRAINT `fk_product_review_product` FOREIGN KEY (`productId`) REFERENCES `product` (`id`) ON DELETE CASCADE,
                                  CONSTRAINT `fk_product_review_user` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Table structure for table `wishlist_item`
DROP TABLE IF EXISTS `wishlist_item`;
CREATE TABLE `wishlist_item` (
                                 `id` bigint NOT NULL AUTO_INCREMENT,
                                 `userId` bigint NOT NULL,
                                 `productId` bigint NOT NULL,
                                 PRIMARY KEY (`id`),
                                 KEY `idx_wishlist_item_user` (`userId`),
                                 KEY `idx_wishlist_item_product` (`productId`),
                                 CONSTRAINT `fk_wishlist_item_user` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE CASCADE,
                                 CONSTRAINT `fk_wishlist_item_product` FOREIGN KEY (`productId`) REFERENCES `product` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Kết thúc mã SQL
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-23 22:00:00
