package springboot03jdbc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(basePackages = "springboot03jdbc.mappers")
@SpringBootApplication
public class Springboot03JdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot03JdbcApplication.class, args);
    }

}
