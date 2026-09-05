package se.jan.wos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
public class LagerOrdersystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(LagerOrdersystemApplication.class, args);
    }

}
