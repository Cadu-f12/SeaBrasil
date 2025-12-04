package dao.vendedordao;

import model.vendedor.VendedorId;
import model.vendedor.Vendedor;
import model.vendedor.VendedorInfo;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PesquisarVendedor {
    Vendedor vendedor;

    public PesquisarVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Vendedor obterVendedorPorId() {
        String sql = "SELECT * FROM vendedor WHERE id = ?";
        VendedorId novoVendedorId = null;
        VendedorInfo novoVendedorInfo = null;
        Vendedor novoVendedor = null;

        try (Connection conn = Conexao.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, vendedor.getId());

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                novoVendedorId = new VendedorId(rs.getInt("id"));
                novoVendedorInfo = new VendedorInfo(rs.getString("nome"), rs.getString("telefone"));
                novoVendedor = new Vendedor(novoVendedorId, novoVendedorInfo);
            }

            rs.close();
            return vendedor;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Vendedor> listarVendedores() {
        String sql = "SELECT * FROM vendedor";
        ArrayList<Vendedor> vendedores = new ArrayList<>();

        try (Connection conn = Conexao.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                VendedorId vendedorId = new VendedorId(rs.getInt("id"));
                VendedorInfo vendedorInfo = new VendedorInfo(rs.getString("nome"), rs.getString("telefone"));
                Vendedor vendedor = new Vendedor(vendedorId, vendedorInfo);
                vendedores.add(vendedor);
            }

            return vendedores;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

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