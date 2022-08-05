package ru.neoflex.educationplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.neoflex.educationplatform.model.Cours;

public interface CoursRepository extends JpaRepository<Cours, Long> {
}