FROM openjdk:10
ADD target/anemone-bot.jar anemone.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "anemone.jar"]