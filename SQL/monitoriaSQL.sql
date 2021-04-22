-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Tempo de geração: 22-Abr-2021 às 00:59
-- Versão do servidor: 5.7.31
-- versão do PHP: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `monitoria`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno_monit`
--

DROP TABLE IF EXISTS `aluno_monit`;
CREATE TABLE IF NOT EXISTS `aluno_monit` (
  `pk_aluno_monitoria` int(11) NOT NULL AUTO_INCREMENT,
  `fk_pk_monitoria` int(11) NOT NULL,
  `fk_pk_usuario` int(11) NOT NULL,
  PRIMARY KEY (`pk_aluno_monitoria`),
  KEY `fk_pk_monitoria` (`fk_pk_monitoria`),
  KEY `fk_pk_usuario` (`fk_pk_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estrutura da tabela `horario_monit`
--

DROP TABLE IF EXISTS `horario_monit`;
CREATE TABLE IF NOT EXISTS `horario_monit` (
  `pk_horario_monitoria` int(11) NOT NULL AUTO_INCREMENT,
  `horario` date NOT NULL,
  `fk_pk_monitoria` int(11) NOT NULL,
  PRIMARY KEY (`pk_horario_monitoria`),
  KEY `fk_pk_monitoria` (`fk_pk_monitoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estrutura da tabela `monitoria`
--

DROP TABLE IF EXISTS `monitoria`;
CREATE TABLE IF NOT EXISTS `monitoria` (
  `pk_monitoria` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) COLLATE utf8_bin NOT NULL,
  `senha` varchar(255) COLLATE utf8_bin NOT NULL,
  `fk_pk_usuario` int(11) NOT NULL,
  PRIMARY KEY (`pk_monitoria`),
  KEY `fk_pk_usuario` (`fk_pk_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `pk_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(255) COLLATE utf8_bin NOT NULL,
  `nome` varchar(255) COLLATE utf8_bin NOT NULL,
  `senha` varchar(255) COLLATE utf8_bin NOT NULL,
  `is_admin` tinyint(1) NOT NULL,
  `is_monitor` tinyint(1) NOT NULL,
  PRIMARY KEY (`pk_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`pk_usuario`, `usuario`, `nome`, `senha`, `is_admin`, `is_monitor`) VALUES
(1, 'admin', 'admin', '123', 1, 0);

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `aluno_monit`
--
ALTER TABLE `aluno_monit`
  ADD CONSTRAINT `aluno_monit_ibfk_1` FOREIGN KEY (`fk_pk_monitoria`) REFERENCES `monitoria` (`pk_monitoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `aluno_monit_ibfk_2` FOREIGN KEY (`fk_pk_usuario`) REFERENCES `usuario` (`pk_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `horario_monit`
--
ALTER TABLE `horario_monit`
  ADD CONSTRAINT `horario_monit_ibfk_1` FOREIGN KEY (`fk_pk_monitoria`) REFERENCES `monitoria` (`pk_monitoria`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `monitoria`
--
ALTER TABLE `monitoria`
  ADD CONSTRAINT `monitoria_ibfk_1` FOREIGN KEY (`fk_pk_usuario`) REFERENCES `usuario` (`pk_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
