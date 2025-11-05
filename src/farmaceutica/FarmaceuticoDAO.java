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
 * @author Andrey
 */
public class FarmaceuticoDAO {
    
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

public boolean LoginFarmaceutico(Farmaceutico farmaceutico) {
    String sql = "SELECT * FROM Farmaceutico WHERE email = ? AND senha = ?";
    Connection c = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        c = ConexaoBD.getConnection();
        ps = c.prepareStatement(sql);

        ps.setString(1, farmaceutico.getEmail());
        ps.setString(2, farmaceutico.getSenha());

        rs = ps.executeQuery();

        if (rs.next()) {
            JOptionPane.showMessageDialog(null, "Login realizado com sucesso");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "E-mail ou senha incorretos!");
            return false;
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao realizar login!");
        e.printStackTrace();
        return false;
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (c != null) c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

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
        e.printStackTrace();
    }
}

public void GerarRelatorio(Paciente paciente, RetornoRelatorio retorno){
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
        e.printStackTrace();
    }
}
}