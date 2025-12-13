package dao.vendedordao;

import dao.ValidacaoId;
import model.vendedor.Vendedor;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class VendedorDAO {
    private final ValidacaoId validacaoId;
    private final Criacoes criacoes;
    private final Pesquisas pesquisas;
    private final Atualizacoes atualizacoes;
    private final Remocoes remocoes;

    public VendedorDAO() {
        this.validacaoId = new ValidacaoId();
        this.criacoes = new Criacoes();
        this.pesquisas = new Pesquisas();
        this.atualizacoes = new Atualizacoes();
        this.remocoes = new Remocoes();
    }

    /* Métodos de pesquisa */
    public Vendedor pesquisarPorId(Vendedor vendedorApenasId) {
        boolean b = validacaoId.existeIdVendedor(vendedorApenasId.getVendedorId());
        if (!b) {
            System.err.println("Exceção disparada de: VendedorDAO.pesquisarPorId");
            throw new NoSuchElementException("id_vendedor inválido: id não encontrado no sistema");
        }

        return pesquisas.obterPorId(vendedorApenasId);
    }
    public ArrayList<Vendedor> listar() {
        return pesquisas.listar();
    }

    /* Métodos de criação */
    public void criarComId(Vendedor vendedorComId) {
        boolean b = validacaoId.existeIdVendedor(vendedorComId.getVendedorId());
        if (b) {
            System.err.println("Exceção disparada de: VendedorDAO.criarComId");
            throw new NoSuchElementException("id_vendedor inválido: já existente no sistema");
        }

        criacoes.addComId(vendedorComId);
    }
    public void criarComNome(Vendedor vendedorComNome) {
        System.err.println("Exceção disparada de: VendedorDAO.criarComNome");
        criacoes.addComNome(vendedorComNome);
    }

    /* Métodos de atualização */
    public void atualizar(Vendedor novoVendedor) {
        boolean b = validacaoId.existeIdVendedor(novoVendedor.getVendedorId());
        if (!b) {
            System.err.println("Exceção disparada de: VendedorDAO.atualizar");
            throw new NoSuchElementException("id_vendedor inválido: id não encontrado no sistema");
        }

        atualizacoes.atualizar(novoVendedor);
    }

    /* Métodos de remoção */
    public void excluirPorId(Vendedor vendedorApenasId) {
        boolean b = validacaoId.existeIdVendedor(vendedorApenasId.getVendedorId());
        if (!b) {
            System.err.println("Exceção disparada de: VendedorDAO.excluirPorId");
            throw new NoSuchElementException("id_vendedor inválido: id não encontrado no sistema");
        }

        remocoes.removerPorId(vendedorApenasId);
    }
}