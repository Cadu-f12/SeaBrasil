package dao.produtodao;

import model.produto.Produto;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Criacoes {

    public void addProdutoComId(Produto produtoComId) {
        String sql = "INSERT INTO produto (id, categoria, nome, preco) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, produtoComId.captureId());
            pstmt.setString(2, produtoComId.captureNomeCategoria());
            pstmt.setString(3, produtoComId.captureNome());
            pstmt.setBigDecimal(4, produtoComId.capturePreco());

            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void addProdutoComNome(Produto produtoComNome) {
        String sql = "INSERT INTO produto (categoria, nome, preco) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, produtoComNome.captureNomeCategoria());
            pstmt.setString(2, produtoComNome.captureNome());
            pstmt.setBigDecimal(3, produtoComNome.capturePreco());

            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}