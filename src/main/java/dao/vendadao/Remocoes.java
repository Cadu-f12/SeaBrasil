package dao.vendadao;

import model.venda.Venda;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Remocoes {

    public void deletarId(Venda venda) {
        String sql = "DELETE FROM venda WHERE id = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, venda.getVendaId());

            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}