package com.example.kursiniusekimoapi.controller;

import com.example.kursiniusekimoapi.dto.ModuleDTO;
import com.example.kursiniusekimoapi.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/modules")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    // GET /modules?pavadinimas=Math
    @GetMapping
    public List<ModuleDTO> getAllModules(@RequestParam(required = false) String pavadinimas) {
        return moduleService.getAllModules(pavadinimas);
    }

    // GET /modules/{id}
    @GetMapping("/{id}")
    public ModuleDTO getModuleById(@PathVariable Long id) {
        ModuleDTO dto = moduleService.getModuleById(id);
        if (dto == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Modulis nerastas");
        }
        return dto;
    }

    // POST /modules
    @PostMapping
    public ModuleDTO createModule(@RequestBody ModuleDTO dto) {
        ModuleDTO created = moduleService.createModule(dto);
        if (created == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Neteisingas studento ID");
        }
        return created;
    }

    // PUT /modules/{id}
    @PutMapping("/{id}")
    public ModuleDTO updateModule(@PathVariable Long id, @RequestBody ModuleDTO dto) {
        ModuleDTO updated = moduleService.updateModule(id, dto);
        if (updated == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Modulis arba studentas nerastas");
        }
        return updated;
    }

    // DELETE /modules/{id}
    @DeleteMapping("/{id}")
    public void deleteModule(@PathVariable Long id) {
        boolean deleted = moduleService.deleteModule(id);
        if (!deleted) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nepavyko ištrinti – modulis nerastas");
        }
    }
}
