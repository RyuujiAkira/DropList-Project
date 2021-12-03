DROP TABLE IF EXISTS `item`;

CREATE TABLE `item`
(
`id` INT auto_increment,
`item_name` VARCHAR(40) NOT NULL,
`item_type` VARCHAR(40) NOT NULL,
`item_brand` INT NOT NULL,
`release_date` DATE NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY(item_brand) REFERENCES brand(id)
);

DROP TABLE IF EXISTS `brand`;

CREATE TABLE `brand`
(
`id` INT auto_increment,
`brand_name` VARCHAR(40) NOT NULL,
`brand_type` VARCHAR(40) NOT NULL,
PRIMARY KEY(id)
);