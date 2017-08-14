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

CREATE TABLE `dish` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dish_name` varchar(255) DEFAULT NULL,
  `taste` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

INSERT INTO `dish` (`id`, `dish_name`, `taste`, `description`)
VALUES
	(1, 'Dosa', 'Medium Spicy', 'Made up of Rice, Potato, Ghee'),
	(2, 'Pohe', 'Medium Spicy', 'Made up of Rice, Potato, Onion, Poha');


CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `user_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `orders` (`id`, `order_id`, `price`, `user_id`)
VALUES
	(1, 'OD4367894763983', 25.12, 'ee0fad0d-e4ac-452e-a2bc-806bd0ffc635');