package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.esprit.springproject.entities.Departement;


import java.util.List;

public interface DepartementRepository extends JpaRepository<Departement,Integer> {


    Departement searchDepartementByNomDepart(String nomDepart);
    @Query("select d from Departement d order by d.nomDepart ASC ")
    List<Departement> getAllOrderByNomDepartAsc();

}
