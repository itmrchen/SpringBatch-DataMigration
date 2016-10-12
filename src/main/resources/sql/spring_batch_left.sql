/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : spring_batch_left

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2016-10-12 12:33:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_from
-- ----------------------------
DROP TABLE IF EXISTS `user_from`;
CREATE TABLE `user_from` (
  `id` bigint(20) NOT NULL auto_increment COMMENT '主键id',
  `user_name` varchar(64) default '' COMMENT '用户名',
  `sex` int(4) default '0' COMMENT '性别（0：男，1：女）',
  `age` int(4) default '0' COMMENT '年龄',
  `address` varchar(128) default '' COMMENT '地址',
  `create_time` datetime default NULL COMMENT '创建时间',
  `update_time` datetime default NULL COMMENT '更新时间',
  `status` int(2) default '1' COMMENT '状态（0：无效，1：有效）',
  `remark` varchar(64) default '' COMMENT '备注',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_from
-- ----------------------------
INSERT INTO `user_from` VALUES ('1', 'lily', '1', '12', 'beijiing', '2016-10-12 12:27:11', '2016-10-12 12:27:13', '1', '');
INSERT INTO `user_from` VALUES ('2', 'lily', '1', '1', 'beijiing', '2016-10-12 12:27:11', '2016-10-12 12:27:13', '1', '');
INSERT INTO `user_from` VALUES ('3', 'lily', '1', '1', 'beijiing', '2016-10-12 12:27:11', '2016-10-12 12:27:13', '1', '');
INSERT INTO `user_from` VALUES ('4', 'lily', '1', '1', 'beijiing', '2016-10-12 12:27:11', '2016-10-12 12:27:13', '1', '');
INSERT INTO `user_from` VALUES ('5', 'lily', '1', '22', 'beijiing', '2016-10-12 12:27:11', '2016-10-12 12:27:13', '1', '');
INSERT INTO `user_from` VALUES ('6', 'lily', '1', '22', 'beijiing', '2016-10-12 12:27:11', '2016-10-12 12:27:13', '1', '');
INSERT INTO `user_from` VALUES ('7', 'lily', '1', '22', 'beijiing', '2016-10-12 12:27:11', '2016-10-12 12:27:13', '1', '');
INSERT INTO `user_from` VALUES ('8', 'lily', '1', '22', 'beijiing', '2016-10-12 12:27:11', '2016-10-12 12:27:13', '1', '');
INSERT INTO `user_from` VALUES ('9', 'lily', '1', '22', 'beijiing', '2016-10-12 12:27:11', '2016-10-12 12:27:13', '1', '');
INSERT INTO `user_from` VALUES ('10', 'lily', '1', '22', 'beijiing', '2016-10-12 12:27:11', '2016-10-12 12:27:13', '1', '');
INSERT INTO `user_from` VALUES ('11', 'lily', '1', '22', 'beijiing', '2016-10-12 12:27:11', '2016-10-12 12:27:13', '1', '');
INSERT INTO `user_from` VALUES ('12', 'lily', '1', '22', 'beijiing', '2016-10-12 12:27:11', '2016-10-12 12:27:13', '1', '');
INSERT INTO `user_from` VALUES ('13', 'lily', '1', '22', 'beijiing', '2016-10-12 12:27:11', '2016-10-12 12:27:13', '1', '');
INSERT INTO `user_from` VALUES ('14', 'lily', '1', '22', 'beijiing', '2016-10-12 12:27:11', '2016-10-12 12:27:13', '1', '');
INSERT INTO `user_from` VALUES ('15', 'lily', '1', '22', 'beijiing', '2016-10-12 12:27:11', '2016-10-12 12:27:13', '1', '');
INSERT INTO `user_from` VALUES ('16', 'lily', '1', '22', 'beijiing', '2016-10-12 12:27:11', '2016-10-12 12:27:13', '1', '');
INSERT INTO `user_from` VALUES ('17', 'lily', '1', '22', 'beijiing', '2016-10-12 12:27:11', '2016-10-12 12:27:13', '1', '');
INSERT INTO `user_from` VALUES ('18', 'lily', '1', '22', 'beijiing', '2016-10-12 12:27:11', '2016-10-12 12:27:13', '1', '');
INSERT INTO `user_from` VALUES ('19', 'lily', '1', '22', 'beijiing', '2016-10-12 12:27:11', '2016-10-12 12:27:13', '1', '');
INSERT INTO `user_from` VALUES ('20', 'lily', '1', '22', 'beijiing', '2016-10-12 12:27:11', '2016-10-12 12:27:13', '1', '');
INSERT INTO `user_from` VALUES ('21', 'lily', '1', '22', 'beijiing', '2016-10-12 12:27:11', '2016-10-12 12:27:13', '1', '');
INSERT INTO `user_from` VALUES ('22', 'lily', '1', '22', 'beijiing', '2016-10-12 12:27:11', '2016-10-12 12:27:13', '1', '');
INSERT INTO `user_from` VALUES ('23', 'lily', '1', '22', 'beijiing', '2016-10-12 12:27:11', '2016-10-12 12:27:13', '1', '');
INSERT INTO `user_from` VALUES ('24', 'lily', '1', '22', 'beijiing', '2016-10-12 12:27:11', '2016-10-12 12:27:13', '1', '');
INSERT INTO `user_from` VALUES ('25', 'lily', '1', '22', 'beijiing', '2016-10-12 12:27:11', '2016-10-12 12:27:13', '1', '');
INSERT INTO `user_from` VALUES ('26', 'lily', '1', '22', 'beijiing', '2016-10-12 12:27:11', '2016-10-12 12:27:13', '1', '');
