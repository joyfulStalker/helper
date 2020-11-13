/*
Navicat MySQL Data Transfer

Source Server         : 本地库
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : payment

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2019-06-09 22:07:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tt_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `tt_dictionary`;
CREATE TABLE `tt_dictionary` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `data_type` int(8) DEFAULT NULL COMMENT '数据类型',
  `business_data_type` int(4) DEFAULT NULL COMMENT '业务数据类型',
  `business_data_descr` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '业务数据描述',
  `is_deleted` int(8) NOT NULL DEFAULT '10011002' COMMENT '是否被删除',
  `created_by` bigint(11) DEFAULT '666' COMMENT '创建人id',
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` bigint(11) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='数据字典表';

-- ----------------------------
-- Records of tt_dictionary
-- ----------------------------
INSERT INTO `tt_dictionary` VALUES ('1', '1000', '1001', '是否状态', '10011002', '666', '2019-06-03 21:10:04', null, null);
INSERT INTO `tt_dictionary` VALUES ('2', '1001', '10011001', '是', '10011002', '666', '2019-06-03 21:11:44', null, null);
INSERT INTO `tt_dictionary` VALUES ('3', '1001', '10011002', '否', '10011002', '666', '2019-06-03 21:12:00', null, null);
INSERT INTO `tt_dictionary` VALUES ('4', '1000', '1002', '性别', '10011002', '666', '2019-06-03 21:31:26', null, null);
INSERT INTO `tt_dictionary` VALUES ('5', '1002', '10021001', '男', '10011002', '666', '2019-06-03 21:31:40', null, null);
INSERT INTO `tt_dictionary` VALUES ('6', '1002', '10021002', '女', '10011002', '666', '2019-06-03 21:31:53', null, null);
INSERT INTO `tt_dictionary` VALUES ('7', '1002', '10021003', '保密', '10011002', '666', '2019-06-03 21:32:21', null, null);
INSERT INTO `tt_dictionary` VALUES ('8', '1000', '1003', '费用类型', '10011002', '666', '2019-06-03 21:39:20', null, null);
INSERT INTO `tt_dictionary` VALUES ('9', '1003', '10031001', '成本', '10011002', '666', '2019-06-03 21:42:49', null, null);
INSERT INTO `tt_dictionary` VALUES ('10', '1003', '10031002', '收入', '10011002', '666', '2019-06-03 21:43:04', null, null);

-- ----------------------------
-- Table structure for tt_fee
-- ----------------------------
DROP TABLE IF EXISTS `tt_fee`;
CREATE TABLE `tt_fee` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `fee_type` int(8) DEFAULT NULL COMMENT '费用类型(字典1003)',
  `tt_fee_cause` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '从tt_fee_cause表中选择',
  `total_cost` decimal(8,2) DEFAULT NULL COMMENT '总费用',
  `is_settled` int(8) DEFAULT NULL COMMENT '是否结清',
  `actual_paid` decimal(8,2) DEFAULT '0.00' COMMENT '实付金额',
  `fee_time` datetime DEFAULT NULL COMMENT '费用产生日期',
  `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '备注',
  `created_by` bigint(11) DEFAULT NULL COMMENT '创建人id',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` bigint(11) DEFAULT NULL COMMENT '创建人id',
  `updated_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='费用项';

-- ----------------------------
-- Records of tt_fee
-- ----------------------------
INSERT INTO `tt_fee` VALUES ('1', '1', '1', '1.00', '1', '1.00', '2019-05-27 22:16:05', '1', null, '2019-05-27 22:16:03', null, null);

-- ----------------------------
-- Table structure for tt_fee_cause
-- ----------------------------
DROP TABLE IF EXISTS `tt_fee_cause`;
CREATE TABLE `tt_fee_cause` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `business_type` int(11) DEFAULT NULL COMMENT '10011001:成本费用项  10011002:盈利费用项',
  `describe` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '描述',
  `created_by` bigint(11) DEFAULT NULL COMMENT '创建人id',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_by` bigint(11) DEFAULT NULL COMMENT '更新人',
  `updated_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='费用产生原因';

-- ----------------------------
-- Records of tt_fee_cause
-- ----------------------------

-- ----------------------------
-- Table structure for tt_fee_payment_detail
-- ----------------------------
DROP TABLE IF EXISTS `tt_fee_payment_detail`;
CREATE TABLE `tt_fee_payment_detail` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tt_fee_id` bigint(11) DEFAULT NULL COMMENT '费用主键id',
  `fee_amount` decimal(8,2) DEFAULT NULL COMMENT '费用金额',
  `pay_time` datetime DEFAULT NULL COMMENT '付款时间',
  `drawee_id` bigint(11) DEFAULT NULL COMMENT '付款人（包含公司）id',
  `drawee` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '付款人姓名/公司名称',
  `payee_id` bigint(11) DEFAULT NULL COMMENT '收款人id/收款公司',
  `payee` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '收款人/收款公司',
  `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='付费详情';

-- ----------------------------
-- Records of tt_fee_payment_detail
-- ----------------------------

-- ----------------------------
-- Table structure for tt_menu
-- ----------------------------
DROP TABLE IF EXISTS `tt_menu`;
CREATE TABLE `tt_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '节点id',
  `pid` bigint(20) NOT NULL COMMENT '父节点id',
  `path` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '路径',
  `component` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '组件路径(例: ./book/list.vue)',
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '菜单显示名称',
  `menu_show` tinyint(4) DEFAULT '1' COMMENT '是否显示',
  `icon_cls` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '图标',
  `delete_flag` int(11) DEFAULT '1' COMMENT '删除标识 1 :可用 2:不可用',
  `leaf` tinyint(4) DEFAULT '0' COMMENT '只有一个节点  (true)',
  `created_by` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `updated_by` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '更新人',
  `updated_date` datetime DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='动态菜单';

-- ----------------------------
-- Records of tt_menu
-- ----------------------------
INSERT INTO `tt_menu` VALUES ('28', '0', '/', '/Home', '用户管理', '1', 'iconfont icon-accountfilling', '1', '0', '7d90fec8f29d4dadae888be8f51f3830', '2018-11-19 17:50:04', '7d90fec8f29d4dadae888be8f51f3830', '2018-11-20 13:48:34');
INSERT INTO `tt_menu` VALUES ('29', '28', '/user/list', '/user/list', '用户列表', '1', '', '1', '0', '7d90fec8f29d4dadae888be8f51f3830', '2018-11-19 17:51:12', null, null);
INSERT INTO `tt_menu` VALUES ('30', '28', '/user/changepwd', '/user/changepwd', '修改密码', '1', '', '1', '0', '7d90fec8f29d4dadae888be8f51f3830', '2018-11-19 17:52:12', null, null);
INSERT INTO `tt_menu` VALUES ('31', '28', '/user/profile', '/user/profile', '个人信息', '1', '', '1', '0', '7d90fec8f29d4dadae888be8f51f3830', '2018-11-19 17:52:59', null, null);

-- ----------------------------
-- Table structure for tt_personnel
-- ----------------------------
DROP TABLE IF EXISTS `tt_personnel`;
CREATE TABLE `tt_personnel` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '姓名/公司名称',
  `phone` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '手机号',
  `address` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '地址',
  `license` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '车牌号',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='人员信息/公司信息';

-- ----------------------------
-- Records of tt_personnel
-- ----------------------------
