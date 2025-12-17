package dao.operacoes.venda;

import dao.operacoes.Criacoes;
import model.venda.Venda;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CriacoesVenda implements Criacoes<Venda> {
    @Override
    public void criarId(Venda venda) {
        String sql  = """
                    INSERT INTO venda (id, idvendedor, idproduto, formadepagamento, data, quantidade, total)
                    VALUES (?, ?, ?, ?, ?, ?, ?);
                    """;

        try (Connection conn = Conexao.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, venda.getVendaId());
            pstmt.setInt(2, venda.getVendedorId());
            pstmt.setInt(3, venda.getProdutoId());
            pstmt.setString(4, venda.getPagamento());
            pstmt.setString(5, venda.getData());
            pstmt.setInt(6, venda.getQuantidade());
            pstmt.setBigDecimal(7, venda.getValorTotal());

            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void criarNome(Venda venda) {
        String sql  = """
                    INSERT INTO venda (idvendedor, idproduto, formadepagamento, data, quantidade, total)
                    VALUES (?, ?, ?, ?, ?, ?);
                    """;

        try (Connection conn = Conexao.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, venda.getVendedorId());
            pstmt.setInt(2, venda.getProdutoId());
            pstmt.setString(3, venda.getPagamento());
            pstmt.setString(4, venda.getData());
            pstmt.setInt(5, venda.getQuantidade());
            pstmt.setBigDecimal(6, venda.getValorTotal());

            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}