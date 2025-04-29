package com.example.kursiniusekimoapi.dto;

public class ModuleDTO {
    private Long id;
    private String pavadinimas;
    private String aprasymas;
    private Long studentId;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPavadinimas() { return pavadinimas; }
    public void setPavadinimas(String pavadinimas) { this.pavadinimas = pavadinimas; }

    public String getAprasymas() { return aprasymas; }
    public void setAprasymas(String aprasymas) { this.aprasymas = aprasymas; }

    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }
}