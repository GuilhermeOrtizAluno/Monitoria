/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Guilherme Ortiz
 * Created: 2 de abr. de 2021
 */
CREATE TABLE usuario (
pk_usuario INT PRIMARY KEY not null AUTO_INCREMENT,
usuario varchar(255) not null,
nome varchar(255) not null,
senha varchar(255) not null,
is_admin Boolean not null,
is_monitor Boolean not null
) ENGINE = innodb;

CREATE TABLE monitoria (
pk_monitoria int PRIMARY KEY not null AUTO_INCREMENT,
nome varchar(255) not null,
senha varchar(255) not null,
fk_pk_usuario int not null,
) ENGINE = innodb;

CREATE TABLE horario_monit (
pk_horario_monitoria int PRIMARY KEY not null AUTO_INCREMENT,
horario DATE not null,
fk_pk_monitoria int not null
) ENGINE = innodb;

CREATE TABLE aluno_monit (
pk_aluno_monitoria int PRIMARY KEY not null AUTO_INCREMENT,
fk_pk_monitoria int not null,
fk_pk_usuario int not null,
) ENGINE = innodb;

ALTER TABLE monitoria ADD CONSTRAINT fk_pk_usuario FOREIGN KEY (pk_usuario) REFERENCES usuario (pk_usuario);
ALTER TABLE horario_monit ADD CONSTRAINT fk_pk_monitoria FOREIGN KEY (pk_monitoria) REFERENCES monitoria (pk_monitoria);
ALTER TABLE aluno_monit ADD CONSTRAINT fk_pk_usuario FOREIGN KEY (pk_usuario) REFERENCES usuario (pk_usuario);
ALTER TABLE aluno_monit ADD CONSTRAINT fk_pk_monitoria FOREIGN KEY (pk_monitoria) REFERENCES monitoria (pk_monitoria);

