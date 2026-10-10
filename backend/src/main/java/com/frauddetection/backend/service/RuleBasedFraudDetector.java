
package com.frauddetection.backend.service;

import com.frauddetection.backend.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class RuleBasedFraudDetector extends BaseFraudDetector {

    @Override
    public boolean isSuspicious(Transaction transaction) {
        return isHighValue(transaction.getAmount());
    }
}
