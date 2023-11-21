package com.balsani.user.domain.services;


import com.balsani.user.domain.model.Address;
import com.balsani.user.domain.model.User;

import com.balsani.user.domain.model.dto.AddressDTO;
import com.balsani.user.domain.model.dto.AddressRequestDTO;
import com.balsani.user.domain.model.dto.UserIndexAddressDTO;
import com.balsani.user.domain.model.dto.UserIndexAddressRequestDTO;
import com.balsani.user.domain.model.mapper.AddressMapper;
import com.balsani.user.domain.model.mapper.UserIndexMapper;
import com.balsani.user.domain.repository.AddressRepository;
import com.balsani.user.domain.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AddressService {
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;
    private final UserIndexMapper mapper;
    private final AddressMapper addressMapper;

    public AddressService(AddressRepository addressRepository,
                          UserRepository userRepository, UserIndexMapper mapper, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.addressMapper = addressMapper;
    }

    public UserIndexAddressDTO save(UserIndexAddressRequestDTO request) {
        User user = mapper.toModel(request);

        return mapper.toDTO(userRepository.save(user));
    }

    public List<UserIndexAddressDTO> findAll() {
        return userRepository.findAll().stream().map(mapper::toDTO).toList();
    }

    public AddressDTO saveAddres(AddressRequestDTO request) {
        Address address = addressMapper.toModel(request);

        return addressMapper.toDTO(addressRepository.save(address));

    }

    public UserIndexAddressDTO saveUserAndAddress(UserIndexAddressRequestDTO userIndexAddressRequestDTO) {
        // Mapear o DTO para entidades
        User user = mapper.toModel(userIndexAddressRequestDTO);
        Address address = user.getAddress();


        Address savedAddress = addressRepository.save(address);

        // Associar o endereço salvo ao usuário
        user.setAddress(savedAddress);

        // Salvar o usuário
        return mapper.toDTO(userRepository.save(user));
    }
}
