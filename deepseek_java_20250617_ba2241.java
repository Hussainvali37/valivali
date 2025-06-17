package com.example.crypto.scheduler;

import com.example.crypto.model.Investment;
import com.example.crypto.repository.InvestmentRepository;
import com.example.crypto.service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class ReturnCalculationScheduler {
    @Autowired
    private InvestmentRepository investmentRepository;

    @Autowired
    private InvestmentService investmentService;

    // Run every minute to check for due investments (demo only)
    @Scheduled(fixedRate = 60000)
    public void calculateReturns() {
        List<Investment> investments = investmentRepository
            .findByProcessedFalseAndDueDateBefore(LocalDateTime.now());

        for (Investment investment : investments) {
            investmentService.processReturns(investment);
        }
    }
}