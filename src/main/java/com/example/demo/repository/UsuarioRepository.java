package com.example.demo.repository;

import com.example.demo.configs.Conexao;
import com.example.demo.domain.Livro;
import com.example.demo.domain.Usuario;
import org.springframework.stereotype.Repository;

import java.sql.*;
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

    public void inserir(Usuario usuario) throws SQLException {
        Connection conn = Conexao.conectar();
        String sql = "INSERT INTO USUARIO (cpf, nome, login, senha) VALUES (?, ?, ?, ?)";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, usuario.getCpf());
        stmt.setString(2, usuario.getNome());
        stmt.setString(3, usuario.getLogin());
        stmt.setString(4, usuario.getSenha());

        stmt.execute();
        stmt.close();
        Conexao.desconectar();
    }
}
