package com.example.demo.domain;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Livro {

    @Id
    private Long id;
    private String titulo;
    private String autor;
    private Date dataPublicacao;
    private String editora;

}
