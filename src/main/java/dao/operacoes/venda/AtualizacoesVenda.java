package dao.operacoes.venda;

import dao.operacoes.Atualizacoes;
import model.venda.Venda;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;

public class AtualizacoesVenda implements Atualizacoes<Venda> {

    @Override
    public void atualizar(Venda novaVenda) {
        String sql = """
                    UPDATE venda SET idvendedor = ?, idproduto = ?, formadepagamento = ?, data = ?, quantidade = ?, total = ?
                    WHERE id = ?;""";
        LocalDate novaData = LocalDate.parse(novaVenda.getData());
        java.sql.Date novaDataSql = java.sql.Date.valueOf(novaData);

        try (Connection conn = Conexao.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, novaVenda.getVendedorId());
            pstmt.setInt(2, novaVenda.getProdutoId());
            pstmt.setString(3, novaVenda.getPagamento());
            pstmt.setDate(4, novaDataSql);
            pstmt.setInt(5, novaVenda.getQuantidade());
            pstmt.setBigDecimal(6, novaVenda.getValorTotal());
            pstmt.setInt(7, novaVenda.getVendaId());

            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}