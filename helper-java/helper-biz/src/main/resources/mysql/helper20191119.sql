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

 Date: 19/11/2019 17:02:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tt_menstruation
-- ----------------------------
DROP TABLE IF EXISTS `tt_menstruation`;
CREATE TABLE `tt_menstruation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `start_date` datetime DEFAULT NULL COMMENT '开始日期',
  `end_date` datetime DEFAULT NULL COMMENT '结束日期',
  `created_by` int(11) DEFAULT NULL COMMENT '创建人',
  `created_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for tt_message
-- ----------------------------
DROP TABLE IF EXISTS `tt_message`;
CREATE TABLE `tt_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mobile_number` char(11) COLLATE utf8mb4_bin NOT NULL COMMENT '手机号',
  `verification_code` char(6) COLLATE utf8mb4_bin NOT NULL COMMENT '6位验证码',
  `business_type` tinyint(1) DEFAULT NULL COMMENT '业务类型',
  `send_time` datetime DEFAULT NULL COMMENT '发送时间',
  `effective_duration` int(2) DEFAULT NULL,
  `send_ip` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `deleted_status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='短信发送';

-- ----------------------------
-- Table structure for tt_user
-- ----------------------------
DROP TABLE IF EXISTS `tt_user`;
CREATE TABLE `tt_user` (
  `id` int(11) NOT NULL,
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '姓名',
  `user_nick` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '昵称',
  `user_sex` tinyint(1) DEFAULT NULL COMMENT '1:男 2:女 3:未知',
  `address` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '住址',
  `id_card` char(18) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '身份证',
  `mobile_number` char(11) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '手机号',
  `login_password` char(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '登录密码',
  `user_birthday` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '生日',
  `user_type` tinyint(1) DEFAULT NULL COMMENT '用户类型1:注册用户 2:访客用户 3:后台开通',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `deleted_status` tinyint(1) DEFAULT NULL COMMENT '0:有效 1:删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户信息表';

-- ----------------------------
-- Table structure for tt_user_login
-- ----------------------------
DROP TABLE IF EXISTS `tt_user_login`;
CREATE TABLE `tt_user_login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `login_date` datetime DEFAULT NULL COMMENT '登录时间',
  `login_ip` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '登录IP',
  `device_num` varchar(30) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '设备号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户登录信息记录';

SET FOREIGN_KEY_CHECKS = 1;
