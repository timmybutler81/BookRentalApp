package com.butlert.bookrentalapp.controller;

import com.butlert.bookrentalapp.dto.UserDTO;
import com.butlert.bookrentalapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/add")
    public UserDTO saveUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }

    @GetMapping("/email-search")
    public UserDTO getUserByEmail(@RequestParam String emailAddress) {
        return userService.getUserByEmail(emailAddress);
    }

    @GetMapping("/last-name-search")
    public UserDTO getUserByLastName(@RequestParam String lastName) {
        return userService.getUserByLastName(lastName);
    }
}
