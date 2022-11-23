package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Departement;
import tn.esprit.springproject.entities.Enseignant;
import tn.esprit.springproject.entities.Etudiant;
import tn.esprit.springproject.entities.Fonction;
import tn.esprit.springproject.repositories.DepartementRepository;
import tn.esprit.springproject.repositories.EnseignantRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class EnseignantServiceImpl implements EnseignantService{
    DepartementRepository departementRepository;
    EnseignantRepository enseignantRepository;
    @Override
    public List<Enseignant> retrieveAllEnseignants() {
        return enseignantRepository.findAll();
    }

    @Override
    public Enseignant addEnseignant(Enseignant e) {
        return enseignantRepository.save(e);
    }

    @Override
    public void deleteEnseignant(int id) {
        enseignantRepository.deleteById(id);

    }

    @Override
    public Enseignant updateEnseignant(Enseignant e) {
        return enseignantRepository.save(e);
    }

    @Override
    public Enseignant retrieveEnseignant(int id) {
        return enseignantRepository.findById(id).orElse(null);
    }

    public void assignEnseignantToDepartement(int enseignantId, int departementId) {
       Enseignant enseignant=retrieveEnseignant(enseignantId);
        Departement departement=departementRepository.findById(departementId).orElse(null);
        enseignant.setDepartement(departement);
        enseignantRepository.save(enseignant);
    }

    @Override
    public Enseignant getEnseignantByFonctionAndDepartement_IdDepart(Fonction fonction,int idDepart) {
        return enseignantRepository.getEnseignantByFonctionAndDepartement_IdDepart(fonction, idDepart);
    }
}
