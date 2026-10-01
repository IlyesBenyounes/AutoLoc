package esprit.tn.benoyunesilyes4cce10.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Contrat {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrat;
    private LocalDate dateSignature;
    private BigDecimal montantTotal;
    private boolean valide;

    // Côté propriétaire du OneToOne : clé étrangère unique reservation_id
    @OneToOne(optional = false)
    @JoinColumn(name = "reservation_id", unique = true)
    private Reservation reservation;

    // Composition : les paiements vivent et meurent avec le contrat
    @OneToMany(mappedBy = "contrat", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Paiement> paiements = new ArrayList<>();

    public Contrat() {}

    public void addPaiement(Paiement p) { paiements.add(p); p.setContrat(this); }
    public void removePaiement(Paiement p) { paiements.remove(p); p.setContrat(null); }

    public Reservation getReservation() { return reservation; }
    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
        if (reservation != null) reservation.setContrat(this);
    }
    public List<Paiement> getPaiements() { return paiements; }
    // getters/setters des attributs simples (Atelier 1)
}