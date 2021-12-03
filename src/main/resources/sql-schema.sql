DROP TABLE IF EXISTS `brand` CASCADE;

CREATE TABLE `brand`
(
`id` BIGINT auto_increment,
`brand_name` VARCHAR(40) NOT NULL,
`brand_type` VARCHAR(40) NOT NULL,
PRIMARY KEY(id)
);

DROP TABLE IF EXISTS `item` CASCADE;

CREATE TABLE `item`
(
`id` BIGINT auto_increment,
`item_name` VARCHAR(40) NOT NULL,
`item_type` VARCHAR(40) NOT NULL,
`item_brand` BIGINT NOT NULL,
`release_date` VARCHAR(15) NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY(item_brand) REFERENCES brand(id)
);