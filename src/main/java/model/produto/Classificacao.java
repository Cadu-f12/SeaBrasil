package model.produto;

public class Classificacao {
    private Categoria categoria;
    private String nome;

    public Classificacao(Categoria categoria, String nome) {
        setCategoria(categoria);
        setNome(nome);
    }

    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Classificacao{" +
                "categoria=" + categoria +
                ", nome='" + nome + '\'' +
                '}';
    }
}