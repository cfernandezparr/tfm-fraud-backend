package com.tfm.fraud_detector.transactions.infrastructure.dto.output;

import lombok.Data;

@Data
public class TransactionOutputDto {

    private Long id;
    private Double fraudProbability;
    private Integer isFraudFlag;
    private String merchant;
    private Double amount;
}
