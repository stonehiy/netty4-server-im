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
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `cityName` varchar(30) DEFAULT NULL COMMENT '城市名称',
  `provinceId` bigint(20) DEFAULT NULL COMMENT '所属省份ID  外键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='城市';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friend`
--

DROP TABLE IF EXISTS `friend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `friend` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `firendId` bigint(20) DEFAULT NULL COMMENT '朋友的ID    外键',
  `userId` bigint(20) DEFAULT NULL COMMENT '自己的ID    外键',
  `friendNickName` varchar(30) DEFAULT NULL COMMENT '备注昵称',
  `friendTypeId` bigint(20) DEFAULT NULL COMMENT '好友类型    外键',
  `friendGroupsId` bigint(20) DEFAULT NULL COMMENT '所属分组ID    外键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='好友表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friend`
--

LOCK TABLES `friend` WRITE;
/*!40000 ALTER TABLE `friend` DISABLE KEYS */;
/*!40000 ALTER TABLE `friend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friendGroup`
--

DROP TABLE IF EXISTS `friendGroup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `friendGroup` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `friendGroupName` varchar(10) DEFAULT NULL COMMENT '分组名字',
  `userId` bigint(10) DEFAULT NULL COMMENT '用户ID    外键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='好友分组表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friendGroup`
--

LOCK TABLES `friendGroup` WRITE;
/*!40000 ALTER TABLE `friendGroup` DISABLE KEYS */;
/*!40000 ALTER TABLE `friendGroup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friendType`
--

DROP TABLE IF EXISTS `friendType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `friendType` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `friendTypeName` varchar(10) DEFAULT NULL COMMENT '类型名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='好友类型';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friendType`
--

LOCK TABLES `friendType` WRITE;
/*!40000 ALTER TABLE `friendType` DISABLE KEYS */;
/*!40000 ALTER TABLE `friendType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `postMessage` text COMMENT '消息内容',
  `status` bit(1) DEFAULT NULL COMMENT '接收状态',
  `sendTime` datetime DEFAULT NULL COMMENT '发送时间',
  `messageTypeId` bigint(20) DEFAULT NULL COMMENT ' (消息类型ID)    外键',
  `fromUserId` bigint(20) DEFAULT NULL COMMENT ' (发送者ID)指向用户表    外键',
  `toUserId` bigint(20) DEFAULT NULL COMMENT ' (接收者ID)指向用户表    外键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='聊天记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `messageType`
--

DROP TABLE IF EXISTS `messageType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `messageType` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `messageTypeName` varchar(20) DEFAULT NULL COMMENT '类型名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消息类型';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messageType`
--

LOCK TABLES `messageType` WRITE;
/*!40000 ALTER TABLE `messageType` DISABLE KEYS */;
/*!40000 ALTER TABLE `messageType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nation`
--

DROP TABLE IF EXISTS `nation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `nationName` varchar(30) DEFAULT NULL COMMENT '国家名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='国家';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nation`
--

LOCK TABLES `nation` WRITE;
/*!40000 ALTER TABLE `nation` DISABLE KEYS */;
/*!40000 ALTER TABLE `nation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `province`
--

DROP TABLE IF EXISTS `province`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `province` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `provinceName` varchar(30) DEFAULT NULL COMMENT '国家名称',
  `nationId` bigint(20) DEFAULT NULL COMMENT '所属国家ID  外键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='省份';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `province`
--

LOCK TABLES `province` WRITE;
/*!40000 ALTER TABLE `province` DISABLE KEYS */;
/*!40000 ALTER TABLE `province` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `loginId` varchar(20) DEFAULT NULL COMMENT '登陆账号',
  `nickName` varchar(20) DEFAULT NULL COMMENT '昵称',
  `passWord` varchar(20) DEFAULT NULL COMMENT '密码',
  `signaTure` varchar(150) DEFAULT NULL COMMENT '个性签名',
  `sex` bit(1) DEFAULT b'0' COMMENT '性别 0：未知 1：男 2：女',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `realName` varchar(30) DEFAULT NULL COMMENT '真实姓名',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `intro` varchar(150) DEFAULT NULL COMMENT '个人简介',
  `headPortrait` varchar(100) DEFAULT NULL COMMENT '头像',
  `age` int(4) DEFAULT NULL COMMENT '年龄',
  `constellation` char(6) DEFAULT NULL COMMENT '星座',
  `bloodType` varchar(10) DEFAULT NULL COMMENT '血型',
  `nationId` bigint(20) DEFAULT NULL COMMENT '(国家ID)    外键',
  `provinceId` bigint(20) DEFAULT NULL COMMENT '（省份ID）    外键',
  `cityId` bigint(20) DEFAULT NULL COMMENT '（城市ID）    外键',
  `friendshipPolicyId` bigint(20) DEFAULT NULL COMMENT '（好友策略ID    外键',
  `userStateId` bigint(20) DEFAULT NULL COMMENT '(用户状态ID)    外键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userFriendshipPolicy`
--

DROP TABLE IF EXISTS `userFriendshipPolicy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userFriendshipPolicy` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `friendshipPolicy` varchar(10) DEFAULT NULL COMMENT '好友添加方式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='添加好友策略';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userFriendshipPolicy`
--

LOCK TABLES `userFriendshipPolicy` WRITE;
/*!40000 ALTER TABLE `userFriendshipPolicy` DISABLE KEYS */;
/*!40000 ALTER TABLE `userFriendshipPolicy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userGroup`
--

DROP TABLE IF EXISTS `userGroup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userGroup` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `userGroupName` varchar(30) DEFAULT NULL COMMENT '群名称',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `adminId` bigint(20) DEFAULT NULL COMMENT '群主ID（指向用户表）  外键',
  `icon` varchar(30) DEFAULT NULL COMMENT '群图标',
  `notice` varchar(300) DEFAULT NULL COMMENT '群公告',
  `intro` varchar(300) DEFAULT NULL COMMENT '群简介',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户群表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userGroup`
--

LOCK TABLES `userGroup` WRITE;
/*!40000 ALTER TABLE `userGroup` DISABLE KEYS */;
/*!40000 ALTER TABLE `userGroup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userGroupMsgContent`
--

DROP TABLE IF EXISTS `userGroupMsgContent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userGroupMsgContent` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `content` text COMMENT '消息内容',
  `fromId` bigint(20) DEFAULT NULL COMMENT '发送者ID  外键',
  `fromName` varchar(30) DEFAULT NULL COMMENT '发送者昵称',
  `createTime` datetime DEFAULT NULL COMMENT '发送时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='群消息内容表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userGroupMsgContent`
--

LOCK TABLES `userGroupMsgContent` WRITE;
/*!40000 ALTER TABLE `userGroupMsgContent` DISABLE KEYS */;
/*!40000 ALTER TABLE `userGroupMsgContent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userGroupMsgToUser`
--

DROP TABLE IF EXISTS `userGroupMsgToUser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userGroupMsgToUser` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `userId` bigint(20) DEFAULT NULL COMMENT '接收者ID  外键',
  `groupMessageId` bigint(20) DEFAULT NULL COMMENT '群消息ID  外键',
  `state` bit(1) DEFAULT NULL COMMENT '接收状态',
  `createTime` datetime DEFAULT NULL COMMENT '发送时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='群消息关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userGroupMsgToUser`
--

LOCK TABLES `userGroupMsgToUser` WRITE;
/*!40000 ALTER TABLE `userGroupMsgToUser` DISABLE KEYS */;
/*!40000 ALTER TABLE `userGroupMsgToUser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userGroupMsgUserToUser`
--

DROP TABLE IF EXISTS `userGroupMsgUserToUser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userGroupMsgUserToUser` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `fromUserId` bigint(20) DEFAULT NULL COMMENT '发送者ID  外键',
  `fromUserName` varchar(30) DEFAULT NULL COMMENT '发送者昵称',
  `toUserId` bigint(20) DEFAULT NULL COMMENT '接收者ID  外键',
  `msgContent` varchar(300) DEFAULT NULL COMMENT '消息内容',
  `state` bit(1) DEFAULT NULL COMMENT '接收状态',
  `createTime` datetime DEFAULT NULL COMMENT '发送时间',
  `userGroupId` bigint(20) DEFAULT NULL COMMENT '所属群ID  外键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='群内私聊消息关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userGroupMsgUserToUser`
--

LOCK TABLES `userGroupMsgUserToUser` WRITE;
/*!40000 ALTER TABLE `userGroupMsgUserToUser` DISABLE KEYS */;
/*!40000 ALTER TABLE `userGroupMsgUserToUser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userGroupToUser`
--

DROP TABLE IF EXISTS `userGroupToUser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userGroupToUser` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `userId` bigint(20) DEFAULT NULL COMMENT '用户ID  外键',
  `groupId` bigint(20) DEFAULT NULL COMMENT '群ID  外键',
  `createTime` datetime DEFAULT NULL COMMENT '发送时间',
  `groupNick` varchar(15) DEFAULT NULL COMMENT '群内用户昵称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='群用户关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userGroupToUser`
--

LOCK TABLES `userGroupToUser` WRITE;
/*!40000 ALTER TABLE `userGroupToUser` DISABLE KEYS */;
/*!40000 ALTER TABLE `userGroupToUser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userState`
--

DROP TABLE IF EXISTS `userState`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userState` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `userStateName` varchar(10) DEFAULT NULL COMMENT '状态名字',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户状态表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userState`
--

LOCK TABLES `userState` WRITE;
/*!40000 ALTER TABLE `userState` DISABLE KEYS */;
/*!40000 ALTER TABLE `userState` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-31 19:52:24