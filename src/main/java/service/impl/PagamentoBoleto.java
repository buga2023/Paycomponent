package service.impl;

import service.PagamentoTaxa;

public class PagamentoBoleto implements PagamentoTaxa {
    private static final double TAXA_BOLETO = 0.10;

    @Override
    public boolean processarPagamento(double valor) {
        double valorComTaxa = valor + calcularTaxa(valor);
        System.out.println("Valor total com taxa de boleto: " + valorComTaxa);
        System.out.println("Processando pagamento com boleto no valor de: " + valor);
        // Lógica para processar o pagamento com boleto
        return true; // Retornar true se o pagamento com boleto foi bem-sucedido
    }

    @Override
    public double calcularTaxa(double valor) {
        return valor * TAXA_BOLETO;
    }
}

