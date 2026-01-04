package com.tfm.fraud_detector.transactions.infrastructure.repository;

import com.tfm.fraud_detector.transactions.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {


}
