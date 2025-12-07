package dao.vendedordao;

import model.vendedor.Vendedor;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CriarVendedor {
    Vendedor vendedor;

    public CriarVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public void addVendedorComId() {
        String sql = "INSERT INTO vendedor (id, nome, telefone) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, vendedor.captureVendedorId());
            pstmt.setString(2, vendedor.captureNome());
            pstmt.setString(3, vendedor.captureTelefone());

            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void addVendedorComNome() {
        String sql = "INSERT INTO vendedor (nome, telefone) VALUES (?, ?)";

        try (Connection conn = Conexao.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, vendedor.captureNome());
            pstmt.setString(2, vendedor.captureTelefone());

            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}