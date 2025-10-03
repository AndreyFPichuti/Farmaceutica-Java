
package farmaceutica;

import java.util.ArrayList;

public class Medico {

    private String email;
    private String senha;
    private ArrayList<Paciente> pacientes;
    
    public Medico(String email, String senha) {
        this.email = email;
        this.senha = senha;
        pacientes = new ArrayList();
    }
    public Medico(){
    
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public ArrayList getPacientes() {
        return pacientes;
    }
    
    public void adicionaPaciente(Paciente paciente) {
        this.pacientes.add(paciente);
    }
}
