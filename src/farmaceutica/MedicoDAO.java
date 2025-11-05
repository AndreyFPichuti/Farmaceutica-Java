package farmaceutica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe DAO responsável pelas operações de persistência do Médico.
 * Aplicação dos princípios de Clean Code: SRP, DRY, KISS e boas práticas de SQL.
 */
public class MedicoDAO {

    /**
     * Insere um novo médico no banco de dados.
     * @param medico objeto com os dados a serem cadastrados
     * @return true se o cadastro foi realizado com sucesso
     */
    public boolean insert(Medico medico) {
        String sql = "INSERT INTO Medico (email, senha) VALUES (?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, medico.getEmail());
            ps.setString(2, medico.getSenha());
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Erro ao inserir médico: " + e.getMessage());
            return false;
        }
    }

    /**
     * Realiza o login de um médico.
     * @param medico objeto contendo e-mail e senha
     * @return true se as credenciais forem válidas
     */
    public boolean login(Medico medico) {
        String sql = "SELECT * FROM Medico WHERE email = ? AND senha = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, medico.getEmail());
            ps.setString(2, medico.getSenha());

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException e) {
            System.err.println("Erro ao realizar login: " + e.getMessage());
            return false;
        }
    }
}
