package model.produto;

import java.math.BigDecimal;

public class Preco {
    private BigDecimal preco;

    public Preco(BigDecimal valor) {
        setPreco(valor);
    }

    protected BigDecimal getPreco() {
        return preco;
    }
    protected void setPreco(BigDecimal preco) {
        BigDecimal minimo = new BigDecimal("0.00");
        BigDecimal maximo = new BigDecimal("9999.99");

        if (preco.compareTo(minimo) < 0 || preco.compareTo(maximo) > 0) {
            throw new IllegalArgumentException("preco inválido: valor menor que 0 ou acima do permitido");
        }

        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Preco{" +
                "preco=" + preco +
                '}';
    }
}
