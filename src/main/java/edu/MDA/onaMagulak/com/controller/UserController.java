package edu.MDA.onaMagulak.com.controller;

import edu.MDA.onaMagulak.com.dto.request.UserCreationDTO;
import edu.MDA.onaMagulak.com.dto.request.UserUpdateDTO;
import edu.MDA.onaMagulak.com.dto.response.UserResponseDTO;
import edu.MDA.onaMagulak.com.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/getAll")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUser());
    }
    @PostMapping("/add")
    public ResponseEntity<UserResponseDTO> saveUser(@RequestBody UserCreationDTO userCreationDTO){
        return ResponseEntity.ok(userService.saveUser(userCreationDTO));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void>deleteById(@PathVariable String id){
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(
            @PathVariable String id,
            @Valid @RequestBody UserUpdateDTO userUpdateDTO){
        UserResponseDTO userResponseDTO=userService.updateByUserId(userUpdateDTO,id);
        return ResponseEntity.ok(userResponseDTO);
    }
}
