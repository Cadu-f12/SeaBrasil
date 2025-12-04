package model.produto;

import dao.ValidacaoId;
import model.Id;

public class ProdutoId extends Id {

    public ProdutoId(int id) {
        super(id);
    }

    @Override
    public void validarUnicidade(int id) {
        ValidacaoId validacaoId = new ValidacaoId();

        if (validacaoId.existeIdProduto(id)) {
            System.err.println("Exceção disparado de: ProdutoId.validarUnicidade");
            throw new IllegalArgumentException("id_produto inválido: id duplicado detectado");
        }
    }
}
