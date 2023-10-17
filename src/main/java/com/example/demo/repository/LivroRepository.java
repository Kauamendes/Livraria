package com.example.demo.repository;

import com.example.demo.configs.Conexao;
import com.example.demo.domain.Livro;
import com.example.demo.domain.Usuario;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LivroRepository {

    public List<Livro> listar() throws SQLException {
        Connection conn = Conexao.conectar();
        List<Livro> livros = new ArrayList<>();
        String sql = "SELECT * FROM LIVRO";
        try {
            Statement stm = conn.createStatement();
            ResultSet resultado = stm.executeQuery(sql);

            while (resultado.next()) {
                Livro livro = Livro.builder().build();
                livro.setId(resultado.getLong("id"));
                livro.setTitulo(resultado.getString("titulo"));
                livro.setAutor(resultado.getString("autor"));
                livros.add(livro);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar livros: "+e.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return livros;
    }

    public void inserir(Livro livro) throws SQLException {
        Connection conn = Conexao.conectar();
        String sql = "INSERT INTO LIVRO (titulo, autor, data_publicacao, editora) VALUES (?, ?, ?, ?)";
        Date dataPublicacao = new Date(livro.getDataPublicacao().getTime());

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, livro.getTitulo());
        stmt.setString(2, livro.getAutor());
        stmt.setDate(3, dataPublicacao);
        stmt.setString(4, livro.getEditora());

        stmt.execute();
        stmt.close();
        Conexao.desconectar();
    }
}
