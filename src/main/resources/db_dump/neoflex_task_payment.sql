CREATE DATABASE  IF NOT EXISTS `neoflex_task` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `neoflex_task`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: neoflex_task
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `payment` (
  `requestId` varchar(10) NOT NULL,
  `amount` double unsigned NOT NULL,
  `currency` varchar(30) NOT NULL,
  `operatingType` varchar(2) NOT NULL,
  `remark` text,
  `accountNumberFrom` varchar(45) NOT NULL,
  `accountNumberTo` varchar(45) NOT NULL,
  `referenceNumber` varchar(32) NOT NULL,
  `status` varchar(45) DEFAULT NULL,
  `dateStamp` timestamp NOT NULL,
  PRIMARY KEY (`requestId`),
  UNIQUE KEY `referenceNumber_UNIQUE` (`referenceNumber`),
  UNIQUE KEY `requestId_UNIQUE` (`requestId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES ('fgrfe3',123,'re','ca','ffg','qwe','eqeqw','2osaoduqqtibwe4uchi4rhe4j55uo45a','gg','2019-04-24 04:18:07'),('qq',85,'eur','CA','GOOD','8800555352','8880555355','lpyilqzpdx0b3q58g3pvv18ancsh5jeo',NULL,'2019-04-14 14:56:47'),('qq0',85,'eur','CA','GOOD','8800555352','8808553535','b63qyg4oo7eggk0gvqcxcjnj90qc11x6','bb','2019-04-14 17:42:35'),('qq1',85,'eur','CA','GOOD','8800555352','8805553535','4gykjae8jp2nl6owkcfy13eim20egxt4','g','2019-04-14 17:42:35'),('qq2',85,'eur','CA','GOOD','8800555352','8808553535','z7uo4lsnwqnues8fb4lbb2lvyfuhvxc6','gg','2019-04-14 17:42:35'),('qq3',85,'eur','CA','GOOD','8800555352','8808553535','ca2zkdoouus2o2g2yy39ugh7dap26f97','b','2019-04-14 17:42:35'),('qq4',85,'eur','CA','GOOD','8800553352','8808553535','ndyib31jgr0kl2ple7unqbyscumgwgdx','gb','2019-04-14 17:42:35'),('qq5',85,'eur','CA','GOOD','8800555352','8800853535','6rh6dknikf54lmi1ic9xnqaalxmgk5as','ghd','2019-04-14 17:42:35'),('qq6',85,'eur','CA','GOOD','8800555352','8800853535','igps8vsmdrhygpjp2iowe94286st34ef','egeg','2019-04-14 17:42:35'),('qq7',85,'eur','CA','GOOD','8800553352','8808835385','nj3f48pdpb3kpkbmoh890qhpkic7grr4','egs','2019-04-14 17:42:35'),('qqf',85,'eur','CA','GOOD','88fg5553535','Ayfgana','kaytds1j7jfzsqteurq3db5r6hn9fll1','dfgb','2019-04-23 12:24:04'),('qqff',123,'eur','AC','jj','qwe','erer','2wdfn06bqb1xdfz1c5hqs37bm4rg79cs','dfg','2019-04-23 16:16:54');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-24 10:27:30
