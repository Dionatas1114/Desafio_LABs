package com.challenge.LuizaLabs.model;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_category")
public class CategoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "categoryId", updatable = false, unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    public String name;

}
