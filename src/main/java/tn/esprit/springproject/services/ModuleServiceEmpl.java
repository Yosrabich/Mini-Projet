package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Module;
import tn.esprit.springproject.repositories.ModuleRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class ModuleServiceEmpl implements ModuleService{
    ModuleRepository moduleRepository;
    @Override
    public List<Module> retrieveAllModules() {
        return moduleRepository.findAll();
    }

    @Override
    public Module addModule(Module mod) {
        return moduleRepository.save(mod);
    }

    @Override
    public void deleteModule(int id) {
moduleRepository.deleteById(id);
    }

    @Override
    public Module updateModule(Module mod) {
        return moduleRepository.save(mod);
    }

    @Override
    public Module retrieveModule(int id) {
        return moduleRepository.findById(id).orElse(null);
    }
}
