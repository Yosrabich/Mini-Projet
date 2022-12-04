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
    

    /*Enseignant getEneignantByFonctionAndModule_IdModule(Fonction fonction,int idModule);*/
    Enseignant chercherEnseignantBynom(String nomEns);
    List<Enseignant> getEnseignantByModules_idModule(int idModule);
    List<Enseignant> getEnseignantByFonctionAndModules_idModule(Fonction fonction,int idModule);
    //chercher la liste des enseignants qui ont un salire < à un salaire donnée
    List<Enseignant> chercherEnseignantBySalaire(double salaire);
   
}
