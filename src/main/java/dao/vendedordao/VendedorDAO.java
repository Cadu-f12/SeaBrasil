package dao.vendedordao;

import model.vendedor.Vendedor;

import java.util.ArrayList;

public class VendedorDAO {
    private final Criacoes criacoes;
    private final Pesquisas pesquisas;
    private final Atualizacoes atualizacoes;
    private final Remocoes remocoes;

    public VendedorDAO() {
        this.criacoes = new Criacoes();
        this.pesquisas = new Pesquisas();
        this.atualizacoes = new Atualizacoes();
        this.remocoes = new Remocoes();
    }

    /* Métodos de pesquisa */
    public Vendedor pesquisarPorId(Vendedor vendedorApenasId) {
        return pesquisas.obterVendedorPorId(vendedorApenasId);
    }
    public ArrayList<Vendedor> listar() {
        return pesquisas.listarVendedores();
    }

    /* Métodos de criação */
    public void criarComId(Vendedor vendedorComId) {
        criacoes.addVendedorComId(vendedorComId);
    }
    public void criarComNome(Vendedor vendedorComNome) {
        criacoes.addVendedorComNome(vendedorComNome);
    }

    /* Métodos de atualização */
    public void atualizar(Vendedor novoVendedor) {
        atualizacoes.atualizarDados(novoVendedor);
    }

    /* Métodos de remoção */
    public void removerComId(Vendedor vendedorApenasId) {
        remocoes.deletarVendedorPorId(vendedorApenasId);
    }
}