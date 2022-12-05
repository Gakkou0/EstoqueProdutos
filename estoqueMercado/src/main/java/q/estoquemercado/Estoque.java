package q.estoquemercado;

public interface Estoque {
    
    public void adicionarNovoProduto(Produto novoProduto);
    public void adicionarItens(int index, int quantidade);
    public void deletarProduto(int index);
    public void lerTodosProdutos(int opcao);
    public void editarProduto(int index, Produto produto);
    public void valorMaisAlto();
    public double valorTotal();
    public void pesquisarProduto(String nome);
    public void pesquisarProduto(int codigo);
    public void pesquisaCodigoBarra(int codigo);
}

