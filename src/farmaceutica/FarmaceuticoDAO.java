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
public class FarmaceuticoDAO {
    //public void registrarRemedio() {}
    //public void pesquisarRemedio() {}
    //public void gerarRelatorio() {}
    
    public void insert(Farmaceutico farmaceutico){
        RegistroMedico registromedico = new RegistroMedico();
         
        String sql = "INSERT INTO Farmaceutico (email,senha) VALUES ('"
     +farmaceutico.getEmail() + "','"
     +farmaceutico.getSenha() + "')";
     
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
    }
    

