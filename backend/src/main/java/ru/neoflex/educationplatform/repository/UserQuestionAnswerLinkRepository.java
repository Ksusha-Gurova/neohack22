package ru.neoflex.educationplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.neoflex.educationplatform.model.UserTaskAnswerLink;

public interface UserQuestionAnswerLinkRepository extends JpaRepository<UserTaskAnswerLink, Long> {
}