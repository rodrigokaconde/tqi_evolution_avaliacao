package br.com.rfoliveira.clientapi.controller;

import br.com.rfoliveira.clientapi.model.Client;
import br.com.rfoliveira.clientapi.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping
    public Client registerClient (@RequestBody Client client){
        return clientService.registerClient(client);
    }
}
