package br.com.rfoliveira.clientapi.model;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "value not informed")
    private String name;

    @NotBlank(message = "value not informed")
    @Email (message = "invalid value")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "value not informed")
    private String password;

    @NotBlank(message = "value not informed")
    @CPF (message = "invalid value")
    @Column(unique = true)
    //@Column(nullable = false, unique = true)
    private String cpf;

    @NotBlank(message = "value not informed")
    @Column(unique = true)
    private String rg;

    @Min(value = 0)
    private float remuneration;

    @NotBlank(message = "value not informed")
    private String street;

    @NotBlank(message = "value not informed")
    private String cep;

    @NotBlank(message = "value not informed")
    private String number;
//trablahando aqui
    //@OneToMany(fetch = FetchType.EAGER, mappedBy = "client", cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "client")
    private List<Loan> loan;

}
