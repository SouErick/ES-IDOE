package entity;

import java.util.ArrayList; 
import java.util.Date;
import java.util.List;    

public class Doacao {
    private int id;
    private Date data; 
    private String titulo;
    private String especificacao; 
    private double valor;


    private List<FormaPagamento> formasPagamento;

    public Doacao() {
        this.formasPagamento = new ArrayList<>(); 
    }


    public Doacao(int id, Date data, String titulo, String especificacao, double valor) {
        this.id = id;
        this.data = data;
        this.titulo = titulo;
        this.especificacao = especificacao;
        this.valor = valor;
        this.formasPagamento = new ArrayList<>(); 
    }

    public void solicitarDoacao() {
        System.out.println("Método solicitarDoacao() chamado.");
    }

    public void contribuir() {
        System.out.println("Método contribuir() chamado.");

    }

    public Doacao listarPedidos() {
        System.out.println("Método listarPedidos() chamado.");
        return this; 
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() { 
        return data;
    }

    public void setData(Date data) { 
        this.data = data;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEspecificacao() {
        return especificacao;
    }

    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) { 
        this.valor = valor;
    }

    public List<FormaPagamento> getFormasPagamento() {
        return formasPagamento;
    }

    public void setFormasPagamento(List<FormaPagamento> formasPagamento) {
        this.formasPagamento = formasPagamento;
    }

    public void addFormaPagamento(FormaPagamento formaPagamento) {
        if (this.formasPagamento == null) {
            this.formasPagamento = new ArrayList<>();
        }
        this.formasPagamento.add(formaPagamento);
    }

    public void removeFormaPagamento(FormaPagamento formaPagamento) {
        if (this.formasPagamento != null) {
            this.formasPagamento.remove(formaPagamento);
        }
    }
}