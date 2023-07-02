FROM 3.8.7-eclipse-temurin-19 as build
WORKDIR /app
COPY pom.xml .
COPY src/ src/
RUN mvn -f pom.xml clean package

FROM eclipse-temurin:19
WORKDIR /app
COPY --from=build /app/target/*.jar demo-0.0.1-SNAPSHOT.jar
ENTRYPOINT [“java”,“-jar”,“/demo-0.0.1-SNAPSHOT.jar”]
