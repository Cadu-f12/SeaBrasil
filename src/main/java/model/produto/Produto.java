package model.produto;

import model.Id;

import java.math.BigDecimal;

public class Produto {
    private final Id id;
    private final ProdutoInfo produtoInfo;

    public Produto(Id id, ProdutoInfo produtoInfo) {
        this.id = id;
        this.produtoInfo = produtoInfo;
    }

    public int captureId() {
        return this.id.getId();
    }

    public Categoria captureProdutoInfoCategoria() {
        return this.produtoInfo.captureCategoria();
    }
    public BigDecimal captureProdutoInfoPreco() {
        return this.produtoInfo.capturePreco();
    }
}