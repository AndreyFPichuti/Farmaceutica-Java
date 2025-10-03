package farmaceutica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; // Classe do driver atualizada
    private static final String URL = "jdbc:mysql://localhost:3306/Farmaceutica?serverTimezone=America/Sao_Paulo";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234"; // Considere usar um mecanismo mais seguro para armazenar senhas

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Erro: Classe do driver não encontrada: " + e.getMessage());
            throw new SQLException("Driver não encontrado", e); // Lança uma SQLException com a causa original
        } catch (SQLException e) {
            System.out.println("Erro: Não foi possível conectar ao banco de dados: " + e.getMessage());
            throw e; // Re-lança a exceção para tratamento adequado
        }
    }

    public static void main(String[] args) {
        try (Connection conn = ConexaoBD.getConnection()) {
            System.out.println("Conectado ao banco de dados MySQL!");

            // Suas operações de banco de dados aqui usando o objeto 'conn'

        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
}
