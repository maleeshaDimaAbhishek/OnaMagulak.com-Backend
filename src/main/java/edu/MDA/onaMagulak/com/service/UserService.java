package edu.MDA.onaMagulak.com.service;

import edu.MDA.onaMagulak.com.dto.request.UserCreationDTO;
import edu.MDA.onaMagulak.com.dto.response.UserResponseDTO;

import java.util.List;

public interface UserService {
    List<UserResponseDTO> getAllUser();

    UserResponseDTO saveUser(UserCreationDTO userCreationDTO);

    void deleteById(String id);
}
