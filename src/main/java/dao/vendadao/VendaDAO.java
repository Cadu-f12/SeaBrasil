package dao.vendadao;

import dao.ValidacaoId;
import model.venda.Venda;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class VendaDAO {
    ValidacaoId validacaoId;
    Criacoes criacoes;
    Pesquisas pesquisas;
    Atualizacoes atualizacoes;
    Remocoes remocoes;

    public VendaDAO() {
        this.validacaoId = new ValidacaoId();
        this.criacoes = new Criacoes();
        this.pesquisas = new Pesquisas();
        this.atualizacoes = new Atualizacoes();
        this.remocoes = new Remocoes();
    }

    /* Métodos de pesquisa */
    public Venda pesquisarId(Venda vendaApenasComId) {
        boolean b = validacaoId.existeIdVenda(vendaApenasComId.getProdutoId());
        if (!b) {
            System.err.println("Exceção disparada de: VendaDAO.pesquisarId");
            throw new NoSuchElementException("id_venda inválido: não existente no sistema");
        }

        return pesquisas.lerId(vendaApenasComId);
    }
    public ArrayList<Venda> listar() {
        return pesquisas.listar();
    }

    /* Métodos de criação */
    public void resgistrarId(Venda venda) {
        boolean b = validacaoId.existeIdVenda(venda.getVendaId());
        if (b) {
            System.err.println("Exceção disparada de: VendaDAO.registrarId");
            throw new NoSuchElementException("id_venda inválido: já existente no sistema");
        }

        criacoes.addVendaComId(venda);
    }
    public void registrarNome(Venda venda) {

        criacoes.addVendaComNome(venda);
    }

    /* Métodos de atualização */
    public void substituir(Venda novaVenda) {
        boolean b = validacaoId.existeIdVenda(novaVenda.getVendaId());
        if (!b) {
            System.err.println("Exceção disparada de: VendaDAO.substituir");
            throw new NoSuchElementException("id_venda inválido: já existente no sistema");
        }

        atualizacoes.atualizar(novaVenda);
    }

    /* Métodos de remoção */
    public void removerId(Venda venda) {
        boolean b = validacaoId.existeIdVenda(venda.getVendaId());
        if (!b) {
            System.err.println("Exceção disparada de: VendaDAO.removerId");
            throw new NoSuchElementException("id_venda inválido: já existente no sistema");
        }

        remocoes.deletarId(venda);
    }
}