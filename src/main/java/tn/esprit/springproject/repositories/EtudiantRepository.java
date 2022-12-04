package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.springproject.entities.Etudiant;

import java.util.List;


public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {
    //**************** YOSRA**************************
    Etudiant findByNomAndPrenom(String nom, String prenom);

    @Query("select e from Etudiant e where e.departement.idDepart=?1")
    List<Etudiant> getEtudiantsByDepartement(int idDepart);

    @Query(value = "select count (e.idEtudiant) from Etudiant e group by e.departement.idDepart having e.departement.idDepart=?1")
    Integer nombreEtudiantsByDepartement(int idDepart);
//**************************************************************************
}
