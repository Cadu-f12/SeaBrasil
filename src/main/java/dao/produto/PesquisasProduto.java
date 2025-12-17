package dao.produto;

import dao.Pesquisas;
import model.Id;
import model.produto.*;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PesquisasProduto implements Pesquisas<Produto> {

    @Override
    public Produto lerId(Produto produtoApenasComId) {
        String sql = "SELECT * FROM produto WHERE id = ?";

        try (Connection conn = Conexao.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, produtoApenasComId.getProdutoId());

            ResultSet rs = pstmt.executeQuery();
            Produto produto = null;
            while (rs.next()) {
                Id idProduto = new Id(rs.getInt("id"));
                Classificacao classificacao = new Classificacao(Categoria.valueOf(rs.getString("categoria")), rs.getString("nome"));
                Preco preco = new Preco(rs.getBigDecimal("preco"));
                ProdutoInfo produtoInfo = new ProdutoInfo(classificacao, preco);
                produto = new Produto(idProduto, produtoInfo);
            }

            rs.close();
            return produto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Produto> listar() {
        String sql = "SELECT * FROM produto";
        ArrayList<Produto> produtos = new ArrayList<>();

        try (Connection conn = Conexao.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Id idProduto = new Id(rs.getInt("id"));
                Classificacao classificacao =  new Classificacao(Categoria.valueOf(rs.getString("categoria")), rs.getString("nome"));
                Preco preco = new Preco(rs.getBigDecimal("preco"));
                ProdutoInfo produtoInfo = new ProdutoInfo(classificacao, preco);
                Produto produto = new Produto(idProduto, produtoInfo);
                produtos.add(produto);
            }

            return produtos;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}