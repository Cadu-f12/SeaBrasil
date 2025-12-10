package model.venda;

import model.produto.Produto;

import java.math.BigDecimal;

public class Total {
    private final BigDecimal somaTotal;

    public Total(Produto produto, BigDecimal quantidade) {
        this.somaTotal = realizarSoma(produto.capturePreco(), quantidade);
    }

    protected BigDecimal getSoma() {
        return this.somaTotal;
    }

    private BigDecimal realizarSoma(BigDecimal preco, BigDecimal quantidade) {
        return quantidade.multiply(preco); // Quantidade * Preço
    }

    @Override
    public String toString() {
        return "Total{" +
                "somaTotal=" + somaTotal +
                '}';
    }
}