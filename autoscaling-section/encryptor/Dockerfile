FROM gradle:jdk21 AS build
WORKDIR /app
COPY . /app
RUN ./gradlew build


FROM openjdk:21
COPY --from=build /app/build/libs/encryptor-0.0.1-SNAPSHOT.jar ./encryptor.jar
CMD [ "java", "-jar", "encryptor.jar" ]
