package by.it.academy.Truck.dto;

import by.it.academy.Truck.entities.UserType;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
@Builder
public class UserUpdateRequest {
    @NotNull
    private UUID id;
    @NotBlank
    private String nameCompany;
    @NotBlank
    private String location;
    @NotBlank
    private String email;
    @NotBlank
    private String userName;
    @NotBlank
    private String password;
    @NotNull
    private UserType userType;
}
