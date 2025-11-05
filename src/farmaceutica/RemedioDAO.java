/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmaceutica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andrey
 */
public class RemedioDAO {
    public void insert(Remedio remedio){
        String sql = "INSERT INTO Remedio (Farmaceutico_idFarmaceutico, nome, estoque, via_medicacao, indicacoes, contraindicacoes, efeitos_colaterais, forma_farmaceutica, principal_ativo, validade) VALUES ("
     +remedio.getIdFarmaceutico() + ",'"
     +remedio.getNome() + "',"
     +remedio.getEstoque() + ",'"
     +remedio.getViaMedicacao() + "','"
     +remedio.getIndicacoes() + "','"
     +remedio.getContraindicacoes() + "','"     
     +remedio.getEfeitosColaterais() + "','"
     +remedio.getFormaFarmaceutica() + "','"
     +remedio.getPrincipalAtivo() + "','"
     +remedio.getValidade() + "')";
     
     try {
     Connection c = ConexaoBD.getConnection();
     PreparedStatement ps = c.prepareStatement(sql);
     ps.execute();
     JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
     ps.close();
     c.close();
     } catch (SQLException e) {
     JOptionPane.showMessageDialog(null, "Erros na Transação");
     e.printStackTrace();
     } }
    
    public void VerificaFarmaceutico(Farmaceutico farmaceutico) throws SQLException{
    Connection con = ConexaoBD.getConnection();
    RegistroRemedio registroremedio = new RegistroRemedio();
        int idFarmaceutico = Integer.parseInt(registroremedio.TextIdFarmaceutico.getText());
        String sql = "SELECT * FROM Farmaceutico where idFarmaceutico = ?";
        
          try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, idFarmaceutico);
           
            ResultSet rs = stmt.executeQuery();
            
            /*if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Login successful");
                // Open the next window or perform any action
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password");
            }
            */
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    
    }
    
    public Remedio PedirMedicamento(String nomeRemedio){
    Remedio remedio = null;
    String sql = "SELECT * FROM Remedio WHERE nome = ?";
    Connection c = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    

    try {
        c = ConexaoBD.getConnection();
        ps = c.prepareStatement(sql);
        ps.setString(1, nomeRemedio);

        rs = ps.executeQuery();

        if (rs.next()) {
            JOptionPane.showMessageDialog(null, "Remédio encontrado!");
            remedio = new Remedio();
            remedio.setIdRemedio(rs.getInt("idRemedio"));
            remedio.setNome(rs.getString("nome"));
            remedio.setEstoque(rs.getInt("estoque"));
            
        } else {
            JOptionPane.showMessageDialog(null, "Nome incorreto!");  
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao pesquisar remédio!");
        e.printStackTrace();
        
    }
    finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (c != null) c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return remedio;
    }
    
    public boolean seAtualizar(int idRemedio, int novoEstoque){
        String sql = "UPDATE Remedio SET estoque = ? WHERE idRemedio = ?";
        Connection c = null;
        PreparedStatement ps = null;

        try {
            c = ConexaoBD.getConnection();
            ps = c.prepareStatement(sql);
            ps.setInt(1, novoEstoque);
            ps.setInt(2, idRemedio);

            int colunasAfetadas = ps.executeUpdate();
            return colunasAfetadas > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar a quantidade do remédio!");
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
                if (c != null) c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void AtualizaRemedio(int novoEstoque, int idRemedio){
        String sql = "UPDATE Remedio SET estoque = ? WHERE idRemedio = ?";
        Connection c = null;
        PreparedStatement ps = null;

        try {
            c = ConexaoBD.getConnection();
            ps = c.prepareStatement(sql);
            ps.setInt(1, novoEstoque);
            ps.setInt(2, idRemedio);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar a quantidade do remédio!");
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (c != null) c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void GerarTabela(DefaultTableModel model) {
        String query = "SELECT * FROM Remedio";

        try {
            Connection connection = ConexaoBD.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query); 
             ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Adiciona as colunas ao modelo da tabela
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(metaData.getColumnName(i));
            }

            // Adiciona as linhas ao modelo da tabela
            while (resultSet.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    rowData[i] = resultSet.getObject(i + 1);
                }
                model.addRow(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}