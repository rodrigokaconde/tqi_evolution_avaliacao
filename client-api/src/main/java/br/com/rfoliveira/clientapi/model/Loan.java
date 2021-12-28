package br.com.rfoliveira.clientapi.model;

import br.com.rfoliveira.clientapi.validation.DateFirstLoan;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
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

    @Min(value = 0)
    private float value;

    private LocalDate requestDate;

    @DateFirstLoan
    private LocalDate firstInstallmentDate;

    @Min(value = 1, message = "invalid value")
    @Max(value = 60, message = "invalid value")
    private int installment;

}
