package ru.neoflex.educationplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.neoflex.educationplatform.model.UserLessonLink;

public interface UserLessonLinkRepository extends JpaRepository<UserLessonLink, Long> {
}