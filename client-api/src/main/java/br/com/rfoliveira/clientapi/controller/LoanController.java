package br.com.rfoliveira.clientapi.controller;

import br.com.rfoliveira.clientapi.model.response.DetailLoan;
import br.com.rfoliveira.clientapi.model.Loan;
import br.com.rfoliveira.clientapi.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/loan")
public class LoanController {

    @Autowired
    LoanService loanService;

    @PostMapping
    public Loan registerLoan (@RequestBody @Valid Loan loan){
        return loanService.registerLoan(loan);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> validationException(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            errors.put(((FieldError)error).getField(), error.getDefaultMessage());
        });
        return errors;
    }

    @GetMapping("{id}")
    public ResponseEntity<DetailLoan> loanDetails(@PathVariable Integer id){
        return loanService.loanDetails(id);
    }

}
