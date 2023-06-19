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
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` VALUES (1,'São Cristovão','57000-000','Maranguape','CE','Rua da alegria','SN',19,'0002','Bruna','F','BOLSAASSISTENCIA');
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `aluno_disciplinas`
--

LOCK TABLES `aluno_disciplinas` WRITE;
/*!40000 ALTER TABLE `aluno_disciplinas` DISABLE KEYS */;
INSERT INTO `aluno_disciplinas` VALUES (1,8);
/*!40000 ALTER TABLE `aluno_disciplinas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `aluno_telefones`
--

LOCK TABLES `aluno_telefones` WRITE;
/*!40000 ALTER TABLE `aluno_telefones` DISABLE KEYS */;
INSERT INTO `aluno_telefones` VALUES (1,'99939-1223');
/*!40000 ALTER TABLE `aluno_telefones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `assunto`
--

LOCK TABLES `assunto` WRITE;
/*!40000 ALTER TABLE `assunto` DISABLE KEYS */;
INSERT INTO `assunto` VALUES (10,'MVC',8),(11,'REST',8),(12,'Spring',8),(13,'JPA',8);
/*!40000 ALTER TABLE `assunto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (2,'PRONATEC - Informática Básica');
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `curso_alunos`
--

LOCK TABLES `curso_alunos` WRITE;
/*!40000 ALTER TABLE `curso_alunos` DISABLE KEYS */;
INSERT INTO `curso_alunos` VALUES (2,1);
/*!40000 ALTER TABLE `curso_alunos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `curso_disciplinas`
--

LOCK TABLES `curso_disciplinas` WRITE;
/*!40000 ALTER TABLE `curso_disciplinas` DISABLE KEYS */;
/*!40000 ALTER TABLE `curso_disciplinas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `disciplina`
--

LOCK TABLES `disciplina` WRITE;
/*!40000 ALTER TABLE `disciplina` DISABLE KEYS */;
INSERT INTO `disciplina` VALUES (8,'Programação WEB 1',5,1);
/*!40000 ALTER TABLE `disciplina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `disciplina_alunos`
--

LOCK TABLES `disciplina_alunos` WRITE;
/*!40000 ALTER TABLE `disciplina_alunos` DISABLE KEYS */;
INSERT INTO `disciplina_alunos` VALUES (8,1);
/*!40000 ALTER TABLE `disciplina_alunos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `disciplina_assunto`
--

LOCK TABLES `disciplina_assunto` WRITE;
/*!40000 ALTER TABLE `disciplina_assunto` DISABLE KEYS */;
/*!40000 ALTER TABLE `disciplina_assunto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `disciplina_assuntos`
--

LOCK TABLES `disciplina_assuntos` WRITE;
/*!40000 ALTER TABLE `disciplina_assuntos` DISABLE KEYS */;
INSERT INTO `disciplina_assuntos` VALUES (8,10),(8,11),(8,12),(8,13);
/*!40000 ALTER TABLE `disciplina_assuntos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `escola`
--

LOCK TABLES `escola` WRITE;
/*!40000 ALTER TABLE `escola` DISABLE KEYS */;
INSERT INTO `escola` VALUES (4,'IFAL - RL'),(6,'IFAL - Arapiraca'),(7,'IFAL - Coruripe'),(9,'IFAL - PDI');
/*!40000 ALTER TABLE `escola` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `escola_cursos`
--

LOCK TABLES `escola_cursos` WRITE;
/*!40000 ALTER TABLE `escola_cursos` DISABLE KEYS */;
INSERT INTO `escola_cursos` VALUES (4,2),(6,2),(7,2),(9,2);
/*!40000 ALTER TABLE `escola_cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `escola_professores`
--

LOCK TABLES `escola_professores` WRITE;
/*!40000 ALTER TABLE `escola_professores` DISABLE KEYS */;
INSERT INTO `escola_professores` VALUES (4,5);
/*!40000 ALTER TABLE `escola_professores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (51),(51),(51),(51),(51);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `nota`
--

LOCK TABLES `nota` WRITE;
/*!40000 ALTER TABLE `nota` DISABLE KEYS */;
INSERT INTO `nota` VALUES (18,8,1,8);
/*!40000 ALTER TABLE `nota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `nota_notas`
--

LOCK TABLES `nota_notas` WRITE;
/*!40000 ALTER TABLE `nota_notas` DISABLE KEYS */;
INSERT INTO `nota_notas` VALUES (18,10),(18,6);
/*!40000 ALTER TABLE `nota_notas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `professor`
--

LOCK TABLES `professor` WRITE;
/*!40000 ALTER TABLE `professor` DISABLE KEYS */;
INSERT INTO `professor` VALUES (5,'Ciência da Computação',31,'Girafales','M','EFETIVO');
/*!40000 ALTER TABLE `professor` ENABLE KEYS */;
UNLOCK TABLES;

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

-- Dump completed on 2018-05-01 20:33:53
