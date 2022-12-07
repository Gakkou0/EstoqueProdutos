
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
        boolean flag = true;
        
            try {
                validaQuantidade(novoProduto.getQuantidadeProduto());
                flag = false;
            } catch (QuantityLessThanZeroException ex) {
                System.out.println("Quantidade abaixo de zero");
            }
        
            
        if (!flag){
            if(this.estoque.size()<=100){
                this.estoque.add(novoProduto);
            } else {
                System.out.println("Quantidade maxima de produtos atingida");
            }
        }
    }
    
    @Override
    public void deletarProduto(int index){
        try{
            this.estoque.remove(index);
            System.out.println("item deletado");
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("item não encontrado");
        }
    }
    
    @Override
    public void lerTodosProdutos(int opcao){
        switch (opcao) {
            case 1 -> {
                if(estoque.isEmpty()){
                    System.out.println("Estoque vazio");
                }else{
                    for(int i = 0; i < this.estoque.size();i++){
                        System.out.println(this.estoque.get(i));
                    }    
                }
            }
            case 2 -> {
                if(estoque.isEmpty()){
                    System.out.println("Estoque vazio");
                }else{
                    for(int i = 0; i < this.estoque.size();i++){
                        System.out.println("Produto \n\nNome: " + this.estoque.get(i).getNome() +
                                "\nPreço: " + this.estoque.get(i).getPreco() +
                                "\nCodigo de Barra: " + this.estoque.get(i).getCodigoBarra());        
                    }
                }
            }
            default -> System.out.println("opção não encontrada");
        }
    }

    
    @Override
    public void editarProduto(int index, Produto produto){
        try{
            this.estoque.add(index, produto);
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Item não encontrado");
        }
    }
    
    @Override
    public void adicionarItens(int index, int quantidade){
        try{
            int novaQuantidade = (this.estoque.get(index).getQuantidadeProduto() + quantidade);
            this.estoque.get(index).setQuantidadeProduto(novaQuantidade);
            
            System.out.println("Itens atualizados");
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Item não encontrado");
        }
    }
    
    @Override
    public void valorMaisAlto(){
        
        try{
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
        }catch (IndexOutOfBoundsException e){
            System.out.println("O estoque está vazio");
        }
        
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
        if(estoque.isEmpty()){
            System.out.println("Estoque vazio");
        }else{
            for(int i = 0; i < this.estoque.size();i++){
                if(nome.equals(this.estoque.get(i).getNome())){
                    System.out.println(this.estoque.get(i));
                    break;
                }
            }
        }
    }
    
    @Override
    public void pesquisarProduto(int codigo){
        if(estoque.isEmpty()){
            System.out.println("Estoque vazio");
        }else{
            for(int i = 0; i < this.estoque.size();i++){
                if(codigo == this.estoque.get(i).getCodigoSistema()){
                    System.out.println(this.estoque.get(i));
                    break;
                }
            }
        }
    }
    
    @Override
    public void pesquisaCodigoBarra(int codigo){
        if(estoque.isEmpty()){
            System.out.println("Estoque vazio");
        }else{
            for(int i = 0; i < this.estoque.size();i++){
                if(codigo == estoque.get(i).getCodigoBarra()){
                    System.out.println(this.estoque.get(i));
                    break;
                }
            }
        }   
    }
    
    public static void validaQuantidade(int quantidade) throws QuantityLessThanZeroException{
        if(quantidade<0){
            throw new QuantityLessThanZeroException();
        }
    }
}
