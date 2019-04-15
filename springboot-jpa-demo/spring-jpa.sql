/*
Navicat MySQL Data Transfer

Source Server         : 172.27.103.24
Source Server Version : 80013
Source Host           : 172.27.103.24:3306
Source Database       : spring-jpa

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2019-04-15 16:28:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` int(10) NOT NULL COMMENT '无意义自增主键',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '创建时间',
  `is_valid` int(1) NOT NULL DEFAULT '1' COMMENT '是否启用，1:启用     0:不启用',
  `version` int(10) NOT NULL COMMENT '版本号',
  `address_detail` varchar(255) NOT NULL COMMENT '具体地址',
  `city` varchar(32) NOT NULL COMMENT '城市',
  `country` varchar(16) NOT NULL COMMENT '国家',
  `label` varchar(16) NOT NULL COMMENT '地址标签（家、公司）',
  `province` varchar(32) NOT NULL COMMENT '省份',
  `web_user_id` int(10) DEFAULT NULL COMMENT '无意义自增主键',
  PRIMARY KEY (`id`),
  KEY `FKmckey77nv904vq2fo1dw025iv` (`web_user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('4', '2019-04-14 22:00:12', '2019-04-14 22:00:13', '1', '0', '11', '天津', '中国', '单位', '天津', '2');
INSERT INTO `address` VALUES ('5', '2019-04-14 22:02:53', '2019-04-14 22:02:53', '1', '0', '天津市红桥区湘潭道1号', '天津市', '中国', '单位2', '天津市', '2');

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('6');
INSERT INTO `hibernate_sequence` VALUES ('6');
INSERT INTO `hibernate_sequence` VALUES ('6');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `address_id` int(11) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '4', '20', '兰兰');

-- ----------------------------
-- Table structure for web_user
-- ----------------------------
DROP TABLE IF EXISTS `web_user`;
CREATE TABLE `web_user` (
  `id` int(10) NOT NULL COMMENT '无意义自增主键',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '创建时间',
  `is_valid` int(1) NOT NULL DEFAULT '1' COMMENT '是否启用，1:启用     0:不启用',
  `version` int(10) NOT NULL COMMENT '版本号',
  `email` varchar(64) NOT NULL COMMENT '邮箱',
  `password` varchar(32) NOT NULL DEFAULT '000000' COMMENT '密码',
  `phone_no` varchar(11) NOT NULL COMMENT '电话号码',
  `real_name` varchar(32) NOT NULL COMMENT '真实姓名',
  `user_name` varchar(255) NOT NULL COMMENT '用户名',
  `nick_name` varchar(32) DEFAULT NULL COMMENT '昵称',
  `wx_id` varchar(32) DEFAULT NULL COMMENT '微信号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `phone_no` (`phone_no`),
  UNIQUE KEY `user_name` (`user_name`),
  UNIQUE KEY `wx_id` (`wx_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_user
-- ----------------------------
INSERT INTO `web_user` VALUES ('1', '2019-04-12 02:42:02', null, '1', '2', 'zhangsan@troila.com', '111111', '13602163369', '张三', 'zhangsan', null, null);
INSERT INTO `web_user` VALUES ('2', '2019-04-12 02:45:04', '2019-04-12 02:45:04', '1', '2', 'lilei@troila.com', '111111', '13602163368', '李雷', 'lilei', null, null);
INSERT INTO `web_user` VALUES ('3', '2019-04-12 02:46:09', '2019-04-12 02:46:09', '1', '2', 'hanmeimei@troila.com', '111111', '12345678956', '韩梅梅', '韩梅梅', null, null);

-- ----------------------------
-- View structure for user_address_view
-- ----------------------------
DROP VIEW IF EXISTS `user_address_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `user_address_view` AS select `user`.`id` AS `id`,`user`.`age` AS `age`,`user`.`name` AS `name`,`user`.`address_id` AS `address_id`,`address`.`label` AS `label`,`address`.`city` AS `city` from (`user` join `address`) where (`user`.`address_id` = `address`.`id`) ;
