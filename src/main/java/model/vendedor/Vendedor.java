package model.vendedor;

import model.Id;

public class Vendedor {
    private final Id id;
    private final VendedorInfo vendedorInfo;

    public Vendedor(Id id, VendedorInfo vendedorInfo) {
        if (!(id instanceof VendedorId)) {
            System.err.println("Exceção disparado de: Vendedor");
            throw new IllegalArgumentException("Id inválido: a entidade Vendedor aceita apenas VendedorId");
        }

        this.id = id;
        this.vendedorInfo = vendedorInfo;
    }

    public int captureVendedorId() {
        return this.id.getId();
    }

    public String captureNome() {
        return this.vendedorInfo.getNome();
    }

    public String captureTelefone() {
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