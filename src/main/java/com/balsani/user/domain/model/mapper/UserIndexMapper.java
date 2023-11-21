package com.balsani.user.domain.model.mapper;

import com.balsani.user.domain.model.Address;
import com.balsani.user.domain.model.User;
import com.balsani.user.domain.model.dto.*;
import org.springframework.stereotype.Component;

@Component
public class UserIndexMapper {
    public User toModel(UserIndexAddressRequestDTO userIndexAddressRequestDTO) {
        User user = new User();
        user.setNome(userIndexAddressRequestDTO.nome());
        user.setSobrenome(userIndexAddressRequestDTO.sobrenome());
        user.setEmail(userIndexAddressRequestDTO.email());


        Address address = new Address();
        address.setLogradouro(userIndexAddressRequestDTO.addressDTO().logradouro());
        address.setNumero(userIndexAddressRequestDTO.addressDTO().numero());
        address.setCidade(userIndexAddressRequestDTO.addressDTO().cidade());
        address.setEstado(userIndexAddressRequestDTO.addressDTO().uf());


        user.setAddress(address);

        return user;

    }

    public UserIndexAddressDTO toDTO(User user) {
        if (user == null) {
            return null;
        }

        AddressDTO addressDTO = mapAddressToDTO(user.getAddress());

        return new UserIndexAddressDTO(
                user.getNome(),
                user.getSobrenome(),
                user.getEmail(),
                addressDTO
        );
    }

    private AddressDTO mapAddressToDTO(Address address) {
        if (address == null) {
            return null;
        }

        return new AddressDTO(
                address.getLogradouro(),
                address.getNumero(),
                address.getCidade(),
                address.getEstado()
        );
    }
}
