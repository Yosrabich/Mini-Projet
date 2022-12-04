package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.DetailEquipe;
import tn.esprit.springproject.entities.Encadrant;
import tn.esprit.springproject.entities.Equipe;
import tn.esprit.springproject.entities.Etudiant;
import tn.esprit.springproject.repositories.EncadrantRepository;
import tn.esprit.springproject.repositories.EquipeRepository;
import tn.esprit.springproject.repositories.EtudiantRepository;

import java.util.List;

@Service
@AllArgsConstructor

public class EquipeServiceImpl implements EquipeService {
    EquipeRepository equipeRepository;
    EtudiantRepository etudiantRepository;
    EncadrantRepository encadrantRepository;


    @Override
    public List<Equipe> retrieveAllEquipes() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe addEquipe(Equipe eq) {
        return equipeRepository.save(eq);
    }

    @Override
    public void deleteEquipe(int id) {
        equipeRepository.deleteById(id);
    }

    @Override
    public Equipe updateEquipe(Equipe eq) {
        return equipeRepository.save(eq);
    }

    @Override
    public Equipe retrieveEquipe(int id) {
        return equipeRepository.findById(id).orElse(null);
    }

    @Override
    public int countEtudiantByEquipe(int id) {
        Equipe equipe = equipeRepository.findEquipeByIdEquipe(id);
        return equipe.getEtudiants().size();
    }

    @Override
    public Boolean compareEquipes(Integer id1, Integer id2) {
      Boolean  comparer = true;
        Equipe eq1 = equipeRepository.findById(id1).orElse(null);
        Equipe eq2 = equipeRepository.findById(id2).orElse(null);
        if (eq1.getEtudiants().size() < eq2.getEtudiants().size()) {
            comparer = false;
        }
        return comparer ;
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

    @Override
    public Equipe affectEquipeToEncadrant(int idEquipe, int idEncadrant) {
        Equipe equipe = equipeRepository.findById(idEquipe).orElse(null);
        Encadrant encadrant = encadrantRepository.findById(idEncadrant).orElse(null);
        equipe.setEncadrant(encadrant);
        return equipeRepository.save(equipe);
    }
}
