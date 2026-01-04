# Imagen base con Java 21
FROM eclipse-temurin:21-jdk

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiamos el proyecto
COPY . .

# Construimos el JAR
RUN ./mvnw clean package -DskipTests

# Puerto usado por Spring Boot
EXPOSE 8080

# Comando de arranque
CMD ["java", "-jar", "target/fraud-detector-0.0.1-SNAPSHOT.jar"]
