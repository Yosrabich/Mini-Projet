package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Departement;
import tn.esprit.springproject.entities.Enseignant;
import tn.esprit.springproject.entities.Etudiant;
import tn.esprit.springproject.entities.Fonction;
import tn.esprit.springproject.entities.Module;
import tn.esprit.springproject.repositories.DepartementRepository;
import tn.esprit.springproject.repositories.EnseignantRepository;
import tn.esprit.springproject.repositories.ModuleRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EnseignantServiceImpl implements EnseignantService {
	@Autowired
	DepartementRepository departementRepository;
	@Autowired
	EnseignantRepository enseignantRepository;

	@Override
	public List<Enseignant> retrieveAllEnseignants() {
		return enseignantRepository.findAll();
	}

	@Override
	public Enseignant addEnseignant(Enseignant e) {
		return enseignantRepository.save(e);
	}

	@Override
	public void deleteEnseignant(int id) {
		enseignantRepository.deleteById(id);

	}

	@Override
	public Enseignant updateEnseignant(Enseignant e) {
		return enseignantRepository.save(e);
	}

	@Override
	public Enseignant retrieveEnseignant(int id) {
		return enseignantRepository.findById(id).orElse(null);
	}

	public void assignEnseignantToDepartement(int enseignantId, int departementId) {
		Enseignant enseignant = retrieveEnseignant(enseignantId);
		Departement departement = departementRepository.findById(departementId).orElse(null);
		enseignant.setDepartement(departement);
		enseignantRepository.save(enseignant);
	}

	@Override
	public Enseignant getEnseignantByFonctionAndDepartement_IdDepart(Fonction fonction, int idDepart) {
		return enseignantRepository.getEnseignantByFonctionAndDepartement_IdDepart(fonction, idDepart);
	}

	@Override
	public Enseignant chercherEnseignantBynom(String nomEns) {

		return enseignantRepository.findEnseignantBynomEns(nomEns);
	}

	@Override
	public List<Enseignant> getEnseignantByModules_idModule(int idModule) {
		return enseignantRepository.findEnseignantByModules_idModule(idModule);
	}

	@Override
	public List<Enseignant> getEnseignantByFonctionAndModules_idModule(Fonction fonction, int idModule) {
		return enseignantRepository.findEnseignantByFonctionAndModules_idModule(fonction, idModule);
	}

	@Override
	public List<Enseignant> chercherEnseignantBySalaire(double salaire) {
		List<Enseignant> enseignants;
		enseignants = enseignantRepository.findAll().stream().filter(e -> e.getSalaire() < salaire)
				.collect(Collectors.toList());
		return enseignants;
	}

	/*
	 * @Override public Enseignant getEneignantByFonctionAndModule_IdModule(Fonction
	 * fonction, int idModule) { return
	 * enseignantRepository.getEneignantByFonctionAndModule_IdModule(fonction,
	 * idModule); }
	 */

}
