package com.example.crypto.service;

import com.example.crypto.model.Investment;
import com.example.crypto.repository.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvestmentService {
    private static final double RETURN_RATE = 1.5; // 150% returns

    @Autowired
    private InvestmentRepository investmentRepository;

    public Investment createInvestment(Investment investment) {
        // Set investment timestamps
        investment.setInvestmentDate(LocalDateTime.now());
        investment.setDueDate(LocalDateTime.now().plusHours(48));
        return investmentRepository.save(investment);
    }

    public void processReturns(Investment investment) {
        investment.setReturnAmount(investment.getAmount() * RETURN_RATE);
        investment.setProcessed(true);
        investmentRepository.save(investment);
    }
}