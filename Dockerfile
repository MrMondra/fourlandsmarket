# Usar una imagen base con JDK
FROM openjdk:17

EXPOSE 8090

# Copiar el JAR construido desde el contexto de construcción al contenedor
COPY target/fourlands.jar app.jar

# Establecer variables de entorno predeterminadas
ENV SPRING_DATASOURCE_URL_VIVA=""
ENV SPRING_DATASOURCE_USERNAME_VIVA=""
ENV SPRING_DATASOURCE_PASSWORD_VIVA=""
ENV SPRING_DATASOURCE_URL_CASA=""
ENV SPRING_DATASOURCE_USERNAME_CASA=""
ENV SPRING_DATASOURCE_PASSWORD_CASA=""

# Comando para ejecutar la aplicación
ENTRYPOINT ["java","-jar","/app.jar"]
