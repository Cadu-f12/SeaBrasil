package dao.produto;

import dao.Criacoes;
import model.produto.Produto;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CriacoesProduto implements Criacoes<Produto> {
    @Override
    public void criarId(Produto produtoComId) {
        String sql = "INSERT INTO produto (id, categoria, nome, preco) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, produtoComId.getProdutoId());
            pstmt.setString(2, produtoComId.getNomeCategoria());
            pstmt.setString(3, produtoComId.getNome());
            pstmt.setBigDecimal(4, produtoComId.getPreco());

            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void criarNome(Produto produtoComNome) {
        String sql = "INSERT INTO produto (categoria, nome, preco) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, produtoComNome.getNomeCategoria());
            pstmt.setString(2, produtoComNome.getNome());
            pstmt.setBigDecimal(3, produtoComNome.getPreco());

            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}