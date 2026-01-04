package com.tfm.fraud_detector.transactions.application.services;

import com.tfm.fraud_detector.transactions.domain.Transaction;
import com.tfm.fraud_detector.transactions.domain.TransactionMapper;
import com.tfm.fraud_detector.transactions.infrastructure.client.PredictClient;
import com.tfm.fraud_detector.transactions.infrastructure.dto.input.TransactionInputDto;
import com.tfm.fraud_detector.transactions.infrastructure.dto.output.PredictResponseDto;
import com.tfm.fraud_detector.transactions.infrastructure.dto.output.TransactionOutputDto;
import com.tfm.fraud_detector.transactions.infrastructure.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;
    private final PredictClient predictClient;

    @Override
    public List<TransactionOutputDto> findAll() {
        return transactionRepository.findAll()
                .stream()
                .map(transactionMapper::toOutputDto)
                .toList();
    }

    @Override
    public TransactionOutputDto findById(Long id) {
        return transactionRepository.findById(id)
                .map(transactionMapper::toOutputDto)
                .orElse(null);
    }

    @Override
    public TransactionOutputDto create(TransactionInputDto inputDto) {
        Transaction t = transactionMapper.toEntity(inputDto);
        t.setFraudProbability(null);
        t.setIsFraudFlag(null);
        Transaction saved = transactionRepository.save(t);
        return transactionMapper.toOutputDto(saved);
    }

    @Override
    public void delete(Long id) {
        transactionRepository.deleteById(id);
    }

    @Override
    public TransactionOutputDto predict(TransactionInputDto inputDto) {
        PredictResponseDto iaResult = predictClient.predict(inputDto);
        Transaction t = transactionMapper.toEntity(inputDto);
        t.setFraudProbability(iaResult.getFraudProbability());
        t.setIsFraudFlag(iaResult.getIsFraudFlag());
        Transaction saved = transactionRepository.save(t);
        return transactionMapper.toOutputDto(saved);
    }
}
