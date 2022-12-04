package q.estoquemercado;

import java.time.LocalDate;

public class ProdutoVencimento extends Produto{
    
    private LocalDate dataValidade;
    
    public ProdutoVencimento(String nome, double preco, int quantidadeProduto, int codigoSistema, int codigoBarra, LocalDate dataCadastro) {
        super(nome, preco, quantidadeProduto, codigoSistema, codigoBarra, dataCadastro);
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
}
