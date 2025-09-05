# ===== Run stage =====
FROM eclipse-temurin:17-jre-alpine
ENV APP_HOME=/opt/app
WORKDIR $APP_HOME
COPY target/ConfigServer-0.0.1-SNAPSHOT.jar config-server.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/opt/app/config-server.jar"]
