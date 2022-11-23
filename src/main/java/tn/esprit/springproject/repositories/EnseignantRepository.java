package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.springproject.entities.Departement;
import tn.esprit.springproject.entities.Enseignant;
import tn.esprit.springproject.entities.Fonction;

public interface EnseignantRepository  extends JpaRepository<Enseignant,Integer> {
    Enseignant getEnseignantByFonctionAndDepartement_IdDepart(Fonction fonction,int idDepart);
}
