package tn.esprit.springproject.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.Module;
import tn.esprit.springproject.services.ModuleService;

import java.util.List;

@Tag(name = "ModuleController")
@AllArgsConstructor
@RestController
@RequestMapping("Module")
public class ModuleController {
    ModuleService moduleService;

    @Operation(description = "AjouterEtudiant")
    @PostMapping("/AjouterModule")
    Module ajouterModule(@RequestBody Module mod) {
        return moduleService.addModule(mod);
    }

    @Operation(description = "ModifierModule")
    @PutMapping("/ModifierModule")
    Module updateModule(@RequestBody Module mod) {
        return moduleService.updateModule(mod);

    }

    @Operation(description = "AfficherAllModules")
    @GetMapping("/AfficherAllModules")
    List<Module> retrieveAllModules() {
        return moduleService.retrieveAllModules();
    }

    @Operation(description = "AfficherModule")
    @GetMapping("/AfficherModuleById/{id}")
    Module getModuleById(@PathVariable int id) {
        return moduleService.retrieveModule(id);
    }

    @Operation(description = "DeleteModule")
    @DeleteMapping("/DeleteModule/{id}")
    void deleteModule(@PathVariable int id) {
        moduleService.deleteModule(id);
    }
}
