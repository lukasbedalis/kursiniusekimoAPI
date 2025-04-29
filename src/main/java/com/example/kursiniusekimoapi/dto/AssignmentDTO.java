package com.example.kursiniusekimoapi.dto;

public class AssignmentDTO {
    private Long id;
    private String pavadinimas;
    private String busena;
    private Integer pazymys;
    private Long moduleId;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPavadinimas() { return pavadinimas; }
    public void setPavadinimas(String pavadinimas) { this.pavadinimas = pavadinimas; }

    public String getBusena() { return busena; }
    public void setBusena(String busena) { this.busena = busena; }

    public Integer getPazymys() { return pazymys; }
    public void setPazymys(Integer pazymys) { this.pazymys = pazymys; }

    public Long getModuleId() { return moduleId; }
    public void setModuleId(Long moduleId) { this.moduleId = moduleId; }
}