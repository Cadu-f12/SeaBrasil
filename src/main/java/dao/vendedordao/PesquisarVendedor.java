package dao.vendedordao;

import model.vendedor.IdVendedor;
import model.vendedor.Vendedor;
import model.vendedor.VendedorInfo;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PesquisarVendedor {
    Vendedor vendedor;

    public PesquisarVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Vendedor obterVendedorPorId() {
        String sql = "SELECT * FROM vendedor WHERE id = ?";
        IdVendedor novoIdVendedor = null;
        VendedorInfo novoVendedorInfo = null;
        Vendedor novoVendedor = null;


        try (Connection conn = Conexao.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, vendedor.getId());

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                novoIdVendedor = new IdVendedor(rs.getInt("id"));
                novoVendedorInfo = new VendedorInfo(rs.getString("nome"), rs.getString("telefone"));
                novoVendedor = new Vendedor(novoIdVendedor, novoVendedorInfo);
            }

            return vendedor;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void listarVendedores() {}

    public boolean existeId() {
        String sql = "SELECT * FROM vendedor WHERE id = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, vendedor.getId());

            ResultSet rs = pstmt.executeQuery();

            return rs.next();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}