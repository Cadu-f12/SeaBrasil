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
        this.id = id;
        this.itemVenda = itemVenda;
        this.vendedor = vendedor;
        this.data = data;
        this.pagamento = pagamento;
    }

    public int getId() {
        return id;
    }

    public ItemVenda getItemVenda() {
        return itemVenda;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public LocalDate getData() {
        return data;
    }

    public Pagamento getPagamento() {
        return pagamento;
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