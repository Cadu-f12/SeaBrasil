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

    int getVendedorId() {
        return this.vendedor.getVendedorId();
    }

    String getPagamento() {
        return this.pagamentoData.getPagamento();
    }
    LocalDate getData() {
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