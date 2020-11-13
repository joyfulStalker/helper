/*
 Navicat Premium Data Transfer

 Source Server         : 我的云sql
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : 127.0.0.1:3306
 Source Schema         : helper

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 26/01/2020 17:51:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tt_lable
-- ----------------------------
DROP TABLE IF EXISTS `tt_lable`;
CREATE TABLE `tt_lable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `lable_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '标签名称',
  `business_id` int(11) NOT NULL COMMENT '业务id',
  `business_type` smallint(6) NOT NULL COMMENT '业务类型(1. 消息提醒 2.任务性格)',
  `create_by` int(11) DEFAULT NULL COMMENT '创建人id',
  `create_by_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建者姓名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新人id',
  `update_by_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '更新者姓名',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_delete` tinyint(1) DEFAULT '0' COMMENT '0:有效 1:删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='标签';

-- ----------------------------
-- Table structure for tt_menstruation
-- ----------------------------
DROP TABLE IF EXISTS `tt_menstruation`;
CREATE TABLE `tt_menstruation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `start_date` datetime DEFAULT NULL COMMENT '开始日期',
  `end_date` datetime DEFAULT NULL COMMENT '结束日期',
  `is_ache` tinyint(1) DEFAULT NULL COMMENT '是否疼痛(1:是0:否)',
  `create_by` int(11) DEFAULT NULL COMMENT '创建人id',
  `create_by_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建者姓名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新人id',
  `update_by_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '更新者姓名',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_delete` tinyint(1) DEFAULT '0' COMMENT '0:有效 1:删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户信息表';

-- ----------------------------
-- Records of tt_menstruation
-- ----------------------------
BEGIN;
INSERT INTO `tt_menstruation` VALUES (1, 1, '2019-07-20 11:56:18', '2019-07-24 11:56:18', 0, -1, '初始化', '2020-01-22 11:56:57', NULL, NULL, NULL, 0);
INSERT INTO `tt_menstruation` VALUES (2, 1, '2019-08-21 11:56:18', '2019-08-25 11:56:18', 0, -1, '初始化', '2020-01-22 11:56:57', NULL, NULL, NULL, 0);
INSERT INTO `tt_menstruation` VALUES (3, 1, '2019-09-27 11:56:18', '2019-10-01 11:56:18', 0, -1, '初始化', '2020-01-22 11:56:57', NULL, NULL, NULL, 0);
INSERT INTO `tt_menstruation` VALUES (4, 1, '2019-10-25 11:56:18', '2019-10-29 11:56:18', 0, -1, '初始化', '2020-01-22 11:56:57', NULL, NULL, NULL, 0);
INSERT INTO `tt_menstruation` VALUES (5, 1, '2019-11-22 11:56:18', '2019-11-26 11:56:18', 0, -1, '初始化', '2020-01-22 11:56:57', NULL, NULL, NULL, 0);
INSERT INTO `tt_menstruation` VALUES (6, 1, '2019-12-25 11:56:18', '2019-12-30 11:56:18', 0, -1, '初始化', '2020-01-22 11:56:57', NULL, NULL, NULL, 0);
INSERT INTO `tt_menstruation` VALUES (7, 1, '2020-01-21 11:56:18', '2020-01-26 15:34:32', 1, -1, '初始化', '2020-01-22 11:56:57', NULL, NULL, NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for tt_message
-- ----------------------------
DROP TABLE IF EXISTS `tt_message`;
CREATE TABLE `tt_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `requester` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '请求者',
  `request_type` tinyint(1) DEFAULT NULL COMMENT '请求类型',
  `verification_code` char(6) COLLATE utf8mb4_bin NOT NULL COMMENT '6位验证码',
  `business_type` tinyint(1) DEFAULT NULL COMMENT '业务类型',
  `send_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '发送时间',
  `effective_duration` int(2) DEFAULT NULL COMMENT '有效时长',
  `send_ip` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求者ip',
  `create_by` int(11) DEFAULT NULL COMMENT '创建人id',
  `create_by_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建者姓名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新人id',
  `update_by_name` varbinary(50) DEFAULT NULL COMMENT '更新者姓名',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_delete` tinyint(1) DEFAULT '0' COMMENT '0:有效 1:删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='短信发送';

-- ----------------------------
-- Records of tt_message
-- ----------------------------
BEGIN;
INSERT INTO `tt_message` VALUES (1, '2030503816@qq.com', 1, '885215', 1, '2020-01-16 18:38:52', 5, '0:0:0:0:0:0:0:1', -1, '系统管理', '2020-01-16 18:38:53', -1, 0xE7B3BBE7BB9FE7AEA1E79086, '2020-01-17 10:13:53', 1);
INSERT INTO `tt_message` VALUES (2, '2030503816@qq.com', 1, '029888', 1, '2020-01-17 10:13:52', 5, '0:0:0:0:0:0:0:1', -1, '系统管理', '2020-01-17 10:13:53', -1, 0xE7B3BBE7BB9FE7AEA1E79086, '2020-01-17 17:55:39', 1);
INSERT INTO `tt_message` VALUES (3, '2030503816@qq.com', 1, '387639', 1, '2020-01-17 17:55:38', 5, '0:0:0:0:0:0:0:1', -1, '系统管理', '2020-01-17 17:55:39', -1, 0xE7B3BBE7BB9FE7AEA1E79086, '2020-01-17 18:10:13', 1);
INSERT INTO `tt_message` VALUES (4, '2030503816@qq.com', 1, '448036', 1, '2020-01-17 18:10:13', 5, '0:0:0:0:0:0:0:1', -1, '系统管理', '2020-01-17 18:10:14', NULL, NULL, NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for tt_remind
-- ----------------------------
DROP TABLE IF EXISTS `tt_remind`;
CREATE TABLE `tt_remind` (
  `id` int(11) NOT NULL,
  `mobile_number` char(11) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '接收者手机号',
  `mail` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '接收者邮箱',
  `remind_date` datetime DEFAULT NULL COMMENT '提醒日期',
  `subject` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '提醒主题',
  `content` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '提醒内容',
  `is_anonymous` tinyint(1) DEFAULT NULL COMMENT '是否匿名',
  `create_by` int(11) DEFAULT NULL COMMENT '创建人id',
  `create_by_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建者姓名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新人id',
  `update_by_name` varbinary(50) DEFAULT NULL COMMENT '更新者姓名',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_delete` tinyint(1) DEFAULT '0' COMMENT '0:有效 1:删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='时间提醒';

-- ----------------------------
-- Table structure for tt_task
-- ----------------------------
DROP TABLE IF EXISTS `tt_task`;
CREATE TABLE `tt_task` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `job_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci DEFAULT NULL COMMENT '任务名',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci DEFAULT NULL COMMENT '任务描述',
  `cron_expression` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci DEFAULT NULL COMMENT 'cron表达式',
  `bean_class` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci DEFAULT NULL COMMENT '任务执行时调用哪个类的方法 包名+类名',
  `job_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci DEFAULT NULL COMMENT '任务状态',
  `job_group` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci DEFAULT NULL COMMENT '任务分组',
  `invoked_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci DEFAULT NULL COMMENT '被调用的url',
  `is_delete` tinyint(1) DEFAULT '0' COMMENT '1:是 0:否',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci COMMENT='定时任务';

-- ----------------------------
-- Records of tt_task
-- ----------------------------
BEGIN;
INSERT INTO `tt_task` VALUES (2, 'remind', '定时提醒', '0 1 0 * * ?	', 'helper.quartz.ExecuteJob', '1', 'group', 'http://www.baidu.com', 0, NULL, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for tt_user
-- ----------------------------
DROP TABLE IF EXISTS `tt_user`;
CREATE TABLE `tt_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '姓名',
  `user_nick` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '昵称',
  `user_sex` tinyint(1) DEFAULT NULL COMMENT '1:男 2:女 3:未知',
  `address` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '住址',
  `id_card` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '身份证',
  `mobile_number` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '手机号',
  `qq` char(11) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'qq',
  `mail` varchar(30) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '邮箱',
  `login_password` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '登录密码',
  `user_birthday` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '生日',
  `user_type` tinyint(1) DEFAULT NULL COMMENT '用户类型1:注册用户 2:访客用户 3:后台开通',
  `create_by` int(11) DEFAULT NULL COMMENT '创建人id',
  `create_by_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建者姓名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新人id',
  `update_by_name` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '更新者姓名',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_delete` tinyint(1) DEFAULT '0' COMMENT '0:有效 1:删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户信息表';

-- ----------------------------
-- Records of tt_user
-- ----------------------------
BEGIN;
INSERT INTO `tt_user` VALUES (1, NULL, '汤圆', NULL, NULL, NULL, NULL, NULL, '2030503816@qq.com', '10f935e22379d4547610781a6381a03d', NULL, 1, -1, '系统管理', '2020-01-05 18:22:08', NULL, NULL, NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for tt_user_login
-- ----------------------------
DROP TABLE IF EXISTS `tt_user_login`;
CREATE TABLE `tt_user_login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `login_date` datetime DEFAULT NULL COMMENT '登录时间',
  `login_ip` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '登录IP',
  `device_num` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '设备号',
  `create_by` int(11) DEFAULT NULL COMMENT '创建人id',
  `create_by_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建者姓名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新人id',
  `update_by_name` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '更新者姓名',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_delete` tinyint(1) DEFAULT '0' COMMENT '0:有效 1:删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户信息表';

-- ----------------------------
-- Records of tt_user_login
-- ----------------------------
BEGIN;
INSERT INTO `tt_user_login` VALUES (1, 6, '2019-12-10 14:15:45', '127.0.0.1', NULL, -1, '系统管理', '2019-12-10 14:15:45', NULL, NULL, NULL, 0);
INSERT INTO `tt_user_login` VALUES (2, 6, '2019-12-10 14:31:50', '127.0.0.1', NULL, -1, '系统管理', '2019-12-10 14:31:50', NULL, NULL, NULL, 0);
INSERT INTO `tt_user_login` VALUES (3, 6, '2019-12-10 15:28:41', '127.0.0.1', NULL, -1, '系统管理', '2019-12-10 15:28:41', NULL, NULL, NULL, 0);
INSERT INTO `tt_user_login` VALUES (4, 6, '2019-12-10 15:29:19', '127.0.0.1', NULL, -1, '系统管理', '2019-12-10 15:29:19', NULL, NULL, NULL, 0);
INSERT INTO `tt_user_login` VALUES (5, 7, '2020-01-05 18:22:25', '127.0.0.1', NULL, -1, '系统管理', '2020-01-05 18:22:25', NULL, NULL, NULL, 0);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
