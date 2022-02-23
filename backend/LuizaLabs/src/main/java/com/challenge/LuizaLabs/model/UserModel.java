package com.challenge.LuizaLabs.model;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_user")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId", updatable = false, unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    public String name;

    @Column(nullable = false)
    public String password;

}
