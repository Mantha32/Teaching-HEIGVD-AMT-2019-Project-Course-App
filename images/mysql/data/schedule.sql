-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 10 nov. 2019 à 11:19
-- Version du serveur :  5.7.23
-- Version de PHP :  7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `schedule`
--

-- --------------------------------------------------------

--
-- Structure de la table `classroom`
--

DROP TABLE IF EXISTS `classroom`;
CREATE TABLE IF NOT EXISTS `classroom` (
  `IDCLASSROOM` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(32) DEFAULT NULL,
  `OCCP` tinyint(1) NOT NULL DEFAULT '0',
  `FLOOR` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDCLASSROOM`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `classroom`
--

INSERT INTO `classroom` (`IDCLASSROOM`, `NAME`, `OCCP`, `FLOOR`) VALUES
(1, 'S001', 0, 2),
(2, 'S002', 0, 1);

-- --------------------------------------------------------

--
-- Structure de la table `course`
--

DROP TABLE IF EXISTS `course`;
CREATE TABLE IF NOT EXISTS `course` (
  `COURSEID` int(11) NOT NULL AUTO_INCREMENT,
  `USERID` int(11) NOT NULL,
  `TITLE` varchar(32) DEFAULT NULL,
  `DESCRIPTION` varchar(32) DEFAULT NULL,
  `LAST_UPDATE` datetime DEFAULT NULL,
  PRIMARY KEY (`COURSEID`),
  KEY `I_FK_COURSE_USER` (`USERID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `course`
--

INSERT INTO `course` (`COURSEID`, `USERID`, `TITLE`, `DESCRIPTION`, `LAST_UPDATE`) VALUES
(1, 1, 'INF400', NULL, '2019-11-08 00:00:00'),
(2, 2, 'INF410', NULL, '2019-11-08 00:00:00');

-- --------------------------------------------------------

--
-- Structure de la table `lecture`
--

DROP TABLE IF EXISTS `lecture`;
CREATE TABLE IF NOT EXISTS `lecture` (
  `LECTUREID` int(11) NOT NULL AUTO_INCREMENT,
  `USERID` int(11) NOT NULL,
  `COURSEID` int(11) NOT NULL,
  `IDCLASSROOM` int(11) NOT NULL,
  PRIMARY KEY (`LECTUREID`),
  KEY `I_FK_LECTURE_USER` (`USERID`),
  KEY `I_FK_LECTURE_COURSE` (`COURSEID`),
  KEY `I_FK_LECTURE_CLASSROOM` (`IDCLASSROOM`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `lecture`
--

INSERT INTO `lecture` (`LECTUREID`, `USERID`, `COURSEID`, `IDCLASSROOM`) VALUES
(1, 2, 2, 1);

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `status` varchar(32) NOT NULL,
  PRIMARY KEY (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `role`
--

INSERT INTO `role` (`status`) VALUES
('Administrateur'),
('Enseignant'),
('Etudiant');

-- --------------------------------------------------------

--
-- Structure de la table `slotevent`
--

DROP TABLE IF EXISTS `slotevent`;
CREATE TABLE IF NOT EXISTS `slotevent` (
  `SLOTEVENTID` int(11) NOT NULL AUTO_INCREMENT,
  `DATE` varchar(32) DEFAULT NULL,
  `HOUR` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`SLOTEVENTID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `slotevent`
--

INSERT INTO `slotevent` (`SLOTEVENTID`, `DATE`, `HOUR`) VALUES
(1, 'Fri Oct 25 2019', 'Fri Oct 25 2019 08:00:00-Fri Oct 25 2019 10:00:00'),
(2, 'Fri Oct 25 2019', 'Fri Oct 25 2019 12:00:00-Fri Oct 25 2019 14:00:00');

-- --------------------------------------------------------

--
-- Structure de la table `time`
--

DROP TABLE IF EXISTS `time`;
CREATE TABLE IF NOT EXISTS `time` (
  `LECTUREID` int(11) NOT NULL,
  `SLOTEVENTID` int(11) NOT NULL,
  PRIMARY KEY (`LECTUREID`,`SLOTEVENTID`),
  KEY `I_FK_REL_2_LECTURE` (`LECTUREID`),
  KEY `I_FK_REL_2_SLOTEVENT` (`SLOTEVENTID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `time`
--

INSERT INTO `time` (`LECTUREID`, `SLOTEVENTID`) VALUES
(1, 1),
(1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `USERID` int(11) NOT NULL AUTO_INCREMENT,
  `FIRSTNAME` varchar(32) DEFAULT NULL,
  `LASTNAME` varchar(32) DEFAULT NULL,
  `USERNAME` varchar(32) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(32) DEFAULT NULL,
  `STATUS` varchar(32) NOT NULL,
  PRIMARY KEY (`USERID`),
  UNIQUE KEY `USERNAME` (`USERNAME`),
  KEY `user_ibfk_1` (`STATUS`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`USERID`, `FIRSTNAME`, `LASTNAME`, `USERNAME`, `PASSWORD`, `EMAIL`, `STATUS`) VALUES
(1, 'doriane', 'doriane', 'doriane', '827ccb0eea8a706c4c34a16891f84e7b', 'doriane@gmail.com', 'Administrateur'),
(2, 'dorina', 'doriane', 'dorina', '827ccb0eea8a706c4c34a16891f84e7b', 'doriane@gmail.com', 'Enseignant'),
(3, 'kevin', 'keviin', 'kevin', '827ccb0eea8a706c4c34a16891f84e7b', 'kevin@gmail.com', 'Etudiant');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `course_ibfk_1` FOREIGN KEY (`USERID`) REFERENCES `user` (`USERID`);

--
-- Contraintes pour la table `lecture`
--
ALTER TABLE `lecture`
  ADD CONSTRAINT `lecture_ibfk_1` FOREIGN KEY (`USERID`) REFERENCES `user` (`USERID`),
  ADD CONSTRAINT `lecture_ibfk_2` FOREIGN KEY (`COURSEID`) REFERENCES `course` (`COURSEID`),
  ADD CONSTRAINT `lecture_ibfk_3` FOREIGN KEY (`IDCLASSROOM`) REFERENCES `classroom` (`IDCLASSROOM`);

--
-- Contraintes pour la table `time`
--
ALTER TABLE `time`
  ADD CONSTRAINT `time_ibfk_1` FOREIGN KEY (`LECTUREID`) REFERENCES `lecture` (`LECTUREID`),
  ADD CONSTRAINT `time_ibfk_2` FOREIGN KEY (`SLOTEVENTID`) REFERENCES `slotevent` (`SLOTEVENTID`);

--
-- Contraintes pour la table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`STATUS`) REFERENCES `role` (`status`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
