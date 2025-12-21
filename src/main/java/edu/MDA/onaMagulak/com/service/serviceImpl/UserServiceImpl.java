package edu.MDA.onaMagulak.com.service.serviceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.MDA.onaMagulak.com.config.ModelMapperConfig;
import edu.MDA.onaMagulak.com.dto.response.UserResponseDTO;
import edu.MDA.onaMagulak.com.entity.UserEntity;
import edu.MDA.onaMagulak.com.repository.UserRepository;
import edu.MDA.onaMagulak.com.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<UserResponseDTO> getAllUser() {
        return userRepository.findAll().stream()
                .map(user-> modelMapper.map(user,UserResponseDTO.class))
                .toList();
    }

}
