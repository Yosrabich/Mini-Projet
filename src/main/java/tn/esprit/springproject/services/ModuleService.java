package tn.esprit.springproject.services;

import tn.esprit.springproject.entities.Etudiant;
import tn.esprit.springproject.entities.Module;

import java.util.List;

public interface ModuleService {
    List<Module> retrieveAllModules();

    Module addModule(Module mod);

    void deleteModule(int id);

    Module updateModule(Module mod);

    Module retrieveModule(int id);
}
