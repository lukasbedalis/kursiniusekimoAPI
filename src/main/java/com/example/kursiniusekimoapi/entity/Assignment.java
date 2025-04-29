package com.example.kursiniusekimoapi.entity;

import jakarta.persistence.*;

@Entity
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pavadinimas;
    private String busena;
    private Integer pazymys;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPavadinimas() { return pavadinimas; }
    public void setPavadinimas(String pavadinimas) { this.pavadinimas = pavadinimas; }

    public String getBusena() { return busena; }
    public void setBusena(String busena) { this.busena = busena; }

    public Integer getPazymys() { return pazymys; }
    public void setPazymys(Integer pazymys) { this.pazymys = pazymys; }

    public Module getModule() { return module; }
    public void setModule(Module module) { this.module = module; }
}