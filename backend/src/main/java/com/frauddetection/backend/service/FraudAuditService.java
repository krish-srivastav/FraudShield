
package com.frauddetection.backend.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class FraudAuditService {

    private final ExecutorService executor =
            Executors.newSingleThreadExecutor();

    public void auditTransaction(long transactionId, String status) {
        executor.submit(() -> {
            System.out.println(
                    "Background audit: Transaction ID = "
                    + transactionId
                    + ", Status = "
                    + status
                    + ", Thread = "
                    + Thread.currentThread().getName()
            );
        });
    }
}

