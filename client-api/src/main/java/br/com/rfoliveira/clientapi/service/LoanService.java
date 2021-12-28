package br.com.rfoliveira.clientapi.service;

import br.com.rfoliveira.clientapi.model.Loan;
import br.com.rfoliveira.clientapi.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    private final LoanRepository loanRepository;

    @Autowired
    public LoanService (LoanRepository loanRepository){
        this.loanRepository = loanRepository;
    }

    public Loan registerLoan (Loan loan){
        return loanRepository.save(loan);
    }

    public List<Loan> ListLoan (){
        return loanRepository.findBy();
    }

}
