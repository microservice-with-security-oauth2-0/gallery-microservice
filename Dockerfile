FROM openjdk:8-jre
MAINTAINER Seshasai <kseshasai.88@gmail.com>

# Add the service itself
#ARG JAR_FILE = *.jar
ADD target/*.jar /usr/share/microservice-ex1/gallary-service.jar

ENTRYPOINT ["java", "-jar", "/usr/share/microservice-ex1/gallary-service.jar"]