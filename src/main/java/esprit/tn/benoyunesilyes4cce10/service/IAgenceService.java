package esprit.tn.benoyunesilyes4cce10.service;

import java.util.List;
import esprit.tn.benoyunesilyes4cce10.domain.Agence;

public interface IAgenceService {
    Agence add(Agence agence);
    List<Agence> getAll();
    Agence getById(Long id);
    Agence update(Agence agence);
    void delete(Long id);
}
