package edu.MDA.onaMagulak.com.service;

import edu.MDA.onaMagulak.com.dto.request.UserCreationDTO;
import edu.MDA.onaMagulak.com.dto.request.UserUpdateDTO;
import edu.MDA.onaMagulak.com.dto.response.UserResponseDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface UserService {
    List<UserResponseDTO> getAllUser();

    UserResponseDTO saveUser(UserCreationDTO userCreationDTO);

    void deleteById(String useName);

    UserResponseDTO updateByUserId(@Valid UserUpdateDTO userUpdateDTO, String id);
}
