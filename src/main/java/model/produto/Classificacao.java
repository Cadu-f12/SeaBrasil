package model.produto;

public class Classificacao {
    private Categoria categoria;
    private String nome;

    public Classificacao(Categoria categoria, String nome) {
        setCategoria(categoria);
        setNome(nome);
    }

    protected String getNomeCategoria() {
        return categoria.name();
    }
    protected void setCategoria(Categoria categoria) {
        if (categoria == null) {
            System.err.println("Exceção disparado de: Classificacao.setCategoria");
            throw new IllegalArgumentException("categoria inválida: valor null não é permitido");
        }

        this.categoria = categoria;
    }

    protected String getNome() {
        return nome;
    }
    protected void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            System.err.println("Exceção disparado de: Classificacao.setNome");
            throw new IllegalArgumentException("nome inválido: valor vazio ou null não é permitido");
        }
        if (nome.length() < 2 || nome.length() > 50) {
            System.err.println("Exceção disparado de: Classificacao.setNome");
            throw new IllegalArgumentException("nome inválido: o tamanho deve estar entre 2 e 50 caracteres");
        }
        if (!nome.matches("[\\p{L} ]+")) {
            System.err.println("Exceção disparada de: Classificacao.setNome");
            throw new IllegalArgumentException("nome inválido: apenas letras e espaços são permitidos");
        }

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