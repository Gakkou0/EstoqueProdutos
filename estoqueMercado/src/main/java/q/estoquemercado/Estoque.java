package q.estoquemercado;

public interface Estoque {
    
    public abstract void adicionarNovoProduto(Produto novoProduto);
    public abstract void deletarProduto(int index);
    public abstract void lerTodosProdutos(int opcao);
    public abstract void editarProduto(int index, Produto produto);
    public abstract void valorMaisAlto();
    public abstract double valorTotal();
    public abstract void pesquisarProduto(String nome);
    public abstract void pesquisarProduto(int codigo);
    public abstract void pesquisaCodigoBarra(int codigo);
}

