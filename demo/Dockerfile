# Sử dụng hình ảnh cơ sở Render cho Java
FROM render/java:11

# Thiết lập thư mục làm việc
WORKDIR /app

# Sao chép file JAR vào thư mục làm việc
COPY target/myapp.jar /app/myapp.jar

# Mở cổng mạng
EXPOSE 8080

# Chạy ứng dụng Spring Boot
CMD ["java", "-jar", "myapp.jar"]
