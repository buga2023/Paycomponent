package service.impl;

import service.Notificacao;
import service.Pagamento;

public class PagamentoParcelado implements Pagamento {
    private int parcelas;

    public PagamentoParcelado(int parcelas) {
        this.parcelas = parcelas;
    }

    @Override
    public boolean processarPagamento(double valor) {
        if (valor <= 0) {
            Logger.error("Valor de pagamento inválido: " + valor);
            return false;
        }
        if (parcelas <= 0) {
            Logger.error("Número de parcelas inválido: " + parcelas);
            return false;
        }

        double valorParcela = valor / parcelas;
        Logger.log("Processando pagamento parcelado em " + parcelas + "x de R$ " + valorParcela);

        // Lógica para processar o pagamento parcelado
        boolean pagamentoBemSucedido = simularProcessamentoPagamento();

        if (pagamentoBemSucedido) {
            Logger.log("Pagamento parcelado no valor de " + valor + " em " + parcelas + "x processado com sucesso.");
            System.out.println("Processando pagamento parcelado no valor de: " + valor);
            return true;
        } else {
            Logger.error("Falha ao processar o pagamento parcelado no valor de " + valor);
            return false;
        }
    }

    @Override
    public void pagar(double valor, Notificacao notificacao) {

    }

    private boolean simularProcessamentoPagamento() {
        // Simulação de uma possível falha no processamento do pagamento
        // Retorna true se o pagamento for bem-sucedido, false se falhar
        double randomValue = Math.random();
        return randomValue > 0.1; // 90% de chance de sucesso
    }
}

