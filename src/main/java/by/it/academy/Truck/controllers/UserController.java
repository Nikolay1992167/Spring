package by.it.academy.Truck.controllers;

import by.it.academy.Truck.dto.UserRequest;
import by.it.academy.Truck.dto.UserResponse;
import by.it.academy.Truck.dto.UserUpdateRequest;
import by.it.academy.Truck.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userServiceImpl;

    @GetMapping("id")
    public UserResponse getUser(@PathVariable UUID id) {
        return userServiceImpl.getUser(id);
    }

    @GetMapping
    public List<UserResponse> getUsers(Pageable pageable) {
        return userServiceImpl.getUsers(pageable);
    }

    @PostMapping
    public UserResponse createUser(@Validated @RequestBody UserRequest userRequest) {
        return userServiceImpl.createUser(userRequest);
    }

    @PutMapping
    public void updateUser(@Validated @RequestBody UserUpdateRequest userUpdateRequest) {
        userServiceImpl.updateUser(userUpdateRequest);
    }

    @DeleteMapping("id")
    public void deleteUser(@PathVariable UUID id) {
        userServiceImpl.deleteUser(id);
    }
}
