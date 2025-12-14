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

    public int getVendaId() {
        return this.id.getId();
    }

    public int getProdutoId() {
        return this.vendaInfo.getProdutoId();
    }
    public BigDecimal getQuantidade() {
        return this.vendaInfo.getQuantidade();
    }
    public BigDecimal getValorTotal() {
        return this.vendaInfo.getValorTotal();
    }

    public int getVendedorId() {
        return this.vendaInfo.getVendedorId();
    }
    public String getPagamento() {
        return this.vendaInfo.getPagamento();
    }
    public String getData() {
        return this.vendaInfo.getData();
    }

    @Override
    public String toString() {
        return "Venda{" +
                "id=" + id +
                ", vendaInfo=" + vendaInfo +
                '}';
    }
}