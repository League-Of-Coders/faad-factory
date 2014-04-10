create database FaadFactoryDb;
use FaadFactoryDb;
CREATE TABLE IF NOT EXISTS `FaadFactoryDb`.`User` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NULL,
  `lastName` VARCHAR(45) NULL,
  `eMail` VARCHAR(45) NULL,
  `userName` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `accountType` VARCHAR(150) NULL,
  `widgets` VARCHAR(150) NULL,
  `active` TINYINT(1) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;