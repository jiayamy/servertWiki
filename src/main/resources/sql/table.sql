CREATE TABLE `w_servert_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `login_` varchar(50) NOT NULL COMMENT '用户登录帐号',
  `servert_id` bigint(20) NOT NULL COMMENT '英灵id',
  `type_` int(11) NOT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='英灵列表';

CREATE TABLE `w_servert_name` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `servert_id` bigint(20) NOT NULL,
  `servert_name` varchar(20) CHARACTER SET latin1 NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) NOT NULL,
  `last_modified_by` varchar(45) DEFAULT NULL,
  `last_modified_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='英灵id,name对应表';

CREATE TABLE `w_servert_level_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `servert_id` bigint(20) NOT NULL,
  `level_` int(11) NOT NULL,
  `atk_` bigint(20) NOT NULL,
  `hp_` bigint(20) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) NOT NULL,
  `last_modified_by` varchar(45) DEFAULT NULL,
  `last_modified_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='英灵等级信息表';

CREATE TABLE `w_skill_level_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `servert_id` bigint(20) NOT NULL,
  `skill_level_from` int(11) NOT NULL,
  `skill_level_to` int(11) NOT NULL,
  `resource_id_1` bigint(20) DEFAULT NULL,
  `resource_id_2` bigint(20) DEFAULT NULL,
  `qb_` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='英灵技能升级材料表';

CREATE TABLE `w_level_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `servert_id` bigint(20) NOT NULL,
  `level_from` int(11) NOT NULL,
  `level_to` int(11) NOT NULL,
  `resource_id_1` bigint(20) DEFAULT NULL,
  `resource_id_2` bigint(20) DEFAULT NULL,
  `qb_` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='英灵升级材料表';

CREATE TABLE `w_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name_` varchar(50) NOT NULL,
  `avert_` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='材料表';

CREATE TABLE `w_servert_image` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `servert_id` bigint(20) NOT NULL,
  `avert_` varchar(200) DEFAULT NULL,
  `image_` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='英灵图片表';



