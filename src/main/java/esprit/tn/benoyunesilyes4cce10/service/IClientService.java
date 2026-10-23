package esprit.tn.benoyunesilyes4cce10.service;

import java.util.List;
import esprit.tn.benoyunesilyes4cce10.domain.Client;

public interface IClientService {
    Client add(Client client);
    List<Client> getAll();
    Client getById(Long id);
    Client update(Client client);
    void delete(Long id);
}
