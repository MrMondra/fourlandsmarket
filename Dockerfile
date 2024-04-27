# Usar una imagen base con JDK
FROM openjdk:17

# Argumentos de compilación que se pueden pasar con --build-arg
ARG JAR_FILE=target/*.jar

# Copiar el JAR construido desde el contexto de construcción al contenedor
COPY ${JAR_FILE} app.jar

# Comando para ejecutar la aplicación
ENTRYPOINT ["java","-jar","/app.jar"]
