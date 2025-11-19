/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmaceutica;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrey
 */
public class PacienteDAO {
    //public void solicitarRemedio()
    public void insert(Paciente paciente){
 
    String sql = "INSERT INTO Paciente (Medico_idMedico, nome,cpf) VALUES ("
    +paciente.getIdMedico() + ",'"
    +paciente.getNome() + "','"
    +paciente.getCpf() + "')";
     
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
     } 
    }
    public void VerificaMedico(Medico medico) throws SQLException{
    Connection con = ConexaoBD.getConnection();
    RegistroPaciente registropaciente = new RegistroPaciente();
        int idMedico = Integer.parseInt(registropaciente.TextIdMedico.getText());
        String sql = "SELECT * FROM Medico where idMedico = ?";
        
          try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, idMedico);
           
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
    public boolean LoginPaciente(Paciente paciente) {
    String sql = "SELECT * FROM Paciente WHERE nome = ? AND cpf = ?";
    Connection c = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        c = ConexaoBD.getConnection();
        ps = c.prepareStatement(sql);

        ps.setString(1, paciente.getNome());
        ps.setString(2, paciente.getCpf());

        rs = ps.executeQuery();

        if (rs.next()) {
            JOptionPane.showMessageDialog(null, "Login realizado com sucesso");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Nome ou CPF incorretos!");
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

}
