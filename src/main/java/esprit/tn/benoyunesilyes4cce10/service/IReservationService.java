package esprit.tn.benoyunesilyes4cce10.service;

import java.util.List;
import esprit.tn.benoyunesilyes4cce10.domain.Reservation;

public interface IReservationService {
    Reservation add(Reservation reservation);
    List<Reservation> getAll();
    Reservation getById(Long id);
    Reservation update(Reservation reservation);
    void delete(Long id);
}
