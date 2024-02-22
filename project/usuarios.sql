-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-02-2024 a las 05:35:09
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `usuarios`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo-categorias`
--

CREATE TABLE `tipo-categorias` (
  `id` int(25) NOT NULL,
  `categoria` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `tipo-categorias`
--

INSERT INTO `tipo-categorias` (`id`, `categoria`) VALUES
(1, 'usuario'),
(2, 'admin');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios-uplc`
--

CREATE TABLE `usuarios-uplc` (
  `id` int(25) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `contrasenia` varchar(30) NOT NULL,
  `categorias_id` int(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `usuarios-uplc`
--

INSERT INTO `usuarios-uplc` (`id`, `usuario`, `contrasenia`, `categorias_id`) VALUES
(1, 'admin', 'admin1', 2),
(2, 'user1', 'user1', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tipo-categorias`
--
ALTER TABLE `tipo-categorias`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios-uplc`
--
ALTER TABLE `usuarios-uplc`
  ADD PRIMARY KEY (`id`),
  ADD KEY `categorias_id` (`categorias_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `usuarios-uplc`
--
ALTER TABLE `usuarios-uplc`
  MODIFY `id` int(25) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `usuarios-uplc`
--
ALTER TABLE `usuarios-uplc`
  ADD CONSTRAINT `usuarios-uplc_ibfk_1` FOREIGN KEY (`categorias_id`) REFERENCES `tipo-categorias` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
