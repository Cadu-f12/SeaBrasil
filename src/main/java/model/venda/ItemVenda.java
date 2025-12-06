package model.venda;

import model.produto.Produto;

import java.math.BigDecimal;

public class ItemVenda {
    private final Produto produto;
    private final Quantidade quantidade;
    private final Total total;

    public ItemVenda(Produto produto, Quantidade quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.total = new Total(produto, this.quantidade.getQuantidade());
    }

    protected int captureProdutoId() {
        return this.produto.captureId();
    }

    protected BigDecimal captureQuantidade() {
        return this.quantidade.getQuantidade();
    }

    protected BigDecimal captureTotal() {
        return this.total.getSoma();
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