package esprit.tn.benoyunesilyes4cce10.service;

import java.util.List;
import esprit.tn.benoyunesilyes4cce10.domain.Employe;

public interface IEmployeService {
    Employe add(Employe employe);
    List<Employe> getAll();
    Employe getById(Long id);
    Employe update(Employe employe);
    void delete(Long id);
}
