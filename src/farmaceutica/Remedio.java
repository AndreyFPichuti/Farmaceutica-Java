
package farmaceutica;

import java.util.Date;
import java.util.ArrayList;

public class Remedio {
    private int IdFarmaceutico;
    private int IdRemedio;
    private String nome;
    private int estoque;
    private String viaMedicacao;
    private String indicacoes;
    private String contraindicacoes;
    private String principalAtivo;
    private String efeitosColaterais;
    private String formaFarmaceutica;
    private String validade;
    private Farmaceutico farmaceutico;
    private ArrayList<Paciente> pacientes;
    
    public Remedio(int IdFarmaceutico, int IdRemedio, String nome, int estoque, String viaMedicacao, String indicacoes, String contraindicacoes, String principalAtivo, String efeitosColaterais, String formaFarmaceutica, String validade, Farmaceutico farmaceutico) {
        this.IdFarmaceutico = IdFarmaceutico;
        this.IdRemedio = IdRemedio;
        this.nome = nome;
        this.estoque = estoque;
        this.viaMedicacao = viaMedicacao;
        this.indicacoes = indicacoes;
        this.contraindicacoes = contraindicacoes;
        this.principalAtivo = principalAtivo;
        this.efeitosColaterais = efeitosColaterais;
        this.formaFarmaceutica = formaFarmaceutica;
        this.validade = validade;
        this.farmaceutico = farmaceutico;
        pacientes = new ArrayList();
    }
    
    public Remedio() {}

    public int getIdFarmaceutico() {
        return IdFarmaceutico;
    }

    public void setIdFarmaceutico(int IdFarmaceutico) {
        this.IdFarmaceutico = IdFarmaceutico;
    }
    
     public int getIdRemedio() {
        return IdRemedio;
    }

    public void setIdRemedio(int IdRemedio) {
        this.IdRemedio = IdRemedio;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        if (estoque < 0) {
        throw new IllegalArgumentException("Estoque não pode ser negativo");
    }
        this.estoque = estoque;
    }

    public String getViaMedicacao() {
        return viaMedicacao;
    }

    public void setViaMedicacao(String viaMedicacao) {
        this.viaMedicacao = viaMedicacao;
    }

    public String getIndicacoes() {
        return indicacoes;
    }

    public void setIndicacoes(String indicacoes) {
        this.indicacoes = indicacoes;
    }

    public String getContraindicacoes() {
        return contraindicacoes;
    }

    public void setContraindicacoes(String contraindicacoes) {
        this.contraindicacoes = contraindicacoes;
    }
    
    public String getPrincipalAtivo() {
        return principalAtivo;
    }
    
    public void setPrincipalAtivo(String principalAtivo) {
        this.principalAtivo = principalAtivo;
    }

    public String getEfeitosColaterais() {
        return efeitosColaterais;
}

    public void setEfeitosColaterais(String efeitosColaterais) {
        this.efeitosColaterais = efeitosColaterais;
    }

    public String getFormaFarmaceutica() {
        return formaFarmaceutica;
    }

    public void setFormaFarmaceutica(String formaFarmaceutica) {
        this.formaFarmaceutica = formaFarmaceutica;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public Farmaceutico getFarmaceutico() {
        return farmaceutico;
    }

    public void setFarmaceutico(Farmaceutico farmaceutico) {
        this.farmaceutico = farmaceutico;
    } 
    
    public ArrayList getPacientes() {
        return pacientes;
    }
    
    public void adicionaPaciente(Paciente paciente) {
        this.pacientes.add(paciente);
    }

}
