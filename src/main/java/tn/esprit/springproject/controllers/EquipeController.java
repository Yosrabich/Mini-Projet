package tn.esprit.springproject.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.Equipe;
import tn.esprit.springproject.entities.Etudiant;
import tn.esprit.springproject.services.EquipeService;
import tn.esprit.springproject.services.EtudiantService;

import java.util.List;

@Tag(name = "EquipeController")
@AllArgsConstructor
@RestController
@RequestMapping("Equipe")
public class EquipeController {
    EquipeService equipeService;

    @Operation(description = "AjouterEquipe")
    @PostMapping("/AjouterEquipe")
    Equipe ajouterEquipe(@RequestBody Equipe equipe) {
        return equipeService.addEquipe(equipe);
    }

    @Operation(description = "ModifierEquipe")
    @PutMapping("/ModifierEquipe")
    Equipe updateEquipe(@RequestBody Equipe equipe) {
        return equipeService.updateEquipe(equipe);

    }

    @Operation(description = "AfficherAllEquipes")
    @GetMapping("/AfficherAllEquipes")
    List<Equipe> retrieveAllEquipes() {
        return equipeService.retrieveAllEquipes();
    }

    @Operation(description = "AfficherEquipe")
    @GetMapping("/AfficherEquipe/{id}")
    Equipe getEquipeById(@PathVariable int id) {
        return equipeService.retrieveEquipe(id);
    }

    @Operation(description = "DeleteEquipe")
    @DeleteMapping("/DeleteEquipe/{id}")
    void deleteEquipe(@PathVariable int id) {
        equipeService.deleteEquipe(id);
    }

    @Operation(description = "affectEquipeToEncadrant")
    @PutMapping("affectEquipeToEncadrant/{idEquipe}/{idEncadrant}")
    public Equipe affectEquipeToEncadrant(@PathVariable int idEquipe, @PathVariable int idEncadrant) {
        return equipeService.affectEquipeToEncadrant(idEquipe, idEncadrant);
    }
}
