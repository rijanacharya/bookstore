FROM openjdk:21

WORKDIR /app

COPY /build/libs/bookstore-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"] 
