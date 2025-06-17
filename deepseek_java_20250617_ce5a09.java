package com.example.crypto.controller;

import com.example.crypto.model.Investment;
import com.example.crypto.service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/investments")
public class InvestmentController {
    private static final double MIN_INVESTMENT = 100.0; // 100 USDT minimum

    @Autowired
    private InvestmentService investmentService;

    @PostMapping
    public ResponseEntity<?> createInvestment(@RequestBody Investment investment) {
        if (investment.getAmount() < MIN_INVESTMENT) {
            return ResponseEntity
                .badRequest()
                .body("Minimum investment is 100 USDT");
        }

        Investment created = investmentService.createInvestment(investment);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
}