DROP TABLE IF EXISTS dish;
CREATE TABLE `dish` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `dish_name` varchar(255) DEFAULT NULL,
  `taste` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS orders;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKel9kyl84ego2otj2accfd8mr7` (`user_id`),
  CONSTRAINT `FKel9kyl84ego2otj2accfd8mr7` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS user;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `email_id` varchar(255) DEFAULT NULL,
  `phone_number` bigint(20) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;


INSERT INTO `dish` (`id`, `description`, `dish_name`, `taste`)
VALUES
	(1, 'Made up of Rice, Potato, Ghee, Poha', 'Dosa', 'Medium Spicy'),
	(2, 'Made up of Rice, Potato, Onion, Poha', 'Pohe', 'Medium Spicy'),
	(3, 'Made up of Rice, Potato, Ghee, Poha', 'Dosa', 'Medium Spicy');

INSERT INTO `orders` (`id`, `order_id`, `price`, `user_id`)
VALUES
	(8, 'OD4367893', 251, 1),
	(9, 'OD4367894763983', 2512, 1),
	(10, 'OD894763983', 22, 2),
	(11, 'Harsh', 49826, NULL),
	(12, 'Harsh', 49826, NULL),
	(13, 'Harsh', 49826, NULL);

INSERT INTO `user` (`user_id`, `email_id`, `phone_number`, `user_name`)
VALUES
	(1, 'patil.bmsce@gmail.com', 3126470214, 'Harsh'),
	(2, 'cjsowm@gmail.com', 3126474124, 'Sowmya'),
	(5, 'patil.bmsce@gmail.com', 3126470214, 'Harsh'),
	(6, 'patil.bmsce@gmail.com', 3126470214, 'Harsh'),
	(8, 'harsh.00.patil@gmail.com', 9916133076, 'Patil'),
	(9, 'harsh.patil@gmail.com', 9916133076, 'Patil'),
	(10, 'harsh.00.patil@gmail.com', 9916133076, 'Patil');
