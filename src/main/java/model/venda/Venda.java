package model.venda;

import model.Id;
import model.produto.ProdutoId;
import model.vendedor.Vendedor;

import java.time.LocalDate;

public class Venda {
    private Id id;
    private ItemVenda itemVenda;
    private Vendedor vendedor;
    private LocalDate data;
    private Pagamento pagamento;

    public Venda(Id id, ItemVenda itemVenda, Vendedor vendedor, LocalDate data, Pagamento pagamento) {
        if (!(id instanceof VendaId)) {
            System.err.println("Exceção disparada de: Venda");
            throw new IllegalArgumentException("Id inválido: a entidade Venda aceita apenas VendaId");
        }

        this.id = id;
        this.itemVenda = itemVenda;
        setVendedor(vendedor);
        setData(data);
        setPagamento(pagamento);
    }

    public int captureId() {
        return this.id.getId();
    }
    public void changeId(int id) {
        this.id.setId(id);
    }

    public Vendedor getVendedor() {
        return vendedor;
    }
    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }
    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "id=" + id +
                ", itemVenda=" + itemVenda +
                ", vendedor=" + vendedor +
                ", data=" + data +
                ", pagamento=" + pagamento +
                '}';
    }
}