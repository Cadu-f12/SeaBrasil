package model.venda;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PagamentoData {
    private Pagamento formaDePagamento;
    private LocalDate data;

    public PagamentoData(Pagamento formaDePagamento, LocalDate data) {
        setFormaDePagamento(formaDePagamento);
        setDataDaVenda(data);
    }
    public PagamentoData(Pagamento formaDePagamento) {
        setFormaDePagamento(formaDePagamento);
        setDataDaVenda();
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

    String getData() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return data.format(dtf);
    }
    private void setDataDaVenda() {
        this.data = LocalDate.now();
    }
    private void setDataDaVenda(LocalDate data) {
        if (data == null) {
            System.err.println("Exceção disparada de: PagamentoData.setDataDaVenda");
            throw new IllegalArgumentException("Data da venda inválida: valor nulo");
        }

        this.data = data;
    }

    @Override
    public String toString() {
        return "PagamentoData{" +
                "formaDePagamento=" + formaDePagamento +
                ", data=" + data +
                '}';
    }
}
