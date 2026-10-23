package esprit.tn.benoyunesilyes4cce10.service;

import java.util.List;
import esprit.tn.benoyunesilyes4cce10.domain.Equipement;

public interface IEquipementService {
    Equipement add(Equipement equipement);
    List<Equipement> getAll();
    Equipement getById(Long id);
    Equipement update(Equipement equipement);
    void delete(Long id);
}
