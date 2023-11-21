package com.balsani.user.domain.model.dto;

public record UserIndexAddressDTO(
        String nome,
        String sobrenome,
        String email,
        AddressDTO addressDTO) {
}
