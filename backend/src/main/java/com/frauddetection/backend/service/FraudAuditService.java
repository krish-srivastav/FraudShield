
package com.frauddetection.backend.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class FraudAuditService {

    private final ExecutorService executor =
            Executors.newSingleThreadExecutor();

    private final AtomicInteger auditCount = new AtomicInteger(0);

    public void auditTransaction(long transactionId, String status) {
        executor.submit(() -> {
            int currentCount = auditCount.incrementAndGet();

            System.out.println(
                    "Background audit: Transaction ID = "
                    + transactionId
                    + ", Status = "
                    + status
                    + ", Audit Number = "
                    + currentCount
                    + ", Thread = "
                    + Thread.currentThread().getName()
            );
        });
    }

    public int getAuditCount() {
        return auditCount.get();
    }
}

