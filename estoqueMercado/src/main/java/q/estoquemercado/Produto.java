package q.estoquemercado;

import java.time.LocalDate;

public abstract class Produto {
    
    private String nome;
    private double preco;
    private int quantidadeProduto;
    private int codigoSistema;
    private int codigoBarra;
    private LocalDate dataCadastro;

    public Produto(String nome, double preco, int quantidadeProduto, int codigoSistema, int codigoBarra, LocalDate dataCadastro) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeProduto = quantidadeProduto;
        this.codigoSistema = codigoSistema;
        this.codigoBarra = codigoBarra;
        this.dataCadastro = dataCadastro;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public int getCodigoSistema() {
        return codigoSistema;
    }

    public void setCodigoSistema(int codigoSistema) {
        this.codigoSistema = codigoSistema;
    }

    public int getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(int codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }
    
    public boolean verificaEstoque(){
        return getQuantidadeProduto()>0;
    }

    @Override
    public String toString() {
        return "Produto \n\n Nome: " + getNome() +
               "\nPreço: " + getPreco() +
               "\nQuantidade em estoque: " + getQuantidadeProduto() +
               "\nCodigo do sistema: " + getCodigoSistema() +
               "\nCodigo de Barras: " + getCodigoBarra() +
               "\nData de cadastro: " + getDataCadastro();
    }
    
}
