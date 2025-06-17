FROM eclipse-temurin:21
RUN mkdir -p /opt/app
COPY ./target/webserver-*.jar /opt/app/webserver.jar
WORKDIR /opt/app
CMD ["java","-jar","webserver.jar"]
