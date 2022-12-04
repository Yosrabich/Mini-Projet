package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.springproject.entities.Contrat;

import java.util.Date;
import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat, Integer> {
    List<Contrat> findByEtudiantIdEtudiantAndAndArchive(int idEtudiant, Boolean archive);

    List<Contrat> findContratsByDateDebutContratAndAndDateFinContrat(Date dateDebut, Date dateFin);

    List<Contrat> findByDateFinContratBetweenAndArchive(Date date1, Date date2, Boolean valid);

    //Integer countByContratArchive(Boolean valid);
    List<Contrat> findByEtudiantIdEtudiantAndArchive(int idEtudiant, Boolean archive);
}

