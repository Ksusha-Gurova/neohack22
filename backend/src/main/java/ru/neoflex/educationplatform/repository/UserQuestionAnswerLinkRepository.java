package ru.neoflex.educationplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.neoflex.educationplatform.model.UserQuestionAnswerLink;

public interface UserQuestionAnswerLinkRepository extends JpaRepository<UserQuestionAnswerLink, Long> {
}