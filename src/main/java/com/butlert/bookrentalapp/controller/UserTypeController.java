package com.butlert.bookrentalapp.controller;

import com.butlert.bookrentalapp.dto.UserTypeDTO;
import com.butlert.bookrentalapp.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-type")
public class UserTypeController {

    @Autowired
    private UserTypeService userTypeService;

    @GetMapping
    public List<UserTypeDTO> getAllUserTypes() {
        return userTypeService.getAllUserTypes();
    }

    @GetMapping("/{id}")
    public UserTypeDTO getUserTypeById(@PathVariable Long id) {
        return userTypeService.getUserTypeById(id);
    }

    @PostMapping("/add")
    public UserTypeDTO saveUserType(@RequestBody UserTypeDTO userTypeDTO) {
        System.out.println(userTypeDTO);
        return userTypeService.saveUserType(userTypeDTO);
    }
}
