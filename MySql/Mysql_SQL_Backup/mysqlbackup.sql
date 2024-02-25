-- MySQL dump 10.13  Distrib 8.0.35, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mysqltest
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `tb_dept`
--

DROP TABLE IF EXISTS `tb_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_dept` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(10) NOT NULL COMMENT '部门名称',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='部门表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_dept`
--

LOCK TABLES `tb_dept` WRITE;
/*!40000 ALTER TABLE `tb_dept` DISABLE KEYS */;
INSERT INTO `tb_dept` VALUES (1,'学工部','2024-01-04 23:24:41','2024-01-04 23:24:41'),(2,'教研部','2024-01-04 23:24:41','2024-01-04 23:24:41'),(3,'咨询部','2024-01-04 23:24:41','2024-01-04 23:24:41'),(4,'就业部','2024-01-04 23:24:41','2024-01-04 23:24:41'),(5,'人事部','2024-01-04 23:24:41','2024-01-04 23:24:41');
/*!40000 ALTER TABLE `tb_dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_emp`
--
DROP TABLE IF EXISTS `tb_emp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_emp` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(32) DEFAULT '123456' COMMENT '密码',
  `name` varchar(10) NOT NULL COMMENT '姓名',
  `gender` tinyint unsigned NOT NULL COMMENT '性别, 说明: 1 男, 2 女',
  `image` varchar(300) DEFAULT NULL COMMENT '图像',
  `job` tinyint unsigned DEFAULT NULL COMMENT '职位, 说明: 1 班主任,2 讲师, 3 学工主管, 4 教研主管',
  `entrydate` date DEFAULT NULL COMMENT '入职时间',
  `dept_id` int unsigned DEFAULT NULL COMMENT '部门ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  KEY `tb_emp_tb_dept_id_fk` (`dept_id`),
  CONSTRAINT `tb_emp_tb_dept_id_fk` FOREIGN KEY (`dept_id`) REFERENCES `tb_dept` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='员工表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_emp`
--

LOCK TABLES `tb_emp` WRITE;
/*!40000 ALTER TABLE `tb_emp` DISABLE KEYS */;
INSERT INTO `tb_emp` VALUES (1,'jinyong','123456','金庸',1,'1.jpg',4,'2000-01-01',2,'2024-01-04 23:24:17','2024-01-04 23:24:17'),(2,'zhangwuji','123456','张无忌',1,'2.jpg',2,'2015-01-01',2,'2024-01-04 23:24:17','2024-01-04 23:24:17'),(3,'yangxiao','123456','杨逍',1,'3.jpg',2,'2008-05-01',2,'2024-01-04 23:24:17','2024-01-04 23:24:17'),(4,'weiyixiao','123456','韦一笑',1,'4.jpg',2,'2007-01-01',2,'2024-01-04 23:24:17','2024-01-04 23:24:17'),(5,'changyuchun','123456','常遇春',1,'5.jpg',2,'2012-12-05',2,'2024-01-04 23:24:17','2024-01-04 23:24:17'),(6,'xiaozhao','123456','小昭',2,'6.jpg',3,'2013-09-05',1,'2024-01-04 23:24:17','2024-01-04 23:24:17'),(7,'jixiaofu','123456','纪晓芙',2,'7.jpg',1,'2005-08-01',1,'2024-01-04 23:24:17','2024-01-04 23:24:17'),(8,'zhouzhiruo','123456','周芷若',2,'8.jpg',1,'2014-11-09',1,'2024-01-04 23:24:17','2024-01-04 23:24:17'),(9,'dingminjun','123456','丁敏君',2,'9.jpg',1,'2011-03-11',1,'2024-01-04 23:24:17','2024-01-04 23:24:17'),(10,'zhaomin','123456','赵敏',2,'10.jpg',1,'2013-09-05',1,'2024-01-04 23:24:17','2024-01-04 23:24:17'),(11,'luzhangke','123456','鹿杖客',1,'11.jpg',1,'2007-02-01',1,'2024-01-04 23:24:17','2024-01-04 23:24:17'),(12,'hebiweng','123456','鹤笔翁',1,'12.jpg',1,'2008-08-18',1,'2024-01-04 23:24:17','2024-01-04 23:24:17'),(13,'fangdongbai','123456','方东白',1,'13.jpg',2,'2012-11-01',2,'2024-01-04 23:24:17','2024-01-04 23:24:17'),(14,'zhangsanfeng','123456','张三丰',1,'14.jpg',2,'2002-08-01',2,'2024-01-04 23:24:17','2024-01-04 23:24:17'),(15,'yulianzhou','123456','俞莲舟',1,'15.jpg',2,'2011-05-01',2,'2024-01-04 23:24:17','2024-01-04 23:24:17'),(16,'songyuanqiao','123456','宋远桥',1,'16.jpg',2,'2010-01-01',2,'2024-01-04 23:24:17','2024-01-04 23:24:17'),(17,'chenyouliang','123456','陈友谅',1,'17.jpg',NULL,'2015-03-21',NULL,'2024-01-04 23:24:17','2024-01-04 23:24:17');
/*!40000 ALTER TABLE `tb_emp` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
-- Dump completed on 2024-01-05  0:05:24
