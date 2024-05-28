package service.impl;

import service.Notificacao;
import service.Pagamento;

public class PagamentoBoleto implements Pagamento {
    private static final double TAXA_BOLETO = 0.10;
    private static final double VALOR_MINIMO = 50.0;

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
        if (valor < VALOR_MINIMO) {
            Logger.error("O valor mínimo para pagamento com boleto é: " + VALOR_MINIMO);
            notificacao.enviarNotificacao("Falha ao processar pagamento: valor abaixo do mínimo permitido.");
            return;
        }

        double valorComTaxa = valor + calcularTaxa(valor);
        Logger.log("Valor total com taxa de boleto: " + valorComTaxa);

        boolean pagamentoBemSucedido = simularProcessamentoPagamento();

        if (pagamentoBemSucedido) {
            Logger.log("Pagamento com boleto no valor de " + valor + " processado com sucesso.");
            notificacao.enviarNotificacao("Pagamento de R$ " + valor + " processado com sucesso via boleto.");
        } else {
            Logger.error("Falha ao processar o pagamento com boleto no valor de " + valor);
            notificacao.enviarNotificacao("Falha ao processar pagamento de R$ " + valor + " via boleto.");
        }
    }

    private double calcularTaxa(double valor) {
        return valor * TAXA_BOLETO;
    }

    private boolean simularProcessamentoPagamento() {
        double randomValue = Math.random();
        return randomValue > 0.1;
    }
}
