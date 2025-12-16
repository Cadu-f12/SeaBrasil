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
    public Vendedor pesquisarId(Vendedor vendedorApenasId) {
        boolean b = validacaoId.existeIdVendedor(vendedorApenasId.getVendedorId());
        if (!b) {
            System.err.println("Exceção disparada de: VendedorDAO.pesquisarId");
            throw new NoSuchElementException("id_vendedor inválido: id não encontrado no sistema");
        }

        return pesquisas.lerId(vendedorApenasId);
    }
    public ArrayList<Vendedor> listar() {
        return pesquisas.listar();
    }

    /* Métodos de criação */
    public void registarId(Vendedor vendedorComId) {
        boolean b = validacaoId.existeIdVendedor(vendedorComId.getVendedorId());
        if (b) {
            System.err.println("Exceção disparada de: VendedorDAO.registrarId");
            throw new NoSuchElementException("id_vendedor inválido: já existente no sistema");
        }

        criacoes.criarId(vendedorComId);
    }
    public void registrarNome(Vendedor vendedorComNome) {
        System.err.println("Exceção disparada de: VendedorDAO.registrarNome");
        criacoes.criarNome(vendedorComNome);
    }

    /* Métodos de atualização */
    public void substituir(Vendedor novoVendedor) {
        boolean b = validacaoId.existeIdVendedor(novoVendedor.getVendedorId());
        if (!b) {
            System.err.println("Exceção disparada de: VendedorDAO.substituir");
            throw new NoSuchElementException("id_vendedor inválido: id não encontrado no sistema");
        }

        atualizacoes.atualizar(novoVendedor);
    }

    /* Métodos de remoção */
    public void removerId(Vendedor vendedorApenasId) {
        boolean b = validacaoId.existeIdVendedor(vendedorApenasId.getVendedorId());
        if (!b) {
            System.err.println("Exceção disparada de: VendedorDAO.removerId");
            throw new NoSuchElementException("id_vendedor inválido: id não encontrado no sistema");
        }

        remocoes.deletarId(vendedorApenasId);
    }
}