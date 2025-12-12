package dao.produtodao;

import dao.ValidacaoId;
import model.produto.Produto;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ProdutoDAO {
    ValidacaoId validacaoId;
    Criacoes criacoes;
    Pesquisas pesquisas;
    Atualizacoes atualizacoes;
    Remocoes remocoes;


    public ProdutoDAO() {
        this.validacaoId = new ValidacaoId();
        this.criacoes = new Criacoes();
        this.pesquisas = new Pesquisas();
        this.atualizacoes = new Atualizacoes();
        this.remocoes = new Remocoes();
    }

    /* Métodos de criação */
    public void criarComId(Produto produtoComId) {
        boolean b = validacaoId.existeIdProduto(produtoComId.captureId());
        if (b) {
            System.err.println("Exceção disparada de: ProdutoDAO.criarComId");
            throw new NoSuchElementException("id_produto inválido: já existente no sistema");
        }

        criacoes.addProdutoComId(produtoComId);
    }
    public void criarComNome(Produto produtoComNome) {
        criacoes.addProdutoComNome(produtoComNome);
    }

    /* Métodos de pesquisa */
    public Produto pesquisarPorId(Produto produtoComId) {
        boolean b = validacaoId.existeIdProduto(produtoComId.captureId());
        if (!b) {
            System.err.println("Exceção disparada de: ProdutoDAO.pesquisarPorId");
            throw new NoSuchElementException("id_produto inválido: não existente no sistema");
        }

        return pesquisas.obterProdutoPorId(produtoComId);
    }
    public ArrayList<Produto> listar() {
        return pesquisas.listar();
    }

    /* Métodos de atualização */
    public void atualizar(Produto novoProduto) {
        System.err.println("Exceção disparada de: ProdutoDAO.atualizar");
        boolean b = validacaoId.existeIdProduto(novoProduto.captureId());
        if (!b) {
            throw new NoSuchElementException("id_produto inválido: id não encontrado no sistema");
        }

        atualizacoes.atualizar(novoProduto);
    }

    /* Métodos de remoção */
    public void excluir(Produto produto) {
        boolean b = validacaoId.existeIdProduto(produto.captureId());
        if (!b) {
            System.err.println("Exceção disparada de: ProdutoDAO.excluir");
            throw new NoSuchElementException("id_produto inválido: não existente no sistema");
        }

        remocoes.removerPorId(produto);
    }

}