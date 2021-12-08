-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 02, 2021 at 03:55 PM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `course_search`
--

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE `courses` (
  `Course_ID` varchar(255) NOT NULL,
  `Course_Name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`Course_ID`, `Course_Name`) VALUES
('MAT101',  'College Algebra'),
('ENG101',  'English 101'),
('ECO101',  'Microeconomics'),
('ECO102',  'Macroeconomics'),
('CPT101',  'Java Programming'),
('ACC101',  'Accounting'),
('ADM101',  'Administrating'),
('AMT101',  'Aircraft Building'),
('BAK101',  'Cake Conceptualizing'),
('BIS101', 'Acronym Making'),
('CET101', 'Back Pat Lecture'),
('CAD101', 'Tracing'),
('IST101', 'CAT5 Identification'),
('GEN101', 'technology in the field'),
('MGT101', 'Micromanaging'),
('MET101',  '3D pen usage'),
('NSM101', 'How to Not Get Zapped'),
('OTA101', 'Feeling Good About Your Job'),
('PTA101', 'Muscles 101'),
('VET101', 'All About Monkeys');

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(46);

-- --------------------------------------------------------

--
-- Table structure for table `majors`
--

CREATE TABLE `majors` (
  `ID` int(11) NOT NULL,
  `Major_Name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `majors`
--

INSERT INTO `majors` (`ID`, `Major_Name`) VALUES
(1, 'Accounting'),
(2, 'Administrative Office Technology'),
(3, 'Aircraft Maintenance Technology'),
(4, 'Baking and Pastry Arts'),
(5, 'Business Administration'),
(6, 'Civil Engineering Technology'),
(7, 'Commercial Graphics '),
(8, 'Computer Programming '),
(9, 'Information Systems Specialist '),
(10, 'General Technology '),
(11, 'Management'),
(12, 'Mechanical Engineering Technology '),
(13, 'Network Systems Management '),
(14, 'Occupational Therapy Assistant '),
(15, 'Physical Therapist Assistant '),
(16, 'Veterinary Technology'),
(17, 'All Courses');

-- --------------------------------------------------------

--
-- Table structure for table `major_courses`
--

CREATE TABLE `major_courses` (
  `id` int(11) NOT NULL,
  `Course_ID` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `major_courses`
--

INSERT INTO `major_courses` (`id`, `Course_ID`) VALUES
(1, 'MAT101'),
(1, 'ENG101'),
(1, 'ECO101'),
(1, 'ECO102'),
(1, 'ACC101'),
(2, 'MAT101'),
(2, 'ENG101'),
(2, 'ECO101'),
(2, 'ECO102'),
(2, 'ADM101'),
(3, 'MAT101'),
(3, 'ENG101'),
(3, 'ECO101'),
(3, 'ECO102'),
(3, 'AMT101'),
(4, 'MAT101'),
(4, 'ENG101'),
(4, 'ECO101'),
(4, 'ECO102'),
(4, 'BAK101'),
(5, 'MAT101'),
(5, 'ENG101'),
(5, 'ECO101'),
(5, 'ECO102'),
(5, 'BIS101'),
(6, 'MAT101'),
(6, 'ENG101'),
(6, 'ECO101'),
(6, 'ECO102'),
(6, 'CET101'),
(7, 'MAT101'),
(7, 'ENG101'),
(7, 'ECO101'),
(7, 'ECO102'),
(7, 'CAD101'),
(8, 'MAT101'),
(8, 'ENG101'),
(8, 'ECO101'),
(8, 'ECO102'),
(8, 'CPT101'),
(9, 'MAT101'),
(9, 'ENG101'),
(9, 'ECO101'),
(9, 'ECO102'),
(9, 'IST101'),
(10, 'MAT101'),
(10, 'ENG101'),
(10, 'ECO101'),
(10, 'ECO102'),
(10, 'GEN101'),
(11, 'MAT101'),
(11, 'ENG101'),
(11, 'ECO101'),
(11, 'ECO102'),
(11, 'MGT101'),
(12, 'MAT101'),
(12, 'ENG101'),
(12, 'ECO101'),
(12, 'ECO102'),
(12, 'MET101'),
(13, 'MAT101'),
(13, 'ENG101'),
(13, 'ECO101'),
(13, 'ECO102'),
(13, 'NSM101'),
(14, 'MAT101'),
(14, 'ENG101'),
(14, 'ECO101'),
(14, 'ECO102'),
(14, 'OTA101'),
(15, 'MAT101'),
(15, 'ENG101'),
(15, 'ECO101'),
(15, 'ECO102'),
(15, 'PTA101'),
(16, 'MAT101'),
(16, 'ENG101'),
(16, 'ECO101'),
(16, 'ECO102'),
(16, 'VET101');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `id` bigint(20) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `major` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `password`, `username`, `major`) VALUES
(1, '$2a$10$HVbQpizvk.J1gYiFm6O0JeimZdQ8P1BKB2yfrZYN/4hQhPihU4sV6', 'arahimfahim40', 0),
(2, '$2a$10$AsEoMvgjZdlgysuaYxGAAOiCEX3S53x9Vzo3lU1UuGagqe5od8ZFu', 'corey', 1),
(3, NULL, NULL, 0),
(4, 'corey', 'porey', 0),
(5, 'anthony', 'anthony', 0),
(6, 'KAMAL', 'kamal', 0),
(7, 'shoorey', 'shoorey', 0),
(8, 'shoo', 'shoo', 0),
(9, 'asdfasd', 'dafsasd', 0),
(10, 'sdgfahsad', 'asdfasdf', 0),
(11, 'asdga', 'hsfdagas', 0),
(12, 'asdfasd', 'sdfaz', 0),
(13, ';lkasdjf;as', 'dksajf;sdj', 0),
(14, 'askdjfak', 'asjdkfa;kjh', 0),
(15, 'asdfasdf', 'dasfasd', 0),
(16, '$2a$10$t3fNqOui.HTvM4ivSN/0cOx/cEF5y/Mbp.vr8zzDetAM.NIuTuKk6', 'dasfasdasdf', 0),
(17, '$2a$10$HUIeUsEsWkEG6yxCYQCkkOZdT3caP83w6XvgC6rNhv0ux8XbmQUBK', 'adsfg', 0),
(18, '$2a$10$w5ooGjmj030HrTrMmEuaxuh/LSNFcpH3mYEqIeUKaCtcr1StgikcS', 'dksafj;', 0),
(19, '$2a$10$XKcVBSE1l08zfo5eCCxX5.m0HHN1rlo7WOzyvzSCWrA81TiZsC2Nq', 'asdf', 0),
(20, '$2a$10$sqAtLVODx9OrU5ixYa0TGebom.fgrRg1a3pPT5LI238wU64ZzhjwW', 'asdgwera', 0),
(21, '$2a$10$KX05Rhtldo5eIKaX3unlTeDmRpPTuTMrHIEKX/ASgfR7avxspebAG', 'dgasdg', 0),
(22, '$2a$10$Nx5fWBfXZOhaCiwsoBPtfuINm9DEsUUnzz59nYuNXiXC0u.2hESI2', 'dgasdgasdfsdf', 0),
(23, '$2a$10$qVyzH30jkC5tVCc58k4a4.J9oJ9Gm0thREOLiohklbLNknL4eHpwC', 'asdgsadf', 0),
(24, '$2a$10$T7cGZtziFOzctasVsxhQpe0nEKmTaAoqSR0/njorzLvz.GXCcwySW', 'dsa;klfj', 0),
(25, '$2a$10$knsQsQ40Y88.t2b7KdtKNOqLM8M3adE2wciRbF/GnSKxocHqX49R6', 'er', 0),
(26, '$2a$10$E3RjCn6XWrSdhrTLbWzuKupFyMj7jOQfo6sNGrK3IcFIo.8UVqHJC', 'asdfg', 0),
(27, '$2a$10$OWNhtpe5P9PB/dfVZ7foGuWWhv7NUkQm4PvryjQIVCd3nHLpNY3PC', 'asdgwe', 0),
(28, '$2a$10$z8bpsL/c1pkulzz9EwJk8.AnB1zopMV2yQ7zLdkzy5wV5j/pUcmPi', 'adweg', 0),
(29, '$2a$10$NyA50PzTPihcLiqXUcouv.btzGVPA428XEmKUUCxjsByMs8hOkgEa', 'dgas', 0),
(30, '$2a$10$RFDDm10US0ZxBSuJ57H4/uxU4k4xmjCFZDRVU1seX3B/KXpbX0FWa', 'password', 0),
(31, '$2a$10$ubSTSpMm9p7tjHtci.8Xm.pRlYMFVzt64nIme2BHTzalKu0h0tJ2i', 'password2', 0),
(32, '$2a$10$z2iG6gZJnZjlWEc2cZ4S3ugkoHP/QwEtxB6I490iHUHC9/X2siDdy', 'password22', 0),
(33, '$2a$10$3FhxDsAeO6A9/fD0ZEg9HurV9lTh.12kpbK2ezuNPC0bQHGqHIr.q', 'password33', 0),
(34, '$2a$10$TVUxtXDPRk8R.o/wRqWwFe36sl1CsQoxUdFVDO4dMGvLDuetW6Qbu', 'password55', 0),
(35, '$2a$10$mGaIMWhLqLZpwmZtS./vueWzXyVK2sOtRbUqE1ePoQ1uuLHBfCS..', 'sdafasdfj;', 0),
(36, '$2a$10$Js2Nj.jyxW4LwMriL.xEyuDFecWlQBlSwJaauGFQPUqWf/b7pGGmy', 'sdafasdfj;d', 0),
(37, '$2a$10$4KVm8dBpzBLUIPLcdakFju0dW5D8ffT4aQBeAAPTgGWow3n9cm2XC', 'password55d', 0),
(38, '$2a$10$eCSTuV.1tvEYvpm91EnVeORWJAbszat4jjZJwS6A4xs8Q/R16vBzG', 'password44d', 0),
(39, '$2a$10$xzFIvJVENG0a7lo9uUzbJe5be/Q3mEUedqD2hE0jXH8O57o/.sTCm', 'gdsag', 0),
(40, '$2a$10$QZOG5d6Dn.uLUqKr5Vv5r.eX74Um4.40c0R4FMZUIeGYvGuMxuHOe', 'gasdasd', 4),
(41, '$2a$10$NGoEzFjAEezE30Kqw3swBegPJFPqeIDGUeBNA/BNvsav2RKJcgCGG', 'allahuakbar', 1),
(42, '$2a$10$5qyG.8NR/djKUI5nT8Bp.eOUR8hjqX85AtVIEQRMMtu7WK4e1CG/2', 'wa wa wa ', 1),
(43, '$2a$10$WGax06w65zGMqbmOMcQz/ugdsux2FAx7X61NAgdTVZXeeCGZqE5wK', '', 8),
(44, '$2a$10$gRQlxAe1BjEtUgTEqp64C.nLf4R9QYajpu0lh5v5hgUjH94j8r/GS', 'jawad', 2),
(45, '$2a$10$RXgDolAsvNluSDNrP2U4y.2C0BiGmcmW86xaWqVLiPVZ/O3b67XuW', 'joe', 1);

-- --------------------------------------------------------

--
-- Table structure for table `student_courses`
--

CREATE TABLE `student_courses` (
  `ID` bigint(20) NOT NULL,
  `Course_ID` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student_courses`
--

INSERT INTO `student_courses` (`ID`, `Course_ID`) VALUES
(44, 'ECO102'),
(44, 'MAT101'),
(44, 'ECO101'),
(44, 'ENG101'),
(44, 'ADM101'),
(45, 'ACC101'),
(45, 'ECO102'),
(45, 'ENG101'),
(45, 'MAT101'),
(45, 'ECO101');

-- --------------------------------------------------------

--
-- Table structure for table `student_enrolled_courses`
--

CREATE TABLE `student_enrolled_courses` (
  `id` bigint(20) NOT NULL,
  `course_id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`Course_ID`);

--
-- Indexes for table `majors`
--
ALTER TABLE `majors`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `major_courses`
--
ALTER TABLE `major_courses`
  ADD KEY `id` (`id`),
  ADD KEY `Course_ID` (`Course_ID`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student_courses`
--
ALTER TABLE `student_courses`
  ADD KEY `ID` (`ID`),
  ADD KEY `Course_ID` (`Course_ID`);

--
-- Indexes for table `student_enrolled_courses`
--
ALTER TABLE `student_enrolled_courses`
  ADD PRIMARY KEY (`id`,`course_id`),
  ADD KEY `FKo0mi5tjvic5jerxjdtuhb0gfw` (`course_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `majors`
--
ALTER TABLE `majors`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `major_courses`
--
ALTER TABLE `major_courses`
  ADD CONSTRAINT `major_courses_ibfk_1` FOREIGN KEY (`id`) REFERENCES `majors` (`ID`),
  ADD CONSTRAINT `major_courses_ibfk_2` FOREIGN KEY (`Course_ID`) REFERENCES `courses` (`Course_ID`);

--
-- Constraints for table `student_courses`
--
ALTER TABLE `student_courses`
  ADD CONSTRAINT `student_courses_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `student` (`id`),
  ADD CONSTRAINT `student_courses_ibfk_2` FOREIGN KEY (`Course_ID`) REFERENCES `courses` (`Course_ID`);

--
-- Constraints for table `student_enrolled_courses`
--
ALTER TABLE `student_enrolled_courses`
  ADD CONSTRAINT `FKo0mi5tjvic5jerxjdtuhb0gfw` FOREIGN KEY (`course_id`) REFERENCES `courses` (`Course_ID`),
  ADD CONSTRAINT `FKqv7ny5rpc269vhq51mbml46p2` FOREIGN KEY (`id`) REFERENCES `student` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
