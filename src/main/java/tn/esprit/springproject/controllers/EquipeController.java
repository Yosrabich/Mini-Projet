package tn.esprit.springproject.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.DetailEquipe;
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
        return equipeService.retrieveAllEquipe();
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

    @GetMapping("/countEtudiantByEquipe/{id}")
    int countEtudiantByEquipe(@PathVariable int id) {
        return equipeService.countEtudiantByEquipe(id);
    }

    @GetMapping("/compareEquipes/{id1id2}")
    public Boolean compareEquipes(@PathVariable Integer id1, Integer id2) {
        return equipeService.compareEquipes(id1, id2);
    }

    @PutMapping("/affecterDetailsEquipeToEquipe/{idEquipe}")
    public void assignDetailsEquipeToEquipe(@PathVariable Integer idEquipe, @RequestBody DetailEquipe detailsEquipe) {
        equipeService.assignDetailsEquipeToEquipe(idEquipe, detailsEquipe);
    }

    @GetMapping("/retrieveEquipesDeLetudiant/{id}")
    public List<Equipe> retrieveEquipesDeLetudiant(@PathVariable Integer id) {
        return equipeService.retrieveEquipesDeLetudiant(id);
    }

}
