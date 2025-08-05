package entity;


public class PessoaFisica extends Pessoa {
    private String cpf;
    private int idade;
    private String tipoSanguineo;
    private String rg; 
    private String sexo;
    private String foto; 

    private Endereco enderecoPrincipal;

    public PessoaFisica() {
        super();
    }

    public PessoaFisica(String nome, String email, String senha, String telefone, String cepPessoa,
                        String cpf, int idade, String tipoSanguineo, String sexo, String foto, Endereco enderecoPrincipal) {
        super(nome, email, senha, telefone, cepPessoa);
        this.cpf = cpf;
        this.idade = idade;
        this.tipoSanguineo = tipoSanguineo;
        this.sexo = sexo;
        this.foto = foto;
        this.enderecoPrincipal = enderecoPrincipal; 
    }

    public boolean editarPerfil() {
        System.out.println("Método editarPerfil() chamado para CPF: " + this.cpf);
        return true;
    }

    public boolean validarCPF() {
        System.out.println("Método validarCPF() chamado para CPF: " + this.cpf);
        return this.cpf != null && this.cpf.matches("\\d{11}"); 
    }

    // Getters e Setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Endereco getEnderecoPrincipal() {
        return enderecoPrincipal;
    }

    public void setEnderecoPrincipal(Endereco enderecoPrincipal) {
        this.enderecoPrincipal = enderecoPrincipal;
    }
}