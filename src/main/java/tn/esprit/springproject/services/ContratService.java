package tn.esprit.springproject.services;

import tn.esprit.springproject.entities.Contrat;

import java.util.Date;
import java.util.List;

public interface ContratService {
    List<Contrat> retrieveAllContrats();
    Contrat addContrat(Contrat c);
    void deleteContrat(int id);
    Contrat updateContrat(Contrat c);
    Contrat retrieveContrat(int id);
    Contrat affectContratToEtudiant (Contrat ce,String nom,String prenom);
    float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);
    Integer nbContratsValides(Date startDate, Date endDate);
}
