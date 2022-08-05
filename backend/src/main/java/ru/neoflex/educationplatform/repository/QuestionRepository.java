package ru.neoflex.educationplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.neoflex.educationplatform.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}