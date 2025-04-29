package com.example.kursiniusekimoapi.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pavadinimas;
    private String aprasymas;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)

    private Student student;

    @OneToMany(mappedBy = "module", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Assignment> assignments;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPavadinimas() { return pavadinimas; }
    public void setPavadinimas(String pavadinimas) { this.pavadinimas = pavadinimas; }

    public String getAprasymas() { return aprasymas; }
    public void setAprasymas(String aprasymas) { this.aprasymas = aprasymas; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    public List<Assignment> getAssignments() { return assignments; }
    public void setAssignments(List<Assignment> assignments) { this.assignments = assignments; }
}