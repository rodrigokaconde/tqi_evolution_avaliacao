package br.com.rfoliveira.clientapi.service;

import br.com.rfoliveira.clientapi.model.Client;
import br.com.rfoliveira.clientapi.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
