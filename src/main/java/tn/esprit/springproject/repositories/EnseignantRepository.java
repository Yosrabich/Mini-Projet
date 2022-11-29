package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.springproject.entities.Departement;
import tn.esprit.springproject.entities.Enseignant;
import tn.esprit.springproject.entities.Fonction;

import java.util.List;

public interface EnseignantRepository  extends JpaRepository<Enseignant,Integer> {
    List<Enseignant> getEnseignantsByFonctionAndDepartement_IdDepart(Fonction fonction,int idDepart);
    @Query(value = "select count (e.idEns) from Enseignant e group by e.departement.idDepart having e.departement.idDepart=?1")
    Integer nombreEnseignantsByDepartement(int idDepart);
}
