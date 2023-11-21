package com.balsani.user.domain.model.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRequestDTO(
    @NotBlank
    @NotNull
    @Length(min = 1, max = 100)
    String nome,

    @NotBlank
    @NotNull
    @Length(min = 1, max = 100)
    String sobreNome,

    @NotBlank
    @NotNull
    @Email
    String email
) {
    
}
