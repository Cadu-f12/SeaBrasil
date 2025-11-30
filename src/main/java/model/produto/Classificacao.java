package model.produto;

public class Classificacao {
    private Categoria categoria;
    private String nome;

    public Classificacao(Categoria categoria, String nome) {
        this.categoria = categoria;
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Classificacao{" +
                "categoria=" + categoria +
                ", nome='" + nome + '\'' +
                '}';
    }
}