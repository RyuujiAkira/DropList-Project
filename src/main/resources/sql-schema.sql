DROP TABLE IF EXISTS `items`;

CREATE TABLE `items`
(
`id` INT auto_increment,
`item_name` VARCHAR(40) NOT NULL,
`item_type` VARCHAR(40) NOT NULL,
`item_brand` VARCHAR(40) NOT NULL,
`release_date` DATE NOT NULL,
PRIMARY KEY(id)
);

DROP TABLE IF EXISTS `brands`;

CREATE TABLE `brands`
(
`id` INT auto_increment,
`brand_name` VARCHAR(40) NOT NULL,
`brand_type` VARCHAR(40) NOT NULL,
PRIMARY KEY(id)
);