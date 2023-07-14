FROM maven:3.8.1-jdk-11-openj9
WORKDIR /app
COPY target/Truck-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT ["java","-jar","Truck-0.0.1-SNAPSHOT.jar"]