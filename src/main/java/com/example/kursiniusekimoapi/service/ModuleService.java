package com.example.kursiniusekimoapi.service;

import com.example.kursiniusekimoapi.converter.ModuleConverter;
import com.example.kursiniusekimoapi.dto.ModuleDTO;
import com.example.kursiniusekimoapi.entity.Module;
import com.example.kursiniusekimoapi.entity.Student;
import com.example.kursiniusekimoapi.repository.ModuleRepository;
import com.example.kursiniusekimoapi.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ModuleService {

    private final ModuleRepository moduleRepository;
    private final StudentRepository studentRepository;
    private final ModuleConverter moduleConverter;

    public ModuleService(ModuleRepository moduleRepository, StudentRepository studentRepository, ModuleConverter moduleConverter) {
        this.moduleRepository = moduleRepository;
        this.studentRepository = studentRepository;
        this.moduleConverter = moduleConverter;
    }

    public List<ModuleDTO> getAllModules(String pavadinimasFilter) {
        List<Module> modules = (pavadinimasFilter == null || pavadinimasFilter.isBlank())
                ? moduleRepository.findAll()
                : moduleRepository.findByPavadinimasContainingIgnoreCase(pavadinimasFilter);

        return modules.stream()
                .map(moduleConverter::toDTO)
                .collect(Collectors.toList());
    }

    public ModuleDTO getModuleById(Long id) {
        return moduleRepository.findById(id)
                .map(moduleConverter::toDTO)
                .orElse(null);
    }

    public ModuleDTO createModule(ModuleDTO dto) {
        Optional<Student> studentOpt = studentRepository.findById(dto.getStudentId());
        if (studentOpt.isEmpty()) return null;

        Module module = moduleConverter.toEntity(dto, studentOpt.get());
        return moduleConverter.toDTO(moduleRepository.save(module));
    }

    public ModuleDTO updateModule(Long id, ModuleDTO dto) {
        Optional<Module> moduleOpt = moduleRepository.findById(id);
        Optional<Student> studentOpt = studentRepository.findById(dto.getStudentId());
        if (moduleOpt.isEmpty() || studentOpt.isEmpty()) return null;

        Module module = moduleOpt.get();
        module.setPavadinimas(dto.getPavadinimas());
        module.setAprasymas(dto.getAprasymas());
        module.setStudent(studentOpt.get());

        return moduleConverter.toDTO(moduleRepository.save(module));
    }

    public boolean deleteModule(Long id) {
        if (!moduleRepository.existsById(id)) return false;
        moduleRepository.deleteById(id);
        return true;
    }
}