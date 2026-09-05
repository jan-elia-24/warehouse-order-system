package se.jan.wos.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String kundNamn;

    private LocalDate orderDatum;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderRad> orderRader = new ArrayList<>();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getKundNamn() { return kundNamn; }
    public void setKundNamn(String kundNamn) { this.kundNamn = kundNamn; }

    public LocalDate getOrderDatum() { return orderDatum; }
    public void setOrderDatum(LocalDate orderDatum) { this.orderDatum = orderDatum; }

    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }

    public List<OrderRad> getOrderRader() { return orderRader; }
    public void setOrderRader(List<OrderRad> orderRader) { this.orderRader = orderRader; }
}