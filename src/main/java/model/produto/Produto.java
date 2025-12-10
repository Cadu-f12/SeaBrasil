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

    public String captureNomeCategoria() {
        return this.produtoInfo.captureNomeCategoria();
    }

    public String captureNome() {
        return this.produtoInfo.captureNome();
    }

    public BigDecimal capturePreco() {
        return this.produtoInfo.capturePreco();
    }
}