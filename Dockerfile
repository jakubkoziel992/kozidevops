FROM eclipse-temurin:21.0.2_13-jdk

WORKDIR /deployments

RUN apt-get update && apt-get install maven -y

COPY . .

RUN mvn clean package

CMD ["java", "-cp", "target/oop-projekt-1.0-SNAPSHOT.jar", "pl.java_application.Main"]




