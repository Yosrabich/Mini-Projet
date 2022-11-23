package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.springproject.entities.Contrat;
import tn.esprit.springproject.entities.DetailEquipe;

public interface DetailEquipeRepository extends JpaRepository<DetailEquipe,Integer> {
}
