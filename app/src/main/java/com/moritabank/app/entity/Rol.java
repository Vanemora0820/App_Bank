package com.moritabank.app.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;

    @Column(name = "rolName")
    private String rolName;

    @ManyToMany(mappedBy = "roles")
    private List<User> users = new ArrayList<>();


}
