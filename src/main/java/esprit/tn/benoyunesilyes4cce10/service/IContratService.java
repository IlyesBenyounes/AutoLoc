package esprit.tn.benoyunesilyes4cce10.service;

import java.util.List;
import esprit.tn.benoyunesilyes4cce10.domain.Contrat;

public interface IContratService {
    Contrat add(Contrat contrat);
    List<Contrat> getAll();
    Contrat getById(Long id);
    Contrat update(Contrat contrat);
    void delete(Long id);
}
