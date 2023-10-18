FROM openjdk:17
WORKDIR /app
COPY build/libs/*.jar /app/
EXPOSE 8081
CMD ["java","-jar","app.jar"]