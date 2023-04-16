package by.it.academy.truck.dto;

import by.it.academy.truck.enams.UserType;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class UserResponse {
    private UUID id;
    private String nameCompany;
    private String location;
    private String email;
    private String userName;
    private String password;
    private UserType userType;
}
