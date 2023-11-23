package dev.patika.plus.spring.libman.controller;

import dev.patika.plus.spring.libman.dto.LoanRequest;
import dev.patika.plus.spring.libman.dto.LoanUpdateRequest;
import dev.patika.plus.spring.libman.entity.Loan;
import dev.patika.plus.spring.libman.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {
    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }
    @PostMapping("/lend-book")
    String lendBook(@Valid LoanRequest loanRequest) {
        boolean success = loanService.lendBook(loanRequest);
        if (success) return "Book lent successfully";
        else return "Book could not be lent, not enough stock";
    }

    @GetMapping("/{id}")
    ResponseEntity<Loan> getLoan(@PathVariable long id) {
        Loan loan = loanService.getById(id);
        if (loan == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(loan);
    }

    @GetMapping
    ResponseEntity<List<Loan>> getLoans() {
        List<Loan> loans = loanService.getAll();
        return ResponseEntity.ok(loans);
    }

    @PutMapping("/update")
    ResponseEntity<Loan> updateLoan(@Valid @RequestBody LoanUpdateRequest loanUpdateRequest) {
        Loan loan = loanService.update(loanUpdateRequest);
        if (loan == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(loan);
    }


}
