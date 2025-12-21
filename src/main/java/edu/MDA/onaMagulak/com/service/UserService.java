package edu.MDA.onaMagulak.com.service;

import edu.MDA.onaMagulak.com.dto.response.UserResponseDTO;

import java.util.List;

public interface UserService {
    List<UserResponseDTO> getAllUser();
}
