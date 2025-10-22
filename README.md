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

El proyecto utiliza el *Maven Wrapper* (`mvnw`) para arrancar sin necesidad de una instalación global de Maven.

1.  Abre la **Terminal** en la carpeta raíz del proyecto.

2.  Ejecuta el siguiente comando para compilar y arrancar la aplicación:

      * **Windows:**
        ```bash
        .\mvnw spring-boot:run
        ```
      * **Linux/macOS:**
        ```bash
        ./mvnw spring-boot:run
        ```
Se aceptan criticas y sugerencias. Estamos en proceso de aprendizaje permanente.
