package br.com.rfoliveira.clientapi.repository;

import br.com.rfoliveira.clientapi.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
