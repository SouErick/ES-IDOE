package entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class PessoaJuridica extends Pessoa {

    private String cnpj;
    private String razaoSocial;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Doacao> doacoesRealizadas = new ArrayList<>();

    public PessoaJuridica() {
        super();
        this.doacoesRealizadas = new ArrayList<>();
    }

    public PessoaJuridica(String nome, String email, String senha, String telefone, String cepPessoa,
                          String cnpj, String razaoSocial) {
        super(nome, email, senha, telefone, cepPessoa);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.doacoesRealizadas = new ArrayList<>();
    }

    public boolean validarCNPJ() {
        System.out.println("Método validarCNPJ() chamado para CNPJ: " + this.cnpj);
        return this.cnpj != null && this.cnpj.matches("\\d{14}"); 
    }

    public boolean criarPedidoDoacao(Doacao doacao) {
        System.out.println("Método criarPedidoDoacao() chamado para a empresa: " + this.razaoSocial);
        if (doacao != null) {
            this.doacoesRealizadas.add(doacao);
            return true;
        }
        return false;
    }

    // Getters e Setters
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }


    public List<Doacao> getDoacoesRealizadas() {
        return doacoesRealizadas;
    }

    public void setDoacoesRealizadas(List<Doacao> doacoesRealizadas) {
        this.doacoesRealizadas = doacoesRealizadas;
    }

    public void addDoacaoRealizada(Doacao doacao) {
        if (this.doacoesRealizadas == null) {
            this.doacoesRealizadas = new ArrayList<>();
        }
        this.doacoesRealizadas.add(doacao);
    }
}