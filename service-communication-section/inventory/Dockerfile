FROM gradle:jdk21 AS build
WORKDIR /app
COPY . /app
RUN chmod +x ./gradlew && \
    ./gradlew build


FROM openjdk:21
COPY --from=build /app/build/libs/inventory-0.0.1-SNAPSHOT.jar ./inventory.jar
CMD [ "java", "-jar", "inventory.jar" ]
