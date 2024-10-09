# Use an OpenJDK 17 base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the project files into the container
COPY . /app

# Create the databases directory (the SQLite file will be mounted here)
RUN mkdir -p /app/databases

# create a .env file in the root of the app project and embed the secrets
RUN echo "DATABASE_USERNAME=admin123" > /app/.env && \
    echo "DATABASE_PASSWORD=admin123" >> /app/.env

# Expose the port that the Spring Boot app will run on
EXPOSE 8080

# Install Maven for building the project
RUN apt-get update && apt-get install -y maven

# Package the Spring Boot app (this creates a .jar file in the target directory)
RUN mvn clean package -DskipTests

# Copy the JAR file to a known location (this avoids issues with wildcard usage in ENTRYPOINT)
RUN cp target/*.jar /app/app.jar

# Set up the entrypoint to run the JAR
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

# The volume for the SQLite database file (this will be mounted from the host)
VOLUME ["/app/databases"]
