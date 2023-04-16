package by.it.academy.truck.mapper;

import by.it.academy.truck.dto.UserRequest;
import by.it.academy.truck.dto.UserResponse;
import by.it.academy.truck.entities.User;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Component
@Builder
public class UserMapper {
    public UserResponse buildUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .nameCompany(user.getNameCompany())
                .location(user.getLocation())
                .email(user.getEmail())
                .userName(user.getUserName())
                .password(user.getPassword())
                .userType(user.getUserType())
                .build();
    }

    public User buildUser(UserRequest userRequest) {
        return User.builder()
                .nameCompany(userRequest.getNameCompany())
                .location(userRequest.getLocation())
                .email(userRequest.getEmail())
                .userName(userRequest.getUserName())
                .password(userRequest.getPassword())
                .userType(userRequest.getUserType())
                .build();
    }
}
