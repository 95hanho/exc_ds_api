-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ds
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(500) DEFAULT NULL,
  `regdate` datetime DEFAULT CURRENT_TIMESTAMP,
  `writer` varchar(45) DEFAULT NULL,
  `writer_login_id` varchar(100) DEFAULT NULL,
  `notice_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_comment_idx` (`writer_login_id`),
  KEY `notice_comment_idx` (`notice_id`),
  CONSTRAINT `notice_comment` FOREIGN KEY (`notice_id`) REFERENCES `notice` (`id`),
  CONSTRAINT `user_comment` FOREIGN KEY (`writer_login_id`) REFERENCES `user` (`login_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (2,'12321213','2024-11-13 17:06:29','관리자','admin',14);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `file`
--

DROP TABLE IF EXISTS `file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `file` (
  `file_num` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `notice_id` int DEFAULT NULL,
  PRIMARY KEY (`file_num`),
  UNIQUE KEY `created_at_UNIQUE` (`created_at`),
  KEY `notice_file_idx` (`notice_id`),
  CONSTRAINT `notice_file` FOREIGN KEY (`notice_id`) REFERENCES `notice` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file`
--

LOCK TABLES `file` WRITE;
/*!40000 ALTER TABLE `file` DISABLE KEYS */;
INSERT INTO `file` VALUES (3,'엠버_빅.jpg','2024-11-13 17:24:47',17);
/*!40000 ALTER TABLE `file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notice`
--

DROP TABLE IF EXISTS `notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notice` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `content` varchar(300) DEFAULT NULL,
  `regdate` datetime DEFAULT CURRENT_TIMESTAMP,
  `hit` int DEFAULT '0',
  `secret` tinyint(1) DEFAULT '0',
  `top` int DEFAULT '0',
  `type` varchar(5) DEFAULT 'N' COMMENT 'G 나 N',
  `writer` varchar(45) DEFAULT NULL,
  `writer_login_id` varchar(100) DEFAULT NULL,
  `manager_comment_latest` tinyint DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `login_id_idx` (`writer_login_id`),
  CONSTRAINT `login_id_reference` FOREIGN KEY (`writer_login_id`) REFERENCES `user` (`login_id`),
  CONSTRAINT `check_is_manager_comment_latest` CHECK ((`manager_comment_latest` in (0,1))),
  CONSTRAINT `check_is_secret` CHECK ((`secret` in (0,1)))
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
INSERT INTO `notice` VALUES (5,'123','<p>12321</p>','2024-11-12 22:31:05',6,0,1,'G','관리자','admin',0),(6,'1321','<p>1132132</p>','2024-11-13 09:17:39',5,0,1,'G','관리자','admin',0),(7,'1132','<p>13212132123</p>','2024-11-13 10:28:49',4,0,1,'G','관리자','admin',0),(8,'1132','<p>13212132123</p>','2024-11-13 10:30:49',3,0,1,'G','관리자','admin',0),(9,'1132','<p>13212132123</p>','2024-11-13 10:43:28',5,0,1,'G','관리자','admin',0),(10,'ㅂㅂㅂ','<p>ㅂㅂㅂㅂㅂ</p>','2024-11-13 14:15:47',4,NULL,1,'G','관리자','admin',0),(11,'ㅂㅂㅂ','<p>ㅂㅂㅂ</p>','2024-11-13 14:15:59',4,NULL,1,'G','관리자','admin',0),(12,'ㅈㅈㅈㅈ','<p>ㅈㅈㅈㅈ</p>','2024-11-13 14:17:12',2,NULL,1,'G','관리자','admin',0),(13,'ㄷㄷㄷ','<p>ㄷㄷㄷㄷ</p>','2024-11-13 14:18:12',2,NULL,1,'G','관리자','admin',0),(14,'테스트테스트','qqwewqqwewq','2024-11-13 14:23:05',6,NULL,0,'N','유저1','user',0),(15,'123','123123123','2024-11-13 14:24:38',3,1,0,'N','유저1','user',0),(16,'공개test','123123123','2024-11-13 14:24:50',4,0,0,'N','유저1','user',0),(17,'123','<p>1322131</p>','2024-11-13 17:24:47',3,NULL,1,'G','관리자','admin',0);
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `token` (
  `token_num` int NOT NULL AUTO_INCREMENT,
  `refresh_token` varchar(200) DEFAULT NULL,
  `agent` varchar(200) DEFAULT NULL,
  `connect_ip` varchar(50) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `login_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`token_num`),
  KEY `login_id_idx` (`login_id`),
  CONSTRAINT `login_id` FOREIGN KEY (`login_id`) REFERENCES `user` (`login_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES (1,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJpc3MiOiJteXRlYW0iLCJpYXQiOjE3MzE0ODc1NjYsImV4cCI6MTczMTQ5ODM2Nn0.sQYcp_nBhrpFUzHM8Hv9hrmXxyBcmVrGHzCzWAHEOTI5Vh1b-itJKaCO5SQiSmXL','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/130.0.0.0 Safari/537.36','0:0:0:0:0:0:0:1','2024-11-12 17:26:16','admin'),(2,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJpc3MiOiJteXRlYW0iLCJpYXQiOjE3MzE0ODc1NjYsImV4cCI6MTczMTQ5ODM2Nn0.sQYcp_nBhrpFUzHM8Hv9hrmXxyBcmVrGHzCzWAHEOTI5Vh1b-itJKaCO5SQiSmXL','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/130.0.0.0 Safari/537.36','0:0:0:0:0:0:0:1','2024-11-13 13:47:43','admin'),(3,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJpc3MiOiJteXRlYW0iLCJpYXQiOjE3MzE0NzU5OTMsImV4cCI6MTczMTQ4Njc5M30.hrWBfayiqV8JC9T0lYDl6tYm0Mqeh6DmuojYN9B8gJ-n9vtErv4bwtSC422FyxKX','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/130.0.0.0 Safari/537.36','0:0:0:0:0:0:0:1','2024-11-13 14:00:40','user');
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `login_id` varchar(100) NOT NULL,
  `login_pwd` varchar(200) DEFAULT NULL,
  `grant` int DEFAULT NULL,
  `insa` varchar(100) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`login_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('admin','1234',90,'1','관리자','1','2024-11-12 15:18:19'),('user','1234',0,'1','유저1','0','2024-11-13 11:40:10');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-13 17:52:59
