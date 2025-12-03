package model.vendedor;

public class Vendedor {
    private IdVendedor id;
    private VendedorInfo vendedorInfo;

    public Vendedor(IdVendedor id, VendedorInfo vendedorInfo) {
        setIdVendedor(id);
        setVendedorInfo(vendedorInfo);
    }

    public int getId() {
        return this.id.getId();
    }
    public void setIdVendedor(IdVendedor id) {
        this.id = id;
    }

    public VendedorInfo getVendedorInfo() {
        return vendedorInfo;
    }
    public void setVendedorInfo(VendedorInfo vendedorInfo) {
        this.vendedorInfo = vendedorInfo;
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