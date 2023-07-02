# Sử dụng một base image chứa JDK 11
FROM adoptopenjdk/openjdk11:latest

# Thiết lập thư mục làm việc trong container
WORKDIR /app

# Sao chép các file cần thiết vào thư mục làm việc
COPY target/*.jar app.jar

# Mở port mà ứng dụng sẽ lắng nghe
EXPOSE 8080

# Thiết lập lệnh chạy ứng dụng khi container được khởi động
CMD ["java", "-jar", "app.jar"]
