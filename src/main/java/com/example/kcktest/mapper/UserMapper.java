package com.example.kcktest.mapper;

import com.example.kcktest.model.dto.UserDto;
import com.example.kcktest.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = UserResolver.class)
public interface UserMapper {

    UserDto toDto(User user);

    @Mapping(target = "id", ignore = true)
    User toUser(UserDto userDto);
}
