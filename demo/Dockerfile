# Sử dụng base image có chứa Java 11 và Maven để xây dựng ứng dụng Spring Boot
FROM adoptopenjdk:11-jdk-hotspot as build

# Thiết lập thư mục làm việc
WORKDIR /app

# Sao chép tệp pom.xml đến thư mục làm việc
COPY pom.xml .

# Tải các phụ thuộc Maven
RUN mvn dependency:go-offline -B

# Sao chép toàn bộ mã nguồn vào thư mục làm việc
COPY src ./src

# Xây dựng ứng dụng Spring Boot
RUN mvn package -DskipTests

# Sử dụng base image khác có chứa JRE để chạy ứng dụng
FROM adoptopenjdk:11-jre-hotspot

# Thiết lập thư mục làm việc
WORKDIR /app

# Sao chép file jar đã được xây dựng từ image 'build'
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar app.jar

# Chạy ứng dụng Spring Boot
CMD ["java", "-jar", "app.jar"]
