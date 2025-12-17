package dao.vendedor;

import dao.Criacoes;
import model.vendedor.Vendedor;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CriacoesVendedor implements Criacoes<Vendedor> {
    @Override
    public void criarId(Vendedor vendedorComTudo) {
        String sql = "INSERT INTO vendedor (id, nome, telefone) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, vendedorComTudo.getVendedorId());
            pstmt.setString(2, vendedorComTudo.getNome());
            pstmt.setString(3, vendedorComTudo.getTelefone());

            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void criarNome(Vendedor vendedorComNome) {
        String sql = "INSERT INTO vendedor (nome, telefone) VALUES (?, ?)";

        try (Connection conn = Conexao.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, vendedorComNome.getNome());
            pstmt.setString(2, vendedorComNome.getTelefone());

            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}