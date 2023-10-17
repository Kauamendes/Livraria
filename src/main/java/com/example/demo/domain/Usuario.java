package com.example.demo.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder
public class Usuario {

    @Id
    private Long id;
    private String cpf;
    private String nome;
    private String login;
    private String senha;
}
