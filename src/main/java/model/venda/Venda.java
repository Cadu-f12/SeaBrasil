package model.venda;

import model.Id;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Venda {
    private final Id id;
    private final VendaInfo vendaInfo;

    public Venda(Id id, VendaInfo vendaInfo) {
        this.id = id;
        this.vendaInfo = vendaInfo;
    }

    public int captureVendaId() {
        return this.id.getId();
    }

    public int captureProdutoId() {
        return this.vendaInfo.captureProdutoId();
    }
    public BigDecimal captureQuantidade() {
        return this.vendaInfo.captureQuantidade();
    }
    public BigDecimal captureValorTotal() {
        return this.vendaInfo.captureValorTotal();
    }

    public int captureVendedorId() {
        return this.vendaInfo.captureVendedorId();
    }
    public String capturePagamento() {
        return this.vendaInfo.capturePagamento();
    }
    public LocalDate captureData() {
        return this.vendaInfo.captureData();
    }

    @Override
    public String toString() {
        return "Venda{" +
                "id=" + id +
                ", vendaInfo=" + vendaInfo +
                '}';
    }
}