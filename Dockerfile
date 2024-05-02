FROM eclipse-temurin:17
WORKDIR /home
COPY ./target/c322-final-0.0.1-SNAPSHOT.jar c322-final.jar
ENTRYPOINT ["java", "-jar", "c322-final.jar"]
