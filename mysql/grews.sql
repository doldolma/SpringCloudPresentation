-- MySQL dump 10.13  Distrib 8.0.28, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: jest_presentation
-- ------------------------------------------------------
-- Server version	8.0.28

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

--
-- Table structure for table `grews`
--
CREATE DATABASE IF NOT EXISTS jest_presentation;
use jest_presentation;

DROP TABLE IF EXISTS `grews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grews` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `slogan` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `belongsTo` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL,
  `nicknameEng` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `likesCount` int unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grews`
--

LOCK TABLES `grews` WRITE;
/*!40000 ALTER TABLE `grews` DISABLE KEYS */;
INSERT INTO `grews` VALUES (1,'이일봉','베네','처음처럼','연구소장','https://www.gridwiz.com/assets/images/culture/team-gridwiz/GW_Web_Profile_12.jpg','2022-02-15 12:36:04','2022-02-15 12:36:04','bene',0),(2,'김재식','카제','if else','개발 1팀','https://www.gridwiz.com/assets/images/culture/team-gridwiz/GW_Web_Profile_15.jpg','2022-02-15 12:36:04','2022-02-15 12:36:04','kaze',0),(3,'권도훈','엘로이','Never Give up!!','개발 1팀','https://www.gridwiz.com/assets/images/culture/team-gridwiz/GW_Web_Profile_74.jpg','2022-02-15 12:36:04','2022-02-15 12:36:04','elory',0),(4,'조아라','아리엘','Rule your mind','개발 1팀','https://www.gridwiz.com/assets/images/culture/team-gridwiz/GW_Web_Profile_94.jpg','2022-02-15 12:36:04','2022-02-15 12:36:04','arielle',0),(5,'송민우','다니엘','No pain No gain','개발 1팀','https://www.gridwiz.com/assets/images/culture/team-gridwiz/GW_Web_Profile_83.jpg','2022-02-15 12:36:04','2022-02-15 12:36:04','daniel',0),(6,'박은서','레이','바쁘게 살자! 봄찬 아빠!','개발 2팀','https://www.gridwiz.com/assets/images/culture/team-gridwiz/GW_Web_Profile_42.jpg','2022-02-15 12:36:04','2022-02-15 12:36:04','ray',0),(7,'김다라','로야','범사에 감사하라','개발 2팀','https://www.gridwiz.com/assets/images/culture/team-gridwiz/GW_Web_Profile_91.jpg','2022-02-15 12:36:04','2022-02-15 12:36:04','roya',0),(8,'권오인','이썬','소중한 순간이 오면 따지지 말고 누릴 것!','개발 2팀','https://www.gridwiz.com/assets/images/culture/team-gridwiz/GW_Web_Profile_2007_04.jpg','2022-02-15 12:36:04','2022-02-15 12:36:04','ethan',0),(9,'박종아','조아','모든 과정이 의미있게','개발 2팀','https://www.gridwiz.com/assets/images/culture/team-gridwiz/GW_Web_Profile_2111_03.jpg','2022-02-15 12:36:04','2022-02-15 12:36:04','joah',0),(10,'박예찬','리베','사모하는 일에 끝이 있나요','개발 2팀','https://user-images.githubusercontent.com/81739782/154037302-6b7ee80e-06b7-4a7f-8bd7-8a2fdbb8d8f2.jpg','2022-02-15 12:36:04','2022-02-15 12:36:04','liebe',0),(11,'허도영','돌마','Why not','개발 2팀','https://user-images.githubusercontent.com/81739782/154037319-47a651ed-6f4c-4d19-96b0-69fcb1588d47.jpg','2022-02-15 12:36:04','2022-02-15 12:36:04','dolma',0),(12,'송은우','숀','오늘도 열심히 살자','개발 3팀','https://www.gridwiz.com/assets/images/culture/team-gridwiz/GW_Web_Profile_62.jpg','2022-02-15 12:36:04','2022-02-15 12:36:04','sean',0),(13,'김승혁','릭','Stay Hungry, Stay foolish','개발 3팀','https://www.gridwiz.com/assets/images/culture/team-gridwiz/GW_Web_Profile_82.jpg','2022-02-15 12:36:04','2022-02-15 12:36:04','rick',0),(14,'조현진','헤이즐','Grow in green','개발 3팀','https://user-images.githubusercontent.com/81739782/154036600-7bc7a12f-b669-4c32-b5fe-28d22a3031dd.jpeg','2022-02-15 12:36:04','2022-02-15 12:36:04','hazel',0),(15,'김상호','조엘','知之者不如好之者','개발 4팀','https://www.gridwiz.com/assets/images/culture/team-gridwiz/GW_Web_Profile_24.jpg','2022-02-15 12:36:04','2022-02-15 12:36:04','joel',0),(16,'최한규','리암','Break the mold!','개발 4팀','https://www.gridwiz.com/assets/images/culture/team-gridwiz/GW_Web_Profile_43.jpg','2022-02-15 12:36:04','2022-02-15 12:36:04','liam',0),(17,'정승환','트레버','Let\'s go out!','개발 4팀','https://www.gridwiz.com/assets/images/culture/team-gridwiz/GW_Web_Profile_18.jpg','2022-02-15 12:36:04','2022-02-15 12:36:04','trevor',0),(18,'김설아','사라','Dream but Stay Awake! ','개발 4팀','https://user-images.githubusercontent.com/81739782/154036612-bc35c495-9108-4426-9db9-afbe429e9499.jpg','2022-02-15 12:36:04','2022-02-15 12:36:04','sarah',0);
/*!40000 ALTER TABLE `grews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sequelizemeta`
--

DROP TABLE IF EXISTS `sequelizemeta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sequelizemeta` (
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`name`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sequelizemeta`
--

LOCK TABLES `sequelizemeta` WRITE;
/*!40000 ALTER TABLE `sequelizemeta` DISABLE KEYS */;
INSERT INTO `sequelizemeta` VALUES ('20220215022758-create-grew.js');
/*!40000 ALTER TABLE `sequelizemeta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-22 10:50:55
