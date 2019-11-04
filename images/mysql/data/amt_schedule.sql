-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 29 oct. 2019 à 01:48
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
-- Base de données :  `doriane`
--

-- -----------------------------------------------------
-- Schema course
-- -----------------------------------------------------

DROP SCHEMA IF EXISTS AMT_SCHEDULE;
CREATE SCHEMA IF NOT EXISTS AMT_SCHEDULE DEFAULT CHARACTER SET utf8 ;
USE AMT_SCHEDULE ;


-- --------------------------------------------------------

--
-- Structure de la table `appel`
--

DROP TABLE IF EXISTS `appel`;
CREATE TABLE IF NOT EXISTS `appel` (
  `MATRICULE` varchar(32) NOT NULL,
  `NUMPLAGE` int(11) NOT NULL,
  `RESTLINK` char(128) DEFAULT NULL,
  PRIMARY KEY (`MATRICULE`,`NUMPLAGE`),
  KEY `I_FK_APPEL_UTILISAREUR` (`MATRICULE`),
  KEY `I_FK_APPEL_PLAGE` (`NUMPLAGE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

DROP TABLE IF EXISTS `cours`;
CREATE TABLE IF NOT EXISTS `cours` (
  `MATRICULE` varchar(32) NOT NULL,
  `CODE` varchar(32) NOT NULL,
  `NUMPLAGE` int(11) NOT NULL,
  `TYPE` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`MATRICULE`,`CODE`,`NUMPLAGE`),
  KEY `I_FK_COURS_UTILISAREUR` (`MATRICULE`),
  KEY `I_FK_COURS_MATIERE` (`CODE`),
  KEY `I_FK_COURS_PLAGE` (`NUMPLAGE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `cours`
--

INSERT INTO `cours` (`MATRICULE`, `CODE`, `NUMPLAGE`, `TYPE`) VALUES
('16w2050', 'ICT201', 1, 'TP'),
('16w2050', 'ICT202', 2, 'TP');

-- --------------------------------------------------------

--
-- Structure de la table `date`
--

DROP TABLE IF EXISTS `date`;
CREATE TABLE IF NOT EXISTS `date` (
  `NUMERO` int(11) NOT NULL,
  `DEBUT` varchar(32) DEFAULT NULL,
  `FIN` varchar(32) DEFAULT NULL,
  `JOUR` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`NUMERO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `dispenser`
--

DROP TABLE IF EXISTS `dispenser`;
CREATE TABLE IF NOT EXISTS `dispenser` (
  `MATRICULE` varchar(32) NOT NULL,
  `CODE` varchar(32) NOT NULL,
  `OCCP` tinyint(1) DEFAULT NULL,
  `TYPE` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`MATRICULE`,`CODE`),
  KEY `I_FK_DISPENSER_UTILISAREUR` (`MATRICULE`),
  KEY `I_FK_DISPENSER_MATIERE` (`CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `dispenser`
--

INSERT INTO `dispenser` (`MATRICULE`, `CODE`, `OCCP`, `TYPE`) VALUES
('16w2182', 'ICT201', NULL, 'TP'),
('16w2182', 'ICT202', NULL, 'TP');

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

DROP TABLE IF EXISTS `evenement`;
CREATE TABLE IF NOT EXISTS `evenement` (
  `MATRICULE` varchar(32) NOT NULL,
  `NUMPLAGE` int(11) NOT NULL,
  `NUMERO` int(11) NOT NULL,
  `NIVEAU` int(11) NOT NULL,
  `CONTENANCE` int(11) DEFAULT NULL,
  `DESCRIPTION` char(255) DEFAULT NULL,
  `DUREE` int(11) DEFAULT NULL,
  `TITRE` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`MATRICULE`,`NUMPLAGE`,`NUMERO`,`NIVEAU`),
  KEY `I_FK_EVENEMENT_UTILISAREUR` (`MATRICULE`),
  KEY `I_FK_EVENEMENT_PLAGE` (`NUMPLAGE`),
  KEY `I_FK_EVENEMENT_DATE` (`NUMERO`),
  KEY `I_FK_EVENEMENT_NIVEAU` (`NIVEAU`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `matiere`
--

DROP TABLE IF EXISTS `matiere`;
CREATE TABLE IF NOT EXISTS `matiere` (
  `CODE` varchar(32) NOT NULL,
  `NIVEAU` int(11) NOT NULL,
  `INTITULE` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`CODE`),
  KEY `I_FK_MATIERE_NIVEAU` (`NIVEAU`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `matiere`
--

INSERT INTO `matiere` (`CODE`, `NIVEAU`, `INTITULE`) VALUES
('ICT201', 2, 'Graph'),
('ICT202', 2, 'Android');

-- --------------------------------------------------------

--
-- Structure de la table `niveau`
--

DROP TABLE IF EXISTS `niveau`;
CREATE TABLE IF NOT EXISTS `niveau` (
  `NIVEAU` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`NIVEAU`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `niveau`
--

INSERT INTO `niveau` (`NIVEAU`) VALUES
(1),
(2);

-- --------------------------------------------------------

--
-- Structure de la table `plage`
--

DROP TABLE IF EXISTS `plage`;
CREATE TABLE IF NOT EXISTS `plage` (
  `NUMPLAGE` int(11) NOT NULL AUTO_INCREMENT,
  `CODE` varchar(32) NOT NULL,
  `DEBUT` varchar(255) DEFAULT NULL,
  `FIN` varchar(255) DEFAULT NULL,
  `JOUR` varchar(255) DEFAULT NULL,
  `DUREE` int(11) DEFAULT NULL,
  `VALIDE` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`NUMPLAGE`),
  KEY `I_FK_PLAGE_SALLE` (`CODE`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `plage`
--

INSERT INTO `plage` (`NUMPLAGE`, `CODE`, `DEBUT`, `FIN`, `JOUR`, `DUREE`, `VALIDE`) VALUES
(1, 'S001', 'Fri Oct 25 2019 10:00:00', 'Fri Oct 25 2019 12:00:00', 'Fri Oct 25 2019', 2, 1),
(2, 'S001', 'Fri Oct 25 2019 04:00:00', 'Fri Oct 25 2019 16:00:00', 'Fri Oct 25 2019', 2, 1);

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

DROP TABLE IF EXISTS `salle`;
CREATE TABLE IF NOT EXISTS `salle` (
  `CODE` varchar(32) NOT NULL,
  `CONTENANCE` int(11) DEFAULT NULL,
  PRIMARY KEY (`CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `salle`
--

INSERT INTO `salle` (`CODE`, `CONTENANCE`) VALUES
('S001', 15),
('S002', 20);

-- --------------------------------------------------------

--
-- Structure de la table `traineau`
--

DROP TABLE IF EXISTS `traineau`;
CREATE TABLE IF NOT EXISTS `traineau` (
  `NUMERO` int(11) NOT NULL AUTO_INCREMENT,
  `MATRICULE` varchar(32) NOT NULL,
  `DEBUT` varchar(255) DEFAULT NULL,
  `FIN` varchar(255) DEFAULT NULL,
  `JOUR` varchar(255) DEFAULT NULL,
  `DUREE` int(11) DEFAULT NULL,
  PRIMARY KEY (`NUMERO`),
  KEY `I_FK_TRAINEAU_UTILISAREUR` (`MATRICULE`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `type`
--

DROP TABLE IF EXISTS `type`;
CREATE TABLE IF NOT EXISTS `type` (
  `STATUT` varchar(32) NOT NULL,
  PRIMARY KEY (`STATUT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `type`
--

INSERT INTO `type` (`STATUT`) VALUES
('Administrateur'),
('Enseignant'),
('Etudiant');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `MATRICULE` varchar(32) NOT NULL,
  `STATUT` varchar(32) NOT NULL,
  `EMAIL` varchar(32) DEFAULT NULL,
  `NOM` varchar(32) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `SEXE` tinyint(1) DEFAULT NULL,
  `GRADE` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`MATRICULE`),
  KEY `I_FK_UTILISAREUR_TYPE` (`STATUT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`MATRICULE`, `STATUT`, `EMAIL`, `NOM`, `PASSWORD`, `SEXE`, `GRADE`) VALUES
('16w2050', 'Enseignant', 'stephane@gmail.com', 'stephane', '827ccb0eea8a706c4c34a16891f84e7b', 1, 'Docteur'),
('16w2182', 'Etudiant', 'ulrichkev2017@gmail.com', 'Kevin', '827ccb0eea8a706c4c34a16891f84e7b', 1, 'Delegue'),
('root', 'Administrateur', 'doriane@gmail.com', 'doriane', 'root', 0, 'Delegue');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `appel`
--
ALTER TABLE `appel`
  ADD CONSTRAINT `appel_ibfk_1` FOREIGN KEY (`MATRICULE`) REFERENCES `utilisateur` (`MATRICULE`),
  ADD CONSTRAINT `appel_ibfk_2` FOREIGN KEY (`NUMPLAGE`) REFERENCES `plage` (`NUMPLAGE`);

--
-- Contraintes pour la table `cours`
--
ALTER TABLE `cours`
  ADD CONSTRAINT `cours_ibfk_1` FOREIGN KEY (`MATRICULE`) REFERENCES `utilisateur` (`MATRICULE`),
  ADD CONSTRAINT `cours_ibfk_2` FOREIGN KEY (`CODE`) REFERENCES `matiere` (`CODE`),
  ADD CONSTRAINT `cours_ibfk_3` FOREIGN KEY (`NUMPLAGE`) REFERENCES `plage` (`NUMPLAGE`);

--
-- Contraintes pour la table `dispenser`
--
ALTER TABLE `dispenser`
  ADD CONSTRAINT `dispenser_ibfk_1` FOREIGN KEY (`MATRICULE`) REFERENCES `utilisateur` (`MATRICULE`),
  ADD CONSTRAINT `dispenser_ibfk_2` FOREIGN KEY (`CODE`) REFERENCES `matiere` (`CODE`);

--
-- Contraintes pour la table `evenement`
--
ALTER TABLE `evenement`
  ADD CONSTRAINT `evenement_ibfk_1` FOREIGN KEY (`MATRICULE`) REFERENCES `utilisateur` (`MATRICULE`),
  ADD CONSTRAINT `evenement_ibfk_2` FOREIGN KEY (`NUMPLAGE`) REFERENCES `plage` (`NUMPLAGE`),
  ADD CONSTRAINT `evenement_ibfk_3` FOREIGN KEY (`NUMERO`) REFERENCES `date` (`NUMERO`),
  ADD CONSTRAINT `evenement_ibfk_4` FOREIGN KEY (`NIVEAU`) REFERENCES `niveau` (`NIVEAU`);

--
-- Contraintes pour la table `matiere`
--
ALTER TABLE `matiere`
  ADD CONSTRAINT `matiere_ibfk_1` FOREIGN KEY (`NIVEAU`) REFERENCES `niveau` (`NIVEAU`);

--
-- Contraintes pour la table `plage`
--
ALTER TABLE `plage`
  ADD CONSTRAINT `plage_ibfk_1` FOREIGN KEY (`CODE`) REFERENCES `salle` (`CODE`);

--
-- Contraintes pour la table `traineau`
--
ALTER TABLE `traineau`
  ADD CONSTRAINT `traineau_ibfk_1` FOREIGN KEY (`MATRICULE`) REFERENCES `utilisateur` (`MATRICULE`);

--
-- Contraintes pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `utilisateur_ibfk_1` FOREIGN KEY (`STATUT`) REFERENCES `type` (`STATUT`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
