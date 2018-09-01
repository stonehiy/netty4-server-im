
CREATE TABLE `s_city` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `name` varchar(30) DEFAULT NULL COMMENT '城市名称',
  `fk_province_id` bigint(20) DEFAULT NULL COMMENT '所属省份ID  外键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='城市';


CREATE TABLE `im_friend` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `fk_firend_id` bigint(20) DEFAULT NULL COMMENT '朋友的ID    外键',
  `fk_user_id` bigint(20) DEFAULT NULL COMMENT '自己的ID    外键',
  `friend_nick` varchar(30) DEFAULT NULL COMMENT '备注昵称',
  `fk_friend_type_id` bigint(20) DEFAULT NULL COMMENT '好友类型    外键',
  `fk_friend_group_id` bigint(20) DEFAULT NULL COMMENT '所属分组ID    外键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='好友表';

CREATE TABLE `im_friend_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `name` varchar(10) DEFAULT NULL COMMENT '分组名字',
  `fk_user_id` bigint(10) DEFAULT NULL COMMENT '用户ID    外键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='好友分组表';

CREATE TABLE `im_friend_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `type_name` varchar(10) DEFAULT NULL COMMENT '类型名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='好友类型';

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

CREATE TABLE `im_message_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `name` varchar(20) DEFAULT NULL COMMENT '类型名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消息类型';

CREATE TABLE `s_nation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `name` varchar(30) DEFAULT NULL COMMENT '国家名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='国家';

CREATE TABLE `s_province` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `name` varchar(30) DEFAULT NULL COMMENT '国家名称',
  `fk_nation_id` bigint(20) DEFAULT NULL COMMENT '所属国家ID  外键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='省份';

CREATE TABLE `s_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `login_name` varchar(20) DEFAULT NULL COMMENT '登陆账号',
  `nickname` varchar(20) DEFAULT NULL COMMENT '昵称',
  `password` varchar(20) DEFAULT NULL COMMENT '密码',
  `signa_ture` varchar(150) DEFAULT NULL COMMENT '个性签名',
  `sex` int(1) DEFAULT 0 COMMENT '性别 0：未知 1：男 2：女',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `realname` varchar(30) DEFAULT NULL COMMENT '真实姓名',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号码',
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
   `deleted` bit DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

CREATE TABLE `im_friend_ship_policy` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `friend_ship_policy` varchar(10) DEFAULT NULL COMMENT '好友添加方式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='添加好友策略';

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

CREATE TABLE `im_group_msg` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `content` text COMMENT '消息内容',
  `fk_from_id` bigint(20) DEFAULT NULL COMMENT '发送者ID  外键',
  `from_name` varchar(30) DEFAULT NULL COMMENT '发送者昵称',
  `create_time` datetime DEFAULT NULL COMMENT '发送时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='群消息内容表';

CREATE TABLE `imr_group_msg_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `fk_to_id` bigint(20) DEFAULT NULL COMMENT '接收者ID  外键',
  `fk_group_msg_id` bigint(20) DEFAULT NULL COMMENT '群消息ID  外键',
  `state` int(1) DEFAULT 0 COMMENT '接收状态',
  `create_time` datetime DEFAULT NULL COMMENT '发送时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='群消息关联表';

CREATE TABLE `imr_group_private_msg` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `fk_from_id` bigint(20) DEFAULT NULL COMMENT '发送者ID  外键',
  `from_nick` varchar(30) DEFAULT NULL COMMENT '发送者昵称',
  `fk_to_id` bigint(20) DEFAULT NULL COMMENT '接收者ID  外键',
  `content` varchar(300) DEFAULT NULL COMMENT '消息内容',
  `state` int(1) DEFAULT 0 COMMENT '接收状态',
  `create_time` datetime DEFAULT NULL COMMENT '发送时间',
  `kf_group_id` bigint(20) DEFAULT NULL COMMENT '所属群ID  外键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='群内私聊消息关联表';

CREATE TABLE `imr_group_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `fk_user_id` bigint(20) DEFAULT NULL COMMENT '用户ID  外键',
  `fk_group_id` bigint(20) DEFAULT NULL COMMENT '群ID  外键',
  `create_time` datetime DEFAULT NULL COMMENT '发送时间',
  `group_nick` varchar(15) DEFAULT NULL COMMENT '群内用户昵称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='群用户关联表';

CREATE TABLE `im_user_state` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自增',
  `state_name` varchar(10) DEFAULT NULL COMMENT '状态名字',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户状态表';

