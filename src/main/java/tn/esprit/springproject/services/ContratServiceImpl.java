package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.*;
import tn.esprit.springproject.repositories.ContratRepository;
import tn.esprit.springproject.repositories.DepartementRepository;
import tn.esprit.springproject.repositories.EquipeRepository;
import tn.esprit.springproject.repositories.EtudiantRepository;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Service
@AllArgsConstructor
public class ContratServiceImpl implements ContratService {
    ContratRepository contratRepository;
    EtudiantRepository etudiantRepository;
    EquipeRepository equipeRepository;
    DepartementRepository departementRepository;

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

    @Override
    public List<Contrat> getContratBySpecialite(Specialite specialite) {
        return contratRepository.findBySpecialite(specialite);
    }

    @Override
    public float getChiffreAffaireParEtudiant(int idEtudiant) {
        float ca = 0;
        long nbrMois;
        List<Contrat> contrats = contratRepository.findByEtudiant_IdEtudiantAndArchive(idEtudiant, false);
        for (Contrat c : contrats) {
            nbrMois = ChronoUnit.MONTHS.between(convertToLocalDateViaInstant(c.getDateDebutContrat()), convertToLocalDateViaInstant(c.getDateFinContrat()));
            ca += c.getMontantContrat() * nbrMois;
        }
        return ca;
    }

    @Override
    public void asseignContratToEtudiant(int idContrat, int idEtudiant) {
        Contrat contrat = contratRepository.findById(idContrat).orElse(null);
        Etudiant etudiant = etudiantRepository.findById(idEtudiant).orElse(null);
        contrat.setEtudiant(etudiant);
        contratRepository.save(contrat);
    }

    @Override
    public List<Contrat> findByDateFinContratBetween(Date startdate, Date enddate) {
        return contratRepository.findByDateFinContratBetween(startdate, enddate);
    }

    @Override
    public List<Contrat> findByDateDebutContratBetween(Date startdate, Date enddate) {
        return contratRepository.findByDateDebutContratBetween(startdate, enddate);
    }

    @Override
    public List<Contrat> findByArchive(boolean archivee) {
        return contratRepository.findByArchive(archivee);
    }

    @Override
    public List<Contrat> findByMontantContratGreaterThanEqual(Double montant) {
        return contratRepository.findByMontantContratGreaterThanEqual(montant);
    }

    @Override
    public List<Contrat> findByMontantContratLessThanEqual(Double montant) {
        return contratRepository.findByMontantContratLessThanEqual(montant);
    }

    @Override
    public List<Contrat> findByOptionEtudiant(Option option) {
        return contratRepository.findByEtudiant_Op(option);
    }

    @Override
    public List<Contrat> findByEquipe(int idEquipe) {
        Equipe equipe = equipeRepository.findById(idEquipe).orElse(null);
        List<Contrat> contrats = contratRepository.findByEtudiantNotNull();
//        contrats.stream().filter(contrat -> contrat.getEtudiant().getEquipes().contains(equipe)).forEach(contrat -> System.out.println(contrat.getIdContrat()));
//        return contrats.stream().filter(contrat -> contrat.getEtudiant() != null).filter(contrat -> contrat.getEtudiant().getEquipes().contains(equipe)).collect(Collectors.toList());
        return contrats.stream().filter(contrat -> contrat.getEtudiant().getEquipes().contains(equipe)).collect(Collectors.toList());
    }

    @Override
    public List<Contrat> findByNiveauEquipe(Niveau niveau) {
//        List<Contrat> contrats = contratRepository.findAll();
        List<Contrat> contrats = contratRepository.findByEtudiantNotNull();
//        contrats.stream().filter(contrat -> contrat.getEtudiant().getEquipes().stream().anyMatch(equipe -> equipe.getNiveau().equals(niveau))).forEach(contrat -> System.out.println(contrat.getEtudiant().getNom()));
        return contrats.stream().filter(contrat -> contrat.getEtudiant().getEquipes().stream().anyMatch(equipe -> equipe.getNiveau().equals(niveau))).collect(Collectors.toList());
    }

    @Override
    public List<Contrat> findByDepartement(int idDepartement) {
        Departement departement = departementRepository.findById(idDepartement).orElse(null);
        return contratRepository.findByEtudiantNotNull().stream().filter(contrat -> contrat.getEtudiant().getDepartement() != null).filter(contrat -> contrat.getEtudiant().getDepartement().equals(departement)).collect(Collectors.toList());
    }

    @Override
    public float getChiffreAffaireParEquipe(int idEquipe) {
        float ca = 0;
        long nbrMois = 0;
        Equipe equipe = equipeRepository.findById(idEquipe).orElse(null);
        List<Contrat> contrats = contratRepository.findByEtudiantNotNull();
        List<Contrat> contratsParEquipe = contrats.stream().filter(contrat -> contrat.getEtudiant().getEquipes().contains(equipe)).collect(Collectors.toList());
        for (Contrat c : contratsParEquipe) {
            nbrMois = ChronoUnit.MONTHS.between(convertToLocalDateViaInstant(c.getDateDebutContrat()), convertToLocalDateViaInstant(c.getDateFinContrat()));
            ca += c.getMontantContrat() * nbrMois;
        }
        return ca;
    }

    @Override
    public Contrat archiverContrat(int idContrat) {
        Contrat c = contratRepository.findById(idContrat).orElse(null);
        c.setArchive(true);
        return contratRepository.save(c);
    }

    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
    }

}