FROM openjdk
WORKDIR /jairu/backend
COPY target/jairu-0.0.1-SNAPSHOT.jar /jairu/backend
CMD ["java", "-jar", "jairu-0.0.1-SNAPSHOT.jar", "spring.datasource.url=jdbc:mysql://jairu_db:3306/jairu?createDatabaseIfNotExist=true"]
