FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY target/app.jar app.jar
ENV JAVA_OPTS="-Xms256m -Xmx256m"
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
