CREATE DATABASE  IF NOT EXISTS `im_db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `im_db`;
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
-- Table structure for table `City`
--

DROP TABLE IF EXISTS `City`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `City` (
  `C_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `C_Name` varchar(30) DEFAULT NULL COMMENT '城市名称',
  `C_ProvinceID` bigint(20) DEFAULT NULL COMMENT '所属省份ID  外键',
  PRIMARY KEY (`C_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='城市';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `City`
--

LOCK TABLES `City` WRITE;
/*!40000 ALTER TABLE `City` DISABLE KEYS */;
/*!40000 ALTER TABLE `City` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `FriendGroups`
--

DROP TABLE IF EXISTS `FriendGroups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `FriendGroups` (
  `FG_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `FG_Name` varchar(10) DEFAULT NULL COMMENT '分组名字',
  `FG_UserID` bigint(10) DEFAULT NULL COMMENT '用户ID    外键',
  PRIMARY KEY (`FG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='好友分组表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FriendGroups`
--

LOCK TABLES `FriendGroups` WRITE;
/*!40000 ALTER TABLE `FriendGroups` DISABLE KEYS */;
/*!40000 ALTER TABLE `FriendGroups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `FriendType`
--

DROP TABLE IF EXISTS `FriendType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `FriendType` (
  `FT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `FT_Name` varchar(10) DEFAULT NULL COMMENT '类型名称',
  PRIMARY KEY (`FT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='好友类型';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FriendType`
--

LOCK TABLES `FriendType` WRITE;
/*!40000 ALTER TABLE `FriendType` DISABLE KEYS */;
/*!40000 ALTER TABLE `FriendType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Friends`
--

DROP TABLE IF EXISTS `Friends`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Friends` (
  `F_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `F_FirendID` bigint(20) DEFAULT NULL COMMENT '朋友的ID    外键',
  `F_UserID` bigint(20) DEFAULT NULL COMMENT '自己的ID    外键',
  `F_Name` varchar(30) DEFAULT NULL COMMENT '备注昵称',
  `F_FriendTypeID` bigint(20) DEFAULT NULL COMMENT '好友类型    外键',
  `F_FriendGroupsID` bigint(20) DEFAULT NULL COMMENT '所属分组ID    外键',
  PRIMARY KEY (`F_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='好友表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Friends`
--

LOCK TABLES `Friends` WRITE;
/*!40000 ALTER TABLE `Friends` DISABLE KEYS */;
/*!40000 ALTER TABLE `Friends` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Messages`
--

DROP TABLE IF EXISTS `Messages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Messages` (
  `M_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `M_PostMessages` text COMMENT '消息内容',
  `M_Status` bit(1) DEFAULT NULL COMMENT '接收状态',
  `M_Time` datetime DEFAULT NULL COMMENT '发送时间',
  `M_MessagesTypeID` bigint(20) DEFAULT NULL COMMENT ' (消息类型ID)    外键',
  `M_FromUserID` bigint(20) DEFAULT NULL COMMENT ' (发送者ID)指向用户表    外键',
  `M_ToUserID` bigint(20) DEFAULT NULL COMMENT ' (接收者ID)指向用户表    外键',
  PRIMARY KEY (`M_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='聊天记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Messages`
--

LOCK TABLES `Messages` WRITE;
/*!40000 ALTER TABLE `Messages` DISABLE KEYS */;
/*!40000 ALTER TABLE `Messages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MessagesType`
--

DROP TABLE IF EXISTS `MessagesType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MessagesType` (
  `MT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `MT_Name` varchar(20) DEFAULT NULL COMMENT '类型名称',
  PRIMARY KEY (`MT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消息类型';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MessagesType`
--

LOCK TABLES `MessagesType` WRITE;
/*!40000 ALTER TABLE `MessagesType` DISABLE KEYS */;
/*!40000 ALTER TABLE `MessagesType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Nation`
--

DROP TABLE IF EXISTS `Nation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Nation` (
  `N_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `N_Name` varchar(30) DEFAULT NULL COMMENT '国家名称',
  PRIMARY KEY (`N_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='国家';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Nation`
--

LOCK TABLES `Nation` WRITE;
/*!40000 ALTER TABLE `Nation` DISABLE KEYS */;
/*!40000 ALTER TABLE `Nation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Province`
--

DROP TABLE IF EXISTS `Province`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Province` (
  `P_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `P_Name` varchar(30) DEFAULT NULL COMMENT '国家名称',
  `P_NationID` bigint(20) DEFAULT NULL COMMENT '所属国家ID  外键',
  PRIMARY KEY (`P_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='省份';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Province`
--

LOCK TABLES `Province` WRITE;
/*!40000 ALTER TABLE `Province` DISABLE KEYS */;
/*!40000 ALTER TABLE `Province` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `U_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `U_LoginID` varchar(20) DEFAULT NULL COMMENT '登陆账号',
  `U_NickName` varchar(20) DEFAULT NULL COMMENT '昵称',
  `U_PassWord` varchar(20) DEFAULT NULL COMMENT '密码',
  `U_SignaTure` varchar(150) DEFAULT NULL COMMENT '个性签名',
  `U_Sex` bit(1) DEFAULT b'0' COMMENT '性别 0：未知 1：男 2：女',
  `U_Birthday` datetime DEFAULT NULL COMMENT '生日',
  `U_Name` varchar(30) DEFAULT NULL COMMENT '真实姓名',
  `U_Email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `U_Intro` varchar(150) DEFAULT NULL COMMENT '个人简介',
  `U_HeadPortrait` varchar(100) DEFAULT NULL COMMENT '头像',
  `U_Age` int(4) DEFAULT NULL COMMENT '年龄',
  `U_Constellation` char(6) DEFAULT NULL COMMENT '星座',
  `U_BloodType` varchar(10) DEFAULT NULL COMMENT '血型',
  `U_NationID` bigint(20) DEFAULT NULL COMMENT '(国家ID)    外键',
  `U_ProvinceID` bigint(20) DEFAULT NULL COMMENT '（省份ID）    外键',
  `U_CityID` bigint(20) DEFAULT NULL COMMENT '（城市ID）    外键',
  `U_FriendshipPolicyID` bigint(20) DEFAULT NULL COMMENT '（好友策略ID    外键',
  `U_UserStateID` bigint(20) DEFAULT NULL COMMENT '(用户状态ID)    外键',
  PRIMARY KEY (`U_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `UserState`
--

DROP TABLE IF EXISTS `UserState`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `UserState` (
  `US_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `US_Name` varchar(10) DEFAULT NULL COMMENT '状态名字',
  PRIMARY KEY (`US_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户状态表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `UserState`
--

LOCK TABLES `UserState` WRITE;
/*!40000 ALTER TABLE `UserState` DISABLE KEYS */;
/*!40000 ALTER TABLE `UserState` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User_FriendshipPolicy`
--

DROP TABLE IF EXISTS `User_FriendshipPolicy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User_FriendshipPolicy` (
  `U_FP_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `U_FriendshipPolicy` varchar(10) DEFAULT NULL COMMENT '好友添加方式',
  PRIMARY KEY (`U_FP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='添加好友策略';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User_FriendshipPolicy`
--

LOCK TABLES `User_FriendshipPolicy` WRITE;
/*!40000 ALTER TABLE `User_FriendshipPolicy` DISABLE KEYS */;
/*!40000 ALTER TABLE `User_FriendshipPolicy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User_Groups`
--

DROP TABLE IF EXISTS `User_Groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User_Groups` (
  `UG_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `UG_Name` varchar(30) DEFAULT NULL COMMENT '群名称',
  `UG_CreateTime` datetime DEFAULT NULL COMMENT '创建时间',
  `UG_AdminID` bigint(20) DEFAULT NULL COMMENT '群主ID（指向用户表）  外键',
  `UG_ICon` varchar(30) DEFAULT NULL COMMENT '群图标',
  `UG_Notice` varchar(300) DEFAULT NULL COMMENT '群公告',
  `UG_Intro` varchar(300) DEFAULT NULL COMMENT '群简介',
  PRIMARY KEY (`UG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户群表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User_Groups`
--

LOCK TABLES `User_Groups` WRITE;
/*!40000 ALTER TABLE `User_Groups` DISABLE KEYS */;
/*!40000 ALTER TABLE `User_Groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User_GroupsMSGContent`
--

DROP TABLE IF EXISTS `User_GroupsMSGContent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User_GroupsMSGContent` (
  `GM_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `GM_Content` text COMMENT '消息内容',
  `GM_FromID` bigint(20) DEFAULT NULL COMMENT '发送者ID  外键',
  `GM_FromUName` varchar(30) DEFAULT NULL COMMENT '发送者昵称',
  `GM_CreateTime` datetime DEFAULT NULL COMMENT '发送时间',
  PRIMARY KEY (`GM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='群消息内容表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User_GroupsMSGContent`
--

LOCK TABLES `User_GroupsMSGContent` WRITE;
/*!40000 ALTER TABLE `User_GroupsMSGContent` DISABLE KEYS */;
/*!40000 ALTER TABLE `User_GroupsMSGContent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User_GroupsMSGToUser`
--

DROP TABLE IF EXISTS `User_GroupsMSGToUser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User_GroupsMSGToUser` (
  `GM_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `GM_UserID` bigint(20) DEFAULT NULL COMMENT '接收者ID  外键',
  `GM_GroupMessageID` bigint(20) DEFAULT NULL COMMENT '群消息ID  外键',
  `GM_State` bit(1) DEFAULT NULL COMMENT '接收状态',
  `GM_CreateTime` datetime DEFAULT NULL COMMENT '发送时间',
  PRIMARY KEY (`GM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='群消息关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User_GroupsMSGToUser`
--

LOCK TABLES `User_GroupsMSGToUser` WRITE;
/*!40000 ALTER TABLE `User_GroupsMSGToUser` DISABLE KEYS */;
/*!40000 ALTER TABLE `User_GroupsMSGToUser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User_GroupsMSGUserToUser`
--

DROP TABLE IF EXISTS `User_GroupsMSGUserToUser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User_GroupsMSGUserToUser` (
  `GM_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `GM_FromUserID` bigint(20) DEFAULT NULL COMMENT '发送者ID  外键',
  `GM_FromUserName` varchar(30) DEFAULT NULL COMMENT '发送者昵称',
  `GM_ToUserID` bigint(20) DEFAULT NULL COMMENT '接收者ID  外键',
  `GM_MSGContent` varchar(300) DEFAULT NULL COMMENT '消息内容',
  `GM_State` bit(1) DEFAULT NULL COMMENT '接收状态',
  `GM_CreateTime` datetime DEFAULT NULL COMMENT '发送时间',
  `GM_UserGroupID` bigint(20) DEFAULT NULL COMMENT '所属群ID  外键',
  PRIMARY KEY (`GM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='群内私聊消息关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User_GroupsMSGUserToUser`
--

LOCK TABLES `User_GroupsMSGUserToUser` WRITE;
/*!40000 ALTER TABLE `User_GroupsMSGUserToUser` DISABLE KEYS */;
/*!40000 ALTER TABLE `User_GroupsMSGUserToUser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User_GroupsToUser`
--

DROP TABLE IF EXISTS `User_GroupsToUser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User_GroupsToUser` (
  `UG_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `UG_UserID` bigint(20) DEFAULT NULL COMMENT '用户ID  外键',
  `UG_GroupID` bigint(20) DEFAULT NULL COMMENT '群ID  外键',
  `UG_CreateTime` datetime DEFAULT NULL COMMENT '发送时间',
  `UG_GroupNick` varchar(15) DEFAULT NULL COMMENT '群内用户昵称',
  PRIMARY KEY (`UG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='群用户关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User_GroupsToUser`
--

LOCK TABLES `User_GroupsToUser` WRITE;
/*!40000 ALTER TABLE `User_GroupsToUser` DISABLE KEYS */;
/*!40000 ALTER TABLE `User_GroupsToUser` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-31 13:34:20
