package edu.MDA.onaMagulak.com.service.serviceImpl;

import edu.MDA.onaMagulak.com.dto.request.UserCreationDTO;
import edu.MDA.onaMagulak.com.dto.response.UserResponseDTO;
import edu.MDA.onaMagulak.com.entity.UserEntity;
import edu.MDA.onaMagulak.com.exception.ResourceNotFoundException;
import edu.MDA.onaMagulak.com.repository.UserRepository;
import edu.MDA.onaMagulak.com.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    @Override
    public List<UserResponseDTO> getAllUser() {
        return userRepository.findAll().stream()
                .map(user-> modelMapper.map(user,UserResponseDTO.class))
                .toList();
    }

    @Override
    public UserResponseDTO saveUser(UserCreationDTO userCreationDTO) {
        String encodedPwd=passwordEncoder.encode(userCreationDTO.getPassword());
        userCreationDTO.setPassword(encodedPwd);
        UserEntity save = userRepository.save(modelMapper.map(userCreationDTO, UserEntity.class));
        userRepository.deleteById(save.getId());
        return modelMapper.map(save,UserResponseDTO.class);
    }

    @Override
    public void deleteById(String id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(()->new
                        ResourceNotFoundException("User not found with id: "+id));
        userRepository.deleteById(id);
    }

}
