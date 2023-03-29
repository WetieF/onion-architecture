# Dockerizing the backend

#FROM openjdk:8
## The ADD instruction copies new files, directories or remote file URLs from <src> and adds them to the filesystem of the image at the path <dest>
#COPY onion-architecture-0.0.1-SNAPSHOT.jar /container/backend.jar
## The <dest> is an absolute path, or a path relative to WORKDIR, into which the source will be copied inside the destination container.(/container/backend.jar)
##WORKDIR /container/backend.jar
#EXPOSE 8083
##An ENTRYPOINT allows you to configure a container that will run as an executable.
#ENTRYPOINT ["java", "-jar", "/container/backend.jar"]

#ENTRYPOINT ["java", "-jar", "/container/backend.jar", "--spring.profiles.active=docker"]