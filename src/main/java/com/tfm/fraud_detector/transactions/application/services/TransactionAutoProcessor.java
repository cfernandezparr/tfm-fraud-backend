package com.tfm.fraud_detector.transactions.application.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tfm.fraud_detector.transactions.infrastructure.dto.input.TransactionInputDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionAutoProcessor {

    private final TransactionService transactionService;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private static final String GENERATOR_URL = "https://generator-api-i2wy.onrender.com/generate";

    @Scheduled(fixedRate = 60000) // 1 minuto
    public void fetchAndProcessTransaction() {
        try {
            String json = restTemplate.getForObject(GENERATOR_URL, String.class);

            if (json == null || json.isEmpty()) {
                log.warn("No transaction received from the generator.");
                return;
            }

            TransactionInputDto input = objectMapper.readValue(json, TransactionInputDto.class);

            var result = transactionService.predict(input);

            log.info("Transaction processed automatically | merchant={} | amount={} | fraudProbability={}",
                    result.getMerchant(),
                    result.getAmount(),
                    result.getFraudProbability());

        } catch (Exception e) {
            log.error("Error occurred while processing automatic transaction.", e);
        }
    }
}
