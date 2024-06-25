#FROM openjdk:17-jdk-slim
#VOLUME /tmp
#COPY target/springboot-pod-nginx-0.0.1-SNAPSHOT springboot-pod-nginx-0.0.1-SNAPSHOT.jar
#ENTRYPOINT ["java","-jar","/springboot-pod-nginx-0.0.1-SNAPSHOT.jar"]

# Użyj oficjalnego obrazu OpenJDK 17 jako bazowego obrazu
FROM openjdk:17-alpine

# Ustaw katalog roboczy na /app
WORKDIR /app

# Skopiuj plik JAR aplikacji do obrazu
COPY target/springboot-pod-nginx-0.0.1-SNAPSHOT.jar /app

# Zdefiniuj punkt wejścia dla kontenera
ENTRYPOINT ["java", "-jar", "springboot-pod-nginx-0.0.1-SNAPSHOT.jar"]