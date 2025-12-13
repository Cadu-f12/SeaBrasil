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

    int getProdutoId() {
        return this.produto.getProdutoId();
    }

    BigDecimal getQuantidade() {
        return this.quantidade.getQuantidade();
    }

    BigDecimal getValorTotal() {
        return this.total.getValorTotal();
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