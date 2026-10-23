package esprit.tn.benoyunesilyes4cce10.service;

import java.util.List;
import esprit.tn.benoyunesilyes4cce10.domain.Maintenance;

public interface IMaintenanceService {
    Maintenance add(Maintenance maintenance);
    List<Maintenance> getAll();
    Maintenance getById(Long id);
    Maintenance update(Maintenance maintenance);
    void delete(Long id);
}
