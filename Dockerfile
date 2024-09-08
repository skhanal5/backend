FROM amazoncorreto:21

# Best practice to set this before running other instructions
# sets directory for subsequent commands instead of running commnads at the root dir
WORKDIR /app

# Do maven stuff
COPY pom.xml .

ARG JAR_FILE=target/*.jar


# Run app as non-root user
USER user
ENTRYPOINT ["java", "-jar", "/app.jar"]

# mvn spring-boot:build-image instead?
