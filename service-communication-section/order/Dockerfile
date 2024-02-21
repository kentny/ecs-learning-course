FROM gradle:jdk21 AS build
WORKDIR /app
COPY . /app
RUN chmod +x ./gradlew && \
    ./gradlew build


FROM openjdk:21
COPY --from=build /app/build/libs/order-0.0.1-SNAPSHOT.jar ./order.jar
CMD [ "java", "-jar", "order.jar" ]
