package model.vendedor;

import model.Id;

public class Vendedor {
    private Id id;
    private VendedorInfo vendedorInfo;

    public Vendedor(Id id, VendedorInfo vendedorInfo) {
        if (!(id instanceof VendedorId)) {
            System.err.println("Exceção disparado de: Vendedor");
            throw new IllegalArgumentException("Id inválido: a entidade Vendedor aceita apenas VendedorId");
        }

        this.id = id;
        this.vendedorInfo = vendedorInfo;
    }

    public int getIdVendedor() {
        return this.id.getId();
    }

    public VendedorInfo getVendedorInfo() {
        return vendedorInfo;
    }

    public String getInfoNome() {
        return this.vendedorInfo.getNome();
    }
    public void ChangeNome(String nome) {
        this.vendedorInfo.setNome(nome);
    }

    public String getInfoTelefone() {
        return this.vendedorInfo.getTelefone();
    }
    public void ChangeTelefone(String telefone) {
        vendedorInfo.setTelefone(telefone);
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "id=" + id +
                ", vendedorInfo=" + vendedorInfo +
                '}';
    }
}