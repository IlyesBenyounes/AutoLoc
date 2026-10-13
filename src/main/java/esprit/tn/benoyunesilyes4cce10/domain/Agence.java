package esprit.tn.benoyunesilyes4cce10.domain;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Agence {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgence;
    private String nom;
    private String ville;
    private String adresse;
    private String telephone;

    @OneToMany(mappedBy = "agence")
    private Set<Employe> employes = new HashSet<>();

    @OneToMany(mappedBy = "agence")
    private Set<Vehicule> vehicules = new HashSet<>();

    public Agence() {}

    public void addEmploye(Employe e) { employes.add(e); e.setAgence(this); }
    public void removeEmploye(Employe e) { employes.remove(e); e.setAgence(null); }
    public void addVehicule(Vehicule v) { vehicules.add(v); v.setAgence(this); }
    public void removeVehicule(Vehicule v) { vehicules.remove(v); v.setAgence(null); }
}
