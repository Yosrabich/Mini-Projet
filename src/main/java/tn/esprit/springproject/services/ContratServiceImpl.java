package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Contrat;
import tn.esprit.springproject.entities.Etudiant;
import tn.esprit.springproject.repositories.ContratRepository;
import tn.esprit.springproject.repositories.EtudiantRepository;

import java.util.Date;
import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Service
@AllArgsConstructor
public class ContratServiceImpl implements ContratService {
    ContratRepository contratRepository;
    EtudiantRepository etudiantRepository;

    @Override
    public List<Contrat> retrieveAllContrats() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat addContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public void deleteContrat(int id) {
        contratRepository.deleteById(id);

    }


    @Override
    public Contrat updateContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public Contrat retrieveContrat(int id) {
        return contratRepository.findById(id).orElse(null);
    }


    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nom, String prenom) {

        Etudiant etudiant = etudiantRepository.findByNomAndPrenom(nom, prenom);
        if (etudiant == null) {
            log.print("not exist");
        } else if (contratRepository.findByEtudiantIdEtudiantAndAndArchive(etudiant.getIdEtudiant(), false).size() < 5) {
            ce.setEtudiant(etudiant);

            return contratRepository.save(ce);
        }
        return null;
    }

    @Override
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {

        float chiffre = 0;
        List<Contrat> conts = contratRepository.findByDateFinContratBetweenAndArchive(startDate, endDate, false);
        for (Contrat c : conts) {
            chiffre += c.getMontantContrat();
        }
        return chiffre;
    }

    @Override
    public Integer nbContratsValides(Date startDate, Date endDate) {
        List<Contrat> conts = contratRepository.findByDateFinContratBetweenAndArchive(startDate, endDate, false);
        return conts.size();
    }
}