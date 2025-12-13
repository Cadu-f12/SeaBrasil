package model.venda;

import model.produto.Produto;

import java.math.BigDecimal;

class Total {
    private final BigDecimal valorTotal;

    Total(Produto produto, BigDecimal quantidade) {
        this.valorTotal = realizarSoma(produto.capturePreco(), quantidade);
    }

    BigDecimal getValorTotal() {
        return this.valorTotal;
    }

    private BigDecimal realizarSoma(BigDecimal preco, BigDecimal quantidade) {
        return quantidade.multiply(preco); // Quantidade * Preço
    }

    @Override
    public String toString() {
        return "Total{" +
                "valorTotal=" + valorTotal +
                '}';
    }
}