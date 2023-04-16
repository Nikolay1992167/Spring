package by.it.academy.truck.services;

import by.it.academy.truck.dto.UserRequest;
import by.it.academy.truck.dto.UserResponse;
import by.it.academy.truck.dto.UserUpdateRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface UserService {

    UserResponse getUser(UUID id);

    UserResponse createUser(UserRequest userRequest);

    List<UserResponse> getUsers(Pageable pageable);

    void updateUser(UserUpdateRequest userUpdateRequest);

    void deleteUser(UUID id);
}
