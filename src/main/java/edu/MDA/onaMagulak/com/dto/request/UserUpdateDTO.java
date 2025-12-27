package edu.MDA.onaMagulak.com.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDTO {

    @NotBlank(message = "Name can't be empty")
    private String name;
    @Email(message = "Invalid Mail Format")
    @NotBlank(message = "email can't be empty")
    private String email;
    @NotBlank(message = "phone can't be empty")
    private String phone;
}
