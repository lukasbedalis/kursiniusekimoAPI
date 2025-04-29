package com.example.kursiniusekimoapi.converter;

import com.example.kursiniusekimoapi.dto.StudentDTO;
import com.example.kursiniusekimoapi.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter {

    public StudentDTO toDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setVardas(student.getVardas());
        dto.setPavarde(student.getPavarde());
        dto.setEmail(student.getEmail());
        return dto;
    }

    public Student toEntity(StudentDTO dto) {
        Student student = new Student();
        //student.setId(dto.getId());
        student.setVardas(dto.getVardas());
        student.setPavarde(dto.getPavarde());
        student.setEmail(dto.getEmail());
        return student;
    }
}