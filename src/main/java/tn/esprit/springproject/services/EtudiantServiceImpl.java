package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Contrat;
import tn.esprit.springproject.entities.Departement;
import tn.esprit.springproject.entities.Equipe;
import tn.esprit.springproject.entities.Etudiant;
import tn.esprit.springproject.repositories.DepartementRepository;

import tn.esprit.springproject.repositories.EtudiantRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class EtudiantServiceImpl implements EtudiantService{
    EtudiantRepository etudiantRepository;
    DepartementRepository departementRepository;
    ContratService contratService;
    EquipeService equipeService;
    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public void deleteEtudiant(int id) {
etudiantRepository.deleteById(id);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(int id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    @Override
    public void assignEtudiantToDepartement(int etudiantId, int departementId) {
Etudiant etudiant=retrieveEtudiant(etudiantId);
        Departement departement=departementRepository.findById(departementId).orElse(null);
        etudiant.setDepartement(departement);
        etudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, int idContrat, int idEquipe) {
        Contrat contrat=contratService.retrieveContrat(idContrat);
        Equipe equipe=equipeService.retrieveEquipe(idEquipe);
        contrat.setEtudiant(e);
        equipe.getEtudiants().add(e);
        return etudiantRepository.save(e);

    }


    @Override
    public Etudiant findByNomAndPrenom(String nom, String prenom) {
        return etudiantRepository.findByNomAndPrenom(nom,prenom);
    }

    @Override
    public List<Etudiant> getEtudiantsByDepartement(int idDepart) {
        return etudiantRepository.getEtudiantsByDepartement(idDepart);
    }

    @Override
    public Integer nombreEtudiantsByDepartement(int idDepart) {
        return  etudiantRepository.nombreEtudiantsByDepartement(idDepart);
    }



}


