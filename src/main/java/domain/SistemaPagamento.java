package domain;

import service.Notificacao;
import service.Pagamento;
import service.PagamentoParcelado;

import java.util.ArrayList;
import java.util.List;

public class SistemaPagamento {
    private List<Double> registrosPagamentos = new ArrayList<>();
    private Pagamento pagamento;

    public SistemaPagamento(Pagamento pagamento, Notificacao notificacao) {
        this.pagamento = pagamento;
    }

    public boolean processarPagamento(double valor) {
        boolean pagamentoBemSucedido = pagamento.processarPagamento(valor);
        if (pagamentoBemSucedido) {
            registrosPagamentos.add(valor);
        }
        return pagamentoBemSucedido;
    }

    public boolean processarPagamentoParcelado(double valor, int parcelas) {
        if (pagamento instanceof PagamentoParcelado) {
            PagamentoParcelado pagamentoParcelado = (PagamentoParcelado) pagamento;
            boolean pagamentoBemSucedido = pagamentoParcelado.processarPagamentoParcelado(valor, parcelas);
            if (pagamentoBemSucedido) {
                registrosPagamentos.add(valor);
            }
            return pagamentoBemSucedido;
        } else {
            System.out.println("Este método de pagamento não suporta parcelamento.");
            return false;
        }
    }

    public List<Double> getRegistrosPagamentos() {
        return registrosPagamentos;
    }
}
