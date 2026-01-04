package com.tfm.fraud_detector.transactions.infrastructure.controller;

import com.tfm.fraud_detector.transactions.application.services.TransactionService;
import com.tfm.fraud_detector.transactions.infrastructure.dto.input.TransactionInputDto;
import com.tfm.fraud_detector.transactions.infrastructure.dto.output.TransactionOutputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping
    public ResponseEntity<List<TransactionOutputDto>> getAll() {
        return ResponseEntity.ok(transactionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionOutputDto> getById(@PathVariable Long id) {
        TransactionOutputDto dto = transactionService.findById(id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<TransactionOutputDto> create(@RequestBody TransactionInputDto inputDto) {
        TransactionOutputDto dto = transactionService.create(inputDto);
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','AUDITOR')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        transactionService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // endpoint para mantener el backend activo en Render
    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("ok");
    }
}
