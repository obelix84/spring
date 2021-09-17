CREATE SCHEMA `lesson6` DEFAULT CHARACTER SET utf8 ;

USE lesson6;

CREATE TABLE `lesson6`.`customers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `lesson6`.`goods` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `cost` FLOAT NOT NULL,
  PRIMARY KEY (`id`));
  
INSERT INTO customers(name) VALUES ('customer1');  
INSERT INTO customers(name) VALUES ('customer2');
INSERT INTO customers(name) VALUES ('customer3');
INSERT INTO customers(name) VALUES ('customer4');
INSERT INTO customers(name) VALUES ('customer5');

INSERT INTO goods(name, cost) VALUES ('good1', 1.51);
INSERT INTO goods(name, cost) VALUES ('good2', 2.52);
INSERT INTO goods(name, cost) VALUES ('good3', 3.53);
INSERT INTO goods(name, cost) VALUES ('good4', 4.54);
INSERT INTO goods(name, cost) VALUES ('good5', 5.55);
INSERT INTO goods(name, cost) VALUES ('good6', 6.56);
INSERT INTO goods(name, cost) VALUES ('good7', 7.57);
INSERT INTO goods(name, cost) VALUES ('good8', 8.58);
INSERT INTO goods(name, cost) VALUES ('good9', 9.59);
INSERT INTO goods(name, cost) VALUES ('good10', 10.60);

CREATE TABLE `lesson6`.`customers_goods` (
  `cust_id` INT NOT NULL,
  `good_id` INT NOT NULL,
  INDEX `FK_cust_idx` (`cust_id` ASC) VISIBLE,
  INDEX `FK_good_idx` (`good_id` ASC) VISIBLE,
  CONSTRAINT `FK_cust`
    FOREIGN KEY (`cust_id`)
    REFERENCES `lesson6`.`customers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_good`
    FOREIGN KEY (`good_id`)
    REFERENCES `lesson6`.`goods` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
	
INSERT INTO customers_goods (cust_id, good_id) VALUES (1, 1);
INSERT INTO customers_goods (cust_id, good_id) VALUES (1, 3);
INSERT INTO customers_goods (cust_id, good_id) VALUES (1, 5);
INSERT INTO customers_goods (cust_id, good_id) VALUES (1, 7);
INSERT INTO customers_goods (cust_id, good_id) VALUES (1, 9);

INSERT INTO customers_goods (cust_id, good_id) VALUES (2, 2);
INSERT INTO customers_goods (cust_id, good_id) VALUES (2, 4);
INSERT INTO customers_goods (cust_id, good_id) VALUES (2, 6);
INSERT INTO customers_goods (cust_id, good_id) VALUES (2, 8);

INSERT INTO customers_goods (cust_id, good_id) VALUES (3, 6);
INSERT INTO customers_goods (cust_id, good_id) VALUES (4, 8);