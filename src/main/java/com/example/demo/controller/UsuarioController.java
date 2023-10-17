package com.example.demo.controller;

import com.example.demo.domain.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/")
    public String cadastrar() {
       return "cadastro_usuario";
    }

    @PostMapping("/cadastrar")
    public void inserir(Usuario usuario) throws SQLException {
        usuarioRepository.inserir(usuario);
        listar();
    }

    @GetMapping("/listar")
    public ModelAndView listar() throws SQLException {
        ModelAndView mv = new ModelAndView("lista_usuario");
        mv.addObject("usuarios", usuarioRepository.listar());
        return mv;
    }

}
