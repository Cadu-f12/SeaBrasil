package model.vendedor;

import dao.ValidacaoId;
import model.Id;

public class VendedorId extends Id {

    public VendedorId(int id) {
        super(id);
    }

    public void validarUnicidade(int id) {
        ValidacaoId validacaoId = new ValidacaoId();

        if (validacaoId.existeIdVendedor(id)) {
            throw new IllegalArgumentException("id_vendedor inválido: id duplicado detectado");
        }
    }
}