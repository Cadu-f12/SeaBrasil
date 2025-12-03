package model.venda;

import model.produto.Produto;

public class ItemVenda {
    private Produto produto;
    private int quantidade;
    private double total;

    public ItemVenda(Produto produto, int quantidade, double total) {
        setProduto(produto);
        setQuantidade(quantidade);
        setTotal(total);
    }

    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ItemVenda{" +
                "produto=" + produto +
                ", quantidade=" + quantidade +
                ", total=" + total +
                '}';
    }
}