FROM java:8
VOLUME /tmp
ADD target/empmgmt-1.0.0.jar app.jar
EXPOSE 9090
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongo/test","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]