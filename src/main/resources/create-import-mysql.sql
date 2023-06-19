-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: schoolsystem
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aluno` (
  `id` int(11) NOT NULL,
  `bairro` varchar(255) DEFAULT NULL,
  `cep` varchar(255) DEFAULT NULL,
  `cidade` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `logradouro` varchar(255) DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `idade` int(11) DEFAULT NULL,
  `matricula` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `sexo` char(1) DEFAULT NULL,
  `aluno_enum` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` VALUES (1,'São Cristovão','57000-000','Maranguape','CE','Rua da alegria','SN',19,'0002','Bruna','F','BOLSAASSISTENCIA');
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aluno_disciplinas`
--

DROP TABLE IF EXISTS `aluno_disciplinas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aluno_disciplinas` (
  `aluno_id` int(11) NOT NULL,
  `disciplinas_id` int(11) NOT NULL,
  KEY `FKo9fw4mk20871t168uqcsc9p91` (`disciplinas_id`),
  KEY `FK4ggsq033dagw8lujn30eap0t9` (`aluno_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno_disciplinas`
--

LOCK TABLES `aluno_disciplinas` WRITE;
/*!40000 ALTER TABLE `aluno_disciplinas` DISABLE KEYS */;
INSERT INTO `aluno_disciplinas` VALUES (1,8);
/*!40000 ALTER TABLE `aluno_disciplinas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aluno_telefones`
--

DROP TABLE IF EXISTS `aluno_telefones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aluno_telefones` (
  `aluno_id` int(11) NOT NULL,
  `telefones` varchar(255) DEFAULT NULL,
  KEY `FKlkykjrknpgme4idsdxywe4a8p` (`aluno_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno_telefones`
--

LOCK TABLES `aluno_telefones` WRITE;
/*!40000 ALTER TABLE `aluno_telefones` DISABLE KEYS */;
INSERT INTO `aluno_telefones` VALUES (1,'99939-1223');
/*!40000 ALTER TABLE `aluno_telefones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assunto`
--

DROP TABLE IF EXISTS `assunto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assunto` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `disciplina_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoh7sprjh4oe58xdmgd30fa7xw` (`disciplina_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assunto`
--

LOCK TABLES `assunto` WRITE;
/*!40000 ALTER TABLE `assunto` DISABLE KEYS */;
INSERT INTO `assunto` VALUES (10,'MVC',8),(11,'REST',8),(12,'Spring',8),(13,'JPA',8);
/*!40000 ALTER TABLE `assunto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `curso` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (2,'PRONATEC - Informática Básica');
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso_alunos`
--

DROP TABLE IF EXISTS `curso_alunos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `curso_alunos` (
  `curso_id` int(11) NOT NULL,
  `alunos_id` int(11) NOT NULL,
  UNIQUE KEY `UK_ldwodjbf11b38vhsvwmx4n06j` (`alunos_id`),
  KEY `FKsfjlhssj87irf7mh739yr403m` (`curso_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso_alunos`
--

LOCK TABLES `curso_alunos` WRITE;
/*!40000 ALTER TABLE `curso_alunos` DISABLE KEYS */;
INSERT INTO `curso_alunos` VALUES (2,1);
/*!40000 ALTER TABLE `curso_alunos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso_disciplinas`
--

DROP TABLE IF EXISTS `curso_disciplinas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `curso_disciplinas` (
  `curso_id` int(11) NOT NULL,
  `disciplinas_id` int(11) NOT NULL,
  UNIQUE KEY `UK_53gk6o7w8n5ca42u12q0pgcx8` (`disciplinas_id`),
  KEY `FKhc6evgy4o6jysjna05vl0o5wd` (`curso_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso_disciplinas`
--

LOCK TABLES `curso_disciplinas` WRITE;
/*!40000 ALTER TABLE `curso_disciplinas` DISABLE KEYS */;
/*!40000 ALTER TABLE `curso_disciplinas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disciplina`
--

DROP TABLE IF EXISTS `disciplina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disciplina` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `professor_id` int(11) DEFAULT NULL,
  `periodo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoqie7f1kx32b1atco9fpgxd7g` (`professor_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disciplina`
--

LOCK TABLES `disciplina` WRITE;
/*!40000 ALTER TABLE `disciplina` DISABLE KEYS */;
INSERT INTO `disciplina` VALUES (8,'Programação WEB 1',5,1);
/*!40000 ALTER TABLE `disciplina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disciplina_alunos`
--

DROP TABLE IF EXISTS `disciplina_alunos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disciplina_alunos` (
  `disciplina_id` int(11) NOT NULL,
  `alunos_id` int(11) NOT NULL,
  KEY `FKnifqbw1efwflt88xwao0j0owd` (`alunos_id`),
  KEY `FK8yygouk418kl5pioddbr3h4mh` (`disciplina_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disciplina_alunos`
--

LOCK TABLES `disciplina_alunos` WRITE;
/*!40000 ALTER TABLE `disciplina_alunos` DISABLE KEYS */;
INSERT INTO `disciplina_alunos` VALUES (8,1);
/*!40000 ALTER TABLE `disciplina_alunos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disciplina_assunto`
--

DROP TABLE IF EXISTS `disciplina_assunto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disciplina_assunto` (
  `disciplina_id` int(11) NOT NULL,
  `assunto_id` int(11) NOT NULL,
  UNIQUE KEY `UK_e6flo4gyxi8jpk07w83ka879q` (`assunto_id`),
  KEY `FKnieilubwihc1tabnoj5849kq9` (`disciplina_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disciplina_assunto`
--

LOCK TABLES `disciplina_assunto` WRITE;
/*!40000 ALTER TABLE `disciplina_assunto` DISABLE KEYS */;
/*!40000 ALTER TABLE `disciplina_assunto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disciplina_assuntos`
--

DROP TABLE IF EXISTS `disciplina_assuntos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disciplina_assuntos` (
  `disciplina_id` int(11) NOT NULL,
  `assuntos_id` int(11) NOT NULL,
  UNIQUE KEY `UK_evpuvr9r6hmvq4ltf5mnjdv2l` (`assuntos_id`),
  KEY `FKslt2c56rgpc5ga9n4ykwg94ov` (`disciplina_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disciplina_assuntos`
--

LOCK TABLES `disciplina_assuntos` WRITE;
/*!40000 ALTER TABLE `disciplina_assuntos` DISABLE KEYS */;
INSERT INTO `disciplina_assuntos` VALUES (8,10),(8,11),(8,12),(8,13);
/*!40000 ALTER TABLE `disciplina_assuntos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `escola`
--

DROP TABLE IF EXISTS `escola`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `escola` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `escola`
--

LOCK TABLES `escola` WRITE;
/*!40000 ALTER TABLE `escola` DISABLE KEYS */;
INSERT INTO `escola` VALUES (4,'IFAL - RL'),(6,'IFAL - Arapiraca'),(7,'IFAL - Coruripe'),(9,'IFAL - PDI');
/*!40000 ALTER TABLE `escola` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `escola_cursos`
--

DROP TABLE IF EXISTS `escola_cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `escola_cursos` (
  `escola_id` int(11) NOT NULL,
  `cursos_id` int(11) NOT NULL,
  KEY `FK2lkbfu15knpg2kae2c3wnbmq8` (`cursos_id`),
  KEY `FKof2pe3bu70hmgapsxg570ghwr` (`escola_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `escola_cursos`
--

LOCK TABLES `escola_cursos` WRITE;
/*!40000 ALTER TABLE `escola_cursos` DISABLE KEYS */;
INSERT INTO `escola_cursos` VALUES (4,2),(6,2),(7,2),(9,2);
/*!40000 ALTER TABLE `escola_cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `escola_professores`
--

DROP TABLE IF EXISTS `escola_professores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `escola_professores` (
  `escola_id` int(11) NOT NULL,
  `professores_id` int(11) NOT NULL,
  KEY `FKiw5kqdkyjami61n8k5yxrnwbp` (`professores_id`),
  KEY `FKsp2grv70rd1y0gbxpdvnjassg` (`escola_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `escola_professores`
--

LOCK TABLES `escola_professores` WRITE;
/*!40000 ALTER TABLE `escola_professores` DISABLE KEYS */;
INSERT INTO `escola_professores` VALUES (4,5);
/*!40000 ALTER TABLE `escola_professores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (51),(51),(51),(51),(51);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nota`
--

DROP TABLE IF EXISTS `nota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nota` (
  `id` int(11) NOT NULL,
  `media_final` double DEFAULT NULL,
  `aluno_id` int(11) DEFAULT NULL,
  `disciplina_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7ntsgem4ql46uy34ile14rg74` (`aluno_id`),
  KEY `FKsvtulgi5u9owlahm6coc3mn00` (`disciplina_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nota`
--

LOCK TABLES `nota` WRITE;
/*!40000 ALTER TABLE `nota` DISABLE KEYS */;
INSERT INTO `nota` VALUES (18,8,1,8);
/*!40000 ALTER TABLE `nota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nota_notas`
--

DROP TABLE IF EXISTS `nota_notas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nota_notas` (
  `nota_id` int(11) NOT NULL,
  `notas` double DEFAULT NULL,
  KEY `FKmy7ncos2dci8a4421uvsnkksh` (`nota_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nota_notas`
--

LOCK TABLES `nota_notas` WRITE;
/*!40000 ALTER TABLE `nota_notas` DISABLE KEYS */;
INSERT INTO `nota_notas` VALUES (18,10),(18,6);
/*!40000 ALTER TABLE `nota_notas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professor`
--

DROP TABLE IF EXISTS `professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `professor` (
  `id` int(11) NOT NULL,
  `formacao` varchar(255) DEFAULT NULL,
  `idade` int(11) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `sexo` char(1) DEFAULT NULL,
  `professor_enum` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professor`
--

LOCK TABLES `professor` WRITE;
/*!40000 ALTER TABLE `professor` DISABLE KEYS */;
INSERT INTO `professor` VALUES (5,'Ciência da Computação',31,'Girafales','M','EFETIVO');
/*!40000 ALTER TABLE `professor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professor_disciplinas`
--

DROP TABLE IF EXISTS `professor_disciplinas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `professor_disciplinas` (
  `professor_id` int(11) NOT NULL,
  `disciplinas_id` int(11) NOT NULL,
  UNIQUE KEY `UK_87b48si2x00v8sa9viwyc7voy` (`disciplinas_id`),
  KEY `FK674vfr2fb602q0r99lnayc1wp` (`professor_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professor_disciplinas`
--

LOCK TABLES `professor_disciplinas` WRITE;
/*!40000 ALTER TABLE `professor_disciplinas` DISABLE KEYS */;
INSERT INTO `professor_disciplinas` VALUES (5,8);
/*!40000 ALTER TABLE `professor_disciplinas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-01 20:33:08
