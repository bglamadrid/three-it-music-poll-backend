# Music Poll Backend
Project generated using [Spring Initializr](https://start.spring.io/).

This project is the backend for the application requested by [3IT](https://www.3it.cl/) as an exam/test to apply for a position as Fullstack Developer.

## Overview
The main focus of this backend application is to provide persistence and server-side validation layers for the poll answers that will be received from an Angular application in the client-side.

It uses ***Maven v3.8*** and ***Spring Boot v2.7*** along with dependencies:
- [Project Lombok](https://projectlombok.org/)
- [Spring Web MVC](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Spring Validation](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#validation)
- [H2 Database Driver](https://h2database.com/html/main.html)

## Requirements
- Java 19 or higher ([Download from Oracle Releases](https://jdk.java.net/19/))
- Maven 3.6 or higher ([Download](https://maven.apache.org/download.cgi))

## Features
- REST API
- Simple data model with two entities:
  - Music Genre
  - Poll Answer