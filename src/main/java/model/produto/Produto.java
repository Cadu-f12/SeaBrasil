package model.produto;

import model.Id;

import java.math.BigDecimal;

public class Produto {
    private final Id id;
    private final Classificacao classificacao;
    private final Preco preco;

    public Produto(Id id, Classificacao classificacao, Preco preco) {
        if (!(id instanceof ProdutoId)) {
            System.err.println("Exceção disparado de: Vendedor");
            throw new IllegalArgumentException("Id inválido: a entidade Vendedor aceita apenas VendedorId");
        }
        this.id = id;
        this.classificacao = classificacao;
        this.preco = preco;
    }

    public int getId() {
        return this.id.getId();
    }
    public void setId(int id) {
        this.id.setId(id);
    }

    public Categoria getClassificacaoCategoria() {
        return this.classificacao.getCategoria();
    }
    public void ChangeClassificacaoCategoria(Categoria categoria) {
        this.classificacao.setCategoria(categoria);
    }

    public String getClassificacaoNome() {
        return this.classificacao.getNome();
    }
    public void ChangeClassificacaoNome(String nome) {
        classificacao.setNome(nome);
    }

    public BigDecimal getPreco() {
        return preco.getPreco();
    }
    public void ChangePreco(BigDecimal valor) {
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