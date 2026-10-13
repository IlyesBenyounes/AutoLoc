package esprit.tn.benoyunesilyes4cce10.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import esprit.tn.benoyunesilyes4cce10.domain.Contrat;
import esprit.tn.benoyunesilyes4cce10.exception.ResourceNotFoundException;
import esprit.tn.benoyunesilyes4cce10.repository.IContratRepository;

@Service
@RequiredArgsConstructor
public class ContratServiceImpl implements IContratService {

    private final IContratRepository contratRepository;

    @Override
    public Contrat create(Contrat x) {
        if (x.getIdContrat() != null) {
            throw new IllegalArgumentException(
                    "Un nouveau contrat ne doit pas avoir d'identifiant");
        }
        valider(x);
        return contratRepository.save(x);
    }

    @Override
    public Contrat findById(Long id) {
        return contratRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contrat", id));
    }

    @Override
    public List<Contrat> findAll() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat update(Long id, Contrat x) {
        valider(x);
        Contrat existant = findById(id);
        existant.setDateSignature(x.getDateSignature());
        existant.setMontantTotal(x.getMontantTotal());
        existant.setValide(x.isValide());
        return contratRepository.save(existant);
    }

    @Override
    public void deleteById(Long id) {
        if (!contratRepository.existsById(id)) {
            throw new ResourceNotFoundException("Contrat", id);
        }
        contratRepository.deleteById(id);
    }

    private void valider(Contrat x) {
        if (x.getMontantTotal() != null && x.getMontantTotal().signum() < 0) {
            throw new IllegalArgumentException("Le montant total ne peut pas être négatif");
        }
    }
}
