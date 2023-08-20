FROM openjdk:17-alpine

VOLUME /tmp

RUN apk add --update --no-cache curl

ENV PORT=0

EXPOSE $PORT

ADD ./target/Movie-0.0.1-SNAPSHOT.jar movie.jar

ENTRYPOINT ["java", "-jar", "/movie.jar"]