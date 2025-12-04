package model.produto;

public class Classificacao {
    private Categoria categoria;
    private String nome;

    public Classificacao(Categoria categoria, String nome) {
        setCategoria(categoria);
        setNome(nome);
    }

    protected Categoria getCategoria() {
        return categoria;
    }
    protected void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    protected String getNome() {
        return nome;
    }
    protected void setNome(String nome) {
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