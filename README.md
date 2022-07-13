### Requirements
* [Java](https://www.java.com/download/)
* [Maven](https://maven.apache.org/)
* [PostgreSQL](https://www.postgresql.org/)

### Setup
#### DB Setup
As this test needs a (valid) database to work, it needs Postgres and the database dump file to
to work.

[file database ](https://github.com/VictorAlfonsoMendozaRodriguez/PruebaTecnica/blob/5e763e97ca0f827c2cae901e0ded1e6b1e10da0a/batabase.sql)

After the DB is installed, you will need to configure `application.properties` with your
DB information in `\src\main\resources`

`spring.datasource.url=jdbc:postgresql://localhost:5432/technical_test`

`spring.datasource.username=postgres`

`spring.datasource.password=postgres`


# Server Setup
#### windows check if is mvn or mvnw
* Run `mvn install` or `mvnv install`  install dependencies & build source
* Run `mvn spring-boot:run` or `mvnw spring-boot:run` to start server

#test postaman file
[file postman file](https://github.com/VictorAlfonsoMendozaRodriguez/PruebaTecnica/blob/5e763e97ca0f827c2cae901e0ded1e6b1e10da0a/Technical_Test.postman_collection.json)
