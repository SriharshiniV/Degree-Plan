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
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `courses` (
  `courseName` varchar(60) NOT NULL,
  PRIMARY KEY (`courseName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES ('CSCE 5050 Applications of Cryptography'),('CSCE 5170 Graph Theory'),('CSCE 5200 Information Retrieval and Web Search'),('CSCE 5220 Computer Graphics'),('CSCE 5370 Distributed and Parallel Database Systems'),('CSCE 5380 Data Mining'),('CSCE 5510 Wireless Communications'),('CSCE 5520 Wireless Networks and Protocols'),('CSCE 5530 Computer Network Design'),('CSCE 5540 Introduction to Sensor Networks'),('CSCE 5550 Introduction to Computer Security'),('CSCE 5580 Computer Networks '),('CSCE 5615 (5933) Networks-on-Chip'),('CSCE 5933 LTE Physical Layer'),('CSCE 5933/5390 Topics in CSCE, Topic: Multimedia Computing');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courses_dp`
--

DROP TABLE IF EXISTS `courses_dp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `courses_dp` (
  `userName` varchar(50) DEFAULT NULL,
  `courseCatergory` varchar(20) DEFAULT NULL,
  `courseName` varchar(80) DEFAULT NULL,
  `semesterTaken` varchar(30) DEFAULT NULL,
  `cHrs` int(11) DEFAULT NULL,
  `grade` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses_dp`
--

LOCK TABLES `courses_dp` WRITE;
/*!40000 ALTER TABLE `courses_dp` DISABLE KEYS */;
INSERT INTO `courses_dp` VALUES ('sharanya','courseA','CSCE 5450 Programming Languages','Fall',3,'A'),('sharanya','courseB','CSCE 5580 Computer Networks','spring',3,'A'),('sharanya','courseC','CSCE 5170 Graph Theory','spring',3,'A'),('sharanya','courseD','CSCE 5350 Fundamentals of Database Systems','spring',3,'A'),('sharanya','optional','CSCE 5200 Information Retrieval and Web Search','Fall',3,'a'),('sharanya','optional','CSCE 5050 Applications of Cryptography','spring',3,'a'),('sharanya','optional','CSCE 5170 Graph Theory','summer',3,'a'),('sharanya','optional','CSCE 5370 Distributed and Parallel Database Systems','Fall',3,'a'),('sharanya','optional','CSCE 5615 (5933) Networks-on-Chip','spring',3,'a'),('sharanya','optional','CSCE 5933/5390 Topics in CSCE, Topic: Multimedia Computing','spring',3,'a'),('sharanya','optional','CSCE 5530 Computer Network Design','summer',3,'a'),('sharanya','optional','CSCE 5380 Data Mining','spring',3,'a');
/*!40000 ALTER TABLE `courses_dp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `degreeplan`
--

DROP TABLE IF EXISTS `degreeplan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `degreeplan` (
  `userName` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `studentId` int(11) DEFAULT NULL,
  `localAddress` varchar(200) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `degree` varchar(20) DEFAULT NULL,
  `major` varchar(40) DEFAULT NULL,
  `minor` varchar(40) DEFAULT NULL,
  `interestArea` varchar(40) DEFAULT NULL,
  `majorProfessor` varchar(40) DEFAULT NULL,
  `coMajorProfessor` varchar(40) DEFAULT NULL,
  `totalCreditHours` int(11) DEFAULT NULL,
  `degreePlanStatus` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `degreeplan`
--

LOCK TABLES `degreeplan` WRITE;
/*!40000 ALTER TABLE `degreeplan` DISABLE KEYS */;
INSERT INTO `degreeplan` VALUES ('sharanya','sharanya',11217894,'2415 charlotte street','sharanyagottimukkula@my.unt.edu','M.S','computerScience','computer engineering','software engineering','Dr. Armin Mikler','Dr. Armin Mikler',36,'submitted');
/*!40000 ALTER TABLE `degreeplan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gre`
--

DROP TABLE IF EXISTS `gre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `gre` (
  `userName` varchar(50) NOT NULL,
  `verbal` int(11) DEFAULT NULL,
  `quantitative` int(11) DEFAULT NULL,
  `analytical` int(11) DEFAULT NULL,
  `dateTaken` date DEFAULT NULL,
  PRIMARY KEY (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gre`
--

LOCK TABLES `gre` WRITE;
/*!40000 ALTER TABLE `gre` DISABLE KEYS */;
INSERT INTO `gre` VALUES ('sharanya',130,130,2,'2018-10-12');
/*!40000 ALTER TABLE `gre` ENABLE KEYS */;
UNLOCK TABLES;

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
INSERT INTO `login` VALUES ('aravind','347b7d2417ca30d906dc5edda4056d7b','student'),('bryant','f925916e2754e5e03f75dd58a5733251','chair'),('CSCEUNT_DPA','a39d362c8364f35fe6ce612d1e5dbee3','admin'),('harshini','e6d304912bdaaad6e67c2f6fdf8015cb','student'),('mikler','e63eea102da9e561d9e1281a9e2dd6b6','professor'),('nanditha','8e86ec7899c66248e6bf5d24503bd3f9','student'),('sharanya','d232704062b0fea5c8d5b869cddef2a5','student');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `majorprofessor`
--

DROP TABLE IF EXISTS `majorprofessor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `majorprofessor` (
  `studentName` varchar(50) NOT NULL,
  `studentMajor` varchar(20) DEFAULT NULL,
  `professorName` varchar(50) DEFAULT NULL,
  `professorEmail` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`studentName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `majorprofessor`
--

LOCK TABLES `majorprofessor` WRITE;
/*!40000 ALTER TABLE `majorprofessor` DISABLE KEYS */;
INSERT INTO `majorprofessor` VALUES ('aravind','CS','Bryant Barett','BryantBarett@unt.edu'),('harshini','CS','Bryant Barett','BryantBarett@unt.edu'),('nanditha','CS','Bryant Barett','BryantBarett@unt.edu'),('sharanya','CS','Dr. Armin Mikler','arminmikler@unt.edu');
/*!40000 ALTER TABLE `majorprofessor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mandatorycourses`
--

DROP TABLE IF EXISTS `mandatorycourses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `mandatorycourses` (
  `CourseName` varchar(80) NOT NULL,
  `groupId` varchar(20) DEFAULT NULL,
  `major` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`CourseName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mandatorycourses`
--

LOCK TABLES `mandatorycourses` WRITE;
/*!40000 ALTER TABLE `mandatorycourses` DISABLE KEYS */;
INSERT INTO `mandatorycourses` VALUES ('CSCE 5150 Analysis of Algorithms','C','CS'),('CSCE 5160 Parallel Processing and Algorithms','B','CE'),('CSCE 5170 Graph Theory','C','CS'),('CSCE 5210 Artificial Intelligence','D','CS'),('CSCE 5350 Fundamentals of Database Systems','D','CS'),('CSCE 5400 Automata Theory','C','CS'),('CSCE 5430 Software Engineering','A','CS'),('CSCE 5440 Real-Time Software Development','C','CE'),('CSCE 5450 Programming Languages','A','CS'),('CSCE 5510 Wireless Communications','A','CE'),('CSCE 5520 Wireless Networks and Protocols','A','CE'),('CSCE 5550 Computer Security','D','CS'),('CSCE 5580 Computer Networks','B','CSCE'),('CSCE 5610 Computer System Architecture','B','CSCE'),('CSCE 5612 (5933) Embedded Hardware & Software Design','C','CE'),('CSCE 5620 Real-time Operating Systems','C','CE'),('CSCE 5640 Operating System Design','B','CSCE'),('CSCE 5650 Compiler Design','A','CS'),('CSCE 5730 Digital CMOS VLSI Design','D','CE'),('CSCE 5740 Topics in Modern Electronic System Design','D','CE'),('CSCE 5760 Design for Fault Tolerance','D','CE');
/*!40000 ALTER TABLE `mandatorycourses` ENABLE KEYS */;
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
INSERT INTO `register` VALUES ('Aravind Thotempudi','aravindthottempudi@my.unt.edu','student','aravind','347b7d2417ca30d906dc5edda4056d7b'),('Dr. Armin Mikler','arminmikler@unt.edu','professor','mikler','e63eea102da9e561d9e1281a9e2dd6b6'),('Bryant Barett','BryantBarett@unt.edu','chair','Bryant','f925916e2754e5e03f75dd58a5733251'),('Nanditha Bodanapu','nandithabodanapu@my.unt.edu','student','nanditha','8e86ec7899c66248e6bf5d24503bd3f9'),('Sharanya Gottimukkula','sharanyagottimukkula@my.unt.edu','student','Sharanya','d232704062b0fea5c8d5b869cddef2a5'),('Sri Harshini','sriharshinivallabhaneni@my.unt.edu','student','harshini','e6d304912bdaaad6e67c2f6fdf8015cb');
/*!40000 ALTER TABLE `register` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requests`
--

DROP TABLE IF EXISTS `requests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `requests` (
  `userName` varchar(50) NOT NULL,
  `professorName` varchar(50) DEFAULT NULL,
  `professorEmail` varchar(80) NOT NULL,
  `department` varchar(30) DEFAULT NULL,
  `admissionSemester` varchar(30) DEFAULT NULL,
  `admissionYear` int(11) DEFAULT NULL,
  `message` varchar(4000) DEFAULT NULL,
  `requestStatus` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`userName`,`professorEmail`),
  CONSTRAINT `requests_ibfk_1` FOREIGN KEY (`userName`) REFERENCES `login` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requests`
--

LOCK TABLES `requests` WRITE;
/*!40000 ALTER TABLE `requests` DISABLE KEYS */;
INSERT INTO `requests` VALUES ('aravind','Bryant Barett','BryantBarett@unt.edu','CS','fall',2017,'please accept my request','Request Accepted'),('harshini','Bryant Barett','BryantBarett@unt.edu','CS','fall',2017,'Please accept','Request Accepted'),('nanditha','Bryant Barett','BryantBarett@unt.edu','CS','fall',2017,'Hello Sir,\r\n\r\nIt would be great if you can accept my request.\r\n\r\nThanks\r\nSharanya','Request Accepted'),('sharanya','Dr. Armin Mikler','arminmikler@unt.edu','CS','fall',2017,'Hello Sir\r\n\r\nIt would be great if you can accept my request and be my major professor.\r\n\r\nThanks\r\nSharanya','Request Accepted'),('sharanya','Bryant Barett','BryantBarett@unt.edu','CS','fall',2017,'mmmmm','Request Sent');
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

-- Dump completed on 2018-10-28 17:52:33
