package com.moritabank.app.entity;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idClient", nullable = false, length = 150)
    private Long clientId;

    @Column(name = "typeDocument", nullable = false, length = 150)
    private String typeId;

    @Column(name = "numDocument" , nullable = false,length = 150)
    private  Long numberId;
    @Column (name = "firstName", nullable = false, length = 150)
    private String firstName;

    @Column (name = "secondName", nullable = false, length = 150)
    private String secondName;

    @Column (name = "firstLastName", nullable = false, length = 150)
    private  String firstLastName;

    @Column (name = "secondLastName", nullable = false, length = 150)
    private String secondLastName;

    @Column (name = "typeClient", nullable = false,length = 150)
    private String typeClient;
    @Column (name = "address" , nullable = false, length = 150 )
    private String address;

    @Column (name = "phone", nullable = false, length = 150)
    private String phone;


    @Column (name = "mail",nullable = false, length = 150)
    private String mail;

    @Column (name = "bornDate", nullable = false, length = 50)
    private LocalDate bornDate ;
    @Column (name = "creationDate", nullable = false, length = 50)
    private LocalDate creationDate;
    @Column (name = "statusClient", nullable = false, length = 150)
    private String statusClient;

    @Column (name = "modificationDate", nullable = false, length =  150)
    private LocalDate modificationDate;

    @Column (name = "modificationUser", nullable = true, length = 150)
    private String modificationUser;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> Accounts= new ArrayList<>();

    }

