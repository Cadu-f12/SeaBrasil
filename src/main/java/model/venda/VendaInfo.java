package model.venda;

import java.math.BigDecimal;
import java.time.LocalDate;

public class VendaInfo {
    private final ItemVenda itemVenda;
    private final ResponsavelPagamento responsavelPagamento;

    public VendaInfo(ItemVenda itemVenda, ResponsavelPagamento responsavelPagamento) {
        this.itemVenda = itemVenda;
        this.responsavelPagamento = responsavelPagamento;
    }

    int getProdutoId() {
        return this.itemVenda.getProdutoId();
    }
    int getQuantidade() {
        return this.itemVenda.getQuantidade();
    }
    BigDecimal getValorTotal() {
        return this.itemVenda.getValorTotal();
    }

    int getVendedorId() {
        return this.responsavelPagamento.getVendedorId();
    }
    String getPagamento() {
        return this.responsavelPagamento.getPagamento();
    }
    String getData() {
        return this.responsavelPagamento.getData();
    }

    @Override
    public String toString() {
        return "VendaInfo{" +
                "itemVenda=" + itemVenda +
                ", responsavelPagamento=" + responsavelPagamento +
                '}';
    }
}