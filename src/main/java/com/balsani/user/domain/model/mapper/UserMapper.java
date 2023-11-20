package com.balsani.user.domain.model.mapper;

import org.springframework.stereotype.Component;

import com.balsani.user.domain.model.User;
import com.balsani.user.domain.model.UserDTO;
import com.balsani.user.domain.model.UserRequestDTO;

/**
 * Os records ainda não dão suporte a dependecia de mapeamento
 */

@Component
public class UserMapper {

    public User toModel(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setNome(userRequestDTO.nome());
        user.setSobrenome(userRequestDTO.sobreNome());
        user.setEmail(userRequestDTO.email());


        return user;
    }

    public UserDTO toDTO(User user) {
        if (user == null) {
            return null;
            
        }

        return new UserDTO(user.getNome(), user.getSobrenome(), user.getEmail());
    }
    
}
