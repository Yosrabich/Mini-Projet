package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.DetailEquipe;
import tn.esprit.springproject.entities.Equipe;
import tn.esprit.springproject.repositories.DetailEquipeRepository;
import tn.esprit.springproject.repositories.EquipeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class DetailEquipeServiceImpl implements DetailEquipeService{
    DetailEquipeRepository detailEquipeRepository;
    EquipeRepository equipeRepository;
    @Override
    public List<DetailEquipe> retrieveAllDetails() {
        return detailEquipeRepository.findAll();
    }

    @Override
    public DetailEquipe addDetailEquipe(DetailEquipe d) {
        return detailEquipeRepository.save(d);
    }

    @Override
    public void deleteDetailEquipe(int id) {
detailEquipeRepository.deleteById(id);
    }

    @Override
    public DetailEquipe updateDetailEquipe(DetailEquipe d) {
        return detailEquipeRepository.save(d);
    }

    @Override
    public DetailEquipe retrieveDetailEquipe(int id) {
        return detailEquipeRepository.findById(id).orElse(null);
    }
    @Override
    public DetailEquipe retrieveDetailparEquipe(Integer id) {
        Equipe equipe=equipeRepository.findEquipeByIdEquipe(id);

        return equipe.getDetailEquipe();
    }
    @Override
    public List<DetailEquipe> afficherListeDetailEquipeTriee() {
        return detailEquipeRepository.getAllOrderByIdDetailEquipe();
    }
}
