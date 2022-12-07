package q.estoquemercado;

import static java.lang.System.exit;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EstoqueMercado {

    public static void main(String[] args) {
        boolean running = true;

        EstoqueProduto estoque = new EstoqueProduto();

        Scanner scan = new Scanner(System.in);
        String opcao;

        while (running) {
            System.out.println("Menu");

            System.out.println("""
                               1 - Busca de item por nome ou codigo
                               2 - Busca de item por código de barras
                               3 - Valor total dos itens em estoque
                               4 - Manipulação de produtos
                               5 - Visualizar todos os Produtos
                               6 - Visualizar produto de maior Valor
                               7 - Sair
                               """);
            
            opcao = scan.nextLine();

            switch (opcao) {
                case "1" -> {
                    System.out.println("""
                                       1 - Pesquisa por nome
                                       2 - Pesquisa por codigo
                                        """);
                    opcao = scan.nextLine();
                    
                    switch(opcao){
                        case "1" -> {
                            System.out.println("Digite o nome:");
                            String nome = scan.next();
                            estoque.pesquisarProduto(nome);
                        }
                        case "2" -> {
                            boolean flag = true;
                            
                            while(flag){
                                try {
                                    Scanner input = new Scanner(System.in);
                                    System.out.println("Digite o codigo:");
                                    int codigo = input.nextInt();
                                    estoque.pesquisarProduto(codigo);
                                    
                                    flag = false;
                                }
                                catch (InputMismatchException e) {
                                    System.out.println("Tipo impartivel de dados");
                                    System.out.println("Por favor, tente novamente");
                                }
                            }
                        }
                    }
                    
                }
                case "2" -> {
                    boolean flag = true;
                    
                    while(flag){
                        try{
                            Scanner input = new Scanner(System.in);

                            System.out.println("Digite o codigo de barras:");
                            int codigo = input.nextInt();
                            estoque.pesquisaCodigoBarra(codigo);
                            flag = false;
                        }
                        catch(InputMismatchException e) {
                            System.out.println("Tipo impartivel de dados");
                            System.out.println("Por favor, tente novamente");
                        }
                        catch(IndexOutOfBoundsException e) {
                            System.out.println("Item não encontrado");
                            flag = false;
                        }
                    }
                }
                case "3" -> {
                    System.out.println("Valor total em estoque é: " + estoque.valorTotal());
                }
                case "4" -> {
                    System.out.println("Menu de manipulação");
                    System.out.println("""
                                       1 - Adicionar produtos
                                       2 - Deletar produtos
                                       3 - Editar produtos
                                       4 - Atualizar quantidade em estoque
                                       5 - Voltar
                                       """);
                    opcao = scan.nextLine();
                    switch (opcao) {
                        case "1" -> {
                            System.out.println("""
                                               1 - produto eletronico
                                               2 - produto com prazo de validade
                                               """);
                            opcao = scan.nextLine();

                            switch (opcao) {
                                case "1" -> {
                                    boolean flag = true;

                                    while (flag) {
                                        try {
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
                                            System.out.println("Digite o ano de lançamento:");
                                            int anoLancamento = input.nextInt();

                                            ProdutoEletronico produto = new ProdutoEletronico(nome, preco, quantidade, codigoBarra, codigoSistema, LocalDate.now(), anoLancamento);
                                            estoque.adicionarNovoProduto(produto);
                                            flag = false;
                                        } catch (InputMismatchException e) {
                                            System.out.println("Tipo impartivel de dados");
                                            System.out.println("Por favor, tente novamente");
                                        }
                                    }
                                }
                                case "2" -> {
                                    boolean flag = true;

                                    while (flag) {
                                        try {
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
                                            System.out.println("Digite o dia de vencimento:");
                                            int dia = input.nextInt();
                                            System.out.println("Digite o mês de vencimento:");
                                            int mes = input.nextInt();
                                            System.out.println("Digite o ano de vencimento:");
                                            int ano = input.nextInt();

                                            ProdutoVencimento produto = new ProdutoVencimento(nome, preco, quantidade, codigoBarra, codigoSistema, LocalDate.now(), LocalDate.of(ano, mes, dia));
                                            estoque.adicionarNovoProduto(produto);
                                            flag = false;
                                        } catch (InputMismatchException e) {
                                            System.out.println("Tipo impartivel de dados");
                                            System.out.println("Por favor, tente novamente");
                                        }
                                    }
                                }
                                default -> {
                                    System.out.println("Opção invalida");
                                }
                            }

                        }
                        case "2" -> {
                            System.out.println("Digite o endereço do produto");
                            int index = scan.nextInt();

                            estoque.deletarProduto(index);
                                    
                        }
                        case "3" -> {
                            System.out.println("Digite o endereço do produto");
                            int index = scan.nextInt();

                            System.out.println("""
                                               1 - produto eletronico
                                               2 - produto com prazo de validade
                                               """);
                            opcao = scan.nextLine();

                            switch (opcao) {
                                case "1" -> {
                                    boolean flag = true;

                                    while (flag) {
                                        try {
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
                                            System.out.println("Digite o ano de lançamento:");
                                            int anoLancamento = input.nextInt();

                                            ProdutoEletronico produto = new ProdutoEletronico(nome, preco, quantidade, codigoBarra, codigoSistema, LocalDate.now(), anoLancamento);
                                            estoque.editarProduto(index, produto);
                                            flag = false;
                                        } catch (InputMismatchException e) {
                                            System.out.println("Tipo impartivel de dados");
                                            System.out.println("Por favor, tente novamente");
                                        }
                                    }
                                }
                                case "2" -> {
                                    boolean flag = true;

                                    while (flag) {
                                        try {
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
                                            System.out.println("Digite o dia de vencimento:");
                                            int dia = input.nextInt();
                                            System.out.println("Digite o mês de vencimento:");
                                            int mes = input.nextInt();
                                            System.out.println("Digite o ano de vencimento:");
                                            int ano = input.nextInt();

                                            ProdutoVencimento produto = new ProdutoVencimento(nome, preco, quantidade, codigoBarra, codigoSistema, LocalDate.now(), LocalDate.of(ano, mes, dia));
                                            estoque.editarProduto(index, produto);
                                            flag = false;
                                        } catch (InputMismatchException e) {
                                            System.out.println("Tipo impartivel de dados");
                                            System.out.println("Por favor, tente novamente");
                                        }
                                    }
                                }
                                default -> {
                                    System.out.println("Opção invalida");
                                }

                            }
                        }
                        case "4" -> {
                            System.out.println("Digite o endereço do produto");
                            int index = scan.nextInt();
                            System.out.println("Digite a quantidade a ser adicionada:");
                            int quantidade = scan.nextInt();

                            estoque.adicionarItens(index, quantidade);

                            System.out.println("itens adicionados");
                        }
                        case "5" -> {
                        }

                        default -> {
                            System.out.println("Opção não encontrada");
                        }
                    }
                }
                case "5" -> {
                    System.out.println("""
                                       1 - Exibir versão completa
                                       2 - Exibir versão resumida
                                       """);
                    estoque.lerTodosProdutos(scan.nextInt());
                }
                case "6" -> {
                    System.out.println("Produto com valor mais alto:\n");
                    estoque.valorMaisAlto();
                }
                
                case "7" -> {
                    exit(0);
                }
                default -> {
                    System.out.println("Opção não encontrada");
                }
            }
        }
    }
}
