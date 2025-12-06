package model.venda;

import model.vendedor.Vendedor;

import java.time.LocalDate;

public class PagamentoResponsavel {
    private final PagamentoData pagamentoData;
    private final Vendedor vendedor;

    public PagamentoResponsavel(PagamentoData pagamentoData, Vendedor vendedor) {
        this.pagamentoData = pagamentoData;
        this.vendedor = vendedor;
    }

    public int captureVendedorId() {
        return this.vendedor.getIdVendedor();
    }

    public Pagamento capturePagamento() {
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