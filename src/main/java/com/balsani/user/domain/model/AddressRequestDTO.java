package com.balsani.user.domain.model;

import com.balsani.user.domain.model.enums.UF;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record AddressRequestDTO(
        @NotBlank(message = "Informe a Rua")
        @NotNull
        @Length(min = 1, max = 255)
        String logradouro,
        @NotNull
        @NotBlank(message = "Informe o número da residência")
        @Length(min = 1)
        String numero,
        @NotBlank(message = "Informe a Cidade")
        @NotNull
        @Length(min = 1, max = 255)
        String cidade,
        @NotBlank
        @NotNull
        UF uf
) {
}
