# spring-api-refapp

### About
Designing a Spring Boot backend application. The overall goal of the project is to learn more about
Spring Boot and the different features it offers (e.g., Spring MVC, JPA, Security, etc.).

### Local Development

#### Running the Application Using Docker

Use the provided `compose.yaml` file to run the application. It defines two services, the API and the database service that
the API depends on. 

For both services to build, you will need to define the following environment variables:
```yaml
DATABASE_USER
DATABASE_PASSWORD
DATABASE_NAME
DATABASE_URL
```

One easy way of doing this is by defining an `.env` file in the root project directory like so:
```bash
  DATABASE_USER=<username>
  DATABASE_PASSWORD=<password>
  DATABASE_NAME=<tablename>
  DATABASE_URL=jdbc:postgresql://postgresql:5432/<tablename>
```

Once that is set up, build the services with the following commands:
```bash
    docker compose down
    docker compose build
    docker compose up
```


#### Running the Application Manually
The application.properties files expects the following environment variables which correspond to your PostgresSQL configuration:

```bash
spring.datasource.url=${DATABASE_URL}
spring.datasource.username=${DATABASE_USER}
spring.datasource.password=${DATABASE_PASSWORD}
```

Once that is set up, run `mvn spring-boot:run` in your terminal to start the application. This requires the corresponding
database to be up and running already beforehand.

#### Postman
This project includes a Postman
collection which can be imported. You can send requests to the different endpoints that this project supports.

#### Testing
Run `mvn test` to run all the unit tests included in this project. The database layer is mocked out, so there is no need
to have the container running in the background for this.

#### Formatting
Run `mvn spotless:check` to see if your code fits the Google Java style standards. The spotless formatting plugin is configured to automatically
invoke the `check` goal in the `compile` phase. If you have format violations, run `mvn spotless:apply` to automatically apply the pre-configured formatting rules for this project. 
