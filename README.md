# spring-api-refapp

### About
Designing a Spring Boot backend application. The overall goal of the project is to learn more about
Spring Boot and the different features it offers (e.g., Spring MVC, JPA, Security, etc.).

### Local Development

#### Running the Database

Use the provided `compose.yaml` file to run the PostgresSQL via Docker. It will run on port `5433` on your local machine.
You will need to configure the following environment variables in the YAML file:

```bash
      POSTGRES_USER: ${DATABASE_USER}
      POSTGRES_PASSWORD: ${DATABASE_PASSWORD}
      POSTGRES_DB: ${DATABASE_NAME}
```

Once that is set up, build the services:

```bash
    docker compose down
    docker compose build
    docker compose up
```

If you read the log output, you will notice that the `db_init.sql` script runs on initialization of the Docker container.
This script will create the basic table that corresponds to the `User` Entity.

#### Running the Application
The application.properties files expects the following environment variables which correspond to your PostgresSQL configuration:

```bash
spring.datasource.url=${DATABASE_URL}
spring.datasource.username=${DATABASE_USER}
spring.datasource.password=${DATABASE_PASSWORD}
```

Once that is set up, run `mvn spring-boot:run` in your terminal to start the applications.

#### Postman
This project includes a Postman
collection which can be imported. You can send requests to the different endpoints that this project supports.

#### Testing
Run `mvn test` to run all the unit tests included in this project. The database layer is mocked out, so there is no need
to have the container running in the background for this.

#### Formatting
Run `mvn spotless:check` to see if your code fits the Google Java style standards. The spotless formatting plugin is configured to automatically
invoke the `check` goal in the `compile` phase. If you have format violations, run `mvn spotless:apply` to automatically apply the pre-configured formatting rules for this project. 
