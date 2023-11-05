-- phpMyAdmin SQL Dump
-- version 4.9.5deb2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Nov 05, 2023 at 04:50 PM
-- Server version: 8.0.35-0ubuntu0.20.04.1
-- PHP Version: 8.1.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `enigma`
--
CREATE DATABASE IF NOT EXISTS enigma;
-- --------------------------------------------------------

--
-- Table structure for table `bloc_calcul`
--

CREATE TABLE `bloc_calcul` (
  `id_bloc` varchar(50) NOT NULL,
  `solution` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `bloc_calcul`
--

INSERT INTO `bloc_calcul` (`id_bloc`, `solution`) VALUES
('1', 'python'),
('2', 'indigo'),
('3', 'banane');

-- --------------------------------------------------------

--
-- Table structure for table `calcul`
--

CREATE TABLE `calcul` (
  `id_calcul` varchar(50) NOT NULL,
  `formule` varchar(250) DEFAULT NULL,
  `place` int DEFAULT NULL,
  `id_bloc` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `calcul`
--

INSERT INTO `calcul` (`id_calcul`, `formule`, `place`, `id_bloc`) VALUES
('1', '(80-√16)/4 - 3', 1, '1'),
('10', '2x3⁴/9', 4, '2'),
('11', '2x3⁴/9-2', 5, '2'),
('12', '8²-7²', 6, '2'),
('13', '√√√√65536', 1, '3'),
('14', 'cos(0)', 2, '3'),
('15', '√√65536-2', 3, '3'),
('16', '(√586528x484517²)⁰', 4, '3'),
('17', '(√586528x484517²)⁰x√√65536-2', 5, '3'),
('18', '(√586528x484517²)⁰x√√65536-2-3³', 6, '3'),
('2', '5²+4x3-7/2', 2, '1'),
('3', '(√64+72)/4', 3, '1'),
('4', '-(50³-84²)/100-62.56', 4, '1'),
('5', '4x3.14+2.44', 5, '1'),
('6', '4x3.14+2.44-8/2³', 6, '1'),
('7', '√81', 1, '2'),
('8', '2√49', 2, '2'),
('9', '2³x/√4', 3, '2');

-- --------------------------------------------------------

--
-- Table structure for table `charade`
--

CREATE TABLE `charade` (
  `id_charade` varchar(50) NOT NULL,
  `charade` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `solution` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `charade`
--

INSERT INTO `charade` (`id_charade`, `charade`, `solution`) VALUES
('1', 'Mon premier est une couleur.<br><br>Mon deuxième est la 9ième lettre de l\'alphabet.<br><br>Mon troisième comporte six faces numérotées de 1 à  6.<br><br>Mon quatrième est le verbe pouvoir, au présent, à  la première personne.<br><br>Mon tout est un acteur américain.', 'JOHNNY DEPP'),
('2', 'Mon premier peut entourer une propriété comme une barrière végétale.<br><br>Les bébés boivent mon deuxième.<br><br>On porte mon troisième l\'hiver, pour ne pas avoir froid aux mains.<br><br>Mon quatrième est le masculin pluriel de celui.<br><br>Mon tout est nécessaire si l\'on veut avoir la classe.', 'ELEGANCE'),
('3', 'Mon premier est la huitième consonne de l\'alphabet.<br><br>Mon deuxième se dit au tennis lorsqu\'une balle sort de la surface de jeu.<br><br>Mon troisième est un légume.<br><br>Mon tout est une matière qui est assez élastique.', 'CAOUTCHOUC'),
('4', 'Mon premier sert à voler.<br><br>\r\nMon deuxième est la conjonction de coordination la plus utilisée.<br><br>\r\nMon troisième est le petit de la biche<br><br>\r\nMon tout est un animal.', 'ELEPHANT'),
('5', 'Mon premier est le contraire de froid.<br><br>Mon deuxième est le début du chant du coq.<br><br>Mon troisième est une note de musique.<br><br>Mon tout vous l\'adorer.', 'CHOCOLAT'),
('6', 'Mon premier est un oiseau noir à queue blanche.<br><br>Mon deuxième coule dans mes veines.<br><br>Mon troisième est un endroit de repos.<br><br>Mon tout est une fleur. ', 'PISSENLIT');

-- --------------------------------------------------------

--
-- Table structure for table `forme`
--

CREATE TABLE `forme` (
  `id_forme` varchar(50) NOT NULL,
  `nb_carre` varchar(10) DEFAULT NULL,
  `nb_croix` int DEFAULT NULL,
  `nb_etoile` varchar(10) DEFAULT NULL,
  `nb_rond` int DEFAULT NULL,
  `nb_triangle` varchar(10) DEFAULT NULL,
  `nb_gris` varchar(10) DEFAULT NULL,
  `nb_bleu` int DEFAULT NULL,
  `nb_orange` varchar(10) DEFAULT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `couleur` varchar(50) DEFAULT NULL,
  `image` varchar(250) DEFAULT NULL,
  `nombre` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `forme`
--

INSERT INTO `forme` (`id_forme`, `nb_carre`, `nb_croix`, `nb_etoile`, `nb_rond`, `nb_triangle`, `nb_gris`, `nb_bleu`, `nb_orange`, `nom`, `couleur`, `image`, `nombre`) VALUES
('1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'CARRE', 'BLEU', 'img/formes/CarreBleu.png', 16),
('10', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'ETOILE', 'GRIS', 'img/formes/EtoileGris.png', 20),
('11', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'ETOILE', 'ORANGE', 'img/formes/EtoileOrange.png', 14),
('12', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'ETOILE', 'VERT', 'img/formes/EtoileVert.png', 23),
('13', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'ROND', 'BLEU', 'img/formes/RondBleu.png', 17),
('14', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'ROND', 'GRIS', 'img/formes/RondGris.png', 15),
('15', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'ROND', 'ORANGE', 'img/formes/RondOrange.png', 16),
('16', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'ROND', 'VERT', 'img/formes/RondVert.png', 23),
('17', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'TRIANGLE', 'BLEU', 'img/formes/TriangleBleu.png', 18),
('18', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'TRIANGLE', 'GRIS', 'img/formes/TriangleGris.png', 21),
('19', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'TRIANGLE', 'ORANGE', 'img/formes/TriangleOrange.png', 19),
('2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'CARRE', 'GRIS', 'img/formes/CarreGris.png', 15),
('20', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'TRIANGLE', 'VERT', 'img/formes/TriangleVert.png', 21),
('3', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'CARRE', 'ORANGE', 'img/formes/CarreOrange.png', 17),
('4', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'CARRE', 'VERT', 'img/formes/CarreVert.png', 20),
('5', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'CROIX', 'BLEU', 'img/formes/CroixBleu.png', 12),
('6', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'CROIX', 'GRIS', 'img/formes/CroixGris.png', 25),
('7', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'CROIX', 'ORANGE', 'img/formes/CroixOrange.png', 14),
('8', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'CROIX', 'VERT', 'img/formes/CroixVert.png', 20),
('9', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'ETOILE', 'BLEU', 'img/formes/EtoileBleu.png', 20);

-- --------------------------------------------------------

--
-- Table structure for table `pays`
--

CREATE TABLE `pays` (
  `id_pays` varchar(50) NOT NULL,
  `continent` varchar(255) DEFAULT NULL,
  `fine` bit(1) DEFAULT NULL,
  `geoguesser` varchar(255) DEFAULT NULL,
  `littoral` bit(1) DEFAULT NULL,
  `nompays` varchar(50) DEFAULT NULL,
  `population_huit_millions` bit(1) DEFAULT NULL,
  `question_unique` varchar(255) DEFAULT NULL,
  `surface_million` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `pays`
--

INSERT INTO `pays` (`id_pays`, `continent`, `fine`, `geoguesser`, `littoral`, `nompays`, `population_huit_millions`, `question_unique`, `surface_million`) VALUES
('1', 'Europe', b'1', 'img/geoguesser/e165d4f2174b66a7d1a95cb204d296eb.jpg', b'1', 'France', b'1', 'Le pays est le deuxieme plus gros producteur de vin dans le monde', b'1'),
('10', 'Europe', b'0', 'img/geoguesser/3fae5630a818b04bc9585fa815707339.jpg', b'1', 'Royaume Uni', b'1', 'C\'est le seul pays au monde à avoir des gardes royaux portant des coiffes en poil d\'ours en guise de couvre-chef', b'1'),
('11', 'Europe', b'1', 'img/geoguesser/a619dc7f6a4804aace5aa28d5510077c.jpg', b'1', 'Belgique', b'1', 'Le pays compte le plus grand nombre de bandes dessinees par habitant au monde', b'0'),
('12', 'Europe', b'0', 'img/geoguesser/0fd041e6a0a829de56e2376408572b6d.jpg', b'1', 'Pays Bas', b'1', 'Le pays avec le plus grand nombre de moulins à vent historiques preserves', b'0'),
('13', 'Europe', b'1', 'img/geoguesser/9172c586d92458e517b2f28b5ab78094.jpg', b'1', 'Albanie', b'0', 'Le pays abrite le site archeologique de Butrint, un site classe au patrimoine mondial de l\'UNESCO, qui comprend des ruines anciennes, des theâtres romains, des thermes, et des vestiges d\'une cite antique', b'0'),
('14', 'Europe', b'1', 'img/geoguesser/f12a843f98ca50c41339ee6607a689c4.jpg', b'0', 'Bielorussie', b'1', 'Le pays abrite le parc national de Belovezhskaya Pushcha, qui est l\'une des dernieres forêts vierges d\'Europe et un site classe au patrimoine mondial de l\'UNESCO', b'0'),
('15', 'Europe', b'1', 'img/geoguesser/96ea191fa1f5ec7db6cd06d4be8b346c.jpg', b'1', 'Bosnie Herzegovine', b'0', 'Le pays abrite les pyramides de Visoko, un ensemble de montagnes et de formations rocheuses', b'0'),
('16', 'Europe', b'1', 'img/geoguesser/fc38ba258c4a88fce13f1f8a41ebd415.jpg', b'1', 'Bulgarie', b'0', 'C\'est le pays d\'origine du yaourt', b'0'),
('17', 'Asie', b'1', 'img/geoguesser/528fe57703736f840945f86d88d056a4.jpg', b'1', 'Chypre', b'0', 'C\'est le pays d\'origine du fromage halloumi, un fromage de brebis et de chevre', b'0'),
('18', 'Europe', b'1', 'img/geoguesser/a4235c50cd3ecd4904227a03219a9803.jpg', b'1', 'Croatie', b'0', 'C\'est le pays d\'origine de la cravate, qui tire son nom du mot \"hrvatska\"', b'0'),
('19', 'Europe', b'0', 'img/geoguesser/47efdff811993a5cadc78aa945a7f8bf.jpg', b'1', 'Danemark', b'0', 'C\'est le pays d\'origine de Lego, l\'une des marques de jouets les plus celebres au monde', b'1'),
('2', 'Europe', b'1', 'img/geoguesser/0e12667adfbd5b39b61ecc723f68eae2.jpg', b'1', 'Allemagne', b'1', 'Le pays abrite la plus grande fête de la biere au monde', b'0'),
('20', 'Europe', b'1', 'img/geoguesser/8b2b9cbb19550965583ad90460bd5849.jpg', b'1', 'Estonie', b'0', 'Le pays est le berceau de Skype, l\'une des premieres plateformes de communication en ligne au monde', b'0'),
('21', 'Europe', b'1', 'img/geoguesser/0530ddfb7e56a6198bd6fb72e9f6820d.jpg', b'1', 'Finlande', b'0', 'Le pays où se situe le village du Pere Noel, appele Rovaniemi, situe dans le cercle arctique', b'0'),
('22', 'Europe', b'1', 'img/geoguesser/a65b9e5fde8b6bc14d941be03d323232.jpg', b'1', 'Grece', b'1', 'Le pays possede 6 000 îles et îlots, seulement 200 environ sont habitees', b'0'),
('23', 'Europe', b'1', 'img/geoguesser/3a4604a5f7b6aedaaf36ad11f1f8580a.jpg', b'0', 'Hongrie', b'1', 'C\'est le pays d\'origine du rubik\'s cube, le celebre casse-tête tridimensionnel invente par Ernő Rubik en 1974', b'0'),
('24', 'Europe', b'1', 'img/geoguesser/a9740e3a7764b4518fb235f1aa64d722.jpg', b'1', 'Islande', b'0', 'C\'est le premier pays au monde qui consomme 100% d\'energie verte ou renouvelable\r\n', b'0'),
('25', 'Europe', b'1', 'img/geoguesser/cf05e50a3d1277bcacdc3665c919af24.jpg', b'1', 'Italie', b'1', 'Le pays possede le plus grand nombre de sites du patrimoine mondial de l\'UNESCO', b'0'),
('26', 'Europe', b'0', 'img/geoguesser/9eb4c22bacc6d9e92741b95750710b4f.jpg', b'0', 'Kosovo', b'0', 'C\'est le pays le plus recent d\'Europe, ayant declare son independance en 2008', b'0'),
('27', 'Europe', b'1', 'img/geoguesser/2f70a543b2ebcc4781f1d3b47d2d6985.jpg', b'1', 'Lettonie', b'0', 'Le pays celebre le festival du chant et de la danse, qui est inscrit sur la liste representative du patrimoine culturel immateriel de l\'humanite de l\'UNESCO', b'0'),
('28', 'Europe', b'1', 'img/geoguesser/d082e8a5c4bfe61257d53141efefc5a4.jpg', b'0', 'Autriche', b'1', 'Le pays natal de nombreux compositeurs .tels que Wolfgang Amadeus Mozart, Ludwig van Beethoven, Franz Schubert ou encore Johann Strauss', b'0'),
('29', 'Europe', b'0', 'img/geoguesser/5abfef79f0201629ea491351dfe984b1.jpg', b'0', 'Liechtenstein', b'0', 'C\'est le seul pays entierement situe dans les Alpes', b'0'),
('3', 'Europe', b'1', 'img/geoguesser/e7c83c5df7cc44681d872b63f96da820.jpg', b'1', 'Russie', b'1', 'Le pays possede le plus long chemin de fer du monde, qui s\'etend sur environ 9 289 kilometres, traversant huit fuseaux horaires', b'1'),
('30', 'Europe', b'1', 'img/geoguesser/795a28ea9ec7b5d4b989ac7de341bfb4.jpg', b'1', 'Lituanie', b'0', 'Le pays possede la plus grande dune de sable mobile d\'Europe, la dune de Parnidis', b'0'),
('31', 'Europe', b'0', 'img/geoguesser/068b83b0839d8cff627bd91fdc8059fb.jpg', b'0', 'Luxembourg', b'0', 'C\'est le seul pays- dans le monde dirige par un grand-duc', b'0'),
('32', 'Europe', b'0', 'img/geoguesser/50fcae303fe637636affcbc2aaa2c702.jpg', b'0', 'Macedoine du Nord', b'0', 'C\'est le pays natal de Mere Teresa, la celebre religieuse catholique et missionnaire, laureate du prix Nobel de la paix, qui a consacre sa vie à aider les pauvres et les malades à travers le monde', b'0'),
('33', 'Europe', b'1', 'img/geoguesser/08fbcb35375e363cdf2edbbfc702080f.jpg', b'1', 'Malte', b'0', 'Le pays possede l\'une des plus anciennes structures monumentales sur Terre, les temples megalithiques de Ġgantija, qui datent d\'environ 3 600 avant J.-C.', b'0'),
('34', 'Europe', b'1', 'img/geoguesser/c36ed0bdd7a9ff570fc16f1c648540ba.jpg', b'0', 'Modlavie', b'0', 'Le pays où se situe la plus grande cave à vin du monde. Elle abrite des millions de bouteilles de vin, dont certaines ont plus de 100 ans', b'0'),
('35', 'Europe', b'0', 'img/geoguesser/3f503b95abf55e326fdfc59c41612b97.jpg', b'1', 'Montenegro', b'0', 'Le pays possede la plage la plus longue de la mer Adriatique', b'0'),
('36', 'Europe', b'1', 'img/geoguesser/55841597240abfff74b6fb7601de8ce2.jpg', b'1', 'Norvege', b'0', 'Le pays compte le plus grand nombre de tunnels routiers au monde en raison de son paysage montagneux et de ses fjords', b'1'),
('37', 'Europe', b'1', 'img/geoguesser/d725f9bc74f06f3b564f6149bb44cee9.jpg', b'1', 'Pologne', b'1', 'C\'est le pays d\'origine de Marie Curie, la seule personne à avoir remporte des prix Nobel dans deux domaines scientifiques differents (physique et chimie)', b'0'),
('38', 'Europe', b'1', 'img/geoguesser/bbfb169cafd297de200bae6696fd21ed.jpg', b'0', 'Republique tcheque', b'1', 'C\'est le pays de naissance du Pilsner, le premier type de biere blond pâle au monde, qui est maintenant produit dans le monde entier', b'0'),
('39', 'Europe', b'1', 'img/geoguesser/66bbd441c72609436960797ab2a55196.jpg', b'1', 'Roumanie', b'1', 'C\'est le pays où se situe le château de Bran, souvent associe au legendaire comte Dracula', b'0'),
('4', 'Asie', b'1', 'img/geoguesser/6e62e5e563162fec76289efc4c162510.jpg', b'1', 'Russie', b'1', 'Le pays possede le plus long chemin de fer du monde, qui s\'etend sur environ 9 289 kilometres, traversant huit fuseaux horaires', b'1'),
('40', 'Europe', b'1', 'img/geoguesser/c8f759282d65d990e7197b257dc763a8.jpg', b'1', 'Turquie', b'1', 'C\'est le pays où se situe la ville de Troie, le site legendaire de la guerre de Troie, qui est decrit dans l\'Iliade d\'Homere', b'0'),
('41', 'Asie', b'1', 'img/geoguesser/9721c02ca7b4cb34cf0e96bd42d862f3.jpg', b'1', 'Turquie', b'1', 'C\'est le pays où se situe la ville de Troie, le site legendaire de la guerre de Troie, qui est decrit dans l\'Iliade d\'Homere', b'0'),
('42', 'Europe', b'1', 'img/geoguesser/b0aaf9d9535f9ba9080406c95aca85ab.jpg', b'0', 'Suisse', b'1', 'Le pays produit certaines des montres les plus prestigieuses et les plus recherchees au monde, avec des marques telles que Rolex, Patek Philippe, et Omega', b'0'),
('43', 'Europe', b'1', 'img/geoguesser/312e99eb5dc9f24b43cbded2ceb409e9.jpg', b'1', 'Suede', b'1', 'C\'est le premier pays au monde à avoir introduit une loi sur la liberte de presse en 1766', b'0'),
('44', 'Europe', b'1', 'img/geoguesser/2da2d08bf7c0f3b2d6f2083a0578ca06.jpg', b'1', 'Slovenie', b'0', 'Le pays abrite la plus ancienne vigne du monde, la vigne Žametovka, qui est cultivee depuis plus de 400 ans', b'0'),
('45', 'Europe', b'1', 'img/geoguesser/9797a86f1433d28bd27ff1165379c31d.jpg', b'0', 'Slovaquie', b'0', 'Le pays possede le plus grand nombre de châteaux par habitant au monde', b'0'),
('46', 'Europe', b'1', 'img/geoguesser/d7f629877469f6ab20765e0b33cc4a46.jpg', b'0', 'Serbie', b'0', 'C\'est le pays natal du celebre inventeur Nikola Tesla qui a fait des contributions majeures dans les domaines de l\'electricite et de la technologie', b'0'),
('47', 'Europe', b'1', 'img/geoguesser/4b0f1559226dc5c26d97dd4ef788a85a.jpg', b'1', 'Ukraine', b'1', 'Le pays abrite la ville de Tchernobyl, le site du pire accident nucleaire de l\'histoire en 1986', b'0'),
('48', 'Europe', b'0', 'img/geoguesser/c9ebae3bf971bf27617b591dc8468d61.jpg', b'0', 'Saint Marin', b'0', 'C\'est le plus ancien etat constitutionnel au monde, avec une constitution ecrite adoptee en 1600', b'0'),
('49', 'Europe', b'0', 'img/geoguesser/28d654b9b14454ee012f69d372ad4754.jpg', b'0', 'Vatican', b'0', 'C\'est le plus petit etat independant au monde, avec une superficie d\'environ 44 hectares', b'0'),
('5', 'Europe', b'0', 'img/geoguesser/ae0eea6eb6d63f98da42de867c47a0f8.jpg', b'1', 'Portugal', b'1', 'Le pays est le plus gros producteur de liege dans le monde', b'0'),
('50', 'Asie', b'0', 'img/geoguesser/a8424b7baae263918301406bdc884e28.jpg', b'0', 'Afghanistan', b'1', 'Le pays où se trouve la vallee de Bâmiyân, qui etait le site des statues de Bouddha de Bâmiyân, de grandes statues de Bouddha taillees dans la roche', b'0'),
('51', 'Asie', b'1', 'img/geoguesser/a04db8684740878d533d702bd06c62e3.jpg', b'1', 'Arabie Saoudite', b'1', 'C\'est le pays qui abrite La Mecque, la ville sainte de l\'islam', b'1'),
('52', 'Asie', b'1', 'img/geoguesser/656425402afa5678861ab1be24a02b0d.jpg', b'1', 'Armenie', b'0', 'Le pays a ete le premier à adopter le christianisme comme religion d\'etat en 301 apres J.-C., marquant ainsi l\'une des plus anciennes traditions chretiennes au monde', b'0'),
('53', 'Asie', b'0', 'img/geoguesser/842d768a7211b482e22919ffd68126c6.jpg', b'0', 'Azerbaidjan', b'1', 'Le pays abrite le lac Goygol, un lac d\'origine volcanique entoure de montagnes', b'0'),
('54', 'Asie', b'0', 'img/geoguesser/8f3e95ef1316c85c396a6d43ea0d908b.jpg', b'1', 'Bahrein', b'0', 'Le pays abrite le celebre circuit international de Sakhir, qui accueille la Formule 1 chaque annee', b'0'),
('55', 'Asie', b'0', 'img/geoguesser/b47bc9c3971a24ddbbfd211d7b692227.jpg', b'1', 'Bangladesh', b'1', 'Le pays abrite le plus grand delta interieur au monde, le delta du Gange-Brahmapoutre, qui est forme par les fleuves Gange et Brahmapoutre', b'0'),
('56', 'Asie', b'0', 'img/geoguesser/2a686997f73318acd21a0b0f53fad735.jpg', b'0', 'Bhoutan', b'0', 'Le pays est le seul au monde à mesurer son succes sur la base du Bonheur National Brut (BNB) plutôt que du Produit Interieur Brut (PIB)', b'0'),
('57', 'Asie', b'0', 'img/geoguesser/a7aae4f0bc2ea0ddfb8d68ce32c9261f.jpg', b'1', 'Myanmar', b'1', 'Le pays abrite la pagode Shwedagon, l\'un des sites religieux les plus sacres au monde. Cette pagode doree s\'eleve à plus de 99 metres de hauteur et est ornee de milliers de diamants, de rubis, d\'emeraudes et d\'autres pierres precieuses', b'0'),
('58', 'Asie', b'0', 'img/geoguesser/0be0d89a7660a0f90bc223b97924a527.jpg', b'1', 'Brunei', b'0', 'Le pays abrite le plus grand palais residentiel au monde, le palais d\'Istana Nurul Iman', b'0'),
('59', 'Asie', b'1', 'img/geoguesser/0311245cfe42eef50db71fe9495f503d.jpg', b'1', 'Cambodge', b'1', 'C\'est le pays où se situent les temples d\'Angkor, y compris le celebre temple d\'Angkor Wat. Ces temples sont le temoignage de l\'ancienne civilisation khmere et sont un site classe au patrimoine mondial de l\'UNESCO', b'0'),
('6', 'Europe', b'1', 'img/geoguesser/1b7a159bafb44549dacebec344b13011.jpeg', b'1', 'Espagne', b'1', 'La danse de flamenco est originaire de ce pays', b'0'),
('60', 'Asie', b'1', 'img/geoguesser/4178b6fa162a2711fbeb38c18246b04e.jpg', b'1', 'Chine', b'1', 'Le pays est le plus peuple au monde, abritant plus d\'un cinquieme de la population mondiale', b'1'),
('61', 'Asie', b'0', 'img/geoguesser/358aa252ef398db98cc39a111f95bd26.jpg', b'1', 'Coree du Nord', b'1', 'C\'est le pays le plus isole politiquement et economiquement au monde, avec un contrôle strict sur les medias, la communication et les mouvements de la population', b'0'),
('62', 'Asie', b'0', 'img/geoguesser/4bebd680369598bf6579be4e9060b8ff.jpg', b'0', 'Coree du Sud', b'1', 'Le pays est le berceau de grandes entreprises technologiques comme Samsung, LG et Hyundai', b'0'),
('63', 'Asie', b'0', 'img/geoguesser/19d30877fcc9d44eef7107ececa526e0.jpg', b'1', 'emirats arabes unis', b'1', 'Le pays possede la ville de Dubai, qui est le lieu de la plus haute structure artificielle au monde, la tour Burj Khalifa, avec 828 metres de hauteur', b'0'),
('64', 'Asie', b'1', 'img/geoguesser/4dec553d60d2c60cc4d89a0cccab725e.jpg', b'1', 'Georgie', b'0', 'Le pays est le berceau de la viticulture, avec une tradition viticole vieille de 8 000 ans', b'0'),
('65', 'Asie', b'1', 'img/geoguesser/faa32043ff129b28b322183f9177fafa.jpg', b'1', 'Inde', b'1', 'Le pays a le plus grand nombre de langues parlees au monde, avec plus de 1 600 langues reconnues', b'1'),
('66', 'Asie', b'1', 'img/geoguesser/f15124a7793b59e0090df8e604704ef1.jpg', b'1', 'Indonesie', b'1', 'C\'est le pays du monde qui abrite le plus grand nombre de volcans actifs', b'1'),
('67', 'Asie', b'0', 'img/geoguesser/c370dbef29c10c123d89f0bb815970a6.jpg', b'1', 'Irak', b'1', 'C\'est le pays qui abrite les ruines de Babylone, l\'une des plus anciennes villes connues de l\'histoire humaine', b'0'),
('68', 'Asie', b'0', 'img/geoguesser/6f0a7d56c2cd7a0861b17eb27bfb562b.jpg', b'1', 'Iran', b'1', 'Le pays abrite la ville de Yazd, qui est l\'une des plus anciennes villes continuellement habitees au monde, avec une histoire remontant à plus de 3 000 ans', b'1'),
('69', 'Asie', b'0', 'img/geoguesser/3f8454b7f2c12cebb1622b6b0dfd1021.jpg', b'1', 'Israel', b'1', 'C\'est le seul pays au monde où l\'hebreu est une langue officielle', b'0'),
('7', 'Europe', b'1', 'img/geoguesser/a317adaa3ef44055107a9ba4bc9b7c38.jpg', b'0', 'Andorre', b'0', 'Le pays est le seul à avoir pour langue officielle à la fois le catalan, le français et l\'espagnol.', b'0'),
('70', 'Asie', b'0', 'img/geoguesser/7cb51895c351c3b0e2afbbda27e873a2.jpg', b'1', 'Japon', b'1', 'C\'est le pays du monde avec le plus grand nombre de distributeurs automatiques par habitant', b'0'),
('71', 'Asie', b'1', 'img/geoguesser/0c1536ced5a3cd31c29257693ff342ce.jpg', b'1', 'Jordanie', b'1', 'C\'est le pays où se situe la cite antique de Petra, un site classe au patrimoine mondial de l\'UNESCO. Petra est celebre pour ses bâtiments tailles dans la roche, elle est consideree comme l\'une des merveilles du monde', b'0'),
('72', 'Asie', b'0', 'img/geoguesser/e22cc0a14faacf60ca06cebdc972caa5.jpg', b'0', 'Kazakhstan', b'1', 'C\'est le pays du monde avec le plus grand nombre de lacs de montagne', b'1'),
('73', 'Asie', b'0', 'img/geoguesser/a9177d7e91bc945f3354f2ba980e715c.jpg', b'0', 'Kirghizistan', b'0', 'Le pays abrite le lac Issyk-Koul, le deuxieme plus grand lac de montagne au monde', b'0'),
('74', 'Asie', b'0', 'img/geoguesser/28876375c9747b0dc64a896d0cc4cd60.jpg', b'1', 'Koweit', b'0', 'C\'est le pays du monde qui a le plus grand nombre de gratte-ciel par habitant', b'0'),
('75', 'Asie', b'0', 'img/geoguesser/5495a2f9ee0ac16f7ee35878f502eefb.jpg', b'0', 'Laos', b'0', 'Le pays abrite la ville de Luang Prabang, un site classe au patrimoine mondial de l\'UNESCO. Luang Prabang est celebre pour son architecture coloniale française bien preservee et ses temples bouddhistes', b'0'),
('76', 'Asie', b'0', 'img/geoguesser/d5731ec6ca6364dbb3f154de1c5f8fff.jpg', b'1', 'Liban', b'0', 'Le pays abrite la plus ancienne ville en activite continue, Byblos (ou Jbeil en arabe). Byblos a une histoire qui remonte à plus de 7 000 ans et est associee à l\'invention de l\'alphabet', b'0'),
('77', 'Asie', b'1', 'img/geoguesser/4259cae7572437bcc8f98a497b5c42b2.jpg', b'1', 'Malaisie', b'1', 'Le pays où se trouve l\'une des plus anciennes forêts tropicales du monde, la forêt tropicale de Belum-Temengor', b'0'),
('78', 'Asie', b'0', 'img/geoguesser/ebc234df81245f7bff973231d9393981.jpg', b'1', 'Maldives', b'0', 'Le pays le plus plat du monde, avec une altitude maximale d\'environ 2,4 metres au-dessus du niveau de la mer', b'0'),
('79', 'Asie', b'1', 'img/geoguesser/f057495280d465d41a5356e2cb2b0894.jpg', b'0', 'Mongolie', b'0', 'Le pays natal de Gengis Khan, le celebre chef de guerre du XIIIe siecle, qui est devenu l\'un des plus grands conquerants de l\'histoire', b'1'),
('8', 'Europe', b'0', 'img/geoguesser/77f09e1229462ba78b6a10825319ba12.jpg', b'1', 'Monaco', b'0', 'C\'est le pays le plus densement peuple au monde.', b'0'),
('80', 'Asie', b'0', 'img/geoguesser/45f1a4b4a2f6bdfa31838a823064389f.jpg', b'0', 'Nepal', b'1', 'Le pays abrite la plus haute montagne du monde, le mont Everest, avec une altitude de 8 848 metres ', b'0'),
('81', 'Asie', b'0', 'img/geoguesser/ad437fd2f44c7b3f8208a162604d81d0.jpg', b'1', 'Oman', b'0', 'Le pays abrite la plus grande grotte du monde par volume, la grotte de Majlis Al Jinn', b'0'),
('82', 'Asie', b'0', 'img/geoguesser/f1054f8b7755791e6f24e9b69fa1b69c.jpg', b'0', 'Ouzbekistan', b'1', 'Le pays abrite certaines des plus anciennes villes bien preservees de la Route de la Soie, notamment Samarcande, Boukhara et Khiva', b'0'),
('83', 'Asie', b'0', 'img/geoguesser/4e075844d2e00e4c800c8c62716bed8c.jpg', b'1', 'Pakistan', b'1', 'Le pays abrite la plus haute autoroute pavee au monde, la route de la Karakoram', b'0'),
('84', 'Asie', b'0', 'img/geoguesser/c894df42aa06fcb0e8e3ff55b71b33fd.jpg', b'1', 'Philippines', b'1', 'Le pays est le seul majoritairement catholique en Asie, heritage de plus de 300 ans de colonisation espagnole', b'0'),
('85', 'Asie', b'0', 'img/geoguesser/7d8ca47bbe17ba692ed007c859ba51b1.jpg', b'1', 'Qatar', b'0', 'Le pays le plus riche au monde en termes de PIB par habitant, en grande partie grâce à ses vastes reserves de gaz naturel', b'0'),
('86', 'Asie', b'0', 'img/geoguesser/4cac76ac3552396cc154d123fe2f58a0.jpg', b'1', 'Singapour', b'0', 'C\'est la ville-etat la plus propre au monde, grâce à des politiques strictes de gestion des dechets et à un fort engagement en faveur de la proprete', b'0'),
('87', 'Asie', b'0', 'img/geoguesser/8ba5bbdd9e0c11077dbf5a9cc83d1c45.jpg', b'1', 'Sri Lanka', b'1', 'Le pays abrite le rocher de Sigirîya, un site classe au patrimoine mondial de l\'UNESCO', b'0'),
('88', 'Asie', b'1', 'img/geoguesser/4cecfbfb1b91bdac36c0ba20027275b2.jpg', b'1', 'Syrie', b'1', 'Le pays où se situe la ville antique de Palmyre, egalement connue sous le nom de Tadmor en arabe. Palmyre etait un centre commercial et culturel important de l\'Antiquite, situe au carrefour des routes commerciales reliant l\'Orient et l\'Occident', b'0'),
('89', 'Asie', b'0', 'img/geoguesser/a0074b450ed102eedd29b26bf123f811.jpg', b'0', 'Tadjikistan', b'1', 'Le pays abrite le plus haut sommet du monde situe entierement à l\'interieur des frontieres d\'un seul pays, le pic Ismoil Somoni (anciennement connu sous le nom de pic du Communisme)', b'0'),
('9', 'Europe', b'1', 'img/geoguesser/d10ec283cf65f0a94c5f81f1f1d98526.jpg', b'1', 'Irlande', b'0', 'Le pays est souvent appelee l\'île d\'emeraude en raison de son paysage verdoyant.', b'0'),
('90', 'Asie', b'0', 'img/geoguesser/31779ba135934ed036644deb47eb1e54.jpg', b'1', 'Taiwan', b'1', 'C\'est le pays natal de l\'acteur Bruce Lee, qui est devenu une icône mondiale des arts martiaux et du cinema d\'action', b'0'),
('91', 'Asie', b'1', 'img/geoguesser/805c97b05cc89066594afbf7fa2d3f94.jpg', b'1', 'Thailande', b'1', 'Le pays du monde où se trouve le plus grand nombre de temples bouddhistes', b'0'),
('92', 'Asie', b'0', 'img/geoguesser/7e58137cb33c85ee1127185fac1083e73.jpg', b'1', 'Timor oriental', b'0', 'C\'est le premier pays d\'Asie à devenir independant au XXIe siecle', b'0'),
('93', 'Asie', b'0', 'img/geoguesser/963f79ea1a99aefb8a7318ee388dcdd9.jpg', b'0', 'Turkmenistan', b'0', 'Le pays où se situe la porte de l\'Enfer, egalement connue sous le nom de Darvaza', b'0'),
('94', 'Asie', b'0', 'img/geoguesser/5f8f9e33bb5e13848af2622b66b2308c.jpg', b'1', 'Vietnam', b'1', 'C\'est le pays où se trouve la baie d\'Along, un site classe au patrimoine mondial de l\'UNESCO', b'0');

-- --------------------------------------------------------

--
-- Table structure for table `poeme`
--

CREATE TABLE `poeme` (
  `id_poeme` varchar(50) NOT NULL,
  `poeme` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `solution` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `poeme`
--

INSERT INTO `poeme` (`id_poeme`, `poeme`, `solution`) VALUES
('1', 'Cher Ruel Stroud, malicieux énutrof,<br><br> \r\n\"Il s\'en ira, kamas ou pas.\", qu\'ils me disaient. Je refusais de les croire. \"Il<br><br>\r\nte hait indiciblement, à cause de tout ce que tu lui coûtes.\" J\'étais dévastée.<br><br>	\r\nPourtant, nous nous aimions à l\'envi, et n\'amenions que bonheur partout<br><br>\r\noù nous passions. Ni gérants ni rois n\'étaient plus riches que nous, car<br><br>\r\nnotre amour valait tout l\'or du Krosmoz. Malgré cette attitude infâme,<br><br>	\r\nj\'osais, et j\'ose encore, espérer... Tu seras vaincu. Battre en retraite ne<br><br>	\r\nte sauvera plus. Tu as l\'air d\'un pouilleux, radin que tu es. Pagne, haut,<br><br>\r\nsandales: voilà vingt-cinq ans qu\'il te faut en changer. Ton gain prime sur<br><br>	\r\nta vieille Arpagone... Pallier mon déficit sentimental ne t\'intéresse pas.<br><br>', 'MALIIRAKHAITIVIETNAMNIGERGRECECUBAESPAGNETONGANEPAL'),
('2', 'Si mon existence t\'importe encore, sache que j\'ai résidé à Brâkmar. Occa-<br><br>	\r\nsionnellement, je vagabondais vers Bonta, pour affaires. Je suis tout de<br><br>\r\nmême parvenue à m\'enrichir, tu sais. Là, oscillant entre bien et mal, entre<br><br>	\r\nces deux cités, j\'espérais te retrouver. Béni ne soit pas notre inutile dieu.<br><br>\r\nJe suis seule, depuis des décennies, délaissée par un mari cupide et sans<br><br>\r\ndescendance. Je ne pouvais lutter contre tous les payements que j\'engen-<br><br>\r\ndrais. Ton goût pour l\'argent, inébranlable, m\'a peut-être effacée de ta<br><br>\r\nmémoire. Il suffit! Ton empire sur moi est aboli. Vie sans Stroud envisa-<br><br>\r\ngeable! Vas-y, rien ne saurait t\'arrêter. Je ne te retiens plus, désormais.<br><br>\r\nㅤㅤㅤㅤㅤㅤㅤTon Arpagone, programmée pour t\'aimer, telle une machine<br><br>', 'MAROCGABONLAOSBENINSUISSEYEMENARGENTINEBOLIVIESYRIECHINE'),
('3', '    Сеttе sаngsuе dе mоnаrquе а еnfin реrdu. Sоn аrméе n\'а su défеndrе<br><br>\r\nсе vil rоуаumе - un immоndе tеrritоirе quе j\'аi mоi-mêmе аutrеfоis<br><br>\r\nsеrvi - еt n\'а mêmе раs еu lе рlаisir dе рrétеndrе à lа viсtоirе un sеul<br><br>\r\ninstаnt. Nоus nоus sоmmеs bаttus соmmе dеs оmbrеs. Ils nе рurеnt<br><br>\r\nnоus аttеindrе, сеs sоldаts, аlоrs quе се рutsсh inеsрéré роur lа libеrté<br><br>\r\nétаit еn trаin dе défеrlеr sur еuх tеllе unе рuissаntе vаguе аu раssаgе<br><br>\r\nd\'un tурhоn. Griеfs dе tаnt d\'аnnéеs sе tеnаiеnt justе là, реrsоnnifiés.<br><br>\r\nВiеn mаlin qui l\'еût rесоnnuе, \"Sоn Аltеssе\", sоbrеmеnt vêtuе d\'un<br><br>\r\nvulgаirе mаntеаu еt déсоréе d\'un оrdinаirе сhареrоn. Соmmе un viеuх<br><br>\r\nvаgаbоnd sаns un sеul sоu еn росhе, еllе s\'аррrêtаit à fuir lе fоrt.<br><br>', 'SUEDEROYAUMEUNIVIETNAMBRESILCHINEINDEHONGRIEMALICOREEDUNORDGABON'),
('4', 'Sоus lе bruit dеs саnоns, d\'inсеssаnts \"bаng\", là, dеs hеurеs durаnt,<br><br>\r\nnоus аvаnсiоns. Lе mаrаthоn durа sерt hеurеs, jusqu\'à lа nuit. Unе<br><br>	\r\nnuit роur l\'Нistоirе, à lаquеllе lе соq а tаrdivеmеnt mis fin, саr, арrès<br><br>	\r\ntоut, \"Fluсtuаt nес mеrgitur\". Qui étаit-il, finаlеmеnt, се sоuvеrаin,<br><br>\r\nроur роssédеr се drоit dе nоus аssеrvir ? Sоn fiеf mаl tеnu nе роuvаit<br><br>\r\nреrdurеr. Il s\'еn еst аinsi аllé, еt nе sаurаit dоrénаvаnt rеvеnir. А nоtrе<br><br>\r\nреuрlе lа libеrté ! Сhеr аmi, dеs rоmаns sеrоnt insрirés dе nоs ехрlоits.<br><br>\r\nQuаnt à mоi, еt mаlgré се suссès рrоbаnt, jе nе sаurаis guèrе iсi<br><br>	\r\nm\'étеrnisеr. Вiеn quе vаinсu, lе rоi а tоujоurs dеs fidèlеs, еt lеs risquеs<br><br>\r\nроur mа viе sоnt ассrus si еn сеs tеrrеs délivréеs mаis frаgilеs jе rеstе.<br><br>\r\n', 'BANGLADESHHONDURASQATARTURQUIEMALTEIRANOMANGRECESERBIERUSSIE');

-- --------------------------------------------------------

--
-- Table structure for table `simon`
--

CREATE TABLE `simon` (
  `idpatern` varchar(50) NOT NULL,
  `patern` varchar(250) DEFAULT NULL,
  `solution` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `simon`
--

INSERT INTO `simon` (`idpatern`, `patern`, `solution`) VALUES
('1', 'img/patern/Patern1.png', '1 3 4 10 13 19 21 22'),
('2', 'img/patern/Patern2.png', '1 9 12 13 20 22 24 25'),
('3', 'img/patern/Patern3.png', '1 6 9 15 16 17 19 21'),
('4', 'img/patern/Patern4.png', '4 7 10 12 13 17 20 24'),
('5', 'img/patern/Patern5.png', '1 5 6 7 9 16 19 20 21 22 25'),
('6', 'img/patern/Patern6.png', '2 3 6 8 9 10 13 15 17 23 25');

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `email` varchar(50) NOT NULL,
  `mdp` varchar(250) DEFAULT NULL,
  `niveau` int DEFAULT NULL,
  `nom` varchar(250) DEFAULT NULL,
  `prenom` varchar(250) DEFAULT NULL,
  `vie` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`email`, `mdp`, `niveau`, `nom`, `prenom`, `vie`) VALUES
('admin@admin.fr', 'admin', 9, 'adminNom', 'adminPrenom', 5),
('user@user.fr', 'user', NULL, 'Dupont', 'Michel', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bloc_calcul`
--
ALTER TABLE `bloc_calcul`
  ADD PRIMARY KEY (`id_bloc`);

--
-- Indexes for table `calcul`
--
ALTER TABLE `calcul`
  ADD PRIMARY KEY (`id_calcul`),
  ADD KEY `FKt6ia8ffeab2q5nnvuekj21kn3` (`id_bloc`);

--
-- Indexes for table `charade`
--
ALTER TABLE `charade`
  ADD PRIMARY KEY (`id_charade`);

--
-- Indexes for table `forme`
--
ALTER TABLE `forme`
  ADD PRIMARY KEY (`id_forme`);

--
-- Indexes for table `pays`
--
ALTER TABLE `pays`
  ADD PRIMARY KEY (`id_pays`);

--
-- Indexes for table `poeme`
--
ALTER TABLE `poeme`
  ADD PRIMARY KEY (`id_poeme`);

--
-- Indexes for table `simon`
--
ALTER TABLE `simon`
  ADD PRIMARY KEY (`idpatern`);

--
-- Indexes for table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`email`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `calcul`
--
ALTER TABLE `calcul`
  ADD CONSTRAINT `FKt6ia8ffeab2q5nnvuekj21kn3` FOREIGN KEY (`id_bloc`) REFERENCES `bloc_calcul` (`id_bloc`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;