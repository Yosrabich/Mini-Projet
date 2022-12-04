package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Equipe;
import tn.esprit.springproject.repositories.EquipeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EquipeServiceImpl implements EquipeService {
    EquipeRepository equipeRepository;

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
}
