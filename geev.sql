-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 31 jan. 2022 à 19:36
-- Version du serveur : 10.4.22-MariaDB
-- Version de PHP : 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `geev`
--

-- --------------------------------------------------------

--
-- Structure de la table `annonce`
--

CREATE TABLE `annonce` (
  `id_annonce` bigint(20) NOT NULL,
  `adresse_de_recuperation` varchar(255) NOT NULL,
  `date` date DEFAULT NULL,
  `description` varchar(255) NOT NULL,
  `image` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `personne_id_personne` bigint(20) DEFAULT NULL,
  `statut_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `annonce`
--

INSERT INTO `annonce` (`id_annonce`, `adresse_de_recuperation`, `date`, `description`, `image`, `title`, `personne_id_personne`, `statut_id`) VALUES
(46, 'alger', '2022-01-28', 'bon etat', 'annonce1.jpg', 'tele', 4, 2),
(47, 'Paris, 13 ieme', '2022-01-28', 'au top', 'B3.PNG', 'Offre téléphone', 4, 2),
(48, 'Paris, 13 ieme', '2022-01-28', 'Très grand', 'Capture8.PNG', 'miroir', 4, 2),
(50, 'alger', '2022-01-29', 'top', 'Capture10.PNG', 'Offre téléphone', 4, 1),
(51, 'Paris, 13 ieme', '2022-01-29', 'Bon état', 'Capture16.PNG', 'Offre téléphone', 4, 1),
(52, 'alger', '2022-01-29', 'Neuf', 'Capture11.PNG', 'Offre ordinateur', 29, 3),
(58, 'Paris, 13 ieme', '2022-01-31', 'Bon état, taille S, Couleur beige', 'monteau.PNG', 'manteau ', 29, 1),
(60, 'Paris, 13 ieme', '2022-01-31', 'bien', 'chemise.PNG', 'Mixeur ', 29, 1),
(61, 'Massy ', '2022-01-31', 'en état de marche, couleur : noire', 'mixeur.PNG', 'Mixeur ', 29, 1);

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

CREATE TABLE `commentaire` (
  `date` date NOT NULL,
  `id_annonce` bigint(20) NOT NULL,
  `id_personne` bigint(20) NOT NULL,
  `description` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `commentaire`
--

INSERT INTO `commentaire` (`date`, `id_annonce`, `id_personne`, `description`) VALUES
('2022-01-23', 19, 2, 'jlkjkd j\'aime bcp'),
('2022-01-31', 61, 29, 'j\'aime beaucoup !');

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(62);

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

CREATE TABLE `personne` (
  `id_personne` bigint(20) NOT NULL,
  `description` varchar(255) NOT NULL,
  `email` varchar(50) NOT NULL,
  `nom` varchar(25) NOT NULL,
  `prenom` varchar(25) NOT NULL,
  `telephone` bigint(20) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `personne`
--

INSERT INTO `personne` (`id_personne`, `description`, `email`, `nom`, `prenom`, `telephone`, `password`) VALUES
(2, 'je suis le plus fort', 'lqskjdlsqkd@dfljg', 'lalou', 'qsdqsdqsd', 767867, ''),
(3, 'je suis le plus fort', 'lqskjdlsqkd@dfljg', 'lalou', 'qsdqsdqsd', 767867, ''),
(4, 'je suis le plus fort', 'lqskjdlsqkd@dfljg', 'lalou', 'qsdqsdqsd', 767867, ''),
(5, 'je suis le plus fort', 'lqskjdlsqkd@dfljg', 'lalou', 'qsdqsdqsd', 767867, ''),
(29, '', 'redalalou01@gmail.com', 'LALOU', 'Reda', 540890301, 'oiok');

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

CREATE TABLE `reservation` (
  `date` date NOT NULL,
  `id_annonce` bigint(20) NOT NULL,
  `id_personne` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`date`, `id_annonce`, `id_personne`) VALUES
('2022-01-28', 46, 4),
('2022-01-28', 47, 4),
('2022-01-28', 48, 4),
('2022-01-29', 46, 4),
('2022-01-29', 47, 4),
('2022-01-29', 47, 29),
('2022-01-29', 50, 29),
('2022-01-29', 52, 29);

-- --------------------------------------------------------

--
-- Structure de la table `statut`
--

CREATE TABLE `statut` (
  `id` bigint(20) NOT NULL,
  `libelle` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `statut`
--

INSERT INTO `statut` (`id`, `libelle`) VALUES
(1, 'libre'),
(2, 'reservée'),
(3, 'donnée');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `annonce`
--
ALTER TABLE `annonce`
  ADD PRIMARY KEY (`id_annonce`),
  ADD KEY `FKisksndbxhdwkq1s5cilnpou4i` (`personne_id_personne`),
  ADD KEY `FKq4mpsb6fw6duevpjjlmkhq69c` (`statut_id`);

--
-- Index pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD PRIMARY KEY (`date`,`id_annonce`,`id_personne`),
  ADD KEY `FKs1xwsrjm7y01yuqnpg819aa9w` (`id_annonce`),
  ADD KEY `FKslevetghp1wm3jj1oc8bfm7ov` (`id_personne`);

--
-- Index pour la table `personne`
--
ALTER TABLE `personne`
  ADD PRIMARY KEY (`id_personne`);

--
-- Index pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`date`,`id_annonce`,`id_personne`),
  ADD KEY `FKbnh29o9y75msgl6w98857gli5` (`id_annonce`),
  ADD KEY `FKp07dkl3acd5tk4wndd3tq63e5` (`id_personne`);

--
-- Index pour la table `statut`
--
ALTER TABLE `statut`
  ADD PRIMARY KEY (`id`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `annonce`
--
ALTER TABLE `annonce`
  ADD CONSTRAINT `FKisksndbxhdwkq1s5cilnpou4i` FOREIGN KEY (`personne_id_personne`) REFERENCES `personne` (`id_personne`),
  ADD CONSTRAINT `FKq4mpsb6fw6duevpjjlmkhq69c` FOREIGN KEY (`statut_id`) REFERENCES `statut` (`id`);

--
-- Contraintes pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD CONSTRAINT `FKs1xwsrjm7y01yuqnpg819aa9w` FOREIGN KEY (`id_annonce`) REFERENCES `annonce` (`id_annonce`),
  ADD CONSTRAINT `FKslevetghp1wm3jj1oc8bfm7ov` FOREIGN KEY (`id_personne`) REFERENCES `personne` (`id_personne`);

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `FKbnh29o9y75msgl6w98857gli5` FOREIGN KEY (`id_annonce`) REFERENCES `annonce` (`id_annonce`),
  ADD CONSTRAINT `FKp07dkl3acd5tk4wndd3tq63e5` FOREIGN KEY (`id_personne`) REFERENCES `personne` (`id_personne`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
