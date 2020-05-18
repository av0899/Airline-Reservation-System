CREATE DATABASE `flight` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `airplane` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_id` int(11) DEFAULT NULL,
  `route_id` int(11) DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `dest_time` time DEFAULT NULL,
  `seat_eco` int(11) DEFAULT NULL,
  `seat_bus` int(11) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `domestic` int(11) DEFAULT NULL,
  `mon` int(11) DEFAULT NULL,
  `tue` int(11) DEFAULT NULL,
  `wed` int(11) DEFAULT NULL,
  `thu` int(11) DEFAULT NULL,
  `fri` int(11) DEFAULT NULL,
  `sat` int(11) DEFAULT NULL,
  `sun` int(11) DEFAULT NULL,
  `price2` float DEFAULT NULL,
  `mon_seats` int(11) DEFAULT NULL,
  `tue_seats` int(11) DEFAULT NULL,
  `wed_seats` int(11) DEFAULT NULL,
  `thu_seats` int(11) DEFAULT NULL,
  `fri_seats` int(11) DEFAULT NULL,
  `sat_seats` int(11) DEFAULT NULL,
  `sun_seats` int(11) DEFAULT NULL,
  `mon_seats_bus` int(11) DEFAULT NULL,
  `tue_seats_bus` int(11) DEFAULT NULL,
  `wed_seats_bus` int(11) DEFAULT NULL,
  `thu_seats_bus` int(11) DEFAULT NULL,
  `fri_seats_bus` int(11) DEFAULT NULL,
  `sat_seats_bus` int(11) DEFAULT NULL,
  `sun_seats_bus` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `company_id` (`company_id`),
  KEY `route_id` (`route_id`),
  CONSTRAINT `airplane_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`),
  CONSTRAINT `airplane_ibfk_2` FOREIGN KEY (`route_id`) REFERENCES `route` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `international` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `place` varchar(255) NOT NULL,
  `domestic` int(11) DEFAULT NULL,
  `international` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `place` (`place`),
  UNIQUE KEY `place_2` (`place`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `passanger` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `class` varchar(255) DEFAULT NULL,
  `prime` int(11) DEFAULT NULL,
  `uname` varchar(255) DEFAULT NULL,
  `random` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `uname` (`uname`),
  CONSTRAINT `passanger_ibfk_1` FOREIGN KEY (`uname`) REFERENCES `user` (`uname`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `promocode` (
  `code` varchar(255) NOT NULL,
  `value` float DEFAULT NULL,
  PRIMARY KEY (`code`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `route` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `distance` float DEFAULT NULL,
  `from1` varchar(255) DEFAULT NULL,
  `to1` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `from1` (`from1`),
  KEY `to1` (`to1`),
  CONSTRAINT `route_ibfk_1` FOREIGN KEY (`from1`) REFERENCES `international` (`place`),
  CONSTRAINT `route_ibfk_2` FOREIGN KEY (`to1`) REFERENCES `international` (`place`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `from2` varchar(255) DEFAULT NULL,
  `to2` varchar(255) DEFAULT NULL,
  `start_time` varchar(255) DEFAULT NULL,
  `end_time` varchar(255) DEFAULT NULL,
  `company` int(11) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `airplane_id` int(11) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `seats` int(11) DEFAULT NULL,
  `uname` varchar(255) NOT NULL,
  `random` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `from2` (`from2`),
  KEY `to2` (`to2`),
  KEY `airplane_id` (`airplane_id`),
  CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`from2`) REFERENCES `international` (`place`),
  CONSTRAINT `ticket_ibfk_2` FOREIGN KEY (`to2`) REFERENCES `international` (`place`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `uname` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uname` (`uname`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

insert into admin(uname,password) values('flight_admin','123');


