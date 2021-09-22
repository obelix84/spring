CREATE SCHEMA `lesson7` ;

CREATE TABLE `goods` (
  `id` bigint NOT NULL,
  `cost` float NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

INSERT INTO `goods` VALUES (1,10.99,'good1'),
(2,11.99,'good2'),(3,145.99,'good3'),
(4,145.99,'good4'),(5,148.99,'good5'),
(6,12249,'good6'),(7,12248.9,'good7'),
(8,1243250,'good8'),(9,12.949,'good9'),
(10,12.949,'good10'),(11,2312.95,'good11'),
(12,23112.9,'good12'),(13,123.949,'good13'),
(14,2123.39,'good14'),(15,243123,'good15'),
(16,2332240000,'good16'),(17,18.3334,'good17'),
(18,19.3333,'good18'),(19,219.333,'good19'),(20,222219,'good20');

INSERT INTO `hibernate_sequence` VALUES (21);
