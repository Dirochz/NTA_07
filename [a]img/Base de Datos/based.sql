-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-11-2022 a las 03:28:17
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Base de datos: `based`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `d_pedido`
--

CREATE TABLE `d_pedido` (
  `ID` int(7) NOT NULL,
  `ID_Folio` int(7) NOT NULL,
  `ID_Pro` int(7) NOT NULL,
  `Nom` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Cant` int(5) NOT NULL,
  `Precio` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Tabla Detalle Pedido';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `Folio` int(7) NOT NULL,
  `ID_Us` int(7) NOT NULL,
  `cliente` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `can` int(5) NOT NULL,
  `total` float NOT NULL,
  `cam` float NOT NULL,
  `Fecha` varchar(11) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Tabla Pedido';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `ID` int(7) NOT NULL,
  `Nom` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Tipo` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Talla` varchar(2) COLLATE utf8_unicode_ci NOT NULL,
  `Can` int(5) NOT NULL,
  `Pre` float NOT NULL,
  `Des` text COLLATE utf8_unicode_ci NOT NULL,
  `Dis` blob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Tabla Productos';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `ID` int(7) NOT NULL,
  `Nom` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ApPa` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `ApMa` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Cor` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `Nick` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Cont` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Tabla Usuario';

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`ID`, `Nom`, `ApPa`, `ApMa`, `Cor`, `Nick`, `Cont`) VALUES
(1, 'Admin', '', '', '', 'Admin', '1');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `d_pedido`
--
ALTER TABLE `d_pedido`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`Folio`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `d_pedido`
--
ALTER TABLE `d_pedido`
  MODIFY `ID` int(7) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `Folio` int(7) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `ID` int(7) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `ID` int(7) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;
