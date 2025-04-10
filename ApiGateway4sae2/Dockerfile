FROM openjdk:17
EXPOSE 8761
ADD target/ApiGateway4sae2-0.0.1-SNAPSHOT.jar gateway.jar
ENTRYPOINT ["java", "-jar","gateway.jar"]