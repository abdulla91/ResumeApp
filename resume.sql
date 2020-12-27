-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Hazırlanma Vaxtı: 27 Dek, 2020 saat 20:19
-- Server versiyası: 8.0.17
-- PHP Versiyası: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Verilənlər Bazası: `resume`
--

-- --------------------------------------------------------

--
-- Cədvəl üçün cədvəl strukturu `country`
--

CREATE TABLE `country` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `nationality` varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Sxemi çıxarılan cedvel `country`
--

INSERT INTO `country` (`id`, `name`, `nationality`) VALUES
(1, 'Azerbaijan', 'Azerbaijani'),
(2, 'USA\r\n', 'American'),
(3, 'Turkey', 'Turkish');

-- --------------------------------------------------------

--
-- Cədvəl üçün cədvəl strukturu `employment_history`
--

CREATE TABLE `employment_history` (
  `id` int(11) NOT NULL,
  `header` varchar(255) NOT NULL,
  `job_description` text NOT NULL,
  `begin_date` date NOT NULL,
  `end_date` date NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Sxemi çıxarılan cedvel `employment_history`
--

INSERT INTO `employment_history` (`id`, `header`, `job_description`, `begin_date`, `end_date`, `user_id`) VALUES
(1, 'Header of cv', 'Java developer', '2020-12-01', '2020-12-25', 1);

-- --------------------------------------------------------

--
-- Cədvəl üçün cədvəl strukturu `skill`
--

CREATE TABLE `skill` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Sxemi çıxarılan cedvel `skill`
--

INSERT INTO `skill` (`id`, `name`) VALUES
(1, 'Java'),
(2, 'C#'),
(3, 'PHP');

-- --------------------------------------------------------

--
-- Cədvəl üçün cədvəl strukturu `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `surname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(90) NOT NULL,
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `profile_description` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `birthdate` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `birthplace_id` int(11) DEFAULT NULL,
  `nationality_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Sxemi çıxarılan cedvel `user`
--

INSERT INTO `user` (`id`, `name`, `surname`, `email`, `phone`, `profile_description`, `address`, `birthdate`, `birthplace_id`, `nationality_id`) VALUES
(1, 'Abdulla', 'Makhsudov', 'maxsudov@gmail.com2', '+994555480465', 'Hazirda profile description ucun qeyd yoxdu', 'Cantepe qesebesi I.Nesimi kuc 6', '1991-04-07', 3, 1),
(3, 'Ali', 'Maxsudov', 'alimax@gmail.com', '+994502297019', '', '', '1992-03-08', 2, 1);

-- --------------------------------------------------------

--
-- Cədvəl üçün cədvəl strukturu `user_skill`
--

CREATE TABLE `user_skill` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `skill_id` int(11) NOT NULL,
  `power` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Sxemi çıxarılan cedvel `user_skill`
--

INSERT INTO `user_skill` (`id`, `user_id`, `skill_id`, `power`) VALUES
(1, 1, 1, 9),
(2, 1, 3, 9),
(3, 1, 2, 7);

--
-- Indexes for dumped tables
--

--
-- Cədvəl üçün indekslər `country`
--
ALTER TABLE `country`
  ADD PRIMARY KEY (`id`);

--
-- Cədvəl üçün indekslər `employment_history`
--
ALTER TABLE `employment_history`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- Cədvəl üçün indekslər `skill`
--
ALTER TABLE `skill`
  ADD PRIMARY KEY (`id`);

--
-- Cədvəl üçün indekslər `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Test` (`nationality_id`),
  ADD KEY `Test2` (`birthplace_id`);

--
-- Cədvəl üçün indekslər `user_skill`
--
ALTER TABLE `user_skill`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `skill_id` (`skill_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- Cədvəl üçün AUTO_INCREMENT `country`
--
ALTER TABLE `country`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Cədvəl üçün AUTO_INCREMENT `employment_history`
--
ALTER TABLE `employment_history`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Cədvəl üçün AUTO_INCREMENT `skill`
--
ALTER TABLE `skill`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Cədvəl üçün AUTO_INCREMENT `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Cədvəl üçün AUTO_INCREMENT `user_skill`
--
ALTER TABLE `user_skill`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `employment_history`
--
ALTER TABLE `employment_history`
  ADD CONSTRAINT `employment_history_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `Test` FOREIGN KEY (`nationality_id`) REFERENCES `country` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `Test2` FOREIGN KEY (`birthplace_id`) REFERENCES `country` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Constraints for table `user_skill`
--
ALTER TABLE `user_skill`
  ADD CONSTRAINT `user_skill_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `user_skill_ibfk_2` FOREIGN KEY (`skill_id`) REFERENCES `skill` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
