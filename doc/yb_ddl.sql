-- 录入销量
CREATE TABLE `yb_input` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` varchar(255) DEFAULT '' COMMENT '组别id,对应yb_saler_group id字段',
  `saler_name` varchar(255) DEFAULT '' COMMENT '销售姓名',
  `visit_name` varchar(255) DEFAULT '' COMMENT '拜访客户(家)',
  `whole_sale` varchar(255) DEFAULT '' COMMENT '批发',
  `dominant_position` varchar(255) DEFAULT '' COMMENT '制高点',
  `display` varchar(255) DEFAULT '' COMMENT '陈列',
  `other` varchar(255) DEFAULT '' COMMENT '其他',
  `visit_by_route` varchar(255) DEFAULT '' COMMENT '走线拜访',
  `visit_by_phone` varchar(255) DEFAULT '' COMMENT '电话拜访',
  `order_count` int(11) DEFAULT 0 COMMENT '订单(张)',
  `water_sale_count` int(11) DEFAULT 0 COMMENT '水销量(箱)',
  `water333` varchar(255) DEFAULT '' COMMENT '333水',
  `water555` varchar(255) DEFAULT '' COMMENT '555水',
  `water1500` varchar(255) DEFAULT '' COMMENT '1.5L水',
  `water4500` varchar(255) DEFAULT '' COMMENT '4.5L水',
  `drink_sale_count` int(11) DEFAULT 0 COMMENT '饮料量(箱)',
  `huojia` int(11) DEFAULT 0 COMMENT '火咖',
  `mishui` int(11) DEFAULT 0 COMMENT '蜜水',
  `other_drink` int(11) DEFAULT 0 COMMENT '火咖2',
  `created_at` datetime DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 销售组别表
CREATE TABLE `yb_sale_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(255) DEFAULT '' COMMENT '组别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 用户
CREATE TABLE `yb_sale_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT '' COMMENT '用户名',
  `password` varchar(255) DEFAULT '' COMMENT '密码',
  `phone_number` varchar(255) DEFAULT '' COMMENT '密码',
  `group_id` int(11) DEFAULT -1 COMMENT 'group_id',
  `role` varchar(255) DEFAULT '' COMMENT '角色',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
