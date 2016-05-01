-- MySQL dump 10.13  Distrib 5.7.9, for osx10.9 (x86_64)
--
-- Host: localhost    Database: SPPDB
-- ------------------------------------------------------
-- Server version	5.7.11

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
-- Table structure for table `certificate`
--

DROP TABLE IF EXISTS `certificate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `certificate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_student` int(11) NOT NULL,
  `id_course` int(11) NOT NULL,
  `data` varchar(256) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `asdasd` (`id_student`),
  KEY `Student_idx` (`id_student`),
  KEY `lllal` (`id_student`),
  KEY `Course_idx` (`id_course`),
  CONSTRAINT `CourseIDFK` FOREIGN KEY (`id_course`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `StudID` FOREIGN KEY (`id_student`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `certificate`
--

LOCK TABLES `certificate` WRITE;
/*!40000 ALTER TABLE `certificate` DISABLE KEYS */;
INSERT INTO `certificate` VALUES (1,1,3,'10 iz 10 paranek!!','2022-03-20'),(5,1,2,'znex is the best','1941-03-22'),(11,1,2,'best top 1','1941-03-22'),(12,2,2,'good guy 10 iz 100','2021-03-22');
/*!40000 ALTER TABLE `certificate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) NOT NULL,
  `technology` varchar(256) NOT NULL,
  `id_lecturer` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Lecturer_idxs` (`id_lecturer`),
  CONSTRAINT `id_lecturerFK` FOREIGN KEY (`id_lecturer`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'Intro to JS: Drawing & Animation','JS',4,100),(2,'Intro to HTML/CSS: Making webpages','HTML, CSS',5,150),(3,'Advanced JS: Natural Simulations','JS',3,200),(4,'Introduction to Programming in Java','Java',4,220),(5,'Programming in C++','C++',5,1100),(9,'Assembler fo web development','Asm',5,1000);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_lesson`
--

DROP TABLE IF EXISTS `course_lesson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course_lesson` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_course` int(11) NOT NULL,
  `id_lesson` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `courseFK_idx` (`id_course`),
  CONSTRAINT `courseFK` FOREIGN KEY (`id_course`) REFERENCES `course` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_lesson`
--

