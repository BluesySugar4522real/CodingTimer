FROM bellsoft/liberica-runtime-container:jre-25

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
