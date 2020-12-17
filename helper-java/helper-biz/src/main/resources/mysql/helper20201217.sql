/*
 Navicat Premium Data Transfer

 Source Server         : my-cloud
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : 127.0.0.1:3306
 Source Schema         : helper

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 17/12/2020 16:07:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for payment_car_owner
-- ----------------------------
DROP TABLE IF EXISTS `payment_car_owner`;
CREATE TABLE `payment_car_owner` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '姓名/公司名称',
  `phone` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '手机号',
  `address` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '地址',
  `license` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '车牌号',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='车主信息表';

-- ----------------------------
-- Table structure for payment_fee
-- ----------------------------
DROP TABLE IF EXISTS `payment_fee`;
CREATE TABLE `payment_fee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `flow_no` bigint(19) NOT NULL COMMENT '流水号',
  `fee_type` int(4) NOT NULL COMMENT '1001:收入 1002:支出',
  `paid_type` int(4) NOT NULL COMMENT '付款方式(1001:支付宝  1002:微信 1003:现金 1004:其他)',
  `total_cost` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '总需支付或收取费用',
  `actual_paid` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '实际收取或支付金额',
  `is_settled` int(8) NOT NULL COMMENT '是否结清(1001:结清 1002:未结清)',
  `pay_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '付款时间',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT '' COMMENT '备注',
  `drawee_id` int(11) DEFAULT NULL COMMENT '付款人（包含公司）id',
  `drawee` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '付款人姓名/公司名称',
  `payee_id` int(11) DEFAULT NULL COMMENT '收款人id/收款公司',
  `payee` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '收款人/收款公司',
  `version` int(11) NOT NULL DEFAULT '1' COMMENT '版本号(从1开始，步长为1，最大的为准)',
  `created_by` bigint(11) DEFAULT NULL COMMENT '创建人id',
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` bigint(11) DEFAULT NULL COMMENT '更新人id',
  `updated_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIX_FN_V` (`flow_no`,`version`) USING BTREE COMMENT '流水号、版本号唯一',
  KEY `IX_FN` (`flow_no`) USING BTREE COMMENT '流水号索引'
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='费用流水';

-- ----------------------------
-- Records of payment_fee
-- ----------------------------
BEGIN;
INSERT INTO `payment_fee` VALUES (2, 493157532160892928, 1001, 1001, 100.00, 10.00, 1001, '2020-08-19 01:41:04', '备注', NULL, '付款人', NULL, '收款人', 1, NULL, '2020-08-18 17:53:04', NULL, NULL);
INSERT INTO `payment_fee` VALUES (3, 493157532160892928, 1001, 1001, 100.00, 10.00, 1001, '2020-08-19 01:41:04', '备注', NULL, '付款人', NULL, '收款人', 2, NULL, '2020-08-18 17:54:43', NULL, NULL);
INSERT INTO `payment_fee` VALUES (4, 493228349674627072, 1001, 1002, 100.00, 100.00, 1002, '2020-08-18 16:08:08', '这是备注', NULL, '付款人', NULL, '收款人', 1, NULL, '2020-08-18 22:34:26', NULL, NULL);
INSERT INTO `payment_fee` VALUES (5, 493228364094644224, 1001, 1002, 100.00, 100.00, 1002, '2020-08-18 16:08:08', '这是备注', NULL, '付款人', NULL, '收款人', 1, NULL, '2020-08-18 22:34:29', NULL, NULL);
INSERT INTO `payment_fee` VALUES (6, 493228368595132416, 1001, 1002, 100.00, 100.00, 1002, '2020-08-18 16:08:08', '这是备注', NULL, '付款人', NULL, '收款人', 1, NULL, '2020-08-18 22:34:30', NULL, NULL);
INSERT INTO `payment_fee` VALUES (7, 493228370868445184, 1001, 1002, 100.00, 100.00, 1002, '2020-08-18 16:08:08', '这是备注', NULL, '付款人', NULL, '收款人', 1, NULL, '2020-08-18 22:34:31', NULL, NULL);
INSERT INTO `payment_fee` VALUES (8, 493228372651024384, 1001, 1002, 100.00, 100.00, 1002, '2020-08-18 16:08:08', '这是备注', NULL, '付款人', NULL, '收款人', 1, NULL, '2020-08-18 22:34:31', NULL, NULL);
INSERT INTO `payment_fee` VALUES (9, 493228374295191552, 1001, 1002, 100.00, 100.00, 1002, '2020-08-18 16:08:08', '这是备注', NULL, '付款人', NULL, '收款人', 1, NULL, '2020-08-18 22:34:32', NULL, NULL);
INSERT INTO `payment_fee` VALUES (10, 493228375813529600, 1001, 1002, 100.00, 100.00, 1002, '2020-08-18 16:08:08', '这是备注', NULL, '付款人', NULL, '收款人', 1, NULL, '2020-08-18 22:34:32', NULL, NULL);
INSERT INTO `payment_fee` VALUES (11, 493228375813529600, 1001, 1002, 100.00, 100.00, 1002, '2020-08-18 16:08:08', '这是备注', NULL, '付款人', NULL, '收款人', 2, NULL, '2020-08-18 22:35:07', NULL, NULL);
INSERT INTO `payment_fee` VALUES (18, 493228375813529600, 1001, 1002, 1000.00, 900.00, 1001, '2020-08-18 16:08:08', '这是备注', NULL, '付款人', NULL, '收款人', 3, NULL, '2020-08-18 22:45:30', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for rlt_label
-- ----------------------------
DROP TABLE IF EXISTS `rlt_label`;
CREATE TABLE `rlt_label` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `business_id` int(11) NOT NULL COMMENT '业务主键id',
  `business_table` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '业务表名',
  `tt_label_id` int(11) NOT NULL COMMENT '标签id',
  `create_by` int(11) DEFAULT NULL COMMENT '创建人id',
  `create_by_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建者姓名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新人id',
  `update_by_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '更新者姓名',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_delete` tinyint(1) DEFAULT '0' COMMENT '0:有效 1:删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of rlt_label
-- ----------------------------
BEGIN;
INSERT INTO `rlt_label` VALUES (1, 1, 'tt_note', 1, 1, '管理员', '2020-07-20 21:19:05', NULL, NULL, NULL, 0);
INSERT INTO `rlt_label` VALUES (2, 2, 'tt_note', 1, 1, '管理员', '2020-07-20 21:19:19', NULL, NULL, NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for tt_label
-- ----------------------------
DROP TABLE IF EXISTS `tt_label`;
CREATE TABLE `tt_label` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `label_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '标签名称',
  `business_type` smallint(6) NOT NULL COMMENT '业务类型(1. 消息提醒 2.任务性质 3.笔记标签)',
  `create_by` int(11) DEFAULT NULL COMMENT '创建人id',
  `create_by_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建者姓名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新人id',
  `update_by_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '更新者姓名',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_delete` tinyint(1) DEFAULT '0' COMMENT '0:有效 1:删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='标签';

-- ----------------------------
-- Records of tt_label
-- ----------------------------
BEGIN;
INSERT INTO `tt_label` VALUES (1, 1, 'linux运维', 3, 1, '管理员', '2020-07-20 21:18:49', NULL, NULL, NULL, 0);
COMMIT;

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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户信息表';

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
INSERT INTO `tt_menstruation` VALUES (8, 1, '2020-02-19 17:41:06', '2020-02-24 17:41:40', 0, -1, '初始化', '2020-03-08 17:42:06', NULL, NULL, NULL, 0);
INSERT INTO `tt_menstruation` VALUES (9, 1, '2020-03-22 16:00:00', '2020-03-26 21:17:45', 1, -1, '系统管理', '2020-03-23 18:27:20', NULL, NULL, NULL, 0);
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='短信发送';

-- ----------------------------
-- Records of tt_message
-- ----------------------------
BEGIN;
INSERT INTO `tt_message` VALUES (1, '2030503816@qq.com', 1, '885215', 1, '2020-01-16 18:38:52', 5, '0:0:0:0:0:0:0:1', -1, '系统管理', '2020-01-16 18:38:53', -1, 0xE7B3BBE7BB9FE7AEA1E79086, '2020-01-17 10:13:53', 1);
INSERT INTO `tt_message` VALUES (2, '2030503816@qq.com', 1, '029888', 1, '2020-01-17 10:13:52', 5, '0:0:0:0:0:0:0:1', -1, '系统管理', '2020-01-17 10:13:53', -1, 0xE7B3BBE7BB9FE7AEA1E79086, '2020-01-17 17:55:39', 1);
INSERT INTO `tt_message` VALUES (3, '2030503816@qq.com', 1, '387639', 1, '2020-01-17 17:55:38', 5, '0:0:0:0:0:0:0:1', -1, '系统管理', '2020-01-17 17:55:39', -1, 0xE7B3BBE7BB9FE7AEA1E79086, '2020-01-17 18:10:13', 1);
INSERT INTO `tt_message` VALUES (4, '1428639203@qq.com', 1, '424287', 1, '2020-03-10 21:09:37', 5, '117.143.124.124', -1, '系统管理', '2020-03-10 21:09:38', -1, 0xE7B3BBE7BB9FE7AEA1E79086, '2020-03-10 21:09:53', 1);
INSERT INTO `tt_message` VALUES (5, '1428639203@qq.com', 1, '424287', 1, '2020-03-10 21:09:37', 5, '117.143.124.124', -1, '系统管理', '2020-03-10 21:09:38', -1, 0xE7B3BBE7BB9FE7AEA1E79086, '2020-03-10 21:09:53', 1);
INSERT INTO `tt_message` VALUES (6, '1428639203@qq.com', 1, '424287', 1, '2020-03-10 21:09:37', 5, '117.143.124.124', -1, '系统管理', '2020-03-10 21:09:38', -1, 0xE7B3BBE7BB9FE7AEA1E79086, '2020-03-10 21:09:53', 1);
INSERT INTO `tt_message` VALUES (7, '2030503816@qq.com', 1, '320858', 1, '2020-06-29 14:46:49', 5, '0:0:0:0:0:0:0:1', -1, '系统管理', '2020-06-29 14:46:49', -1, 0xE7B3BBE7BB9FE7AEA1E79086, '2020-07-16 17:27:57', 1);
INSERT INTO `tt_message` VALUES (8, '2030503816@qq.com', 1, '320858', 1, '2020-06-29 14:46:49', 5, '0:0:0:0:0:0:0:1', -1, '系统管理', '2020-06-29 14:46:49', -1, 0xE7B3BBE7BB9FE7AEA1E79086, '2020-07-16 17:27:57', 1);
INSERT INTO `tt_message` VALUES (9, '2030503816@qq.com', 1, '867331', 1, '2020-07-16 17:27:57', 5, '0:0:0:0:0:0:0:1', -1, '系统管理', '2020-07-16 17:27:57', -1, 0xE7B3BBE7BB9FE7AEA1E79086, '2020-07-16 17:28:18', 1);
INSERT INTO `tt_message` VALUES (10, '2030503816@qq.com', 1, '565739', 1, '2020-07-16 17:49:18', 5, '127.0.0.1', -1, '系统管理', '2020-07-16 17:48:42', -1, 0xE7B3BBE7BB9FE7AEA1E79086, '2020-07-16 17:49:49', 1);
INSERT INTO `tt_message` VALUES (11, '2030503816@qq.com', 1, '923374', 1, '2020-08-18 14:06:53', 5, '0:0:0:0:0:0:0:1', -1, '系统管理', '2020-08-18 14:06:54', -1, 0xE7B3BBE7BB9FE7AEA1E79086, '2020-08-18 14:12:54', 1);
INSERT INTO `tt_message` VALUES (12, '2030503816@qq.com', 1, '852932', 1, '2020-08-18 14:12:54', 5, '0:0:0:0:0:0:0:1', -1, '系统管理', '2020-08-18 14:12:54', NULL, NULL, NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for tt_note
-- ----------------------------
DROP TABLE IF EXISTS `tt_note`;
CREATE TABLE `tt_note` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tt_user_id` int(11) NOT NULL COMMENT '用户ID',
  `note_title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '笔记名称',
  `note_category` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '笔记分类(java-base,java-spring,java-mybatis,mom-rmq,mom-kfk,mom-red,datebase-mysql,date-orac)',
  `note_content` text COLLATE utf8mb4_bin COMMENT '笔记内容',
  `publish_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '发布状态(1:草稿 2:审核中 3:已发布 4:审核失败)',
  `check_result` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT '' COMMENT '审核反馈结果',
  `create_by` int(11) DEFAULT NULL COMMENT '创建人id',
  `create_by_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建者姓名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新人id',
  `update_by_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '更新者姓名',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_delete` tinyint(1) DEFAULT '0' COMMENT '0:有效 1:删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of tt_note
-- ----------------------------
BEGIN;
INSERT INTO `tt_note` VALUES (1, 1, 'SpringBoot+Vue+Linux 项目发布流程', 'java-base', '<div id=\"content_views\" class=\"markdown_views prism-atom-one-dark\">\r\n                    <!-- flowchart 箭头图标 勿删 -->\r\n                    <svg xmlns=\"http://www.w3.org/2000/svg\" style=\"display: none;\">\r\n                        <path stroke-linecap=\"round\" d=\"M5,0 0,2.5 5,5z\" id=\"raphael-marker-block\" style=\"-webkit-tap-highlight-color: rgba(0, 0, 0, 0);\"></path>\r\n                    </svg>\r\n                                            <h4><a id=\"SpringBootVue_0\"></a>准备好SpringBoot和Vue项目</h4>\r\n<h4><a id=\"vue_1\"></a>修改vue项目的配置文件</h4>\r\n<ol>\r\n<li>找到<em>config/index.js</em>文件，定位到 <strong>build</strong> 下，修改assetsPublicPath的值为<code>assetsPublicPath: \'./\'</code>。<br>\r\n如图：加 <code>.</code>，不然的话会是空白页。<br>\r\n<img src=\"https://img-blog.csdnimg.cn/20200712195015949.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3l1eWVzaGFodW4=,size_16,color_FFFFFF,t_70\" alt=\"在这里插入图片描述\"></li>\r\n<li>找到<em>build/util.js</em>文件，定位到 <strong>vue-style-loader</strong> ，在其后加一行：<code>publicPath: \'../../\'</code>，作用是保证字体、图片的正常使用。</li>\r\n<li>把代理请求改掉，使用真实地址。我封装了axios，在创建axios实例的时候把原来本地的 <strong>/mypath</strong> 改成真实地址 <strong>http://127.0.0.1:9000</strong>。<pre class=\"prettyprint\"><code class=\"has-numbering\" onclick=\"mdcp.copyCode(event)\" style=\"position: unset;\">const service = axios.create({\r\n   // baseURL: \'/mypath\', // api的base_url\r\n   baseURL: \'http://127.0.0.1:9000\', // api的base_url\r\n   timeout: 100000// 请求超时时间\r\n});\r\n<div class=\"hljs-button {2}\" data-title=\"复制\"></div></code><ul class=\"pre-numbering\" style=\"\"><li style=\"color: rgb(153, 153, 153);\">1</li><li style=\"color: rgb(153, 153, 153);\">2</li><li style=\"color: rgb(153, 153, 153);\">3</li><li style=\"color: rgb(153, 153, 153);\">4</li><li style=\"color: rgb(153, 153, 153);\">5</li></ul></pre>\r\n</li>\r\n</ol>\r\n<h4><a id=\"SpringBootLinux_14\"></a>整合到SpringBoot中，并发布到Linux</h4>\r\n<ol start=\"4\">\r\n<li>\r\n<p>Vue项目下执行<code>npm run build</code>，得到一个<em>dist</em>文件夹，下面有一个<em>index.html</em>文件和<em>static</em>文件夹，这个文件夹就是我们要发布的前端项目。如图：<br>\r\n<img src=\"https://img-blog.csdnimg.cn/20200712200257323.png\" alt=\"在这里插入图片描述\"></p>\r\n</li>\r\n<li>\r\n<p>把上一步得到的文件夹<em>dist</em>下的<em>index.html</em>文件和<em>static</em>文件夹放到SpringBoot项目中，位置是<code>resources\\static</code>，如图：<br>\r\n<img src=\"https://img-blog.csdnimg.cn/20200712200729208.png\" alt=\"在这里插入图片描述\"></p>\r\n</li>\r\n<li>\r\n<p>打包SpringBoot项目，得到项目的jar包。（jar包在项目的target目录下）。上传jar包到Linux服务器上。运行项目，<br>\r\n命令： <code>java -jar 你的项目.jar</code>。 <a href=\"http://192.168.1.200:9000/\" rel=\"nofollow\">请求地址，以实际为准</a> http://192.168.1.200:9000/。</p>\r\n<p>至此Vue项目已经整合到SpringBoot上了。</p>\r\n</li>\r\n</ol>\r\n\r\n                                    </div>', 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `tt_note` VALUES (2, 1, '完美保存谷歌浏览器网页', 'index', '<p>老版本的谷歌浏览器可以在输入栏中输入chrome://flags,搜素mhtml，启用。<br>\r\n但是新版本中是搜索不到的，此时可以在进行如下操作来开启此功能：<br>\r\n找到快捷图标–&gt;右键–&gt;属性–&gt;快捷方式–&gt;输入： 空格 --save-page-as-mhtml<br>\r\n应用确定，重新进入，ctrl+s即可完美保存网页<br>\r\n<img src=\"https://img-blog.csdnimg.cn/20200211201616412.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3l1eWVzaGFodW4=,size_16,color_FFFFFF,t_70\" alt=\"在这里插入图片描述\"></p>', 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `tt_note` VALUES (3, 1, '2020-JVM学习笔记 尚硅谷-宋红康', 'java-base', '<body class=\"typora-export os-windows\">\r\n<div id=\"write\" class=\"is-node\"><h1><a name=\"2020-jvm学习笔记-尚硅谷-宋红康\" class=\"md-header-anchor\"></a><span>2020-JVM学习笔记 尚硅谷-宋红康 </span></h1><p>&nbsp;</p><p><span>本笔记以HotSpot为主，Java不是最强大的语言，但是JVM是最强大的虚拟机。</span></p><p><span>天下事有难易乎？为之，则难者亦易已；不为，则易者亦难矣。</span></p><p><span>记录于：20200801</span></p><p><span>修改于：20200802、</span></p><p><span>结束于：</span></p><p>&nbsp;</p><h2><a name=\"一参考资料\" class=\"md-header-anchor\"></a><span>一：参考资料</span></h2><p><span>《Java虚拟机规范(Java SE 8版) 》、《实战Java虚拟机》、《深入了解Java虚拟机》、</span></p><p><span>《自己动手写Java虚拟机（go）》</span></p><p>&nbsp;</p><p>&nbsp;</p><h2><a name=\"二虚拟机概念\" class=\"md-header-anchor\"></a><span>二：虚拟机概念</span></h2><p>&nbsp;</p><p><span>所谓虚拟机（Virtual Machine）,就是一台虚拟得出计算机。它是一款软件，用来执行一系列虚拟计算机指令。大体上，虚拟机可以分为系统虚拟机和程序虚拟机。</span></p><ul><li><span>大名鼎鼎的visual Box，VMware就属于系统虚拟机，他们完全是对物理计算机的仿真，提供了一个可运行完整操作系统的软件平台。</span></li><li><span>程序虚拟机的典型代表就是Java虚拟机，他专门为执行单个计算机程序而设计，在Java虚拟机中执行的指令我们称之为Java字节码指令。</span></li></ul><p><span>无论是系统虚拟机还是程序虚拟机，在上面运行的软件都被限制于虚拟机提供的资源中。</span></p><p>&nbsp;</p><p>&nbsp;</p><h3><a name=\"1java虚拟机\" class=\"md-header-anchor\"></a><span>1、Java虚拟机</span></h3><p>&nbsp;</p><ol start=\"\"><li><p><span>作用：</span></p><p><span>二进制字节码的运行环境，负责装载字节码到其内部，解释编译未对应平台上的机器指令执行。每一条Java指令，Java虚拟机规范中都有详细定义，乳怎么操作数，怎么处理操作数，处理结果放在哪。</span></p></li><li><p><span>特点：</span></p><ol start=\"\"><li><p><span>一次编译，到处运行</span></p></li><li><p><span>自动内存管理</span></p></li><li><p><span>自动垃圾回收功能</span></p><p>&nbsp;</p></li></ol></li></ol><h3><a name=\"2jvm的位置\" class=\"md-header-anchor\"></a><span>2、JVM的位置</span></h3><p>&nbsp;</p><p><img src=\"C:\\Users\\liu\\AppData\\Roaming\\Typora\\typora-user-images\\1596287005271.png\" referrerpolicy=\"no-referrer\" alt=\"1596287005271\"></p><p>&nbsp;</p><p>&nbsp;</p><h2><a name=\"三java代码执行流程\" class=\"md-header-anchor\"></a><span>三：Java代码执行流程</span></h2><p>&nbsp;</p><p><img src=\"C:\\Users\\liu\\Downloads\\Java代码执行流程.png\" referrerpolicy=\"no-referrer\" alt=\"Java代码执行流程\"></p><p>&nbsp;</p><p>&nbsp;</p><h2><a name=\"四jvm的架构模型\" class=\"md-header-anchor\"></a><span>四：JVM的架构模型</span></h2><p>&nbsp;</p><p><span>Java编译器输入的指令流基本上是一种基于栈的指令集架构，另外一种指令级架构则是基于寄存器的指令级架构。</span></p><p><span>两种架构的区别：</span></p><ul><li><p><span>基于栈架构的特点</span></p><p><span>设计和实现更简单，适用于资源受限的系统。</span></p><p><span>避开了寄存器的分配难题，使用零地址指令方式分配。</span></p><p><span>指令流中的指令大部分是零地址指令，其执行过程依赖于操作栈。指令集更小，编译器容易实现。</span></p><p><span>不需要硬件支持，可移植性更好，更好实现跨平台。</span></p></li><li><p><span>基于寄存器架构的特点</span></p><p><span>典型的应用是x86的二进制指令集，比如传统的PC以及Android的Davlik虚拟机。</span></p><p><span>指令级架构则完全依赖硬件，可移植性差。</span></p><p><span>花费更少的指令去完成一项操作，性能优秀和执行更高效。。</span></p><p><span>在大部分情况下，基于寄存器架构的指令集往往都以一地址指令、二地址指令和三地址指令为主，而基于栈式架构的指令集却是以零地址指令为主。</span></p></li></ul><p><span>总结：</span></p><p><span>		</span><span>由于跨平台性的设计，Java的指令集都是根据栈来设计的。不同平台的CPU架构不同，所以不能设计为基于寄存器的。优点是跨平台，指令集小，编译器容易实现，缺点是性能下降，实现同样的功能需要更多的指令。</span></p><p><span>		</span><span>时至今日，尽管嵌入式平台已经不是Java程序的主流运行平台了（准确来说应该是HotSpotVM的宿主环境已经不局限于嵌入式平台了），那么为什么不将架构更换为基于寄存器的架构呢？</span></p><p><span>		</span><span>栈：跨平台、指令集小、指令多，执行性能比寄存器差。</span></p><p>&nbsp;</p><p>&nbsp;</p><h2><a name=\"五jvm生命周期\" class=\"md-header-anchor\"></a><span>五：JVM生命周期</span></h2><ol start=\"\"><li><p><span>虚拟机的启动</span></p><p><span>Java虚拟机的启动是通过引导类加载器（bootstrap class loader）创建一个初始类（initial class）来完成的，这个类是由虚拟机的具体实现指定的。</span></p></li><li><p><span>虚拟机的执行</span></p><ul><li><span>一个运行中的Java虚拟机有着一个清晰的任务：执行Java程序。</span></li><li><span>程序开始执行时，他才运行，程序结束时它就停止。</span></li><li><span>执行一个所谓的Java程序的时候，真正执行的是一个叫做Java虚拟机的进程。</span></li></ul></li><li><p><span>虚拟机的退出</span></p><ul><li><span>程序正常结束</span></li><li><span>程序执行过程中遇到了异常或错误而异常终止</span></li><li><span>由于操作系统出现错误而导致Java虚拟机进程终止</span></li><li><span>某线程调用Runtime类或System类的exit方法，或Runtime累的halt方法，并且Java安全管理器也允许这次exit或halt操作。</span></li><li><span>除此之外，JNI（Java Native Interface）规范描述了用JNI Invocation API 来加载或卸载Java虚拟机时，Java虚拟机的退出情况。</span></li></ul></li></ol><p>&nbsp;</p><h2><a name=\"六类加载子系统\" class=\"md-header-anchor\"></a><span>六：类加载子系统</span></h2><p>&nbsp;</p><h3><a name=\"1作用\" class=\"md-header-anchor\"></a><span>1、作用</span></h3><ul><li><span>类加载器子系统负责从文件系统或者网络中加载class文件，class文件在文件开头有特定的文件标识。</span></li><li><span>ClassLoader只负责class文件的加载，至于他是否可以运行，则是由ExecutionEngine决定。</span></li><li><span>加载的类信息存放于一块称之为方法区的内存空间。除了类的信息外，方法区中还会存放运行时常量池信息，可能还包括字符串常量和数字常量（这部分常量信息是class文件中常量池部分的内存映射）。</span></li></ul><p>&nbsp;</p><h3><a name=\"2类加载过程\" class=\"md-header-anchor\"></a><span>2、类加载过程</span></h3><h4><a name=\"①加载loading）\" class=\"md-header-anchor\"></a><span>①、加载（Loading）</span></h4><ul><li><span>通过一个类的全限定名获取定义此类的二进制字节流</span></li><li><span>将这个字节流所代表的静态存储结构转化为方法区的运行时数据结构</span></li><li><span>在内存中生成一个代表这个类的java.lang.Class对象，作为方法区这个类的各种数据的访问入口</span></li></ul><h4><a name=\"②链接\" class=\"md-header-anchor\"></a><span>②、链接</span></h4><ul><li><p><span>验证（Verification）</span></p><ul><li><span>目的在于确保Class文件的字节流中包含信息符合当前虚拟机要求，保证被加载的正确性，不会危害虚拟机自身安全。</span></li><li><span>主要包括四中验证：文件格式验证、元数据验证、字节码验证、符号引用验证</span></li></ul></li><li><p><span>准备（Preparation）</span></p><ul><li><span>为类变量分配内存并且设置该类变量的默认初始值，即零值。</span></li><li><span>这里不包含用final修饰的static，因为final在编译的时候就会分配了，准备阶段会显示初始化。</span></li><li><span>这里不会为实例变量分配初始化，类变量会分配在方法区中，而实例变量是会随着对象一起分配到Java堆中。</span></li></ul></li><li><p><span>解析（Resolution）</span></p><ul><li><span>将常量池内的符号引用转换为直接引用的过程。</span></li><li><span>事实上，解析操作往往会伴随着JVM在执行完初始化之后再执行。</span></li><li><span>符号引用就是一组符号来描述所引用的目标。符号引用的字面量形式明确定义在《Java虚拟机规范》的Class文件格式中。直接引用就是直接指向目标的指针、相对偏移量或间接定位到目标的句柄。</span></li><li><span>解析动作主要针对类或接口、字段、类方法、接口方法、方法类型等。对应常量池中的CONSTANT_CLASS_INFO、CONSTANT_FIELD_REF_INFO、CONSTANT_METHOD_REF_INFO等。</span></li></ul></li></ul><p>&nbsp;</p><h4><a name=\"③初始化initialization）\" class=\"md-header-anchor\"></a><span>③、初始化（Initialization）</span></h4><ul><li><span>初始化阶段就是执行类构造器方法</span><clinit><span>()的过程。</span></clinit></li><li><span>此方法不需要定义，是javac编译器自动收集类中的所有类变量的赋值动作和静态代码块中的语句合并而来。</span></li><li><span>构造器方法中指令按语句在源文件中出现的顺序执行。</span></li><li><clinit><span>()不同于累的构造器（关联：构造器是虚拟机视角下的</span><linit><span>()）。</span></linit></clinit></li><li><span>若该类具有父类，JVM会保证子类的</span><clinit><span>()执行前，父类的</span><clinit><span>()已经执行完毕。</span></clinit></clinit></li><li><span>虚拟机必须保证一个类的</span><clinit><span>()方法在多线程下被同步加锁。</span></clinit></li></ul><h3><a name=\"3类加载器的分类\" class=\"md-header-anchor\"></a><span>3、类加载器的分类</span></h3><ul><li><span>JVM支持两种类型的类加载器，分别为引导类加载器（Bootstrap ClassLoader）和自定义加载器（User-Defined ClassLoader）。</span></li><li><span>从概念上来讲，自定义加载器一般指的是程序中由开发人员自定义的一类类加载器，但是Java虚拟机规范却没有这么定义，而是将所有派生生于抽象类ClassLoader的类加载器都划分为自定义类加载器。</span></li><li><span>无论加载器的类型如何划分，在程序中我们最常见的类加载器始终只有3个：引导类加载器（Bootstrap ClassLoader）、扩展类加载器（Extension Class Loader）、系统类加载器（System Class Loader）。</span></li></ul><pre spellcheck=\"false\" class=\"md-fences md-end-block ty-contain-cm modeLoaded\" lang=\"java\" style=\"break-inside: unset;\"><div class=\"CodeMirror cm-s-inner CodeMirror-wrap\" lang=\"java\"><div style=\"overflow: hidden; position: relative; width: 3px; height: 0px; top: 0px; left: 4px;\"><textarea autocorrect=\"off\" autocapitalize=\"off\" spellcheck=\"false\" tabindex=\"0\" style=\"position: absolute; bottom: -1em; padding: 0px; width: 1000px; height: 1em; outline: none;\"></textarea></div><div class=\"CodeMirror-scrollbar-filler\" cm-not-content=\"true\"></div><div class=\"CodeMirror-gutter-filler\" cm-not-content=\"true\"></div><div class=\"CodeMirror-scroll\" tabindex=\"-1\"><div class=\"CodeMirror-sizer\" style=\"margin-left: 0px; margin-bottom: 0px; border-right-width: 0px; padding-right: 0px; padding-bottom: 0px;\"><div style=\"position: relative; top: 0px;\"><div class=\"CodeMirror-lines\" role=\"presentation\"><div role=\"presentation\" style=\"position: relative; outline: none;\"><div class=\"CodeMirror-measure\"><span><span>&#8203;</span>x</span></div><div class=\"CodeMirror-measure\"></div><div style=\"position: relative; z-index: 1;\"></div><div class=\"CodeMirror-code\" role=\"presentation\" style=\"\"><div class=\"CodeMirror-activeline\" style=\"position: relative;\"><div class=\"CodeMirror-activeline-background CodeMirror-linebackground\"></div><div class=\"CodeMirror-gutter-background CodeMirror-activeline-gutter\" style=\"left: 0px; width: 0px;\"></div><pre class=\" CodeMirror-line \" role=\"presentation\"><span role=\"presentation\" style=\"padding-right: 0.1px;\"><span class=\"cm-variable\">ClassLoader</span> <span class=\"cm-variable\">systemClassLoader</span> <span class=\"cm-operator\">=</span> <span class=\"cm-variable\">ClassLoader</span>.<span class=\"cm-variable\">getSystemClassLoader</span>();</span></pre></div><pre class=\" CodeMirror-line \" role=\"presentation\"><span role=\"presentation\" style=\"padding-right: 0.1px;\"><span class=\"cm-variable\">System</span>.<span class=\"cm-variable\">out</span>.<span class=\"cm-variable\">println</span>(<span class=\"cm-variable\">systemClassLoader</span>);<span class=\"cm-comment\">//sun.misc.Launcher$AppClassLoader@18b4aac2</span></span></pre><pre class=\" CodeMirror-line \" role=\"presentation\"><span role=\"presentation\" style=\"padding-right: 0.1px;\"><span cm-text=\"\">&#8203;</span></span></pre><pre class=\" CodeMirror-line \" role=\"presentation\"><span role=\"presentation\" style=\"padding-right: 0.1px;\"><span class=\"cm-variable\">ClassLoader</span> <span class=\"cm-variable\">extensionClassLoader</span> <span class=\"cm-operator\">=</span> <span class=\"cm-variable\">systemClassLoader</span>.<span class=\"cm-variable\">getParent</span>();</span></pre><pre class=\" CodeMirror-line \" role=\"presentation\"><span role=\"presentation\" style=\"padding-right: 0.1px;\"><span class=\"cm-variable\">System</span>.<span class=\"cm-variable\">out</span>.<span class=\"cm-variable\">println</span>(<span class=\"cm-variable\">extensionClassLoader</span>);<span class=\"cm-comment\">//sun.misc.Launcher$ExtClassLoader@1055e4af</span></span></pre><pre class=\" CodeMirror-line \" role=\"presentation\"><span role=\"presentation\" style=\"padding-right: 0.1px;\"><span cm-text=\"\">&#8203;</span></span></pre><pre class=\" CodeMirror-line \" role=\"presentation\"><span role=\"presentation\" style=\"padding-right: 0.1px;\"><span class=\"cm-variable\">ClassLoader</span> <span class=\"cm-variable\">bootStrapClassLoader</span> <span class=\"cm-operator\">=</span> <span class=\"cm-variable\">extensionClassLoader</span>.<span class=\"cm-variable\">getParent</span>();</span></pre><pre class=\" CodeMirror-line \" role=\"presentation\"><span role=\"presentation\" style=\"padding-right: 0.1px;\"><span class=\"cm-variable\">System</span>.<span class=\"cm-variable\">out</span>.<span class=\"cm-variable\">println</span>(<span class=\"cm-variable\">bootStrapClassLoader</span>);<span class=\"cm-comment\">//null</span></span></pre><pre class=\" CodeMirror-line \" role=\"presentation\"><span role=\"presentation\" style=\"padding-right: 0.1px;\"><span cm-text=\"\">&#8203;</span></span></pre><pre class=\" CodeMirror-line \" role=\"presentation\"><span role=\"presentation\" style=\"padding-right: 0.1px;\"><span class=\"cm-comment\">//自定义的类是由系统类加载器（System Class Loader）加载的</span></span></pre><pre class=\" CodeMirror-line \" role=\"presentation\"><span role=\"presentation\" style=\"padding-right: 0.1px;\"><span class=\"cm-variable\">ClassLoader</span> <span class=\"cm-variable\">classLoader</span> <span class=\"cm-operator\">=</span> <span class=\"cm-variable\">MyClassLoaderTest</span>.<span class=\"cm-keyword\">class</span>.<span class=\"cm-variable\">getClassLoader</span>();</span></pre><pre class=\" CodeMirror-line \" role=\"presentation\"><span role=\"presentation\" style=\"padding-right: 0.1px;\"><span class=\"cm-variable\">System</span>.<span class=\"cm-variable\">out</span>.<span class=\"cm-variable\">println</span>(<span class=\"cm-variable\">classLoader</span>);<span class=\"cm-comment\">//sun.misc.Launcher$AppClassLoader@18b4aac2</span></span></pre><pre class=\" CodeMirror-line \" role=\"presentation\"><span role=\"presentation\" style=\"padding-right: 0.1px;\"><span cm-text=\"\">&#8203;</span></span></pre><pre class=\" CodeMirror-line \" role=\"presentation\"><span role=\"presentation\" style=\"padding-right: 0.1px;\"><span class=\"cm-comment\">//系统核心类库是由引导类加载器（Bootstrap ClassLoader）加载</span></span></pre><pre class=\" CodeMirror-line \" role=\"presentation\"><span role=\"presentation\" style=\"padding-right: 0.1px;\"><span class=\"cm-variable\">ClassLoader</span> <span class=\"cm-variable\">stringClassLoader</span> <span class=\"cm-operator\">=</span> <span class=\"cm-variable-3\">String</span>.<span class=\"cm-keyword\">class</span>.<span class=\"cm-variable\">getClassLoader</span>();</span></pre><pre class=\" CodeMirror-line \" role=\"presentation\"><span role=\"presentation\" style=\"padding-right: 0.1px;\"><span class=\"cm-variable\">System</span>.<span class=\"cm-variable\">out</span>.<span class=\"cm-variable\">println</span>(<span class=\"cm-variable\">stringClassLoader</span>);<span class=\"cm-comment\">//null </span></span></pre></div></div></div></div></div><div style=\"position: absolute; height: 0px; width: 1px; border-bottom: 0px solid transparent; top: 416px;\"></div><div class=\"CodeMirror-gutters\" style=\"display: none; height: 416px;\"></div></div></div></pre><p>&nbsp;</p><p><strong><span>系统类自带的类加载器：</span></strong></p><ul><li><p><span>启动类加载器（引导类加载器 Bootstrap ClassLoader）</span></p><ul><li><span>这个类加载使用C/C++语言实现的，嵌套在JVM内部。</span></li><li><span>他用来加载Java的核心类库（JAVA_HOME/jre/lib/rt.jar、resource.jar、或sun.boot.class.path路径下的内容），用于提供JVM自身需要的类。</span></li><li><span>并不继承自java.lang.ClassLoader，没有父加载器。</span></li><li><span>加载扩展类和应用程序类加载器，并指定为他们的父类加载器。</span></li><li><span>出于安全考虑，Bootstrap启动类加载起之家在包名为java、javax、sun等开头的类</span></li></ul></li><li><p><span>扩展类加载器</span></p><ul><li><span>Java语言编写，由sun.misc.Launcher$ExtClassLoader实现。</span></li><li><span>派生于ClassLoader类。</span></li><li><span>父类加载器为启动类加载器。</span></li><li><span>从java.ext.dirs系统属性所指定的目录加载类库，或从JDK的安装目录的jre/lib/ext子目录下加载类库。如果用户创建的jar放在此目录下，也会由扩展类加载器加载。</span></li></ul></li><li><p><span>应用程序类加载器（系统类加载器 AppClassLoader）</span></p><ul><li><span>java语言编写，由sun.misc.Launcher$AppClassLoader实现。</span></li><li><span>派生于ClassLoader类。</span></li><li><span>父类加载器为扩展类加载器。</span></li><li><span>他负责加载环境变量classpath或系统属性java.class.path指定路径下的类库。</span></li><li><span>该类加载是程序中默认的类加载器，一般来说，Java应用的类都是由他来完成价在。</span></li><li><span>通过ClassLoader.getSystemClassLoader()方法可以获取到该类加载器。</span></li></ul></li></ul><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><h2><a name=\"视野扩展\" class=\"md-header-anchor\"></a><span>视野扩展</span></h2><p>&nbsp;</p><p><span>Java生态圈</span></p><p><span>		</span><span>Java是目前应用最为广泛的软件开发平台之一。随着Java以及Java社区的不断壮大，Java也早已不再是简简单单的一门计算机语言，它更是一个平台、一种文化、一个社区。</span></p><ul><li><p><span>作为一个平台，Java虚拟机扮演着举足轻重的作用。</span></p><ul><li><span>Groovy、Scala、JRuby、Kotlin等都是Java平台的一部分。</span></li></ul></li><li><p><span>作为一种文化，Java几乎成为了“开源”的代名词。</span></p><ul><li><span>第三方开源软件和框架。如Tomcat、Struts、MyBatis、Spring等.</span></li><li><span>就连JDK和JVM自身也有不少开源的实现，如OpenJDK、Harmony。</span></li></ul></li><li><p><span>作为一个社区，Java拥有全世界最多的技术拥护者和开源社区支持，有数不清的论坛和资料。从桌面应用软件、嵌入式开发到企业级应用、后台服务器、中间件，都可以看到Java的身影。其应用形式之复杂、参与人数之众多也令人咋舌。</span></p></li></ul><p><span>IT行业三大难题： CPU、编译器、操作系统</span></p><p><span>市场占用率最高的虚拟机：HotSpot、JRockit</span></p><p><span>jps命令：</span></p></div>\r\n\r\n</body>', 3, '', NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `tt_note` VALUES (4, 1, 'linux新机必备   ', 'index', '<table class=\"highlight tab-size js-file-line-container\" data-tab-size=\"8\" data-paste-markdown-skip=\"\">\r\n      <tbody><tr>\r\n        <td id=\"L1\" class=\"blob-num js-line-number\" data-line-number=\"1\"></td>\r\n        <td id=\"LC1\" class=\"blob-code blob-code-inner js-file-line\">&#65279;-----------------------------------------------------------------------------------------------------------------------------------------</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L2\" class=\"blob-num js-line-number\" data-line-number=\"2\"></td>\r\n        <td id=\"LC2\" class=\"blob-code blob-code-inner js-file-line\">-----------------------------------------------------------------------------------------------------------------------------------------</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L3\" class=\"blob-num js-line-number\" data-line-number=\"3\"></td>\r\n        <td id=\"LC3\" class=\"blob-code blob-code-inner js-file-line\">-----------------------------------------------------------------------------------------------------------------------------------------</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L4\" class=\"blob-num js-line-number\" data-line-number=\"4\"></td>\r\n        <td id=\"LC4\" class=\"blob-code blob-code-inner js-file-line\">-------------------------------------------------------centos7新机器初始化---------------------------------------------------------------</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L5\" class=\"blob-num js-line-number\" data-line-number=\"5\"></td>\r\n        <td id=\"LC5\" class=\"blob-code blob-code-inner js-file-line\">-----------------------------------------------------------------------------------------------------------------------------------------</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L6\" class=\"blob-num js-line-number\" data-line-number=\"6\"></td>\r\n        <td id=\"LC6\" class=\"blob-code blob-code-inner js-file-line\">-----------------------------------------------------------------------------------------------------------------------------------------</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L7\" class=\"blob-num js-line-number\" data-line-number=\"7\"></td>\r\n        <td id=\"LC7\" class=\"blob-code blob-code-inner js-file-line\">-----------------------------------------------------------------------------------------------------------------------------------------</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L8\" class=\"blob-num js-line-number\" data-line-number=\"8\"></td>\r\n        <td id=\"LC8\" class=\"blob-code blob-code-inner js-file-line\">-----------------------------------------------------------------------------------------------------------------------------------------</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L9\" class=\"blob-num js-line-number\" data-line-number=\"9\"></td>\r\n        <td id=\"LC9\" class=\"blob-code blob-code-inner js-file-line\">\r\n</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L10\" class=\"blob-num js-line-number\" data-line-number=\"10\"></td>\r\n        <td id=\"LC10\" class=\"blob-code blob-code-inner js-file-line\">----初次使用c7时</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L11\" class=\"blob-num js-line-number\" data-line-number=\"11\"></td>\r\n        <td id=\"LC11\" class=\"blob-code blob-code-inner js-file-line\">----centos7修改动态IP为静态</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L12\" class=\"blob-num js-line-number\" data-line-number=\"12\"></td>\r\n        <td id=\"LC12\" class=\"blob-code blob-code-inner js-file-line\">	首先查看VMware中设置的动态ip起止范围，以免设置冲突</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L13\" class=\"blob-num js-line-number\" data-line-number=\"13\"></td>\r\n        <td id=\"LC13\" class=\"blob-code blob-code-inner js-file-line\">	</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L14\" class=\"blob-num js-line-number\" data-line-number=\"14\"></td>\r\n        <td id=\"LC14\" class=\"blob-code blob-code-inner js-file-line\">	vi /etc/sysconfig/network-scripts/ifcfg-（一般第一个）</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L15\" class=\"blob-num js-line-number\" data-line-number=\"15\"></td>\r\n        <td id=\"LC15\" class=\"blob-code blob-code-inner js-file-line\">\r\n</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L16\" class=\"blob-num js-line-number\" data-line-number=\"16\"></td>\r\n        <td id=\"LC16\" class=\"blob-code blob-code-inner js-file-line\">	这里说一下需要修改的位置:</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L17\" class=\"blob-num js-line-number\" data-line-number=\"17\"></td>\r\n        <td id=\"LC17\" class=\"blob-code blob-code-inner js-file-line\">	#修改</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L18\" class=\"blob-num js-line-number\" data-line-number=\"18\"></td>\r\n        <td id=\"LC18\" class=\"blob-code blob-code-inner js-file-line\">	BOOTPROTO=static #这里讲dhcp换成static</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L19\" class=\"blob-num js-line-number\" data-line-number=\"19\"></td>\r\n        <td id=\"LC19\" class=\"blob-code blob-code-inner js-file-line\">	ONBOOT=yes #将no换成yes（如果no  使用yum安装时会报 Error: cannot find a valid baseurl or repo:base）</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L20\" class=\"blob-num js-line-number\" data-line-number=\"20\"></td>\r\n        <td id=\"LC20\" class=\"blob-code blob-code-inner js-file-line\">	#新增</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L21\" class=\"blob-num js-line-number\" data-line-number=\"21\"></td>\r\n        <td id=\"LC21\" class=\"blob-code blob-code-inner js-file-line\">	IPADDR=192.168.100.200 #静态IP</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L22\" class=\"blob-num js-line-number\" data-line-number=\"22\"></td>\r\n        <td id=\"LC22\" class=\"blob-code blob-code-inner js-file-line\">	GATEWAY=192.168.100.2 #默认网关</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L23\" class=\"blob-num js-line-number\" data-line-number=\"23\"></td>\r\n        <td id=\"LC23\" class=\"blob-code blob-code-inner js-file-line\">	NETMASK=255.255.255.0 #子网掩码</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L24\" class=\"blob-num js-line-number\" data-line-number=\"24\"></td>\r\n        <td id=\"LC24\" class=\"blob-code blob-code-inner js-file-line\">	DNS1=8.8.8.8 #dns配置 解析域名</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L25\" class=\"blob-num js-line-number\" data-line-number=\"25\"></td>\r\n        <td id=\"LC25\" class=\"blob-code blob-code-inner js-file-line\">	保存退出后,重启网络服务:</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L26\" class=\"blob-num js-line-number\" data-line-number=\"26\"></td>\r\n        <td id=\"LC26\" class=\"blob-code blob-code-inner js-file-line\">	# service network restart</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L27\" class=\"blob-num js-line-number\" data-line-number=\"27\"></td>\r\n        <td id=\"LC27\" class=\"blob-code blob-code-inner js-file-line\">	</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L28\" class=\"blob-num js-line-number\" data-line-number=\"28\"></td>\r\n        <td id=\"LC28\" class=\"blob-code blob-code-inner js-file-line\">	此时就可以使用远程工具连接了（centos7默认有）</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L29\" class=\"blob-num js-line-number\" data-line-number=\"29\"></td>\r\n        <td id=\"LC29\" class=\"blob-code blob-code-inner js-file-line\">\r\n</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L30\" class=\"blob-num js-line-number\" data-line-number=\"30\"></td>\r\n        <td id=\"LC30\" class=\"blob-code blob-code-inner js-file-line\">\r\n</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L31\" class=\"blob-num js-line-number\" data-line-number=\"31\"></td>\r\n        <td id=\"LC31\" class=\"blob-code blob-code-inner js-file-line\">----使用yum命令进行安装软件可能会报这些错误</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L32\" class=\"blob-num js-line-number\" data-line-number=\"32\"></td>\r\n        <td id=\"LC32\" class=\"blob-code blob-code-inner js-file-line\">----Cannot find a valid baseurl for repo: base/7/x86_64</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L33\" class=\"blob-num js-line-number\" data-line-number=\"33\"></td>\r\n        <td id=\"LC33\" class=\"blob-code blob-code-inner js-file-line\">----\"Could not resolve host: mirrorlist.centos.org; Unknown error\"的解决方法</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L34\" class=\"blob-num js-line-number\" data-line-number=\"34\"></td>\r\n        <td id=\"LC34\" class=\"blob-code blob-code-inner js-file-line\">	这是因为域名解析不了，修改配置</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L35\" class=\"blob-num js-line-number\" data-line-number=\"35\"></td>\r\n        <td id=\"LC35\" class=\"blob-code blob-code-inner js-file-line\">	vi /etc/resolv.conf</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L36\" class=\"blob-num js-line-number\" data-line-number=\"36\"></td>\r\n        <td id=\"LC36\" class=\"blob-code blob-code-inner js-file-line\">	然后添加</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L37\" class=\"blob-num js-line-number\" data-line-number=\"37\"></td>\r\n        <td id=\"LC37\" class=\"blob-code blob-code-inner js-file-line\">	nameserver 8.8.8.8 </td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L38\" class=\"blob-num js-line-number\" data-line-number=\"38\"></td>\r\n        <td id=\"LC38\" class=\"blob-code blob-code-inner js-file-line\">	nameserver 8.8.4.4 </td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L39\" class=\"blob-num js-line-number\" data-line-number=\"39\"></td>\r\n        <td id=\"LC39\" class=\"blob-code blob-code-inner js-file-line\">	serchdomain root</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L40\" class=\"blob-num js-line-number\" data-line-number=\"40\"></td>\r\n        <td id=\"LC40\" class=\"blob-code blob-code-inner js-file-line\">\r\n</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L41\" class=\"blob-num js-line-number\" data-line-number=\"41\"></td>\r\n        <td id=\"LC41\" class=\"blob-code blob-code-inner js-file-line\">----centos7下使用yum安装ifconfig、wget等工具(yum search 要安装的工具   来搜索)</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L42\" class=\"blob-num js-line-number\" data-line-number=\"42\"></td>\r\n        <td id=\"LC42\" class=\"blob-code blob-code-inner js-file-line\">	yum search ifconfig</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L43\" class=\"blob-num js-line-number\" data-line-number=\"43\"></td>\r\n        <td id=\"LC43\" class=\"blob-code blob-code-inner js-file-line\">	yum install net-tools.x86_64</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L44\" class=\"blob-num js-line-number\" data-line-number=\"44\"></td>\r\n        <td id=\"LC44\" class=\"blob-code blob-code-inner js-file-line\">	</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L45\" class=\"blob-num js-line-number\" data-line-number=\"45\"></td>\r\n        <td id=\"LC45\" class=\"blob-code blob-code-inner js-file-line\">	yum search wget</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L46\" class=\"blob-num js-line-number\" data-line-number=\"46\"></td>\r\n        <td id=\"LC46\" class=\"blob-code blob-code-inner js-file-line\">	yum install wget.x86_64</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L47\" class=\"blob-num js-line-number\" data-line-number=\"47\"></td>\r\n        <td id=\"LC47\" class=\"blob-code blob-code-inner js-file-line\">	</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L48\" class=\"blob-num js-line-number\" data-line-number=\"48\"></td>\r\n        <td id=\"LC48\" class=\"blob-code blob-code-inner js-file-line\">	</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L49\" class=\"blob-num js-line-number\" data-line-number=\"49\"></td>\r\n        <td id=\"LC49\" class=\"blob-code blob-code-inner js-file-line\">----CentOS7使用firewalld打开关闭防火墙与端口	</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L50\" class=\"blob-num js-line-number\" data-line-number=\"50\"></td>\r\n        <td id=\"LC50\" class=\"blob-code blob-code-inner js-file-line\">	1、firewalld的基本使用</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L51\" class=\"blob-num js-line-number\" data-line-number=\"51\"></td>\r\n        <td id=\"LC51\" class=\"blob-code blob-code-inner js-file-line\">		启    动：systemctl start firewalld</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L52\" class=\"blob-num js-line-number\" data-line-number=\"52\"></td>\r\n        <td id=\"LC52\" class=\"blob-code blob-code-inner js-file-line\">		关	  闭：systemctl stop firewalld</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L53\" class=\"blob-num js-line-number\" data-line-number=\"53\"></td>\r\n        <td id=\"LC53\" class=\"blob-code blob-code-inner js-file-line\">		查看状态：systemctl status firewalld </td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L54\" class=\"blob-num js-line-number\" data-line-number=\"54\"></td>\r\n        <td id=\"LC54\" class=\"blob-code blob-code-inner js-file-line\">		开机禁用：systemctl disable firewalld</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L55\" class=\"blob-num js-line-number\" data-line-number=\"55\"></td>\r\n        <td id=\"LC55\" class=\"blob-code blob-code-inner js-file-line\">		开机启用：systemctl enable firewalld</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L56\" class=\"blob-num js-line-number\" data-line-number=\"56\"></td>\r\n        <td id=\"LC56\" class=\"blob-code blob-code-inner js-file-line\">	2、对端口操作命令</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L57\" class=\"blob-num js-line-number\" data-line-number=\"57\"></td>\r\n        <td id=\"LC57\" class=\"blob-code blob-code-inner js-file-line\">		添	  加：firewall-cmd --zone=public --add-port=80/tcp --permanent    （--permanent永久生效，没有此参数重启后失效）</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L58\" class=\"blob-num js-line-number\" data-line-number=\"58\"></td>\r\n        <td id=\"LC58\" class=\"blob-code blob-code-inner js-file-line\">		重新载入：firewall-cmd --reload</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L59\" class=\"blob-num js-line-number\" data-line-number=\"59\"></td>\r\n        <td id=\"LC59\" class=\"blob-code blob-code-inner js-file-line\">		查    看：firewall-cmd --zone= public --query-port=80/tcp</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L60\" class=\"blob-num js-line-number\" data-line-number=\"60\"></td>\r\n        <td id=\"LC60\" class=\"blob-code blob-code-inner js-file-line\">		删    除：firewall-cmd --zone= public --remove-port=80/tcp --permanent</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L61\" class=\"blob-num js-line-number\" data-line-number=\"61\"></td>\r\n        <td id=\"LC61\" class=\"blob-code blob-code-inner js-file-line\">\r\n</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L62\" class=\"blob-num js-line-number\" data-line-number=\"62\"></td>\r\n        <td id=\"LC62\" class=\"blob-code blob-code-inner js-file-line\">		</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L63\" class=\"blob-num js-line-number\" data-line-number=\"63\"></td>\r\n        <td id=\"LC63\" class=\"blob-code blob-code-inner js-file-line\">----centos7 telnet安装与使用</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L64\" class=\"blob-num js-line-number\" data-line-number=\"64\"></td>\r\n        <td id=\"LC64\" class=\"blob-code blob-code-inner js-file-line\">	先检查是否安装: telnet-server和xinetd</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L65\" class=\"blob-num js-line-number\" data-line-number=\"65\"></td>\r\n        <td id=\"LC65\" class=\"blob-code blob-code-inner js-file-line\">		rpm -qa telnet-server</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L66\" class=\"blob-num js-line-number\" data-line-number=\"66\"></td>\r\n        <td id=\"LC66\" class=\"blob-code blob-code-inner js-file-line\">		rpm -qa xinetd</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L67\" class=\"blob-num js-line-number\" data-line-number=\"67\"></td>\r\n        <td id=\"LC67\" class=\"blob-code blob-code-inner js-file-line\">	如果没有安装，则安装：</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L68\" class=\"blob-num js-line-number\" data-line-number=\"68\"></td>\r\n        <td id=\"LC68\" class=\"blob-code blob-code-inner js-file-line\">		查看可安装的telnet： yum list |grep telnet</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L69\" class=\"blob-num js-line-number\" data-line-number=\"69\"></td>\r\n        <td id=\"LC69\" class=\"blob-code blob-code-inner js-file-line\">			telnet.x86_64                               1:0.17-64.el7              base     </td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L70\" class=\"blob-num js-line-number\" data-line-number=\"70\"></td>\r\n        <td id=\"LC70\" class=\"blob-code blob-code-inner js-file-line\">			telnet-server.x86_64                        1:0.17-64.el7              base </td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L71\" class=\"blob-num js-line-number\" data-line-number=\"71\"></td>\r\n        <td id=\"LC71\" class=\"blob-code blob-code-inner js-file-line\">		查看可安装的xinetd： yum list |grep xinetd</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L72\" class=\"blob-num js-line-number\" data-line-number=\"72\"></td>\r\n        <td id=\"LC72\" class=\"blob-code blob-code-inner js-file-line\">			xinetd.x86_64                               2:2.3.15-13.el7            base  </td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L73\" class=\"blob-num js-line-number\" data-line-number=\"73\"></td>\r\n        <td id=\"LC73\" class=\"blob-code blob-code-inner js-file-line\">	执行安装：</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L74\" class=\"blob-num js-line-number\" data-line-number=\"74\"></td>\r\n        <td id=\"LC74\" class=\"blob-code blob-code-inner js-file-line\">		yum -y install telnet-server.x86_64</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L75\" class=\"blob-num js-line-number\" data-line-number=\"75\"></td>\r\n        <td id=\"LC75\" class=\"blob-code blob-code-inner js-file-line\">		yum -y install telnet.x86_64</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L76\" class=\"blob-num js-line-number\" data-line-number=\"76\"></td>\r\n        <td id=\"LC76\" class=\"blob-code blob-code-inner js-file-line\">		yum -y install xinetd.x86_64</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L77\" class=\"blob-num js-line-number\" data-line-number=\"77\"></td>\r\n        <td id=\"LC77\" class=\"blob-code blob-code-inner js-file-line\">	</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L78\" class=\"blob-num js-line-number\" data-line-number=\"78\"></td>\r\n        <td id=\"LC78\" class=\"blob-code blob-code-inner js-file-line\">	</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L79\" class=\"blob-num js-line-number\" data-line-number=\"79\"></td>\r\n        <td id=\"LC79\" class=\"blob-code blob-code-inner js-file-line\">	</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L80\" class=\"blob-num js-line-number\" data-line-number=\"80\"></td>\r\n        <td id=\"LC80\" class=\"blob-code blob-code-inner js-file-line\">	</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L81\" class=\"blob-num js-line-number\" data-line-number=\"81\"></td>\r\n        <td id=\"LC81\" class=\"blob-code blob-code-inner js-file-line\">	</td>\r\n      </tr>\r\n      <tr>\r\n        <td id=\"L82\" class=\"blob-num js-line-number\" data-line-number=\"82\"></td>\r\n        <td id=\"LC82\" class=\"blob-code blob-code-inner js-file-line\">	</td>\r\n      </tr>\r\n</tbody>\r\n</table>', 3, '', NULL, NULL, NULL, NULL, NULL, NULL, 0);
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
-- Table structure for tt_remind_me
-- ----------------------------
DROP TABLE IF EXISTS `tt_remind_me`;
CREATE TABLE `tt_remind_me` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `app_name` varchar(15) COLLATE utf8mb4_bin NOT NULL COMMENT 'APP名字',
  `account` varchar(60) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '账号',
  `mail` varchar(60) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '邮箱',
  `sort_num` int(11) DEFAULT NULL COMMENT '排序号',
  `oath_pass` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='备忘';

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
INSERT INTO `tt_task` VALUES (2, 'remind', '定时提醒', '0 15 20 ? * *', 'helper.quartz.ExecuteJob', '0', 'group', 'http://localhost:9000/menstruation/taskMenstruationRemind', 0, NULL, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for tt_test_batch
-- ----------------------------
DROP TABLE IF EXISTS `tt_test_batch`;
CREATE TABLE `tt_test_batch` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='批量插入测试';

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户信息表';

-- ----------------------------
-- Records of tt_user
-- ----------------------------
BEGIN;
INSERT INTO `tt_user` VALUES (1, '管理员', '管理员', NULL, NULL, NULL, NULL, NULL, '2030503816@qq.com', '10f935e22379d4547610781a6381a03d', NULL, 1, -1, '系统管理', '2020-01-05 18:22:08', NULL, NULL, NULL, 0);
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户信息表';

-- ----------------------------
-- Records of tt_user_login
-- ----------------------------
BEGIN;
INSERT INTO `tt_user_login` VALUES (1, 1, '2020-07-15 12:11:37', '127.0.0.1', NULL, -1, '系统管理', '2020-07-15 12:11:37', NULL, NULL, NULL, 0);
INSERT INTO `tt_user_login` VALUES (2, 1, '2020-07-16 17:02:52', '127.0.0.1', NULL, -1, '系统管理', '2020-07-16 17:02:52', NULL, NULL, NULL, 0);
INSERT INTO `tt_user_login` VALUES (3, 2, '2020-07-16 17:28:24', '0:0:0:0:0:0:0:1', NULL, -1, '系统管理', '2020-07-16 17:28:24', NULL, NULL, NULL, 0);
INSERT INTO `tt_user_login` VALUES (4, 3, '2020-07-16 18:29:40', '0:0:0:0:0:0:0:1', NULL, -1, '系统管理', '2020-07-16 18:29:40', NULL, NULL, NULL, 0);
INSERT INTO `tt_user_login` VALUES (5, 3, '2020-07-16 18:45:06', '127.0.0.1', NULL, -1, '系统管理', '2020-07-16 18:45:06', NULL, NULL, NULL, 0);
INSERT INTO `tt_user_login` VALUES (6, 3, '2020-07-16 18:46:11', '127.0.0.1', NULL, -1, '系统管理', '2020-07-16 18:46:11', NULL, NULL, NULL, 0);
INSERT INTO `tt_user_login` VALUES (7, 3, '2020-07-16 18:48:12', '127.0.0.1', NULL, -1, '系统管理', '2020-07-16 18:48:12', NULL, NULL, NULL, 0);
INSERT INTO `tt_user_login` VALUES (8, 1, '2020-07-16 18:57:25', '127.0.0.1', NULL, -1, '系统管理', '2020-07-16 18:57:25', NULL, NULL, NULL, 0);
INSERT INTO `tt_user_login` VALUES (9, 3, '2020-07-16 19:02:42', '127.0.0.1', NULL, -1, '系统管理', '2020-07-16 19:02:42', NULL, NULL, NULL, 0);
INSERT INTO `tt_user_login` VALUES (10, 3, '2020-07-16 19:17:36', '127.0.0.1', NULL, -1, '系统管理', '2020-07-16 19:17:36', NULL, NULL, NULL, 0);
INSERT INTO `tt_user_login` VALUES (11, 1, '2020-07-16 21:04:55', '0:0:0:0:0:0:0:1', NULL, -1, '系统管理', '2020-07-16 21:04:55', NULL, NULL, NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for 软考模拟记录
-- ----------------------------
DROP TABLE IF EXISTS `软考模拟记录`;
CREATE TABLE `软考模拟记录` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `试卷名字` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `分数` int(11) NOT NULL,
  `所在页数或地址` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '考试模拟所在页数/地址',
  `试题来源` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT '希赛' COMMENT '1:希赛 2:考试冲刺 3:32小时通关',
  `考点` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `难点` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `是否掌握` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT '否',
  `创建时间` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='软考学习--模拟分数记录';

-- ----------------------------
-- Records of 软考模拟记录
-- ----------------------------
BEGIN;
INSERT INTO `软考模拟记录` VALUES (1, '2020年08月22日软件设计师每日一练', 50, 'https://uc.educity.cn/tiku/testReport.html?id=8510816', '希赛', 'UML、前驱图与PV信号量、海明码、排序算法、RUP生命周期', NULL, '否', '2020-08-22 12:02:01');
INSERT INTO `软考模拟记录` VALUES (2, '可靠性之失效率计算', 0, 'p50', '教材', '失效率', NULL, '否', '2020-08-22 15:29:41');
INSERT INTO `软考模拟记录` VALUES (3, '2020年08月23日软件设计师每日一练', 60, 'https://uc.educity.cn/tiku/testReport.html?id=8531171', '希赛', NULL, NULL, '否', '2020-08-23 12:29:24');
INSERT INTO `软考模拟记录` VALUES (4, '2020年08月24日软件设计师每日一练', 70, 'https://www.educity.cn/tiku/dp30086537.html', '希赛', '手机病毒、编译（语义、语法错误概念）、页断裂（图文理解）', NULL, '否', '2020-08-24 09:46:14');
INSERT INTO `软考模拟记录` VALUES (5, '2020年08月25日软件设计师每日一练', 50, NULL, '希赛', NULL, NULL, '否', '2020-08-25 12:15:49');
INSERT INTO `软考模拟记录` VALUES (6, '2020年08月27日软件设计师每日一练', 35, NULL, '希赛', NULL, NULL, '否', '2020-08-27 21:18:35');
INSERT INTO `软考模拟记录` VALUES (7, '2020年08月27日软件设计师每日一练', 80, 'https://uc.educity.cn/tiku/testReport.html?id=8784851', '希赛', NULL, NULL, '否', '2020-09-01 15:13:34');
INSERT INTO `软考模拟记录` VALUES (8, '2020年09月01日软件设计师每日一练', 75, NULL, '希赛', NULL, NULL, '否', '2020-09-03 15:55:49');
INSERT INTO `软考模拟记录` VALUES (9, '2020年09月02日软件设计师每日一练', 68, 'https://uc.educity.cn/tiku/testReport.html?id=8859431', '希赛', NULL, NULL, '否', '2020-09-03 17:30:43');
INSERT INTO `软考模拟记录` VALUES (10, '2020年09月04日软件设计师每日一练', 80, 'https://uc.educity.cn/tiku/testReport.html?id=9156591', '希赛', '霍夫曼编码、线性表循环单链、白盒测试用例', '霍夫曼编码-0,循环单链-1', '否', '2020-09-12 10:33:35');
INSERT INTO `软考模拟记录` VALUES (11, '12020年09月05日软件设计师每日一练', 60, 'https://uc.educity.cn/tiku/testReport.html?id=9169230', '希赛', '排序算法比较、移码补码、运算器与控制器、文法、自然连接', '移码补码-1,', '否', '2020-09-12 10:37:08');
INSERT INTO `软考模拟记录` VALUES (12, '2020年09月06日软件设计师每日一练', 85, 'https://uc.educity.cn/tiku/testReport.html?id=9193468', '希赛', 'DNS域名解析过程、UML之状态图', 'UML状态图-1,', '否', '2020-09-13 09:23:04');
INSERT INTO `软考模拟记录` VALUES (13, '2020年09月07日软件设计师每日一练', 54, 'https://uc.educity.cn/tiku/testReport.html?id=9198855', '希赛', '开发模型、专业英语、信号量、索引文件、面向对象概念、范式', '专业英语-1,信号量-1', '否', '2020-09-13 11:31:51');
INSERT INTO `软考模拟记录` VALUES (14, '2020年10月01日软件设计师每日一练', 80, 'https://uc.educity.cn/tiku/testReport.html?id=9788121', '希赛', '病毒分类(引导区病毒、宏病毒、木马病毒、蠕虫病毒)、软件测试', NULL, '否', '2020-10-01 10:38:02');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
