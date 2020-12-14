-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 11, 2020 at 02:45 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `emp_mgmt`
--

-- --------------------------------------------------------

--
-- Table structure for table `emp_attendance`
--

CREATE TABLE `emp_attendance` (
  `serial` int(11) NOT NULL,
  `emp_id` varchar(30) NOT NULL,
  `day` date NOT NULL,
  `time_in` time NOT NULL,
  `time_out` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `emp_attendance`
--

INSERT INTO `emp_attendance` (`serial`, `emp_id`, `day`, `time_in`, `time_out`) VALUES
(50, 'emp002', '2020-11-11', '13:06:16', '14:06:20'),
(51, 'emp002', '2020-11-11', '19:10:16', '19:10:51');

-- --------------------------------------------------------

--
-- Table structure for table `emp_details`
--

CREATE TABLE `emp_details` (
  `emp_id` varchar(30) NOT NULL,
  `emp_name` varchar(30) NOT NULL,
  `emp_email` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `emp_details`
--

INSERT INTO `emp_details` (`emp_id`, `emp_name`, `emp_email`) VALUES
('1', 'test', 'test'),
('emp001', 'pratyusha', 'pratyusha@java.com'),
('emp002', 'emp002', 'emp002@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `emp_login`
--

CREATE TABLE `emp_login` (
  `emp_id` varchar(30) NOT NULL,
  `emp_pw` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `emp_login`
--

INSERT INTO `emp_login` (`emp_id`, `emp_pw`) VALUES
('1', 'test'),
('emp001', 'abcd'),
('emp002', 'emp002');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `emp_attendance`
--
ALTER TABLE `emp_attendance`
  ADD PRIMARY KEY (`serial`);

--
-- Indexes for table `emp_details`
--
ALTER TABLE `emp_details`
  ADD PRIMARY KEY (`emp_id`);

--
-- Indexes for table `emp_login`
--
ALTER TABLE `emp_login`
  ADD PRIMARY KEY (`emp_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `emp_attendance`
--
ALTER TABLE `emp_attendance`
  MODIFY `serial` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
