DROP DATABASE IF EXISTS `babull_db`;
CREATE DATABASE `babull_db`;

CREATE TABLE `babull_db`.`cuenta` (
  `id` bigint(20) NOT NULL,
  `saldo` decimal(38,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `babull_db`.`cuenta` (`id`, `saldo`) VALUES
(1, 850.00),
(2, 650.00);

ALTER TABLE `babull_db`.`cuenta`
  ADD PRIMARY KEY (`id`);
