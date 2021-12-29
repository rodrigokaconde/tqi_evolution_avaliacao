package br.com.rfoliveira.clientapi.model.response;

import lombok.Data;

@Data
public class LoanClientResponse {
    Integer id;
    float value;
    int installment;
}
