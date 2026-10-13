package esprit.tn.benoyunesilyes4cce10.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import esprit.tn.benoyunesilyes4cce10.domain.Vehicule;
import esprit.tn.benoyunesilyes4cce10.exception.ResourceNotFoundException;
import esprit.tn.benoyunesilyes4cce10.repository.IVehiculeRepository;

@Service
@RequiredArgsConstructor
public class VehiculeServiceImpl implements IVehiculeService {

    private final IVehiculeRepository vehiculeRepository;

    @Override
    public Vehicule create(Vehicule x) {
        if (x.getIdVehicule() != null) {
            throw new IllegalArgumentException(
                    "Un nouveau vehicule ne doit pas avoir d'identifiant");
        }
        valider(x);
        return vehiculeRepository.save(x);
    }

    @Override
    public Vehicule findById(Long id) {
        return vehiculeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicule", id));
    }

    @Override
    public List<Vehicule> findAll() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Vehicule update(Long id, Vehicule x) {
        valider(x);
        Vehicule existant = findById(id);
        existant.setImmatriculation(x.getImmatriculation());
        existant.setMarque(x.getMarque());
        existant.setModele(x.getModele());
        existant.setCategorie(x.getCategorie());
        existant.setTarifJournalier(x.getTarifJournalier());
        existant.setStatut(x.getStatut());
        return vehiculeRepository.save(existant);
    }

    @Override
    public void deleteById(Long id) {
        if (!vehiculeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Vehicule", id);
        }
        vehiculeRepository.deleteById(id);
    }

    private void valider(Vehicule x) {
        if (x.getImmatriculation() == null || x.getImmatriculation().isBlank()) {
            throw new IllegalArgumentException("L'immatriculation du véhicule est obligatoire");
        }
        if (x.getTarifJournalier() != null && x.getTarifJournalier().signum() < 0) {
            throw new IllegalArgumentException("Le tarif journalier ne peut pas être négatif");
        }
    }
}
