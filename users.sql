/*
SQLyog Professional v12.09 (64 bit)
MySQL - 5.6.26 : Database - data
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`data` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `data`;

/*Table structure for table `data_users` */

DROP TABLE IF EXISTS `data_users`;

CREATE TABLE `data_users` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `id_identity_document_type` int(10) DEFAULT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `mail` varchar(150) DEFAULT NULL,
  `identification` int(15) DEFAULT NULL,
  `phone` bigint(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `data_users` */

insert  into `data_users`(`id`,`id_identity_document_type`,`first_name`,`last_name`,`mail`,`identification`,`phone`) values (1,1,'Jeremy','De Avila','jedp1026@gmail.com',1140845180,3116905022);

/*Table structure for table `identity_document_type` */

DROP TABLE IF EXISTS `identity_document_type`;

CREATE TABLE `identity_document_type` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(90) DEFAULT NULL,
  `description` varchar(120) DEFAULT NULL,
  `code` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `identity_document_type` */

insert  into `identity_document_type`(`id`,`name`,`description`,`code`) values (1,'Cedula de Ciudadania','Cedula de Ciudadania','CC'),(2,'Cedula de Extranjería','Cedula de Extranjería','CE'),(3,'Tarjeta de identidad','Tarjeta de identidad','TI'),(4,'Nit','Nit','NIT'),(5,'RUT','RUT','RUT');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
