FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/marvel-api*.jar marvel-api.jar
CMD java ${JAVA_OPTS} -jar marvel-api.jar