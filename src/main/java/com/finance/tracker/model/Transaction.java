package com.finance.tracker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be positive")
    @Column(nullable = false)
    private BigDecimal amount;

    @NotNull(message = "Type is required")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType type;

    @NotNull(message = "Category is required")
    @Column(nullable = false)
    private String category;

    @NotNull(message = "Date is required")
    @Column(nullable = false)
    private LocalDate date;

    @Column
    private String note;

    // ─── Constructors ────────────────────────────────────────────────────────────

    public Transaction() {}

    public Transaction(BigDecimal amount, TransactionType type, String category,
                       LocalDate date, String note) {
        this.amount   = amount;
        this.type     = type;
        this.category = category;
        this.date     = date;
        this.note     = note;
    }

    // ─── Getters & Setters ───────────────────────────────────────────────────────

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public TransactionType getType() { return type; }
    public void setType(TransactionType type) { this.type = type; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
}
