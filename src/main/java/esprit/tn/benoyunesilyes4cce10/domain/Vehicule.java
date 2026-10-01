package esprit.tn.benoyunesilyes4cce10.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
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

    @OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Maintenance> maintenances = new ArrayList<>();

    // Côté propriétaire du ManyToMany : crée la table de jointure
    @ManyToMany
    @JoinTable(name = "vehicule_equipement",
            joinColumns = @JoinColumn(name = "vehicule_id"),
            inverseJoinColumns = @JoinColumn(name = "equipement_id"))
    private List<Equipement> equipements = new ArrayList<>();

    @OneToMany(mappedBy = "vehicule")
    private List<Reservation> reservations = new ArrayList<>();

    public Vehicule() {}

    public void addMaintenance(Maintenance m) { maintenances.add(m); m.setVehicule(this); }
    public void removeMaintenance(Maintenance m) { maintenances.remove(m); m.setVehicule(null); }
    public void addEquipement(Equipement e) { equipements.add(e); e.getVehicules().add(this); }
    public void removeEquipement(Equipement e) { equipements.remove(e); e.getVehicules().remove(this); }
    public void addReservation(Reservation r) { reservations.add(r); r.setVehicule(this); }

    public Agence getAgence() { return agence; }
    public void setAgence(Agence agence) { this.agence = agence; }
    public List<Maintenance> getMaintenances() { return maintenances; }
    public List<Equipement> getEquipements() { return equipements; }
    public List<Reservation> getReservations() { return reservations; }
    // getters/setters des attributs simples (Atelier 1)
}