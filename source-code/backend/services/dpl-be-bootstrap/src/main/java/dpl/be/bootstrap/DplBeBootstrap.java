package dpl.be.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "dpl.be")
public class DplBeBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(DplBeBootstrap.class, args);
    }
}
