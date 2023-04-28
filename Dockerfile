FROM openjdk
WORKDIR /jairu/backend
ADD target/jairu-0.0.1-SNAPSHOT.jar /jairu/backend
EXPOSE 8086
CMD ["$(cat /jairu/backend/.env_vars)","&&", "java", "-jar", "jairu-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=docker"]
