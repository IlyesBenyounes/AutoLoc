package esprit.tn.benoyunesilyes4cce10.service;

import java.util.List;
import esprit.tn.benoyunesilyes4cce10.domain.Vehicule;

public interface IVehiculeService {
    Vehicule add(Vehicule vehicule);
    List<Vehicule> getAll();
    Vehicule getById(Long id);
    Vehicule update(Vehicule vehicule);
    void delete(Long id);
}
