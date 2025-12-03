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
        this.nome = nome;
    }

    protected String getTelefone() {
        return telefone;
    }
    protected void setTelefone(String telefone) {
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