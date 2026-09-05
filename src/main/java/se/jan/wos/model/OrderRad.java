package se.jan.wos.model;

import jakarta.persistence.*;

@Entity
public class OrderRad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "artikel_id")
    private Artikel artikel;

    private Integer antal;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }

    public Artikel getArtikel() { return artikel; }
    public void setArtikel(Artikel artikel) { this.artikel = artikel; }

    public Integer getAntal() { return antal; }
    public void setAntal(Integer antal) { this.antal = antal; }
}