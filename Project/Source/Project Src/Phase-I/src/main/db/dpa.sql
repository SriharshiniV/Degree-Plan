-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: dpa
-- ------------------------------------------------------
-- Server version	8.0.12

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
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `login` (
  `userName` varchar(40) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `role` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('aravind','806af810e2bbe73310e53e52ffc2de7f','student'),('bryant','e5b79bbdb797144a4cbf576aef22f492','chair'),('CSCEUNT_DPA','ba0af364b2d1ae82bd2cd44002c3c8c6','admin'),('mikler','42972dfe655ee2de724d96fd1b2193b1','professor'),('nanditha','f13bbffce11026f9ca053b4c9935581b','student'),('sharanya','2b864cad0ede992c2fb13954d0638ca9','student');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `majorprofessor`
--

DROP TABLE IF EXISTS `majorprofessor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `majorprofessor` (
  `studentName` varchar(40) DEFAULT NULL,
  `studentMajor` varchar(40) DEFAULT NULL,
  `professorName` varchar(40) DEFAULT NULL,
  `professorEmail` varchar(60) DEFAULT NULL,
  KEY `professorEmail` (`professorEmail`),
  CONSTRAINT `majorprofessor_ibfk_1` FOREIGN KEY (`professorEmail`) REFERENCES `requests` (`professoremail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `majorprofessor`
--

LOCK TABLES `majorprofessor` WRITE;
/*!40000 ALTER TABLE `majorprofessor` DISABLE KEYS */;
INSERT INTO `majorprofessor` VALUES ('sharanya','CS','Dr. Armin Mikler','arminmikler@unt.edu');
/*!40000 ALTER TABLE `majorprofessor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `register`
--

DROP TABLE IF EXISTS `register`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `register` (
  `name` varchar(30) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `role` varchar(30) DEFAULT NULL,
  `userName` varchar(30) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `register`
--

LOCK TABLES `register` WRITE;
/*!40000 ALTER TABLE `register` DISABLE KEYS */;
INSERT INTO `register` VALUES ('Aravind Thotempudi','aravindthottempudi@my.unt.edu','student','aravind','806af810e2bbe73310e53e52ffc2de7f'),('Dr. Armin Mikler','arminmikler@unt.edu','professor','mikler','42972dfe655ee2de724d96fd1b2193b1'),('Bryant Barett','BryantBarett@unt.edu','chair','Bryant','e5b79bbdb797144a4cbf576aef22f492'),('Nanditha Bodanapu','nandithabodanapu@my.unt.edu','student','nanditha','f13bbffce11026f9ca053b4c9935581b'),('Sharanya Gottimukkula','sharanyagottimukkula@my.unt.edu','student','Sharanya','2b864cad0ede992c2fb13954d0638ca9');
/*!40000 ALTER TABLE `register` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requests`
--

DROP TABLE IF EXISTS `requests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `requests` (
  `userName` varchar(50) DEFAULT NULL,
  `professorName` varchar(50) DEFAULT NULL,
  `professorEmail` varchar(80) NOT NULL,
  `department` varchar(30) DEFAULT NULL,
  `admissionSemester` varchar(30) DEFAULT NULL,
  `admissionYear` int(11) DEFAULT NULL,
  `message` varchar(4000) DEFAULT NULL,
  `requestStatus` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`professorEmail`),
  KEY `userName` (`userName`),
  CONSTRAINT `requests_ibfk_1` FOREIGN KEY (`userName`) REFERENCES `login` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requests`
--

LOCK TABLES `requests` WRITE;
/*!40000 ALTER TABLE `requests` DISABLE KEYS */;
INSERT INTO `requests` VALUES ('sharanya','Dr. Armin Mikler','arminmikler@unt.edu','CS','fall',2017,'Hello Sir\r\n\r\nIt would be great if you can accept my request and be my major professor.\r\n\r\nThanks\r\nSharanya','Request Accepted');
/*!40000 ALTER TABLE `requests` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-26 13:32:38
