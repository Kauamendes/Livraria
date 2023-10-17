package com.example.demo.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static Connection connection;

    public static synchronized Connection conectar() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/livraria",
                    System.getenv("DATABASE_USERNAME"),
                    System.getenv("DATABASE_PASSWORD")
            );
        }

        return connection;
    }

    public static void desconectar() throws SQLException {
        if (connection != null) {
            connection.close();
            connection = null;
        }
    }

}
