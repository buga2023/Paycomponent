package service.impl;

import service.Notificacao;
import service.Pagamento;

public class PagamentoPIX implements Pagamento {
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

        // Simulação de processamento de pagamento via PIX
        boolean pagamentoBemSucedido = simularProcessamentoPagamento();

        if (pagamentoBemSucedido) {
            Logger.log("Pagamento via PIX no valor de " + valor + " processado com sucesso.");
            notificacao.enviarNotificacao("Pagamento de R$ " + valor + " processado com sucesso via PIX.");
        } else {
            Logger.error("Falha ao processar o pagamento via PIX no valor de " + valor);
            notificacao.enviarNotificacao("Falha ao processar pagamento de R$ " + valor + " via PIX.");
        }
    }

    private boolean simularProcessamentoPagamento() {
        // Simulação de uma possível falha no processamento do pagamento
        // Retorna true se o pagamento for bem-sucedido, false se falhar
        double randomValue = Math.random();
        return randomValue > 0.1; // 90% de chance de sucesso
    }
}

