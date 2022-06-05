package com.github.gustavoflor.springwebfluxhandson.entity;

import com.github.gustavoflor.springwebfluxhandson.dto.CreateUserDTO;
import com.github.gustavoflor.springwebfluxhandson.dto.UpdateUserDTO;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@Builder(access = AccessLevel.PRIVATE)
public class User {
    @Id
    private String id;

    private String name;

    private String email;

    public static User of(final CreateUserDTO dto) {
        return User.builder()
                .name(dto.name())
                .email(dto.email())
                .build();
    }

    public User merge(final UpdateUserDTO dto) {
        setName(dto.name());
        setEmail(dto.email());
        return this;
    }
}
