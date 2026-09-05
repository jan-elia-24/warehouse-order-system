package se.jan.wos.controller;

import se.jan.wos.model.Lager;
import se.jan.wos.repository.LagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lager")
public class LagerController {

    @Autowired
    private LagerRepository lagerRepository;

    @GetMapping
    public List<Lager> hamtaAlla() {
        return lagerRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lager> hamtaEn(@PathVariable Long id) {
        return lagerRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Lager skapa(@RequestBody Lager lager) {
        return lagerRepository.save(lager);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lager> uppdatera(@PathVariable Long id, @RequestBody Lager uppdaterat) {
        return lagerRepository.findById(id)
                .map(lager -> {
                    lager.setAntal(uppdaterat.getAntal());
                    lager.setArtikel(uppdaterat.getArtikel());
                    return ResponseEntity.ok(lagerRepository.save(lager));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> taBort(@PathVariable Long id) {
        if (!lagerRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        lagerRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}