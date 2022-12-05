package q.estoquemercado;

import java.time.LocalDate;

public class ProdutoVencimento extends Produto{
    
    private LocalDate dataValidade;
    
    public ProdutoVencimento(String nome, double preco, int quantidadeProduto, int codigoSistema, int codigoBarra, LocalDate dataCadastro, LocalDate dataValidade) {
        super(nome, preco, quantidadeProduto, codigoSistema, codigoBarra, dataCadastro);
        this.dataValidade = dataValidade;
        
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }
    
    public boolean verificaValidade(){
        return this.dataValidade.isBefore(LocalDate.now());
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nData de validade: " + getDataValidade();
    }
}
