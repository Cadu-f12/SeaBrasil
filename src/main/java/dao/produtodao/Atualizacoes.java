package dao.produtodao;

import model.produto.Produto;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Atualizacoes {

    public void atualizar(Produto novoProduto) {
        String sql = "UPDATE produto SET categoria = ?, nome = ?, preco = ? WHERE id = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, novoProduto.captureNomeCategoria());
            pstmt.setString(2, novoProduto.captureNome());
            pstmt.setBigDecimal(3, novoProduto.capturePreco());
            pstmt.setInt(4, novoProduto.captureId());

            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}