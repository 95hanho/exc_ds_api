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
-- Table structure for table `cancel_log`
--

DROP TABLE IF EXISTS `cancel_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cancel_log` (
  `id` int NOT NULL AUTO_INCREMENT,
  `reason` varchar(45) DEFAULT '',
  `flag` varchar(45) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `s_id` int DEFAULT NULL,
  `login_id` varchar(100) DEFAULT NULL,
  `executor` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_cancellog_idx` (`login_id`),
  KEY `schedule_cancellog_idx` (`s_id`),
  KEY `user_cancellog2_idx` (`executor`),
  CONSTRAINT `schedule_cancellog` FOREIGN KEY (`s_id`) REFERENCES `schedule` (`s_id`),
  CONSTRAINT `user_cancellog` FOREIGN KEY (`login_id`) REFERENCES `user` (`login_id`),
  CONSTRAINT `user_cancellog2` FOREIGN KEY (`executor`) REFERENCES `user` (`login_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cancel_log`
--

LOCK TABLES `cancel_log` WRITE;
/*!40000 ALTER TABLE `cancel_log` DISABLE KEYS */;
INSERT INTO `cancel_log` VALUES (8,'','취소','2024-11-19 18:52:04',5,'user3','admin'),(9,'','변경','2024-11-19 18:52:04',5,'user','admin'),(11,'','등록','2024-11-19 19:00:30',5,'admin','admin'),(12,'급한 업무 및 회의','취소','2024-11-19 22:23:00',1,'admin','admin');
/*!40000 ALTER TABLE `cancel_log` ENABLE KEYS */;
UNLOCK TABLES;

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
  `talktalk_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_comment_idx` (`writer_login_id`),
  KEY `notice_comment_idx` (`notice_id`),
  KEY `talktalk_comment_idx` (`talktalk_id`),
  CONSTRAINT `notice_comment` FOREIGN KEY (`notice_id`) REFERENCES `notice` (`id`) ON DELETE CASCADE,
  CONSTRAINT `talktalk_comment` FOREIGN KEY (`talktalk_id`) REFERENCES `talktalk` (`id`) ON DELETE CASCADE,
  CONSTRAINT `user_comment` FOREIGN KEY (`writer_login_id`) REFERENCES `user` (`login_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (3,'12321','2024-11-14 11:04:32','관리자','admin',15,NULL),(4,'3312312123','2024-11-14 11:05:01','관리자','admin',15,NULL),(5,'1231232','2024-11-14 11:05:19','유저1','user',15,NULL);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enroll`
--

DROP TABLE IF EXISTS `enroll`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enroll` (
  `enrol_id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `attendance_type` varchar(5) NOT NULL DEFAULT '',
  `attendance_msg` varchar(20) NOT NULL DEFAULT '',
  `attendance_description` varchar(100) NOT NULL DEFAULT '',
  `s_id` int DEFAULT NULL,
  `login_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`enrol_id`),
  KEY `schedule_user_idx` (`login_id`),
  KEY `asdadsads_idx` (`s_id`),
  CONSTRAINT `schedule_enroll` FOREIGN KEY (`s_id`) REFERENCES `schedule` (`s_id`),
  CONSTRAINT `user_enroll` FOREIGN KEY (`login_id`) REFERENCES `user` (`login_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enroll`
--

LOCK TABLES `enroll` WRITE;
/*!40000 ALTER TABLE `enroll` DISABLE KEYS */;
INSERT INTO `enroll` VALUES (15,'2024-11-19 16:47:06','','','',4,'admin'),(16,'2024-11-19 16:47:06','','','',3,'admin'),(18,'2024-11-19 16:47:08','','','',2,'admin'),(19,'2024-11-19 16:49:01','','','',5,'user'),(20,'2024-11-19 16:49:02','','','',4,'user'),(21,'2024-11-19 16:49:02','','','',3,'user'),(22,'2024-11-19 16:49:03','','','',1,'user'),(23,'2024-11-19 16:49:03','','','',2,'user'),(25,'2024-11-19 16:49:12','','','',4,'user2'),(26,'2024-11-19 16:49:13','','','',3,'user2'),(27,'2024-11-19 16:49:13','','','',1,'user2'),(28,'2024-11-19 16:49:14','','','',2,'user2'),(30,'2024-11-19 19:00:30','','','',5,'admin');
/*!40000 ALTER TABLE `enroll` ENABLE KEYS */;
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
  `filePath` varchar(200) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `popup_id` int DEFAULT NULL,
  `notice_id` int DEFAULT NULL,
  `program_num` int DEFAULT NULL,
  PRIMARY KEY (`file_num`),
  KEY `notice_file_idx` (`notice_id`),
  KEY `program_file_idx` (`program_num`),
  CONSTRAINT `notice_file` FOREIGN KEY (`notice_id`) REFERENCES `notice` (`id`) ON DELETE CASCADE,
  CONSTRAINT `program_file` FOREIGN KEY (`program_num`) REFERENCES `program` (`program_num`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file`
--

LOCK TABLES `file` WRITE;
/*!40000 ALTER TABLE `file` DISABLE KEYS */;
INSERT INTO `file` VALUES (15,'aea286ab-d64a-4ce7-b790-bc8acdf56793.png','https://ds-api.exc.co.kr/files/program/list/aea286ab-d64a-4ce7-b790-bc8acdf56793.png','2024-11-20 16:38:50',NULL,NULL,1),(16,'lec_a002_20.jpg','https://ds-api.exc.co.kr/files/program/list/lec_a002_20.jpg','2024-11-20 16:38:50',NULL,NULL,3),(17,'nlec_a002_14.jpg','https://ds-api.exc.co.kr/files/program/list/nlec_a002_14.jpg','2024-11-20 16:39:15',NULL,NULL,4),(18,'nlec_a002_03.jpg','https://ds-api.exc.co.kr/files/program/list/nlec_a002_03.jpg','2024-11-20 16:39:15',NULL,NULL,5),(20,'엘리멘탈_배경5.jpg','D:/dsapp/files/1732091567969_엘리멘탈_배경5.jpg','2024-11-20 17:23:55',NULL,19,NULL),(21,'웨이드_빅.jpg','D:/dsapp/files/1732091643354_웨이드_빅.jpg','2024-11-20 17:33:54',NULL,NULL,15),(22,'ㅅㅏㄴㅇㅓㅂㅇㅏㄴㅈㅓㄴㄱㅣㅅㅏ_ㅇㅠㅇㅖㅈㅣ.jpg','https://ds-api.exc.co.kr/files/popup/1/4f29f02b-b490-4ed3-a8be-6ed72c7f219f.png','2024-11-21 16:39:18',1,NULL,NULL),(23,'ㅅㅏㄴㅇㅓㅂㅇㅏㄴㅈㅓㄴㄱㅣㅅㅏ_ㅇㅠㅇㅖㅈㅣ.jpg','https://ds-api.exc.co.kr/files/popup/1/4f29f02b-b490-4ed3-a8be-6ed72c7f219f.png','2024-11-21 16:39:18',2,NULL,NULL);
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
  `manager_comment_latest` tinyint DEFAULT '0',
  `writer_login_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `login_id_idx` (`writer_login_id`),
  CONSTRAINT `login_id_reference` FOREIGN KEY (`writer_login_id`) REFERENCES `user` (`login_id`),
  CONSTRAINT `check_is_manager_comment_latest` CHECK ((`manager_comment_latest` in (0,1))),
  CONSTRAINT `check_is_secret` CHECK ((`secret` in (0,1)))
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
INSERT INTO `notice` VALUES (5,'123','<p>12321</p>','2024-11-12 22:31:05',6,0,1,'G','관리자',0,'admin'),(15,'123','123123123','2024-11-13 14:24:38',10,1,0,'N','유저1',0,'user'),(16,'공개test','123123123','2024-11-13 14:24:50',10,0,0,'N','유저1',0,'user'),(17,'123','<p>1322131</p>','2024-11-13 17:24:47',10,NULL,1,'G','관리자',0,'admin'),(18,'12312','<p>13213132</p>','2024-11-14 10:34:06',5,NULL,1,'G','관리자',0,'admin'),(19,'test123','<p>test12312</p>','2024-11-20 17:23:55',2,NULL,1,'G','관리자',0,'admin');
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `popup`
--

DROP TABLE IF EXISTS `popup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `popup` (
  `popup_id` int NOT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`popup_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `popup`
--

LOCK TABLES `popup` WRITE;
/*!40000 ALTER TABLE `popup` DISABLE KEYS */;
INSERT INTO `popup` VALUES (1,1),(2,1);
/*!40000 ALTER TABLE `popup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `program`
--

DROP TABLE IF EXISTS `program`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `program` (
  `program_num` int NOT NULL AUTO_INCREMENT,
  `program_code` varchar(10) DEFAULT NULL,
  `program_name` varchar(45) DEFAULT NULL,
  `program_status` varchar(2) DEFAULT NULL,
  `program_new_label` varchar(2) DEFAULT NULL,
  `program_hash_tag` varchar(200) DEFAULT NULL,
  `time` int DEFAULT '0',
  `time_ment` varchar(50) DEFAULT NULL,
  `place` varchar(200) DEFAULT NULL,
  `program_content` varchar(500) DEFAULT NULL,
  `category_num` int DEFAULT NULL,
  PRIMARY KEY (`program_num`),
  KEY `category_program_idx` (`category_num`),
  CONSTRAINT `category_p` FOREIGN KEY (`category_num`) REFERENCES `program_category` (`cate_num`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `program`
--

LOCK TABLES `program` WRITE;
/*!40000 ALTER TABLE `program` DISABLE KEYS */;
INSERT INTO `program` VALUES (1,'S13','고객 경험은 어떻게 무기가 되는가','Y','Y','#세계 자금 흐름 #AI혁명 #제조업 투자지형도 #제조업 미래전략',20,'(교육 20H + 실습(인증코치 준비반) 12H)','천 인재개발원/ DS에듀센터 동탄 Ⅱ<br><span style=\"font-size:16px\"> ※자세한 사항은  수강신청 시스템  및  입과 안내 메일을 참고해주세요.</span>','<p>테스트용</p>',1),(3,'S15','구성원의 탁월함을 이끌어내는 퍼실리테이션','Y','N','#국내 Tech 기업 사례 #네이버 #카카오 #직원경험 #리더의선택 #인사이트 함양',8,'(8:30~17:30)','강원도 속초시<br><span style=\"font-size:16px\"> ※자세한 사항은  수강신청 시스템  및  입과 안내 메일을 참고해주세요.</span>','<p>테스트용</p>',1),(4,'S12','리더십 에센스','Y','Y','#리더의 자기인식 #리더십 현재상태 점검 #나의 리더십 성공모델 #리더십 향상계획 수립',8,'(8:30~17:30)','FRONT 개발자 앞<br><span style=\"font-size:16px\"> ※자세한 사항은  수강신청 시스템  및  입과 안내 메일을 참고해주세요.</span>','<p>테스트용</p>',2),(5,'S20','몰입을 이끄는 소통 스킬','Y','N','#긍정적조직문화 #일중심의소통 #AI #긍정혁명 #소통하는문화구축',4,'(8:30~12:30 / 13:30~17:30)','우리집 <br><span style=\"font-size:16px\"> ※자세한 사항은  수강신청 시스템  및  입과 안내 메일을 참고해주세요.</span>','<p>테스트용</p>',2),(15,'S21','고객 경험은 어떻게 무기가 되는가','Y','Y','#디지털트렌스포메이션 #고객경험 #마케팅 #경험마케팅 #커뮤니티',4,'(8:30~12:30 / 13:30~17:30)','서천 인재개발원/ DS에듀센터 동탄 Ⅱ<br><span style=\"font-size:16px\"> ※자세한 사항은  수강신청 시스템  및  입과 안내 메일을 참고해주세요.</span>','<p><img src=\"https://dsedu.exc.co.kr/images/A001_13_img_01.jpg\"></p>\r\n                                <p><img src=\"https://dsedu.exc.co.kr/images/A001_13_img_02.jpg\"></p>\r\n                                <p><img src=\"https://dsedu.exc.co.kr/images/A001_13_img_03.jpg\"></p>',1);
/*!40000 ALTER TABLE `program` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `program_category`
--

DROP TABLE IF EXISTS `program_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `program_category` (
  `cate_num` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `color` varchar(50) DEFAULT NULL,
  `category_bg_url` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`cate_num`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `program_category`
--

LOCK TABLES `program_category` WRITE;
/*!40000 ALTER TABLE `program_category` DISABLE KEYS */;
INSERT INTO `program_category` VALUES (1,'사업/경영','#46c29d','https://dsedu.exc.co.kr/images/category_bg_01.jpg'),(2,'산업/기술','#9324a6','https://dsedu.exc.co.kr/images/category_bg_04.jpg');
/*!40000 ALTER TABLE `program_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `review_num` int NOT NULL AUTO_INCREMENT,
  `rate` int DEFAULT NULL,
  `contents` varchar(500) DEFAULT NULL,
  `regdate` datetime DEFAULT CURRENT_TIMESTAMP,
  `writer` varchar(100) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `program_num` int DEFAULT NULL,
  PRIMARY KEY (`review_num`),
  KEY `review_program_idx` (`program_num`),
  CONSTRAINT `review_program` FOREIGN KEY (`program_num`) REFERENCES `program` (`program_num`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (1,2,'1231123','2024-11-28 00:00:00','한호성','2024-11-21 09:59:02',1),(2,5,'좋았음','2024-11-13 00:00:00','김지연','2024-11-21 10:05:25',1),(3,3,'보통이였음.','2024-11-20 00:00:00','김민지','2024-11-21 10:05:39',3),(4,4,'낫벳','2024-11-08 00:00:00','오운완','2024-11-21 10:06:04',4),(5,4,'ㅁㅁㅁㅁㅁ','2024-11-04 00:00:00','김김김','2024-11-21 10:06:23',5);
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schedule` (
  `s_id` int NOT NULL AUTO_INCREMENT,
  `schedule_code` varchar(10) DEFAULT NULL,
  `create_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `schedule_enrol_start_date` datetime DEFAULT NULL,
  `schedule_enrol_end_date` datetime DEFAULT NULL,
  `schedule_start_date` datetime DEFAULT NULL,
  `schedule_start_date_add_date` datetime DEFAULT NULL,
  `schedule_after_date` json DEFAULT NULL COMMENT 'SELECT id, name, JSON_EXTRACT(event_dates, ''$[0]'') AS first_event_date\\nFROM event;\n\n ArrayList<Date> dateList = new ArrayList<>();\n        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");\n\n        try {\n            dateList.add(dateFormat.parse("2024-11-10 14:00:00"));\n            dateList.add(dateFormat.parse("2024-11-15 10:00:00"));\n            dateList.add(dateFormat.parse("2024-11-20 18:30:00"));\n        } catch (Exception e) {\n            e.printStackTrace();\n        }\n\n        // 날짜 리스트를 문자열로 변환\n        ArrayList<String> dateStrings = new ArrayList<>();\n        for (Date date : dateList) {\n            dateStrings.add(dateFormat.format(date));\n        }\n\n        // Gson으로 JSON 변환\n        Gson gson = new Gson();\n        String json = gson.toJson(dateStrings);\n\n        System.out.println(json);',
  `online` varchar(5) DEFAULT NULL,
  `part_type` varchar(10) DEFAULT NULL,
  `enrol_limit` int DEFAULT NULL,
  `schedule_status` tinyint(1) DEFAULT NULL,
  `open_status` tinyint(1) DEFAULT NULL,
  `schedule_group_num` int DEFAULT NULL,
  `schedule_number` int DEFAULT NULL,
  `program_num` int DEFAULT NULL,
  PRIMARY KEY (`s_id`),
  KEY `program_schedule_idx` (`program_num`),
  CONSTRAINT `program_schedule` FOREIGN KEY (`program_num`) REFERENCES `program` (`program_num`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES (1,'2851','2024-11-14 21:26:02','2024-10-15 14:00:00','2030-10-23 23:59:59','2024-11-12 00:00:00','2024-11-13 12:00:00','[\"2024-11-29 12:00\"]','N','합반',2,0,1,0,1,1),(2,'2852','2024-11-14 21:26:08','2024-10-15 14:00:00','2030-10-23 23:59:59','2024-11-05 00:00:00','2024-11-06 12:00:00',NULL,'N','합반',2,0,1,0,1,3),(3,'2853','2024-11-14 21:26:09','2024-10-15 14:00:00','2030-10-23 23:59:59','2024-11-18 00:00:00',NULL,NULL,'Y','합반',2,0,1,0,1,4),(4,'2854','2024-11-14 21:26:09','2024-10-15 14:00:00','2030-10-23 23:59:59','2024-11-25 00:00:00',NULL,NULL,'N','합반',2,0,1,0,1,5),(5,'2865','2024-11-14 21:27:24','2024-10-15 14:00:00','2030-10-23 23:59:59','2024-11-27 00:00:00',NULL,NULL,'N','합반',2,0,1,0,2,1);
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `talktalk`
--

DROP TABLE IF EXISTS `talktalk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `talktalk` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `content` varchar(500) DEFAULT NULL,
  `hit` int DEFAULT '0',
  `regdate` datetime DEFAULT CURRENT_TIMESTAMP,
  `program_num` int DEFAULT NULL,
  `writer_login_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_talktalk_idx` (`writer_login_id`),
  KEY `program_talktalk_idx` (`program_num`),
  CONSTRAINT `program_talktalk` FOREIGN KEY (`program_num`) REFERENCES `program` (`program_num`),
  CONSTRAINT `user_talktalk` FOREIGN KEY (`writer_login_id`) REFERENCES `user` (`login_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `talktalk`
--

LOCK TABLES `talktalk` WRITE;
/*!40000 ALTER TABLE `talktalk` DISABLE KEYS */;
/*!40000 ALTER TABLE `talktalk` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES (1,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJpc3MiOiJteXRlYW0iLCJpYXQiOjE3MzE5NzY4NDQsImV4cCI6MTczMTk4NzY0NH0.xcrIpei3o6v-aaaKMGaTFRa_Ilc3MMCzNTpYsxv8pdn-enhsPSyjSr0GFtVBFm2u','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/130.0.0.0 Safari/537.36','0:0:0:0:0:0:0:1','2024-11-12 17:26:16','admin'),(2,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJpc3MiOiJteXRlYW0iLCJpYXQiOjE3MzE5NzY4NDQsImV4cCI6MTczMTk4NzY0NH0.xcrIpei3o6v-aaaKMGaTFRa_Ilc3MMCzNTpYsxv8pdn-enhsPSyjSr0GFtVBFm2u','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/130.0.0.0 Safari/537.36','0:0:0:0:0:0:0:1','2024-11-13 13:47:43','admin'),(3,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJpc3MiOiJteXRlYW0iLCJpYXQiOjE3MzE1NDk5MTIsImV4cCI6MTczMTU2MDcxMn0.53EljJb9DdrcSj1EMtszVRlHGuoCzBf3QVcyrvf_qXBLDP5wo2JhHIAAHokqrdM-','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/130.0.0.0 Safari/537.36','0:0:0:0:0:0:0:1','2024-11-13 14:00:40','user'),(4,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJpc3MiOiJteXRlYW0iLCJpYXQiOjE3MzE5NzY4NDQsImV4cCI6MTczMTk4NzY0NH0.xcrIpei3o6v-aaaKMGaTFRa_Ilc3MMCzNTpYsxv8pdn-enhsPSyjSr0GFtVBFm2u','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/130.0.0.0 Safari/537.36','0:0:0:0:0:0:0:1','2024-11-14 08:49:02','admin'),(5,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJpc3MiOiJteXRlYW0iLCJpYXQiOjE3MzE1NDk5MTIsImV4cCI6MTczMTU2MDcxMn0.53EljJb9DdrcSj1EMtszVRlHGuoCzBf3QVcyrvf_qXBLDP5wo2JhHIAAHokqrdM-','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/130.0.0.0 Safari/537.36','0:0:0:0:0:0:0:1','2024-11-14 09:06:30','user'),(6,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJpc3MiOiJteXRlYW0iLCJpYXQiOjE3MzE5NzY4NDQsImV4cCI6MTczMTk4NzY0NH0.xcrIpei3o6v-aaaKMGaTFRa_Ilc3MMCzNTpYsxv8pdn-enhsPSyjSr0GFtVBFm2u','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/130.0.0.0 Safari/537.36','0:0:0:0:0:0:0:1','2024-11-15 09:04:16','admin'),(7,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJpc3MiOiJteXRlYW0iLCJpYXQiOjE3MzE5NzY4NDQsImV4cCI6MTczMTk4NzY0NH0.xcrIpei3o6v-aaaKMGaTFRa_Ilc3MMCzNTpYsxv8pdn-enhsPSyjSr0GFtVBFm2u','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/130.0.0.0 Safari/537.36','0:0:0:0:0:0:0:1','2024-11-15 13:44:24','admin'),(8,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJpc3MiOiJteXRlYW0iLCJpYXQiOjE3MzE2NTg3NzcsImV4cCI6MTczMTY2OTU3N30.sI4vdhnOaStv0OMpxwR6M_TbqAOiKeyMMeDtEcSlCerilZ07X_dLMFNsy_cuyYwE','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/130.0.0.0 Safari/537.36','0:0:0:0:0:0:0:1','2024-11-15 17:19:37','user'),(9,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJpc3MiOiJteXRlYW0iLCJpYXQiOjE3MzIxNzg1MzksImV4cCI6MTczMjE4OTMzOX0.VuuUUCxIi6zRB7zxjXbrhndg6g9vcT-V9aYAYkHOv2uyXA1uSx3fXnpf7gw1TopE','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36','0:0:0:0:0:0:0:1','2024-11-15 20:31:29','admin'),(10,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJpc3MiOiJteXRlYW0iLCJpYXQiOjE3MzIwMDI1MzgsImV4cCI6MTczMjAxMzMzOH0.vClDNwh7d-G3qVpMWFgvNS7ADJQDzVE9-k3MZx1AbLnwjwFli_ZQzgsr_EeCJHUy','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36','0:0:0:0:0:0:0:1','2024-11-15 20:41:07','user'),(11,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJpc3MiOiJteXRlYW0iLCJpYXQiOjE3MzIxNzg1MzksImV4cCI6MTczMjE4OTMzOX0.VuuUUCxIi6zRB7zxjXbrhndg6g9vcT-V9aYAYkHOv2uyXA1uSx3fXnpf7gw1TopE','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36','0:0:0:0:0:0:0:1','2024-11-16 01:57:00','admin'),(12,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJpc3MiOiJteXRlYW0iLCJpYXQiOjE3MzIwMDI1MzgsImV4cCI6MTczMjAxMzMzOH0.vClDNwh7d-G3qVpMWFgvNS7ADJQDzVE9-k3MZx1AbLnwjwFli_ZQzgsr_EeCJHUy','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36','0:0:0:0:0:0:0:1','2024-11-16 02:16:33','user'),(13,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJpc3MiOiJteXRlYW0iLCJpYXQiOjE3MzE2OTEwMDUsImV4cCI6MTczMTcwMTgwNX0.hDLO0VCEIokaovNaK4Ua5hGqtPW11ZmsEQlBif3ZEAzdc14VOCDvmaMQa4n_Ocbk','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36','0:0:0:0:0:0:0:1','2024-11-16 02:16:45','user2'),(14,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJpc3MiOiJteXRlYW0iLCJpYXQiOjE3MzIxNzg1MzksImV4cCI6MTczMjE4OTMzOX0.VuuUUCxIi6zRB7zxjXbrhndg6g9vcT-V9aYAYkHOv2uyXA1uSx3fXnpf7gw1TopE','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36','0:0:0:0:0:0:0:1','2024-11-17 15:15:55','admin'),(15,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJpc3MiOiJteXRlYW0iLCJpYXQiOjE3MzIxNzg1MzksImV4cCI6MTczMjE4OTMzOX0.VuuUUCxIi6zRB7zxjXbrhndg6g9vcT-V9aYAYkHOv2uyXA1uSx3fXnpf7gw1TopE','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36','0:0:0:0:0:0:0:1','2024-11-17 20:58:23','admin'),(16,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJpc3MiOiJteXRlYW0iLCJpYXQiOjE3MzIxNzg1MzksImV4cCI6MTczMjE4OTMzOX0.VuuUUCxIi6zRB7zxjXbrhndg6g9vcT-V9aYAYkHOv2uyXA1uSx3fXnpf7gw1TopE','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36','0:0:0:0:0:0:0:1','2024-11-18 21:09:04','admin'),(17,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJpc3MiOiJteXRlYW0iLCJpYXQiOjE3MzE5NzY4NDQsImV4cCI6MTczMTk4NzY0NH0.xcrIpei3o6v-aaaKMGaTFRa_Ilc3MMCzNTpYsxv8pdn-enhsPSyjSr0GFtVBFm2u','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/130.0.0.0 Safari/537.36','0:0:0:0:0:0:0:1','2024-11-19 09:13:22','admin'),(18,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJpc3MiOiJteXRlYW0iLCJpYXQiOjE3MzIxNzg1MzksImV4cCI6MTczMjE4OTMzOX0.VuuUUCxIi6zRB7zxjXbrhndg6g9vcT-V9aYAYkHOv2uyXA1uSx3fXnpf7gw1TopE','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36','0:0:0:0:0:0:0:1','2024-11-19 15:00:09','admin'),(19,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJpc3MiOiJteXRlYW0iLCJpYXQiOjE3MzIwMDI1MzgsImV4cCI6MTczMjAxMzMzOH0.vClDNwh7d-G3qVpMWFgvNS7ADJQDzVE9-k3MZx1AbLnwjwFli_ZQzgsr_EeCJHUy','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36','0:0:0:0:0:0:0:1','2024-11-19 15:35:26','user'),(20,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJpc3MiOiJteXRlYW0iLCJpYXQiOjE3MzIwMDI1NDksImV4cCI6MTczMjAxMzM0OX0.hR1a31PC0K8poATUv1mydGSqkwJVRedzn-6DMMuT4_eF6gNvhQDYL573X4c1nX-V','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36','0:0:0:0:0:0:0:1','2024-11-19 16:49:09','user2'),(21,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJpc3MiOiJteXRlYW0iLCJpYXQiOjE3MzIxNzg1MzksImV4cCI6MTczMjE4OTMzOX0.VuuUUCxIi6zRB7zxjXbrhndg6g9vcT-V9aYAYkHOv2uyXA1uSx3fXnpf7gw1TopE','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36','0:0:0:0:0:0:0:1','2024-11-20 09:16:16','admin'),(22,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJpc3MiOiJteXRlYW0iLCJpYXQiOjE3MzIxNzg1MzksImV4cCI6MTczMjE4OTMzOX0.VuuUUCxIi6zRB7zxjXbrhndg6g9vcT-V9aYAYkHOv2uyXA1uSx3fXnpf7gw1TopE','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36','0:0:0:0:0:0:0:1','2024-11-20 14:06:14','admin'),(23,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJpc3MiOiJteXRlYW0iLCJpYXQiOjE3MzIxNzg1MzksImV4cCI6MTczMjE4OTMzOX0.VuuUUCxIi6zRB7zxjXbrhndg6g9vcT-V9aYAYkHOv2uyXA1uSx3fXnpf7gw1TopE','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36','0:0:0:0:0:0:0:1','2024-11-20 22:25:12','admin'),(24,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJpc3MiOiJteXRlYW0iLCJpYXQiOjE3MzIxNzg1MzksImV4cCI6MTczMjE4OTMzOX0.VuuUUCxIi6zRB7zxjXbrhndg6g9vcT-V9aYAYkHOv2uyXA1uSx3fXnpf7gw1TopE','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36','0:0:0:0:0:0:0:1','2024-11-21 09:26:56','admin'),(25,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJpc3MiOiJteXRlYW0iLCJpYXQiOjE3MzIxNzg1MzksImV4cCI6MTczMjE4OTMzOX0.VuuUUCxIi6zRB7zxjXbrhndg6g9vcT-V9aYAYkHOv2uyXA1uSx3fXnpf7gw1TopE','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36','0:0:0:0:0:0:0:1','2024-11-21 15:43:59','admin');
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
  `member_email` varchar(100) DEFAULT NULL,
  `member_hp` varchar(45) DEFAULT NULL,
  `member_insa_number` varchar(45) DEFAULT NULL,
  `member_no` int DEFAULT NULL,
  `member_type` varchar(45) DEFAULT NULL,
  `team_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`login_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('admin','1234',90,'1','관리자','1','2024-11-12 15:18:19','1234@naver.com','01012341234','12344321',16983,'관리자','IT전략실'),('user','1234',0,'1','유저1','0','2024-11-13 11:40:10','222@naver.com','01011111111','13591359',16984,'그룹장','경영지원팀'),('user2','1234',0,'1','유저2','0','2024-11-16 02:16:16','3333@naver.com','01022222222','15411541',16985,'그룹장','무슨팀일까요'),('user3','1234',0,'1','유저3','0','2024-11-18 02:16:16','4444@naver.com','01033333333','16112344',16981,'그룹장','신입교육팀');
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

-- Dump completed on 2024-11-21 17:47:29
