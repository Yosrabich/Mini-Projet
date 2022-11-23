package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.springproject.entities.Departement;
import tn.esprit.springproject.entities.Module;

public interface ModuleRepository  extends JpaRepository<Module,Integer> {
}
