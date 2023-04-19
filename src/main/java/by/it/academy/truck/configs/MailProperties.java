package by.it.academy.truck.configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("services.mail")
public class MailProperties {
    private String email;
    private String username;
    private String password;
}
