package esprit.tn.benoyunesilyes4cce10.domain;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String numPermis;
    private LocalDate dateInscription;

    @OneToMany(mappedBy = "client")
    private Set<Reservation> reservations = new HashSet<>();

    public Client() {}

    public void addReservation(Reservation r) { reservations.add(r); r.setClient(this); }
}
