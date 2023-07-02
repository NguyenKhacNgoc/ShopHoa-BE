# Sử dụng image adoptopenjdk phiên bản 11 làm base
FROM adoptopenjdk:11-jdk-hotspot

# Thiết lập thư mục làm việc trong container
WORKDIR /app

# Sao chép mã nguồn và các tệp cần thiết vào container
COPY . /app

# Cài đặt Maven và cài đặt phụ thuộc
RUN apt-get update && apt-get install -y maven
RUN mvn install

# Cấu hình cổng lắng nghe
EXPOSE 8080

# Chạy ứng dụng
CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]
