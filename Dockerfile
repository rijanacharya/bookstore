FROM openjdk:21

WORKDIR /app

COPY /build/libs/SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"] 
