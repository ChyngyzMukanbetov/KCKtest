package com.example.kcktest.mapper;

import com.example.kcktest.model.dto.UserDto;
import com.example.kcktest.model.entity.User;
import com.example.kcktest.service.abstracts.UserService;
import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserResolver {
    private final UserService userService;

    @ObjectFactory
    public User resolve(UserDto userDto, @TargetType Class<User> type) {
        if (userDto == null) {
            return null;
        } else if (userService.findUserByLogin(userDto.getLogin()) == null) {
            return new User();
        } else {
            return userService.findUserByLogin(userDto.getLogin());
        }
    }
}
