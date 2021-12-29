package br.com.rfoliveira.clientapi.repository;

import br.com.rfoliveira.clientapi.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    public Optional<Client> findByEmail(String email);
}
