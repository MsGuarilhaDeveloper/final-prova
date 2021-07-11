package programa;
import classes.Produto;
import classes.Relatorios;
import classes.Venda;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mercearia {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        List<Produto> produto = new ArrayList<>();
        List<Venda> venda = new ArrayList<>();
        
        int opcao = -1;
        
        while(opcao != 0){
            System.out.println("\n MENU PRINCIPAL!!");
            System.out.println("--------------------------|");
            System.out.println("\n1 - Cadastro de produtos  |");
            System.out.println("2 - Relatorios            |");
            System.out.println("3 - Venda                 |");
            System.out.println("0 - Sair                  |");
            System.out.println("--------------------------|");
            System.out.printf("Opção: ");
            opcao = ler.nextInt();
            ler.nextLine();

            switch(opcao){
                case 1:
                   int escolha = -1;
                   int codigo = -1;
                   

                       do {
                           
                       System.out.println("\n(Menu de Cadastro)");
                       System.out.println("-------------------------------");
                       System.out.println("1 - Cadastrar produto          |");
                       System.out.println("2 - Consultar produtos         |");
                       System.out.println("0 - Voltar pro menu            |");
                       System.out.println("-------------------------------");
                       System.out.printf("Opção: ");
                       escolha = ler.nextInt();
                       ler.nextLine();
                       
                     
                       switch (escolha){
                           case 1:

                           do {                              
                           System.out.println("\n(Cadastrando Produto)");
                           System.out.println("---------------------------------");
                           System.out.println("Digite o código do produto");
                           System.out.printf("\nCódigo: ");
                           codigo = ler.nextInt();
                           ler.nextLine();
                           
                           System.out.println("\n--------------------------");
                           System.out.println("Digite o nome do produto");
                           System.out.printf("\nNome: ");
                           String nome = ler.nextLine();

                           System.out.println("\n---------------------------");
                           System.out.println("Digite o valor do produto");
                           System.out.printf("\nValor Produto: ");
                           double valor = ler.nextInt();
                           ler.nextLine();

                           System.out.println("\n--------------------------------");
                           System.out.println("Digite a quantidade de ");
                           System.out.printf("\nQuantidade: ");
                           int quantidade = ler.nextInt();
                           ler.nextLine();
                           produto.add(new Produto(codigo, nome, valor, quantidade));  

                           System.out.println("\n------------------------");
                           System.out.println(" Cadastrar Outro Produto");
                           System.out.println("1 - Sim");
                           System.out.println("2 - Não");
                           System.out.println("------------------------");
                           System.out.printf("Opção: ");
                           escolha = ler.nextInt();
                           ler.nextLine();

                           if (escolha == 2){
                           System.out.println("\n***********************");
                           System.out.println("1 - Voltar Menu Cadastrar");
                           System.out.printf("Opção :" );
                           opcao = ler.nextInt();
                           ler.nextLine();
                           break;
                           }

                         } while (escolha != 0);
                           break;
                           case 2: 

                                System.out.println("\n(Produtos Cadastrados)");
                                System.out.println("----------------------------------------------|");
                                System.out.println("Codigo    | Nome      | Valor     | Quantidade|");
                                System.out.println("----------------------------------------------|");
                           for (Produto p : produto) {
                                System.out.printf("%d         |%s       |%.2f        |%d         |\n", p.getCodigo(), p.getNome(), p.getValor(), p.getQuantidadeEstoque());                       
                           }
                                System.out.println("----------------------------------------------|");

                                System.out.println("\nEnter Voltar Menu Cadastrar");
                                ler.nextLine();

                           break;
                           case 0:
                                System.out.println("\nVoltando Menu Principal...");
                                break;
                       }
                    } while (escolha != 0);  
                    
                break;
                case 2:
                Relatorios relatorios = new Relatorios();

                System.out.println("Relatorios");
                System.out.println("\n-------------------");
                System.out.println("1 - Produtos");
                System.out.println("2 - Venda por período");
                System.out.println("0 - Voltar ao menu");
                System.out.printf("Opção:\n ");
                int op = ler.nextInt();
                ler.nextLine();

                if(op == 1){
                    relatorios.exibirRelatorioProduto(ler, produto);
                        
                    }else if (op == 2){
                        relatorios.exibirVendaDetalhado(ler, venda);

                    }else if (op == 3){
                        relatorios.exibirRelatorioConsolidade(ler, venda);

                    }

                break;     
                case 3: 
                
                System.out.println("Realizando Venda");
                System.out.println("------------------------");
                System.out.println("\nDigite o Codigo do produto ");
                System.out.printf("Opção: ");
                int cod = ler.nextInt();
                ler.nextLine();
                System.out.println("\n--------------------------------");
                System.out.println("Digite a Quantidade do Produto");
                System.out.printf("Opção: ");
                int quantidadeVendida = ler. nextInt();
                ler.nextLine();
            
                
                DateTimeFormatter fd = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String dataHoje = fd.format(LocalDateTime.now());
                
                boolean achei = false;
                for (Produto p : produto) {
                        if(p.getCodigo() == cod){
                            achei = true;
                            p.removerQuantidade(quantidadeVendida);
                            venda.add(new Venda(quantidadeVendida, LocalDate.parse(dataHoje, fd),p));
                            System.out.println("\nVenda Realizada com sucesso!");
                            break;                            
                    } 
                }
                if (achei == false){
                    System.out.println("\nProduto não encontrado!! \nVoltando ao menu...\n");
                    break;
                }
                break;
                

                
                   
                    
                       
            }
        }
        ler.close();
    }
    
}
