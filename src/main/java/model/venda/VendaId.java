package model.venda;

import dao.ValidacaoId;
import model.Id;

public class VendaId extends Id {

    public VendaId(int id) {
        super(id);
    }

    @Override
    public void validarUnicidade(int id) {
        ValidacaoId validacaoId = new ValidacaoId();

        if (validacaoId.existeIdVenda(id)) {
            System.err.println("Exceção disparado de: VendaId.validarUnicidade");
            throw new IllegalArgumentException("id_venda inválido: id duplicado detectado");
        }
    }
}
