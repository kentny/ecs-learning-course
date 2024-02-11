FROM gradle:jdk21 AS build
WORKDIR /app
COPY . /app
RUN chmod +x ./gradlew && \
    ./gradlew build


FROM openjdk:21
COPY --from=build /app/build/libs/session-management-0.0.1-SNAPSHOT.jar ./session-management.jar
CMD [ "java", "-jar", "session-management.jar" ]
