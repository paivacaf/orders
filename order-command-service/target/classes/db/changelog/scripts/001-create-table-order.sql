CREATE TABLE `orders` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `control_number` VARCHAR(255) DEFAULT NULL,
    `registration_date` DATE DEFAULT NULL,
    `product_name` VARCHAR(255) DEFAULT NULL,
    `unit_price` DECIMAL(19, 2) DEFAULT NULL,
    `quantity` INT DEFAULT NULL,
    `client_code` INT DEFAULT NULL,
    `total_order` DECIMAL(19, 2) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;



