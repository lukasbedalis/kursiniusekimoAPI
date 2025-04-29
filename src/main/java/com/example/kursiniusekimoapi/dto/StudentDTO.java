package com.example.kursiniusekimoapi.dto;

public class StudentDTO {
    private Long id;
    private String vardas;
    private String pavarde;
    private String email;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getVardas() { return vardas; }
    public void setVardas(String vardas) { this.vardas = vardas; }

    public String getPavarde() { return pavarde; }
    public void setPavarde(String pavarde) { this.pavarde = pavarde; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}