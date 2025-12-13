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

    public int getProdutoId() {
        return this.id.getId();
    }

    public String getNomeCategoria() {
        return this.produtoInfo.getNomeCategoria();
    }

    public String getNome() {
        return this.produtoInfo.getNome();
    }

    public BigDecimal getPreco() {
        return this.produtoInfo.getPreco();
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", produtoInfo=" + produtoInfo +
                '}';
    }
}