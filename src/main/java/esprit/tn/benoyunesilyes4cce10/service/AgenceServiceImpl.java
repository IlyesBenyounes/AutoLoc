package esprit.tn.benoyunesilyes4cce10.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import esprit.tn.benoyunesilyes4cce10.domain.Agence;
import esprit.tn.benoyunesilyes4cce10.exception.ResourceNotFoundException;
import esprit.tn.benoyunesilyes4cce10.repository.IAgenceRepository;

@Service
@RequiredArgsConstructor
public class AgenceServiceImpl implements IAgenceService {

    private final IAgenceRepository agenceRepository;

    @Override
    public Agence create(Agence x) {
        if (x.getIdAgence() != null) {
            throw new IllegalArgumentException(
                    "Un nouveau agence ne doit pas avoir d'identifiant");
        }
        valider(x);
        return agenceRepository.save(x);
    }

    @Override
    public Agence findById(Long id) {
        return agenceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Agence", id));
    }

    @Override
    public List<Agence> findAll() {
        return agenceRepository.findAll();
    }

    @Override
    public Agence update(Long id, Agence x) {
        valider(x);
        Agence existant = findById(id);
        existant.setNom(x.getNom());
        existant.setVille(x.getVille());
        existant.setAdresse(x.getAdresse());
        existant.setTelephone(x.getTelephone());
        return agenceRepository.save(existant);
    }

    @Override
    public void deleteById(Long id) {
        if (!agenceRepository.existsById(id)) {
            throw new ResourceNotFoundException("Agence", id);
        }
        agenceRepository.deleteById(id);
    }

    private void valider(Agence x) {
        if (x.getNom() == null || x.getNom().isBlank()) {
            throw new IllegalArgumentException("Le nom de l'agence est obligatoire");
        }
    }
}
