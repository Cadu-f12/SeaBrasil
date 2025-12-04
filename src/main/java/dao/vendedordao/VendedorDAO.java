package dao.vendedordao;

import model.vendedor.Vendedor;

import java.util.ArrayList;

public class VendedorDAO {
    private final Vendedor vendedor;

    public VendedorDAO(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public void AdicionarRegistro() {
        CriarVendedor criarVendedor = new CriarVendedor(vendedor);
        criarVendedor.addVendedor();
    }

    public Vendedor SelecionarVendedor() {
        PesquisarVendedor pesquisarVendedor = new PesquisarVendedor(vendedor);
        return pesquisarVendedor.obterVendedorPorId();
    }

    public ArrayList<Vendedor> ListarVendedores() {
        PesquisarVendedor pesquisarVendedor = new PesquisarVendedor(vendedor);
        return pesquisarVendedor.listarVendedores();
    }

    public boolean VerificarId(int id) {
        PesquisarVendedor pesquisarVendedor = new PesquisarVendedor(vendedor);
        return pesquisarVendedor.existeId();
    }
}