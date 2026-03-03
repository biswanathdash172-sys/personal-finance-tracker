package com.finance.tracker.service;

import com.finance.tracker.model.Transaction;
import com.finance.tracker.model.TransactionType;
import com.finance.tracker.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    /** Save a new transaction */
    public Transaction save(Transaction transaction) {
        return repository.save(transaction);
    }

    /** Retrieve all transactions, newest first */
    public List<Transaction> findAll() {
        return repository.findAllByOrderByDateDesc();
    }

    /** Delete a transaction by id */
    public void delete(Long id) {
        repository.deleteById(id);
    }

    // ─── Monthly summary helpers ─────────────────────────────────────────────────

    public BigDecimal getMonthlyIncome(int month, int year) {
        return repository.sumByTypeAndMonth(TransactionType.INCOME, month, year);
    }

    public BigDecimal getMonthlyExpenses(int month, int year) {
        return repository.sumByTypeAndMonth(TransactionType.EXPENSE, month, year);
    }

    public BigDecimal getMonthlyBalance(int month, int year) {
        return getMonthlyIncome(month, year).subtract(getMonthlyExpenses(month, year));
    }

    /** Convenience: current month/year */
    public int currentMonth() { return LocalDate.now().getMonthValue(); }
    public int currentYear()  { return LocalDate.now().getYear(); }
    public String currentMonthName() {
        return LocalDate.now().getMonth().getDisplayName(
                java.time.format.TextStyle.FULL, java.util.Locale.ENGLISH);
    }
}
