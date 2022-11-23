package tn.esprit.springproject.services;


import tn.esprit.springproject.entities.Departement;

import java.util.List;
import java.util.Set;

public interface DepartementService {
    List<Departement> retrieveAllDepartements();
    Departement addDepartement(Departement d);
    void deleteDepartement(int id);
    Departement updateDepartement(Departement d);
    Departement retrieveDepartement(int id);
     Set<Departement> retrieveDepartementsByUniversite(int idUniversite);
    Departement searchDepartementByNomDepart(String nomDepart);
    List<Departement> getAllOrderByNomDepartAsc();
}
