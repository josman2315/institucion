-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS institucion_db;

USE institucion_db;

-- Crear la tabla estudiantes
CREATE TABLE IF NOT EXISTS estudiantes
  (
     id_estudiante     BIGINT auto_increment PRIMARY KEY,
     nombre_estudiante VARCHAR(255) NOT NULL
  );

-- Crear la tabla profesores
CREATE TABLE IF NOT EXISTS profesores
  (
     id_profesor     BIGINT auto_increment PRIMARY KEY,
     nombre_profesor VARCHAR(255) NOT NULL
  );

-- Crear la tabla notas con restricciones de llaves foráneas
CREATE TABLE IF NOT EXISTS notas
  (
     id_nota       BIGINT auto_increment PRIMARY KEY,
     nombre_nota   VARCHAR(255) NOT NULL,
     id_profesor   BIGINT,
     id_estudiante BIGINT,
     valor         DOUBLE NOT NULL,
     CONSTRAINT fk_nota_profesor FOREIGN KEY (id_profesor) REFERENCES 
     profesores(id_profesor) ON DELETE SET NULL,
     CONSTRAINT fk_nota_estudiante FOREIGN KEY (id_estudiante) REFERENCES
     estudiantes(id_estudiante) ON DELETE SET NULL
  ); 