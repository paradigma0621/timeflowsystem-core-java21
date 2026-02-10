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

INSERT INTO person (
    name,
    register_date,
    removed,
    enrollment,
    customer_id,
    profile_id,
    birth_date,
    deletion_date
) VALUES (
             'João da Silva',
             '2024-01-15 10:30:00',
             b'0',
             'ENR-2024-001',
             12,
             2,
             '1990-05-12',
             '2026-01-15 09:20:12'
         );