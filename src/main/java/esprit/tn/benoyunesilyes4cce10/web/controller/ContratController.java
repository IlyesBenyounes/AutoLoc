package esprit.tn.benoyunesilyes4cce10.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import esprit.tn.benoyunesilyes4cce10.domain.Contrat;
import esprit.tn.benoyunesilyes4cce10.service.IContratService;

import java.util.List;

@RestController
@RequestMapping("/api/contrats")
@RequiredArgsConstructor
public class ContratController {

    private final IContratService contratService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contrat add(@RequestBody Contrat contrat) {
        return contratService.add(contrat);
    }

    @GetMapping
    public List<Contrat> getAll() {
        return contratService.getAll();
    }

    @GetMapping("/{id}")
    public Contrat getById(@PathVariable Long id) {
        return contratService.getById(id);
    }

    @PutMapping
    public Contrat update(@RequestBody Contrat contrat) {
        return contratService.update(contrat);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        contratService.delete(id);
    }
}
