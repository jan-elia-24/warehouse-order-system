package se.jan.wos.controller;

import se.jan.wos.model.OrderRad;
import se.jan.wos.repository.OrderRadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderrader")
public class OrderRadController {

    @Autowired
    private OrderRadRepository orderRadRepository;

    @GetMapping
    public List<OrderRad> hamtaAlla() {
        return orderRadRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderRad> hamtaEn(@PathVariable Long id) {
        return orderRadRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public OrderRad skapa(@RequestBody OrderRad orderRad) {
        return orderRadRepository.save(orderRad);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> taBort(@PathVariable Long id) {
        if (!orderRadRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        orderRadRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}