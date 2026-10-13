package esprit.tn.benoyunesilyes4cce10.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Vehicule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicule;
    private String immatriculation;
    private String marque;
    private String modele;

    @Enumerated(EnumType.STRING)
    private CategorieVehicule categorie;

    private BigDecimal tarifJournalier;

    @Enumerated(EnumType.STRING)
    private StatutVehicule statut;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agence_id")
    private Agence agence;

    // Pas de setter : avec orphanRemoval, remplacer la collection provoque une erreur Hibernate
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Maintenance> maintenances = new HashSet<>();

    @Setter(AccessLevel.NONE)
    @ManyToMany
    @JoinTable(name = "vehicule_equipement",
            joinColumns = @JoinColumn(name = "vehicule_id"),
            inverseJoinColumns = @JoinColumn(name = "equipement_id"))
    private Set<Equipement> equipements = new HashSet<>();

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "vehicule")
    private Set<Reservation> reservations = new HashSet<>();

    public Vehicule() {}

    public void addMaintenance(Maintenance m) { maintenances.add(m); m.setVehicule(this); }
    public void removeMaintenance(Maintenance m) { maintenances.remove(m); m.setVehicule(null); }
    public void addEquipement(Equipement e) { equipements.add(e); e.getVehicules().add(this); }
    public void removeEquipement(Equipement e) { equipements.remove(e); e.getVehicules().remove(this); }
    public void addReservation(Reservation r) { reservations.add(r); r.setVehicule(this); }
}
