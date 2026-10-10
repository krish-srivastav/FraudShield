package com.frauddetection.backend.service;

import com.frauddetection.backend.model.Transaction;

public interface FraudDetector {
    boolean isSuspicious(Transaction transaction);
}
