package com.github.gustavoflor.springwebfluxhandson.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public record UpdateUserDTO(@NotBlank String name, @Email @NotBlank String email) {
}
