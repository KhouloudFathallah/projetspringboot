FROM openjdk:17-jdk-slim
RUN apt-get update && apt-get install -y unzip
WORKDIR /app
COPY target/projetkhouloud-0.0.1-SNAPSHOT.jar.original /app/app.jar
EXPOSE 8081
RUN mkdir -p app && unzip -o app.jar -d app
CMD ["java" , "-jar" , "app.jar"]