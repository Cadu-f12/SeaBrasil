package model.produto;

import java.math.BigDecimal;

public class ProdutoInfo {
    private final Classificacao classificacao;
    private final Preco preco;

    public ProdutoInfo(Classificacao classificacao, Preco preco) {
        this.classificacao = classificacao;
        this.preco = preco;
    }

    public Categoria captureCategoria() {
        return this.classificacao.getCategoria();
    }

    public BigDecimal capturePreco() {
        return this.preco.getPreco();
    }
}
