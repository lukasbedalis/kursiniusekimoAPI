package com.example.kursiniusekimoapi.service;

import com.example.kursiniusekimoapi.converter.StudentConverter;
import com.example.kursiniusekimoapi.dto.StudentDTO;
import com.example.kursiniusekimoapi.entity.Student;
import com.example.kursiniusekimoapi.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentConverter studentConverter;

    public StudentService(StudentRepository studentRepository, StudentConverter studentConverter) {
        this.studentRepository = studentRepository;
        this.studentConverter = studentConverter;
    }

    public List<StudentDTO> getAllStudents(String vardasFilter) {
        List<Student> students = (vardasFilter == null || vardasFilter.isBlank())
                ? studentRepository.findAll()
                : studentRepository.findByVardasContainingIgnoreCase(vardasFilter);

        return students.stream()
                .map(studentConverter::toDTO)
                .collect(Collectors.toList());
    }

    public StudentDTO getStudentById(Long id) {
        return studentRepository.findById(id)
                .map(studentConverter::toDTO)
                .orElse(null);
    }

    public StudentDTO createStudent(StudentDTO dto) {
        Student student = studentConverter.toEntity(dto);
        return studentConverter.toDTO(studentRepository.save(student));
    }

    public StudentDTO updateStudent(Long id, StudentDTO dto) {
        Optional<Student> existing = studentRepository.findById(id);
        if (existing.isEmpty()) return null;

        Student student = existing.get();
        student.setVardas(dto.getVardas());
        student.setPavarde(dto.getPavarde());
        student.setEmail(dto.getEmail());

        return studentConverter.toDTO(studentRepository.save(student));
    }

    public boolean deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) return false;
        studentRepository.deleteById(id);
        return true;
    }
}