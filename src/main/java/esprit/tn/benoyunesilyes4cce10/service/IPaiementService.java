package esprit.tn.benoyunesilyes4cce10.service;

import java.util.List;
import esprit.tn.benoyunesilyes4cce10.domain.Paiement;

public interface IPaiementService {
    Paiement findById(Long id);
    List<Paiement> findAll();
}
