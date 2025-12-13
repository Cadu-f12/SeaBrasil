package model.produto;

import java.math.BigDecimal;

public class ProdutoInfo {
    private final Classificacao classificacao;
    private final Preco preco;

    public ProdutoInfo(Classificacao classificacao, Preco preco) {
        this.classificacao = classificacao;
        this.preco = preco;
    }

    String captureNomeCategoria() {
        return this.classificacao.getNomeCategoria();
    }

    String captureNome() {
        return this.classificacao.getNome();
    }

    BigDecimal capturePreco() {
        return this.preco.getPreco();
    }

    @Override
    public String toString() {
        return "ProdutoInfo{" +
                "classificacao=" + classificacao +
                ", preco=" + preco +
                '}';
    }
}
