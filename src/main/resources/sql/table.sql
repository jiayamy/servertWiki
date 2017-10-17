CREATE TABLE `w_servert_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `login_` varchar(50) NOT NULL COMMENT '用户登录帐号',
  `name_` varchar(50) NOT NULL COMMENT '英灵名称',
  `type_` int(11) NOT NULL,
  `atk_` bigint(20) NOT NULL,
  `hp_` bigint(20) NOT NULL,
  `level_` int(11) NOT NULL DEFAULT '1',
  `skill_1_level` int(11) NOT NULL DEFAULT '1',
  `skill_2_level` int(11) NOT NULL DEFAULT '1',
  `skill_3_level` int(11) NOT NULL DEFAULT '1',
  `tool_level` int(11) NOT NULL DEFAULT '1',
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) NOT NULL,
  `last_modified_by` varchar(45) DEFAULT NULL,
  `last_modified_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='英灵列表'