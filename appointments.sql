SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

DROP DATABASE IF EXISTS appointments;
CREATE DATABASE IF NOT EXISTS appointments DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE appointments;

DELIMITER $$
DROP PROCEDURE IF EXISTS `AddAppointment`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `AddAppointment` (IN `inCustomerName` VARCHAR(20), IN `inAppointmentDate` VARCHAR(8), IN `inAppointmentTime` TIME, IN `inAppointmentLength` INT)  NO SQL
BEGIN
 INSERT INTO appointment (customername, appointmentdate, appointmenttime, appointmentlength)
        VALUES (inCustomerName, inAppointmentDate, inAppointmentTime, inAppointmentLength);
END$$

DROP PROCEDURE IF EXISTS `GetAppointments`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetAppointments` (IN `inAppointmentDate` VARCHAR(8))  NO SQL
BEGIN
  Select CustomerName, AppointmentTime, AppointmentLength From Appointment
  Where appointmentDate = inAppointmentDate
  Order By AppointmentTime;    
END$$

DELIMITER ;

DROP TABLE IF EXISTS appointment;
CREATE TABLE IF NOT EXISTS appointment (
  id int(11) NOT NULL AUTO_INCREMENT,
  CustomerName varchar(20) NOT NULL,
  AppointmentDate varchar(8) NOT NULL,
  AppointmentTime time NOT NULL,
  AppointmentLength int(11) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

INSERT INTO appointment (id, CustomerName, AppointmentDate, AppointmentTime, AppointmentLength) VALUES
(1, 'Lynn Kelly', '20201001', '10:00:00', 30),
(2, 'Ciara O\'Donnelll', '20201001', '11:15:00', 45),
(3, 'Louise Kelly', '20201001', '13:15:00', 60),
(4, 'Martin Gallacher', '20201002', '09:20:00', 15),
(5, 'Stephen Pickering', '20201002', '10:15:00', 45),
(6, 'Stephen Gaddis', '20201002', '11:30:00', 60),
(7, 'Joe Kelly', '20201003', '09:00:00', 30),
(8, 'Gene Kelly', '20201003', '10:15:00', 15),
(9, 'Ellen Stevenston', '20201001', '14:00:00', 45);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
