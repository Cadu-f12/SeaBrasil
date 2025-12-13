package model.venda;

import java.time.LocalDate;

public class PagamentoData {
    private Pagamento formaDePagamento;
    private LocalDate data;

    public PagamentoData(Pagamento formaDePagamento) {
        setFormaDePagamento(formaDePagamento);
        dataDaVenda();
    }

    String getPagamento() {
        return formaDePagamento.name();
    }
    private void setFormaDePagamento(Pagamento formaDePagamento) {
        if (formaDePagamento == null) {
            throw new IllegalArgumentException("Forma de pagamento inválida: valor nulo");
        }

        this.formaDePagamento = formaDePagamento;
    }

    LocalDate getData() {
        return data;
    }
    private void dataDaVenda() {
        this.data = LocalDate.now();
    }

    @Override
    public String toString() {
        return "PagamentoData{" +
                "formaDePagamento=" + formaDePagamento +
                ", data=" + data +
                '}';
    }
}
