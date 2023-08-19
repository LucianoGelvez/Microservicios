FROM openjdk:17-alpine

VOLUME /tmp

RUN apk add --update --no-cache curl

ADD ./target/catalog-0.0.1-SNAPSHOT.jar catalog.jar

ENTRYPOINT ["java", "-jar", "/catalog.jar"]