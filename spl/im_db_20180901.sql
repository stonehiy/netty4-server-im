-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 192.168.56.101    Database: im_db
-- ------------------------------------------------------
-- Server version	5.7.22

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
-- Table structure for table `im_friend`
--

DROP TABLE IF EXISTS `im_friend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `im_friend` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `fk_firend_id` bigint(20) DEFAULT NULL COMMENT '朋友的ID    外键',
  `fk_user_id` bigint(20) DEFAULT NULL COMMENT '自己的ID    外键',
  `friend_nick` varchar(30) DEFAULT NULL COMMENT '备注昵称',
  `fk_friend_type_id` bigint(20) DEFAULT NULL COMMENT '好友类型    外键',
  `fk_friend_group_id` bigint(20) DEFAULT NULL COMMENT '所属分组ID    外键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='好友表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `im_friend`
--

LOCK TABLES `im_friend` WRITE;
/*!40000 ALTER TABLE `im_friend` DISABLE KEYS */;
/*!40000 ALTER TABLE `im_friend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `im_friend_group`
--

DROP TABLE IF EXISTS `im_friend_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `im_friend_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `name` varchar(10) DEFAULT NULL COMMENT '分组名字',
  `fk_user_id` bigint(10) DEFAULT NULL COMMENT '用户ID    外键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='好友分组表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `im_friend_group`
--

