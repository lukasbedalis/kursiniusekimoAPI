package com.example.kursiniusekimoapi.service;

import com.example.kursiniusekimoapi.converter.AssignmentConverter;
import com.example.kursiniusekimoapi.dto.AssignmentDTO;
import com.example.kursiniusekimoapi.entity.Assignment;
import com.example.kursiniusekimoapi.entity.Module;
import com.example.kursiniusekimoapi.repository.AssignmentRepository;
import com.example.kursiniusekimoapi.repository.ModuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final ModuleRepository moduleRepository;
    private final AssignmentConverter assignmentConverter;

    public AssignmentService(AssignmentRepository assignmentRepository, ModuleRepository moduleRepository, AssignmentConverter assignmentConverter) {
        this.assignmentRepository = assignmentRepository;
        this.moduleRepository = moduleRepository;
        this.assignmentConverter = assignmentConverter;
    }

    public List<AssignmentDTO> getAllAssignments(String filter) {
        List<Assignment> list = (filter == null || filter.isBlank())
                ? assignmentRepository.findAll()
                : assignmentRepository.findByPavadinimasContainingIgnoreCase(filter);

        return list.stream()
                .map(assignmentConverter::toDTO)
                .collect(Collectors.toList());
    }

    public AssignmentDTO getAssignmentById(Long id) {
        return assignmentRepository.findById(id)
                .map(assignmentConverter::toDTO)
                .orElse(null);
    }

    public AssignmentDTO createAssignment(AssignmentDTO dto) {
        Optional<Module> moduleOpt = moduleRepository.findById(dto.getModuleId());
        if (moduleOpt.isEmpty()) return null;

        Assignment assignment = assignmentConverter.toEntity(dto, moduleOpt.get());
        return assignmentConverter.toDTO(assignmentRepository.save(assignment));
    }

    public AssignmentDTO updateAssignment(Long id, AssignmentDTO dto) {
        Optional<Assignment> aOpt = assignmentRepository.findById(id);
        Optional<Module> mOpt = moduleRepository.findById(dto.getModuleId());

        if (aOpt.isEmpty() || mOpt.isEmpty()) return null;

        Assignment a = aOpt.get();
        a.setPavadinimas(dto.getPavadinimas());
        a.setBusena(dto.getBusena());
        a.setPazymys(dto.getPazymys());
        a.setModule(mOpt.get());

        return assignmentConverter.toDTO(assignmentRepository.save(a));
    }

    public boolean deleteAssignment(Long id) {
        if (!assignmentRepository.existsById(id)) return false;
        assignmentRepository.deleteById(id);
        return true;
    }
}