package q.estoquemercado;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;


public class EstoqueMercado {

    public static void main(String[] args) {
        boolean running = true;
        
        EstoqueProduto estoque = new EstoqueProduto();
        
        Scanner scan = new Scanner(System.in);
        int opcao;
        
        while(running){
            System.out.println("Menu");
            
            System.out.println("""
                               1 - Busca de item por nome ou codigo
                               2 - Busca de item por código de barras
                               3 - Valor total dos itens em estoque
                               4 - Manipulação de produtos
                               5 - Visualizar todos os Produtos
                               6 - Visualizar produto de maior Valor
                               
                               """);
            opcao = scan.nextInt();
            
            switch(opcao){
                case 1 -> {
                    
                }
                case 2 -> {
                    
                }
                case 3 -> {
                    System.out.println("Valor total em estoque é: " +estoque.valorTotal());
                }
                case 4 -> {
                    System.out.println("Menu de manipulação");
                    System.out.println("""
                                       1 - Adicionar produtos
                                       2 - Deletar produtos
                                       3 - Editar produtos
                                       4 - Atualizar quantidade em estoque
                                       5 - Ler produtos
                                       6 - Voltar
                                       """);
                    opcao = scan.nextInt();
                    switch(opcao){
                        case 1 -> {
                            boolean flag = true;
                            
                            while(flag){
                                try{
                                    Scanner input = new Scanner(System.in);
                                    
                                    System.out.println("Adição de produto\n");
                                    System.out.println("Digite o nome do produto:");
                                    String nome = input.next();
                                    System.out.println("Digite o preço do produto:");
                                    double preco = input.nextDouble();
                                    System.out.println("Digite a quantidade em estoque:");
                                    int quantidade = input.nextInt();
                                    System.out.println("Digite o codigo de Barras:");
                                    int codigoBarra = input.nextInt();
                                    System.out.println("Digite o codigo no sistema:");
                                    int codigoSistema = input.nextInt();

                                    ProdutoEletronico produto = new ProdutoEletronico(nome, preco, quantidade, codigoBarra, codigoSistema, LocalDate.now(), 1903);
                                    estoque.adicionarNovoProduto(produto);
                                    flag = false;
                                }catch(InputMismatchException e){
                                    System.out.println("Tipo impartivel de dados");
                                    System.out.println("Por favor, tente novamente");
                                }
                            }
                            
                        }
                        case 2 -> {
                            
                        }
                        case 3 -> {
                            
                        }
                        case 4 -> {
                            
                        }
                        case 5 -> {
                            
                        }
                        case 6 -> {
                            
                        }
                        
                        default -> {
                            System.out.println("Opção não encontrada");
                        }
                    }
                }
                case 5 -> {
                     System.out.println("""
                                       1 - Exibir versão completa
                                       2 - Exibir versão resumida
                                       """);
                    estoque.lerTodosProdutos(scan.nextInt());  
                }
                case 6 -> {
                     System.out.println("Produto com valor mais alto:\n");
                     estoque.valorMaisAlto();
                }
                default -> {
                    System.out.println("Opção não encontrada");
                }
            }
        }
    }
}
