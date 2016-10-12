/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : spring_batch_right

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2016-10-12 19:24:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_to
-- ----------------------------
DROP TABLE IF EXISTS `user_to`;
CREATE TABLE `user_to` (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `user_name` varchar(64) default '' COMMENT '用户名',
  `sex` int(4) default '0' COMMENT '性别（0：男，1：女）',
  `age` int(4) default '0' COMMENT '年龄',
  `address` varchar(128) default '' COMMENT '地址',
  `create_time` datetime default NULL COMMENT '创建时间',
  `update_time` datetime default NULL COMMENT '更新时间',
  `status` int(2) default '1' COMMENT '状态（0：无效，1：有效）',
  `remark` varchar(64) default '' COMMENT '备注'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
