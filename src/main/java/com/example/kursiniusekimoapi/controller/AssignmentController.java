package com.example.kursiniusekimoapi.controller;

import com.example.kursiniusekimoapi.dto.AssignmentDTO;
import com.example.kursiniusekimoapi.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    // GET /assignments?pavadinimas=Lab
    @GetMapping
    public List<AssignmentDTO> getAll(@RequestParam(required = false) String pavadinimas) {
        return assignmentService.getAllAssignments(pavadinimas);
    }

    // GET /assignments/{id}
    @GetMapping("/{id}")
    public AssignmentDTO getById(@PathVariable Long id) {
        AssignmentDTO dto = assignmentService.getAssignmentById(id);
        if (dto == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Atsiskaitymas nerastas");
        }
        return dto;
    }

    // POST /assignments
    @PostMapping
    public AssignmentDTO create(@RequestBody AssignmentDTO dto) {
        AssignmentDTO created = assignmentService.createAssignment(dto);
        if (created == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Modulio ID neteisingas");
        }
        return created;
    }

    // PUT /assignments/{id}
    @PutMapping("/{id}")
    public AssignmentDTO update(@PathVariable Long id, @RequestBody AssignmentDTO dto) {
        AssignmentDTO updated = assignmentService.updateAssignment(id, dto);
        if (updated == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Atsiskaitymas arba modulis nerastas");
        }
        return updated;
    }

    // DELETE /assignments/{id}
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        boolean deleted = assignmentService.deleteAssignment(id);
        if (!deleted) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nepavyko ištrinti – atsiskaitymas nerastas");
        }
    }
}
