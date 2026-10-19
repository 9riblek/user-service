# ===== STAGE 1 : Build =====
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app

# Copier les fichiers Maven
COPY pom.xml .
COPY src ./src

# Build du projet (skip tests optionnel en prod CI/CD)
RUN mvn clean package -DskipTests

# ===== STAGE 2 : Runtime =====
FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

# Copier le jar depuis le stage build
COPY --from=builder /app/target/*.jar app.jar

# Port exposé (adapter si besoin)
EXPOSE 8080

# Variables JVM optimisées (important en prod microservices)
ENV JAVA_OPTS="-Xms256m -Xmx512m"

# Lancement de l’application
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]