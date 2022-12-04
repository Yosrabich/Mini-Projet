package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Departement;
import tn.esprit.springproject.entities.DetailEquipe;
import tn.esprit.springproject.entities.Equipe;
import tn.esprit.springproject.entities.Etudiant;
import tn.esprit.springproject.repositories.EquipeRepository;
import tn.esprit.springproject.repositories.EtudiantRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class EquipeServiceImpl implements EquipeService {
    @Autowired

    EquipeRepository equipeRepository;
    EtudiantRepository etudiantRepository;
    boolean comparer;

    @Override
    public List<Equipe> retrieveAllEquipe() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe addEquipe(Equipe Eq) {
        return equipeRepository.save(Eq);
    }

    @Override
    public void deleteEquipe(Integer id) {
        equipeRepository.deleteById(id);

    }

    @Override
    public Equipe updateEquipe(Equipe Eq) {
        return equipeRepository.save(Eq);
    }

    @Override
    public Equipe retrieveEquipe(Integer id) {
        return equipeRepository.findById(id).orElse(null);
    }

    @Override
    public int countEtudiantByEquipe(int id) {
        Equipe equipe = equipeRepository.findEquipeByIdEquipe(id);
        return equipe.getEtudiants().size();
    }

    @Override
    public Boolean compareEquipes(Integer id1, Integer id2) {
        comparer = true;
        Equipe eq1 = equipeRepository.findById(id1).orElse(null);
        Equipe eq2 = equipeRepository.findById(id2).orElse(null);
        if (eq1.getEtudiants().size() < eq2.getEtudiants().size()) {
            comparer = false;
        }
        return comparer;
    }

    @Override
    public void assignDetailsEquipeToEquipe(Integer idEquipe, DetailEquipe detailsEquipe) {
        Equipe equipe = equipeRepository.findById(idEquipe).orElse(null);
        equipe.setDetailEquipe(detailsEquipe);
        equipeRepository.save(equipe);
    }

    @Override
    public List<Equipe> retrieveEquipesDeLetudiant(Integer id) {
        Etudiant etudiant = etudiantRepository.findById(id).orElse(null);
        return equipeRepository.findEquipesByIdEtudiant();

    }


}
