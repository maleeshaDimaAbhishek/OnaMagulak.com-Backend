package edu.MDA.onaMagulak.com.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {
    private String id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String password;
    private Date creationDate;
    private Date updateDate;
    private String role;
}
