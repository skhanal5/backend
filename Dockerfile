# Build stage
FROM maven:3.9.6-amazoncorretto-21 AS build

# Best practice to set this before running other instructions
# sets directory for subsequent commands instead of running commnads at the root dir
WORKDIR /project

# Move only necessary files over
COPY src src
COPY pom.xml .

# Package everything
RUN mvn clean package -DskipTests

# Production ready stage
FROM amazoncorretto:21

WORKDIR /app

# Install this to create user
RUN yum -y install shadow-utils

# Create non-privileged user
RUN groupadd -r user && useradd -r -g user user
RUN chown -R user /app

# Copy JAR over
COPY --from=build /project/target/*.jar app.jar

# Best practice: Run app as non-root user
USER user

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]