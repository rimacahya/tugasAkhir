/*
SQLyog Ultimate v11.33 (32 bit)
MySQL - 5.0.51b-community-nt-log : Database - db_penggajian
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_penggajian` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_penggajian`;

/*Table structure for table `tbl_absensi` */

DROP TABLE IF EXISTS `tbl_absensi`;

CREATE TABLE `tbl_absensi` (
  `id_absensi` int(11) NOT NULL auto_increment,
  `NIK` char(4) default NULL,
  `Tanggal` date default NULL,
  `Masuk` datetime default NULL,
  `Keluar` datetime default NULL,
  PRIMARY KEY  (`id_absensi`),
  KEY `NIK` (`NIK`),
  CONSTRAINT `tbl_absensi_ibfk_1` FOREIGN KEY (`NIK`) REFERENCES `tbl_karyawan` (`NIK`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_absensi` */

insert  into `tbl_absensi`(`id_absensi`,`NIK`,`Tanggal`,`Masuk`,`Keluar`) values (1,'1223','2016-01-02','2016-01-02 14:12:12','2016-01-02 16:47:07'),(2,'1223','2016-01-03','2016-01-03 14:54:02','2016-01-03 15:00:00'),(3,'2314','2016-01-02','2016-01-02 14:57:41','2016-01-02 15:10:44'),(4,'2317','2016-01-02','2016-01-02 15:10:54','2016-01-02 18:11:24'),(5,'2317','2016-01-04','2016-01-04 14:52:47','2016-01-04 15:53:02');

/*Table structure for table `tbl_gaji` */

DROP TABLE IF EXISTS `tbl_gaji`;

CREATE TABLE `tbl_gaji` (
  `no_slip` int(5) NOT NULL,
  `NIK` char(4) default NULL,
  `gaji_pokok` int(12) default NULL,
  `jumlah_kehadiran` int(11) default NULL,
  `tunjangan` int(12) default NULL,
  `total_gaji` int(20) default NULL,
  PRIMARY KEY  (`no_slip`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `tbl_gaji` */

insert  into `tbl_gaji`(`no_slip`,`NIK`,`gaji_pokok`,`jumlah_kehadiran`,`tunjangan`,`total_gaji`) values (23242,'2314',100000,1,20000,120000),(2322,'2317',100000,1,20000,120000),(1111,'2315',200000,0,42000,200000),(321421,'2316',200000,0,42000,200000);

/*Table structure for table `tbl_jabatan` */

DROP TABLE IF EXISTS `tbl_jabatan`;

CREATE TABLE `tbl_jabatan` (
  `kode_jabatan` char(10) NOT NULL,
  `jabatan` varbinary(40) default NULL,
  `gaji_pokok` int(11) default NULL,
  `tunjangan` int(11) default NULL,
  PRIMARY KEY  (`kode_jabatan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_jabatan` */

insert  into `tbl_jabatan`(`kode_jabatan`,`jabatan`,`gaji_pokok`,`tunjangan`) values ('0s','mene edit',20001,2000000),('11','a1',200000,42000),('13','obqwq',100000,20000),('A1','Staff',2000000,500000),('A5','Manager',200000,42000);

/*Table structure for table `tbl_karyawan` */

DROP TABLE IF EXISTS `tbl_karyawan`;

CREATE TABLE `tbl_karyawan` (
  `NIK` char(4) NOT NULL,
  `Nama` varchar(30) default NULL,
  `Tempat_lahir` varchar(30) default NULL,
  `Tanggal_lahir` date default NULL,
  `Jenis_kelamin` char(1) default NULL,
  `Alamat` varchar(50) default NULL,
  `Status` varchar(15) default NULL,
  `kode_jabatan` char(10) default NULL,
  PRIMARY KEY  (`NIK`),
  KEY `kode_jabatan` (`kode_jabatan`),
  CONSTRAINT `tbl_karyawan_ibfk_1` FOREIGN KEY (`kode_jabatan`) REFERENCES `tbl_jabatan` (`kode_jabatan`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_karyawan` */

insert  into `tbl_karyawan`(`NIK`,`Nama`,`Tempat_lahir`,`Tanggal_lahir`,`Jenis_kelamin`,`Alamat`,`Status`,`kode_jabatan`) values ('1214','rr','bandar','1997-01-01','p','lampung','belum','A1'),('1223','Dwi Randy','Bandar Jaya','2015-01-01','L','Bandar Jaya','Menikah','A5'),('2310','Eka','Bandar Lampung','1996-04-07','p','Bandar Lampung','Belum Menikah','11'),('2314','indana','mesuji','1995-12-17','p','bandar lampung','belum menikah','13'),('2315','rima vsfg','bandar','1996-01-01','p','bandar lampung','belum menikah','11'),('2316','candra','mesj','1996-02-03','p','lampung','belum menikah','11'),('2317','kkll','jkn','2014-01-04','p','hjk','kll','13');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
