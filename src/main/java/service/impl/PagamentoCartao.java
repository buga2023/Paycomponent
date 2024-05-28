package service.impl;

import service.Notificacao;
import service.Pagamento;

public class PagamentoCartao implements Pagamento {
    private int parcelas;
    private static final double JUROS_MENSAL = 0.02; // 2% ao mês

    public PagamentoCartao(int parcelas) {
        this.parcelas = parcelas;
    }

    @Override
    public boolean processarPagamento(double valor) {
        return false;
    }

    @Override
    public void pagar(double valor, Notificacao notificacao) {
        if (valor <= 0) {
            Logger.error("Valor de pagamento inválido: " + valor);
            notificacao.enviarNotificacao("Falha ao processar pagamento: valor inválido.");
            return;
        }
        if (parcelas <= 0) {
            Logger.error("Número de parcelas inválido: " + parcelas);
            notificacao.enviarNotificacao("Falha ao processar pagamento: número de parcelas inválido.");
            return;
        }

        double valorTotal = valor;
        if (parcelas > 5) {
            valorTotal = calcularValorComJuros(valor, parcelas);
            Logger.log("Valor original: R$ " + valor + ", valor com juros: R$ " + valorTotal);
        }

        double valorParcela = valorTotal / parcelas;
        Logger.log("Processando pagamento de R$ " + valorTotal + " em " + parcelas + " parcelas de R$ " + valorParcela + " cada.");

        boolean pagamentoBemSucedido = simularProcessamentoPagamento();

        if (pagamentoBemSucedido) {
            Logger.log("Pagamento com cartão no valor de R$ " + valorTotal + " processado com sucesso.");
            notificacao.enviarNotificacao("Pagamento de R$ " + valorTotal + " processado com sucesso via cartão em " + parcelas + " parcelas.");
        } else {
            Logger.error("Falha ao processar o pagamento com cartão no valor de R$ " + valorTotal);
            notificacao.enviarNotificacao("Falha ao processar pagamento de R$ " + valorTotal + " via cartão.");
        }
    }

    private double calcularValorComJuros(double valor, int parcelas) {
        double valorComJuros = valor * Math.pow(1 + JUROS_MENSAL, parcelas - 5);
        return valorComJuros;
    }

    private boolean simularProcessamentoPagamento() {
        double randomValue = Math.random();
        return randomValue > 0.1;
    }
}

