FROM maven:3.9-eclipse-temurin-21-alpine AS builder

WORKDIR /deployments


COPY . .

RUN mvn clean package

FROM eclipse-temurin:21.0.2_13-jre-alpine AS runner

RUN addgroup -g 500 myjavaapp &&  adduser -D  -u 501 -G myjavaapp myjavaapp

USER myjavaapp:myjavaapp

COPY --from=builder /deployments/target/oop-projekt-1.0-SNAPSHOT.jar .

CMD ["java", "-cp", "oop-projekt-1.0-SNAPSHOT.jar", "pl.java_application.Main"]




