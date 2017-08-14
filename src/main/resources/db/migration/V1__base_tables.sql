--DROP TABLE IF EXISTS dish;
--CREATE TABLE `dish` (
--  `id` int(11) NOT NULL AUTO_INCREMENT,
--  `description` varchar(255) DEFAULT NULL,
--  `dish_name` varchar(255) DEFAULT NULL,
--  `taste` varchar(255) DEFAULT NULL,
--  PRIMARY KEY (`id`)
--) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
--
--DROP TABLE IF EXISTS orders;
--CREATE TABLE `orders` (
--  `id` int(11) NOT NULL AUTO_INCREMENT,
--  `order_id` varchar(255) DEFAULT NULL,
--  `price` double NOT NULL,
--  `user_id` int(11) DEFAULT NULL,
--  PRIMARY KEY (`id`),
--  KEY `FKel9kyl84ego2otj2accfd8mr7` (`user_id`),
--  CONSTRAINT `FKel9kyl84ego2otj2accfd8mr7` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
--) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
--

CREATE TABLE `user` (
  `id` varchar(50) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email_id` varchar(50) NOT NULL,
  `phone_number` bigint(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  `creation_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `user` (`id`,`first_name`, `last_name`, `email_id`, `phone_number`, `password`)
VALUES
	('ee0fad0d-e4ac-452e-a2bc-806bd0ffc635', 'Sowmya', 'Patil', 'cjsowm@gmail.com', 3126474124, '8be3c943b1609fffbfc51aad666d0a04adf83c9d'),
	('23cf61ff-389b-4c47-845c-2f725c53bc4d', 'Harsh', 'Patil', 'patil.bmsce@gmail.com', 3126470214, '8be3c943b1609fffbfc51aad666d0a04adf83c9d');


--INSERT INTO `dish` (`id`, `description`, `dish_name`, `taste`)
--VALUES
--	(1, 'Made up of Rice, Potato, Ghee, Poha', 'Dosa', 'Medium Spicy'),
--	(2, 'Made up of Rice, Potato, Onion, Poha', 'Pohe', 'Medium Spicy'),
--	(3, 'Made up of Rice, Potato, Ghee, Poha', 'Dosa', 'Medium Spicy');
--
--INSERT INTO `orders` (`id`, `order_id`, `price`, `user_id`)
--VALUES
--	(8, 'OD4367893', 251, 1),
--	(9, 'OD4367894763983', 2512, 1),
--	(10, 'OD894763983', 22, 2),
--	(11, 'Harsh', 49826, NULL),
--	(12, 'Harsh', 49826, NULL),
--	(13, 'Harsh', 49826, NULL);