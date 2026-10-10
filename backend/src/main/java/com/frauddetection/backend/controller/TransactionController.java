
package com.frauddetection.backend.controller;

import com.frauddetection.backend.model.Transaction;
import com.frauddetection.backend.service.FraudDetector;
import com.frauddetection.backend.service.FraudAuditService;
import com.frauddetection.backend.repository.TransactionRepository;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final FraudDetector fraudDetector;
    private final TransactionRepository transactionRepository;
    private final FraudAuditService fraudAuditService;

    public TransactionController(
            FraudDetector fraudDetector,
            TransactionRepository transactionRepository,
            FraudAuditService fraudAuditService) {
        this.fraudDetector = fraudDetector;
        this.transactionRepository = transactionRepository;
        this.fraudAuditService = fraudAuditService;
    }

    @PostMapping("/check")
    public Map<String, Object> checkTransaction(
            @RequestBody Transaction transaction) {

        boolean suspicious = fraudDetector.isSuspicious(transaction);
        String status = suspicious ? "SUSPICIOUS" : "SAFE";

        long id = transactionRepository.save(transaction, status);

        // Run the audit task in a background thread.
        fraudAuditService.auditTransaction(id, status);

        return Map.of(
                "id", id,
                "amount", transaction.getAmount(),
                "type", transaction.getType(),
                "location", transaction.getLocation(),
                "status", status,
                "message", suspicious
                        ? "High-value transaction flagged for review"
                        : "No suspicious activity detected"
        );
    }

    @GetMapping
    public List<Map<String, Object>> getAllTransactions() {
        return transactionRepository.findAll();
    }
}

