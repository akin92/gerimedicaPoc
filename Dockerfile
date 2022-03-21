FROM adoptopenjdk/openjdk11:latest
RUN mkdir /opt/app
COPY  gerimedica-1.0-SNAPSHOT.jar /opt/app
CMD ["java", "-jar", "/opt/app/gerimedica-1.0-SNAPSHOT.jar"]