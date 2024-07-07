package com.patika.emlakburadauserservice.converter;

import com.patika.emlakburadauserservice.dto.request.UserSaveRequest;
import com.patika.emlakburadauserservice.dto.response.UserResponse;
import com.patika.emlakburadauserservice.model.User;
import com.patika.emlakburadauserservice.util.HashUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserConverter {

//    public static User toUser(UserSaveRequest request) {
//        String hashedPassword = HashUtil.generate(request.getPassword());
//
//        User user = new User(request.getName(), request.getSurname(), request.getEmail(), hashedPassword);
//        user.setIsActive(Boolean.TRUE);
//        user.setPassword(hashedPassword);
//        return user;
//    }

    public static User toUser(UserSaveRequest request) {
        String hashedPassword = HashUtil.generate(request.getPassword());

        return User.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .email(request.getEmail())
                .password(hashedPassword)
                .build();
    }

    public static UserResponse toResponse(User user) {
        return UserResponse.builder()
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    public static Set<UserResponse> toResponse(List<User> users) {
        return users
                .stream()
                .map(UserConverter::toResponse)
                .collect(Collectors.toSet());
    }
}
