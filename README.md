# Administrative Debt Challenge


All the project was made using:

* Hexagonal Architecture or Ports and Adapters
* Java 15
* Maven version 3.6.3
* H2 Database Engine
* IntelliJ IDEA IDE


## Prerequisites

* Install Java 8 or higher, download from this link [here](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* Install Maven, download from this link [here](https://maven.apache.org/download.cgi). This article shows [how configure maven on Windows](https://www.mkyong.com/maven/how-to-install-maven-in-windows/).

## Setup

1) Clone the project from the repository.

```
git clone https://github.com/jsneider05/administrative-debt.git
```

## Run the project

1) Clean and install dependencies

```bash
cd administrative-debt
mvn clean install -U
```

2) Run the project as a jar:

```bash
cd administrative-debt/target
java -jar debt-${project.version}.jar
```
Or, as a Spring Boot Application with
```bash
mvn spring-boot:run
```
```bash
./mvnw spring-boot:run
```

## H2 Database

|Proyecto|URL|
|--------|---|
|H2|[http://localhost:8089/api/h2-console](http://localhost:8089/api/h2-console)|


## Swagger UI

|Proyecto|URL|
|--------|---|
|Debt|[http://localhost:8089/api/swagger-ui.html](http://localhost:8089/api/swagger-ui.html)|
