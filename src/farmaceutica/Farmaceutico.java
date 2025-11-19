
package farmaceutica;

import java.util.ArrayList;

public class Farmaceutico {
    private String email;
    private String senha;
    private ArrayList<Remedio> remedios;
    
    public Farmaceutico(String email, String senha) {
        this.email = email;
        this.senha = senha;
        remedios = new ArrayList();
    }
    public Farmaceutico(){
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
    
    public ArrayList getRemedios() {
        return remedios;
    }
    
    public void adicionaRemedio(Remedio remedio) {
        this.remedios.add(remedio);
    }
}
