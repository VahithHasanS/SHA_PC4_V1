# Stage 1: Build
FROM eclipse-temurin:21-jdk AS build

WORKDIR /app
COPY . .

RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# Stage 2: Run
FROM eclipse-temurin:21-jdk

WORKDIR /app
COPY --from=build /app/target/shapc4v1-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]
