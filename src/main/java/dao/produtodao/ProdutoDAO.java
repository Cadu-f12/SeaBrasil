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

    /* Métodos de pesquisa */
    public Produto pesquisarId(Produto produtoComId) {
        boolean b = validacaoId.existeIdProduto(produtoComId.getProdutoId());
        if (!b) {
            System.err.println("Exceção disparada de: ProdutoDAO.pesquisarId");
            throw new NoSuchElementException("id_produto inválido: não existente no sistema");
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
            System.err.println("Exceção disparada de: ProdutoDAO.criarComId");
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
    public void removerId(Produto produto) {
        boolean b = validacaoId.existeIdProduto(produto.getProdutoId());
        if (!b) {
            System.err.println("Exceção disparada de: ProdutoDAO.removerId");
            throw new NoSuchElementException("id_produto inválido: não existente no sistema");
        }

        remocoes.deletarId(produto);
    }

}