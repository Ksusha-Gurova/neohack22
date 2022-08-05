package ru.neoflex.educationplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.neoflex.educationplatform.model.UserTaskLink;

public interface UserTaskLinkRepository extends JpaRepository<UserTaskLink, Long> {
}