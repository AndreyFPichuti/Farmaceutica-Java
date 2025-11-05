/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmaceutica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 * 
 * Classe DAO responsável pelas operações de persistência do Farmacêutico
 * Aplicação dos princípios de Clean Code: SRP, DRY, KISS e boas práticas de SQL
 */
public class FarmaceuticoDAO {
    
    /**
     * Insere um novo farmacêutico no banco de dados
     * @param farmaceutico objeto com os dados a serem cadastrados
     * @return true se o cadastro foi realizado com sucesso
     */
    public boolean insert(Farmaceutico farmaceutico) {
        String sql = "INSERT INTO Farmaceutico (email, senha) VALUES (?, ?)";
        try (Connection conn = ConexaoBD.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {

         ps.setString(1, farmaceutico.getEmail());
         ps.setString(2, farmaceutico.getSenha());
         ps.executeUpdate();
         return true;

        } catch (SQLException e) {
        System.err.println("Erro ao inserir farmacêutico: " + e.getMessage());
        return false;
        }
    }

    /**
     * Realiza o login do farmacêutico
     * @param farmaceutico objeto contendo e-mail e senha
     * @return true se as credenciais forem válidas
     */
    public boolean login(Farmaceutico farmaceutico) {
    String sql = "SELECT * FROM Farmaceutico WHERE email = ? AND senha = ?";

    try (Connection conn = ConexaoBD.getConnection();
    PreparedStatement ps = conn.prepareStatement(sql)) {
         ps.setString(1, farmaceutico.getEmail());
         ps.setString(2, farmaceutico.getSenha());

         try (ResultSet rs = ps.executeQuery()) {
             return rs.next();
         }

        } catch (SQLException e) {
        System.err.println("Erro ao realizar login: " + e.getMessage());
        return false;
        }
    }

    /**
     * Busca remédios de acordo com nome ou indicações
     * @param remedio objeto contendo os critérios de pesquisa
     * @param retorno objeto responsável por exibir os resultados
     */
    public void PesquisarRemedio(Remedio remedio, RetornoPesquisaRemedio retorno) {
    String sql = "SELECT * FROM remedio WHERE nome LIKE ? OR indicacoes LIKE ?";

    try (Connection connection = ConexaoBD.getConnection();
         PreparedStatement ps = connection.prepareStatement(sql)) {

        ps.setString(1, "%" + remedio.getNome() + "%");
        ps.setString(2, "%" + remedio.getIndicacoes() + "%");

        try (ResultSet resultSet = ps.executeQuery()) {
            DefaultTableModel dtmRemedio = (DefaultTableModel) retorno.TabelaRemedio.getModel();

            while (resultSet.next()) {
                Remedio r = new Remedio();
                r.setIdRemedio(resultSet.getInt("idRemedio"));
                r.setIdFarmaceutico(resultSet.getInt("Farmaceutico_idFarmaceutico"));
                r.setNome(resultSet.getString("nome"));
                r.setEstoque(resultSet.getInt("estoque"));
                r.setViaMedicacao(resultSet.getString("via_medicacao"));
                r.setIndicacoes(resultSet.getString("indicacoes"));
                r.setContraindicacoes(resultSet.getString("contraindicacoes"));
                r.setEfeitosColaterais(resultSet.getString("efeitos_colaterais"));
                r.setFormaFarmaceutica(resultSet.getString("forma_farmaceutica"));
                r.setPrincipalAtivo(resultSet.getString("principal_ativo"));
                r.setValidade(resultSet.getString("validade"));

                Object[] dadosRemedio = {
                    r.getNome(),
                    r.getEstoque(),
                    r.getViaMedicacao(),
                    r.getIndicacoes(),
                    r.getContraindicacoes(),
                    r.getEfeitosColaterais(),
                    r.getFormaFarmaceutica(),
                    r.getPrincipalAtivo(),
                    r.getValidade()
                };

                dtmRemedio.addRow(dadosRemedio);
            }
        }
    } catch (SQLException e) {
        System.err.println("Erro ao buscar remédios: " + e.getMessage());
    }
}
    
    /**
     * Gera relatório de pacientes cadastrados
     * @param retorno componente gráfico para exibição da tela
     */
    public void GerarRelatorio(RetornoRelatorio retorno){
        String sql = "SELECT * FROM Paciente";

        try (Connection connection = ConexaoBD.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {



            try (ResultSet resultSet = ps.executeQuery()) {
                DefaultTableModel dtmPaciente = (DefaultTableModel) retorno.TabelaRelatorio.getModel();

                while (resultSet.next()) {
                    Paciente p = new Paciente();
                    p.setNome(resultSet.getString("Nome"));
                    p.setCpf(resultSet.getString("Cpf"));


                    Object[] dadosPaciente = {
                        p.getNome(),
                        p.getCpf(),

                    };

                    dtmPaciente.addRow(dadosPaciente);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao gerar relatório de pacientes: " + e.getMessage());
        }
    }
}