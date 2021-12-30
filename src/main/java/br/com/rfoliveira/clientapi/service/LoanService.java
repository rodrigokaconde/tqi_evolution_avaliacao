package br.com.rfoliveira.clientapi.service;

import br.com.rfoliveira.clientapi.model.response.DetailLoan;
import br.com.rfoliveira.clientapi.model.Loan;
import br.com.rfoliveira.clientapi.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


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


    public ResponseEntity<DetailLoan> loanDetails(Integer id) {
        Optional<Loan> loan = loanRepository.findById(id);
        DetailLoan detailLoan = new DetailLoan();
        if(loan.isPresent()){
            detailLoan.setId(loan.get().getId());
            detailLoan.setInstallment(loan.get().getInstallment());
            detailLoan.setValue(loan.get().getValue());
            detailLoan.setFirstInstallmentDate(loan.get().getFirstInstallmentDate());
            detailLoan.setEmailClient(loan.get().getClient().getEmail());
            detailLoan.setRemuneration(loan.get().getClient().getRemuneration());
            return ResponseEntity.ok().body(detailLoan);
        }else
            return ResponseEntity.notFound().build();

    }
}
