package br.com.rfoliveira.clientapi.service;

import br.com.rfoliveira.clientapi.model.Client;
import br.com.rfoliveira.clientapi.model.Loan;
import br.com.rfoliveira.clientapi.model.response.LoanClientResponse;
import br.com.rfoliveira.clientapi.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService (ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public Client registerClient (Client client){
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
}
