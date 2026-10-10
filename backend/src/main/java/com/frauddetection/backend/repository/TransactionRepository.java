package com.frauddetection.backend.repository;

import com.frauddetection.backend.model.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionRepository {

    private final JdbcTemplate jdbcTemplate;

    public TransactionRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public long save(Transaction transaction, String status) {
        String sql = """
            INSERT INTO transactions
            (amount, type, location, status)
            VALUES (?, ?, ?, ?)
            """;

        jdbcTemplate.update(
            sql,
            transaction.getAmount(),
            transaction.getType(),
            transaction.getLocation(),
            status
        );

        return jdbcTemplate.queryForObject(
            "SELECT LAST_INSERT_ID()",
            Long.class
        );
    }
}
