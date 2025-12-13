package dao.vendedordao;

import model.vendedor.Vendedor;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Atualizacoes {

    protected void atualizar(Vendedor novoVendedor) {
        String sql = "UPDATE vendedor SET nome = ?, telefone = ? WHERE id = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, novoVendedor.getNome());
            pstmt.setString(2, novoVendedor.getTelefone());
            pstmt.setInt(3, novoVendedor.getVendedorId());

            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}