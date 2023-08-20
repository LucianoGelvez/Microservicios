FROM openjdk:17-alpine

VOLUME /tmp

EXPOSE 8761

RUN apk add --update --no-cache curl

ADD ./target/eureka-server-0.0.1-SNAPSHOT.jar eureka.jar

ENTRYPOINT ["java", "-jar", "/eureka.jar"]