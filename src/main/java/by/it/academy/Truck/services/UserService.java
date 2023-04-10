package by.it.academy.Truck.services;

import by.it.academy.Truck.dto.UserRequest;
import by.it.academy.Truck.dto.UserResponse;
import by.it.academy.Truck.dto.UserUpdateRequest;
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
