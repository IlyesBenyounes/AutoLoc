package esprit.tn.benoyunesilyes4cce10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import esprit.tn.benoyunesilyes4cce10.domain.Client;

public interface IClientRepository extends JpaRepository<Client, Long> {
}
