package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.springproject.entities.Contrat;
import tn.esprit.springproject.entities.Equipe;

import java.util.List;

public interface EquipeRepository extends JpaRepository<Equipe, Integer> {
    Equipe findEquipeByIdEquipe(int id);

    @Query("select et.equipes from Etudiant et ")
    List<Equipe> findEquipesByIdEtudiant();
}
