DROP database monitoria;

CREATE database monitoria;
-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 11-Maio-2021 às 21:26
-- Versão do servidor: 10.4.18-MariaDB
-- versão do PHP: 8.0.3

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

CREATE TABLE `aluno_monit` (
  `pk_aluno_monitoria` int(11) NOT NULL,
  `fk_pk_monitoria` int(11) NOT NULL,
  `usuario_aluno` varchar(255) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `aluno_monit`
--

INSERT INTO `aluno_monit` (`pk_aluno_monitoria`, `fk_pk_monitoria`, `usuario_aluno`) VALUES
(1, 1, 'aluno1'),
(2, 1, 'aluno2'),
(3, 1, 'aluno3'),
(4, 2, 'aluno1'),
(5, 2, 'aluno2'),
(6, 2, 'aluno3'),
(7, 3, 'aluno1'),
(8, 3, 'aluno2'),
(9, 3, 'aluno3'),
(10, 4, 'aluno1'),
(11, 4, 'aluno2'),
(12, 4, 'aluno3'),
(13, 5, 'aluno1'),
(14, 5, 'aluno2'),
(15, 5, 'aluno3'),
(16, 6, 'aluno1'),
(17, 6, 'aluno2'),
(18, 6, 'aluno3'),
(19, 7, 'aluno1'),
(20, 7, 'aluno2'),
(21, 7, 'aluno3'),
(22, 8, 'aluno1'),
(23, 8, 'aluno2'),
(24, 8, 'aluno3'),
(25, 9, 'aluno1'),
(26, 9, 'aluno2'),
(27, 9, 'aluno3');

-- --------------------------------------------------------

--
-- Estrutura da tabela `horario_monit`
--

CREATE TABLE `horario_monit` (
  `pk_horario_monitoria` int(11) NOT NULL,
  `horario` varchar(5) COLLATE utf8_bin NOT NULL,
  `fk_pk_monitoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `horario_monit`
--

INSERT INTO `horario_monit` (`pk_horario_monitoria`, `horario`, `fk_pk_monitoria`) VALUES
(1, '1M2', 1),
(2, '2N1', 1),
(3, '3M2', 2),
(4, '4N1', 2),
(5, '5M2', 3),
(6, '1T1', 4),
(7, '2T2', 5),
(8, '3T1', 5),
(9, '4T2', 6),
(10, '5T1', 7),
(11, '1M5', 8),
(12, '2N3', 9);

-- --------------------------------------------------------

--
-- Estrutura da tabela `monitoria`
--

CREATE TABLE `monitoria` (
  `pk_monitoria` int(11) NOT NULL,
  `nome` varchar(255) COLLATE utf8_bin NOT NULL,
  `senha` varchar(255) COLLATE utf8_bin NOT NULL,
  `usuario_monitor` varchar(255) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `monitoria`
--

INSERT INTO `monitoria` (`pk_monitoria`, `nome`, `senha`, `usuario_monitor`) VALUES
(1, 'Linguagem de Programação Estruturada', '123', 'monitor1'),
(2, 'Banco de Dados 1', '123', 'monitor2'),
(3, 'Programação Orientada a Objetos', '123', 'monitor3'),
(4, 'Estrutura de Dados 1', '123', 'monitor1'),
(5, 'Algoritmos', '123', 'monitor2'),
(6, 'Estrutura de Dados 2', '123', 'monitor3'),
(7, 'Lógica de Programação', '123', 'monitor1'),
(8, 'Banco de Dados 2', '123', 'monitor2'),
(9, 'Matemática Discreta', '123', 'monitor3');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `pk_usuario` int(11) NOT NULL,
  `usuario` varchar(255) COLLATE utf8_bin NOT NULL,
  `nome` varchar(255) COLLATE utf8_bin NOT NULL,
  `senha` varchar(255) COLLATE utf8_bin NOT NULL,
  `is_admin` tinyint(1) NOT NULL,
  `is_monitor` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`pk_usuario`, `usuario`, `nome`, `senha`, `is_admin`, `is_monitor`) VALUES
(1, 'admin', 'admin', 'admin', 1, 0),
(2, 'aluno1', 'aluno', '123', 0, 0),
(3, 'monitor1', 'monitor', '123', 0, 1),
(4, 'aluno2', 'aluno', '123', 0, 0),
(5, 'monitor2', 'monitor', '123', 0, 1),
(6, 'aluno3', 'aluno', '123', 0, 0),
(7, 'monitor3', 'monitor', '123', 0, 1);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `aluno_monit`
--
ALTER TABLE `aluno_monit`
  ADD PRIMARY KEY (`pk_aluno_monitoria`),
  ADD KEY `fk_pk_monitoria` (`fk_pk_monitoria`);

--
-- Índices para tabela `horario_monit`
--
ALTER TABLE `horario_monit`
  ADD PRIMARY KEY (`pk_horario_monitoria`),
  ADD KEY `fk_pk_monitoria` (`fk_pk_monitoria`);

--
-- Índices para tabela `monitoria`
--
ALTER TABLE `monitoria`
  ADD PRIMARY KEY (`pk_monitoria`);

--
-- Índices para tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`pk_usuario`),
  ADD KEY `usuario` (`usuario`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `aluno_monit`
--
ALTER TABLE `aluno_monit`
  MODIFY `pk_aluno_monitoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de tabela `horario_monit`
--
ALTER TABLE `horario_monit`
  MODIFY `pk_horario_monitoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT de tabela `monitoria`
--
ALTER TABLE `monitoria`
  MODIFY `pk_monitoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de tabela `usuario`
--
ALTER TABLE `usuario`
  MODIFY `pk_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `horario_monit`
--
ALTER TABLE `horario_monit`
  ADD CONSTRAINT `horario_monit_ibfk_1` FOREIGN KEY (`fk_pk_monitoria`) REFERENCES `monitoria` (`pk_monitoria`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
