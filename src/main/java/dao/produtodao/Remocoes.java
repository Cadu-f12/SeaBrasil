package dao.produtodao;

import model.produto.Produto;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Remocoes {

    public void deletarId(Produto produto){
        String sql = "DELETE FROM produto WHERE id = ?";

        try (Connection conn = Conexao.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, produto.getProdutoId());

            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}