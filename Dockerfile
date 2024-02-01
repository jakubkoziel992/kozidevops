FROM eclipse-temurin:21.0.2_13-jre

WORKDIR /deployments

COPY target/oop-projekt-1.0-SNAPSHOT.jar .

CMD ["java", "-cp", "oop-projekt-1.0-SNAPSHOT.jar", "pl.java_application.Main"]




