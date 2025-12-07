package dao.vendedordao;

import model.vendedor.Vendedor;

import java.util.ArrayList;

public class VendedorDAO {
    private final CriarVendedor criarVendedor;
    private final PesquisarVendedor pesquisarVendedor;
    private final AtualizarVendedor atualizarVendedor;
    private final DeletarVendedor deletarVendedor;


    public VendedorDAO() {
        this.criarVendedor = new CriarVendedor();
        this.pesquisarVendedor = new PesquisarVendedor();
        this.atualizarVendedor = new AtualizarVendedor();
        this.deletarVendedor = new DeletarVendedor();

    }

    /* Métodos de pesquisa */
    public Vendedor pesquisaPorId(int id) {
        return pesquisarVendedor.obterVendedorPorId(id);
    }
    public ArrayList<Vendedor> listar() {
        return pesquisarVendedor.listarVendedores();
    }

    /* Métodos de criação */
    public void criarComId(Vendedor vendedorComId) {
        criarVendedor.addVendedorComId(vendedorComId);
    }
    public void criarComNome(Vendedor vendedorComNome) {
        criarVendedor.addVendedorComNome(vendedorComNome);
    }

    /* Métodos de atualização */

    /* Métodos de remoção */
    public void removerComId(int id) {
        deletarVendedor.deletarVendedorPorId(id);
    }
}