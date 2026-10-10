
package com.frauddetection.backend.repository;

import com.frauddetection.backend.model.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

    public List<Map<String, Object>> findAll() {
        String sql = """
            SELECT id, amount, type, location, status, created_at
            FROM transactions
            ORDER BY id DESC
            """;

        return jdbcTemplate.queryForList(sql);
    }
}
