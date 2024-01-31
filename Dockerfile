FROM openjdk:23

WORKDIR /app/src/
COPY out/artifacts/oop_projekt_jar/oop-projekt.jar .

CMD ["java", "-jar", "oop-projekt.jar"] 

