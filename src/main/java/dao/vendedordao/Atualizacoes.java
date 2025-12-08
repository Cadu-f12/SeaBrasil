package dao.vendedordao;

import model.vendedor.Vendedor;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Atualizacoes {

    public void atualizarDados(Vendedor novoVendedor) {
        String sql = "UPDATE vendedor SET id = ?, nome = ?, telefone = ? WHERE id = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, novoVendedor.captureVendedorId());
            pstmt.setString(2, novoVendedor.captureNome());
            pstmt.setString(3, novoVendedor.captureTelefone());
            pstmt.setInt(4, novoVendedor.captureVendedorId());

            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}