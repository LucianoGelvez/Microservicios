FROM openjdk:17-alpine

VOLUME /tmp

RUN apk add --update --no-cache curl

ENV PORT=0

EXPOSE $PORT

ADD ./target/Serie-0.0.1-SNAPSHOT.jar serie.jar

ENTRYPOINT ["java", "-jar", "/serie.jar"]