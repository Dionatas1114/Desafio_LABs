package com.challenge.LuizaLabs.model;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_product")
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "productId", updatable = false, unique = true, nullable = false)
    private int id;

    @Column(nullable = false)
    public String name;

    @Column(nullable = false)
    public double price;

}
