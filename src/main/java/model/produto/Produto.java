package model.produto;

public class Produto {
    private int id;
    private Classificacao classificacao;
    private double preco;

    public Produto(int id, Classificacao classificacao, double preco) {
        setId(id);
        setClassificacao(classificacao);
        setPreco(preco);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }
    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }

    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
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