LOCK TABLES `course_lesson` WRITE;
/*!40000 ALTER TABLE `course_lesson` DISABLE KEYS */;
/*!40000 ALTER TABLE `course_lesson` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `data_for_lesson`
--

DROP TABLE IF EXISTS `data_for_lesson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data_for_lesson` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` longtext NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_for_lesson`
--

LOCK TABLES `data_for_lesson` WRITE;
/*!40000 ALTER TABLE `data_for_lesson` DISABLE KEYS */;
INSERT INTO `data_for_lesson` VALUES (1,'FirstLesson of first course'),(2,'Second lesson of first course'),(3,'One more data'),(4,'Some data for lesson'),(5,'Beautiful text here'),(6,'Some video and text for lesson'),(7,'A lot of info '),(8,'kqwrkwqrlkqrlkr'),(9,'12112121212'),(10,'124kf;lkfs;lf'),(11,'124232314224141'),(12,'121'),(13,'12321'),(14,'12o12o'),(15,'12312231132213231213'),(16,'krelkerlerkl'),(17,'1234255252'),(18,'sdlsdlksdlkdsldlsk'),(19,'sdlsdlksdlkdsldlsk'),(20,'1lldsdsldsldsl'),(21,'121314'),(22,'fldkg;kgdl'),(23,'dkgkdkdjgjkgd'),(24,'efjksjfksjsf'),(25,'dksskd'),(26,'2112122112'),(27,'351003'),(28,'Bookakakakaka'),(29,'sjddsj'),(30,'sayufdatiuyoiuasuoias'),(31,'fasasfasfs'),(32,'122112kl12kl12'),(33,'elkdlksfdlkfsdldfkldsf'),(34,'Kokokokokokokokoko'),(35,'znexiiie'),(36,''),(37,'sffaffafaafa'),(38,'afdasfdsafdsasaf'),(39,'4erreerererer'),(40,'sdsadsdsada'),(41,'mbmnbmnbmnbmnbmnbmnbmbmn'),(42,'ndnddndnmmmmnddnsd'),(43,'djkf'),(44,'sdshsdjsddshjh');
/*!40000 ALTER TABLE `data_for_lesson` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `document`
--

DROP TABLE IF EXISTS `document`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `document` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_student` int(11) DEFAULT NULL,
  `type` varchar(45) NOT NULL,
  `id_course` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `id_lecturer` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `asdasd` (`id_student`),
  KEY `Student_idx` (`id_student`),
  KEY `lllal` (`id_student`),
  KEY `Course_idx` (`id_course`),
  KEY `Lect_idx` (`id_lecturer`),
  CONSTRAINT `Course` FOREIGN KEY (`id_course`) REFERENCES `course` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Lect` FOREIGN KEY (`id_lecturer`) REFERENCES `lecturer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document`
--

LOCK TABLES `document` WRITE;
/*!40000 ALTER TABLE `document` DISABLE KEYS */;
INSERT INTO `document` VALUES (1,2,'12',1,'2019-02-20 16:00:00',1),(2,3,'12',2,'2019-03-20 16:00:00',2),(3,7,'12',3,'2020-03-20 16:00:00',3),(4,7,'12',4,'2020-03-20 16:00:00',1),(5,3,'12',5,'2021-03-20 16:00:00',2);
/*!40000 ALTER TABLE `document` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lecturer`
--

DROP TABLE IF EXISTS `lecturer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lecturer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(25) NOT NULL,
  `password` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `email` varchar(100) NOT NULL,
  `ban_status` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lecturer`
--

LOCK TABLES `lecturer` WRITE;
/*!40000 ALTER TABLE `lecturer` DISABLE KEYS */;
INSERT INTO `lecturer` VALUES (1,'trueLecturer','12345','Richard','Jefferson','+375441234567','r_jefferson@gmail.com',0),(2,'Gaytakae','23456','Donald','Powell','+375252345678','d.powell@gmail.com',0),(3,'Ziegamish','34567','Alaina','Беннетт','+375291111111','alaina@gmail.com',0);
/*!40000 ALTER TABLE `lecturer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lesson`
--

DROP TABLE IF EXISTS `lesson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lesson` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_course` int(11) NOT NULL,
  `id_data` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `CourseForLesson_idx` (`id_course`),
  KEY `data_for_lesson_idx` (`id_data`),
  CONSTRAINT `CourseForLesson` FOREIGN KEY (`id_course`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `data_for_lesson` FOREIGN KEY (`id_data`) REFERENCES `data_for_lesson` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lesson`
--

LOCK TABLES `lesson` WRITE;
/*!40000 ALTER TABLE `lesson` DISABLE KEYS */;
INSERT INTO `lesson` VALUES (1,1,7),(2,2,6),(3,2,5),(4,3,4),(5,4,3),(6,5,2),(7,5,1),(17,5,34),(21,1,38),(22,4,39),(23,4,40),(26,2,43);
/*!40000 ALTER TABLE `lesson` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passed_lesson`
--

DROP TABLE IF EXISTS `passed_lesson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `passed_lesson` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_student` int(11) NOT NULL,
  `id_lesson` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `LessonPassedForStudent_idx` (`id_lesson`),
  KEY `id_studentFK_idx` (`id_student`),
  CONSTRAINT `id_lessonFK` FOREIGN KEY (`id_lesson`) REFERENCES `lesson` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passed_lesson`
--

LOCK TABLES `passed_lesson` WRITE;
/*!40000 ALTER TABLE `passed_lesson` DISABLE KEYS */;
INSERT INTO `passed_lesson` VALUES (1,2,2),(2,2,3),(3,3,1),(4,7,4),(5,7,5);
/*!40000 ALTER TABLE `passed_lesson` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(25) NOT NULL,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `email` varchar(100) NOT NULL,
  `ban_status` tinyint(1) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'12345','12345','12345','12345','12345',0,'12345');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_course`
--

DROP TABLE IF EXISTS `student_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_of_student` int(11) NOT NULL,
  `id_of_course` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_studentFK_idx` (`id_of_student`),
  KEY `id_courceFK_idx` (`id_of_course`),
  CONSTRAINT `id_of_courseFK` FOREIGN KEY (`id_of_course`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idstudentFK` FOREIGN KEY (`id_of_student`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_course`
--

LOCK TABLES `student_course` WRITE;
/*!40000 ALTER TABLE `student_course` DISABLE KEYS */;
INSERT INTO `student_course` VALUES (1,3,1);
/*!40000 ALTER TABLE `student_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `ban_status` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'znexie','1234','admin','Anton','Shulga','+375257576982','znexie@gmail.com',0),(2,'kek','1234','student','Dima','Kekoff','+375241211414','kek@mail.ru',0),(3,'vadeek','1234','student','Vadim','Shikulo','+375332225588','vadimbylvar@gmail.com',0),(4,'hannibal','1234','lecturer','Hannibal','Lector','+375292882882','hlecturer@gmail.com',0),(5,'vasek','1234','lecturer','Vasya','Pupok','+375242425255','vasya@gmail.com',0),(6,'dimoniq','1234','lecturer','Dima','Perec','+375653353333','dimq@tut.by',1),(12,'mefody','*****','lecturer','Mefody','Dark','123-45-67','mefody@mail.ru',1),(30,'znexie2321','112','admin','wqwqq','qwwqwqwq','+12112121221w','zne@gmail.com',0);
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

-- Dump completed on 2016-05-01 22:32:01
