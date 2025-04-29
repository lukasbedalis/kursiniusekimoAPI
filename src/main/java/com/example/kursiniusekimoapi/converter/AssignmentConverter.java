package com.example.kursiniusekimoapi.converter;

import com.example.kursiniusekimoapi.dto.AssignmentDTO;
import com.example.kursiniusekimoapi.entity.Assignment;
import com.example.kursiniusekimoapi.entity.Module;
import org.springframework.stereotype.Component;

@Component
public class AssignmentConverter {

    public AssignmentDTO toDTO(Assignment assignment) {
        AssignmentDTO dto = new AssignmentDTO();
        dto.setId(assignment.getId());
        dto.setPavadinimas(assignment.getPavadinimas());
        dto.setBusena(assignment.getBusena());
        dto.setPazymys(assignment.getPazymys());
        if (assignment.getModule() != null) {
            dto.setModuleId(assignment.getModule().getId());
        }
        return dto;
    }

    public Assignment toEntity(AssignmentDTO dto, Module module) {
        Assignment assignment = new Assignment();
        assignment.setId(dto.getId());
        assignment.setPavadinimas(dto.getPavadinimas());
        assignment.setBusena(dto.getBusena());
        assignment.setPazymys(dto.getPazymys());
        assignment.setModule(module);
        return assignment;
    }
}