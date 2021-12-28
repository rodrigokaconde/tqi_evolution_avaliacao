package br.com.rfoliveira.clientapi.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(nullable = false)
    private float value;

    @Column(nullable = false)
    private LocalDate requestDate;

    @Column(nullable = false)
    private LocalDate firstInstallmentDate;

    @Column(nullable = false)
    private int installment;

}
