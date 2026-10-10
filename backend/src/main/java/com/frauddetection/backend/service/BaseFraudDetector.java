
package com.frauddetection.backend.service;

public abstract class BaseFraudDetector implements FraudDetector {

    protected boolean isHighValue(double amount) {
        return amount > 50000;
    }
}
