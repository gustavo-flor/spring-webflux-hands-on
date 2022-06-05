package com.github.gustavoflor.springwebfluxhandson.dto;

import com.github.gustavoflor.springwebfluxhandson.entity.User;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record UserDTO(String id, String name, String email) {
    public static UserDTO of(final User user) {
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
