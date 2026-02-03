package dpl.be.api.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "dpl.be")
public class ApiApp {
    public static void main(String[] args) {
        SpringApplication.run(ApiApp.class, args);
    }
}
