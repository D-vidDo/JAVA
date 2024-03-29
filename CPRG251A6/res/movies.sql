-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.3.14-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table cprg251.movies
DROP TABLE IF EXISTS `movies`;
CREATE TABLE IF NOT EXISTS `movies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `duration` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `year` year(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=501 DEFAULT CHARSET=LATIN1;

-- Dumping data for table cprg251.movies: ~500 rows (approximately)
DELETE FROM `movies`;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` (`id`, `duration`, `title`, `year`) VALUES
	(1, 141, 'Wonder Woman', '2017'),
	(2, 129, 'Beauty and the Beast', '2017'),
	(3, 113, 'Baby Driver', '2017'),
	(4, 102, 'Big Hero 6', '2014'),
	(5, 108, 'Deadpool', '2016'),
	(6, 137, 'Guardians of the Galaxy Vol. 2', '2017'),
	(7, 162, 'Avatar', '2009'),
	(8, 101, 'John Wick', '2014'),
	(9, 145, 'Gone Girl', '2014'),
	(10, 123, 'The Hunger Games: Mockingjay - Part 1', '2014'),
	(11, 140, 'War for the Planet of the Apes', '2017'),
	(12, 147, 'Captain America: Civil War', '2016'),
	(13, 154, 'Pulp Fiction', '1994'),
	(14, 129, 'Pirates of the Caribbean: Dead Men Tell No Tales', '2017'),
	(15, 152, 'The Dark Knight', '2008'),
	(16, 117, 'Blade Runner', '1982'),
	(17, 143, 'The Avengers', '2012'),
	(18, 89, 'Captain Underpants: The First Epic Movie', '2017'),
	(19, 110, 'The Circle', '2017'),
	(20, 119, 'The Bad Batch', '2017'),
	(21, 113, 'The Maze Runner', '2014'),
	(22, 130, 'Dawn of the Planet of the Apes', '2014'),
	(23, 122, 'Alien: Covenant', '2017'),
	(24, 107, 'Ghost in the Shell', '2017'),
	(25, 87, 'Boyka: Undisputed IV', '2016'),
	(26, 105, 'Whiplash', '2014'),
	(27, 139, 'Fight Club', '1999'),
	(28, 123, 'What Happened to Monday', '2017'),
	(29, 90, 'Wish Upon', '2017'),
	(30, 137, 'Logan', '2017'),
	(31, 121, 'Guardians of the Galaxy', '2014'),
	(32, 89, '47 Meters Down', '2017'),
	(33, 142, 'The Shawshank Redemption', '1994'),
	(34, 99, 'The Last King', '2016'),
	(35, 95, 'The Dark Tower', '2017'),
	(36, 122, 'John Wick: Chapter 2', '2017'),
	(37, 136, 'The Fate of the Furious', '2017'),
	(38, 142, 'Forrest Gump', '1994'),
	(39, 143, 'Pirates of the Caribbean: The Curse of the Black Pearl', '2003'),
	(40, 87, 'Security', '2017'),
	(41, 109, 'The Legend of Tarzan', '2016'),
	(42, 126, 'King Arthur: Legend of the Sword', '2017'),
	(43, 115, 'Doctor Strange', '2016'),
	(44, 123, 'Suicide Squad', '2016'),
	(45, 121, 'Star Wars', '1977'),
	(46, 115, 'Ted 2', '2015'),
	(47, 195, 'Schindler\'s List', '1993'),
	(48, 105, 'Rise of the Planet of the Apes', '2011'),
	(49, 132, 'Maze Runner: The Scorch Trials', '2015'),
	(50, 175, 'The Godfather', '1972'),
	(51, 133, 'Fantastic Beasts and Where to Find Them', '2016'),
	(52, 125, 'Spirited Away', '2001'),
	(53, 111, 'Wind River', '2017'),
	(54, 129, 'Now You See Me 2', '2016'),
	(55, 116, 'Life Is Beautiful', '1997'),
	(56, 149, 'Transformers: The Last Knight', '2017'),
	(57, 98, 'Before I Fall', '2017'),
	(58, 152, 'Harry Potter and the Philosopher\'s Stone', '2001'),
	(59, 122, 'Girls Trip', '2017'),
	(60, 99, '0.0986111111111111', '2017'),
	(61, 141, 'Avengers: Age of Ultron', '2015'),
	(62, 104, 'Get Out', '2017'),
	(63, 109, 'Psycho', '1960'),
	(64, 135, 'Fury', '2014'),
	(65, 96, 'Despicable Me 3', '2017'),
	(66, 200, 'The Godfather: Part II', '1974'),
	(67, 133, 'Rogue One: A Star Wars Story', '2016'),
	(68, 89, 'Lucy', '2014'),
	(69, 103, 'Life', '2017'),
	(70, 127, 'Miss Peregrine\'s Home for Peculiar Children', '2016'),
	(71, 93, 'The Beguiled', '2017'),
	(72, 140, 'Operation Mekong', '2016'),
	(73, 116, 'Baywatch', '2017'),
	(74, 133, 'One Flew Over the Cuckoo\'s Nest', '1975'),
	(75, 112, 'Thor: The Dark World', '2013'),
	(76, 130, 'A Silent Voice', '2016'),
	(77, 106, 'Your Name.', '2016'),
	(78, 190, 'Dilwale Dulhania Le Jayenge', '1995'),
	(79, 110, 'Me Before You', '2016'),
	(80, 102, 'The Mother of Tears', '2007'),
	(81, 124, 'The Twilight Saga: Eclipse', '2010'),
	(82, 131, 'Pacific Rim', '2013'),
	(83, 110, 'The Mummy', '2017'),
	(84, 86, 'The Emoji Movie', '2017'),
	(85, 93, 'Rescue Under Fire', '2017'),
	(86, 133, 'Creed', '2015'),
	(87, 136, 'The Matrix', '1999'),
	(88, 125, 'Fifty Shades of Grey', '2015'),
	(89, 124, 'Jurassic World', '2015'),
	(90, 169, 'Interstellar', '2014'),
	(91, 229, 'Once Upon a Time in America', '1984'),
	(92, 178, 'The Lord of the Rings: The Fellowship of the Ring', '2001'),
	(93, 113, 'Edge of Tomorrow', '2014'),
	(94, 86, 'The Autopsy of Jane Doe', '2016'),
	(95, 144, 'The Hobbit: The Battle of the Five Armies', '2014'),
	(96, 136, 'Star Wars: The Force Awakens', '2015'),
	(97, 113, 'The Imitation Game', '2014'),
	(98, 151, 'Batman v Superman: Dawn of Justice', '2016'),
	(99, 169, 'Pirates of the Caribbean: At World\'s End', '2007'),
	(100, 98, 'Collide', '2016'),
	(101, 122, 'Twilight', '2008'),
	(102, 136, 'The Amazing Spider-Man', '2012'),
	(103, 107, 'Dunkirk', '2017'),
	(104, 113, 'Arrival', '2016'),
	(105, 134, '12 Years a Slave', '2013'),
	(106, 120, 'Chappie', '2015'),
	(107, 126, 'Terminator Genisys', '2015'),
	(108, 88, 'The House', '2017'),
	(109, 130, 'The Twilight Saga: New Moon', '2009'),
	(110, 161, 'Harry Potter and the Chamber of Secrets', '2002'),
	(111, 151, 'Pirates of the Caribbean: Dead Man\'s Chest', '2006'),
	(112, 118, 'Kong: Skull Island', '2017'),
	(113, 179, 'The Lord of the Rings: The Two Towers', '2002'),
	(114, 121, 'Spider-Man', '2002'),
	(115, 120, 'Mad Max: Fury Road', '2015'),
	(116, 201, 'The Lord of the Rings: The Return of the King', '2003'),
	(117, 115, 'Thor', '2011'),
	(118, 118, 'Fifty Shades Darker', '2017'),
	(119, 148, 'Inception', '2010'),
	(120, 117, 'Split', '2016'),
	(121, 144, 'X-Men: Apocalypse', '2016'),
	(122, 140, 'Batman Begins', '2005'),
	(123, 141, 'Harry Potter and the Prisoner of Azkaban', '2004'),
	(124, 92, 'The Saint', '2017'),
	(125, 130, 'Kingsman: The Secret Service', '2015'),
	(126, 91, 'Diary of a Wimpy Kid: The Long Haul', '2017'),
	(127, 136, 'Pirates of the Caribbean: On Stranger Tides', '2011'),
	(128, 119, 'Insurgent', '2015'),
	(129, 104, 'The Purge: Anarchy', '2014'),
	(130, 139, 'Spider-Man 3', '2007'),
	(131, 115, 'Assassin\'s Creed', '2016'),
	(132, 97, 'Sex Tape', '2014'),
	(133, 137, 'Furious 7', '2015'),
	(134, 97, 'Dark Skies', '2013'),
	(135, 194, 'Titanic', '1997'),
	(136, 117, 'Ant-Man', '2015'),
	(137, 118, 'Pan\'s Labyrinth', '2006'),
	(138, 137, 'The Hunger Games: Mockingjay - Part 2', '2015'),
	(139, 142, 'The Amazing Spider-Man 2', '2014'),
	(140, 116, 'World War Z', '2013'),
	(141, 115, 'The Twilight Saga: Breaking Dawn - Part 2', '2012'),
	(142, 131, 'X-Men: Days of Future Past', '2014'),
	(143, 108, 'Zootopia', '2016'),
	(144, 117, 'The Twilight Saga: Breaking Dawn - Part 1', '2011'),
	(145, 88, 'Don\'t Breathe', '2016'),
	(146, 116, 'Back to the Future', '1985'),
	(147, 141, 'The Martian', '2015'),
	(148, 100, 'Finding Nemo', '2003'),
	(149, 110, 'Colossal', '2017'),
	(150, 146, 'The Hunger Games: Catching Fire', '2013'),
	(151, 116, 'Self/less', '2015'),
	(152, 111, 'Kill Bill: Vol. 1', '2003'),
	(153, 100, 'The Hangover Part III', '2013'),
	(154, 130, 'Harry Potter and the Deathly Hallows: Part 2', '2011'),
	(155, 148, 'Spectre', '2015'),
	(156, 89, 'Sleight', '2017'),
	(157, 74, 'Black Mirror: White Christmas', '2014'),
	(158, 157, 'Harry Potter and the Goblet of Fire', '2005'),
	(159, 98, 'Despicable Me 2', '2013'),
	(160, 83, 'No Good Deed', '2014'),
	(161, 105, 'The Book of Henry', '2017'),
	(162, 102, 'Rings', '2017'),
	(163, 90, 'Child\'s Play 3', '1991'),
	(164, 108, 'A Monster Calls', '2016'),
	(165, 92, 'A Ghost Story', '2017'),
	(166, 101, 'Rough Night', '2017'),
	(167, 126, 'The Fifth Element', '1997'),
	(168, 102, 'Frozen', '2013'),
	(169, 93, 'Overdrive', '2017'),
	(170, 94, 'Inside Out', '2015'),
	(171, 124, 'The Mummy', '1999'),
	(172, 102, 'Grown Ups', '2010'),
	(173, 104, 'A Dog\'s Will', '2000'),
	(174, 100, 'The Hangover', '2009'),
	(175, 130, 'Iron Man 3', '2013'),
	(176, 103, 'DragonHeart', '1996'),
	(177, 103, 'Saw', '2004'),
	(178, 156, 'The Revenant', '2015'),
	(179, 84, 'Beauty and the Beast', '1991'),
	(180, 120, 'The Big Sick', '2017'),
	(181, 117, 'Alien', '1979'),
	(182, 146, 'Harry Potter and the Deathly Hallows: Part 1', '2010'),
	(183, 169, 'The Hobbit: An Unexpected Journey', '2012'),
	(184, 124, 'Power Rangers', '2017'),
	(185, 99, 'Annabelle', '2014'),
	(186, 86, 'The Purge', '2013'),
	(187, 155, 'Gladiator', '2000'),
	(188, 144, 'Casino Royale', '2006'),
	(189, 78, 'The Jungle Book', '1967'),
	(190, 91, 'Fist Fight', '2017'),
	(191, 118, 'Train to Busan', '2016'),
	(192, 137, 'Terminator 2: Judgment Day', '1991'),
	(193, 149, '2001: A Space Odyssey', '1968'),
	(194, 101, 'Teenage Mutant Ninja Turtles', '2014'),
	(195, 130, 'Tomorrowland', '2015'),
	(196, 95, 'Despicable Me', '2010'),
	(197, 115, 'The Incredibles', '2004'),
	(198, 138, 'Angels & Demons', '2009'),
	(199, 92, 'Penguins of Madagascar', '2014'),
	(200, 107, 'Ghostbusters', '1984'),
	(201, 126, 'Iron Man', '2008'),
	(202, 102, 'The Wizard of Oz', '1939'),
	(203, 115, 'Charlie and the Chocolate Factory', '2005'),
	(204, 112, 'Stonehearst Asylum', '2014'),
	(205, 81, 'Toy Story', '1995'),
	(206, 102, 'The Hangover Part II', '2011'),
	(207, 96, 'I.T.', '2016'),
	(208, 140, 'The Lost City of Z', '2016'),
	(209, 137, 'Aliens', '1986'),
	(210, 169, 'Saving Private Ryan', '1998'),
	(211, 123, 'Seven Pounds', '2008'),
	(212, 89, 'The Lion King', '1994'),
	(213, 139, 'Divergent', '2014'),
	(214, 136, 'Kill Bill: Vol. 2', '2004'),
	(215, 119, 'Enigma', '2001'),
	(216, 91, 'I Spit on Your Grave III: Vengeance is Mine', '2015'),
	(217, 124, 'Jupiter Ascending', '2015'),
	(218, 138, 'Harry Potter and the Order of the Phoenix', '2007'),
	(219, 143, 'Cast Away', '2000'),
	(220, 117, 'Nightcrawler', '2014'),
	(221, 125, 'TRON: Legacy', '2010'),
	(222, 147, 'Straight Outta Compton', '2015'),
	(223, 88, 'Mulan', '1998'),
	(224, 105, 'Pixels', '2015'),
	(225, 110, 'The Key', '1983'),
	(226, 119, 'The Bourne Identity', '2002'),
	(227, 140, 'Hacksaw Ridge', '2016'),
	(228, 117, 'The Pursuit of Happyness', '2006'),
	(229, 108, 'Horrible Bosses 2', '2014'),
	(230, 76, 'Eight Crazy Nights', '2002'),
	(231, 109, 'Terminator 3: Rise of the Machines', '2003'),
	(232, 177, 'Braveheart', '1995'),
	(233, 122, 'American Beauty', '1999'),
	(234, 85, 'Amityville: The Awakening', '2017'),
	(235, 93, 'Scouts Guide to the Zombie Apocalypse', '2015'),
	(236, 145, 'Minority Report', '2002'),
	(237, 122, 'Star Trek Beyond', '2016'),
	(238, 161, 'The Hobbit: The Desolation of Smaug', '2013'),
	(239, 121, 'Underworld', '2003'),
	(240, 102, 'Sin City: A Dame to Kill For', '2014'),
	(241, 165, 'The Dark Knight Rises', '2012'),
	(242, 114, 'San Andreas', '2015'),
	(243, 111, 'Ratatouille', '2007'),
	(244, 91, 'It Comes at Night', '2017'),
	(245, 124, 'Beautiful Creatures', '2013'),
	(246, 110, 'Leon: The Professional', '1994'),
	(247, 108, 'The Bourne Supremacy', '2004'),
	(248, 89, 'S.W.A.T.: Under Siege', '2017'),
	(249, 100, 'It Follows', '2015'),
	(250, 117, 'Amazing Grace', '2006'),
	(251, 167, 'The Hateful Eight', '2015'),
	(252, 143, 'Skyfall', '2012'),
	(253, 116, 'Passengers', '2016'),
	(254, 110, 'Top Gun', '1986'),
	(255, 95, 'Kidnap', '2017'),
	(256, 132, 'V for Vendetta', '2006'),
	(257, 100, 'Ice Age: Collision Course', '2016'),
	(258, 93, 'Black Butterfly', '2017'),
	(259, 108, 'Sing', '2016'),
	(260, 142, 'The Hunger Games', '2012'),
	(261, 91, 'Underworld: Blood Wars', '2016'),
	(262, 89, 'Derailed', '2002'),
	(263, 189, 'The Green Mile', '1999'),
	(264, 108, 'American Pastoral', '2016'),
	(265, 129, 'Live by Night', '2016'),
	(266, 110, 'Dr. No', '1962'),
	(267, 116, 'War of the Worlds', '2005'),
	(268, 129, 'Dead Poets Society', '1989'),
	(269, 115, 'Raiders of the Lost Ark', '1981'),
	(270, 87, 'The Woman in Red', '1984'),
	(271, 141, 'Catch Me If You Can', '2002'),
	(272, 87, 'Child\'s Play', '1988'),
	(273, 101, 'Equals', '2015'),
	(274, 105, 'Cinderella', '2015'),
	(275, 165, 'Django Unchained', '2012'),
	(276, 187, 'King Kong', '2005'),
	(277, 124, 'Jaws', '1975'),
	(278, 128, 'La La Land', '2016'),
	(279, 90, 'Factory Girl', '2006'),
	(280, 106, 'Non-Stop', '2014'),
	(281, 106, 'Ted', '2012'),
	(282, 112, 'Beauty and the Beast', '2014'),
	(283, 144, 'The Shining', '1980'),
	(284, 99, 'Hercules', '2014'),
	(285, 154, 'The Last Samurai', '2003'),
	(286, 93, 'Iron Sky', '2012'),
	(287, 97, 'Night at the Museum: Secret of the Tomb', '2014'),
	(288, 112, 'Super 8', '2011'),
	(289, 114, 'The Emerald Forest', '1985'),
	(290, 121, 'Sicario', '2015'),
	(291, 124, 'The Empire Strikes Back', '1980'),
	(292, 97, 'Maleficent', '2014'),
	(293, 106, 'The Runaways', '2010'),
	(294, 106, 'Fantastic Four', '2005'),
	(295, 115, 'E.T. the Extra-Terrestrial', '1982'),
	(296, 93, 'Trainspotting', '1996'),
	(297, 96, 'Up', '2009'),
	(298, 124, 'Captain America: The First Avenger', '2011'),
	(299, 93, 'Bandidas', '2006'),
	(300, 108, 'The Terminator', '1984'),
	(301, 127, 'Real Steel', '2011'),
	(302, 103, 'Mr. Holmes', '2015'),
	(303, 127, 'Dawn of the Dead', '1978'),
	(304, 96, 'Vice', '2015'),
	(305, 133, 'American Sniper', '2014'),
	(306, 96, 'The Bye Bye Man', '2017'),
	(307, 107, 'The Adventures of Tintin', '2011'),
	(308, 109, 'Cars 3', '2017'),
	(309, 101, 'xXx: State of the Union', '2005'),
	(310, 123, 'Jason Bourne', '2016'),
	(311, 114, 'The Incredible Hulk', '2008'),
	(312, 126, 'Batman', '1989'),
	(313, 157, 'Zodiac', '2007'),
	(314, 153, 'Harry Potter and the Half-Blood Prince', '2009'),
	(315, 124, 'Iron Man 2', '2010'),
	(316, 123, 'Mission: Impossible II', '2000'),
	(317, 107, 'The Hills Have Eyes', '2006'),
	(318, 93, 'Undisputed II: Last Man Standing', '2006'),
	(319, 119, 'High-Rise', '2015'),
	(320, 131, 'National Treasure', '2004'),
	(321, 130, 'The Perfect Storm', '2000'),
	(322, 116, 'Nocturnal Animals', '2016'),
	(323, 117, 'Cars', '2006'),
	(324, 123, 'Blade: Trinity', '2004'),
	(325, 66, '9 Songs', '2004'),
	(326, 100, 'Sister Act', '1992'),
	(327, 124, 'Die Hard 2', '1990'),
	(328, 120, 'The BFG', '2016'),
	(329, 140, 'Apollo 13', '1995'),
	(330, 127, 'Snow White and the Huntsman', '2012'),
	(331, 136, 'Captain America: The Winter Soldier', '2014'),
	(332, 94, 'Once Upon a Time in Venice', '2017'),
	(333, 129, 'Sherlock Holmes: A Game of Shadows', '2011'),
	(334, 109, 'The Scorpion King: Rise of a Warrior', '2008'),
	(335, 81, 'Chicken Little', '2005'),
	(336, 149, 'The Da Vinci Code', '2006'),
	(337, 92, 'The Pink Panther 2', '2009'),
	(338, 119, 'French Connection II', '1975'),
	(339, 143, 'Man of Steel', '2013'),
	(340, 151, 'The Departed', '2006'),
	(341, 79, '9', '2009'),
	(342, 91, 'Gravity', '2013'),
	(343, 107, 'Predator', '1987'),
	(344, 165, 'Transformers: Age of Extinction', '2014'),
	(345, 110, 'We\'re the Millers', '2013'),
	(346, 148, 'Brimstone', '2017'),
	(347, 85, 'Lilo & Stitch', '2002'),
	(348, 116, 'Prince of Persia: The Sands of Time', '2010'),
	(349, 127, 'Se7en', '1995'),
	(350, 84, 'Passenger 57', '1992'),
	(351, 107, 'The Sixth Sense', '1999'),
	(352, 100, 'Carrie', '2013'),
	(353, 121, 'Allegiant', '2016'),
	(354, 95, 'American Pie', '1999'),
	(355, 98, 'Six Days Seven Nights', '1998'),
	(356, 121, 'Inferno', '2016'),
	(357, 113, 'Donnie Darko', '2001'),
	(358, 96, 'Sully', '2016'),
	(359, 130, 'Need for Speed', '2014'),
	(360, 124, 'The Punisher', '2004'),
	(361, 108, 'On the Waterfront', '1954'),
	(362, 128, 'Vertigo', '1958'),
	(363, 120, 'Platoon', '1986'),
	(364, 119, 'Birdman', '2014'),
	(365, 126, 'Spy Game', '2001'),
	(366, 147, 'Mulholland Drive', '2001'),
	(367, 115, 'The Bourne Ultimatum', '2007'),
	(368, 119, 'American History X', '1998'),
	(369, 125, 'Flying Swords of Dragon Gate', '2011'),
	(370, 93, 'Annie Hall', '1977'),
	(371, 117, '300', '2006'),
	(372, 109, 'Taken 3', '2014'),
	(373, 122, '3:10 to Yuma', '2007'),
	(374, 144, '13 Hours: The Secret Soldiers of Benghazi', '2016'),
	(375, 105, 'Disturbia', '2007'),
	(376, 90, 'Shark Tale', '2004'),
	(377, 90, 'Shrek', '2001'),
	(378, 117, 'Their Finest', '2017'),
	(379, 90, 'Identity', '2003'),
	(380, 108, 'School of Rock', '2003'),
	(381, 166, 'The Curious Case of Benjamin Button', '2008'),
	(382, 170, 'Heat', '1995'),
	(383, 107, 'xXx: Return of Xander Cage', '2017'),
	(384, 112, 'Rear Window', '1954'),
	(385, 141, 'The Judge', '2014'),
	(386, 113, '3 Days to Kill', '2014'),
	(387, 13, 'Michael Jackson\'s Thriller', '1983'),
	(388, 115, 'Now You See Me', '2013'),
	(389, 131, 'Mission: Impossible - Rogue Nation', '2015'),
	(390, 94, 'Life of Crime', '2013'),
	(391, 112, 'Planet of the Apes', '1968'),
	(392, 110, 'Operation Chromite', '2016'),
	(393, 76, 'The Nightmare Before Christmas', '1993'),
	(394, 109, 'A Man Apart', '2003'),
	(395, 94, 'Dogtooth', '2009'),
	(396, 97, 'Legend of the Guardians: The Owls of Ga\'Hoole', '2010'),
	(397, 113, '28 Days Later', '2002'),
	(398, 148, 'Anna and the King', '1999'),
	(399, 117, 'T2 Trainspotting', '2017'),
	(400, 145, 'Independence Day', '1996'),
	(401, 130, 'Kung Fu Yoga', '2017'),
	(402, 132, 'The Equalizer', '2014'),
	(403, 105, 'Edward Scissorhands', '1990'),
	(404, 137, 'Child 44', '2015'),
	(405, 97, 'Sinister 2', '2015'),
	(406, 143, 'The Great Gatsby', '2013'),
	(407, 83, 'Sausage Party', '2016'),
	(408, 94, 'Addams Family Values', '1993'),
	(409, 92, 'Toy Story 2', '1999'),
	(410, 115, 'The Founder', '2016'),
	(411, 128, 'Showgirls', '1995'),
	(412, 83, 'The Little Mermaid', '1989'),
	(413, 106, 'The Jungle Book', '2016'),
	(414, 105, 'Wild Orchid', '1989'),
	(415, 90, 'Saw VI', '2009'),
	(416, 81, 'Ice Age', '2002'),
	(417, 119, 'Planet of the Apes', '2001'),
	(418, 125, 'Trainwreck', '2015'),
	(419, 108, 'Alice in Wonderland', '2010'),
	(420, 117, 'Kick-Ass', '2010'),
	(421, 114, 'The Huntsman: Winter\'s War', '2016'),
	(422, 103, 'Insidious', '2010'),
	(423, 100, 'Fantastic Four', '2015'),
	(424, 89, 'Amateur Night', '2016'),
	(425, 117, 'Holes', '2003'),
	(426, 120, 'True Romance', '1993'),
	(427, 125, 'A Most Violent Year', '2014'),
	(428, 162, 'The Godfather: Part III', '1990'),
	(429, 118, 'Two Is a Family', '2016'),
	(430, 134, 'Princess Mononoke', '1997'),
	(431, 116, 'Ghostbusters', '2016'),
	(432, 119, 'Tomorrow Never Dies', '1997'),
	(433, 104, 'Robin Hood: Men in Tights', '1993'),
	(434, 114, 'Alien³', '1992'),
	(435, 136, 'A Clockwork Orange', '1971'),
	(436, 84, 'Teen Titans: The Judas Contract', '2017'),
	(437, 118, 'Lion', '2016'),
	(438, 104, 'The Lego Batman Movie', '2017'),
	(439, 117, 'Blade II', '2002'),
	(440, 97, 'When the Bough Breaks', '2016'),
	(441, 125, 'Batman & Robin', '1997'),
	(442, 106, 'Mine', '2016'),
	(443, 97, 'The Boy', '2016'),
	(444, 94, 'Paul Blart: Mall Cop 2', '2015'),
	(445, 104, 'Jumanji', '1995'),
	(446, 120, 'Independence Day: Resurgence', '2016'),
	(447, 120, 'The Social Network', '2010'),
	(448, 89, 'Smurfs: The Lost Village', '2017'),
	(449, 103, 'Toy Story 3', '2010'),
	(450, 130, 'The Mummy Returns', '2001'),
	(451, 130, 'The Prestige', '2006'),
	(452, 107, 'Danny Collins', '2015'),
	(453, 90, 'Kung Fu Panda', '2008'),
	(454, 153, 'Inglourious Basterds', '2009'),
	(455, 135, 'Waterworld', '1995'),
	(456, 116, 'Highlander', '1986'),
	(457, 95, 'A Bug\'s Life', '1998'),
	(458, 77, 'Peter Pan', '1953'),
	(459, 114, 'Run All Night', '2015'),
	(460, 92, 'Trolls', '2016'),
	(461, 109, 'The Thing', '1982'),
	(462, 127, 'Hidden Figures', '2016'),
	(463, 104, 'Who Framed Roger Rabbit', '1988'),
	(464, 100, 'Ricki and the Flash', '2015'),
	(465, 128, 'Dracula', '1992'),
	(466, 88, 'Men in Black II', '2002'),
	(467, 100, 'A Mighty Heart', '2007'),
	(468, 97, 'Irreversible', '2002'),
	(469, 107, 'Field of Dreams', '1989'),
	(470, 117, 'The A-Team', '2010'),
	(471, 145, 'The Handmaiden', '2016'),
	(472, 83, 'Spirit: Stallion of the Cimarron', '2002'),
	(473, 92, 'The Fury of a Patient Man', '2016'),
	(474, 85, 'High Noon', '1952'),
	(475, 158, '2012', '2009'),
	(476, 108, 'Night at the Museum', '2006'),
	(477, 91, 'Ice Age: The Meltdown', '2006'),
	(478, 94, 'Badlands', '1973'),
	(479, 111, 'The Omen', '1976'),
	(480, 131, 'Die Hard', '1988'),
	(481, 100, 'Coraline', '2009'),
	(482, 109, 'Law Abiding Citizen', '2009'),
	(483, 127, 'Basic Instinct', '1992'),
	(484, 90, 'Saw: The Final Chapter', '2010'),
	(485, 124, 'Prometheus', '2012'),
	(486, 97, 'The Princess and the Frog', '2009'),
	(487, 99, 'Jaws 3-D', '1983'),
	(488, 96, 'Tron', '1982'),
	(489, 163, 'Watchmen', '2009'),
	(490, 85, 'The Shrine', '2010'),
	(491, 89, 'Ballerina', '2016'),
	(492, 139, 'Open Range', '2003'),
	(493, 100, 'Resident Evil: Damnation', '2012'),
	(494, 119, 'Velvet Goldmine', '1998'),
	(495, 119, 'Captain Fantastic', '2016'),
	(496, 115, 'Terminator Salvation', '2009'),
	(497, 96, '12 Angry Men', '1957'),
	(498, 75, 'Alice in Wonderland', '1951'),
	(499, 138, 'American Hustle', '2013'),
	(500, 120, 'The Rock', '1996');
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
moviesmovies