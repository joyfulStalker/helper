/*
 Navicat Premium Data Transfer

 Source Server         : helper云库
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : helper

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 12/07/2020 20:40:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tt_lable
-- ----------------------------
DROP TABLE IF EXISTS `tt_lable`;
CREATE TABLE `tt_lable`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `lable_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '标签名称',
  `business_id` int(11) NOT NULL COMMENT '业务id',
  `business_type` smallint(6) NOT NULL COMMENT '业务类型(1. 消息提醒 2.任务性格)',
  `create_by` int(11) NULL DEFAULT NULL COMMENT '创建人id',
  `create_by_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建者姓名',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` int(11) NULL DEFAULT NULL COMMENT '更新人id',
  `update_by_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新者姓名',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_delete` tinyint(1) NULL DEFAULT 0 COMMENT '0:有效 1:删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '标签' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tt_menstruation
-- ----------------------------
DROP TABLE IF EXISTS `tt_menstruation`;
CREATE TABLE `tt_menstruation`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `start_date` datetime(0) NULL DEFAULT NULL COMMENT '开始日期',
  `end_date` datetime(0) NULL DEFAULT NULL COMMENT '结束日期',
  `is_ache` tinyint(1) NULL DEFAULT NULL COMMENT '是否疼痛(1:是0:否)',
  `create_by` int(11) NULL DEFAULT NULL COMMENT '创建人id',
  `create_by_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建者姓名',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` int(11) NULL DEFAULT NULL COMMENT '更新人id',
  `update_by_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新者姓名',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_delete` tinyint(1) NULL DEFAULT 0 COMMENT '0:有效 1:删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tt_menstruation
-- ----------------------------
INSERT INTO `tt_menstruation` VALUES (1, 1, '2019-07-20 11:56:18', '2019-07-24 11:56:18', 0, -1, '初始化', '2020-01-22 11:56:57', NULL, NULL, NULL, 0);
INSERT INTO `tt_menstruation` VALUES (2, 1, '2019-08-21 11:56:18', '2019-08-25 11:56:18', 0, -1, '初始化', '2020-01-22 11:56:57', NULL, NULL, NULL, 0);
INSERT INTO `tt_menstruation` VALUES (3, 1, '2019-09-27 11:56:18', '2019-10-01 11:56:18', 0, -1, '初始化', '2020-01-22 11:56:57', NULL, NULL, NULL, 0);
INSERT INTO `tt_menstruation` VALUES (4, 1, '2019-10-25 11:56:18', '2019-10-29 11:56:18', 0, -1, '初始化', '2020-01-22 11:56:57', NULL, NULL, NULL, 0);
INSERT INTO `tt_menstruation` VALUES (5, 1, '2019-11-22 11:56:18', '2019-11-26 11:56:18', 0, -1, '初始化', '2020-01-22 11:56:57', NULL, NULL, NULL, 0);
INSERT INTO `tt_menstruation` VALUES (6, 1, '2019-12-25 11:56:18', '2019-12-30 11:56:18', 0, -1, '初始化', '2020-01-22 11:56:57', NULL, NULL, NULL, 0);
INSERT INTO `tt_menstruation` VALUES (7, 1, '2020-01-21 11:56:18', '2020-01-26 15:34:32', 1, -1, '初始化', '2020-01-22 11:56:57', NULL, NULL, NULL, 0);
INSERT INTO `tt_menstruation` VALUES (8, 1, '2020-02-19 17:41:06', '2020-02-24 17:41:40', 0, -1, '初始化', '2020-03-08 17:42:06', NULL, NULL, NULL, 0);
INSERT INTO `tt_menstruation` VALUES (9, 1, '2020-03-22 16:00:00', '2020-03-26 21:17:45', 1, -1, '系统管理', '2020-03-23 18:27:20', NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for tt_message
-- ----------------------------
DROP TABLE IF EXISTS `tt_message`;
CREATE TABLE `tt_message`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `requester` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '请求者',
  `request_type` tinyint(1) NULL DEFAULT NULL COMMENT '请求类型',
  `verification_code` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '6位验证码',
  `business_type` tinyint(1) NULL DEFAULT NULL COMMENT '业务类型',
  `send_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '发送时间',
  `effective_duration` int(2) NULL DEFAULT NULL COMMENT '有效时长',
  `send_ip` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '请求者ip',
  `create_by` int(11) NULL DEFAULT NULL COMMENT '创建人id',
  `create_by_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建者姓名',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` int(11) NULL DEFAULT NULL COMMENT '更新人id',
  `update_by_name` varbinary(50) NULL DEFAULT NULL COMMENT '更新者姓名',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_delete` tinyint(1) NULL DEFAULT 0 COMMENT '0:有效 1:删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '短信发送' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tt_message
-- ----------------------------
INSERT INTO `tt_message` VALUES (1, '2030503816@qq.com', 1, '885215', 1, '2020-01-16 18:38:52', 5, '0:0:0:0:0:0:0:1', -1, '系统管理', '2020-01-16 18:38:53', -1, 0xE7B3BBE7BB9FE7AEA1E79086, '2020-01-17 10:13:53', 1);
INSERT INTO `tt_message` VALUES (2, '2030503816@qq.com', 1, '029888', 1, '2020-01-17 10:13:52', 5, '0:0:0:0:0:0:0:1', -1, '系统管理', '2020-01-17 10:13:53', -1, 0xE7B3BBE7BB9FE7AEA1E79086, '2020-01-17 17:55:39', 1);
INSERT INTO `tt_message` VALUES (3, '2030503816@qq.com', 1, '387639', 1, '2020-01-17 17:55:38', 5, '0:0:0:0:0:0:0:1', -1, '系统管理', '2020-01-17 17:55:39', -1, 0xE7B3BBE7BB9FE7AEA1E79086, '2020-01-17 18:10:13', 1);
INSERT INTO `tt_message` VALUES (4, '1428639203@qq.com', 1, '424287', 1, '2020-03-10 21:09:37', 5, '117.143.124.124', -1, '系统管理', '2020-03-10 21:09:38', -1, 0xE7B3BBE7BB9FE7AEA1E79086, '2020-03-10 21:09:53', 1);
INSERT INTO `tt_message` VALUES (5, '1428639203@qq.com', 1, '424287', 1, '2020-03-10 21:09:37', 5, '117.143.124.124', -1, '系统管理', '2020-03-10 21:09:38', -1, 0xE7B3BBE7BB9FE7AEA1E79086, '2020-03-10 21:09:53', 1);
INSERT INTO `tt_message` VALUES (6, '1428639203@qq.com', 1, '424287', 1, '2020-03-10 21:09:37', 5, '117.143.124.124', -1, '系统管理', '2020-03-10 21:09:38', -1, 0xE7B3BBE7BB9FE7AEA1E79086, '2020-03-10 21:09:53', 1);
INSERT INTO `tt_message` VALUES (7, '2030503816@qq.com', 1, '624188', 3, '2020-06-07 14:17:00', 5, '127.0.0.1', -1, '系统管理', '2020-06-07 14:16:59', NULL, NULL, NULL, 0);
INSERT INTO `tt_message` VALUES (8, '2030503816@qq.com', 1, '320858', 1, '2020-06-29 14:46:49', 5, '0:0:0:0:0:0:0:1', -1, '系统管理', '2020-06-29 14:46:49', NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for tt_remind
-- ----------------------------
DROP TABLE IF EXISTS `tt_remind`;
CREATE TABLE `tt_remind`  (
  `id` int(11) NOT NULL,
  `mobile_number` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '接收者手机号',
  `mail` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '接收者邮箱',
  `remind_date` datetime(0) NULL DEFAULT NULL COMMENT '提醒日期',
  `subject` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '提醒主题',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '提醒内容',
  `is_anonymous` tinyint(1) NULL DEFAULT NULL COMMENT '是否匿名',
  `create_by` int(11) NULL DEFAULT NULL COMMENT '创建人id',
  `create_by_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建者姓名',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` int(11) NULL DEFAULT NULL COMMENT '更新人id',
  `update_by_name` varbinary(50) NULL DEFAULT NULL COMMENT '更新者姓名',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_delete` tinyint(1) NULL DEFAULT 0 COMMENT '0:有效 1:删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '时间提醒' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tt_task
-- ----------------------------
DROP TABLE IF EXISTS `tt_task`;
CREATE TABLE `tt_task`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `job_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '任务名',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '任务描述',
  `cron_expression` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT 'cron表达式',
  `bean_class` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '任务执行时调用哪个类的方法 包名+类名',
  `job_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '任务状态',
  `job_group` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '任务分组',
  `invoked_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '被调用的url',
  `is_delete` tinyint(1) NULL DEFAULT 0 COMMENT '1:是 0:否',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci COMMENT = '定时任务' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tt_task
-- ----------------------------
INSERT INTO `tt_task` VALUES (2, 'remind', '大姨妈定时提醒', '0 15 20 ? * *', 'helper.quartz.ExecuteJob', '1', 'group', 'http://localhost:9000/menstruation/taskMenstruationRemind', 0, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for tt_test_batch
-- ----------------------------
DROP TABLE IF EXISTS `tt_test_batch`;
CREATE TABLE `tt_test_batch`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '批量插入测试' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tt_test_batch
-- ----------------------------
INSERT INTO `tt_test_batch` VALUES (1, 'ff397cfc-8f2e-41db-8e9a-bc871423d038');
INSERT INTO `tt_test_batch` VALUES (2, 'ae236e54-aae6-4e61-9053-9161acd06308');
INSERT INTO `tt_test_batch` VALUES (3, '163ca26d-b3c1-4c16-a4f6-3dc42c9ef129');
INSERT INTO `tt_test_batch` VALUES (4, '292b08e1-b0c3-46d3-83af-53ebd550579d');
INSERT INTO `tt_test_batch` VALUES (5, 'e424a8b6-790b-4422-ac22-0031eb643b84');
INSERT INTO `tt_test_batch` VALUES (6, 'b9398316-9f67-436a-8ea4-bdb5b551766d');
INSERT INTO `tt_test_batch` VALUES (7, '43d01d56-be33-4de2-93ee-62ce2b909214');
INSERT INTO `tt_test_batch` VALUES (8, '4588e595-da71-4dc0-8b87-eb30b17d5284');
INSERT INTO `tt_test_batch` VALUES (9, '1f6bc2dd-96da-416e-aa7b-f04cc19c02ae');
INSERT INTO `tt_test_batch` VALUES (10, 'f7a2dcad-6457-4e1e-bc5d-13d23259d6f4');
INSERT INTO `tt_test_batch` VALUES (11, '8247c499-ed98-4573-b476-a90647ce8710');
INSERT INTO `tt_test_batch` VALUES (12, '6cff11cb-1d94-4312-adc4-abd94be26fe7');
INSERT INTO `tt_test_batch` VALUES (13, 'ad4e00b1-acc4-4ead-984a-d437b8922092');
INSERT INTO `tt_test_batch` VALUES (14, '17e59a91-21ae-4381-81f9-db34671e7041');
INSERT INTO `tt_test_batch` VALUES (15, '26e5310d-1f0c-4464-9c75-e26136d7507c');
INSERT INTO `tt_test_batch` VALUES (16, '8463f6cb-7943-463a-9eb5-26825e808a00');
INSERT INTO `tt_test_batch` VALUES (17, '800410ce-d1ad-4c5c-a58c-4c6db720339d');
INSERT INTO `tt_test_batch` VALUES (18, 'c0d7ce78-0de9-41d5-b47a-d006c398cd8e');
INSERT INTO `tt_test_batch` VALUES (19, '8934d341-83a4-4968-9a90-e5e650f48cf8');
INSERT INTO `tt_test_batch` VALUES (20, 'ad54e073-9238-4cf0-9dd2-d2b63a22a904');
INSERT INTO `tt_test_batch` VALUES (21, 'abde17ac-332e-4bce-9007-59a40366fbff');
INSERT INTO `tt_test_batch` VALUES (22, '9dbe8050-e19d-4e41-b1ef-238bcbabcb5b');
INSERT INTO `tt_test_batch` VALUES (23, '095d45b5-3b3a-4cb9-980e-ff86f7a54b20');
INSERT INTO `tt_test_batch` VALUES (24, '0b596acf-3f79-43ff-b5a1-50dcb88ddd23');
INSERT INTO `tt_test_batch` VALUES (25, '19b2e069-82f7-4a05-9ed4-de97cd7e0fab');
INSERT INTO `tt_test_batch` VALUES (26, 'c1af3735-fee2-4353-958e-8c7d694a404f');
INSERT INTO `tt_test_batch` VALUES (27, '474a8c55-c8bd-4a6c-9f91-9a4b24950966');
INSERT INTO `tt_test_batch` VALUES (28, '89df4dd0-d4db-4e7d-afb3-8ca48ced83ef');
INSERT INTO `tt_test_batch` VALUES (29, '116a3ebe-6dc1-47dc-9780-c3b682e969e0');
INSERT INTO `tt_test_batch` VALUES (30, '88117647-f263-48b2-bc30-d76278266cf9');

-- ----------------------------
-- Table structure for tt_user
-- ----------------------------
DROP TABLE IF EXISTS `tt_user`;
CREATE TABLE `tt_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '姓名',
  `user_nick` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '昵称',
  `user_sex` tinyint(1) NULL DEFAULT NULL COMMENT '1:男 2:女 3:未知',
  `address` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '住址',
  `id_card` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '身份证',
  `mobile_number` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '手机号',
  `qq` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT 'qq',
  `mail` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '邮箱',
  `login_password` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '登录密码',
  `user_birthday` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '生日',
  `user_type` tinyint(1) NULL DEFAULT NULL COMMENT '用户类型1:注册用户 2:访客用户 3:后台开通',
  `create_by` int(11) NULL DEFAULT NULL COMMENT '创建人id',
  `create_by_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建者姓名',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` int(11) NULL DEFAULT NULL COMMENT '更新人id',
  `update_by_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新者姓名',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_delete` tinyint(1) NULL DEFAULT 0 COMMENT '0:有效 1:删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tt_user
-- ----------------------------
INSERT INTO `tt_user` VALUES (2, NULL, '包子', NULL, NULL, NULL, NULL, NULL, '1428639203@qq.com', '10f935e22379d4547610781a6381a03d', NULL, 1, -1, '系统管理', '2020-01-05 18:22:08', NULL, NULL, NULL, 0);
INSERT INTO `tt_user` VALUES (8, NULL, '汤圆', NULL, NULL, NULL, NULL, NULL, '2030503816@qq.com', '10f935e22379d4547610781a6381a03d', NULL, 1, -1, '系统管理', '2020-03-10 21:09:54', NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for tt_user_login
-- ----------------------------
DROP TABLE IF EXISTS `tt_user_login`;
CREATE TABLE `tt_user_login`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `login_date` datetime(0) NULL DEFAULT NULL COMMENT '登录时间',
  `login_ip` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '登录IP',
  `device_num` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '设备号',
  `create_by` int(11) NULL DEFAULT NULL COMMENT '创建人id',
  `create_by_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建者姓名',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` int(11) NULL DEFAULT NULL COMMENT '更新人id',
  `update_by_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新者姓名',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_delete` tinyint(1) NULL DEFAULT 0 COMMENT '0:有效 1:删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tt_user_login
-- ----------------------------
INSERT INTO `tt_user_login` VALUES (1, 6, '2019-12-10 14:15:45', '127.0.0.1', NULL, -1, '系统管理', '2019-12-10 14:15:45', NULL, NULL, NULL, 0);
INSERT INTO `tt_user_login` VALUES (2, 6, '2019-12-10 14:31:50', '127.0.0.1', NULL, -1, '系统管理', '2019-12-10 14:31:50', NULL, NULL, NULL, 0);
INSERT INTO `tt_user_login` VALUES (3, 6, '2019-12-10 15:28:41', '127.0.0.1', NULL, -1, '系统管理', '2019-12-10 15:28:41', NULL, NULL, NULL, 0);
INSERT INTO `tt_user_login` VALUES (4, 6, '2019-12-10 15:29:19', '127.0.0.1', NULL, -1, '系统管理', '2019-12-10 15:29:19', NULL, NULL, NULL, 0);
INSERT INTO `tt_user_login` VALUES (5, 7, '2020-01-05 18:22:25', '127.0.0.1', NULL, -1, '系统管理', '2020-01-05 18:22:25', NULL, NULL, NULL, 0);
INSERT INTO `tt_user_login` VALUES (6, 1, '2020-03-10 21:03:37', '117.143.124.124', NULL, -1, '系统管理', '2020-03-10 21:03:37', NULL, NULL, NULL, 0);
INSERT INTO `tt_user_login` VALUES (7, 8, '2020-03-10 21:11:54', '117.143.124.124', NULL, -1, '系统管理', '2020-03-10 21:11:54', NULL, NULL, NULL, 0);
INSERT INTO `tt_user_login` VALUES (8, 1, '2020-03-10 21:41:06', '127.0.0.1', NULL, -1, '系统管理', '2020-03-10 21:41:06', NULL, NULL, NULL, 0);
INSERT INTO `tt_user_login` VALUES (9, 1, '2020-03-10 21:41:10', '127.0.0.1', NULL, -1, '系统管理', '2020-03-10 21:41:10', NULL, NULL, NULL, 0);
INSERT INTO `tt_user_login` VALUES (10, 1, '2020-03-10 21:42:04', '127.0.0.1', NULL, -1, '系统管理', '2020-03-10 21:42:04', NULL, NULL, NULL, 0);
INSERT INTO `tt_user_login` VALUES (11, 1, '2020-03-10 21:44:20', '192.168.1.5', NULL, -1, '系统管理', '2020-03-10 21:44:20', NULL, NULL, NULL, 0);
INSERT INTO `tt_user_login` VALUES (12, 1, '2020-03-10 21:46:11', '192.168.1.13', NULL, -1, '系统管理', '2020-03-10 21:46:11', NULL, NULL, NULL, 0);
INSERT INTO `tt_user_login` VALUES (13, 1, '2020-03-10 21:46:12', '192.168.1.13', NULL, -1, '系统管理', '2020-03-10 21:46:12', NULL, NULL, NULL, 0);
INSERT INTO `tt_user_login` VALUES (14, 1, '2020-03-10 21:46:12', '192.168.1.13', NULL, -1, '系统管理', '2020-03-10 21:46:12', NULL, NULL, NULL, 0);
INSERT INTO `tt_user_login` VALUES (15, 1, '2020-03-10 21:46:15', '192.168.1.13', NULL, -1, '系统管理', '2020-03-10 21:46:15', NULL, NULL, NULL, 0);
INSERT INTO `tt_user_login` VALUES (16, 1, '2020-03-10 21:46:30', '192.168.1.13', NULL, -1, '系统管理', '2020-03-10 21:46:30', NULL, NULL, NULL, 0);
INSERT INTO `tt_user_login` VALUES (17, 1, '2020-03-10 21:46:33', '192.168.1.13', NULL, -1, '系统管理', '2020-03-10 21:46:33', NULL, NULL, NULL, 0);
INSERT INTO `tt_user_login` VALUES (18, 8, '2020-06-07 16:26:24', '127.0.0.1', NULL, -1, '系统管理', '2020-06-07 16:26:24', NULL, NULL, NULL, 0);
INSERT INTO `tt_user_login` VALUES (19, 8, '2020-06-07 16:42:23', '127.0.0.1', NULL, -1, '系统管理', '2020-06-07 16:42:23', NULL, NULL, NULL, 0);
INSERT INTO `tt_user_login` VALUES (20, 8, '2020-06-07 16:43:06', '127.0.0.1', NULL, -1, '系统管理', '2020-06-07 16:43:06', NULL, NULL, NULL, 0);
INSERT INTO `tt_user_login` VALUES (21, 8, '2020-06-29 14:48:19', '0:0:0:0:0:0:0:1', NULL, -1, '系统管理', '2020-06-29 14:48:19', NULL, NULL, NULL, 0);

SET FOREIGN_KEY_CHECKS = 1;
