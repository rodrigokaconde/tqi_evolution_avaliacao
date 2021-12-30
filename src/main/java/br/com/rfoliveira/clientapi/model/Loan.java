package br.com.rfoliveira.clientapi.model;

import br.com.rfoliveira.clientapi.validationLoan.DateFirstInstallment;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;

@Data
@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Min(value = 0)
    private float value;

    @DateFirstInstallment
    private LocalDate firstInstallmentDate;

    @Min(value = 1, message = "invalid value")
    @Max(value = 60, message = "invalid value")
    private int installment;

}
