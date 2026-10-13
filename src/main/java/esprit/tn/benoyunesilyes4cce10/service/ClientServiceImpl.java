package esprit.tn.benoyunesilyes4cce10.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import esprit.tn.benoyunesilyes4cce10.domain.Client;
import esprit.tn.benoyunesilyes4cce10.exception.ResourceNotFoundException;
import esprit.tn.benoyunesilyes4cce10.repository.IClientRepository;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements IClientService {

    private final IClientRepository clientRepository;

    @Override
    public Client create(Client x) {
        if (x.getIdClient() != null) {
            throw new IllegalArgumentException(
                    "Un nouveau client ne doit pas avoir d'identifiant");
        }
        valider(x);
        return clientRepository.save(x);
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client", id));
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client update(Long id, Client x) {
        valider(x);
        Client existant = findById(id);
        existant.setNom(x.getNom());
        existant.setPrenom(x.getPrenom());
        existant.setEmail(x.getEmail());
        existant.setTelephone(x.getTelephone());
        existant.setNumPermis(x.getNumPermis());
        existant.setDateInscription(x.getDateInscription());
        return clientRepository.save(existant);
    }

    @Override
    public void deleteById(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new ResourceNotFoundException("Client", id);
        }
        clientRepository.deleteById(id);
    }

    private void valider(Client x) {
        if (x.getNom() == null || x.getNom().isBlank()) {
            throw new IllegalArgumentException("Le nom du client est obligatoire");
        }
        if (x.getEmail() == null || x.getEmail().isBlank()) {
            throw new IllegalArgumentException("L'e-mail du client est obligatoire");
        }
    }
}
