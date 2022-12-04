package tn.esprit.springproject.services;


import tn.esprit.springproject.entities.Etudiant;
import tn.esprit.springproject.entities.Option;

import java.util.List;


public interface EtudiantService {
    List<Etudiant> retrieveAllEtudiants();

    Etudiant addEtudiant(Etudiant e);

    void deleteEtudiant(int id);

    Etudiant updateEtudiant(Etudiant e);

    Etudiant retrieveEtudiant(int id);

    void assignEtudiantToDepartement(int etudiantId, int departementId);

    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, int idContrat, int
            idEquipe);

    Etudiant findByNomAndPrenom(String nom, String prenom);

    List<Etudiant> getEtudiantsByDepartement(int idDepart);

    Integer nombreEtudiantsByDepartement(int idDepart);

    Integer nombreEtudiantsByOption(Option option);



    List<Etudiant> EtudiantsByOption(Option option);
}
