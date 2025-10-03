
package farmaceutica;

import java.util.ArrayList;

public class Farmaceutico {
    private int IdFarmaceutico;
    private String email;
    private String senha;
    private ArrayList<Remedio> remedios;
    
    public Farmaceutico(int IdFarmaceutico, String email, String senha) {
        this.IdFarmaceutico = IdFarmaceutico;
        this.email = email;
        this.senha = senha;
        remedios = new ArrayList();
    }
    public Farmaceutico(){
    }
    
    public String getEmail() {
        return email;
    }

    public int getIdFarmaceutico() {
        return IdFarmaceutico;
    }

    public void setIdFarmaceutico(int IdFarmaceutico) {
        this.IdFarmaceutico = IdFarmaceutico;
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
    
    public ArrayList getRemedios() {
        return remedios;
    }
    
    public void adicionaRemedio(Remedio remedio) {
        this.remedios.add(remedio);
    }
}
