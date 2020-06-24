/*
 Navicat Premium Data Transfer

 Source Server         : 3.239(root)
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : 192.168.3.239:3306
 Source Schema         : roletestdb

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 24/06/2020 15:59:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dim_account
-- ----------------------------
DROP TABLE IF EXISTS `dim_account`;
CREATE TABLE `dim_account`  (
  `aID` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `loginName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `passWord` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `eMail` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '邮箱',
  `realName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '真实姓名',
  `active` tinyint(3) UNSIGNED NULL DEFAULT 1,
  `createDateTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `createAid` int(10) UNSIGNED NULL DEFAULT 0,
  `headImg` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '头像',
  PRIMARY KEY (`aID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dim_account
-- ----------------------------
INSERT INTO `dim_account` VALUES (1, 'dave', '123', '1@qq.com', '芦苇', 1, '2020-06-06 13:42:18', 0, NULL);
INSERT INTO `dim_account` VALUES (2, 'admin', '123', '2@qq.com', '管理员', 1, '2020-06-09 15:41:26', 0, NULL);
INSERT INTO `dim_account` VALUES (3, 'user1', '123', '3@qq.com', '普通用户', 1, '2020-06-09 15:41:47', 0, NULL);

-- ----------------------------
-- Table structure for dim_menu
-- ----------------------------
DROP TABLE IF EXISTS `dim_menu`;
CREATE TABLE `dim_menu`  (
  `menuID` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `menuName` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `menuDesc` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '菜单描述',
  `url` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单链接',
  `icon` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '菜单图标',
  `class` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT 'class样式名称',
  `level` tinyint(3) UNSIGNED NOT NULL COMMENT '菜单等级',
  `parentID` smallint(5) UNSIGNED NOT NULL COMMENT '父元素ID, 默认为0',
  `active` tinyint(3) UNSIGNED NOT NULL DEFAULT 1 COMMENT '0 无效，1 有效，9 删除',
  `createUid` int(11) UNSIGNED NOT NULL COMMENT '创建人',
  `createDateTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `lastUpdateUid` int(11) UNSIGNED NULL DEFAULT 0 COMMENT '最后修改人',
  `lastUpdateDateTime` timestamp(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`menuID`) USING BTREE,
  UNIQUE INDEX `url`(`url`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 67 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dim_menu
-- ----------------------------
INSERT INTO `dim_menu` VALUES (1, '产品', '', '/product', 'el-icon-present', '', 1, 0, 1, 1, '2020-04-21 15:12:02', 0, NULL);
INSERT INTO `dim_menu` VALUES (2, '进货', '', '/productin2', 'el-icon-sell', '', 1, 0, 1, 1, '2020-04-21 15:23:30', 0, NULL);
INSERT INTO `dim_menu` VALUES (3, '销售', '', '/sale', 'el-icon-shopping-cart-full', '', 1, 0, 1, 1, '2020-04-21 15:24:05', 0, NULL);
INSERT INTO `dim_menu` VALUES (4, '库存', '', '/kucun', 'el-icon-coin', '', 1, 0, 1, 1, '2020-04-21 15:24:34', 0, NULL);
INSERT INTO `dim_menu` VALUES (5, '资产', '', '/menu', 'el-icon-box', '', 1, 0, 1, 1, '2020-04-21 14:13:21', 0, NULL);
INSERT INTO `dim_menu` VALUES (6, '系统', '', '/sys', 'el-icon-setting', '', 1, 0, 1, 1, '2020-04-21 15:24:54', 0, NULL);
INSERT INTO `dim_menu` VALUES (11, '产品管理', '', '/productmanagement', 'icon-news-1', '', 2, 1, 1, 1, '2020-04-23 14:10:54', 0, NULL);
INSERT INTO `dim_menu` VALUES (12, '套包管理', '', '/productSetdetail', 'icon-news-1', '', 2, 1, 1, 1, '2020-04-23 14:13:26', 0, NULL);
INSERT INTO `dim_menu` VALUES (21, '录入进货', '', '/factSellInStock', 'icon-news-1', '', 2, 2, 1, 1, '2020-04-24 09:07:45', 0, NULL);
INSERT INTO `dim_menu` VALUES (22, '进货单管理', '', '/factSellIn', 'icon-news-1', '', 2, 2, 1, 1, '2020-04-24 09:09:13', 0, NULL);
INSERT INTO `dim_menu` VALUES (23, '进货明细', '', '/factSellIndetail', 'icon-news-1', '', 2, 2, 1, 1, '2020-04-24 09:10:15', 0, NULL);
INSERT INTO `dim_menu` VALUES (24, '扫描进货', '', '/factSellInScanningIn', 'icon-news-1', '', 2, 2, 1, 1, '2020-05-08 10:21:17', 0, NULL);
INSERT INTO `dim_menu` VALUES (31, '销售出库', '', '/saleOut', 'icon-news-1', '', 2, 3, 1, 1, '2020-05-20 17:44:10', 0, NULL);
INSERT INTO `dim_menu` VALUES (32, '销售明细', '', '/saleDetailde', 'icon-news-1', '', 2, 3, 1, 1, '2020-05-21 16:20:42', 0, NULL);
INSERT INTO `dim_menu` VALUES (33, '销售管理', '', '/saleManagement', 'icon-news-1', '', 2, 3, 1, 1, '2020-05-21 16:21:22', 0, NULL);
INSERT INTO `dim_menu` VALUES (34, '销售草稿', '', '/saleDraft', 'icon-news-1', '', 2, 3, 1, 1, '2020-05-21 16:22:01', 0, NULL);
INSERT INTO `dim_menu` VALUES (51, '仓库管理', '', '/warehousemanagement', 'icon-news-1', '', 2, 5, 1, 1, '2020-04-26 14:46:28', 0, NULL);
INSERT INTO `dim_menu` VALUES (61, '用户管理', '', '/privilegemanagement', 'icon-news-1', '', 2, 6, 1, 1, '2020-04-23 15:04:43', 0, NULL);
INSERT INTO `dim_menu` VALUES (63, '进货草稿', '', '/factSellIndraft', 'icon-news-1', '', 2, 2, 1, 1, '2020-04-27 16:56:30', 0, NULL);
INSERT INTO `dim_menu` VALUES (64, '往来单位', '', '/purchaseCompany', 'icon-news-1', '', 2, 5, 1, 1, '2020-04-28 09:10:12', 0, NULL);
INSERT INTO `dim_menu` VALUES (66, '库存统计', '', '/stockManage', 'icon-news-1', '', 2, 4, 1, 1, '2020-06-12 15:00:04', 0, NULL);

-- ----------------------------
-- Table structure for dim_permission
-- ----------------------------
DROP TABLE IF EXISTS `dim_permission`;
CREATE TABLE `dim_permission`  (
  `pID` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `uri` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `permissionName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `active` tinyint(3) UNSIGNED NULL DEFAULT 1,
  `createDateTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP,
  `createAid` int(11) UNSIGNED NULL DEFAULT 0,
  `isMenu` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'N' COMMENT '是否为菜单',
  `menuParent` int(11) UNSIGNED NULL DEFAULT 0 COMMENT '菜单父ID',
  `level` tinyint(1) UNSIGNED NULL DEFAULT 0 COMMENT '菜单级别',
  PRIMARY KEY (`pID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dim_permission
-- ----------------------------
INSERT INTO `dim_permission` VALUES (1, '/account', '账户管理', 1, '2020-06-06 18:33:03', 0, 'N', 1, 0);
INSERT INTO `dim_permission` VALUES (2, '/user', '用户管理', 1, '2020-06-09 15:31:43', 0, 'Y', 0, 0);
INSERT INTO `dim_permission` VALUES (3, '/menu', '菜单管理', 1, '2020-06-09 15:32:07', 0, 'Y', 0, 0);

-- ----------------------------
-- Table structure for dim_role
-- ----------------------------
DROP TABLE IF EXISTS `dim_role`;
CREATE TABLE `dim_role`  (
  `rID` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `roleName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `active` tinyint(3) UNSIGNED NOT NULL DEFAULT 1,
  `roleDesc` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `createDateTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`rID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dim_role
-- ----------------------------
INSERT INTO `dim_role` VALUES (1, '超级管理员', 1, '最大权限', '2020-06-06 14:45:53');
INSERT INTO `dim_role` VALUES (2, '管理', 1, '系统管理', '2020-06-06 14:46:06');
INSERT INTO `dim_role` VALUES (3, '普通用户', 1, '只能看自己信息', '2020-06-06 14:47:02');

-- ----------------------------
-- Table structure for rel_account_role
-- ----------------------------
DROP TABLE IF EXISTS `rel_account_role`;
CREATE TABLE `rel_account_role`  (
  `relID` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `aID` int(11) UNSIGNED NOT NULL,
  `rID` int(11) UNSIGNED NOT NULL,
  `active` tinyint(3) UNSIGNED NULL DEFAULT 1,
  `createDateTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`relID`) USING BTREE,
  UNIQUE INDEX `AID_RID_indexUnique`(`aID`, `rID`) USING BTREE COMMENT '账户ID加角色ID做唯一'
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rel_account_role
-- ----------------------------
INSERT INTO `rel_account_role` VALUES (1, 1, 1, 1, '2020-06-09 15:32:26');
INSERT INTO `rel_account_role` VALUES (2, 2, 2, 1, '2020-06-09 15:32:40');
INSERT INTO `rel_account_role` VALUES (3, 3, 3, 1, '2020-06-09 15:32:43');

-- ----------------------------
-- Table structure for rel_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `rel_role_permission`;
CREATE TABLE `rel_role_permission`  (
  `relID` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `rID` int(11) UNSIGNED NOT NULL COMMENT '角色ID',
  `pID` int(11) UNSIGNED NOT NULL COMMENT '权限ID',
  `active` tinyint(3) UNSIGNED NULL DEFAULT 1 COMMENT '是否有效',
  `actionC` tinyint(1) UNSIGNED NULL DEFAULT 0,
  `actionR` tinyint(1) UNSIGNED NULL DEFAULT 0,
  `actionU` tinyint(1) UNSIGNED NULL DEFAULT 0,
  `actionD` tinyint(1) UNSIGNED NULL DEFAULT 0,
  `createDateTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`relID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rel_role_permission
-- ----------------------------
INSERT INTO `rel_role_permission` VALUES (1, 1, 1, 1, 1, 1, 1, 1, '2020-06-09 15:34:06');
INSERT INTO `rel_role_permission` VALUES (2, 1, 2, 1, 1, 1, 1, 0, '2020-06-09 15:34:15');
INSERT INTO `rel_role_permission` VALUES (3, 1, 3, 1, 1, 1, 1, 1, '2020-06-09 15:34:23');
INSERT INTO `rel_role_permission` VALUES (4, 2, 1, 1, 0, 1, 0, 0, '2020-06-09 15:34:44');
INSERT INTO `rel_role_permission` VALUES (5, 2, 3, 1, 0, 0, 0, 0, '2020-06-09 15:34:49');

SET FOREIGN_KEY_CHECKS = 1;
