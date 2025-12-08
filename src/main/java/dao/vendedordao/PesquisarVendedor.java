package dao.vendedordao;

import dao.ValidacaoId;
import model.Id;
import model.vendedor.Vendedor;
import model.vendedor.VendedorInfo;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PesquisarVendedor {
    private final ValidacaoId validacaoId;

    public PesquisarVendedor() {
        this.validacaoId = new ValidacaoId();
    }

    public Vendedor obterVendedorPorId(int idVendedor) {
        existeId(idVendedor);
        String sql = "SELECT * FROM vendedor WHERE id = ?";
        Vendedor novoVendedor = null;

        try (Connection conn = Conexao.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idVendedor);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Id id = new VendedorId(rs.getInt("id"));
                VendedorInfo vendedorInfo = new VendedorInfo(rs.getString("nome"), rs.getString("telefone"));
                novoVendedor = new Vendedor(id, vendedorInfo);
            }

            rs.close();
            return novoVendedor;
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

    private void existeId(int id) {
        boolean flag = validacaoId.existeIdVendedor(id);
        if (!flag) {
            throw new RuntimeException("Vendedor não encontrado: o ID informado não existe no sistema.");
        }
    }
}