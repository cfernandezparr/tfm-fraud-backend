package com.tfm.fraud_detector.transactions.application.services;

import com.tfm.fraud_detector.transactions.infrastructure.dto.input.TransactionInputDto;
import com.tfm.fraud_detector.transactions.infrastructure.dto.output.TransactionOutputDto;

import java.util.List;

public interface TransactionService {

    List<TransactionOutputDto> findAll();

    TransactionOutputDto findById(Long id);

    TransactionOutputDto create(TransactionInputDto inputDto);

    void delete(Long id);

    TransactionOutputDto predict(TransactionInputDto inputDto);

}
