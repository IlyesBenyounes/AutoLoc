package esprit.tn.benoyunesilyes4cce10.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import esprit.tn.benoyunesilyes4cce10.domain.Reservation;
import esprit.tn.benoyunesilyes4cce10.exception.ResourceNotFoundException;
import esprit.tn.benoyunesilyes4cce10.repository.IReservationRepository;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements IReservationService {

    private final IReservationRepository reservationRepository;

    @Override
    public Reservation create(Reservation x) {
        if (x.getIdReservation() != null) {
            throw new IllegalArgumentException(
                    "Un nouveau reservation ne doit pas avoir d'identifiant");
        }
        valider(x);
        return reservationRepository.save(x);
    }

    @Override
    public Reservation findById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation", id));
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation update(Long id, Reservation x) {
        valider(x);
        Reservation existant = findById(id);
        existant.setDateDebut(x.getDateDebut());
        existant.setDateFin(x.getDateFin());
        existant.setStatut(x.getStatut());
        return reservationRepository.save(existant);
    }

    @Override
    public void deleteById(Long id) {
        if (!reservationRepository.existsById(id)) {
            throw new ResourceNotFoundException("Reservation", id);
        }
        reservationRepository.deleteById(id);
    }

    private void valider(Reservation x) {
        if (x.getDateDebut() != null && x.getDateFin() != null
                && x.getDateFin().isBefore(x.getDateDebut())) {
            throw new IllegalArgumentException(
                    "La date de fin ne peut pas être antérieure à la date de début");
        }
    }
}
