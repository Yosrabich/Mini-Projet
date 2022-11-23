package tn.esprit.springproject.services;

import tn.esprit.springproject.entities.Departement;
import tn.esprit.springproject.entities.Enseignant;
import tn.esprit.springproject.entities.Fonction;

import java.util.List;

public interface EnseignantService {
    List<Enseignant> retrieveAllEnseignants();
    Enseignant addEnseignant(Enseignant e);
    void deleteEnseignant(int id);
    Enseignant updateEnseignant(Enseignant e);
    Enseignant retrieveEnseignant(int id);
    void assignEnseignantToDepartement(int enseignantId, int departementId);
    Enseignant getEnseignantByFonctionAndDepartement_IdDepart(Fonction fonction,int idDepart);
}
