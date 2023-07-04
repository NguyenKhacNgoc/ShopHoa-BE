# Sử dụng một image cơ sở Java để xây dựng ứng dụng
FROM adoptopenjdk:11-jdk-hotspot

# Thiết lập thư mục làm việc trong container
WORKDIR /app

# Sao chép tệp pom.xml vào thư mục hiện tại
COPY pom.xml .

# Sao chép các tệp nguồn và tài nguyên vào thư mục hiện tại
COPY src ./src

# Xây dựng ứng dụng bằng Maven
RUN ./mvnw package -DskipTests

# Sao chép tệp jar đã được xây dựng vào thư mục /app
COPY target/*.jar app.jar

# Thiết lập biến môi trường PORT cho ứng dụng
ENV PORT=8080

# Thiết lập lệnh chạy ứng dụng khi container được khởi chạy
CMD ["java", "-jar", "app.jar"]
