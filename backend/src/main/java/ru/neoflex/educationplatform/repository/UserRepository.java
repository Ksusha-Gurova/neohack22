package ru.neoflex.educationplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.neoflex.educationplatform.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}