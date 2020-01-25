-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Янв 25 2020 г., 17:32
-- Версия сервера: 5.5.25
-- Версия PHP: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `nightclub`
--

-- --------------------------------------------------------

--
-- Структура таблицы `nightclubs`
--

CREATE TABLE IF NOT EXISTS `nightclubs` (
  `nightClubId` int(11) NOT NULL AUTO_INCREMENT,
  `nightClubName` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`nightClubId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=15 ;

--
-- Дамп данных таблицы `nightclubs`
--

INSERT INTO `nightclubs` (`nightClubId`, `nightClubName`) VALUES
(1, 'Bora-Bora'),
(2, 'Zeus'),
(3, 'Paradise'),
(4, 'Equator'),
(5, 'BeachClub'),
(6, 'BeachClub2'),
(7, 'Club #1'),
(9, 'Harley'),
(10, 'Adams'),
(11, 'Pesto'),
(12, 'Grand'),
(13, 'CoffeHouse'),
(14, 'DinDon');

-- --------------------------------------------------------

--
-- Структура таблицы `visitors`
--

CREATE TABLE IF NOT EXISTS `visitors` (
  `visitorId` int(11) NOT NULL AUTO_INCREMENT,
  `visitorName` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`visitorId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=27 ;

--
-- Дамп данных таблицы `visitors`
--

INSERT INTO `visitors` (`visitorId`, `visitorName`) VALUES
(1, 'Andrey'),
(2, 'Denis'),
(3, 'David'),
(4, 'Oleg'),
(5, 'Alex'),
(6, 'Anton'),
(7, 'Anton2'),
(8, 'Anna'),
(9, 'Gena'),
(10, 'Valentina'),
(14, 'Alla'),
(15, 'Helen'),
(16, 'Helen2'),
(19, 'Alice'),
(20, 'Roman'),
(21, 'Roman98'),
(22, 'Ruslan'),
(23, 'Tonya'),
(24, 'Liliian'),
(25, 'Liliia'),
(26, 'BBBB');

-- --------------------------------------------------------

--
-- Структура таблицы `visits`
--

CREATE TABLE IF NOT EXISTS `visits` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `visitorId` int(11) NOT NULL,
  `nightClubId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `visitorId` (`visitorId`),
  KEY `nightClubId` (`nightClubId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=20 ;

--
-- Дамп данных таблицы `visits`
--

INSERT INTO `visits` (`id`, `visitorId`, `nightClubId`) VALUES
(1, 1, 2),
(3, 2, 2),
(4, 2, 2),
(5, 3, 1),
(6, 4, 1),
(7, 5, 6),
(8, 6, 6),
(9, 7, 5),
(10, 8, 2),
(11, 8, 1),
(12, 8, 2),
(13, 8, 1),
(14, 8, 7),
(15, 8, 9),
(16, 8, 1),
(17, 8, 7),
(18, 25, 12),
(19, 24, 13);

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `visits`
--
ALTER TABLE `visits`
  ADD CONSTRAINT `visits_ibfk_1` FOREIGN KEY (`visitorId`) REFERENCES `visitors` (`visitorId`),
  ADD CONSTRAINT `visits_ibfk_2` FOREIGN KEY (`nightClubId`) REFERENCES `nightclubs` (`nightClubId`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
