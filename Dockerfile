# Imagen base con Java 21
FROM eclipse-temurin:21-jdk

# Directorio de trabajo
WORKDIR /app

# Copiamos el proyecto
COPY . .

# Damos permiso de ejecución al Maven Wrapper
RUN chmod +x mvnw

# Construimos el JAR
RUN ./mvnw clean package -DskipTests

# Puerto usado por Spring Boot
EXPOSE 8080

# Arranque
CMD ["java", "-jar", "target/fraud-detector-0.0.1-SNAPSHOT.jar"]
