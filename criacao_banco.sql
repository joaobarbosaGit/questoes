SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

ALTER SCHEMA `joaolu98_bd_questoes`  DEFAULT CHARACTER SET utf8  DEFAULT COLLATE utf8_general_ci ;

CREATE TABLE IF NOT EXISTS `joaolu98_bd_questoes`.`Acesso` (
  `idAcesso` INT(11) NOT NULL AUTO_INCREMENT,
  `Adminitrador` INT(11) NOT NULL,
  `Questionario` INT(11) NOT NULL,
  `Desafio` INT(11) NOT NULL,
  `Rankeamento` INT(11) NOT NULL,
  `Conta` INT(11) NOT NULL,
  PRIMARY KEY (`idAcesso`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `joaolu98_bd_questoes`.`Usuario_Professor` (
  `idUsuario_Professor` INT(11) NOT NULL AUTO_INCREMENT,
  `Nome_Professor` VARCHAR(100) NOT NULL,
  `Email` VARCHAR(80) NOT NULL,
  `Senha` VARCHAR(20) NOT NULL,
  `Acesso_idAcesso` INT(11) NOT NULL,
  PRIMARY KEY (`idUsuario_Professor`),
  INDEX `fk_Usuario_Professor_Acesso1_idx` (`Acesso_idAcesso` ASC),
  CONSTRAINT `fk_Usuario_Professor_Acesso1`
    FOREIGN KEY (`Acesso_idAcesso`)
    REFERENCES `joaolu98_bd_questoes`.`Acesso` (`idAcesso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `joaolu98_bd_questoes`.`Usuario_Aluno` (
  `idUsuario_Aluno` INT(11) NOT NULL AUTO_INCREMENT,
  `Nome_Aluno` VARCHAR(100) NOT NULL,
  `Turma` VARCHAR(80) NOT NULL,
  `Email` VARCHAR(80) NOT NULL,
  `Senha` VARCHAR(20) NOT NULL,
  `Acesso_idAcesso` INT(11) NOT NULL,
  PRIMARY KEY (`idUsuario_Aluno`),
  INDEX `fk_Usuario_Aluno_Acesso1_idx` (`Acesso_idAcesso` ASC),
  CONSTRAINT `fk_Usuario_Aluno_Acesso1`
    FOREIGN KEY (`Acesso_idAcesso`)
    REFERENCES `joaolu98_bd_questoes`.`Acesso` (`idAcesso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `joaolu98_bd_questoes`.`Rodada` (
  `idRodada` INT(11) NOT NULL AUTO_INCREMENT,
  `Material` VARCHAR(200) NOT NULL,
  `Quantidade_Membros` VARCHAR(45) NOT NULL,
  `Quantidade_Times` VARCHAR(45) NOT NULL,
  `Data_Fase1` DATE NOT NULL,
  `Data_Fase2` DATE NOT NULL,
  `Data_Fase3` DATE NOT NULL,
  `Data_Fase4` DATE NOT NULL,
  `Usuario_Professor_idUsuario_Professor` INT(11) NOT NULL,
  PRIMARY KEY (`idRodada`),
  INDEX `fk_Rodada_Usuario_Professor1_idx` (`Usuario_Professor_idUsuario_Professor` ASC),
  CONSTRAINT `fk_Rodada_Usuario_Professor1`
    FOREIGN KEY (`Usuario_Professor_idUsuario_Professor`)
    REFERENCES `joaolu98_bd_questoes`.`Usuario_Professor` (`idUsuario_Professor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `joaolu98_bd_questoes`.`Questionario` (
  `idQuestionario` INT(11) NOT NULL AUTO_INCREMENT,
  `Rodada_idRodada` INT(11) NOT NULL,
  PRIMARY KEY (`idQuestionario`),
  INDEX `fk_Questionario_Rodada1_idx` (`Rodada_idRodada` ASC),
  CONSTRAINT `fk_Questionario_Rodada1`
    FOREIGN KEY (`Rodada_idRodada`)
    REFERENCES `joaolu98_bd_questoes`.`Rodada` (`idRodada`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `joaolu98_bd_questoes`.`Respostas_Questionario` (
  `idRespostas_Questionario` INT(11) NOT NULL AUTO_INCREMENT,
  `Questionario_idQuestionario` INT(11) NULL DEFAULT NULL,
  `Rodada_idRodada` INT(11) NOT NULL,
  PRIMARY KEY (`idRespostas_Questionario`),
  INDEX `fk_Respostas_Questionario_Questionario1_idx` (`Questionario_idQuestionario` ASC),
  INDEX `fk_Respostas_Questionario_Rodada1_idx` (`Rodada_idRodada` ASC),
  CONSTRAINT `fk_Respostas_Questionario_Questionario1`
    FOREIGN KEY (`Questionario_idQuestionario`)
    REFERENCES `joaolu98_bd_questoes`.`Questionario` (`idQuestionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Respostas_Questionario_Rodada1`
    FOREIGN KEY (`Rodada_idRodada`)
    REFERENCES `joaolu98_bd_questoes`.`Rodada` (`idRodada`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `joaolu98_bd_questoes`.`Equipe` (
  `idEquipe` INT(11) NOT NULL AUTO_INCREMENT,
  `Questionario_idQuestionario` INT(11) NOT NULL,
  `Respostas_Questionario_idRespostas_Questionario` INT(11) NOT NULL,
  PRIMARY KEY (`idEquipe`),
  INDEX `fk_Equipe_Questionario1_idx` (`Questionario_idQuestionario` ASC),
  INDEX `fk_Equipe_Respostas_Questionario1_idx` (`Respostas_Questionario_idRespostas_Questionario` ASC),
  CONSTRAINT `fk_Equipe_Questionario1`
    FOREIGN KEY (`Questionario_idQuestionario`)
    REFERENCES `joaolu98_bd_questoes`.`Questionario` (`idQuestionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Equipe_Respostas_Questionario1`
    FOREIGN KEY (`Respostas_Questionario_idRespostas_Questionario`)
    REFERENCES `joaolu98_bd_questoes`.`Respostas_Questionario` (`idRespostas_Questionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `joaolu98_bd_questoes`.`Usuario_Aluno_has_Equipe` (
  `Usuario_Aluno_idUsuario_Aluno` INT(11) NOT NULL,
  `Equipe_idEquipe` INT(11) NOT NULL,
  PRIMARY KEY (`Usuario_Aluno_idUsuario_Aluno`, `Equipe_idEquipe`),
  INDEX `fk_Usuario_Aluno_has_Equipe_Equipe1_idx` (`Equipe_idEquipe` ASC),
  INDEX `fk_Usuario_Aluno_has_Equipe_Usuario_Aluno1_idx` (`Usuario_Aluno_idUsuario_Aluno` ASC),
  CONSTRAINT `fk_Usuario_Aluno_has_Equipe_Usuario_Aluno1`
    FOREIGN KEY (`Usuario_Aluno_idUsuario_Aluno`)
    REFERENCES `joaolu98_bd_questoes`.`Usuario_Aluno` (`idUsuario_Aluno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuario_Aluno_has_Equipe_Equipe1`
    FOREIGN KEY (`Equipe_idEquipe`)
    REFERENCES `joaolu98_bd_questoes`.`Equipe` (`idEquipe`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `joaolu98_bd_questoes`.`Questao` (
  `idQuestao` INT(11) NOT NULL AUTO_INCREMENT,
  `Corpo_Questao` VARCHAR(1000) NOT NULL,
  `Gabarito` VARCHAR(1000) NOT NULL,
  `Qualificacao_Questao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idQuestao`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `joaolu98_bd_questoes`.`Resposta` (
  `idResposta` INT(11) NOT NULL AUTO_INCREMENT,
  `Corpo_Resposta` VARCHAR(45) NOT NULL,
  `Nota_Resposta` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idResposta`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `joaolu98_bd_questoes`.`Questionario_has_Questao` (
  `Questionario_idQuestionario` INT(11) NOT NULL,
  `Questao_idQuestao` INT(11) NOT NULL,
  PRIMARY KEY (`Questionario_idQuestionario`, `Questao_idQuestao`),
  INDEX `fk_Questionario_has_Questao_Questao1_idx` (`Questao_idQuestao` ASC),
  INDEX `fk_Questionario_has_Questao_Questionario_idx` (`Questionario_idQuestionario` ASC),
  CONSTRAINT `fk_Questionario_has_Questao_Questionario`
    FOREIGN KEY (`Questionario_idQuestionario`)
    REFERENCES `joaolu98_bd_questoes`.`Questionario` (`idQuestionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Questionario_has_Questao_Questao1`
    FOREIGN KEY (`Questao_idQuestao`)
    REFERENCES `joaolu98_bd_questoes`.`Questao` (`idQuestao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `joaolu98_bd_questoes`.`Rodada_has_Equipe` (
  `Rodada_idRodada` INT(11) NOT NULL,
  `Equipe_idEquipe` INT(11) NOT NULL,
  PRIMARY KEY (`Rodada_idRodada`, `Equipe_idEquipe`),
  INDEX `fk_Rodada_has_Equipe_Equipe1_idx` (`Equipe_idEquipe` ASC),
  INDEX `fk_Rodada_has_Equipe_Rodada1_idx` (`Rodada_idRodada` ASC),
  CONSTRAINT `fk_Rodada_has_Equipe_Rodada1`
    FOREIGN KEY (`Rodada_idRodada`)
    REFERENCES `joaolu98_bd_questoes`.`Rodada` (`idRodada`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Rodada_has_Equipe_Equipe1`
    FOREIGN KEY (`Equipe_idEquipe`)
    REFERENCES `joaolu98_bd_questoes`.`Equipe` (`idEquipe`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `joaolu98_bd_questoes`.`Respostas_Questionario_has_Resposta` (
  `Respostas_Questionario_idRespostas_Questionario` INT(11) NOT NULL,
  `Resposta_idResposta` INT(11) NOT NULL,
  PRIMARY KEY (`Respostas_Questionario_idRespostas_Questionario`, `Resposta_idResposta`),
  INDEX `fk_Respostas_Questionario_has_Resposta_Resposta1_idx` (`Resposta_idResposta` ASC),
  INDEX `fk_Respostas_Questionario_has_Resposta_Respostas_Questionar_idx` (`Respostas_Questionario_idRespostas_Questionario` ASC),
  CONSTRAINT `fk_Respostas_Questionario_has_Resposta_Respostas_Questionario1`
    FOREIGN KEY (`Respostas_Questionario_idRespostas_Questionario`)
    REFERENCES `joaolu98_bd_questoes`.`Respostas_Questionario` (`idRespostas_Questionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Respostas_Questionario_has_Resposta_Resposta1`
    FOREIGN KEY (`Resposta_idResposta`)
    REFERENCES `joaolu98_bd_questoes`.`Resposta` (`idResposta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `joaolu98_bd_questoes`.`Desafio` (
  `idDesafio` INT(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idDesafio`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `joaolu98_bd_questoes`.`Questao_Desafio` (
  `idQuestao_Desafio` INT(11) NOT NULL AUTO_INCREMENT,
  `Corpo_Questao` VARCHAR(1000) NOT NULL,
  `Gabarito` VARCHAR(1000) NOT NULL,
  `Qualificacao_Questao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idQuestao_Desafio`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `joaolu98_bd_questoes`.`Desafio_has_Questao_Desafio` (
  `Desafio_idDesafio` INT(11) NOT NULL,
  `Questao_Desafio_idQuestao` INT(11) NOT NULL,
  PRIMARY KEY (`Desafio_idDesafio`, `Questao_Desafio_idQuestao`),
  INDEX `fk_Desafio_has_Questao_Desafio_Questao_Desafio1_idx` (`Questao_Desafio_idQuestao` ASC),
  INDEX `fk_Desafio_has_Questao_Desafio_Desafio1_idx` (`Desafio_idDesafio` ASC),
  CONSTRAINT `fk_Desafio_has_Questao_Desafio_Desafio1`
    FOREIGN KEY (`Desafio_idDesafio`)
    REFERENCES `joaolu98_bd_questoes`.`Desafio` (`idDesafio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Desafio_has_Questao_Desafio_Questao_Desafio1`
    FOREIGN KEY (`Questao_Desafio_idQuestao`)
    REFERENCES `joaolu98_bd_questoes`.`Questao_Desafio` (`idQuestao_Desafio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

