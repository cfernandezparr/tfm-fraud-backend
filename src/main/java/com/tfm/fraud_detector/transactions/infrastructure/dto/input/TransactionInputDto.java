package com.tfm.fraud_detector.transactions.infrastructure.dto.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TransactionInputDto {

    @JsonProperty("cc_num")
    private Long cardNumber;

    @JsonProperty("merchant")
    private String merchant;

    @JsonProperty("category")
    private String category;

    @JsonProperty("amt")
    private Double amount;

    private String gender;
    private String city;
    private String state;

    @JsonProperty("zip")
    private Integer zipCode;

    @JsonProperty("city_pop")
    private Integer cityPop;

    private String job;

    @JsonProperty("lat")
    private Double lat;

    @JsonProperty("long")
    private Double lng;

    @JsonProperty("merch_lat")
    private Double merchLat;

    @JsonProperty("merch_long")
    private Double merchLng;

    private Integer hour;
    private Integer day;
    private Integer weekday;

    @JsonProperty("unix_time")
    private Long unixTime;
}
