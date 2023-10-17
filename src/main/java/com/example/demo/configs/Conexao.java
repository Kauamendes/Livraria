package com.example.demo.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static Connection connection;

    public static Connection conectar() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/my_database",
                    "postgres",
                    "password"
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
