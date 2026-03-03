package com.finance.tracker.controller;

import com.finance.tracker.model.Transaction;
import com.finance.tracker.model.TransactionType;
import com.finance.tracker.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Controller
public class TransactionController {

    private static final List<String> CATEGORIES =
            Arrays.asList("Food", "Transport", "Shopping", "Health", "Entertainment", "Other");

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    // ─── Home Page ───────────────────────────────────────────────────────────────

    @GetMapping("/")
    public String home(Model model) {
        int month = service.currentMonth();
        int year  = service.currentYear();

        model.addAttribute("transactions",    service.findAll());
        model.addAttribute("monthlyIncome",   service.getMonthlyIncome(month, year));
        model.addAttribute("monthlyExpenses", service.getMonthlyExpenses(month, year));
        model.addAttribute("monthlyBalance",  service.getMonthlyBalance(month, year));
        model.addAttribute("currentMonth",    service.currentMonthName());
        model.addAttribute("currentYear",     year);

        return "index";
    }

    // ─── Add Transaction ─────────────────────────────────────────────────────────

    @GetMapping("/add")
    public String showAddForm(Model model) {
        Transaction transaction = new Transaction();
        transaction.setDate(LocalDate.now());  // pre-fill today's date
        model.addAttribute("transaction", transaction);
        model.addAttribute("categories", CATEGORIES);
        model.addAttribute("types", TransactionType.values());
        return "add";
    }

    @PostMapping("/add")
    public String addTransaction(@Valid @ModelAttribute("transaction") Transaction transaction,
                                 BindingResult result,
                                 Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categories", CATEGORIES);
            model.addAttribute("types", TransactionType.values());
            return "add";
        }
        service.save(transaction);
        return "redirect:/";
    }

    // ─── Delete Transaction ──────────────────────────────────────────────────────

    @PostMapping("/delete/{id}")
    public String deleteTransaction(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/";
    }
}
