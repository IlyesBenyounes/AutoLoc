package esprit.tn.benoyunesilyes4cce10.service;

import java.util.List;
import esprit.tn.benoyunesilyes4cce10.domain.Paiement;

public interface IPaiementService {
    Paiement add(Paiement paiement);
    List<Paiement> getAll();
    Paiement getById(Long id);
    Paiement update(Paiement paiement);
    void delete(Long id);
}
