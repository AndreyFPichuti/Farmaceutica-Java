
package farmaceutica;

import java.util.Date;
import java.util.ArrayList;

public class Remedio {
    private String nome;
    private int estoque;
    private String viaMedicacao;
    private String indicacoes;
    private String contraindicacoes;
    private String efeitosColaterais;
    private String formaFarmaceutica;
    private Date validade;
    private Farmaceutico farmaceutico;
    private ArrayList<Paciente> pacientes;
    
    public Remedio(String nome, int estoque, String viaMedicacao, String indicacoes, String contraindicacoes, String efeitosColaterais, String formaFarmaceutica, Date validade, Farmaceutico farmaceutico) {
        this.nome = nome;
        this.estoque = estoque;
        this.viaMedicacao = viaMedicacao;
        this.indicacoes = indicacoes;
        this.contraindicacoes = contraindicacoes;
        this.efeitosColaterais = efeitosColaterais;
        this.formaFarmaceutica = formaFarmaceutica;
        this.validade = validade;
        this.farmaceutico = farmaceutico;
        pacientes = new ArrayList();
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

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
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
