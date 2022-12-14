package q.estoquemercado;

import java.time.LocalDate;

public class ProdutoEletronico extends Produto {

    private int anoLancamento;
    
    public ProdutoEletronico(String nome, double preco, int quantidadeProduto, int codigoSistema, int codigoBarra, LocalDate dataCadastro, int anoLancamento) {
        super(nome, preco, quantidadeProduto, codigoSistema, codigoBarra, dataCadastro);
        this.anoLancamento = anoLancamento;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLançamento) {
        this.anoLancamento = anoLançamento;
    }

    @Override
    public String toString() {
        return super.toString() + "\nAno de lançamento: " + getAnoLancamento();
    }

}
