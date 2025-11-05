package farmaceutica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 * Classe DAO responsável pelas operações de persistência do Remédio.
 * Aplicação dos princípios de Clean Code: SRP, DRY, KISS e boas práticas de SQL.
 */
public class RemedioDAO {

    /**
     * Insere um novo remédio no banco de dados.
     * @param remedio objeto com os dados a serem cadastrados
     * @return true se o cadastro foi realizado com sucesso
     */
    public boolean insert(Remedio remedio) {
        String sql = "INSERT INTO Remedio (Farmaceutico_idFarmaceutico, nome, estoque, via_medicacao, indicacoes, contraindicacoes, efeitos_colaterais, forma_farmaceutica, principal_ativo, validade) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, remedio.getIdFarmaceutico());
            ps.setString(2, remedio.getNome());
            ps.setInt(3, remedio.getEstoque());
            ps.setString(4, remedio.getViaMedicacao());
            ps.setString(5, remedio.getIndicacoes());
            ps.setString(6, remedio.getContraindicacoes());
            ps.setString(7, remedio.getEfeitosColaterais());
            ps.setString(8, remedio.getFormaFarmaceutica());
            ps.setString(9, remedio.getPrincipalAtivo());
            ps.setString(10, remedio.getValidade());
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Erro ao inserir remédio: " + e.getMessage());
            return false;
        }
    }

    /**
     * Atualiza o estoque de um remédio.
     * @param idRemedio identificador do remédio
     * @param novoEstoque nova quantidade em estoque
     * @return true se o estoque foi atualizado com sucesso
     */
    public boolean atualizarEstoque(int idRemedio, int novoEstoque) {
        String sql = "UPDATE Remedio SET estoque = ? WHERE idRemedio = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, novoEstoque);
            ps.setInt(2, idRemedio);
            int linhasAfetadas = ps.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar estoque do remédio: " + e.getMessage());
            return false;
        }
    }

    /**
     * Busca um remédio pelo nome.
     * @param nomeRemedio nome do remédio a ser pesquisado
     * @return objeto Remedio encontrado ou null se não encontrado
     */
    public Remedio buscarPorNome(String nomeRemedio) {
        String sql = "SELECT * FROM Remedio WHERE nome = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nomeRemedio);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Remedio remedio = new Remedio();
                    remedio.setIdRemedio(rs.getInt("idRemedio"));
                    remedio.setNome(rs.getString("nome"));
                    remedio.setEstoque(rs.getInt("estoque"));
                    return remedio;
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar remédio: " + e.getMessage());
        }
        return null;
    }

    /**
     * Lista todos os remédios e preenche uma tabela.
     * @param model modelo da tabela a ser preenchido
     */
    public void listarRemedios(DefaultTableModel model) {
        String sql = "SELECT * FROM Remedio";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            int columnCount = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    rowData[i] = rs.getObject(i + 1);
                }
                model.addRow(rowData);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar remédios: " + e.getMessage());
        }
    }
}
