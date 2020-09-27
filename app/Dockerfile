FROM maven:3.6-openjdk-8
EXPOSE 8080
WORKDIR /app
COPY . .

RUN pwd
RUN ls
RUN rm -rf target

RUN ls
RUN mvn clean
RUN mvn compile
RUN mvn package

CMD ["java", "-jar", "/app/target/actuator-service-0.0.1-SNAPSHOT.jar"]
