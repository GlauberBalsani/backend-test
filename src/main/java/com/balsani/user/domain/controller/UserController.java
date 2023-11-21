package com.balsani.user.domain.controller;

import java.util.List;


import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.balsani.user.domain.model.dto.UserDTO;
import com.balsani.user.domain.model.dto.UserRequestDTO;
import com.balsani.user.domain.services.UserService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

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
    public ResponseEntity<List<UserDTO>> getAll() {
        List<UserDTO> body = userService.findAll();

        return ResponseEntity.ok(body);
    }

    @GetMapping("/byname/{nome}")
    public ResponseEntity<List<UserDTO>> getByName(@Valid @RequestBody @PathVariable String nome) {
        List<UserDTO> findByName = userService.findByName(nome);
        
        return ResponseEntity.status(HttpStatus.FOUND).body(findByName);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable @Valid Long id) {
        UserDTO bodyId = userService.findById(id);
        return  ResponseEntity.status(HttpStatus.OK).body(bodyId);

    }

    @DeleteMapping("deleteBy/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable @Valid Long id) {
        userService.deletById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/byId/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable @Positive Long id, @RequestBody @Valid UserRequestDTO request) {
        UserDTO userDTO = userService.update(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(userDTO);

    }



    
    
}
