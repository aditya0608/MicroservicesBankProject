FROM eclipse-temurin:17-jre-alpine
ENV APP_HOME=/opt/app
WORKDIR $APP_HOME
EXPOSE 8090
COPY target/user-0.0.1-SNAPSHOT.jar users.jar
# Run application
ENTRYPOINT ["java", "-jar", "/opt/app/users.jar"]
