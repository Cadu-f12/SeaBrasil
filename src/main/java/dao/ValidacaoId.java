package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ValidacaoId {

    public boolean existeIdVendedor(int id) {
        String sql = "SELECT * FROM vendedor WHERE id = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            return rs.next();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}