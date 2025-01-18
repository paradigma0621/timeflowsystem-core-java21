-- mysqlDatabase.person definition

CREATE TABLE `person` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `register_date` datetime(6) DEFAULT NULL,
  `removed` bit(1) DEFAULT NULL,
  `enrollment` varchar(255) DEFAULT NULL,
  `customer_id` int DEFAULT NULL,
  `profile_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- mysqlDatabase.clocking definition

CREATE TABLE `clocking` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `seconds_duration` int DEFAULT NULL,
  `grade` double DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `subject` varchar(500) DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `finish_date` datetime(6) DEFAULT NULL,
  `localization` varchar(255) DEFAULT NULL,
  `person_id` bigint NOT NULL,
  `removed` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK887ckl98ya71ifc4uf2nwhyc` (`person_id`),
  CONSTRAINT `FK887ckl98ya71ifc4uf2nwhyc` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
