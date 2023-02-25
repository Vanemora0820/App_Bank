package com.moritabank.app.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "accounts")
public class Account {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "idAccount", nullable = false, length = 150)
    private Long accountId;

    @Column (name = "typeAccount", nullable = false, length = 150)
    private String typeAccount;

    @Column (name = "balance", nullable = false,length = 150)
    private BigDecimal balance;

    @Column (name = "creationAccountDate", nullable = false, length = 150)
    private  LocalDate  creationAccountDate;

    @Column (name = "modificationAccountDate", nullable = false, length = 150)
    private LocalDate modificationAccountDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idClient", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions = new ArrayList<>();

}
