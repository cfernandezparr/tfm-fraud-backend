package com.tfm.fraud_detector.transactions.infrastructure.client;

import com.tfm.fraud_detector.transactions.infrastructure.dto.input.TransactionInputDto;
import com.tfm.fraud_detector.transactions.infrastructure.dto.output.PredictResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class PredictClient {

    private final RestTemplate restTemplate;

    private static final String PREDICT_URL = "https://fraud-api-k3re.onrender.com/predict";

    public PredictResponseDto predict(TransactionInputDto inputDto) {
        return restTemplate.postForObject(PREDICT_URL, inputDto, PredictResponseDto.class);
    }
}
