package com.webgram.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "produits")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 25)
    private String reference;
    @Column(nullable = false, length = 25)
    private String code;
    @Column(length = 500)
    private String description;
    private boolean isDeleted = false;
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;
}
