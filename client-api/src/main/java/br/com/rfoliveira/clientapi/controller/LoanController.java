package br.com.rfoliveira.clientapi.controller;

import br.com.rfoliveira.clientapi.model.Loan;
import br.com.rfoliveira.clientapi.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loan")
public class LoanController {

    @Autowired
    LoanService loanService;

    @PostMapping
    public Loan registerLoan (@RequestBody Loan loan){
        return loanService.registerLoan(loan);
    }

    @GetMapping
    public List<Loan> ListLoan (){
        return loanService.ListLoan();
    }

}
