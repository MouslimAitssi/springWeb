-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 05 fév. 2020 à 02:16
-- Version du serveur :  5.7.26
-- Version de PHP :  7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `jobs`
--

-- --------------------------------------------------------

--
-- Structure de la table `companies`
--

DROP TABLE IF EXISTS `companies`;
CREATE TABLE IF NOT EXISTS `companies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(300) DEFAULT NULL,
  `company_address` varchar(500) DEFAULT NULL,
  `company_email` varchar(50) DEFAULT NULL,
  `company_website` varchar(500) DEFAULT NULL,
  `project_infos` varchar(3000) DEFAULT NULL,
  `profiles` varchar(500) DEFAULT NULL,
  `project_type` varchar(50) DEFAULT NULL,
  `period` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `companies`
--

INSERT INTO `companies` (`id`, `company_name`, `company_address`, `company_email`, `company_website`, `project_infos`, `profiles`, `project_type`, `period`) VALUES
(7, 'ANC', 'Tanger Mouhepako', 'anc@gmail.com', 'https://www.anc.ma', 'The project is about ...', 'Profiles needed are : Data Scientist and Information Security Analyst and ', 'Internship', '4 months'),
(9, 'CCME', 'RABAT HAY REYAD', 'ccme@gmail.com', 'https://www.ccme.ma', 'Our project is about ....', 'Profiles needed are : Software Developer and Web Developer and ', 'Job', 'Full-Time');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
