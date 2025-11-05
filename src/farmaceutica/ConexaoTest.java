package farmaceutica;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;

public class ConexaoTest {
    
    private static final Logger LOGGER = Logger.getLogger(ConexaoBD.class.getName());
    
    public static void main(String[] args) {
        try (Connection conn = ConexaoBD.getConnection()) {
            LOGGER.info("Conectado ao banco de dados MySQL!");

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao conectar ao banco de dados: " + e.getMessage(), e);
        }
    } 
}
