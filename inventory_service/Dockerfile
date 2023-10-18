FROM openjdk:17
WORKDIR /app
COPY build/libs/*.jar /app/
EXPOSE 8083
CMD ["java","-jar","app.jar"]