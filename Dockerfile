FROM openjdk:17-alpine as builder
RUN mkdir "/home/target"
COPY target /home/target
WORKDIR /home
RUN jdeps --print-module-deps --ignore-missing-deps --multi-release 17 \
    --class-path="./target/lib/*" target/customjre-0.0.1-SNAPSHOT.jar>jdeps.info
RUN jlink --add-modules $(cat ./jdeps.info) --output ./jre

FROM alpine
RUN mkdir "/home/app"
ENV JAVA_HOME=/opt/jre-17
ENV PATH=$JAVA_HOME/bin:$PATH
COPY --from=builder /home/target/customjre-0.0.1-SNAPSHOT.jar /home/app/customjre.jar
COPY --from=builder /home/jre /opt/jre-17
WORKDIR /home/app
CMD java -jar customjre.jar