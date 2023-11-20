package com.balsani.user.domain.services;



import java.util.List;

import org.springframework.stereotype.Service;

import com.balsani.user.domain.exceptions.BusinessException;
import com.balsani.user.domain.model.User;
import com.balsani.user.domain.model.UserDTO;
import com.balsani.user.domain.model.UserRequestDTO;
import com.balsani.user.domain.model.mapper.UserMapper;
import com.balsani.user.domain.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;

    public UserService(UserRepository userRepository,UserMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    public UserDTO save(UserRequestDTO userRequestDTO) {
        User user = mapper.toModel(userRequestDTO);

        return mapper.toDTO(userRepository.save(user));
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<UserDTO> findByName(String nome) {
        return userRepository.findByNome(nome).stream()
            .map(mapper::toDTO)
            .toList();
    }

    public UserDTO update(Long id, UserRequestDTO request) {
        return userRepository.findById(id).map(actual -> {
            actual.setNome(request.nome());
            actual.setSobrenome(request.sobreNome());
            actual.setEmail(request.email());

            return mapper.toDTO(userRepository.save(actual));
        })

        .orElseThrow(() -> new BusinessException("Atualização invalida"));
    }

    
    
}
