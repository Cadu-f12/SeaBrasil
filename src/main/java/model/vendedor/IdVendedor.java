package model.vendedor;

import dao.vendedordao.ValidacaoIdVendedor;
import model.Id;

public class IdVendedor extends Id {
    ValidacaoIdVendedor validacaoIdVendedor = new ValidacaoIdVendedor();


    public IdVendedor(int id) {
        super(id);
        validarUnicidade(id);
    }

    private void validarUnicidade(int id) {
        if (validacaoIdVendedor.existeId(id)) {
            throw new IllegalArgumentException("id_vendedor inválido: id duplicado detectado");
        }
    }
}