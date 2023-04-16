package by.it.academy.truck.dto;

import by.it.academy.truck.enams.UserType;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@Builder
public class UserUpdateRequest {
    @NotNull
    private UUID id;
    @NotBlank
    @Size(max = 100)
    private String nameCompany;
    @NotBlank
    @Size(max = 100)
    private String location;
    @NotBlank
    @Size(max = 50)
    private String email;
    @NotBlank
    @Size(max = 50)
    private String userName;
    @NotBlank
    @Size(max = 50)
    private String password;
    @NotNull
    private UserType userType;
}
