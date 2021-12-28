package br.com.rfoliveira.clientapi.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false, unique = true)
    private String rg;

    @Column(nullable = false)
    private float remuneration;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String number;

}
