-- MySQL Workbench Synchronization
-- Generated: 2021-02-09 08:12
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: JONH

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE TABLE IF NOT EXISTS `adabox28_bd_questoes`.`Equipe` (
  `idEquipe` INT(11) NOT NULL AUTO_INCREMENT,
  `Nome_Equipe` VARCHAR(100) NOT NULL,
  `Equipe_Para_Resposta` INT(11) NOT NULL,
  `Equipe_Que_Resposta` INT(11) NOT NULL,
  `Pontuacao_Questoes` INT(11) NOT NULL,
  `Pontuacao_Respostas` INT(11) NOT NULL,
  `Pontuacao_Desafios` INT(11) NOT NULL,
  `isQuestionario` INT(11) NOT NULL,
  `isResposta` INT(11) NOT NULL,
  `isDesafio` INT(11) NOT NULL,
  `idQuestao_Equipe01` INT(11) NOT NULL,
  `idQuestao_Equipe02` INT(11) NOT NULL,
  `idQuestao_Equipe03` INT(11) NOT NULL,
  `idQuestao_Equipe04` INT(11) NOT NULL,
  `idQuestao_Equipe05` INT(11) NOT NULL,
  `idQuestao_Equipe06` INT(11) NOT NULL,
  `idQuestao_Equipe07` INT(11) NOT NULL,
  `idQuestao_Equipe08` INT(11) NOT NULL,
  `idQuestao_Equipe09` INT(11) NOT NULL,
  `idQuestao_Equipe10` INT(11) NOT NULL,
  `idResposta_Equipe01` INT(11) NOT NULL,
  `idResposta_Equipe02` INT(11) NOT NULL,
  `idResposta_Equipe03` INT(11) NOT NULL,
  `idResposta_Equipe04` INT(11) NOT NULL,
  `idResposta_Equipe05` INT(11) NOT NULL,
  `idResposta_Equipe06` INT(11) NOT NULL,
  `idResposta_Equipe07` INT(11) NOT NULL,
  `idResposta_Equipe08` INT(11) NOT NULL,
  `idResposta_Equipe09` INT(11) NOT NULL,
  `idResposta_Equipe10` INT(11) NOT NULL,
  `idQuestao_Desafio01` INT(11) NOT NULL,
  `idQuestao_Desafio02` INT(11) NOT NULL,
  `idQuestao_Desafio03` INT(11) NOT NULL,
  `idResposta_Desafio01` INT(11) NULL DEFAULT NULL,
  `idResposta_Desafio02` INT(11) NULL DEFAULT NULL,
  `idResposta_Desafio03` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idEquipe`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `adabox28_bd_questoes`.`Questao` (
  `idQuestao` INT(11) NOT NULL AUTO_INCREMENT,
  `Corpo_Questao` VARCHAR(1000) NOT NULL,
  `Gabarito` VARCHAR(1000) NOT NULL,
  `Qualificacao_Questao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idQuestao`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `adabox28_bd_questoes`.`Usuario_Professor` (
  `idUsuario_Professor` INT(11) NOT NULL AUTO_INCREMENT,
  `Nome_Professor` VARCHAR(100) NOT NULL,
  `Email` VARCHAR(80) NOT NULL,
  `Senha` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idUsuario_Professor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `adabox28_bd_questoes`.`Rodada` (
  `idRodada` INT(11) NOT NULL AUTO_INCREMENT,
  `Descricao` VARCHAR(200) NOT NULL,
  `Material` VARCHAR(200) NOT NULL,
  `Quantidade_Times` VARCHAR(45) NOT NULL,
  `Data_Fase1` DATE NOT NULL,
  `Data_Fase2` DATE NOT NULL,
  `Data_Fase3` DATE NOT NULL,
  `Data_Fase4` DATE NOT NULL,
  `Data_Fase5` DATE NOT NULL,
  `Data_Fase6` DATE NOT NULL,
  `Usuario_Professor_idUsuario_Professor` INT(11) NOT NULL,
  `idQuestao_Desafio01` INT(11) NOT NULL,
  `idQuestao_Desafio02` INT(11) NOT NULL,
  `idQuestao_Desafio03` INT(11) NOT NULL,
  `idQuestao_Desafio04` INT(11) NOT NULL,
  `idQuestao_Desafio05` INT(11) NOT NULL,
  `idQuestao_Desafio06` INT(11) NOT NULL,
  `idQuestao_Desafio07` INT(11) NOT NULL,
  `idQuestao_Desafio08` INT(11) NOT NULL,
  `idQuestao_Desafio09` INT(11) NOT NULL,
  `idQuestao_Desafio10` INT(11) NOT NULL,
  PRIMARY KEY (`idRodada`),
  INDEX `fk_Rodada_Usuario_Professor1_idx` (`Usuario_Professor_idUsuario_Professor`),
  CONSTRAINT `fk_Rodada_Usuario_Professor1`
    FOREIGN KEY (`Usuario_Professor_idUsuario_Professor`)
    REFERENCES `adabox28_bd_questoes`.`Usuario_Professor` (`idUsuario_Professor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `adabox28_bd_questoes`.`Usuario_Aluno` (
  `idUsuario_Aluno` INT(11) NOT NULL AUTO_INCREMENT,
  `Usuario` VARCHAR(100) NOT NULL,
  `Senha` VARCHAR(50) NOT NULL,
  `Email` VARCHAR(100) NOT NULL,
  `Equipe_idEquipe` INT(11) NOT NULL,
  `Rodada_idRodada` INT(11) NOT NULL,
  PRIMARY KEY (`idUsuario_Aluno`),
  INDEX `fk_Usuario_Aluno_Equipe1_idx` (`Equipe_idEquipe`),
  INDEX `fk_Usuario_Aluno_Rodada1_idx` (`Rodada_idRodada`),
  CONSTRAINT `fk_Usuario_Aluno_Equipe1`
    FOREIGN KEY (`Equipe_idEquipe`)
    REFERENCES `adabox28_bd_questoes`.`Equipe` (`idEquipe`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuario_Aluno_Rodada1`
    FOREIGN KEY (`Rodada_idRodada`)
    REFERENCES `adabox28_bd_questoes`.`Rodada` (`idRodada`)
    )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `adabox28_bd_questoes`.`Resposta` (
  `idResposta` INT(11) NOT NULL AUTO_INCREMENT,
  `Corpo_Resposta` VARCHAR(1000) NOT NULL,
  `Nota_Resposta` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idResposta`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `adabox28_bd_questoes`.`Questao_Desafio` (
  `idQuestao_Desafio` INT(11) NOT NULL AUTO_INCREMENT,
  `Corpo_Questao` VARCHAR(1000) NOT NULL,
  `Gabarito` VARCHAR(1000) NOT NULL,
  PRIMARY KEY (`idQuestao_Desafio`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `adabox28_bd_questoes`.`Resposta_Questao_Desafio` (
  `idResposta_Questao_Desafio` INT(11) NOT NULL AUTO_INCREMENT,
  `Corpo_Resposta` VARCHAR(1000) NOT NULL,
  `Nota_Questao_Desafio` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idResposta_Questao_Desafio`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `adabox28_bd_questoes`.`Recurso` (
  `idRecurso` INT(11) NOT NULL AUTO_INCREMENT,
  `Objeto` VARCHAR(50) NOT NULL,
  `Causa` VARCHAR(1000) NOT NULL,
  `Deferimento` VARCHAR(1000) NOT NULL,
  `Situacao` INT(11) NOT NULL,
  `Rodada_idRodada` INT(11) NOT NULL,
  `Equipe_idEquipe` INT(11) NOT NULL,
  PRIMARY KEY (`idRecurso`),
  INDEX `fk_Recurso_Rodada1_idx` (`Rodada_idRodada` ),
  INDEX `fk_Recurso_Equipe1_idx` (`Equipe_idEquipe` ),
  CONSTRAINT `fk_Recurso_Rodada1`
    FOREIGN KEY (`Rodada_idRodada`)
    REFERENCES `adabox28_bd_questoes`.`Rodada` (`idRodada`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Recurso_Equipe1`
    FOREIGN KEY (`Equipe_idEquipe`)
    REFERENCES `adabox28_bd_questoes`.`Equipe` (`idEquipe`)
    );


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


INSERT INTO `Equipe` (`idEquipe`, `Nome_Equipe`, `Equipe_Para_Resposta`, `Equipe_Que_Resposta`, `idQuestao_Equipe01`, `idQuestao_Equipe02`, `idQuestao_Equipe03`, `idQuestao_Equipe04`, `idQuestao_Equipe05`, `idQuestao_Equipe06`, `idQuestao_Equipe07`, `idQuestao_Equipe08`, `idQuestao_Equipe09`, `idQuestao_Equipe10`, `idResposta_Equipe01`, `idResposta_Equipe02`, `idResposta_Equipe03`, `idResposta_Equipe04`, `idResposta_Equipe05`, `idResposta_Equipe06`, `idResposta_Equipe07`, `idResposta_Equipe08`, `idResposta_Equipe09`, `idResposta_Equipe10`, `idQuestao_Desafio01`, `idQuestao_Desafio02`, `idQuestao_Desafio03`, `idResposta_Desafio01`, `idResposta_Desafio02`, `idResposta_Desafio03`) VALUES (NULL,'', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', NULL, NULL, NULL);
INSERT INTO `Usuario_Professor` (`idUsuario_Professor`, `Nome_Professor`, `Email`, `Senha`) VALUES (NULL, 'admin', 'a', 'a');

TRUNCATE TABLE Usuario_Aluno;
TRUNCATE TABLE Rodada;
TRUNCATE TABLE Usuario_Professor;
TRUNCATE TABLE Recurso;
TRUNCATE TABLE Equipe;
TRUNCATE TABLE Questao;
TRUNCATE TABLE Questao_Desafio;
TRUNCATE TABLE Resposta;
TRUNCATE TABLE Resposta_Questao_Desafio;
