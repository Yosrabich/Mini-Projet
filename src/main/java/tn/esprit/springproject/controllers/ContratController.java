package tn.esprit.springproject.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.Contrat;
import tn.esprit.springproject.services.ContratService;

import java.util.Date;
import java.util.List;

@Tag(name = "ContratController")
@AllArgsConstructor
@RestController
@RequestMapping("Contrat")
public class ContratController {
    ContratService contratService;

    @Operation(description = "AjouterContrat")
    @PostMapping("/AjouterContrat")
    Contrat ajouterContrat(@RequestBody Contrat c) {
        return contratService.addContrat(c);
    }

    @Operation(description = "ModifierContrat")
    @PutMapping("/ModifierContrat")
    Contrat updateContrat(@RequestBody Contrat c) {
        return contratService.updateContrat(c);

    }

    @Operation(description = "AfficherAllContrats")
    @GetMapping("/AfficherAllContrats")
    List<Contrat> retrieveAllContrat() {
        return contratService.retrieveAllContrats();
    }

    @Operation(description = "AfficherContrat")
    @GetMapping("/AfficherContrat/{id}")
    Contrat getContratById(@PathVariable int id) {
        return contratService.retrieveContrat(id);
    }

    @Operation(description = "DeleteContrat")
    @DeleteMapping("/DeleteContrat/{id}")
    void deleteContrat(@PathVariable int id) {
        contratService.deleteContrat(id);
    }

    @Operation(description = "affectContratToEtudiant")
    @PutMapping("/affectContratToEtudiant/{nom}/{prenom}")
    public Contrat affectContratToEtudiant(@RequestBody Contrat ce, @PathVariable String nom, @PathVariable String prenom) {
        return contratService.affectContratToEtudiant(ce, nom, prenom);
    }

    @Operation(description = "nbContratsValides")
    @GetMapping("/getNbContrat/{startDate}/{endDate}")
    Integer nbContratsValides(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
        return contratService.nbContratsValides(startDate, endDate);
    }

    @Operation(description = "getChiffreAffaireEntreDeuxDate")
    @GetMapping("/getChiffreAffaire/{startDate}/{endDate}")
    public float getChiffreAffaireEntreDeuxDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
        return contratService.getChiffreAffaireEntreDeuxDate(startDate, endDate);
    }
}
