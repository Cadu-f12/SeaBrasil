package dao.vendedordao;

import model.vendedor.Vendedor;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CriarVendedor {
    Vendedor vendedor;

    public CriarVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public void addVendedor() {
    }
}