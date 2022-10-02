FROM openjdk:17-alpine
RUN mkdir "/home/app"
COPY target/customjre-0.0.1-SNAPSHOT.jar /home/app/customjre.jar
WORKDIR /home/app
CMD java -jar customjre.jar