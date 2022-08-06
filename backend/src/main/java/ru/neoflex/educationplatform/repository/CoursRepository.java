package ru.neoflex.educationplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.neoflex.educationplatform.model.Course;

import java.util.List;

public interface CoursRepository extends JpaRepository<Course, Long> {

    List<Course> findAllByIsPrivateAndStatus(Boolean isPrivate, String status);
}