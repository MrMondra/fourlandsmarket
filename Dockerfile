# Usar una imagen base con JDK
FROM openjdk:17

EXPOSE 8090

# Copiar el JAR construido desde el contexto de construcción al contenedor
COPY target/fourlands.jar app.jar

# Comando para ejecutar la aplicación
ENTRYPOINT ["java","-jar","/app.jar"]
