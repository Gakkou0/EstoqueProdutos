package q.estoquemercado;

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
                                       1 - Exibir versão resumida
                                       2 - Exibir versão completa
                                       """);
                    estoque.lerTodosProdutos(scan.nextInt());  
                }
                case 6 -> {
                                   
                }
                default -> {
                    System.out.println("Opção não encontrada");
                }
            }
        }
    }
}
