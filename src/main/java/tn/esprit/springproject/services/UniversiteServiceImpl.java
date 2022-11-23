package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Departement;
import tn.esprit.springproject.entities.Universite;
import tn.esprit.springproject.repositories.DepartementRepository;
import tn.esprit.springproject.repositories.UniversiteRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class UniversiteServiceImpl implements UniversiteService{
    UniversiteRepository universiteRepository;
    DepartementRepository departementRepository;
    @Override
    public List<Universite> retrieveAllUniversities() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public void deleteUniversite(int id) {
universiteRepository.deleteById(id);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversite(int id) {
        return universiteRepository.findById(id).orElse(null);
    }
    public void assignUniversiteToDepartement(int idUniversite, int idDepartement){
        Universite universite=universiteRepository.findById(idUniversite).orElse(null);
        Departement departement=departementRepository.findById(idDepartement).orElse(null);
        universite.getDepartements().add(departement);
        universiteRepository.save(universite);

    }
}


