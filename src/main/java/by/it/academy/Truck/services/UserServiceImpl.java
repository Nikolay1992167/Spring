package by.it.academy.Truck.services;

import by.it.academy.Truck.dto.UserRequest;
import by.it.academy.Truck.dto.UserResponse;
import by.it.academy.Truck.dto.UserUpdateRequest;
import by.it.academy.Truck.entities.User;
import by.it.academy.Truck.mapper.UserMapper;
import by.it.academy.Truck.mapper.UserUpdateMapper;
import by.it.academy.Truck.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    private final UserRepository userRepository;

    private final UserUpdateMapper updateMapper;


    public UserResponse getUser(UUID id) {
        log.info("In UserServiceImpl getUser{}", id);
        return userRepository.findById(id)
                .map(userMapper::buildUserResponse)
                .get();
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
        log.info("In UserServiceImpl updateUser{}", userUpdateRequest);
        User user = userRepository.findById(userUpdateRequest.getId()).get();
        updateMapper.updateUserFromDto(userUpdateRequest, user);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(UUID id) {
        log.info("In UserServiceImpl deleteUser{}", id);
        userRepository.deleteById(id);
    }
}
