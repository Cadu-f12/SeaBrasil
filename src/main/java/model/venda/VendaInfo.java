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

    int captureProdutoId() {
        return this.itemVenda.captureProdutoId();
    }
    BigDecimal captureQuantidade() {
        return this.itemVenda.captureQuantidade();
    }
    BigDecimal captureValorTotal() {
        return this.itemVenda.captureTotal();
    }

    int captureVendedorId() {
        return this.responsavelPagamento.captureVendedorId();
    }
    String capturePagamento() {
        return this.responsavelPagamento.capturePagamento();
    }
    LocalDate captureData() {
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