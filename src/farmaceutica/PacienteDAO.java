package farmaceutica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe DAO responsável pelas operações de persistência do Paciente.
 * Aplicação dos princípios de Clean Code: SRP, DRY, KISS e boas práticas de SQL.
 */
public class PacienteDAO {

    /**
     * Insere um novo paciente no banco de dados.
     * @param paciente objeto com os dados a serem cadastrados
     * @return true se o cadastro foi realizado com sucesso
     */
    public boolean insert(Paciente paciente) {
        String sql = "INSERT INTO Paciente (Medico_idMedico, nome, cpf) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, paciente.getIdMedico());
            ps.setString(2, paciente.getNome());
            ps.setString(3, paciente.getCpf());
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Erro ao inserir paciente: " + e.getMessage());
            return false;
        }
    }

    /**
     * Realiza o login de um paciente.
     * @param paciente objeto contendo nome e cpf
     * @return true se as credenciais forem válidas
     */
    public boolean login(Paciente paciente) {
        String sql = "SELECT * FROM Paciente WHERE nome = ? AND cpf = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, paciente.getNome());
            ps.setString(2, paciente.getCpf());

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException e) {
            System.err.println("Erro ao realizar login: " + e.getMessage());
            return false;
        }
    }
}
