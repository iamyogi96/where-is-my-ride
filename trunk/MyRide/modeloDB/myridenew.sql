SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE  TABLE IF NOT EXISTS `Where_is_my_ride`.`Usuario` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(45) NOT NULL ,
  `apaterno` VARCHAR(45) NOT NULL ,
  `amaterno` VARCHAR(45) NOT NULL ,
  `correo` VARCHAR(45) NOT NULL ,
  `direccion` VARCHAR(45) NOT NULL ,
  `ciudad` VARCHAR(45) NOT NULL ,
  `contrasena` VARCHAR(45) NOT NULL ,
  `telefono` VARCHAR(15) NOT NULL ,
  `imagen` BLOB NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;

CREATE  TABLE IF NOT EXISTS `Where_is_my_ride`.`Transporte` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `num_economico` INT(11) NOT NULL ,
  `tipo_trans` INT(11) NOT NULL ,
  `disponible` VARCHAR(45) NOT NULL ,
  `totales` INT(11) NOT NULL ,
  `Ruta_id` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Transporte_Ruta1` (`Ruta_id` ASC) ,
  CONSTRAINT `fk_Transporte_Ruta1`
    FOREIGN KEY (`Ruta_id` )
    REFERENCES `Where_is_my_ride`.`Ruta` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;

CREATE  TABLE IF NOT EXISTS `Where_is_my_ride`.`Historial` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `id_ruta` INT(11) NOT NULL ,
  `Usuario_id` INT(11) NOT NULL ,
  `hora` TIME NOT NULL ,
  `fecha` DATE NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Historial_Ruta1` (`id_ruta` ASC) ,
  INDEX `fk_Historial_Usuario1` (`Usuario_id` ASC) ,
  CONSTRAINT `fk_Historial_Ruta1`
    FOREIGN KEY (`id_ruta` )
    REFERENCES `Where_is_my_ride`.`Ruta` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Historial_Usuario1`
    FOREIGN KEY (`Usuario_id` )
    REFERENCES `Where_is_my_ride`.`Usuario` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;

CREATE  TABLE IF NOT EXISTS `Where_is_my_ride`.`Ruta` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(45) NOT NULL ,
  `descripcion` VARCHAR(50) NOT NULL ,
  `no_ruta` INT(11) NOT NULL ,
  `logotipo` BLOB NOT NULL ,
  `telefono` VARCHAR(45) NOT NULL ,
  `nom_responsable` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;

CREATE  TABLE IF NOT EXISTS `Where_is_my_ride`.`Puntos` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `no_punto` INT(11) NOT NULL ,
  `longitud` DECIMAL(15,8) NOT NULL ,
  `latitud` DECIMAL(15,8) NOT NULL ,
  `id_ruta` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Puntos_Ruta1` (`id_ruta` ASC) ,
  CONSTRAINT `fk_Puntos_Ruta1`
    FOREIGN KEY (`id_ruta` )
    REFERENCES `Where_is_my_ride`.`Ruta` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
