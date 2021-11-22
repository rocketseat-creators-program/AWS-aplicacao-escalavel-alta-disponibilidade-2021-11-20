FROM adoptopenjdk/openjdk11:alpine-slim

#Create user and usergroup
RUN addgroup -S spring && adduser -S spring -G spring

#Use the user
USER spring:spring

#Define the arg JAR_FILE
ARG JAR_FILE=target/*-SNAPSHOT.jar

COPY ${JAR_FILE} app.jar

EXPOSE 8080

#Start the application
ENTRYPOINT ["java","-jar","/app.jar"]