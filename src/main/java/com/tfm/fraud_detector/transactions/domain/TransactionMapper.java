package com.tfm.fraud_detector.transactions.domain;

import com.tfm.fraud_detector.transactions.infrastructure.dto.input.TransactionInputDto;
import com.tfm.fraud_detector.transactions.infrastructure.dto.output.TransactionOutputDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    Transaction toEntity(TransactionInputDto dto);

    TransactionOutputDto toOutputDto(Transaction transaction);
}
