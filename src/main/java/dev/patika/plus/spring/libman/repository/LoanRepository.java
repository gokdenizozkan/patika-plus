package dev.patika.plus.spring.libman.repository;

import dev.patika.plus.spring.libman.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

}
