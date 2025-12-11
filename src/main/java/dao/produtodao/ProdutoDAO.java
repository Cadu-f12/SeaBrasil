package dao.produtodao;

import dao.ValidacaoId;
import model.produto.Produto;

import java.util.NoSuchElementException;

public class ProdutoDAO {
    ValidacaoId validacaoId;
    Criacoes criacoes = new Criacoes();

    public ProdutoDAO() {
        this.validacaoId = new ValidacaoId();
        this.criacoes = new Criacoes();
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
}