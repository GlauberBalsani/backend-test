package com.balsani.user.domain.model.dto;

import com.balsani.user.domain.model.enums.UF;

public record AddressDTO(String logradouro, String numero, String cidade, UF uf) {
}
