CREATE TABLE `customers` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `client_code` INT NOT NULL UNIQUE,
    `name` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
