
package farmaceutica;

import java.util.ArrayList;

public class Paciente {
   
    private String nome;
    private String cpf;
    private Medico medico;
    private int IdMedico;
    private ArrayList<Remedio> remedios;

    public Paciente(String nome, String cpf, int IdMedico, Medico medico) {
        this.nome = nome;
        this.cpf = cpf;
        this.IdMedico = IdMedico;
        this.medico = medico;
        remedios = new ArrayList();
    }

    public int getIdMedico() {
        return IdMedico;
    }

    public void setIdMedico(int IdMedico) {
        this.IdMedico = IdMedico;
    }
    
    public Paciente(){
    
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }   

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    
    public ArrayList getRemedios() {
        return remedios;
    }
    
    public void adiciona(Remedio remedio) {
        this.remedios.add(remedio);
    }
}
