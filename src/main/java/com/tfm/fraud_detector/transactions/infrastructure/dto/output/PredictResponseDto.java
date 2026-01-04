package com.tfm.fraud_detector.transactions.infrastructure.dto.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PredictResponseDto {

    @JsonProperty("fraud_probability")
    private Double fraudProbability;

    @JsonProperty("is_fraud_flag")
    private Integer isFraudFlag;
}

