package model.vendedor;

import model.Id;

public class Vendedor {
    private Id id;
    private VendedorInfo vendedorInfo;

    public Vendedor(Id id, VendedorInfo vendedorInfo) {
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