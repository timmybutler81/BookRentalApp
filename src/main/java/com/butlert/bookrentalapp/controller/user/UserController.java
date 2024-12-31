package com.butlert.bookrentalapp.controller.user;

import com.butlert.bookrentalapp.dto.user.UserDTO;
import com.butlert.bookrentalapp.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<UserDTO> addOrUpdateUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.addOrUpdateUser(userDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/email-search")
    public ResponseEntity<List<UserDTO>> getUserByEmail(@RequestParam String emailAddress) {
        return ResponseEntity.ok(userService.getUserByEmail(emailAddress));
    }

    @GetMapping("/lastname-search")
    public ResponseEntity<List<UserDTO>> getUserByLastName(@RequestParam String lastName) {
        return ResponseEntity.ok(userService.getUserByLastName(lastName));
    }
}
