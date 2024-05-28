package service.impl;

import service.Pagamento;

public class PagamentoPIX implements Pagamento {
    public boolean processarPagamento(double valor) {
        System.out.println("Processando pagamento com PIX no valor de: " + valor);
        // Lógica para processar o pagamento com PIX
        return true; // Retornar true se o pagamento com PIX foi bem-sucedido
    }
}
