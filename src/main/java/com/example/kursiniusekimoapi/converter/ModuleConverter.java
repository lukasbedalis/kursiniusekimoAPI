package com.example.kursiniusekimoapi.converter;

import com.example.kursiniusekimoapi.dto.ModuleDTO;
import com.example.kursiniusekimoapi.entity.Module;
import com.example.kursiniusekimoapi.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class ModuleConverter {

    public ModuleDTO toDTO(Module module) {
        ModuleDTO dto = new ModuleDTO();
        dto.setId(module.getId());
        dto.setPavadinimas(module.getPavadinimas());
        dto.setAprasymas(module.getAprasymas());
        if (module.getStudent() != null) {
            dto.setStudentId(module.getStudent().getId());
        }
        return dto;
    }

    public Module toEntity(ModuleDTO dto, Student student) {
        Module module = new Module();
        module.setId(dto.getId());
        module.setPavadinimas(dto.getPavadinimas());
        module.setAprasymas(dto.getAprasymas());
        module.setStudent(student);
        return module;
    }
}