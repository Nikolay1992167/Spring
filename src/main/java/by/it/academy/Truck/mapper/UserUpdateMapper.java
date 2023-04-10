package by.it.academy.Truck.mapper;

import by.it.academy.Truck.dto.UserUpdateRequest;
import by.it.academy.Truck.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserUpdateMapper {
    void updateUserFromDto(UserUpdateRequest userUpdateRequest, User user);
}
