package classes;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;



    
public class Relatorios {
     Scanner ler = new Scanner(System.in);
     String dataInicial;
     String dataFinal;
    
    public void exibirRelatorioProduto(Scanner ler, List <Produto> produto){
        System.out.println(" Relatorio de Produtos");
        // System.out.println("----------------------------------------");
        System.out.printf("|%-10.10s|\t|%-12.12s|\t|%-20.20s|\t|%-15.15s|\n",
        "Código", "Produto", "Valor R$", "Estoque");
        for (Produto p : produto) {
            System.out.printf("|%-10.10s|\t|%-12.12s|\t|%-20.20s|\t|%-15.15s|\n",
            p.getCodigo(), p.getNome(), p.getValor(), p.getQuantidadeEstoque());
            
        }
            DoubleSummaryStatistics est = produto.stream()
            .collect(Collectors.summarizingDouble(Produto::getValor));
            System.out.printf("Valor Maior %.2f    Valor Menor %.2f    Valor Medio %.2f\n",
            est.getMax(), est.getMin(), est.getAverage());
    }
    public void exibirVendaDetalhado(Scanner ler , List<Venda> venda){      

        DateTimeFormatter fd = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        System.out.println("\nRelatorios");
        System.out.println("-----------");
        System.out.printf("Data Inicial: ");
        dataInicial = ler.nextLine();
        System.out.printf("Data final: ");
        dataFinal = ler.nextLine();
        
        
        List<Venda> vendasFiltradas =
        venda.stream().filter(v -> v.getDataProdutos().plusDays(1).isAfter(LocalDate.parse(dataInicial, fd)) &&
        v.getDataProdutos().plusDays(-1).isBefore(LocalDate.parse(dataFinal, fd)))
        .collect(Collectors.toList());
        
             System.out.printf("|%-10.10s|\t|%-12.12s|\t|%-10.10s|\t|%-20.20s|\t|%-15.15s|\n",
            "Data", "Produto", "Quantidade", "Valor", "Valor Total R$" );
           
            vendasFiltradas.forEach(v -> 
            System.out.printf("|%-10.10s|\t|%-12.12s|\t|%-10.10s|\t|%-20.20s|\t|%-15.15s|\n",
            v.getDataProdutos(), v.getProduto().getNome(), v.getQuantidadeVendida(), v.getProduto().getValor(), v.getValorTotal()));
            
        }
        public void exibirRelatorioConsolidade(Scanner ler, List<Venda> venda){

            DateTimeFormatter fd = DateTimeFormatter.ofPattern("dd/MM/yyyy");
             
            System.out.println("\nRelatorio Consolidado");
            System.out.println("-------------");
            System.out.printf("Data Inicial: ");
            dataInicial = ler.nextLine();
            System.out.printf("Data Final: ");
            dataFinal = ler.nextLine();

            List<Venda> vendasFiltradas =
            venda.stream().filter(v -> v.getDataProdutos().plusDays(1).isAfter(LocalDate.parse(dataInicial, fd)) &&
            v.getDataProdutos().plusDays(-1).isBefore(LocalDate.parse(dataFinal, fd)))
            .collect(Collectors.toList());

            System.out.printf("|\n%-10.10s|\t|%-12.12s|\t|%-10.10s|\n",
            "data","Quantidade Vendida","Total Vendido");

            DoubleSummaryStatistics TotalVendido = vendasFiltradas.stream()
            .collect(Collectors.summarizingDouble(v -> v.getValorTotal()));
            
            vendasFiltradas.forEach(v -> 
            System.out.printf("|%-10.10s|\t|%-12.12s|\t|%-10.10s|\n",
            v.getDataProdutos(),v.getSomaTotalVendido(),v.getValorTotal()));
            System.out.printf("Valor maximo %.2f ", TotalVendido.getMax());

        }
    }
        

    

        
    
