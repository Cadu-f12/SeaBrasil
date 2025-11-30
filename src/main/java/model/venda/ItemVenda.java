package model.venda;

import model.produto.Produto;

public class ItemVenda {
    private Produto produto;
    private int quantidade;
    private double total;

    public ItemVenda(Produto produto, int quantidade, double total) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.total = total;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getTotal() {
        return total;
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