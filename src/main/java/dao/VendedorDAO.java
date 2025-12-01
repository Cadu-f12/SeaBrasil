package dao;

import model.vendedor.Vendedor;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VendedorDAO {

    public void addVendedor(Vendedor vendedor) {
        String sql  = "INSERT INTO vendedor (id, nome, telefone) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, vendedor.getId());
            pstmt.setString(2, vendedor.getInfoNome());
            pstmt.setString(3, vendedor.getInfoTelefone());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao acessar o banco de dados: operação não pôde ser concluída.");
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro inesperado durante a execução: " + e);
        }
    }
}
