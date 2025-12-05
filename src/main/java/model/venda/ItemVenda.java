package model.venda;

import model.produto.Produto;

import java.math.BigDecimal;

public class ItemVenda {
    private Produto produto;
    private BigDecimal quantidade;
    private Total total;

    public ItemVenda(Produto produto, BigDecimal quantidade) {
        setProduto(produto);
        setQuantidade(quantidade);
        this.total = new Total(produto, quantidade);
    }

    protected Produto getProduto() {
        return produto;
    }
    protected void setProduto(Produto produto) {
        if (produto == null) {
            System.err.println("Exceção disparada de: ItemVenda.setProduto");;
            throw new IllegalArgumentException("produto inválido: valor nulo detectado");
        }

        this.produto = produto;
    }

    protected BigDecimal getQuantidade() {
        return quantidade;
    }
    protected void setQuantidade(BigDecimal quantidade) {
        if (quantidade == null) {
            System.err.println("Exceção disparada de: ItemVenda.setQuantidade");
            throw new IllegalArgumentException("quantidade inválida: valor nulo detectado");
        }
        // quantidade < 1
        if (quantidade.compareTo(BigDecimal.ONE) < 0) {
            System.err.println("Exceção disparada de: ItemVenda.setQuantidade");
            throw new IllegalArgumentException("quantidade inválida: valor menor que 1 detectado");
        }
        // quantidade > 99
        if (quantidade.compareTo(new BigDecimal("99")) > 0) {
            System.err.println("Exceção disparada de: ItemVenda.setQuantidade");
            throw new IllegalArgumentException("quantidade inválida: valor maior que 99 detectado");
        }

        this.quantidade = quantidade;
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