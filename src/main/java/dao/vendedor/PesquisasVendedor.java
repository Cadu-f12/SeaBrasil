package dao.vendedor;

import dao.Pesquisas;
import model.Id;
import model.vendedor.Vendedor;
import model.vendedor.VendedorInfo;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PesquisasVendedor implements Pesquisas<Vendedor> {

    @Override
    public Vendedor lerId(Vendedor vendedorApenasComId) {
        String sql = "SELECT * FROM vendedor WHERE id = ?";
        Vendedor novoVendedor = null;

        try (Connection conn = Conexao.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, vendedorApenasComId.getVendedorId());
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Id id = new Id(rs.getInt("id"));
                VendedorInfo vendedorInfo = new VendedorInfo(rs.getString("nome"), rs.getString("telefone"));
                novoVendedor = new Vendedor(id, vendedorInfo);
            }

            rs.close();
            return novoVendedor;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Vendedor> listar() {
        String sql = "SELECT * FROM vendedor";
        ArrayList<Vendedor> vendedores = new ArrayList<>();

        try (Connection conn = Conexao.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Id vendedorId = new Id(rs.getInt("id"));
                VendedorInfo vendedorInfo = new VendedorInfo(rs.getString("nome"), rs.getString("telefone"));
                Vendedor vendedor = new Vendedor(vendedorId, vendedorInfo);
                vendedores.add(vendedor);
            }

            return vendedores;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}