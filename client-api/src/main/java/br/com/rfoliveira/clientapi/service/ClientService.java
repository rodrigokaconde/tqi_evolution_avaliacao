package br.com.rfoliveira.clientapi.service;

import br.com.rfoliveira.clientapi.model.Client;
import br.com.rfoliveira.clientapi.model.Loan;
import br.com.rfoliveira.clientapi.model.response.LoanClientResponse;
import br.com.rfoliveira.clientapi.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final PasswordEncoder encoder;
    @Autowired
    public ClientService(ClientRepository clientRepository, PasswordEncoder encoder){
        this.clientRepository = clientRepository;
        this.encoder = encoder;
    }

    public Client registerClient (Client client){
        client.setPassword(encoder.encode(client.getPassword()));
        return clientRepository.save(client);
    }

    public ResponseEntity<List<LoanClientResponse>> listLoanClient(Integer id) {
        List<Loan> loansClient = clientRepository.findById(id).get().getLoan();
        List<LoanClientResponse> loansResponse = new ArrayList<>();

        for(Loan loanIterator : loansClient){
            LoanClientResponse loanResponse = new LoanClientResponse();
            loanResponse.setId(loanIterator.getId());
            loanResponse.setValue(loanIterator.getValue());
            loanResponse.setInstallment(loanIterator.getInstallment());
            loansResponse.add(loanResponse);
        }
        if(!loansClient.isEmpty())
            return ResponseEntity.ok().body(loansResponse);
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Boolean> loginClient(String email, String password) {
        Optional<Client> findClient = clientRepository.findByEmail(email);
        if(findClient.isEmpty()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }

        Boolean valid = encoder.matches(password, findClient.get().getPassword());
        HttpStatus status = valid ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(status).body(valid);
    }
}
