package tn.esprit.springproject.services;

import tn.esprit.springproject.entities.Contrat;
import tn.esprit.springproject.entities.Equipe;

import java.util.List;

public interface EquipeService {
    List<Equipe> retrieveAllEquipes();
    Equipe addEquipe(Equipe eq);
    void deleteEquipe(int id);
    Equipe updateEquipe(Equipe eq);
    Equipe retrieveEquipe(int id);
}
