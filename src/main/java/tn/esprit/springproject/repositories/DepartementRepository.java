package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.esprit.springproject.entities.Departement;
import tn.esprit.springproject.entities.Etudiant;


import java.util.List;

public interface DepartementRepository extends JpaRepository<Departement,Integer> {


    List<Departement> getDepartementsByNomDepartContains(String nom);
    Departement searchDepartementByNomDepart(String nom);
    @Query("select d from Departement d order by d.nomDepart ASC ")
    List<Departement> getAllOrderByNomDepartAsc();
    @Query("select avg (e.salaire) from Enseignant e group by e.departement.idDepart having e.departement.idDepart=?1")
    double salaireMoyenParDepartement(int idDepart);



}


