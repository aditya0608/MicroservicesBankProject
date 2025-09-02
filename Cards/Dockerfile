
# ---- Runtime image ----
# ---- Runtime image ----
FROM eclipse-temurin:17-jre-alpine
ENV APP_HOME=/opt/app
WORKDIR $APP_HOME
EXPOSE 8090
COPY target/cards-0.0.1-SNAPSHOT.jar cards.jar
ENTRYPOINT ["java", "-jar", "/opt/app/cards.jar"]

