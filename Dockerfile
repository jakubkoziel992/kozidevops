FROM eclipse-temurin:21.0.2_13-jdk AS builder

WORKDIR /deployments

RUN apt-get update && apt-get install maven -y

COPY . .

RUN mvn clean package

FROM eclipse-temurin:21.0.2_13-jdk AS runner

COPY --from=builder /deployments/target/oop-projekt-1.0-SNAPSHOT.jar .

CMD ["java", "-cp", "oop-projekt-1.0-SNAPSHOT.jar", "pl.java_application.Main"]




