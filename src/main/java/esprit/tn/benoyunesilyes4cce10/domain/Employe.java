package esprit.tn.benoyunesilyes4cce10.domain;

import jakarta.persistence.*;

@Entity
public class Employe {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmploye;
    private String nom;
    private String prenom;

    @Enumerated(EnumType.STRING)
    private RoleEmploye role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agence_id")
    private Agence agence;

    public Employe() {}

    public Agence getAgence() { return agence; }
    public void setAgence(Agence agence) { this.agence = agence; }
    // getters/setters des attributs simples (Atelier 1)
}