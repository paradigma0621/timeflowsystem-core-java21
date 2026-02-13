-- mysqlDatabase.person definition

CREATE TABLE `person` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `register_date` DATETIME DEFAULT NULL,
  `removed` bit(1) DEFAULT NULL,
  `enrollment` varchar(255) DEFAULT NULL,
  `customer_id` int DEFAULT NULL,
  `profile_id` int DEFAULT NULL,
  `birth_date` DATE DEFAULT NULL,
  `deletion_date` DATETIME DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- mysqlDatabase.clocking definition

CREATE TABLE `clocking` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `seconds_duration` int DEFAULT NULL,
  `grade` double DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `subject` varchar(500) DEFAULT NULL,
  `start_date` DATETIME DEFAULT NULL,
  `finish_date` DATETIME DEFAULT NULL,
  `localization` varchar(255) DEFAULT NULL,
  `person_id` bigint NOT NULL,
  `removed` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK887ckl98ya71ifc4uf2nwhyc` (`person_id`),
  CONSTRAINT `FK887ckl98ya71ifc4uf2nwhyc` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO mysqlDatabase.clocking
(id, seconds_duration, grade, description, subject, start_date, finish_date, localization, person_id, removed)
VALUES
    (1, 5, 2.0, 'Task 1', 'Subject 1', '2024-01-01 08:00:00', '2024-01-01 08:05:00', 'Office', 1, 0),
    (2, 5, 2.0, 'Task 2', 'Subject 2', '2024-01-01 08:00:00', '2024-01-01 08:05:00', 'Office', 1, 0),
    (3, 5, 2.0, 'Task 3', 'Subject 3', '2024-01-01 08:00:00', '2024-01-01 08:05:00', 'Office', 1, 0),
    (4, 5, 2.0, 'Task 4', 'Subject 4', '2024-01-01 08:00:00', '2024-01-01 08:05:00', 'Office', 1, 0),
    (5, 10, 3.0, 'Task 5', 'Subject 5', '2024-01-02 09:00:00', '2024-01-02 09:10:00', 'Remote', 1, 0),
    (6, 15, 4.0, 'Task 6', 'Subject 6', '2024-01-03 10:00:00', '2024-01-03 10:15:00', 'Client', 1, 0),
    (7, 20, 1.0, 'Task 7', 'Subject 7', '2024-01-04 11:00:00', '2024-01-04 11:20:00', 'Office', 1, 0),
    (8, 25, 2.5, 'Task 8', 'Subject 8', '2024-01-05 12:00:00', '2024-01-05 12:25:00', 'Remote', 1, 0),
    (9, 30, 3.5, 'Task 9', 'Subject 9', '2024-01-06 13:00:00', '2024-01-06 13:30:00', 'Client', 1, 0),
    (10, 35, 4.5, 'Task 10', 'Subject 10', '2024-01-07 14:00:00', '2024-01-07 14:35:00', 'Office', 1, 0),
    (11, 40, 1.5, 'Task 11', 'Subject 11', '2024-01-08 15:00:00', '2024-01-08 15:40:00', 'Remote', 1, 0),
    (12, 45, 2.2, 'Task 12', 'Subject 12', '2024-01-09 16:00:00', '2024-01-09 16:45:00', 'Client', 1, 0),
    (13, 50, 3.8, 'Task 13', 'Subject 13', '2024-01-10 17:00:00', '2024-01-10 17:50:00', 'Office', 1, 0),
    (14, 55, 4.2, 'Task 14', 'Subject 14', '2024-01-11 08:30:00', '2024-01-11 09:25:00', 'Remote', 1, 0),
    (15, 60, 2.7, 'Task 15', 'Subject 15', '2024-01-12 09:30:00', '2024-01-12 10:30:00', 'Client', 1, 0),
    (16, 65, 3.3, 'Task 16', 'Subject 16', '2024-01-13 10:30:00', '2024-01-13 11:35:00', 'Office', 1, 0),
    (17, 70, 4.7, 'Task 17', 'Subject 17', '2024-01-14 11:30:00', '2024-01-14 12:40:00', 'Remote', 1, 0),
    (18, 75, 1.9, 'Task 18', 'Subject 18', '2024-01-15 12:30:00', '2024-01-15 13:45:00', 'Client', 1, 0),
    (19, 80, 2.4, 'Task 19', 'Subject 19', '2024-01-16 13:30:00', '2024-01-16 14:50:00', 'Office', 1, 0),
    (20, 85, 3.1, 'Task 20', 'Subject 20', '2024-01-17 14:30:00', '2024-01-17 15:55:00', 'Remote', 1, 0),
    (21, 90, 4.9, 'Task 21', 'Subject 21', '2024-01-18 15:30:00', '2024-01-18 17:00:00', 'Client', 1, 0),
    (22, 95, 2.6, 'Task 22', 'Subject 22', '2024-01-19 08:15:00', '2024-01-19 09:50:00', 'Office', 1, 0),
    (23, 100, 3.4, 'Task 23', 'Subject 23', '2024-01-20 09:15:00', '2024-01-20 10:55:00', 'Remote', 1, 0),
    (24, 105, 4.1, 'Task 24', 'Subject 24', '2024-01-21 10:15:00', '2024-01-21 12:00:00', 'Client', 1, 0),
    (25, 110, 1.8, 'Task 25', 'Subject 25', '2024-01-22 11:15:00', '2024-01-22 13:05:00', 'Office', 1, 0),
    (26, 115, 2.9, 'Task 26', 'Subject 26', '2024-01-23 12:15:00', '2024-01-23 14:10:00', 'Remote', 1, 0),
    (27, 120, 3.6, 'Task 27', 'Subject 27', '2024-01-24 13:15:00', '2024-01-24 15:15:00', 'Client', 1, 0),
    (28, 125, 4.3, 'Task 28', 'Subject 28', '2024-01-25 14:15:00', '2024-01-25 16:20:00', 'Office', 1, 0);
