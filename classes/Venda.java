package classes;


import java.time.LocalDate;

public class Venda {
    private String produtoVendido;
    private int quantidadeVendida;
    private LocalDate dataProdutos;
    private Produto produto;
   
    
    public double getSomaTotalVendido(){
        return quantidadeVendida + quantidadeVendida;
    }
    public double getValorTotal() {
        return produto.getValor() * quantidadeVendida;
    }


    public Venda( int quantidadeVendida, LocalDate dataProdutos, Produto produto){
           this.quantidadeVendida = quantidadeVendida;
           this.dataProdutos = dataProdutos;
           this.produto = produto;
    }
    
    

    public String getProdutoVendido() {
        return produtoVendido;
    }

    public void setProdutoVendido(String produtoVendido) {
        this.produtoVendido = produtoVendido;
}
    public LocalDate getDataProdutos() {
        return dataProdutos;
    }
    public void setDataProdutos(LocalDate dataProdutos) {
        this.dataProdutos = dataProdutos;
    }
    
    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }
    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
}
