package dao.vendedordao;

import model.vendedor.Vendedor;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Criacoes {

    public void addVendedorComId(Vendedor vendedorComTudo) {
        String sql = "INSERT INTO vendedor (id, nome, telefone) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, vendedorComTudo.captureVendedorId());
            pstmt.setString(2, vendedorComTudo.captureNome());
            pstmt.setString(3, vendedorComTudo.captureTelefone());

            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void addVendedorComNome(Vendedor vendedorComNome) {
        String sql = "INSERT INTO vendedor (nome, telefone) VALUES (?, ?)";

        try (Connection conn = Conexao.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, vendedorComNome.captureNome());
            pstmt.setString(2, vendedorComNome.captureTelefone());

            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}