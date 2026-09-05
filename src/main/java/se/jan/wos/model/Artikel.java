package se.jan.wos.model;

import jakarta.persistence.*;

@Entity
public class Artikel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String namn;

    private String sku;

    private Double pris;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNamn() { return namn; }
    public void setNamn(String namn) { this.namn = namn; }

    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }

    public Double getPris() { return pris; }
    public void setPris(Double pris) { this.pris = pris; }
}