package com.balsani.user.domain.controller;

import java.util.List;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.balsani.user.domain.model.User;
import com.balsani.user.domain.model.UserDTO;
import com.balsani.user.domain.model.UserRequestDTO;
import com.balsani.user.domain.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<UserDTO> save(@Valid @RequestBody UserRequestDTO request) {
        UserDTO body = userService.save(request);;

        return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        List<User> body = userService.findAll();

        return ResponseEntity.ok(body);
    }

    @GetMapping("{nome}")
    public ResponseEntity<List<UserDTO>> getByName(@Valid @RequestBody @PathVariable String nome) {
        List<UserDTO> findByName = userService.findByName(nome);
        
        return ResponseEntity.status(HttpStatus.FOUND).body(findByName);
    }
    
}
