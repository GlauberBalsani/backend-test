package com.balsani.user.domain.model.mapper;

import com.balsani.user.domain.model.*;
import com.balsani.user.domain.model.dto.AddressDTO;
import com.balsani.user.domain.model.dto.AddressRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public Address toModel(AddressRequestDTO addressRequestDTO) {
        Address address = new Address();
        address.setLogradouro(addressRequestDTO.logradouro());
        address.setNumero(addressRequestDTO.numero());
        address.setCidade(addressRequestDTO.cidade());
        address.setEstado(addressRequestDTO.uf());


        return address;
    }

    public AddressDTO toDTO(Address address) {
        if (address == null) {
            return null;

        }

        return new AddressDTO(address.getLogradouro(),
                address.getNumero(), address.getCidade(),address.getEstado());
    }
}
