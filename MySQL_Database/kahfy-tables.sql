-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema kahfyDb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema kahfyDb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `kahfyDb` DEFAULT CHARACTER SET utf8 ;
USE `kahfyDb` ;

-- -----------------------------------------------------
-- Table `kahfyDb`.`members`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kahfyDb`.`members` (
  `member_id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `rewards` INT(11) NOT NULL,
  `password` VARCHAR(65) NOT NULL,
  PRIMARY KEY (`member_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kahfyDb`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kahfyDb`.`products` (
  `product_id` INT NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(200) NOT NULL,
  `price` DECIMAL(3,2) NOT NULL,
  `reward_worth` INT(11) NOT NULL,
  PRIMARY KEY (`product_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kahfyDb`.`shopping_session`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kahfyDb`.`shopping_session` (
  `session_id` INT(11) NOT NULL AUTO_INCREMENT,
  `member_id` INT(11) NOT NULL,
  `total` DECIMAL(5,2) NOT NULL,
  `rewards_used` INT(11) NOT NULL,
  PRIMARY KEY (`session_id`),
  INDEX `fk_shopping_cart_members1_idx` (`member_id` ASC) VISIBLE,
  CONSTRAINT `fk_shopping_cart_members1`
    FOREIGN KEY (`member_id`)
    REFERENCES `kahfyDb`.`members` (`member_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kahfyDb`.`cart_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kahfyDb`.`cart_item` (
  `item_id` INT NOT NULL AUTO_INCREMENT,
  `session_id` INT(11) NOT NULL,
  `product_id` INT NOT NULL,
  `quantity` INT NOT NULL,
  `rewards_applied` INT(11) NOT NULL,
  `rewards_to_earn` INT(11) NOT NULL,
  `subtotal` DECIMAL(5,2) NOT NULL,
  INDEX `fk_cart_item_shopping_session1_idx` (`session_id` ASC) VISIBLE,
  INDEX `fk_cart_item_products1_idx` (`product_id` ASC) VISIBLE,
  PRIMARY KEY (`item_id`),
  INDEX `item_id_UNIQUE` (`item_id` ASC) VISIBLE,
  CONSTRAINT `fk_cart_item_shopping_session1`
    FOREIGN KEY (`session_id`)
    REFERENCES `kahfyDb`.`shopping_session` (`session_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cart_item_products1`
    FOREIGN KEY (`product_id`)
    REFERENCES `kahfyDb`.`products` (`product_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
