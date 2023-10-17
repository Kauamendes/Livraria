package com.example.demo.controller;

import com.example.demo.domain.Livro;
import com.example.demo.domain.Usuario;
import com.example.demo.repository.LivroRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/livros")
public class LivroController {

    private final LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @GetMapping("/cadastrar")
    public String cadastrar() {
        return "cadastro_livro";
    }

    @PostMapping("/cadastrar")
    public String inserir(Livro livro) throws SQLException {
        livroRepository.inserir(livro);
        return "redirect:/livros/listar";
    }

    @GetMapping("/listar")
    public ModelAndView listar() throws SQLException {
        ModelAndView mv = new ModelAndView("lista_livro");
        mv.addObject("livros", livroRepository.listar());
        return mv;
    }

}
