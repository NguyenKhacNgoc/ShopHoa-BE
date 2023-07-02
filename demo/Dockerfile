# Sử dụng Java 11 từ Docker Hub
FROM openjdk:11

# Thiết lập thư mục làm việc trong container
WORKDIR /app

# Sao chép file JAR của ứng dụng vào thư mục làm việc
COPY target/demo-0.0.1-SNAPSHOT.jar .

# Thiết lập biến môi trường cho ứng dụng
ENV PORT=8080

# Mở cổng cho ứng dụng
EXPOSE $PORT

# Chạy ứng dụng Spring Boot
CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]
