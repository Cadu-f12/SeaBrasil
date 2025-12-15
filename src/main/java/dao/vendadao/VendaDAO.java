package dao.vendadao;

import dao.ValidacaoId;
import model.venda.Venda;

import java.util.NoSuchElementException;

public class VendaDAO {
    ValidacaoId validacaoId;
    Criacoes criacoes;

    public VendaDAO() {
        validacaoId = new ValidacaoId();
        this.criacoes = new Criacoes();
    }

    /* Métodos de criação */
    public void criarComId(Venda venda) {
        boolean b = validacaoId.existeIdProduto(venda.getVendaId());
        if (b) {
            System.err.println("Exceção disparada de: VendaDAO.criarComId");
            throw new NoSuchElementException("id_venda inválido: já existente no sistema");
        }

        criacoes.addVendaComId(venda);
    }
    public void criarComNome(Venda venda) {

        criacoes.addVendaComNome(venda);
    }
}
