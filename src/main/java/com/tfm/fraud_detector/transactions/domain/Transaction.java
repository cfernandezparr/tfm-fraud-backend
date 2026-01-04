package com.tfm.fraud_detector.transactions.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long cardNumber;
    private String merchant;
    private String category;
    private Double amount;

    private String gender;
    private String city;
    private String state;
    private Integer zipCode;
    private Integer cityPop;
    private String job;

    private Double lat;
    private Double lng;

    private Double merchLat;
    private Double merchLng;

    @Column(name = "transaction_hour")
    private Integer hour;

    @Column(name = "transaction_day")
    private Integer day;

    private Integer weekday;
    private Long unixTime;

    private Double fraudProbability;
    private Integer isFraudFlag;
}
