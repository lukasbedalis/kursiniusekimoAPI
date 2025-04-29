package com.example.kursiniusekimoapi.repository;

import com.example.kursiniusekimoapi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByVardasContainingIgnoreCase(String vardas);
}
