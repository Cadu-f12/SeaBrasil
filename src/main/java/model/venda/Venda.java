package model.venda;

import model.Id;
import model.produto.ProdutoId;
import model.vendedor.Vendedor;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Venda {
    private final Id id;
    private final ItemVenda itemVenda;
    private final PagamentoResponsavel pagResponsavel;

    public Venda(Id id, ItemVenda itemVenda, PagamentoResponsavel pagResponsavel) {
        if (!(id instanceof VendaId)) {
            System.err.println("Exceção disparada de: Venda");
            throw new IllegalArgumentException("Id inválido: a entidade Venda aceita apenas VendaId");
        }

        this.id = id;
        this.itemVenda = itemVenda;
        this.pagResponsavel = pagResponsavel;
    }

    public int captureId() {
        return this.id.getId();
    }

    /* Dados do ItemVenda */
    public int captureIdProduto() {
        return this.itemVenda.captureProdutoId();
    }
    public BigDecimal captureItemVendaQuantidade() {
        return this.itemVenda.captureQuantidade();
    }
    public BigDecimal captureItemVendaTotal() {
        return this.itemVenda.captureTotal();
    }

    /* Dados do PagamentoResponsavel */
    public int captureIdVendedor() {
        return this.pagResponsavel.captureVendedorId();
    }
    public Pagamento capturePgResponsavelPagamento() {
        return this.pagResponsavel.capturePagamento();
    }
    public LocalDate captureDataVenda() {
        return this.pagResponsavel.captureData();
    }

    @Override
    public String toString() {
        return "Venda{" +
                "id=" + id +
                ", itemVenda=" + itemVenda +
                ", pagResponsavel=" + pagResponsavel +
                '}';
    }
}