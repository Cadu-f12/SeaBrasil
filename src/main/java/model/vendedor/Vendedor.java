package model.vendedor;

import model.Id;

public class Vendedor {
    private final Id id;
    private final VendedorInfo vendedorInfo;

    public Vendedor(Id id, VendedorInfo vendedorInfo) {
        this.id = id;
        this.vendedorInfo = vendedorInfo;
    }

    public int getVendedorId() {
        return this.id.getId();
    }

    public String getNome() {
        return this.vendedorInfo.getNome();
    }

    public String getTelefone() {
        return this.vendedorInfo.getTelefone();
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "id=" + id +
                ", vendedorInfo=" + vendedorInfo +
                '}';
    }
}