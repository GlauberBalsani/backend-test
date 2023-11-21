package com.balsani.user.domain.controller;


import com.balsani.user.domain.model.dto.UserIndexAddressDTO;
import com.balsani.user.domain.model.dto.UserIndexAddressRequestDTO;
import com.balsani.user.domain.services.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users/address")
public class UserIndexController {
    private final AddressService addressService;

    public UserIndexController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public ResponseEntity<UserIndexAddressDTO> saveAddres(@RequestBody UserIndexAddressRequestDTO request) {
        UserIndexAddressDTO addressDTO = addressService.saveUserAndAddress(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(addressDTO);
    }

    @GetMapping
    public ResponseEntity<List<UserIndexAddressDTO>> getAll() {
        List<UserIndexAddressDTO> all = addressService.findAll();

        return ResponseEntity.ok(all);
    }


}
