package dao.vendadao;

import dao.ValidacaoId;
import dao.operacoes.Criacoes;
import dao.operacoes.Pesquisas;
import dao.operacoes.venda.CriacoesVenda;
import dao.operacoes.venda.PesquisasVenda;
import model.venda.Venda;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class VendaDAO {
    private final ValidacaoId validacaoId;
    private final Criacoes<Venda> criacoes;
    private final Pesquisas<Venda> pesquisas;
    private final Atualizacoes atualizacoes;
    private final Remocoes remocoes;

    public VendaDAO() {
        this.validacaoId = new ValidacaoId();
        this.criacoes = new CriacoesVenda();
        this.pesquisas = new PesquisasVenda();
        this.atualizacoes = new Atualizacoes();
        this.remocoes = new Remocoes();
    }

    /* Métodos de pesquisa */
    public Venda pesquisarId(Venda vendaApenasComId) {
        boolean b = validacaoId.existeIdVenda(vendaApenasComId.getProdutoId());
        if (!b) {
            System.err.println("Exceção disparada de: VendaDAO.pesquisarId");
            throw new NoSuchElementException("id_venda inválido: id não encontrado no sistema");
        }

        return pesquisas.lerId(vendaApenasComId);
    }
    public ArrayList<Venda> listar() {
        return pesquisas.listar();
    }

    /* Métodos de criação */
    public void resgistrarId(Venda vendaComId) {
        boolean b = validacaoId.existeIdVenda(vendaComId.getVendaId());
        if (b) {
            System.err.println("Exceção disparada de: VendaDAO.registrarId");
            throw new NoSuchElementException("id_venda inválido: já existente no sistema");
        }

        criacoes.criarId(vendaComId);
    }
    public void registrarNome(Venda vendaComNome) {

        criacoes.criarNome(vendaComNome);
    }

    /* Métodos de atualização */
    public void substituir(Venda novaVenda) {
        boolean b = validacaoId.existeIdVenda(novaVenda.getVendaId());
        if (!b) {
            System.err.println("Exceção disparada de: VendaDAO.substituir");
            throw new NoSuchElementException("id_venda inválido: id não encontrado no sistema");
        }

        atualizacoes.atualizar(novaVenda);
    }

    /* Métodos de remoção */
    public void removerId(Venda vendaApenasId) {
        boolean b = validacaoId.existeIdVenda(vendaApenasId.getVendaId());
        if (!b) {
            System.err.println("Exceção disparada de: VendaDAO.removerId");
            throw new NoSuchElementException("id_venda inválido: já existente no sistema");
        }

        remocoes.deletarId(vendaApenasId);
    }
}