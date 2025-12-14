package model.venda;

import java.math.BigDecimal;

public class Quantidade {
    int quantidade;

    public Quantidade(int quantidade) {
        setQuantidade(quantidade);
    }

    int getQuantidade() {
        return quantidade;
    }
    private void setQuantidade(int quantidade) {
        // quantidade < 1
        if (quantidade < 1) {
            System.err.println("Exceção disparada de: ItemVenda.setQuantidade");
            throw new IllegalArgumentException("quantidade inválida: valor menor que 1 detectado");
        }

        // quantidade > 99
        if (quantidade > 99) {
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