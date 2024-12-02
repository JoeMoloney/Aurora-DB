package joe.aurora;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class AuroraApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuroraApplication.class, args);
        log.info("Aurora Application Started");
    }
}