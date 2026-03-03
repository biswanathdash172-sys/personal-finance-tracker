package com.finance.tracker.repository;

import com.finance.tracker.model.Transaction;
import com.finance.tracker.model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    /** All transactions ordered newest first */
    List<Transaction> findAllByOrderByDateDesc();

    /** Sum of amounts for a given type and month/year */
    @Query("SELECT COALESCE(SUM(t.amount), 0) FROM Transaction t " +
           "WHERE t.type = :type " +
           "AND MONTH(t.date) = :month " +
           "AND YEAR(t.date) = :year")
    BigDecimal sumByTypeAndMonth(@Param("type") TransactionType type,
                                 @Param("month") int month,
                                 @Param("year") int year);
}
