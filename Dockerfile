# First stage: complete build environment
FROM maven:3.5.0-jdk-8-alpine AS builder

# add pom.xml and source code
ADD ./pom.xml pom.xml
ADD ./src src/

# package jar
RUN mvn clean package

# Second stage: minimal runtime environment
From openjdk:8-jre-alpine

# copy jar from the first stage
COPY --from=builder target/springboot-actuator-prometheus-test-0.0.1-SNAPSHOT.jar springboot-actuator-prometheus-test-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "springboot-actuator-prometheus-test-0.0.1-SNAPSHOT.jar"]