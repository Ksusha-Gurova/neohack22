package ru.neoflex.educationplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.neoflex.educationplatform.model.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}