package esprit.tn.benoyunesilyes4cce10.service;

import java.util.List;
import esprit.tn.benoyunesilyes4cce10.domain.Contrat;

public interface IContratService {
    Contrat create(Contrat contrat);
    Contrat findById(Long id);
    List<Contrat> findAll();
    Contrat update(Long id, Contrat contrat);
    void deleteById(Long id);
}
