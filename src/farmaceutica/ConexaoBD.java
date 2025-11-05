package farmaceutica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    
    private static final String DRIVER = EnvLoader.get("DB_DRIVER");
    private static final String URL = EnvLoader.get("DB_URL");
    private static final String USERNAME = EnvLoader.get("DB_USERNAME");
    private static final String PASSWORD = EnvLoader.get("DB_PASSWORD");

    public static Connection getConnection() throws SQLException {
    try {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    } catch (ClassNotFoundException e) {
        throw new SQLException("Driver JDBC não encontrado", e);
    }
}


    
}
