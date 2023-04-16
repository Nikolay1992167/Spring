package by.it.academy.truck.services;

import by.it.academy.truck.dto.UserRequest;
import by.it.academy.truck.dto.UserResponse;
import by.it.academy.truck.dto.UserUpdateRequest;
import by.it.academy.truck.entities.User;
import by.it.academy.truck.exceptions.UserNotFoundException;
import by.it.academy.truck.mapper.UserMapper;
import by.it.academy.truck.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    private final UserRepository userRepository;

    public UserResponse getUser(UUID id) {
        log.info("In UserServiceImpl getUser{}", id);
        return userRepository.findById(id)
                .map(userMapper::buildUserResponse)
                .orElseThrow(()-> new UserNotFoundException(String.format("Can not find user with id %s", id)));
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        log.info("In UserServiceImpl createUser{}", userRequest);
        User user = userMapper.buildUser(userRequest);
        User savedUser = userRepository.save(user);
        return userMapper.buildUserResponse(savedUser);
    }

    @Override
    public List<UserResponse> getUsers(Pageable pageable) {
        log.info("In UserServiceImpl getUsers");
        return userRepository.findAll(pageable).stream()
                .map(userMapper::buildUserResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void updateUser(UserUpdateRequest userUpdateRequest) {
            User updateUser = userRepository.findById(userUpdateRequest.getId()).orElseThrow(() -> new IllegalArgumentException("Invalid user Id"));
            updateUser.setUserName(userUpdateRequest.getUserName());
            updateUser.setPassword(userUpdateRequest.getPassword());
            updateUser.setEmail(userUpdateRequest.getEmail());
            updateUser.setLocation(userUpdateRequest.getLocation());
            updateUser.setNameCompany(userUpdateRequest.getNameCompany());
            updateUser.setUserType(userUpdateRequest.getUserType());
            userRepository.save(updateUser);
    }

    @Override
    public void deleteUser(UUID id) {
        log.info("In UserServiceImpl deleteUser{}", id);
        userRepository.deleteById(id);
    }
}
