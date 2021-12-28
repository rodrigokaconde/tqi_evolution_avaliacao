package br.com.rfoliveira.clientapi.repository;

import br.com.rfoliveira.clientapi.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Integer> {
}
