package com.payeshgaran.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountNumber;

    private String pin;

    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private TypeOfAccount type =TypeOfAccount.LOANS;

    @Enumerated(EnumType.STRING)
    private Locked locked =Locked.ENABLE;

    private int incorrectAttempts;

    @Basic
    @Temporal(TemporalType.DATE)
    private java.util.Date utilDate = new Date();

    @Basic
    @Temporal(TemporalType.TIME)
    private java.util.Date utilTime = new Date();


    public Account(String accountNumber, String pin, BigDecimal balance, TypeOfAccount type) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
        this.type = type;
    }

    @OneToMany
    @JoinColumn(name = "transaction_id")
    private List<Transaction> transaction;


}
