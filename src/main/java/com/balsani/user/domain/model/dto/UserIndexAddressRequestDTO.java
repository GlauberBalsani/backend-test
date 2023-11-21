package com.balsani.user.domain.model.dto;

public record UserIndexAddressRequestDTO(String nome, String sobrenome, String email, AddressDTO addressDTO) {
}
