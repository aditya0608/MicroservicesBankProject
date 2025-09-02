package com.aditya.user.service.assembler;

import com.aditya.user.model.dto.UserDTO;
import com.aditya.user.model.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserAssembler {

    public static UserDTO fromDomainObject(User user) {
        if (user == null) return null;
        return new UserDTO(user.getUserId(), user.getUserPassword());
    }

    public static User toDomainObject(UserDTO dto) {
        if (dto == null) return null;
        User user = new User();
        user.setUserId(dto.userId());
        user.setUserPassword(dto.userPassword());
        return  user;
    }
}

