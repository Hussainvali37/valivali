package com.example.crypto.repository;

import com.example.crypto.model.Investment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface InvestmentRepository extends JpaRepository<Investment, Long> {
    List<Investment> findByProcessedFalseAndDueDateBefore(LocalDateTime now);
}