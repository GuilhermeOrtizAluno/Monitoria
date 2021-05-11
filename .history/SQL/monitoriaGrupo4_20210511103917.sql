DROP database monitoria;

Create database monitoria;

-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 06-Maio-2021 às 13:10
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
  `usuario_aluno` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estrutura da tabela `horario_monit`
--

CREATE TABLE `horario_monit` (
  `pk_horario_monitoria` int(11) NOT NULL,
  `horario` date NOT NULL,
  `fk_pk_monitoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estrutura da tabela `monitoria`
--

CREATE TABLE `monitoria` (
  `pk_monitoria` int(11) NOT NULL,
  `nome` varchar(255) COLLATE utf8_bin NOT NULL,
  `senha` varchar(255) COLLATE utf8_bin NOT NULL,
  `usuario_monitor` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `monitoria`
--

INSERT INTO `monitoria` (`pk_monitoria`, `nome`, `senha`, `usuario_monitor`) VALUES
(1, 'Algoritmos', '123', 'monitor1'),
(2, 'Estrutura de Dados', '123', 'monitor1'),
(3, 'Sistemas Distribuidos', '123', 'monitor2'),
(4, 'Banco de Dados', '123', 'monitor2');

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
(2, 'aluno1', 'aluno1', 'aluno1', 0, 0),
(3, 'aluno2', 'aluno2', 'aluno2', 0, 0),
(4, 'aluno3', 'aluno3', 'aluno3', 0, 0),
(5, 'aluno4', 'aluno4', 'aluno4', 0, 0),
(6, 'monitor1', 'monitor1', 'monitor1', 0, 1),
(7, 'monitor2', 'monitor2', 'monitor2', 0, 1),
(8, 'monitor3', 'monitor3', 'monitor3', 0, 1),
(9, 'monitor4', 'monitor4', 'monitor4', 0, 1);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `aluno_monit`
--
ALTER TABLE `aluno_monit`
  ADD PRIMARY KEY (`pk_aluno_monitoria`),
  ADD KEY `fk_pk_monitoria` (`fk_pk_monitoria`),
  ADD KEY `usuario_aluno` (`usuario_aluno`);

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
  ADD PRIMARY KEY (`pk_usuario`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `aluno_monit`
--
ALTER TABLE `aluno_monit`
  MODIFY `pk_aluno_monitoria` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `horario_monit`
--
ALTER TABLE `horario_monit`
  MODIFY `pk_horario_monitoria` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `monitoria`
--
ALTER TABLE `monitoria`
  MODIFY `pk_monitoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `usuario`
--
ALTER TABLE `usuario`
  MODIFY `pk_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

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
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
