package edu.MDA.onaMagulak.com.util;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
@RequiredArgsConstructor

public class PasswordUtil {

    private final PasswordEncoder passwordEncoder;

    // Encode plain password
    public  String encodePassword(String plainPassword) {
        return passwordEncoder.encode(plainPassword);
    }

    // Verify plain password against encoded hash
    public  boolean matches(String plainPassword, String encodedPassword) {
        return passwordEncoder.matches(plainPassword, encodedPassword);
    }

}
