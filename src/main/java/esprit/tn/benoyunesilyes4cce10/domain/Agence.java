package esprit.tn.benoyunesilyes4cce10.domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Agence {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgence;
    private String nom;
    private String ville;
    private String adresse;
    private String telephone;

    @OneToMany(mappedBy = "agence")
    private List<Employe> employes = new ArrayList<>();

    @OneToMany(mappedBy = "agence")
    private List<Vehicule> vehicules = new ArrayList<>();

    public Agence() {}

    public void addEmploye(Employe e) { employes.add(e); e.setAgence(this); }
    public void removeEmploye(Employe e) { employes.remove(e); e.setAgence(null); }
    public void addVehicule(Vehicule v) { vehicules.add(v); v.setAgence(this); }
    public void removeVehicule(Vehicule v) { vehicules.remove(v); v.setAgence(null); }

    public List<Employe> getEmployes() { return employes; }
    public void setEmployes(List<Employe> employes) { this.employes = employes; }
    public List<Vehicule> getVehicules() { return vehicules; }
    public void setVehicules(List<Vehicule> vehicules) { this.vehicules = vehicules; }
    // getters/setters des attributs simples (Atelier 1)
}