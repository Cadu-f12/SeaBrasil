package dao.vendedordao;

import model.vendedor.Vendedor;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Remocoes {

    protected void deletarVendedorPorId(Vendedor vendedorApenasComId) {
        String sql = "DELETE FROM vendedor WHERE id = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, vendedorApenasComId.captureVendedorId());

            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}