FROM openjdk:21-jdk

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем jar-файл в контейнер
COPY target/MetroFood-1.0.0.jar MetroFood-1.0.0.jar

# Указываем команду для запуска приложения
ENTRYPOINT ["java", "-jar", "MetroFood-1.0.0.jar"]

EXPOSE 8080