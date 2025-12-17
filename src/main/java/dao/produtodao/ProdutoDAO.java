package dao.produtodao;

import dao.ValidacaoId;
import dao.operacoes.Criacoes;
import dao.operacoes.Pesquisas;
import dao.operacoes.produto.CriacoesProduto;
import dao.operacoes.produto.PesquisasProduto;
import model.produto.Produto;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ProdutoDAO {
    private final ValidacaoId validacaoId;
    private final Criacoes<Produto> criacoes;
    private final Pesquisas<Produto> pesquisas;
    private final Atualizacoes atualizacoes;
    private final Remocoes remocoes;


    public ProdutoDAO() {
        this.validacaoId = new ValidacaoId();
        this.criacoes = new CriacoesProduto();
        this.pesquisas = new PesquisasProduto();
        this.atualizacoes = new Atualizacoes();
        this.remocoes = new Remocoes();
    }

    /* Métodos de pesquisa */
    public Produto pesquisarId(Produto produtoComId) {
        boolean b = validacaoId.existeIdProduto(produtoComId.getProdutoId());
        if (!b) {
            System.err.println("Exceção disparada de: ProdutoDAO.pesquisarId");
            throw new NoSuchElementException("id_produto inválido: id não encontrado no sistema");
        }

        return pesquisas.lerId(produtoComId);
    }
    public ArrayList<Produto> listar() {
        return pesquisas.listar();
    }

    /* Métodos de criação */
    public void registrarId(Produto produtoComId) {
        boolean b = validacaoId.existeIdProduto(produtoComId.getProdutoId());
        if (b) {
            System.err.println("Exceção disparada de: ProdutoDAO.registrarId");
            throw new NoSuchElementException("id_produto inválido: já existente no sistema");
        }

        criacoes.criarId(produtoComId);
    }
    public void registrarNome(Produto produtoComNome) {
        criacoes.criarNome(produtoComNome);
    }

    /* Métodos de atualização */
    public void substituir(Produto novoProduto) {
        boolean b = validacaoId.existeIdProduto(novoProduto.getProdutoId());
        if (!b) {
            System.err.println("Exceção disparada de: ProdutoDAO.substituir");
            throw new NoSuchElementException("id_produto inválido: id não encontrado no sistema");
        }

        atualizacoes.atualizar(novoProduto);
    }

    /* Métodos de remoção */
    public void removerId(Produto produtoApenasId) {
        boolean b = validacaoId.existeIdProduto(produtoApenasId.getProdutoId());
        if (!b) {
            System.err.println("Exceção disparada de: ProdutoDAO.removerId");
            throw new NoSuchElementException("id_produto inválido: id não encontrado no sistema");
        }

        remocoes.deletarId(produtoApenasId);
    }
}