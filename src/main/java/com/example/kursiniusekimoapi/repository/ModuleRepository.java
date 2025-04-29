package com.example.kursiniusekimoapi.repository;

import com.example.kursiniusekimoapi.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {
    List<Module> findByPavadinimasContainingIgnoreCase(String pavadinimas);
}
