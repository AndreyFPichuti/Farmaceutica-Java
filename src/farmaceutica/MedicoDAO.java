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
public class MedicoDAO {
    
    //public void ManterPaciente(String nome, String cpf) {}
    public void insert(Medico medico){
        RegistroMedico registromedico = new RegistroMedico();
        
        String sql = "INSERT INTO Medico (email,senha) VALUES ('"
     +medico.getEmail() + "','"
     +medico.getSenha() + "')";
     
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
    
    
    public boolean LoginMedico(Medico medico) {
    String sql = "SELECT * FROM Medico WHERE email = ? AND senha = ?";
    Connection c = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        c = ConexaoBD.getConnection();
        ps = c.prepareStatement(sql);

        ps.setString(1, medico.getEmail());
        ps.setString(2, medico.getSenha());

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

}



