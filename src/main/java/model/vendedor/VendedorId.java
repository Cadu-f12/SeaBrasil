package model.vendedor;

import dao.ValidacaoId;
import model.Id;

public class VendedorId extends Id {

    public VendedorId(int id) {
        super(id);
    }

    @Override
    public void validarUnicidade(int id) {
        ValidacaoId validacaoId = new ValidacaoId();

        if (validacaoId.existeIdVendedor(id)) {
            System.err.println("Exceção disparado de: VendedorId.validarUnicidade");
            throw new IllegalArgumentException("id_vendedor inválido: id duplicado detectado");
        }
    }
}