LOCK TABLES `im_friend_group` WRITE;
/*!40000 ALTER TABLE `im_friend_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `im_friend_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `im_friend_ship_policy`
--

DROP TABLE IF EXISTS `im_friend_ship_policy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `im_friend_ship_policy` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `friend_ship_policy` varchar(10) DEFAULT NULL COMMENT '好友添加方式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='添加好友策略';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `im_friend_ship_policy`
--

LOCK TABLES `im_friend_ship_policy` WRITE;
/*!40000 ALTER TABLE `im_friend_ship_policy` DISABLE KEYS */;
/*!40000 ALTER TABLE `im_friend_ship_policy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `im_friend_type`
--

DROP TABLE IF EXISTS `im_friend_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `im_friend_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `type_name` varchar(10) DEFAULT NULL COMMENT '类型名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='好友类型';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `im_friend_type`
--

LOCK TABLES `im_friend_type` WRITE;
/*!40000 ALTER TABLE `im_friend_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `im_friend_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `im_group_msg`
--

DROP TABLE IF EXISTS `im_group_msg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `im_group_msg` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `content` text COMMENT '消息内容',
  `fk_from_id` bigint(20) DEFAULT NULL COMMENT '发送者ID  外键',
  `from_name` varchar(30) DEFAULT NULL COMMENT '发送者昵称',
  `create_time` datetime DEFAULT NULL COMMENT '发送时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='群消息内容表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `im_group_msg`
--

LOCK TABLES `im_group_msg` WRITE;
/*!40000 ALTER TABLE `im_group_msg` DISABLE KEYS */;
/*!40000 ALTER TABLE `im_group_msg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `im_message`
--

DROP TABLE IF EXISTS `im_message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `im_message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `content` text COMMENT '消息内容',
  `state` int(1) DEFAULT NULL COMMENT '接收状态',
  `send_time` datetime DEFAULT NULL COMMENT '发送时间',
  `fk_message_type_id` bigint(20) DEFAULT NULL COMMENT ' (消息类型ID)    外键',
  `fk_from_id` bigint(20) DEFAULT NULL COMMENT ' (发送者ID)指向用户表    外键',
  `fk_to_id` bigint(20) DEFAULT NULL COMMENT ' (接收者ID)指向用户表    外键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='聊天记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `im_message`
--

LOCK TABLES `im_message` WRITE;
/*!40000 ALTER TABLE `im_message` DISABLE KEYS */;
/*!40000 ALTER TABLE `im_message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `im_message_type`
--

DROP TABLE IF EXISTS `im_message_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `im_message_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `name` varchar(20) DEFAULT NULL COMMENT '类型名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消息类型';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `im_message_type`
--

LOCK TABLES `im_message_type` WRITE;
/*!40000 ALTER TABLE `im_message_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `im_message_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `im_user_group`
--

DROP TABLE IF EXISTS `im_user_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `im_user_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `name` varchar(30) DEFAULT NULL COMMENT '群名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `fk_admin_id` bigint(20) DEFAULT NULL COMMENT '群主ID（指向用户表）  外键',
  `icon` varchar(30) DEFAULT NULL COMMENT '群图标',
  `notice` varchar(300) DEFAULT NULL COMMENT '群公告',
  `intro` varchar(300) DEFAULT NULL COMMENT '群简介',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户群表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `im_user_group`
--

LOCK TABLES `im_user_group` WRITE;
/*!40000 ALTER TABLE `im_user_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `im_user_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `im_user_state`
--

DROP TABLE IF EXISTS `im_user_state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `im_user_state` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `state_name` varchar(10) DEFAULT NULL COMMENT '状态名字',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户状态表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `im_user_state`
--

LOCK TABLES `im_user_state` WRITE;
/*!40000 ALTER TABLE `im_user_state` DISABLE KEYS */;
/*!40000 ALTER TABLE `im_user_state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imr_group_msg_group`
--

DROP TABLE IF EXISTS `imr_group_msg_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `imr_group_msg_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `fk_to_id` bigint(20) DEFAULT NULL COMMENT '接收者ID  外键',
  `fk_group_msg_id` bigint(20) DEFAULT NULL COMMENT '群消息ID  外键',
  `state` int(1) DEFAULT '0' COMMENT '接收状态',
  `create_time` datetime DEFAULT NULL COMMENT '发送时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='群消息关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imr_group_msg_group`
--

LOCK TABLES `imr_group_msg_group` WRITE;
/*!40000 ALTER TABLE `imr_group_msg_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `imr_group_msg_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imr_group_private_msg`
--

DROP TABLE IF EXISTS `imr_group_private_msg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `imr_group_private_msg` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `fk_from_id` bigint(20) DEFAULT NULL COMMENT '发送者ID  外键',
  `from_nick` varchar(30) DEFAULT NULL COMMENT '发送者昵称',
  `fk_to_id` bigint(20) DEFAULT NULL COMMENT '接收者ID  外键',
  `content` varchar(300) DEFAULT NULL COMMENT '消息内容',
  `state` int(1) DEFAULT '0' COMMENT '接收状态',
  `create_time` datetime DEFAULT NULL COMMENT '发送时间',
  `kf_group_id` bigint(20) DEFAULT NULL COMMENT '所属群ID  外键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='群内私聊消息关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imr_group_private_msg`
--

LOCK TABLES `imr_group_private_msg` WRITE;
/*!40000 ALTER TABLE `imr_group_private_msg` DISABLE KEYS */;
/*!40000 ALTER TABLE `imr_group_private_msg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imr_group_user`
--

DROP TABLE IF EXISTS `imr_group_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `imr_group_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `fk_user_id` bigint(20) DEFAULT NULL COMMENT '用户ID  外键',
  `fk_group_id` bigint(20) DEFAULT NULL COMMENT '群ID  外键',
  `create_time` datetime DEFAULT NULL COMMENT '发送时间',
  `group_nick` varchar(15) DEFAULT NULL COMMENT '群内用户昵称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='群用户关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imr_group_user`
--

LOCK TABLES `imr_group_user` WRITE;
/*!40000 ALTER TABLE `imr_group_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `imr_group_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_city`
--

DROP TABLE IF EXISTS `s_city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_city` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `name` varchar(30) DEFAULT NULL COMMENT '城市名称',
  `fk_province_id` bigint(20) DEFAULT NULL COMMENT '所属省份ID  外键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='城市';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_city`
--

LOCK TABLES `s_city` WRITE;
/*!40000 ALTER TABLE `s_city` DISABLE KEYS */;
/*!40000 ALTER TABLE `s_city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_nation`
--

DROP TABLE IF EXISTS `s_nation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_nation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `name` varchar(30) DEFAULT NULL COMMENT '国家名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='国家';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_nation`
--

LOCK TABLES `s_nation` WRITE;
/*!40000 ALTER TABLE `s_nation` DISABLE KEYS */;
/*!40000 ALTER TABLE `s_nation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_province`
--

DROP TABLE IF EXISTS `s_province`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_province` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `name` varchar(30) DEFAULT NULL COMMENT '国家名称',
  `fk_nation_id` bigint(20) DEFAULT NULL COMMENT '所属国家ID  外键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='省份';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_province`
--

LOCK TABLES `s_province` WRITE;
/*!40000 ALTER TABLE `s_province` DISABLE KEYS */;
/*!40000 ALTER TABLE `s_province` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_user`
--

DROP TABLE IF EXISTS `s_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `login_name` varchar(20) DEFAULT NULL COMMENT '登陆账号',
  `nickname` varchar(20) DEFAULT NULL COMMENT '昵称',
  `password` varchar(20) DEFAULT NULL COMMENT '密码',
  `signa_ture` varchar(150) DEFAULT NULL COMMENT '个性签名',
  `sex` int(2) DEFAULT '0' COMMENT '性别 0：未知 1：男 2：女',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `realname` varchar(30) DEFAULT NULL COMMENT '真实姓名',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `intro` varchar(150) DEFAULT NULL COMMENT '个人简介',
  `head_portrait` varchar(100) DEFAULT NULL COMMENT '头像',
  `age` int(4) DEFAULT NULL COMMENT '年龄',
  `constellation` char(6) DEFAULT NULL COMMENT '星座',
  `blood_type` varchar(10) DEFAULT NULL COMMENT '血型',
  `fk_nation_id` bigint(20) DEFAULT NULL COMMENT '(国家ID)    外键',
  `fk_province_id` bigint(20) DEFAULT NULL COMMENT '（省份ID）    外键',
  `fk_city_id` bigint(20) DEFAULT NULL COMMENT '（城市ID）    外键',
  `fk_frd_policy_id` bigint(20) DEFAULT NULL COMMENT '（好友策略ID    外键',
  `fk_user_state_id` bigint(20) DEFAULT NULL COMMENT '(用户状态ID)    外键',
  `delete` bit(1) DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_user`
--

LOCK TABLES `s_user` WRITE;
/*!40000 ALTER TABLE `s_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `s_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-01 10:01:06
