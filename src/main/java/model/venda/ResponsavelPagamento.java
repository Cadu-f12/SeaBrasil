package model.venda;

import model.vendedor.Vendedor;

import java.time.LocalDate;

public class ResponsavelPagamento {
    private final PagamentoData pagamentoData;
    private final Vendedor vendedor;

    public ResponsavelPagamento(PagamentoData pagamentoData, Vendedor vendedor) {
        this.pagamentoData = pagamentoData;
        this.vendedor = vendedor;
    }

    public int captureVendedorId() {
        return this.vendedor.captureVendedorId();
    }

    public String capturePagamento() {
        return this.pagamentoData.getFormaDePagamento();
    }

    public LocalDate captureData() {
        return this.pagamentoData.getData();
    }

    @Override
    public String toString() {
        return "PagamentoResponsavel{" +
                "pagamentoData=" + pagamentoData +
                ", vendedor=" + vendedor +
                '}';
    }
}