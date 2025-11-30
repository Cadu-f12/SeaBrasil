package model.vendedor;

public class Vendedor {
    private int id;
    private VendedorInfo vendedorInfo;

    public Vendedor(int id, VendedorInfo vendedorInfo) {
        this.id = id;
        this.vendedorInfo = vendedorInfo;
    }

    public int getId() {
        return id;
    }

    public VendedorInfo getVendedorInfo() {
        return vendedorInfo;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "id=" + id +
                ", vendedorInfo=" + vendedorInfo +
                '}';
    }
}