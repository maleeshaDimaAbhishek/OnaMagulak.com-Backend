package edu.MDA.onaMagulak.com.repository;

import edu.MDA.onaMagulak.com.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
}
