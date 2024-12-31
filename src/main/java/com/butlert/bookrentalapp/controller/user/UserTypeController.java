package com.butlert.bookrentalapp.controller.user;

import com.butlert.bookrentalapp.dto.user.UserTypeDTO;
import com.butlert.bookrentalapp.service.user.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-type")
public class UserTypeController {

    @Autowired
    private UserTypeService userTypeService;

    @PostMapping("/add")
    public ResponseEntity<UserTypeDTO> addOrUpdateUserType(@RequestBody UserTypeDTO userTypeDTO) {
        return ResponseEntity.ok(userTypeService.addOrUpdateUserType(userTypeDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserTypeDTO> getUserTypeById(@PathVariable Long id) {
        return ResponseEntity.ok(userTypeService.getUserTypeById(id));
    }

    @GetMapping
    public ResponseEntity<List<UserTypeDTO>> getAllUserTypes() {
        return ResponseEntity.ok(userTypeService.getAllUserTypes());
    }
}
