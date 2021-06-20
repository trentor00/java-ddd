CREATE TABLE `orders` (
    `id` CHAR(36) NOT NULL,
    `name` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `orders_counter` (
                                   `id` CHAR(36) NOT NULL,
                                   `total` INT NOT NULL,
                                   `existing_orders` JSON NOT NULL,
                                   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
