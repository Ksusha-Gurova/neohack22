package ru.neoflex.educationplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.neoflex.educationplatform.model.InterestTag;

public interface InterestTagRepository extends JpaRepository<InterestTag, Long> {
}