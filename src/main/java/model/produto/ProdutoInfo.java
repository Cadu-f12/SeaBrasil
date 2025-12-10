package model.produto;

import java.math.BigDecimal;

public class ProdutoInfo {
    private final Classificacao classificacao;
    private final Preco preco;

    public ProdutoInfo(Classificacao classificacao, Preco preco) {
        this.classificacao = classificacao;
        this.preco = preco;
    }

    public String captureNomeCategoria() {
        return this.classificacao.getNomeCategoria();
    }

    public String captureNome() {
        return this.classificacao.getNome();
    }

    public BigDecimal capturePreco() {
        return this.preco.getPreco();
    }
}
