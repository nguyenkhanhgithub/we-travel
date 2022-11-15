FROM maven:3.6.1-jdk-8-alpine AS build
WORKDIR /app
COPY pom.xml ./pom.xml
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn -Dmaven.test.skip=true clean package
#
# Package stage
#
FROM openjdk:8u212-jdk-alpine
COPY --from=build /app/target/we-travel.jar we-travel.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar","we-travel.jar"]