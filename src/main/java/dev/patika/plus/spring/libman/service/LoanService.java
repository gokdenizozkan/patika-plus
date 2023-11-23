package dev.patika.plus.spring.libman.service;

import dev.patika.plus.spring.libman.dto.LoanRequest;
import dev.patika.plus.spring.libman.dto.LoanUpdateRequest;
import dev.patika.plus.spring.libman.entity.Loan;
import dev.patika.plus.spring.libman.repository.LoanRepository;
import dev.patika.plus.spring.libman.entity.Book;
import dev.patika.plus.spring.libman.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {
    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final BookService bookService;

    @Autowired
    public LoanService(LoanRepository loanRepository, BookRepository bookRepository, BookService bookService) {
        this.loanRepository = loanRepository;
        this.bookRepository = bookRepository;
        this.bookService = bookService;
    }

    public boolean lendBook(LoanRequest loanRequest) {
        Book book = loanRequest.book();
        if (book.getStock() <= 0) {
            return false;
        }

        book.setStock(book.getStock() - 1);
        bookRepository.save(book);

        Loan loan = new Loan();
        loan.setBorrowerName(loanRequest.borrowerName());
        loan.setBorrowerEmail(loanRequest.borrowerEmail());
        loan.setBorrowingDate(loanRequest.borrowingDate());
        loan.setReturnDate(loanRequest.returnDate());
        loan.setBook(book);
        loanRepository.save(loan);
        return true;
    }

    public Loan update(LoanUpdateRequest loanUpdateRequest) {
        String email = getById(loanUpdateRequest.id())
                .getBorrowerEmail();

        Loan loan = new Loan(
                loanUpdateRequest.id(),
                loanUpdateRequest.borrowerName(),
                email,
                loanUpdateRequest.borrowingDate(),
                loanUpdateRequest.returnDate(),
                loanUpdateRequest.book()
        );

        loanRepository.save(loan);
        return loan;
    }

    public List<Loan> getAll() {
        return loanRepository.findAll();
    }
    public Loan getById(long id) {
        return loanRepository.findById(id).get();
    }
}
