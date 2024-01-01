FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/projetkhouloud-0.0.1-SNAPSHOT.jar /app/projetkhouloud-0.0.1-SNAPSHOT.jar

EXPOSE 8888

CMD ["java","-jar","projetkhouloud-0.0.1-SNAPSHOT.jar"]