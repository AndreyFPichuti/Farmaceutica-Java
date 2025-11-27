package farmaceutica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoBD {

    private static final Logger LOGGER = Logger.getLogger(ConexaoBD.class.getName());

    public static Connection getConnection() throws SQLException {
        String driver = EnvLoader.get("DB_DRIVER");
        String url = EnvLoader.get("DB_URL");
        String user = EnvLoader.get("DB_USER");
        String password = EnvLoader.get("DB_PASSWORD");

        if (driver == null || url == null || user == null || password == null) {
            LOGGER.severe("Falha ao carregar variáveis do arquivo .env");
            throw new SQLException("Credenciais do banco não encontradas no .env");
        }

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Driver JDBC não encontrado: {0}", e.getMessage());
            throw new SQLException("Driver JDBC não encontrado", e);
        }

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao conectar ao banco de dados: {0}", e.getMessage());
            throw e;
        }
    }
}
