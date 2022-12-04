package tn.esprit.springproject.services;


import tn.esprit.springproject.entities.Enseignant;
import tn.esprit.springproject.entities.Fonction;

import java.util.Date;
import java.util.List;

public interface EnseignantService {
    List<Enseignant> retrieveAllEnseignants();

    Enseignant addEnseignant(Enseignant e);

    void deleteEnseignant(int id);

    Enseignant updateEnseignant(Enseignant e);

    Enseignant retrieveEnseignant(int id);

    //**************** YOSRA**************************
    void assignEnseignantToDepartement(int enseignantId, int departementId);

    List<Enseignant> getEnseignantsByFonctionAndDepartement_IdDepart(Fonction fonction, int idDepart);

    List<Enseignant> getEnseignantWithMaxSalaireByDeptAndFonction(Fonction fonction, int idDepart);

    Integer nombreEnseignantsByDepartement(int idDepart);

    List<Enseignant> findEnseignantsByDateRecrutementBetweenAndDepartement_IdDepart(Date startDate, Date finDate, int idDepart);
//************************************************************************

}
