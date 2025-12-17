package dao.operacoes.venda;

import dao.operacoes.Pesquisas;
import dao.ProdutoDAO;
import dao.VendedorDAO;
import model.Id;
import model.produto.Produto;
import model.venda.*;
import model.vendedor.Vendedor;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PesquisasVenda implements Pesquisas<Venda> {

    @Override
    public Venda lerId(Venda vendaApenasComId) {
        String sql = "SELECT * FROM produto WHERE id = ?";
        Venda venda = null;

        try (Connection conn = Conexao.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, vendaApenasComId.getVendaId());
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Id idVenda = new Id(rs.getInt("id"));
                PagamentoData pagamentoData = new PagamentoData(Pagamento.valueOf(rs.getString("formadepagamento")), rs.getDate("data").toLocalDate());
                Quantidade quantidade = new Quantidade(rs.getInt("quantidade"));
                ResponsavelPagamento responsavelPagamento = new ResponsavelPagamento(pagamentoData, carregarVendedor(rs.getInt("idvendedor")));
                ItemVenda itemVenda = new ItemVenda(carregarProduto(rs.getInt("idproduto")), quantidade);
                VendaInfo vendaInfo = new VendaInfo(itemVenda, responsavelPagamento);
                venda = new Venda(idVenda, vendaInfo);
            }

            rs.close();
            return venda;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Venda> listar() {
        String sql = "SELECT * FROM venda";
        ArrayList<Venda> vendas = new ArrayList<>();

        try (Connection conn = Conexao.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Id idVenda = new Id(rs.getInt("id"));
                Quantidade quantidade = new Quantidade(rs.getInt("quantidade"));
                ItemVenda itemVenda = new ItemVenda(carregarProduto(rs.getInt("idproduto")), quantidade);
                PagamentoData pagamentoData = new PagamentoData(Pagamento.valueOf(rs.getString("formadepagamento")), rs.getDate("data").toLocalDate());
                ResponsavelPagamento responsavelPagamento = new ResponsavelPagamento(pagamentoData, carregarVendedor(rs.getInt("idvendedor")));
                VendaInfo vendaInfo = new VendaInfo(itemVenda, responsavelPagamento);
                Venda venda = new Venda(idVenda, vendaInfo);
                vendas.add(venda);
            }

            return vendas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Vendedor carregarVendedor(int id) {
        VendedorDAO vendedorDAO = new VendedorDAO();
        Vendedor vendedor = new Vendedor(new Id(id), null);
        return vendedorDAO.pesquisarId(vendedor);
    }

    private Produto carregarProduto(int id) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Produto produto = new Produto(new Id(id), null);
        return produtoDAO.pesquisarId(produto);
    }

}