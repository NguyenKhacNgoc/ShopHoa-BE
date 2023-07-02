# Sử dụng Java 11 làm base image
FROM adoptopenjdk:11-jre-hotspot

# Thay đổi thư mục làm việc
WORKDIR /app

# Sao chép tất cả các file từ thư mục target của dự án Spring Boot vào trong container
COPY target/*.jar demo-0.0.1-SNAPSHOT.jar

# Expose cổng mà ứng dụng sẽ lắng nghe
EXPOSE 8080

# Chạy ứng dụng khi container được khởi chạy
CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]
