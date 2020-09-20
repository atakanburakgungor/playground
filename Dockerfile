FROM openjdk:8-jdk-alpine
MAINTAINER atakanburakgungor
VOLUME /tmp
EXPOSE 8080
ADD target/playground-0.0.1.jar playground.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/playground.jar"]
