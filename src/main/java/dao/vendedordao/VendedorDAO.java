package dao.vendedordao;

import model.vendedor.IdVendedor;
import model.vendedor.Vendedor;
import model.vendedor.VendedorInfo;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VendedorDAO {

    public void AdicionarRegistro(int id, String nome, String telefone) {
        Vendedor vendedor = null;

        try {
            IdVendedor idVendedor = new IdVendedor(id);
            VendedorInfo VendedorInfo = new VendedorInfo(nome, telefone);
            vendedor = new Vendedor(idVendedor, VendedorInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            CriarVendedor criar = new CriarVendedor(vendedor);
            criar.addVendedor();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
