package esprit.tn.benoyunesilyes4cce10.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Contrat {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrat;
    private LocalDate dateSignature;
    private BigDecimal montantTotal;
    private boolean valide;

    @OneToOne(optional = false)
    @JoinColumn(name = "reservation_id", unique = true)
    private Reservation reservation;

    // Pas de setter : avec orphanRemoval, remplacer la collection provoque une erreur Hibernate
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "contrat", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Paiement> paiements = new HashSet<>();

    public Contrat() {}

    public void addPaiement(Paiement p) { paiements.add(p); p.setContrat(this); }
    public void removePaiement(Paiement p) { paiements.remove(p); p.setContrat(null); }

    // Setter explicite : synchronise le côté inverse du OneToOne
    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
        if (reservation != null) reservation.setContrat(this);
    }
}
