package model.venda;

import model.vendedor.Vendedor;

import java.time.LocalDate;

public class Venda {
    private int id;
    private ItemVenda itemVenda;
    private Vendedor vendedor;
    private LocalDate data;
    private Pagamento pagamento;

    public Venda(int id, ItemVenda itemVenda, Vendedor vendedor, LocalDate data, Pagamento pagamento) {
        setId(id);
        setItemVenda(itemVenda);
        setVendedor(vendedor);
        setData(data);
        setPagamento(pagamento);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public ItemVenda getItemVenda() {
        return itemVenda;
    }
    public void setItemVenda(ItemVenda itemVenda) {
        this.itemVenda = itemVenda;
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