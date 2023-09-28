#Project for Bootcamp 2022

##Session 01
*  Spring Boot Webflux 2.5.x.
*  Spring Boot Actuator.
*  Controladores Rest y Restful.
*  Manejo de trazas con Logback.
*  Uso de lombok.

##Session 02
*  Spring Data JPA.
*  Mongo Reactivo.

##Session 03
*  Patrones de diseño en microservicios.
*  Mongo Reactivo.

##Session 04
*  Antipatrones de desarrollo en Microservicios.
*  Contenedores Docker.

##Session 05
*  Checkstyle.
*  Metricas de calidad con SonarQube.
*  Pruebas Unitarias con Junit5, Mockito, Mockwebserver


##Prerequisites

What things you need to install the software and how to install them

* [Java 11](https://www.oracle.com/technetwork/java/javase/downloads) - Programming Language.
* [Maven](https://maven.apache.org/) - Dependency Management.
* [Spring Boot](https://spring.io/projects/spring-boot) - Framework to microservices.

## Installing
```
mvn clean install
```

## Running
```
mvn spring-boot:run
```

## invoke endpoint customer

###Create new customer
```
curl --request POST 'localhost:9002/api/customer' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": "1",
    "firstname": "pepe",
    "lastname": "lopez",
    "email": "pepelopez@correo.com"
}'
```
###List all customers
```
curl --request GET 'localhost:9002/api/customer'
```

## invoke endpoint from Spring Actuator
```
curl --request GET 'localhost:9002/actuator'
```


## Running the tests

Para la ejecución de los test ejecutamos el siguiente comando.
para el gestor dependencias Maven.
```
mvn test
```
para el gestor dependencias Gradle.
```
gradle test
```

## Para valuación de codigo fuente localmente
* checkstyle
* pmd
* spotbugs
* jacoco


* [CheckStyle](https://checkstyle.sourceforge.io/) - Para los estilos de código.
* [Spotbugs](https://spotbugs.github.io/) - Para el análisis estático de código.
* [PMD](https://pmd.github.io/) - Para el análisis estático de código.

Para invocar el análisis de código estático.

Maven:
```
mvn compile test site
```

## Versioning

We use [SemVer](http://semver.org/) for versioning.