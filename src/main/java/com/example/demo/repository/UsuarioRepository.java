package com.example.demo.repository;

import com.example.demo.configs.Conexao;
import com.example.demo.domain.Livro;
import com.example.demo.domain.Usuario;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepository {

    public List<Usuario> listar() throws SQLException {
        Connection conn = Conexao.conectar();
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM USUARIO";
        try {
            Statement stm = conn.createStatement();
            ResultSet resultado = stm.executeQuery(sql);

            while (resultado.next()) {
                Usuario usuario = Usuario.builder().build();
                usuario.setId(resultado.getLong("id"));
                usuario.setCpf(resultado.getString("cpf"));
                usuario.setNome(resultado.getString("nome"));
                usuario.setLogin(resultado.getString("login"));
                usuario.setSenha(resultado.getString("senha"));
                usuarios.add(usuario);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar usuarios: "+e.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return usuarios;
    }

    public void inserir(Usuario usuario) {
    }
}
