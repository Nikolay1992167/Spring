package by.it.academy.truck.services;

import by.it.academy.truck.configs.MailProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final MailProperties mailProperties;

    @Override
    public void sendMail() {
        String email = mailProperties.getEmail();
    }
}
