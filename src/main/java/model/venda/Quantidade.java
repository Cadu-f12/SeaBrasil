package model.venda;

import java.math.BigDecimal;

public class Quantidade {
    BigDecimal quantidade;

    public Quantidade(BigDecimal quantidade) {
        setQuantidade(quantidade);
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

    @Override
    public String toString() {
        return "Quantidade{" +
                "quantidade=" + quantidade +
                '}';
    }
}