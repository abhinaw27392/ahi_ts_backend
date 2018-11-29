CREATE DATABASE  IF NOT EXISTS `ah_db` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `ah_db`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ah_db
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.28-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ahi_departments`
--

DROP TABLE IF EXISTS `ahi_departments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ahi_departments` (
  `department_id` int(10) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(200) NOT NULL,
  `department_description` varchar(400) NOT NULL,
  `headed_by_user_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`department_id`),
  UNIQUE KEY `department_id_UNIQUE` (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ahi_departments`
--

LOCK TABLES `ahi_departments` WRITE;
/*!40000 ALTER TABLE `ahi_departments` DISABLE KEYS */;
INSERT INTO `ahi_departments` VALUES (1,'web11','development11',39),(2,'DevOPs','development',44);
/*!40000 ALTER TABLE `ahi_departments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ahi_projects`
--

DROP TABLE IF EXISTS `ahi_projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ahi_projects` (
  `project_id` int(10) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(200) NOT NULL,
  `project_description` varchar(400) NOT NULL,
  `headed_by_user_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`project_id`),
  UNIQUE KEY `project_id_UNIQUE` (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ahi_projects`
--

LOCK TABLES `ahi_projects` WRITE;
/*!40000 ALTER TABLE `ahi_projects` DISABLE KEYS */;
INSERT INTO `ahi_projects` VALUES (17,'timesheet','related to timesheet of employee',39),(18,'asset management','related to assets of office',37),(20,'money management','related to salary of employee',39),(22,'saurav project','saurav project',36),(23,'timesheeet application','related to timesheeet',2),(24,'demoproject','demoproject',36);
/*!40000 ALTER TABLE `ahi_projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ahi_security_group`
--

DROP TABLE IF EXISTS `ahi_security_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ahi_security_group` (
  `security_group_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `security_group_code` varchar(255) DEFAULT NULL,
  `security_group_name` varchar(255) DEFAULT NULL,
  `when_created` datetime DEFAULT NULL,
  `when_updated` datetime DEFAULT NULL,
  `who_created` varchar(255) DEFAULT NULL,
  `who_updated` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`security_group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ahi_security_group`
--

LOCK TABLES `ahi_security_group` WRITE;
/*!40000 ALTER TABLE `ahi_security_group` DISABLE KEYS */;
INSERT INTO `ahi_security_group` VALUES (1,'ADMIN','Admin User',NULL,NULL,NULL,NULL),(2,'MANAGER','Manager User',NULL,NULL,NULL,NULL),(3,'USER','Normal User',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `ahi_security_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ahi_tasks`
--

DROP TABLE IF EXISTS `ahi_tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ahi_tasks` (
  `task_id` int(10) NOT NULL AUTO_INCREMENT,
  `task_name` varchar(200) NOT NULL,
  `task_description` varchar(400) NOT NULL,
  `user_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`task_id`),
  UNIQUE KEY `task_id_UNIQUE` (`task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=151 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ahi_tasks`
--

LOCK TABLES `ahi_tasks` WRITE;
/*!40000 ALTER TABLE `ahi_tasks` DISABLE KEYS */;
INSERT INTO `ahi_tasks` VALUES (144,'development','development of timesheet page',2),(145,'debugging','debugging of timesheet application',2),(146,'testing aa44','testing of timesheet application',2),(147,'debugging saurav','debugging',36),(148,'new task for sanjana','new task for sanjana',42),(149,'Demo','Demo',2),(150,'demo3','demo3',2);
/*!40000 ALTER TABLE `ahi_tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ahi_timesheet`
--

DROP TABLE IF EXISTS `ahi_timesheet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ahi_timesheet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) NOT NULL,
  `task_id` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  `total_hours` int(11) DEFAULT NULL,
  `emp_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `project_id_ts_idx` (`project_id`),
  KEY `task_id_ts_idx` (`task_id`),
  CONSTRAINT `project_id_ts` FOREIGN KEY (`project_id`) REFERENCES `ahi_projects` (`project_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `task_id_ts` FOREIGN KEY (`task_id`) REFERENCES `ahi_tasks` (`task_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ahi_timesheet`
--

LOCK TABLES `ahi_timesheet` WRITE;
/*!40000 ALTER TABLE `ahi_timesheet` DISABLE KEYS */;
INSERT INTO `ahi_timesheet` VALUES (1,20,146,'2018-11-15',1,2),(2,20,146,'2018-11-16',5,2),(3,20,146,'2018-11-19',4,2),(4,18,144,'2018-11-16',2,2),(5,18,144,'2018-11-17',2,2),(6,18,144,'2018-11-18',2,2),(7,18,144,'2018-11-19',2,2),(8,18,145,'2018-11-11',8,2),(9,23,145,'2018-11-17',4,2),(10,23,145,'2018-11-18',0,2),(11,23,145,'2018-11-19',4,2),(12,23,145,'2018-11-20',4,2),(13,23,145,'2018-11-26',0,2),(14,18,145,'2018-11-05',8,2),(15,18,145,'2018-11-10',8,2),(16,20,145,'2018-11-26',2,2),(17,20,145,'2018-11-27',2,2),(18,20,145,'2018-11-28',2,2),(19,20,145,'2018-11-29',2,2),(20,20,145,'2018-11-30',2,2),(21,20,145,'2018-12-01',2,2),(22,20,145,'2018-12-02',2,2),(23,22,145,'2018-11-26',2,2),(24,22,145,'2018-11-27',4,2),(25,22,145,'2018-11-28',6,2),(26,22,145,'2018-11-29',7,2),(27,22,145,'2018-11-30',8,2),(28,22,145,'2018-12-01',9,2),(29,22,146,'2018-11-26',8,2),(30,22,146,'2018-11-27',9,2),(31,22,146,'2018-11-28',9,2),(32,22,146,'2018-11-29',0,2),(33,22,146,'2018-11-30',9,2),(34,22,146,'2018-12-01',9,2);
/*!40000 ALTER TABLE `ahi_timesheet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ahi_user`
--

DROP TABLE IF EXISTS `ahi_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ahi_user` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `login_id` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `when_created` datetime DEFAULT NULL,
  `when_updated` datetime DEFAULT NULL,
  `who_created` varchar(255) DEFAULT NULL,
  `who_updated` varchar(255) DEFAULT NULL,
  `dob` datetime DEFAULT NULL,
  `designation` varchar(60) DEFAULT NULL,
  `joining_date` datetime DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  `supervisor_id` int(10) unsigned DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `login_id_UNIQUE` (`login_id`),
  KEY `supervisor_fk_iidx1` (`supervisor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ahi_user`
--

LOCK TABLES `ahi_user` WRITE;
/*!40000 ALTER TABLE `ahi_user` DISABLE KEYS */;
INSERT INTO `ahi_user` VALUES (1,'','Surjit','Konjengbam','100001','$2a$10$PSk111GESB2Sjq0xc.Q.FezCoI1qAnfBydJemYvQy5NS0r/YmlLqq','surjit.konjengbam@gmail.com','2018-01-30 11:51:51','2018-01-30 11:51:51','admin','admin','1980-09-09 00:00:00','software developer','2018-01-30 00:00:00','admin',1,'USA'),(2,'','Abhinaw','Shahi','100021','$2a$10$JfhgzvYCuPRyvSZCuSe7ze52s3ffTJb9uMLh8QJrZ2fqwC8HhR2j2','abhinaw.kumar@ahinfotech.in','2018-01-30 11:51:51','2018-11-20 11:41:47','admin','100021','2018-01-30 11:51:51','software developer','2018-01-30 11:51:51','admin',1,'Bangalore'),(36,'','saurabh','siwa','100035','$2a$10$DMGbFbs27tgld1YQ3X0VwOFDLj8NXB.hVZ2rykX1PYY1kDvcRdGDa',NULL,'2018-09-17 21:13:57','2018-09-17 21:13:57','100035','100035','2015-01-01 05:30:00','software developer','2017-01-01 05:30:00','user',2,'Bangalore'),(37,'','sumit','sharma','100022','$2a$10$fUKaFS66QbNfDGrv2/lA3ekzBVyM/PAKjuAK7TrSaBCOKApaI1p0S',NULL,'2018-09-17 21:39:37','2018-09-17 21:39:37','undefined','undefined','1991-01-01 05:30:00','software developer','2016-01-01 05:30:00','user',2,'Bangalore'),(38,'','Kavyashree','Balabhadra','100034','$2a$10$Yzg3jZ1zRSEl4GDedZybo.YWFAbOEI4dvNauN7Yu.Lob.lwjJs4.u',NULL,'2018-09-18 11:18:42','2018-09-18 11:18:42','undefined','undefined','1988-06-01 05:30:00','Senior Developer','2017-01-27 05:30:00','user',2,'Bangalore'),(39,'','Amit','Pankaj','100024','$2a$10$PZX3bTGUWp7wrwP4dyhtj.lXjkDRaQ7a/3/jibaF5y0d8cdvDJBrG',NULL,'2018-09-18 15:12:33','2018-09-18 15:12:33','undefined','undefined','1957-01-01 05:30:00','software developer','2016-01-01 05:30:00','manager',40,'Bangalore'),(40,'','rajan','ranjan','100045','$2a$10$ssNbvGf8eVOVW9DL1IEMt.d/h3yd2ImpThrMS/SJ165lWESABnePS',NULL,'2018-09-18 18:09:21','2018-09-18 18:09:21','100021','100021','1999-02-01 05:30:00','sd','2016-02-01 05:30:00','user',2,'Bangalore'),(41,'','raghav','bhagavat','100033','$2a$10$0ZLvP1BPUnAN9lFun2i5v.LrYZ58eW22TVKhI2Jerq.Ydpx29AnSC',NULL,'2018-09-18 19:06:11','2018-09-18 19:06:11','100035','100035','2009-02-01 05:30:00','senior software deve','2016-01-01 05:30:00','user',2,'Bangalore'),(42,'','sanjana','H.E','100077','$2a$10$AMFtTIYJP8bukNo2C.p8gOw72Od0jXvXs9KWk/3je9UGd40ZicgEG',NULL,'2018-09-24 17:08:42','2018-09-24 17:08:42','100021','100021','1994-09-19 05:30:00','software developer','2018-09-24 05:30:00','user',2,'Bangalore'),(43,'','piyush','raj','100041','$2a$10$l6TojtPJymCunn3jqq9xGexnbT0U8OaLM.PNARIbc7PZmNOp.uju2',NULL,'2018-09-26 18:07:23','2018-09-26 18:07:23','100021','100021','1993-08-01 05:30:00','intern','2018-09-01 05:30:00','user',2,'Bangalore'),(44,'','demo4','demolast','100049','$2a$10$T3KCBIukDpr.23gK1c5rIOCUbTBmLUshyQav3NPHbx9G5KSh.8nE.',NULL,'2018-09-26 18:33:52','2018-09-26 18:33:52','100021','100021','2001-01-01 05:30:00','lead','2016-01-01 05:30:00','manager',2,'USA'),(45,'','sachin','mukherjee','100031','$2a$10$C3d.Qoc8D2EZDUy0zU1yO.CjR1uCfd2DoLTETtgi/k0c7BVIZWShi',NULL,'2018-10-03 16:01:48','2018-10-03 16:01:48','100021','100021','1991-01-01 05:30:00','software developer','2016-01-01 05:30:00','user',2,'Bangalore'),(46,'','aa','aa','100067','$2a$10$qUx7PoTn02Kb/Lcm2cVzI.M4q0i9fsn1bUlHp4Teiw/OFpdBIrrWq',NULL,'2018-10-12 18:11:17','2018-10-12 18:11:17','100021','100021','2018-01-01 05:30:00','aa','2016-01-01 05:30:00','user',37,'aa'),(47,'','gg','gg','100078','$2a$10$CppiRhSV.j3C/pwrPDZSU.OywraqX1l.GVdmwtLc3swcnePx9lHNS',NULL,'2018-10-15 12:09:59','2018-10-15 12:09:59','100021','100021','1993-01-01 05:30:00','hhhhh','2016-12-01 05:30:00','user',38,'gg'),(48,'','h','hh','100079','$2a$10$/3b.v04Q03P19JnHMMyz7uU4wL2fl7dYlOQjNDzUQ6M6D0xEOPyAe',NULL,'2018-10-15 12:15:03','2018-10-15 12:15:03','100021','100021','1992-01-01 05:30:00','hh','2016-01-01 05:30:00','user',37,'hhhh'),(49,'','unk','aa','100089','$2a$10$cSGWXy0QhNqH6J7JA6Dvs.XgB.n1hX81fgWzMURijC0XJO..GpSWS',NULL,'2018-10-15 12:16:36','2018-10-15 12:16:36','100021','100021','1996-01-01 05:30:00','bb','2017-01-01 05:30:00','user',2,'bang'),(50,'','ss','ss','100029','$2a$10$t9yJpL.GDeThhTvTEyl3ie14Fsibq.zcO8fNsOc.5nAi/vqrrjOXS',NULL,'2018-10-15 13:34:14','2018-10-15 13:34:14','100021','100021','2002-01-01 05:30:00','ss','2016-01-01 05:30:00','user',38,'ss'),(51,'','tt','tt','111111','$2a$10$4LASf5CwZV7gQOMeSSSqlujqayA2VN/D8d0ur.xUroKXcpqECGEVe',NULL,'2018-10-15 13:48:55','2018-10-15 13:48:55','100021','100021','2017-01-01 05:30:00','tt','2018-01-02 05:30:00','user',2,'tt'),(53,'','hh','hh','123212','$2a$10$pUjeaUVgOlUeZpH3w4JIGeCR6BX9v38.zarGEKxcwukre1PEtP2Ra',NULL,'2018-10-31 15:22:04','2018-10-31 15:22:04','100021','100021','2018-01-01 00:00:00','gg','2018-01-01 00:00:00','admin',1,'hh'),(54,'','kk','kk','134321','$2a$10$Fe9eHtqBEiFGKlWVTdzo4.dnIunU.vc0QsdZBmJBErnad24uFpqRe',NULL,'2018-10-31 15:22:55','2018-10-31 15:22:55','100021','100021','2018-01-01 00:00:00','kk','2018-01-01 00:00:00','admin',2,'kk'),(56,'','guru','pr','123456','$2a$10$4JX2hzxIwHIwcNP1L8ngUuqmOxDtdOKAyxfXTNQGOZjCgNrebJlu2',NULL,'2018-10-31 15:45:35','2018-10-31 15:45:35','100021','100021','1211-12-12 00:00:00','tl','1111-11-11 00:00:00','manager',40,'bangalore');
/*!40000 ALTER TABLE `ahi_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ahi_user_security_group`
--

DROP TABLE IF EXISTS `ahi_user_security_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ahi_user_security_group` (
  `security_group_id` int(10) unsigned NOT NULL,
  `user_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`user_id`,`security_group_id`),
  KEY `id_idx` (`user_id`),
  KEY `id1` (`security_group_id`),
  CONSTRAINT `id1` FOREIGN KEY (`security_group_id`) REFERENCES `ahi_security_group` (`security_group_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id2` FOREIGN KEY (`user_id`) REFERENCES `ahi_user` (`user_id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ahi_user_security_group`
--

LOCK TABLES `ahi_user_security_group` WRITE;
/*!40000 ALTER TABLE `ahi_user_security_group` DISABLE KEYS */;
INSERT INTO `ahi_user_security_group` VALUES (1,1);
/*!40000 ALTER TABLE `ahi_user_security_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'ah_db'
--

--
-- Dumping routines for database 'ah_db'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-28 16:47:00
