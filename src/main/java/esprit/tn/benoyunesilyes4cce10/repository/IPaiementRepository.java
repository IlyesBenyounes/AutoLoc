package esprit.tn.benoyunesilyes4cce10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import esprit.tn.benoyunesilyes4cce10.domain.Paiement;

public interface IPaiementRepository extends JpaRepository<Paiement, Long> {
}
