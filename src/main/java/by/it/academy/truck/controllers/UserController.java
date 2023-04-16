package by.it.academy.truck.controllers;

import by.it.academy.truck.dto.UserRequest;
import by.it.academy.truck.dto.UserResponse;
import by.it.academy.truck.dto.UserUpdateRequest;
import by.it.academy.truck.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {

    private final UserService userServiceImpl;

    @GetMapping("/users/{id}")
    public UserResponse getUser(@PathVariable UUID id) {
        return userServiceImpl.getUser(id);
    }

    @GetMapping("/users")
    public List<UserResponse> getUsers(Pageable pageable) {
        return userServiceImpl.getUsers(pageable);
    }

    @PostMapping("/user")
    public UserResponse createUser(@Validated @RequestBody UserRequest userRequest) {
        return userServiceImpl.createUser(userRequest);
    }

    @PutMapping("/update/user")
    public void updateUser(@Validated @RequestBody UserUpdateRequest userUpdateRequest) {
        userServiceImpl.updateUser(userUpdateRequest);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable UUID id) {
        userServiceImpl.deleteUser(id);
    }
}
