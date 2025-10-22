# 🚀 Hexagonal App Backend Springboot Java (MySQL)

Este documento explica los pasos exactos para levantar y ejecutar el servicio API REST de **`hexagonal-app-backend-springboot-java`** en tu máquina local.

## 1\. Pre-requisitos (Lo que Necesitas) 🛠️

| Herramienta | Versión Mínima | Nota |
| :--- | :--- | :--- |
| **Java Development Kit (JDK)** | 17 (LTS) | Entorno de ejecución estándar y recomendado. |
| **MySQL** | - | El motor de base de datos debe estar instalado y corriendo. |
| **Maven Wrapper** (`.mvn`) | - | Incluido en el proyecto; no requiere instalación manual de Maven. |

-----

## 2\. Preparación de la Base de Datos (`babull_db`) 💾

El nombre de la base de datos para este proyecto es **`babull_db`**. La estructura y los datos iniciales se encuentran en la carpeta **`bbdd`**.

```sql
DROP DATABASE IF EXISTS `babull_db`;
CREATE DATABASE `babull_db`;

CREATE TABLE `babull_db`.`cuenta` (
  `id` bigint(20) NOT NULL,
  `saldo` decimal(38,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `babull_db`.`cuenta` (`id`, `saldo`) VALUES
(1, 850.00),
(2, 650.00);

ALTER TABLE `babull_db`.`cuenta`
  ADD PRIMARY KEY (`id`);
```

-----

## 3\. Configuración de la Conexión 🔗

Debes editar el archivo de configuración para que Spring Boot pueda acceder a tu MySQL local.

### 3.1. Editar `application.properties`

1.  Abre el archivo **`src/main/resources/application.properties`**.
2.  Modifica las siguientes líneas **solo con tu usuario y contraseña** de MySQL:

<!-- end list -->

```properties
# CONFIGURACIÓN DE TU BASE DE DATOS LOCAL
server.port=8080
spring.datasource.url=jdbc:mysql://localhost:3306/babull_db
spring.datasource.username=tu_usuario_mysql
spring.datasource.password=tu_contraseña_mysql

# OTRAS CONFIGURACIONES DE JAVA/SPRING
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

> ⚠️ **¡Atención\!** Reemplaza `tu_usuario_mysql` y `tu_contraseña_mysql` con tus credenciales.

-----

## 4\. Levantar la Aplicación ⬆️

Ejecuta todos los comandos desde la **carpeta raíz** del proyecto.

### 4.1. Compilación y Empaquetado

Primero, compila el proyecto y genera el archivo JAR:

```bash
./mvnw clean install
```

*(Usa `mvn clean install` si tienes Maven instalado globalmente, o `mvnw.cmd clean install` en Windows).*

### 4.2. Ejecución de la Aplicación (Opciones)

**Opción A: Ejecutar con el Plugin de Spring Boot (Recomendado para desarrollo rápido)**

```bash
./mvnw spring-boot:run
```

**Opción B: Ejecutar el JAR Generado (Estándar)**

Una vez que el comando `clean install` ha finalizado, ejecuta el archivo JAR que se encuentra en la carpeta `target`:

```bash
java -jar app-main/target/app-main-1.0-SNAPSHOT.jar
```

Aparecerá por consola:

> LOG: Aplicación de Arquitectura Hexagonal iniciada en el puerto 8080.
