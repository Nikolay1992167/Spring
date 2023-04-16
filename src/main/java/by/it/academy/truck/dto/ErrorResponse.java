package by.it.academy.truck.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ErrorResponse {

    private String message;
    private LocalDateTime localDateTime;
    private final String phone = "+375 29 123 455 7";


    public ErrorResponse(String message, LocalDateTime localDateTime) {
        this.message = message;
        this.localDateTime = localDateTime;
    }
}
