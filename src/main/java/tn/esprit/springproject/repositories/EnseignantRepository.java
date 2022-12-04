package tn.esprit.springproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.springproject.entities.Departement;
import tn.esprit.springproject.entities.Enseignant;
import tn.esprit.springproject.entities.Fonction;

public interface EnseignantRepository  extends JpaRepository<Enseignant,Integer> {
    Enseignant getEnseignantByFonctionAndDepartement_IdDepart(Fonction fonction,int idDepart);

   /* Enseignant getEneignantByFonctionAndModule_IdModule(Fonction fonction,int idModule);*/
    Enseignant findEnseignantBynomEns(String nomEns);
    List<Enseignant> findEnseignantByModules_idModule(int idModule);
    List<Enseignant> findEnseignantByFonctionAndModules_idModule(Fonction fonction,int idModule);
}
