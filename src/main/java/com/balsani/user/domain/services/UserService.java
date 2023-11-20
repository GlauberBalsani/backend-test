package com.balsani.user.domain.services;



import java.util.List;

import com.balsani.user.domain.exceptions.RecordNotFoundException;
import org.springframework.stereotype.Service;

import com.balsani.user.domain.exceptions.BusinessException;
import com.balsani.user.domain.model.User;
import com.balsani.user.domain.model.UserDTO;
import com.balsani.user.domain.model.UserRequestDTO;
import com.balsani.user.domain.model.mapper.UserMapper;
import com.balsani.user.domain.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
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

    public void deletById(Long id) {
        userRepository.delete(userRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));
    }

    public UserDTO findById(Long id){
        return userRepository.findById(id).map(mapper::toDTO)
                .orElseThrow(() -> new BusinessException("USer nao enotrado"));
    }

    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(mapper::toDTO).toList();
    }

    public List<UserDTO> findByName(String nome) {
        return userRepository.findByNome(nome).stream()
            .map(mapper::toDTO)
            .toList();
    }

    public UserDTO update(Long id, UserRequestDTO request) {
        User actual = userRepository.findById(id).orElse(null);

        if (actual != null) {
            actual.setNome(request.nome());
            actual.setSobrenome(request.sobreNome());
            actual.setEmail(request.email());

            User updatedUser = userRepository.save(actual);
            return mapper.toDTO(updatedUser);
        } else {
            throw new BusinessException("Atualização inválida");
        }
    }





}
