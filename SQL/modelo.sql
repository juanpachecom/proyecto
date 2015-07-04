START TRANSACTION WITH CONSISTENT SNAPSHOT;
/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.6.20 : Database - proyecto
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`proyecto` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `proyecto`;

/*Table structure for table `cliente` */

DROP TABLE IF EXISTS `cliente`;

CREATE TABLE `cliente` (
  `rut` varchar(12) COLLATE utf8_unicode_ci NOT NULL,
  `nombre` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `direccion` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `idRegion` int(2) DEFAULT NULL,
  `idObra` int(2) DEFAULT NULL,
  PRIMARY KEY (`rut`),
  KEY `idObra` (`idObra`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `cliente` */

/*Table structure for table `materiales` */

DROP TABLE IF EXISTS `materiales`;

CREATE TABLE `materiales` (
  `idMateriales` int(2) NOT NULL,
  `nombre` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `valor` int(6) DEFAULT NULL,
  `cantidad` int(3) DEFAULT NULL,
  PRIMARY KEY (`idMateriales`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `materiales` */

/*Table structure for table `mueble_materiales` */

DROP TABLE IF EXISTS `mueble_materiales`;

CREATE TABLE `mueble_materiales` (
  `idMuebles` int(2) NOT NULL,
  `idMateriales` int(2) NOT NULL,
  PRIMARY KEY (`idMuebles`,`idMateriales`),
  KEY `idMateriales` (`idMateriales`),
  CONSTRAINT `mueble_materiales_ibfk_1` FOREIGN KEY (`idMateriales`) REFERENCES `materiales` (`idMateriales`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `mueble_materiales` */

/*Table structure for table `muebles` */

DROP TABLE IF EXISTS `muebles`;

CREATE TABLE `muebles` (
  `idMuebles` int(2) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `valor` int(6) NOT NULL,
  PRIMARY KEY (`idMuebles`),
  CONSTRAINT `muebles_ibfk_1` FOREIGN KEY (`idMuebles`) REFERENCES `mueble_materiales` (`idMuebles`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `muebles` */

/*Table structure for table `obra` */

DROP TABLE IF EXISTS `obra`;

CREATE TABLE `obra` (
  `idObra` int(2) NOT NULL,
  `nombre` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `rutUsuario` varchar(12) COLLATE utf8_unicode_ci DEFAULT NULL,
  `telefono` int(9) DEFAULT NULL,
  `idMueble` int(2) DEFAULT NULL,
  `direccion` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idObra`),
  KEY `rutUsuario` (`rutUsuario`),
  KEY `idMueble` (`idMueble`),
  CONSTRAINT `obra_ibfk_1` FOREIGN KEY (`idObra`) REFERENCES `cliente` (`idObra`),
  CONSTRAINT `obra_ibfk_2` FOREIGN KEY (`rutUsuario`) REFERENCES `usuario` (`rutUsuario`),
  CONSTRAINT `obra_ibfk_3` FOREIGN KEY (`idMueble`) REFERENCES `muebles` (`idMuebles`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `obra` */

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `rutUsuario` varchar(12) COLLATE utf8_unicode_ci NOT NULL,
  `nombre` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `telefono` int(9) DEFAULT NULL,
  `tipoUsuario` int(2) DEFAULT NULL,
  PRIMARY KEY (`rutUsuario`),
  KEY `tipoUsuario` (`tipoUsuario`),
  CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`tipoUsuario`) REFERENCES `usuariotipo` (`idTipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `usuario` */

/*Table structure for table `usuariotipo` */

DROP TABLE IF EXISTS `usuariotipo`;

CREATE TABLE `usuariotipo` (
  `idTipo` int(2) NOT NULL,
  `nombre` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idTipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `usuariotipo` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;


COMMIT;
