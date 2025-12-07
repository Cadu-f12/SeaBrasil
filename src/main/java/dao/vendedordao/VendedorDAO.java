package dao.vendedordao;

import model.vendedor.Vendedor;

import java.util.ArrayList;

public class VendedorDAO {
    private int id;
    private Vendedor vendedor;

    public VendedorDAO(int id, Vendedor vendedor) {
        this.id = id;
        this.vendedor = vendedor;
    }
    public VendedorDAO(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    public VendedorDAO(int id) {
        this.id = id;
    }

    /* Métodos de pesquisa */
    public Vendedor pesquisaPorId() {
        PesquisarVendedor pesquisarVendedor = new PesquisarVendedor(this.id);
        return pesquisarVendedor.obterVendedorPorId();
    }
    public ArrayList<Vendedor> listar() {
        PesquisarVendedor pesquisarVendedor = new PesquisarVendedor(this.id);
        return pesquisarVendedor.listarVendedores();
    }

    /* Métodos de criação */
    public void criarComId() {
        CriarVendedor criarVendedor = new CriarVendedor(vendedor);
        criarVendedor.addVendedorComId();
    }
    public void criarComNome() {
        CriarVendedor criarVendedor  = new CriarVendedor(vendedor);
        criarVendedor.addVendedorComNome();
    }

}