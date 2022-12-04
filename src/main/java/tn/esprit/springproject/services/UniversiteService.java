package tn.esprit.springproject.services;


import tn.esprit.springproject.entities.Universite;

import java.util.List;

public interface UniversiteService {
    List<Universite> retrieveAllUniversities();

    Universite addUniversite(Universite u);

    void deleteUniversite(int id);

    Universite updateUniversite(Universite u);

    Universite retrieveUniversite(int id);

    void assignUniversiteToDepartement(int idUniversite, int idDepartement);

}
