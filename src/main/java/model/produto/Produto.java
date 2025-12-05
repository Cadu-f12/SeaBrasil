package model.produto;

import model.Id;

import java.math.BigDecimal;

public class Produto {
    private final Id id;
    private final Classificacao classificacao;
    private final Preco preco;

    public Produto(Id id, Classificacao classificacao, Preco preco) {
        if (!(id instanceof ProdutoId)) {
            System.err.println("Exceção disparado de: Produto");
            throw new IllegalArgumentException("Id inválido: a entidade Produto aceita apenas ProdutoId");
        }

        this.id = id;
        this.classificacao = classificacao;
        this.preco = preco;
    }

    public int captureId() {
        return this.id.getId();
    }
    public void changeId(int id) {
        this.id.setId(id);
    }

    public Categoria captureClassificacaoCategoria() {
        return this.classificacao.getCategoria();
    }
    public void changeClassificacaoCategoria(Categoria categoria) {
        this.classificacao.setCategoria(categoria);
    }

    public String captureClassificacaoNome() {
        return this.classificacao.getNome();
    }
    public void changeClassificacaoNome(String nome) {
        classificacao.setNome(nome);
    }

    public BigDecimal capturePreco() {
        return preco.getPreco();
    }
    public void changePreco(BigDecimal valor) {
        preco.setPreco(valor);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", classificacao=" + classificacao +
                ", preco=" + preco +
                '}';
    }
}