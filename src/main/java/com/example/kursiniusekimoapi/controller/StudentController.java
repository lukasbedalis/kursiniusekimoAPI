package com.example.kursiniusekimoapi.controller;

import com.example.kursiniusekimoapi.dto.StudentDTO;
import com.example.kursiniusekimoapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // GET /students?vardas=Jonas
    @GetMapping
    public List<StudentDTO> getAllStudents(@RequestParam(required = false) String vardas) {
        return studentService.getAllStudents(vardas);
    }

    // GET /students/{id}
    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id) {
        StudentDTO student = studentService.getStudentById(id);
        if (student == null) {
            return ResponseEntity.notFound().build(); // <-- svarbi dalis
        }
        return ResponseEntity.ok(student);
    }

    // POST /students
    @PostMapping
    public StudentDTO createStudent(@RequestBody StudentDTO dto) {
        return studentService.createStudent(dto);
    }

    // PUT /students/{id}
    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long id, @RequestBody StudentDTO dto) {
        StudentDTO updated = studentService.updateStudent(id, dto);
        if (updated == null) {
            return ResponseEntity.notFound().build(); // taip pat apdorojame neradimo atvejį
        }
        return ResponseEntity.ok(updated);
    }

    // DELETE /students/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        boolean deleted = studentService.deleteStudent(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
