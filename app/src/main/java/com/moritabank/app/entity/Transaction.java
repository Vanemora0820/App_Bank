package com.moritabank.app.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


    @Entity
    @Table(name = "transactions")

    public class Transaction {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column (name = "idTransaction", nullable = false, length = 150)
        private Long idTransaction;

        @Column (name = "typeTransaction", nullable = false, length = 150)
        private String typeTransaction;

        @Column (name = "amount", nullable = false,length = 150)
        private BigDecimal amount;
        @Column (name = "statusTransaction", nullable = false,length = 150)
        private String statusTransaction;
        @Column (name = "creationTransactionDate", nullable = false, length = 150)
        private LocalDate creationTransactionDate;

        @Column (name = "executionDate", nullable = false, length = 150)
        private LocalDate executionDate;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "idAccount", nullable = false)
        private Account account;




}
