package dao.operacoes.produto;

import dao.operacoes.Atualizacoes;
import model.produto.Produto;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AtualizacoesProduto implements Atualizacoes<Produto> {

    @Override
    public void atualizar(Produto novoProduto) {
        String sql = "UPDATE produto SET categoria = ?, nome = ?, preco = ? WHERE id = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, novoProduto.getNomeCategoria());
            pstmt.setString(2, novoProduto.getNome());
            pstmt.setBigDecimal(3, novoProduto.getPreco());
            pstmt.setInt(4, novoProduto.getProdutoId());

            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}