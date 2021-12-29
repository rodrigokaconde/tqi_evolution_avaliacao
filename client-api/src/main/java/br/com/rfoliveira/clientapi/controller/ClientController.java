package br.com.rfoliveira.clientapi.controller;

import br.com.rfoliveira.clientapi.model.Client;
import br.com.rfoliveira.clientapi.model.response.LoanClientResponse;
import br.com.rfoliveira.clientapi.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping
    public Client registerClient (@RequestBody @Valid Client client){

        return clientService.registerClient(client);
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

    @GetMapping("/loans/{id}")
    public ResponseEntity<List<LoanClientResponse>> listLoanClient (@PathVariable Integer id){
        return clientService.listLoanClient(id);

    }

    @GetMapping("/login")
    public ResponseEntity<Boolean> loginClient (@RequestParam String email, @RequestParam String password){
        return clientService.loginClient(email, password);
    }

}
