FROM maven:3.8-jdk-11 AS build
COPY src /usr/src/booking-rooms/src
COPY pom.xml /usr/src/booking-rooms
RUN mvn -f /usr/src/booking-rooms/pom.xml clean package

FROM openjdk:11
COPY --from=build /usr/src/booking-rooms/target/booking-rooms.jar booking-rooms.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "booking-rooms.jar"]