package model.produto;

public class Produto {
    private int id;
    private Classificacao classificacao;
    private double preco;

    public Produto(int id, Classificacao classificacao, double preco) {
        this.id = id;
        this.classificacao = classificacao;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public double getPreco() {
        return preco;
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