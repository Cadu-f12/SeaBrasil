package model.vendedor;

public class VendedorInfo {
    private String nome;
    private String telefone; // campo opcional

    public VendedorInfo(String nome, String telefone) {
        setNome(nome);
        setTelefone(telefone);
    }

    protected String getNome() {
        return nome;
    }
    protected void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            System.err.println("Exceção disparado de: VendedorInfo.setNome");
            throw new IllegalArgumentException("nome inválido: valor vazio ou null não é permitido");
        }
        if (nome.length() < 2 || nome.length() > 100) {
            System.err.println("Exceção disparado de: VendedorInfo.setNome");
            throw new IllegalArgumentException("nome inválido: o tamanho deve estar entre 2 e 100 caracteres");
        }
        if (!nome.matches("[\\p{L} ]+")) {
            System.err.println("Exceção disparada de: VendedorInfo.setNome");
            throw new IllegalArgumentException("nome inválido: apenas letras e espaços são permitidos");
        }

        this.nome = nome;
    }

    protected String getTelefone() {
        return telefone;
    }
    protected void setTelefone(String telefone) {
        if (telefone == null) {
            this.telefone = null;
            return;
        }
        if (telefone.isEmpty()) {
            System.err.println("Exceção disparado de: VendedorInfo.setTelefone");
            throw new IllegalArgumentException("telefone inválido: valor vazio não é permitido");
        }
        if (!telefone.matches("\\d+")) {
            System.err.println("Exceção disparado de: VendedorInfo.setTelefone");
            throw new IllegalArgumentException("telefone inválido: apenas números são permitidos");
        }
        if (telefone.length() < 8 || telefone.length() > 45) {
            System.err.println("Exceção disparado de: VendedorInfo.setTelefone");
            throw new IllegalArgumentException("telefone inválido: o tamanho deve estar entre 8 e 45 números");
        }

        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "VendedorInfo{" +
                "nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}