# Build stage
FROM maven:3.9.6-amazoncorretto-21 AS build

# Best practice to set this before running other instructions
# sets directory for subsequent commands instead of running commnads at the root dir
WORKDIR /project

# Move only necessary files over
COPY src .
COPY pom.xml .

# Package everything
RUN mvn clean package -DskipTests

# Production ready  stage
FROM amazoncorreto:21

WORKDIR /app

# Copy JAR over
COPY --from=build /project/*.jar app.jar

# Best practice: Run app as non-root user
RUN groupadd -r user && useradd -r -g user user
USER user

ENTRYPOINT ["java", "-jar", "/app.jar"]