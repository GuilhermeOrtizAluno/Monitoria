-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 16-Abr-2021 às 08:28
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
  `fk_pk_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `horario_monit`
--

CREATE TABLE `horario_monit` (
  `pk_horario_monitoria` int(11) NOT NULL,
  `horario` date NOT NULL,
  `fk_pk_monitoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `monitoria`
--

CREATE TABLE `monitoria` (
  `pk_monitoria` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `fk_pk_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `pk_usuario` int(11) NOT NULL,
  `usuario` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `is_admin` tinyint(1) NOT NULL,
  `is_monitor` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `aluno_monit`
--
ALTER TABLE `aluno_monit`
  ADD PRIMARY KEY (`pk_aluno_monitoria`),
  ADD KEY `fk_pk_monitoria` (`fk_pk_monitoria`),
  ADD KEY `fk_pk_usuario` (`fk_pk_usuario`);

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
  ADD PRIMARY KEY (`pk_monitoria`),
  ADD KEY `monitoria_ibfk_1` (`fk_pk_usuario`);

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
  MODIFY `pk_monitoria` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `usuario`
--
ALTER TABLE `usuario`
  MODIFY `pk_usuario` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `aluno_monit`
--
ALTER TABLE `aluno_monit`
  ADD CONSTRAINT `aluno_monit_ibfk_1` FOREIGN KEY (`fk_pk_monitoria`) REFERENCES `monitoria` (`pk_monitoria`),
  ADD CONSTRAINT `aluno_monit_ibfk_2` FOREIGN KEY (`fk_pk_usuario`) REFERENCES `usuario` (`pk_usuario`);

--
-- Limitadores para a tabela `horario_monit`
--
ALTER TABLE `horario_monit`
  ADD CONSTRAINT `horario_monit_ibfk_1` FOREIGN KEY (`fk_pk_monitoria`) REFERENCES `monitoria` (`pk_monitoria`);

--
-- Limitadores para a tabela `monitoria`
--
ALTER TABLE `monitoria`
  ADD CONSTRAINT `monitoria_ibfk_1` FOREIGN KEY (`fk_pk_usuario`) REFERENCES `usuario` (`pk_usuario`) ON DELETE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
