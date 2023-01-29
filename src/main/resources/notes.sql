
#创建数据库, 如果没有这个数据库的话
CREATE DATABASE IF NOT EXISTS `note`;

#选择此数据库
USE `note`;

#删除该数据库里的表, 如果存在的话
DROP TABLE IF EXISTS `url_info`;

#创建表url_info_test
CREATE TABLE `url_info` (
  `url` CHAR(26) NOT NULL,
  `strData` TEXT,
  PRIMARY KEY (`url`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4;
