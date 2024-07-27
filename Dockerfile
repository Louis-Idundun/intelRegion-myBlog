FROM openjdk:17-jdk-slim
LABEL authors="louisidundun"

VOLUME /tmp
COPY target/myBlog-0.0.1-SNAPSHOT.jar intelRegionProject.jar
ENTRYPOINT ["java","-jar","/intelRegionProject.jar"]