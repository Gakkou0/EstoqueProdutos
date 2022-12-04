
package q.estoquemercado;

import java.util.ArrayList;

public class EstoqueProduto implements Estoque{
    
    private ArrayList<Produto> estoque = new ArrayList<>();

    public ArrayList<Produto> getEstoque() {
        return estoque;
    }

    public void setEstoque(ArrayList<Produto> estoque) {
        this.estoque = estoque;
    }
    
    @Override
    public void adicionarNovoProduto(Produto novoProduto){
        if(this.estoque.size()<=100){
            this.estoque.add(novoProduto);
        } else {
            System.out.println("Quantidade maxima de produtos atingida");
        }
    }
    
    @Override
    public void deletarProduto(int index){
        this.estoque.remove(index);
    }
    
    @Override
    public void lerTodosProdutos(int opcao){
        switch (opcao) {
            case 1 -> {
                for(int i = 0; i < this.estoque.size();i++){
                    System.out.println(this.estoque.get(i));
                }
            }
            case 2 -> {
                for(int i = 0; i < this.estoque.size();i++){
                    System.out.println("Produto \n\n Nome: " + this.estoque.get(i).getNome() +
                            "\nPreço: " + this.estoque.get(i).getNome() +
                            "\nCodigo de Barra: " + this.estoque.get(i).getCodigoBarra());
                }
            }
            default -> System.out.println("opção não encontrada");
        }
    }

    
    @Override
    public void editarProduto(int index, Produto produto){
        this.estoque.add(index, produto);
    }
    
    public void adicionarItens(int index, int quantidade){
        
        int novaQuantidade = (this.estoque.get(index).getQuantidadeProduto() + quantidade);
        this.estoque.get(index).setQuantidadeProduto(novaQuantidade);
    }
    
    @Override
    public void valorMaisAlto(){
        
        double maiorValor = 0;
        int maiorValorIndex = 0;
        
        for(int i = 0; i < this.estoque.size();i++){
            if (i==0){
                maiorValor = this.estoque.get(i).getPreco();
            }else if(maiorValor<this.estoque.get(i).getPreco()){
                maiorValor = this.estoque.get(i).getPreco();
                maiorValorIndex = i;
            }
        }
        
        System.out.println(this.estoque.get(maiorValorIndex));
    }
    
    @Override
    public double valorTotal(){
        
        double valorTotal = 0;
        for(int i = 0; i < this.estoque.size();i++){
            valorTotal += (this.estoque.get(i).getPreco() * this.estoque.get(i).getQuantidadeProduto());
        }
        
        return valorTotal;
    }
    
    @Override
    public void pesquisarProduto(String nome){
        for(int i = 0; i < this.estoque.size();i++){
            if(nome.equals(this.estoque.get(i).getNome())){
                System.out.println(this.estoque.get(i));
                break;
            }
        }
    }
    
    @Override
    public void pesquisarProduto(int codigo){
        for(int i = 0; i < this.estoque.size();i++){
            if(codigo == this.estoque.get(i).getCodigoSistema()){
                System.out.println(this.estoque.get(i));
                break;
            }
        }
    }
    
    @Override
    public void pesquisaCodigoBarra(int codigo){
        for(int i = 0; i < this.estoque.size();i++){
            if(codigo == this.estoque.get(i).getCodigoBarra()){
                System.out.println(this.estoque.get(i));
                break;
            }
        }
    }
    
}
