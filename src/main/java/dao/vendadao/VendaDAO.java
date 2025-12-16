package dao.vendadao;

import dao.ValidacaoId;
import model.venda.Venda;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class VendaDAO {
    ValidacaoId validacaoId;
    Criacoes criacoes;
    Pesquisas pesquisas;

    public VendaDAO() {
        this.validacaoId = new ValidacaoId();
        this.criacoes = new Criacoes();
        this.pesquisas = new Pesquisas();
    }

    /* Métodos de pesquisa */
    public Venda pesquisarId(Venda vendaApenasComId) {
        boolean b = validacaoId.existeIdProduto(vendaApenasComId.getProdutoId());
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
        boolean b = validacaoId.existeIdProduto(venda.getVendaId());
        if (b) {
            System.err.println("Exceção disparada de: VendaDAO.criarComId");
            throw new NoSuchElementException("id_venda inválido: já existente no sistema");
        }

        criacoes.addVendaComId(venda);
    }
    public void registrarNome(Venda venda) {

        criacoes.addVendaComNome(venda);
    }
}