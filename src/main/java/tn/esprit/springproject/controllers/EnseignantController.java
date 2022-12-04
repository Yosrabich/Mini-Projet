package tn.esprit.springproject.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.Enseignant;
import tn.esprit.springproject.entities.Fonction;
import tn.esprit.springproject.services.EnseignantService;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*")
@Tag(name = "EnseignantController")
@RestController
@AllArgsConstructor
@RequestMapping("Enseignant")
public class EnseignantController {
    EnseignantService enseignantService;

    @Operation(description = "AjouterEnseignant")
    @PostMapping("/Ajouter")
    Enseignant ajouterEnseignant(@RequestBody Enseignant enseignant) {
        return enseignantService.addEnseignant(enseignant);
    }

    @Operation(description = "ModifierEnseignant")
    @PutMapping("/Modifier")
    Enseignant updateEnseignant(@RequestBody Enseignant enseignant) {
        return enseignantService.updateEnseignant(enseignant);

    }

    @Operation(description = "AfficherAllEnseignant")
    @GetMapping("/AfficherAll")
    List<Enseignant> retrieveAllEnseignant() {
        return enseignantService.retrieveAllEnseignants();
    }

    @Operation(description = "AfficherEnseignant")
    @GetMapping("/Afficher/{id}")
    Enseignant getEnseignantById(@PathVariable int id) {
        return enseignantService.retrieveEnseignant(id);
    }

    @Operation(description = "DeleteEnseignant")
    @DeleteMapping("/Delete")
    void deleteDetailEquipe(@PathVariable int id) {
        enseignantService.deleteEnseignant(id);
    }

    @Operation(description = "assignEnseignantToDepartement")
    @PutMapping("/assignEnseignantToDepartement/{enseignantId}/{departementId}")
    void assignEnseignantToDepartement(@PathVariable int enseignantId, @PathVariable int departementId) {
        enseignantService.assignEnseignantToDepartement(enseignantId, departementId);
    }

    @Operation(description = "getEnseignantByFonction_ChefDepartementAndDepartement_IdDepart")
    @GetMapping("/getEnseignant/{fonction}/{idDepart}")
    List<Enseignant> getEnseignantsByFonctionAndDepartement_IdDepart(@PathVariable Fonction fonction, @PathVariable int idDepart) {
        return enseignantService.getEnseignantsByFonctionAndDepartement_IdDepart(fonction, idDepart);


    }

    @Operation(description = "getEnseignantWithMaxSalaireByDeptAndFonction")
    @GetMapping("/getEnseignantWithMaxSalaireByDeptAndFonction/{fonction}/{idDepart}")
    List<Enseignant> getEnseignantWithMaxSalaireByDeptAndFonction(@PathVariable Fonction fonction, @PathVariable int idDepart) {
        return enseignantService.getEnseignantWithMaxSalaireByDeptAndFonction(fonction, idDepart);
    }

    @Operation(description = "nombreEnseignantsByDepartement")
    @GetMapping("/nombreEnseignantsByDepartement/{idDepart}")
    Integer nombreEnseignantsByDepartement(@PathVariable int idDepart) {
        return enseignantService.nombreEnseignantsByDepartement(idDepart);
    }

    @Operation(description = "findEnseignantsByDateRecrutementBetweenAndIdDepart")
    @GetMapping("/findEnseignantsByDateRecrutementBetweenAndIdDepart/{startDate}/{endDate}/{idDepart}")
    List<Enseignant> findEnseignantsByDateRecrutementBetweenAndDepartement_IdDepart(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate, @PathVariable int idDepart) {
        return enseignantService.findEnseignantsByDateRecrutementBetweenAndDepartement_IdDepart(startDate, endDate, idDepart);
    }


}