package se.jan.wos.controller;

import se.jan.wos.model.Artikel;
import se.jan.wos.repository.ArtikelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artiklar")
public class ArtikelController {

    @Autowired
    private ArtikelRepository artikelRepository;

    @GetMapping
    public List<Artikel> hamtaAlla() {
        return artikelRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artikel> hamtaEn(@PathVariable Long id) {
        return artikelRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Artikel skapa(@RequestBody Artikel artikel) {
        return artikelRepository.save(artikel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Artikel> uppdatera(@PathVariable Long id, @RequestBody Artikel uppdaterad) {
        return artikelRepository.findById(id)
                .map(artikel -> {
                    artikel.setNamn(uppdaterad.getNamn());
                    artikel.setSku(uppdaterad.getSku());
                    artikel.setPris(uppdaterad.getPris());
                    return ResponseEntity.ok(artikelRepository.save(artikel));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> ta_bort(@PathVariable Long id) {
        if (!artikelRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        artikelRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}