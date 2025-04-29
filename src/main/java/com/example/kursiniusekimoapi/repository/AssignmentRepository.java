package com.example.kursiniusekimoapi.repository;

import com.example.kursiniusekimoapi.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    List<Assignment> findByPavadinimasContainingIgnoreCase(String pavadinimas);
}
