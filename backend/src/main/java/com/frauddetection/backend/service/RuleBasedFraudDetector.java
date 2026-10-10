package com.frauddetection.backend.service;

import com.frauddetection.backend.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class RuleBasedFraudDetector implements FraudDetector {

    @Override
    public boolean isSuspicious(Transaction transaction) {
        return transaction.getAmount() > 50000;
    }
}
