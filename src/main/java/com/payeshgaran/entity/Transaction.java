package com.payeshgaran.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private TypeOfTransaction type;

//    @Column(name = "accountNumber_Sender")
    private String accountNumberSender;

//    @Column(name = "accountNumber_Receiver")
    private String accountNumberReceiver;

    private BigDecimal amount;

    @Basic
    @Temporal(TemporalType.DATE)
    private java.util.Date utilDate = new Date();

    @Basic
    @Temporal(TemporalType.TIME)
    private java.util.Date utilTime = new Date();

}
