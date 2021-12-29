package br.com.rfoliveira.clientapi.model.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DetailLoan {

    private Integer id;

    private float value;

    private LocalDate firstInstallmentDate;

    private int installment;

    private String emailClient;

    private float remuneration;
}
