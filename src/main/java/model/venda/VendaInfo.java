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

    public int captureProdutoId() {
        return this.itemVenda.captureProdutoId();
    }
    public BigDecimal captureQuantidade() {
        return this.itemVenda.captureQuantidade();
    }
    public BigDecimal captureValorTotal() {
        return this.itemVenda.captureTotal();
    }

    public int captureVendedorId() {
        return this.responsavelPagamento.captureVendedorId();
    }
    public String capturePagamento() {
        return this.responsavelPagamento.capturePagamento();
    }
    public LocalDate captureData() {
        return this.responsavelPagamento.captureData();
    }

    @Override
    public String toString() {
        return "VendaInfo{" +
                "itemVenda=" + itemVenda +
                ", responsavelPagamento=" + responsavelPagamento +
                '}';
    }
}