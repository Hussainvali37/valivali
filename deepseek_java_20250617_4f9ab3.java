package com.example.crypto.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Investment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount; // USDT
    private double returnAmount; // Calculated return
    private LocalDateTime investmentDate;
    private LocalDateTime dueDate;
    private boolean processed = false; // True after 48hrs

    @ManyToOne
    private User user;
}