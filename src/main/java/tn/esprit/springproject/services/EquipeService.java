package tn.esprit.springproject.services;

import tn.esprit.springproject.entities.DetailEquipe;
import tn.esprit.springproject.entities.Equipe;
import tn.esprit.springproject.entities.Etudiant;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface EquipeService {

    List<Equipe> retrieveAllEquipe();

    Equipe addEquipe(Equipe Eq);

    void deleteEquipe(Integer id);

    Equipe updateEquipe(Equipe Eq);

    Equipe retrieveEquipe(Integer id);

    public int countEtudiantByEquipe(int id);

    public Boolean compareEquipes(Integer id1, Integer id2);

    public void assignDetailsEquipeToEquipe(Integer idEquipe, DetailEquipe detailsEquipe);


    public List<Equipe> retrieveEquipesDeLetudiant(Integer id);

}
