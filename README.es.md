# Music Poll Backend
Proyecto generado usando [Spring Initializr](https://start.spring.io/).

Este proyecto es el backend para la aplicación solicitada por [3IT](https://www.3it.cl/) como examen/prueba para aplicar a la posición de Fullstack Developer.

## Overview
El foco principal de esta aplicación backend es proveer capas de persistencia y validación en el lado del servidor para las respuestas de una encuesta que serán recibidas desde una aplicación Angular en el lado del cliente.

Utiliza ***Maven v3.8*** y ***Spring Boot v2.7*** junto a las dependencias:
- [Project Lombok](https://projectlombok.org/)
- [Spring Web MVC](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Spring Validation](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#validation)
- [H2 Database Driver](https://h2database.com/html/main.html)

## Features
- REST API
- Modelo de datos normalizado y simple con dos entidades:
  - Music Genre (Género de Música)
  - Poll Answer (Respuesta de Encuesta)

## Requirements
- Java 19 o superior ([Download from Oracle Releases](https://jdk.java.net/19/))
- Maven 3.6 o superior ([Download](https://maven.apache.org/download.cgi))