package io.magicianlib.fs;

import io.magicianlib.fs.config.LoggingDirValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("io.magicianlib")
public class FsServiceApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(FsServiceApplication.class);
        application.addListeners(new LoggingDirValidator());
        application.run(args);
    }
}