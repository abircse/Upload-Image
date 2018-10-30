-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 30, 2018 at 07:03 PM
-- Server version: 10.1.34-MariaDB
-- PHP Version: 7.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `imagedatabase`
--

-- --------------------------------------------------------

--
-- Table structure for table `allimage`
--

CREATE TABLE `allimage` (
  `id` int(11) NOT NULL,
  `imagecaption` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `allimage`
--

INSERT INTO `allimage` (`id`, `imagecaption`) VALUES
(1, 'mzmmz'),
(2, 'Qareeb'),
(3, 'Playing..'),
(4, 'Soup'),
(5, 'Panjabi..'),
(6, 'Hhajaj'),
(7, 'à¦¬à§à¦¯à¦¾à¦—'),
(8, 'à¦•à¦¾à¦°à¦¿à¦¬'),
(9, 'ক্সিককিকি');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `allimage`
--
ALTER TABLE `allimage`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `allimage`
--
ALTER TABLE `allimage`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
